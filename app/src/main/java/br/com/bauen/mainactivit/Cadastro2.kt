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

        val nomeCompleto = findViewById<EditText>(R.id.et_nome)

        bntCadastro.setOnClickListener {
            //Criar um objeto Cliente para cadastro 2

            val cliente = Cliente()

            cliente.born = dataDeNascimento.text.toString()
            cliente.cpf = cpfEditText.text.toString()
            cliente.rg = rgEditText.text.toString()
            cliente.password = senhaEditText.text.toString()

            cliente.name = getExternalFilesDir("nomeCliente2").toString()

            //Recuperar dados da activity Cadastro
            var dados = intent
//            var nomeCliente2 = dados?.getString("name")
            val emailCliente2 = dados.getStringExtra("email")
            var phoneCliente2 = dados.getDoubleExtra("phone", 0.0)
            val nomeCliente2 =  dados.getStringExtra("name")



//            var cepCliente2 = dados?.getDouble("cep")
//            var ruaCliente2 = dados?.getString("rua")
//            var estadoCliente2 = dados?.getString("estado")
//            var cidadeCliente2 = dados?.getString("cidade")
//            var bairroCliente2 = dados?.getString("bairro")
//            var numberCliente2 = dados?.getDouble("number")

            //Converte o endereço em json
            val gson = Gson()
            val clienteJson = gson.toJson(cliente)

            println("*******" + clienteJson)

            //Abrir Tela de Login volta
            val perfilPrestador = Intent (this, LoginActivity::class.java)
            startActivity(perfilPrestador)
        }
    }
}