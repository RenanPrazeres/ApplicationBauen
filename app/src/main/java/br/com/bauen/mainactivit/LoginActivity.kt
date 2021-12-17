package br.com.bauen.mainactivit

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import br.com.bauen.mainactivit.http.HttpHelper
import br.com.bauen.mainactivit.ultis.DialogCadastro
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class LoginActivity : AppCompatActivity() {

    lateinit var email_login: EditText
    lateinit var senha_login: EditText
    lateinit var buttonLogin: Button
    lateinit var novoPorAqui: TextView
    lateinit var cadastre_se: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.email_login)
        senha_login = findViewById(R.id.senha_login)
        buttonLogin = findViewById(R.id.button_login)
        novoPorAqui = findViewById(R.id.nao_tem_conta)
        cadastre_se = findViewById(R.id.cadastre_se_login)

        buttonLogin.setOnClickListener {
            val intent = Intent(this, PerfilPrestadorActivity::class.java)
            startActivity(intent)
        }

    }

//    override fun onClick(v: View?) {
//        val httpHelper = HttpHelper()
//
//        doAsync {
//            val usuario = httpHelper.login(email_login.text.toString(), senha_login.text.toString())
//
//            uiThread {
//                if (usuario.email.isNotEmpty()){
//                    abrirListagemPrestador()
//                }else {
//                    toast("Dados incorretos! Tente novamente")
//                }
//            }
//        }
//    }

//    private fun abrirListagemPrestador() {
//
//    }


    fun showDialog(view: View) {
        when(view.id){
            R.id.cadastre_se_login ->{
                abrirCaixaDialogo()
            }
        }
    }

//    private fun login() {
//        val user = email_login.text.toString()
//        val pass = senha_login.text.toString()
//
//        val dao = UsuarioDao(this, null)
//        val autenticado = dao.autenticar(user, pass)
//    }

    private fun abrirCaixaDialogo() {

        val caixaDeDialogo = AlertDialog.Builder(this)

        caixaDeDialogo.setTitle("O que você deseja realizar no aplicativo?")
        caixaDeDialogo.setMessage("Você será redirecionado para o caminho desejado")
        caixaDeDialogo.setPositiveButton("Contratar um prestador de serviço") { dialogInterface: DialogInterface, i: Int ->
            abrirCadastroCliente()
        }
        caixaDeDialogo.setNegativeButton("Prestar meu serviço") { dialogInterface: DialogInterface, i: Int ->
            abrirCadastroPrestador()
//            drawerLayout.open()
        }
        caixaDeDialogo.show()
    }

    private fun abrirCadastroCliente() {
        val intent = Intent(this, CadastroCliente::class.java)
        startActivity(intent)
        finish()
    }
    private fun abrirCadastroPrestador() {
        val intent = Intent(this, CadastroPrestadorDeServico::class.java)
        startActivity(intent)
        finish()
    }
}

//    fun abrirDialog(){
//        val alertDialog = AlertDialog.Builder(this)
//        val inflater = layoutInflater
//        val view = inflater.inflate(R.layout.activity_dialog_cadastro, null)
//
//        alertDialog.setView(view)
//
//        val dialog = alertDialog.create()
//        dialog.show()
//
//        alertDialog.setPositiveButton(R.id.bnt_contratar_prestador_dialog_cadastro) { dialogInterface: DialogInterface, i: Int ->
//            val abrirCadastroCliente = Intent (this, CadastroCliente::class.java)
//            startActivity(abrirCadastroCliente)
//
//        }
//    }
