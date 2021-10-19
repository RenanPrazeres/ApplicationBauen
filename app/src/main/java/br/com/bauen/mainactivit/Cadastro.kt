package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Cadastro : AppCompatActivity() {

    lateinit var criarConta: TextView
    lateinit var nomeCompleto: EditText
    lateinit var emailUtilizado: EditText
    lateinit var numeroCelular: EditText
    lateinit var cepResidencia: EditText
    lateinit var ruaResidencia: EditText
    lateinit var estadoResidencia: EditText
    lateinit var cidadeResidencia: EditText
    lateinit var bairroResidencia: EditText
    lateinit var numeroResidencia: EditText
    lateinit var complementoResidencia: EditText
    lateinit var bntContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        bntContinuar = findViewById(R.id.button_continuar)

        bntContinuar.setOnClickListener {
            val intent = Intent (this, Cadastro2::class.java)
            startActivity(intent)
        }




    }
}