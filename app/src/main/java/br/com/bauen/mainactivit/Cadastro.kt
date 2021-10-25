package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Cadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val nomeCompleto = findViewById<EditText>(R.id.et_nome)
        val emailUtilizado = findViewById<EditText>(R.id.et_email)
        val numeroCelular = findViewById<EditText>(R.id.et_celular)
        val cepResidencia = findViewById<EditText>(R.id.et_cep)
        val ruaResidencia = findViewById<EditText>(R.id.et_rua)
        val estadoResidencia = findViewById<EditText>(R.id.et_estado)
        val cidadeResidencia = findViewById<EditText>(R.id.et_cidade)
        val bairroResidencia = findViewById<EditText>(R.id.et_bairro)
        val numeroResidencia= findViewById<EditText>(R.id.et_numero)
        val complementoResidencia= findViewById<EditText>(R.id.et_complemento)
        val bntContinuar = findViewById<Button>(R.id.button_continuar)

        bntContinuar.setOnClickListener {
            //Criar um objeto Prestador
            val prestadorDeServico = Cadastro()
            //prestadorDeServico.et_ = nomeCompleto.text.toString()


            val abrirCadastro2 = Intent (this, Cadastro2::class.java)
            startActivity(abrirCadastro2 )
        }




    }
}