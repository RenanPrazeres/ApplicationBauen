package br.com.bauen.mainactivit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ChatActivityLog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        supportActionBar!!.hide()

    }
}