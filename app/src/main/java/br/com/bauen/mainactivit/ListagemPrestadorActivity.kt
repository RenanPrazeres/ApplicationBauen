package br.com.bauen.mainactivit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.bauen.mainactivit.adapter.CardsAdapter

class ListagemPrestadorActivity : AppCompatActivity() {

    lateinit var rvCard: RecyclerView
    lateinit var cardsAdapter: CardsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_prestador)

        //Configuração da recycleView
        //
        rvCard = findViewById(R.id.rv_Cards)
        cardsAdapter = CardsAdapter(this)

        //Deteminar o Layout da RV
        rvCard.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)

        //Definir o adapter da RV
        rvCard.adapter = cardsAdapter


        rvCard.layoutManager = GridLayoutManager(this,2)
        //Definir o adapter da Rv
        rvCard.adapter = cardsAdapter


    }
}
