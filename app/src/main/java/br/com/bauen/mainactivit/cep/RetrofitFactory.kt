package br.com.bauen.mainactivit.cep


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    //RECEBE A URL DO VIACEP
    val URL = "https://viacep.com.br/ws/"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun retrofitService() : RetrofitService {
        return retrofitFactory.create(RetrofitService::class.java)
    }
}