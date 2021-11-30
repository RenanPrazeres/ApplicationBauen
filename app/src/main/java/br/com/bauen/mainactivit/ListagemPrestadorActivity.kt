package br.com.bauen.mainactivit

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.bauen.mainactivit.adapter.CardsAdapter
import br.com.bauen.mainactivit.adapter.ServiceProviderAdapter
import br.com.bauen.mainactivit.http.ProviderCalls
import br.com.bauen.mainactivit.http.RetrofitApi
import br.com.bauen.mainactivit.tables.PrestadorDeServico
import model.Card
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class ListagemPrestadorActivity : AppCompatActivity() {

    lateinit var rvServiceProvider: RecyclerView
    lateinit var adapterServiceProviders: ServiceProviderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_prestador)


        rvServiceProvider = findViewById(R.id.rv_cards)
        rvServiceProvider.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterServiceProviders = ServiceProviderAdapter(this)

        rvServiceProvider.adapter = adapterServiceProviders

        loadproviderList()
    }

    private fun loadproviderList() {

        var providerList: List<PrestadorDeServico>
        val retrofit = RetrofitApi.getRetrofit()
        val providerCall = retrofit.create(ProviderCalls::class.java)
        val call = providerCall.listProviders()

        call.enqueue(object : retrofit2.Callback<List<PrestadorDeServico>> {

            override fun onFailure(call: Call<List<PrestadorDeServico>>, t: Throwable) {
                Toast.makeText(
                    this@ListagemPrestadorActivity,
                    "Ops! Acho que ocorreu um problema.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("Erro_CONEXÃO", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<PrestadorDeServico>>,
                response: Response<List<PrestadorDeServico>>
            ) {
                providerList = response.body()!!

                adapterServiceProviders.updateCategoryList(providerList)
            }
        })
    }
}
