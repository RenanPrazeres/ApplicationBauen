package br.com.bauen.mainactivit

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import br.com.bauen.mainactivit.cep.Cep
import br.com.bauen.mainactivit.cep.RetrofitFactory
import br.com.bauen.mainactivit.http.HttpHelper
import br.com.bauen.mainactivit.tables.Cliente
import br.com.bauen.mainactivit.tables.Endereco
import br.com.bauen.mainactivit.tables.PrestadorDeServico
import br.com.bauen.mainactivit.ultis.MaskFormatUtil
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CadastroPrestadorDeServico : AppCompatActivity() {

    lateinit var editTextCep: EditText
    lateinit var editTextRua: TextView
    lateinit var editTextEstado: TextView
    lateinit var editTextCidade: TextView
    lateinit var editTextBairro: TextView
    lateinit var editDataNascimento: TextView
    lateinit var numeroCasa: EditText
    lateinit var cpfPrestador: EditText
    lateinit var rgPrestador: EditText
    lateinit var senhaPrestador: EditText
    lateinit var numeroParaChatPrestador: EditText
    lateinit var nomePrestador: EditText
    lateinit var celularPrestador: EditText
    lateinit var emailPrestador: EditText
    lateinit var btnCadastrarPrestador: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_prestador_de_servico)

        nomePrestador = findViewById(R.id.et_nomePrestador)
        emailPrestador = findViewById(R.id.et_emailPrestador)
        celularPrestador = findViewById(R.id.et_celularPrestador)
        editDataNascimento = findViewById(R.id.et_datadenascimentoPrestador)
        editTextCep = findViewById(R.id.et_cepPrestador)
        editTextRua = findViewById(R.id.et_ruaPrestador)
        editTextEstado = findViewById(R.id.et_estadoPrestador)
        editTextCidade = findViewById(R.id.et_cidadePrestador)
        editTextBairro = findViewById(R.id.et_bairroPrestador)
        numeroCasa = findViewById(R.id.et_numeroPrestador)
        cpfPrestador = findViewById(R.id.et_cpfPrestador)
        rgPrestador = findViewById(R.id.et_rgPrestador)
        senhaPrestador = findViewById(R.id.et_senhaPrestador)
        numeroParaChatPrestador = findViewById(R.id.et_roomPrestador)
        btnCadastrarPrestador = findViewById(R.id.button_cadastrarPrestador)

//        //MÁSCARA NOS CAMPOS
//        editTextCep.addTextChangedListener(
//            MaskFormatUtil.mask(
//                editTextCep,
//                MaskFormatUtil.FORMAT_CEP
//            )
//        )
//
//        cpfPrestador.addTextChangedListener(
//            MaskFormatUtil.mask(
//                cpfPrestador,
//                MaskFormatUtil.FORMAT_CPF
//            )
//        )
//
//        rgPrestador.addTextChangedListener(
//            MaskFormatUtil.mask(
//                rgPrestador,
//                MaskFormatUtil.FORMAT_RG
//            )
//        )

        //Click no botão de CADASTRO
        btnCadastrarPrestador.setOnClickListener {
            if (validaForm()) {

                val zipcode = editTextCep.text.toString()
                val street = editTextRua.text.toString()
                val state = editTextEstado.text.toString()
                val city = editTextCidade.text.toString()
                val neighborhood = editTextBairro.text.toString()
                val number = numeroCasa.text.toString()

                //Cria o objeto Endereco
                val address :Endereco = Endereco(zipcode,street,state,city,neighborhood,number)

                //instancia os elementos do objeto prestador
                val name = nomePrestador.text.toString()
                val email = emailPrestador.text.toString()
                val phone = celularPrestador.text.toString()
                val born = editDataNascimento.text.toString()
                val cpf = cpfPrestador.text.toString()
                val rg = rgPrestador.text.toString()
                val room = numeroParaChatPrestador.text.toString()
                val password = senhaPrestador.text.toString()

                //Cria o objeto pestador + endereço
                val prestador: PrestadorDeServico = PrestadorDeServico(phone, name, cpf, rg, password, email, born, room, address)

                //Converter o prestador em json
                val gson = Gson()
                val prestadorJson = gson.toJson(prestador)

                println("............" + prestadorJson)


                doAsync {
                    val http = HttpHelper()
                    http.postPrestador(prestadorJson)

//                    val http2 = HttpHelper()
//                    http2.postPrestador(enderecoJson)
                }
                abrirLogin()
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

        numeroCasa.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
//                Toast.makeText(this, "CPF CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                cpfPrestador.isVisible = true
            }
        }

        editDataNascimento.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
//                Toast.makeText(this, "RG CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                rgPrestador.isVisible = true
            }
        }

        cpfPrestador.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
//                Toast.makeText(this, "ROOM CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                numeroParaChatPrestador.isVisible = true
            }

            if (!hasFocus && cpfPrestador.length() == 11) {
                cpfPrestador.error = null
            }

            if (!hasFocus && cpfPrestador.length() != 11) {
                cpfPrestador.error = "CPF inválido, deve ter 11 digitos"
            }
        }

        rgPrestador.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
//                Toast.makeText(this, "SENHA CLIENTE ABERTO", Toast.LENGTH_LONG).show()
                senhaPrestador.isVisible = true
            }
            if (!hasFocus && rgPrestador.length() == 9) {
                rgPrestador.error = null
            }
            if (!hasFocus && rgPrestador.length() != 9) {
                rgPrestador.error = "RG inválido, deve ter 9 digitos"
            }
        }

        numeroParaChatPrestador.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
//                Toast.makeText(this, "BOTÃO ABERTO", Toast.LENGTH_LONG).show()
                btnCadastrarPrestador.isVisible = true
            }
        }

    }

    private fun abrirLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
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

        if (numeroCasa.text.isEmpty()) {
            numeroCasa.error = "Digite o número da sua casa."
            error = false
        }

        if (editDataNascimento.text.isEmpty()) {
            editDataNascimento.error = "Escolha sua data de nascimento."
            error = false
        }

        if (numeroParaChatPrestador.text.isEmpty()) {
            numeroParaChatPrestador.error =
                "Insira um número de identificação, ele será utilizado para manter uma conversa no chat."
            error = false
        }

        if (nomePrestador.text.isEmpty()) {
            nomePrestador.error = "Coloque seu nome completo no campo."
            error = false
        }

        if (editTextCep.text.isEmpty()) {
            editTextCep.error = "Insira o CEP de sua residência."
            error = false
        }

        if (celularPrestador.text.isEmpty()) {
            celularPrestador.error = "Digite o número do seu celular."
            error = false
        }

        if (emailPrestador.text.isEmpty()) {
            emailPrestador.error = "Digite o seu e-mail mais utilizado."
            error = false
        }

        if (cpfPrestador.text.isEmpty()) {
            cpfPrestador.error = "Insira o seu CPF."
            error = false
        }

        if (rgPrestador.text.isEmpty()) {
            rgPrestador.error = "Insira o seu RG."
            error = false
        }

        if (senhaPrestador.text.isEmpty()) {
            senhaPrestador.error = "Crie uma senha, ela será ustilizada para efetuar o login."
            error = false
        }

        return error

    }
}