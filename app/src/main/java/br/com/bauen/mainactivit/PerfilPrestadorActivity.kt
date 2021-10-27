package br.com.bauen.mainactivit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PerfilPrestadorActivity : AppCompatActivity() {

    lateinit var btncontato: Button
    private lateinit var btn_add: Button
    private lateinit var imageView: ImageView

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil_prestador)


        btn_add = findViewById(R.id.btn_test)
        imageView = findViewById(R.id.imagem_test)
        btncontato = findViewById(R.id.btn_contato)

        btn_add.setOnClickListener {
            pickImageGallery()
        }


        //BOTAO PARA ENTRAR EM CONTATO, DIRECIONANDO PARA TELA DE CHAT
        btncontato.setOnClickListener {
            val chat = Intent(this, ChatActivity::class.java)
            startActivity(chat)

        }
    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            imageView.setImageURI(data?.data)
        }
    }
}


//        rb_ratingBar.rating = 2.5f
//        rb_ratingBar = stepSize = .5f
//
//        rb_rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
//            Toast.makeText( this, "Rating: $rating", Toast.LENGTH_SHORT).show()
//
//        }
