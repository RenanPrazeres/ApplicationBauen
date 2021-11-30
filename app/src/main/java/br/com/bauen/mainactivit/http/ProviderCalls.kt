package br.com.bauen.mainactivit.http

import br.com.bauen.mainactivit.tables.PrestadorDeServico
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProviderCalls {
    @GET("/service-provider")
    fun listProviders(): Call<List<PrestadorDeServico>>

}


