package br.com.bauen.mainactivit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Cadastro2 : AppCompatActivity() {

    lateinit var dataDeNascimento: EditText
    lateinit var cpf: EditText
    lateinit var rg: EditText
    lateinit var senha: EditText
    lateinit var confirmacaoSenha: EditText
    lateinit var bntCadastro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro2)
    }
}