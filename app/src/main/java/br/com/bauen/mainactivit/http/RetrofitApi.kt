package br.com.bauen.mainactivit.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {
    companion object {
        fun getRetrofit() : Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.107.140.74:3334")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}



