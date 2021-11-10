package br.com.bauen.mainactivit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.com.bauen.mainactivit.cep.Cep
import br.com.bauen.mainactivit.cep.RetrofitFactory
import br.com.bauen.mainactivit.http.HttpHelper
import br.com.bauen.mainactivit.login.Cliente
import br.com.bauen.mainactivit.login.Endereco
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class CadastroCliente : AppCompatActivity() {

    lateinit var editTextCep: EditText
    lateinit var editTextRua: EditText
    lateinit var editTextEstado: EditText
    lateinit var editTextCidade: EditText
    lateinit var editTextBairro: EditText
    lateinit var numeroCasa: EditText
    lateinit var cpfCliente: EditText
    lateinit var rgCliente: EditText
    lateinit var senhaCliente : EditText
    lateinit var lugarReformadoCliente: EditText

    lateinit var btnContinuarTeste: Button

//    lateinit var llCadastro: LinearLayout

    @SuppressLint("WrongConstant", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        val nomeCompleto = findViewById<EditText>(R.id.et_nomeCliente)
        val emailUtilizado = findViewById<EditText>(R.id.et_emailCliente)
        val numeroCelular = findViewById<EditText>(R.id.et_celularCliente)
        val dataDeNascimento = findViewById<EditText>(R.id.et_datadenascimentoCliente)

        editTextCep = findViewById(R.id.et_cepCliente)
        val cepResidencia = findViewById<EditText>(R.id.et_cepCliente)

        val ruaResidencia = findViewById<EditText>(R.id.et_ruaCliente)
        editTextRua = findViewById(R.id.et_ruaCliente)

        val estadoResidencia = findViewById<EditText>(R.id.et_estadoCliente)
        editTextEstado = findViewById(R.id.et_estadoCliente)

        val cidadeResidencia = findViewById<EditText>(R.id.et_cidadeCliente)
        editTextCidade = findViewById(R.id.et_cidadeCliente)

        val bairroResidencia = findViewById<EditText>(R.id.et_bairroCliente)
        editTextBairro = findViewById(R.id.et_bairroCliente)

        val numeroResidencia= findViewById<EditText>(R.id.et_numeroCliente)
        numeroCasa = findViewById(R.id.et_numeroCliente)

        val cpfEditText = findViewById<EditText>(R.id.et_cpfCliente)
        cpfCliente = findViewById(R.id.et_cpfCliente)

        val rgEditText = findViewById<EditText>(R.id.et_rgCliente)
        rgCliente = findViewById(R.id.et_rgCliente)

        val senhaEditText = findViewById<EditText>(R.id.et_senhaCliente)
        senhaCliente = findViewById(R.id.et_senhaCliente)

        val bntContinuar = findViewById<Button>(R.id.button_cadastrarCliente)
        btnContinuarTeste = findViewById(R.id.button_cadastrarCliente)

        lugarReformadoCliente = findViewById(R.id.et_roomCliente)
        val lugarAReformmarCliente = findViewById<EditText>(R.id.et_roomCliente)



        bntContinuar.setOnClickListener {
            //Criar um objeto Cliente
            val cliente = Cliente()
            cliente.name = nomeCompleto.text.toString()
            cliente.email = emailUtilizado.text.toString()
            cliente.phone = numeroCelular.text.toString()
            cliente.born = dataDeNascimento.text.toString()

            cliente.cpf = cpfEditText.text.toString()
            cliente.rg = rgEditText.text.toString()
            cliente.room = lugarAReformmarCliente.text.toString()
            cliente.password = senhaEditText.text.toString()

            val endereco = Endereco()
            endereco.zipcode = cepResidencia.text.toString()
            endereco.street = ruaResidencia.text.toString()
            endereco.state = estadoResidencia.text.toString()
            endereco.city = cidadeResidencia.text.toString()
            endereco.neighborhood = bairroResidencia.text.toString()
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

            //Formatação de aniversário
//            var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//            var date = LocalDate.parse("$dataDeNascimento", "$formatter")




//            var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//            var dater = LocalDate.parse("$dataDeNascimento", formatter)

            finish()

        }


//        val localDate: LocalDate = LocalDate.now()
//        val strLocalDate2: String =
//            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))



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
                Toast.makeText(this, "ROOM CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                lugarReformadoCliente.isVisible = true
            }
        }

        rgCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "SENHA CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                senhaCliente.isVisible = true
            }
        }

        lugarReformadoCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                Toast.makeText(this, "BOTÃO ABERTO", Toast.LENGTH_LONG).show()
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


//    fun convertDate(){
//        val mydate = "10/05/2003"
//        val targetFormat = SimpleDateFormat("yyyy MM dd")
//        date = originalFormat.parse(mydate)
//    }
}