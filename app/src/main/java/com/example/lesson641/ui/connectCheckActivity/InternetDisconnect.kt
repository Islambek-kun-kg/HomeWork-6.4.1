package com.example.lesson641.ui.connectCheckActivity

import com.example.lesson641.R
import com.example.lesson641.core.base.BaseActivity
import com.example.lesson641.utils.connectionCheck.ConnectChecker
import kotlinx.android.synthetic.main.internet_disconnect.*

class InternetDisconnect : BaseActivity(R.layout.internet_disconnect) {

    override fun setupUI() =
        btn_Reconnect.setOnClickListener { ConnectChecker.checkForConnection() }


    override fun setupLiveData() {}

    override fun showDisconnectState() {}

}