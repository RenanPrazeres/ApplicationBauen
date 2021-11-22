package br.com.bauen.mainactivit.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Request
import java.net.URL

class HttpHelper {

    fun post (json: String) : String {
        //Definir URL do servidor
        val URL = "https://10.107.177.7:3001"

        //Definir o cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // Criar cliente que vai disparar a requisição
        val client = OkHttpClient()

        //Criar o body da requisição
        val body = RequestBody.create(headerHttp, json)

        //Construir a requisição POST HTTP para o servidor
        var request = Request.Builder().url(URL).post(body).build()

        //Utilizar o client para fazer a requisição e receber a resposta
        val response = client.newCall(request).execute()

        return response.body().toString()

    }

    //GET PRESTADOR
    fun get(){
        //Definir URL do servidor
        val URLApi = "http://10.107.144.3:3334//service-provider"

        // Criar cliente que vai disparar a requisição
        val client = OkHttpClient()

        //Criar uma requisição GET
        val request = Request.Builder().url(URLApi).get().build()

        //Enviar a requisição para o servidor
        val response = client.newCall(request).execute()

        //Extrair o body da requisição
        val responseBody = response.body()

        //Exibir o body da requisição
        if (responseBody != null){
            val json = responseBody.string()
            println("RESPOSTA ===========" + json)
        }
    }

    //GET PRESTADOR LISTAGEM

    fun get2() {

        //Definir URL do servidor
        val URLApi = "http://192.168.56.1:3334//service-provider"

        // Criar cliente que vai disparar a requisição
        val client = OkHttpClient()

        //Criar uma requisição GET
        val request = Request.Builder().url(URLApi).get().build()

        //Enviar a requisição para o servidor
        val response = client.newCall(request).execute()

        //Extrair o body da requisição
        val responseBody = response.body()

        //Exibir o body da requisição
        if (responseBody != null){
            val json = responseBody.string()
            println("RESPOSTA ===========" + json)
        }

    }

}