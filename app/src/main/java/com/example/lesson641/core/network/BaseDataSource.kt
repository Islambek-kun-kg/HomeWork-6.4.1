package com.example.lesson641.core.network

import com.example.lesson641.core.network.result.Resource
import retrofit2.Response

abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        return try {
            val response = call()
            if (response.isSuccessful && response.body() != null) Resource.success(response.body())
            else Resource.error(response.message(), response.body(), response.code())
        } catch (e: Exception) {
            Resource.error(e.message ?: e.toString(), null, 429)
        }
    }
}