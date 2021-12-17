package br.com.bauen.mainactivit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager

class PerfilPrestadorActivity : AppCompatActivity() {
    lateinit var btncontato: Button
    lateinit var img_add: ImageView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil_prestador)

        img_add = findViewById(R.id.btn_add)
        imageView = findViewById(R.id.imagem_test)
        btncontato = findViewById(R.id.btn_contato)

        img_add.setOnClickListener {
//            pickImageGallery()
        }


        //BOTAO PARA ENTRAR EM CONTATO, DIRECIONANDO PARA TELA DE CHAT
        btncontato.setOnClickListener {
            val chat = Intent(this, ChatActivity::class.java)
            startActivity(chat)

        }
    }


    companion object {
        val IMAGE_REQUEST_CODE = 100
    }
}


//val data :MutableList<DataObjetc> = ArrayList()
//       for (i :int in 1..10)
//            data.add(DataObjetc("Title $i"))
//
//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


//        rb_ratingBar.rating = 2.5f
//        rb_ratingBar = stepSize = .5f
//
//        rb_rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
//            Toast.makeText( this, "Rating: $rating", Toast.LENGTH_SHORT).show()
//
//        }


//    lateinit var btncontato: Button
//    private lateinit var btn_add: Button
//    private lateinit var imageView: ImageView
//
//    companion object {
//        val IMAGE_REQUEST_CODE = 100
//    }