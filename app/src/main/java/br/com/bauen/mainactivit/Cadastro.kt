package br.com.bauen.mainactivit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import br.com.bauen.mainactivit.cep.Cep
import br.com.bauen.mainactivit.cep.RetrofitFactory
import br.com.bauen.mainactivit.http.HttpHelper
import br.com.bauen.mainactivit.login.Cliente
import br.com.bauen.mainactivit.login.Endereco
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import retrofit2.Callback
import retrofit2.Response


class Cadastro : AppCompatActivity() {


    lateinit var editTextCep: EditText
    lateinit var editTextRua: EditText
    lateinit var editTextEstado: EditText
    lateinit var editTextCidade: EditText
    lateinit var editTextBairro: EditText
    lateinit var numeroCasa: EditText
    lateinit var cpfCliente: EditText
    lateinit var rgCliente: EditText
    lateinit var senhaCliente : EditText

    lateinit var btnContinuarTeste: Button

//    lateinit var llCadastro: LinearLayout

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val nomeCompleto = findViewById<EditText>(R.id.et_nome)
        val emailUtilizado = findViewById<EditText>(R.id.et_email)
        val numeroCelular = findViewById<EditText>(R.id.et_celular)

        editTextCep = findViewById(R.id.et_cep)
        val cepResidencia = findViewById<EditText>(R.id.et_cep)

        val ruaResidencia = findViewById<EditText>(R.id.et_rua)
        editTextRua = findViewById(R.id.et_rua)

        val estadoResidencia = findViewById<EditText>(R.id.et_estado)
        editTextEstado = findViewById(R.id.et_estado)

        val cidadeResidencia = findViewById<EditText>(R.id.et_cidade)
        editTextCidade = findViewById(R.id.et_cidade)

        val bairroResidencia = findViewById<EditText>(R.id.et_bairro)
        editTextBairro = findViewById(R.id.et_bairro)

        val numeroResidencia= findViewById<EditText>(R.id.et_numero)
        numeroCasa = findViewById(R.id.et_numero)

        val dataDeNascimento = findViewById<EditText>(R.id.et_datadenascimento)

        val cpfEditText = findViewById<EditText>(R.id.et_cpf)
        cpfCliente = findViewById(R.id.et_cpf)

        val rgEditText = findViewById<EditText>(R.id.et_rg)
        rgCliente = findViewById(R.id.et_rg)

        val senhaEditText = findViewById<EditText>(R.id.et_senha)
        senhaCliente = findViewById<EditText>(R.id.et_senha)

        val bntContinuar = findViewById<Button>(R.id.button_continuar)
        btnContinuarTeste = findViewById(R.id.button_continuar)


        bntContinuar.setOnClickListener {
            //Criar um objeto Cliente
            val cliente = Cliente()
            cliente.name = nomeCompleto.text.toString()
            cliente.email = emailUtilizado.text.toString()
            cliente.phone = numeroCelular.text.toString()
            cliente.born = dataDeNascimento.text.toString()

            cliente.cpf = cpfEditText.text.toString()
            cliente.rg = rgEditText.text.toString()
            cliente.password = senhaEditText.text.toString()

            val endereco = Endereco()
            endereco.zipcode = cepResidencia.text.toString()
            endereco.street = ruaResidencia.text.toString()
            endereco.state = estadoResidencia.text.toString()
            endereco.city = cidadeResidencia.text.toString()
            endereco.neighborhood = bairroResidencia.text.toString()
            endereco.number = numeroResidencia.text.toString()

            btnContinuarTeste = findViewById(R.id.button_continuar)



            //Converter o cliente em json
            val gson = Gson()
            val clienteJson = gson.toJson(cliente)

            println("############" + clienteJson)

            //Converte o endereço em json
            val gsonEndereco = Gson()
            val enderecoJson = gsonEndereco.toJson(endereco)

            println("///////////" + enderecoJson)

            doAsync{
                val http = HttpHelper()
                http.post(clienteJson)

                val http2 = HttpHelper()
                http2.post(enderecoJson)
            }


            //Passar dados para outra activity
            val detalhesCliente = Intent(this, Cadastro2::class.java)
            startActivity(detalhesCliente)
            finish()

        }



        editTextBairro.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "DATA DE NASCIMENTO ABERTA", Toast.LENGTH_LONG).show()
                dataDeNascimento.isVisible = true
            }
        }

        numeroCasa.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "CPF CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                cpfCliente.isVisible = true
            }
        }

        dataDeNascimento.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "RG CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                rgCliente.isVisible = true
            }
        }

        cpfCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "SENHA CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                senhaCliente.isVisible = true
            }
        }

        rgCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "SENHA CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                btnContinuarTeste.isVisible = true
            }
        }

        cepResidencia.setOnFocusChangeListener { v, hasFocus ->

            val cep = cepResidencia.text

            if (!hasFocus && cep.length == 8){
                searchByCEP()
                 cepResidencia.error = null
            }

            if (!hasFocus && cep.length < 8) {
                cepResidencia.error = "CEP inválido"
            }
        }


    }

    private fun searchByCEP() {

        val cep = editTextCep.text


        val remote = RetrofitFactory().retrofitService()
        val call: Call<Cep> = remote.getCEP(cep.toString())

        call.enqueue(object : Callback<Cep> {
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                val cep = response.body()
                if (cep != null) {
                    editTextRua.setText(cep.logradouro)
                    editTextEstado.setText(cep.uf)
                    editTextCidade.setText(cep.cidade)
                    editTextBairro.setText(cep.bairro)
                }
            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                Log.i("cep", t.message.toString())
            }

        })
    }
}

