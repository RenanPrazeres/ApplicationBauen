package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class PerfilPrestadorActivity : AppCompatActivity() {

    lateinit var btncontato : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil_prestador)

        btncontato = findViewById(R.id.btn_contato)


        //BOTAO PARA ENTRAR EM CONTATO, DIRECIONANDO PARA TELA DE CHAT
        btncontato.setOnClickListener {
            val chat = Intent(this, ChatActivity::class.java)
            startActivity(chat)

        }

    }
}


//        rb_ratingBar.rating = 2.5f
//        rb_ratingBar = stepSize = .5f
//
//        rb_rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
//            Toast.makeText( this, "Rating: $rating", Toast.LENGTH_SHORT).show()

//        }
