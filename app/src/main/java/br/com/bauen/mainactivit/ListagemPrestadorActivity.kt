package br.com.bauen.mainactivit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity.apply
import androidx.core.view.GravityCompat.apply
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.bauen.mainactivit.adapter.CardsAdapter
import br.com.bauen.mainactivit.http.HttpHelper
import model.Card
import org.jetbrains.anko.doAsync
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListagemPrestadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_prestador)

        doAsync {
            val http = HttpHelper()
            http.get2()
        }
    }
}
