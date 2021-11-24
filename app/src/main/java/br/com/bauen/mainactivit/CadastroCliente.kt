package br.com.bauen.mainactivit

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
    lateinit var editTextRua: TextView
    lateinit var editTextEstado: TextView
    lateinit var editTextCidade: TextView
    lateinit var editTextBairro: TextView
    lateinit var editDataNascimento: TextView
    lateinit var numeroCasa: EditText
    lateinit var cpfCliente: EditText
    lateinit var rgCliente: EditText
    lateinit var senhaCliente: EditText
    lateinit var numeroParaChatCliente : EditText
    lateinit var nomeCliente: EditText
    lateinit var celularCliente: EditText
    lateinit var emailCliente: EditText
    lateinit var btnCadastrarCliente: Button

    @SuppressLint("WrongConstant", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)

        nomeCliente = findViewById(R.id.et_nomeCliente)
        emailCliente = findViewById(R.id.et_emailCliente)
        celularCliente = findViewById(R.id.et_celularCliente)
        editDataNascimento = findViewById(R.id.et_datadenascimentoCliente)
        editTextCep = findViewById(R.id.et_cepCliente)
        editTextRua = findViewById(R.id.et_ruaCliente)
        editTextEstado = findViewById(R.id.et_estadoCliente)
        editTextCidade = findViewById(R.id.et_cidadeCliente)
        editTextBairro = findViewById(R.id.et_bairroCliente)
        numeroCasa = findViewById(R.id.et_numeroCliente)
        cpfCliente = findViewById(R.id.et_cpfCliente)
        rgCliente = findViewById(R.id.et_rgCliente)
        senhaCliente = findViewById(R.id.et_senhaCliente)
        btnCadastrarCliente = findViewById(R.id.button_cadastrarCliente)
        numeroParaChatCliente = findViewById(R.id.et_roomCliente)

//        rgCliente.addTextChangedListener(
//            MaskFormatUtil.mask(
//                rgCliente,
//                MaskFormatUtil.FORMAT_RG
//            )
//        )

        btnCadastrarCliente.setOnClickListener {
            if (validaForm()) {

                //instancia os elementos do objeto endereco
                val zipcode = editTextCep.text.toString()
                val street = editTextRua.text.toString()
                val state = editTextEstado.text.toString()
                val city = editTextCidade.text.toString()
                val neighborhood = editTextBairro.text.toString()
                val number = numeroCasa.text.toString()
                //Cria o objeto Endereco
                val address :Endereco = Endereco(zipcode,street,state,city,neighborhood,number)

                //instancia os elementos do objeto cliente
                val name = nomeCliente.text.toString()
                val email = emailCliente.text.toString()
                val phone = celularCliente.text.toString()
                val born = editDataNascimento.text.toString()

                val cpf =  cpfCliente.text.toString()
                val rg = rgCliente.text.toString()
                val room = numeroParaChatCliente.text.toString()
                val password = senhaCliente.text.toString()

                //Cria o objeto cliente + endereço
                val cliente: Cliente = Cliente(phone, name, cpf, rg, password, email, born, room, address)

                //Converter o cliente em json
                val gson = Gson()
                val clienteJson = gson.toJson(cliente)

                println("///////////" + clienteJson)

                doAsync {
                    val http = HttpHelper()
                    http.postCliente(clienteJson)
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


        editDataNascimento.setOnFocusChangeListener { v, hasFocus ->
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

            if (!hasFocus && cpfCliente.length() == 11) {
                cpfCliente.error = null
            }

            if (!hasFocus && cpfCliente.length() != 11) {
                cpfCliente.error = "CPF inválido, deve ter 11 digitos"
            }
        }

        rgCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "SENHA CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                senhaCliente.isVisible = true
            }
            if (!hasFocus && rgCliente.length() == 9) {
                rgCliente.error = null
            }
            if (!hasFocus && rgCliente.length() != 9) {
                rgCliente.error = "RG inválido, deve ter 9 digitos"
            }
        }

        numeroParaChatCliente.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                Toast.makeText(this, "BOTÃO ABERTO", Toast.LENGTH_LONG).show()
                btnCadastrarCliente.isVisible = true
            }
        }

        editTextCep.setOnFocusChangeListener { v, hasFocus ->

            val cep = editTextCep.text

            if (!hasFocus && cep.length == 8) {
                searchByCEP()
                editTextCep.error = null
            }

            if (!hasFocus && cep.length < 8) {
                editTextCep.error = "CEP inválido"
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