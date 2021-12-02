package br.com.bauen.mainactivit

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



//        buttonLogin.setOnClickListener {
//            login()
//        }


    }

//    private fun login(){
//        val user = email_login.text.toString()
//        val pass = senha_login.text.toString()

//        val dao = UsuarioDao(this, null)
//        val autenticado = dao.autenticar(user, pass)



    fun showDialog(view: View) {
        when(view.id){
            R.id.cadastre_se_login ->{
                abrirDialog()
            }
        }
    }

    fun abrirDialog(){
        val alertDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val view = inflater.inflate(R.layout.activity_dialog_cadastro, null)

        alertDialog.setView(view)

        val dialog = alertDialog.create()
        dialog.show()

        alertDialog.setPositiveButton("Sim") { dialogInterface: DialogInterface, i: Int ->
            abrirTelaBiometria()

        }
    }

    private fun abrirTelaBiometria() {
        val intent = Intent(this, CadastroPrestadorDeServico::class.java)
        startActivity(intent)
        finish()
    }


}