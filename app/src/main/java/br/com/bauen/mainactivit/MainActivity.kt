package br.com.bauen.mainactivit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SocketHandler.setSocket()

        val mSocket=SocketHandler.getSocket()

        mSocket.connect()
    }
}