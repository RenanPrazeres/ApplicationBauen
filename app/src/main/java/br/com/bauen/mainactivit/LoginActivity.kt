package br.com.bauen.mainactivit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.bauen.mainactivit.http.HttpHelper
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

        //clique e abrir nova activity
        cadastre_se.setOnClickListener {
            val intent = Intent (this, CadastroCliente::class.java)
            startActivity(intent)

//            doAsync {
//                val http = HttpHelper()
//                http.get()
//            }
        }
    }
}