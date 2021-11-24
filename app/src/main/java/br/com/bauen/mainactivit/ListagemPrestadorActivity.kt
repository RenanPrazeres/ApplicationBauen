package br.com.bauen.mainactivit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.bauen.mainactivit.adapter.CardsAdapter
import br.com.bauen.mainactivit.cep.ApiService
import model.Card
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class ListagemPrestadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_prestador)



        val retrofit =Retrofit.Builder()
            .baseUrl("http://10.107.144.29:3334//service-provider/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllCard().enqueue(object : Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
//                showData(response.body()!!)
                d("RenanPrazeres","onResponse")
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                d("Renan", "onFailure")
                }
        })

        val card = mutableListOf<Card>()
        for (i in 0..100) {
            card.add(Card("RenanPrazeres", "30 Projetos Realizados","Engenheiro"))
        }

    }
//    private fun showData(body: List<Card>){
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager (this@ListagemPrestadorActivity)
//            adapter = CardsAdapter(Card)
//        }
    }



































//lateinit var rvCard: RecyclerView
//    lateinit var cardAdapeter: CardsAdapter




//Configuração da recycleView
//        //
//        rvCard = findViewById(R.id.rv_cards)
//        cardAdapeter = CardsAdapter(this)
//
//        //Deteminar o Layout da RV
//        rvCard.layoutManager = LinearLayoutManager(
//            this, LinearLayoutManager.VERTICAL, false)
//
//        //Definir o adapter da RV
//        rvCard.adapter = cardAdapeter
//
//
//        rvCard.layoutManager = GridLayoutManager(this,2)
//        //Definir o adapter da Rv
//        rvCard.adapter = cardAdapeter
//
//
//
//
//
//
//
//
//        doAsync {
//            val http = HttpHelper()
//            http.get2()
//        }