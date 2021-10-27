package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.bauen.mainactivit.login.Cliente
import com.google.gson.Gson

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

        val dataDeNascimento = findViewById<EditText>(R.id.et_datadenascimento)
        val cpfEditText = findViewById<EditText>(R.id.et_cpf)
        val rgEditText = findViewById<EditText>(R.id.et_rg)
        val senhaEditText = findViewById<EditText>(R.id.et_senha)
        val bntCadastro = findViewById<Button>(R.id.button_cadastro)

        bntCadastro.setOnClickListener {
            //Criar um objeto Cliente para cadastro 2

            val cliente = Cliente()

            cliente.born = dataDeNascimento.text.toString()
            cliente.cpf = cpfEditText.text.toString()
            cliente.rg = rgEditText.text.toString()
            cliente.password = senhaEditText.text.toString()


            val gson = Gson()
            val clienteJson = gson.toJson(cliente)

            println("*******" + clienteJson)

            //Abrir Tela de Cadastro2
            val perfilPrestador = Intent (this, PerfilPrestadorActivity::class.java)
            startActivity(perfilPrestador)
        }
    }
}