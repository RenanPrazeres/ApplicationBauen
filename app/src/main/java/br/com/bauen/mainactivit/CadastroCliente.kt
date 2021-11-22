package br.com.bauen.mainactivit

import android.annotation.SuppressLint
import android.app.DatePickerDialog
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
import br.com.bauen.mainactivit.tables.Cliente
import br.com.bauen.mainactivit.tables.Endereco
import br.com.bauen.mainactivit.ultis.MaskFormatUtil
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class CadastroCliente : AppCompatActivity() {

    lateinit var editTextCep: EditText
    lateinit var editTextRua: EditText
    lateinit var editTextEstado: EditText
    lateinit var editTextCidade: EditText
    lateinit var editTextBairro: EditText
    lateinit var editDataNascimento: EditText
    lateinit var numeroCasa: EditText
    lateinit var cpfCliente: EditText
    lateinit var rgCliente: EditText
    lateinit var senhaCliente: EditText
    lateinit var numeroParaChatCliente : EditText
    lateinit var nomeCliente: EditText
    lateinit var celularCliente: EditText
    lateinit var emailCliente: EditText
    lateinit var btnCadastrarCliente: Button

//    lateinit var llCadastro: LinearLayout

    @SuppressLint("WrongConstant", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        val nomeCompleto = findViewById<EditText>(R.id.et_nomeCliente)
        nomeCliente = findViewById(R.id.et_nomeCliente)

        val emailUtilizado = findViewById<EditText>(R.id.et_emailCliente)
        emailCliente = findViewById(R.id.et_emailCliente)

        val numeroCelular = findViewById<EditText>(R.id.et_celularCliente)
        celularCliente = findViewById(R.id.et_celularCliente)

        val dataDeNascimento = findViewById<EditText>(R.id.et_datadenascimentoCliente)
        editDataNascimento = findViewById(R.id.et_datadenascimentoCliente)

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

        val numeroResidencia = findViewById<EditText>(R.id.et_numeroCliente)
        numeroCasa = findViewById(R.id.et_numeroCliente)

        val cpfEditText = findViewById<EditText>(R.id.et_cpfCliente)
        cpfCliente = findViewById(R.id.et_cpfCliente)

        val rgEditText = findViewById<EditText>(R.id.et_rgCliente)
        rgCliente = findViewById(R.id.et_rgCliente)

        val senhaEditText = findViewById<EditText>(R.id.et_senhaCliente)
        senhaCliente = findViewById(R.id.et_senhaCliente)

        val bntContinuar = findViewById<Button>(R.id.button_cadastrarCliente)
        btnCadastrarCliente = findViewById(R.id.button_cadastrarCliente)

        numeroParaChatCliente = findViewById(R.id.et_roomCliente)
        val lugarAReformmarCliente = findViewById<EditText>(R.id.et_roomCliente)


//        cepResidencia.addTextChangedListener(
//            MaskFormatUtil.mask(
//                cepResidencia,
//                MaskFormatUtil.FORMAT_CEP
//            )
//        )
//
//        cpfCliente.addTextChangedListener(
//            MaskFormatUtil.mask(
//                cpfCliente,
//                MaskFormatUtil.FORMAT_CPF
//            )
//        )
//
//        rgEditText.addTextChangedListener(
//            MaskFormatUtil.mask(
//                rgEditText,
//                MaskFormatUtil.FORMAT_RG
//            )
//        )

        bntContinuar.setOnClickListener {
            if (validaForm()) {

                //instancia os elementos do objeto endereco
                val zipcode = cepResidencia.text.toString()
                val street = ruaResidencia.text.toString()
                val state = estadoResidencia.text.toString()
                val city = cidadeResidencia.text.toString()
                val neighborhood = bairroResidencia.text.toString()
                val number = numeroResidencia.text.toString()
                //Cria o objeto Endereco
                val enderecoo :Endereco = Endereco(zipcode,street,state,city,neighborhood,number)

                //instancia os elementos do objeto endereco
                val name = nomeCompleto.text.toString()
                val email = emailUtilizado.text.toString()
                val phone = numeroCelular.text.toString()
                val born = dataDeNascimento.text.toString()

                val cpf = cpfEditText.text.toString()
                val rg = rgEditText.text.toString()
                val room = lugarAReformmarCliente.text.toString()
                val password = senhaEditText.text.toString()

                //Cria o objeto endereco
                val cliente: Cliente = Cliente(name, email,phone, born,cpf, rg,password, enderecoo,room)




                //Converter o cliente em json
                val gson = Gson()
                val clienteJson = gson.toJson(cliente)

                println("///////////" + clienteJson)

                //Converte o endereço em json
                val gsonEndereco = Gson()
                val enderecoJson = gsonEndereco.toJson(enderecoo)

                println("///////////" + enderecoJson)

                doAsync {
                    val http = HttpHelper()
                    http.postCliente(clienteJson)
                    http.postCliente(enderecoJson)

//                    val http2 = HttpHelper()
//                    http2.postCliente(enderecoJson)
                }

                finish()
            }
        }

        // Criar o calendário
        val calendario = Calendar.getInstance()
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        editDataNascimento.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->

                    var diaFinal = _dia
                    var mesFinal = _mes + 1

                    var mesString = "$mesFinal"
                    var diaString = "$diaFinal"

                    if (mesFinal < 10) {
                        mesString = "0$mesFinal"
                    }

                    if (diaFinal < 10) {
                        diaString = "0$diaFinal"
                    }

                    Log.i("xpto", _dia.toString())
                    Log.i("xpto", _mes.toString())

                    editDataNascimento.setText("$_ano/$mesString/$diaString")
                }, ano, mes, dia
            )
            dpd.show()
        }

        numeroCasa.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "CPF CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                cpfCliente.isVisible = true
            }
        }


        dataDeNascimento.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "RG CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                rgCliente.isVisible = true
            }
        }

        cpfCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "ROOM CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                numeroParaChatCliente .isVisible = true
            }

            if (!hasFocus && cpfCliente.length() == 14) {
                cpfCliente.error = null
            }

            if (!hasFocus && cpfCliente.length() != 14) {
                cpfCliente.error = "CPF inválido, deve ter 11 digitos"
            }
        }

        rgCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "SENHA CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                senhaCliente.isVisible = true
            }
            if (!hasFocus && rgCliente.length() == 12) {
                rgCliente.error = null
            }
            if (!hasFocus && rgCliente.length() != 12) {
                rgCliente.error = "RG inválido, deve ter 9 digitos"
            }
        }

        numeroParaChatCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "BOTÃO ABERTO", Toast.LENGTH_LONG).show()
                btnCadastrarCliente.isVisible = true
            }
        }

        cepResidencia.setOnFocusChangeListener { v, hasFocus ->

            val cep = cepResidencia.text

            if (!hasFocus && cep.length == 8) {
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

    private fun validaForm(): Boolean {

        var error = true

        if(numeroCasa.text.isEmpty()){
            numeroCasa.error = "Digite o número da sua casa."
            error = false
        }

        if(editDataNascimento.text.isEmpty()){
            editDataNascimento.error = "Escolha sua data de nascimento."
            error = false
        }

        if(numeroParaChatCliente.text.isEmpty()){
            numeroParaChatCliente.error = "Insira um número de identificação, ele será utilizado para manter uma conversa no chat."
            error = false
        }

        if(nomeCliente.text.isEmpty()){
            nomeCliente.error = "Coloque seu nome completo no campo."
            error = false
        }

        if(editTextCep.text.isEmpty()){
            editTextCep.error = "Insira o CEP de sua residência."
            error = false
        }

        if(celularCliente.text.isEmpty()){
            celularCliente.error = "Digite o número do seu celular."
            error = false
        }

        if(emailCliente.text.isEmpty()){
            emailCliente.error = "Digite o seu e-mail mais utilizado."
            error = false
        }

        if(cpfCliente.text.isEmpty()){
            cpfCliente.error = "Insira o seu CPF."
            error = false
        }

        if(rgCliente.text.isEmpty()){
            rgCliente.error = "Insira o seu RG."
            error = false
        }

        if(senhaCliente.text.isEmpty()){
            senhaCliente.error = "Crie uma senha, ela será ustilizada para efetuar o login."
            error = false
        }

        return error

    }
}