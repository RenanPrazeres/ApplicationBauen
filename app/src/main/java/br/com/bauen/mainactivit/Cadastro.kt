package br.com.bauen.mainactivit

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
    lateinit var dataDeNascimento: EditText
    lateinit var cpf: EditText
    lateinit var rg: EditText
    lateinit var senha: EditText
    lateinit var confirmacaoSenha: EditText
    lateinit var bntCadastro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)






    }
}