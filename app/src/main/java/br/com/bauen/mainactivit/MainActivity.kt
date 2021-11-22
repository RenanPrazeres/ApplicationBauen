package br.com.bauen.mainactivit

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        val buttonSendMsg = findViewById<ImageButton>(R.id.button_send_msg)
        val editTextChat= findViewById<EditText>(R.id.editTextChat)

        buttonSendMsg.setOnClickListener {
            val sendMsg = Intent(this, ChatActivityLog::class.java)
            startActivity(sendMsg)
        }
    }
}