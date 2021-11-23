package br.com.bauen.mainactivit

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivityLog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        val recyclerView = findViewById(R.id.recyclerview) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val mensagens = ArrayList<Mensagem>()

        mensagens.add(Mensagem("oiiiii"))
        mensagens.add(Mensagem("oiiiii"))
        mensagens.add(Mensagem("oiiiii"))
        mensagens.add(Mensagem("oiiiii"))
        mensagens.add(Mensagem("oiiiii"))
        mensagens.add(Mensagem("oiiiii"))

        val adapter = CustomAdapter(mensagens)

        recyclerView.adapter = adapter

    }
}