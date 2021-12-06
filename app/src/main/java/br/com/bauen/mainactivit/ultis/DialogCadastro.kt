package br.com.bauen.mainactivit.ultis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.bauen.mainactivit.CadastroCliente
import br.com.bauen.mainactivit.CadastroPrestadorDeServico
import br.com.bauen.mainactivit.R

class DialogCadastro : AppCompatActivity() {

    lateinit var bntCadastroPrestador: Button
    lateinit var bntCadastroCliente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_cadastro)

//        bntCadastroCliente = findViewById(R.id.bnt_contratar_prestador_dialog_cadastro)
//        bntCadastroPrestador = findViewById(R.id.bnt_ser_prestador_dialog_cadastro)
//
//        bntCadastroCliente.setOnClickListener {
//            val abrirCadastroCliente = Intent (this, CadastroCliente::class.java)
//            startActivity(abrirCadastroCliente)
//        }
//
//        bntCadastroPrestador.setOnClickListener {
//            val abrirCadastroPrestador = Intent (this, CadastroPrestadorDeServico::class.java)
//            startActivity(abrirCadastroPrestador)
//        }


    }
}