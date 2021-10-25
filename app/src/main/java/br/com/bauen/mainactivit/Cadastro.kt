package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.bauen.mainactivit.cep.Cep
import br.com.bauen.mainactivit.cep.RetrofitFactory
import br.com.bauen.mainactivit.cliente.Cliente
import com.google.gson.Gson
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
        val complementoResidencia= findViewById<EditText>(R.id.et_complemento)
        val bntContinuar = findViewById<Button>(R.id.button_continuar)

        bntContinuar.setOnClickListener {
            //Criar um objeto Cliente
            val cliente = Cliente()
            cliente.nome = nomeCompleto.text.toString()
            cliente.email = emailUtilizado.text.toString()
            cliente.celular = numeroCelular.text.toString()
            cliente.cep = cepResidencia.text.toString()
            cliente.rua = ruaResidencia.text.toString()
            cliente.estado = estadoResidencia.text.toString()
            cliente.cidade = cidadeResidencia.text.toString()
            cliente.bairro = bairroResidencia.text.toString()
            cliente.numeroResidencia = numeroResidencia.text.toString()
            cliente.complemento = complementoResidencia.text.toString()

            //Converter o cliente em json
            val gson = Gson()
            val clienteJson = gson.toJson(cliente)


            println("############" + clienteJson)

            //Abrir Tela de Cadastro2
            val abrirCadastro2 = Intent (this, Cadastro2::class.java)
            startActivity(abrirCadastro2 )
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