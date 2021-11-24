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

class RetrofitFactory2 {
    //RECEBE A URL Da API
    val URL = "http://10.107.144.29:3334//service-provider"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun retrofitService() : RetrofitService {
        return retrofitFactory.create(RetrofitService::class.java)
    }
}