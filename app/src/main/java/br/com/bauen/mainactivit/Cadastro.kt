package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
        val bntContinuar = findViewById<Button>(R.id.button_continuar)

        bntContinuar.setOnClickListener {
            //Criar um objeto Cliente
            val cliente = Cliente()
            cliente.name = nomeCompleto.text.toString()
            cliente.email = emailUtilizado.text.toString()
            cliente.phone = numeroCelular.text.toString()

            val endereco = Endereco()
            endereco.zipcode = cepResidencia.text.toString()
            endereco.street = ruaResidencia.text.toString()
            endereco.state = estadoResidencia.text.toString()
            endereco.city = cidadeResidencia.text.toString()
            endereco.zipcode = bairroResidencia.text.toString()
            endereco.number = numeroResidencia.text.toString()


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



            //Declarando o tipo do conteúdo a ser transferido
            val nomeCliente: String = nomeCompleto.text.toString()
            val emailCliente: String = emailUtilizado.text.toString()
            val phoneCliente: Double = numeroCelular.text.toString().toDouble()

            val cepCliente: Double = cepResidencia.text.toString().toDouble()
            val numeroResidenciaCliente: Double = numeroResidencia.text.toString().toDouble()
            val ruaCliente: String = ruaResidencia.text.toString()
            val estadoCliente: String = estadoResidencia.text.toString()
            val cidadeCliente: String = cidadeResidencia.text.toString()
            val bairroCliente: String = bairroResidencia.text.toString()

            //Passar dados para outra activity
            val detalhesCliente = Intent(this, Cadastro2::class.java)
            detalhesCliente.putExtra("name", nomeCliente)
            detalhesCliente.putExtra("email", emailCliente)
            detalhesCliente.putExtra("phone", phoneCliente)


//            detalhesCliente.putExtra("cep", cepCliente)
//            detalhesCliente.putExtra("rua", ruaCliente)
//            detalhesCliente.putExtra("estado", estadoCliente)
//            detalhesCliente.putExtra("cidade", cidadeCliente)
//            detalhesCliente.putExtra("bairro", bairroCliente)
//            detalhesCliente.putExtra("number", numeroResidenciaCliente)

            startActivity(detalhesCliente)


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

