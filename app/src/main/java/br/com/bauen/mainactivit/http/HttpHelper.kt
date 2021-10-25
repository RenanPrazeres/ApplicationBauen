package br.com.bauen.mainactivit.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Request

class HttpHelper {

    fun post (json: String) : String {
        //Definir URL do servidor
        val URLApi = "http://192.168.0.102:3334/"

        //Definir o cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // Criar cliente que vai disparar a requisição
        val client = OkHttpClient()

        //Criar o body da requisição
        val body = RequestBody.create(headerHttp, json)

        //Construir a requisição POST HTTP para o servidor
        var request = Request.Builder().url(URLApi).post(body).build()

        //Utilizar o client para fazer a requisição e receber a resposta
        val response = client.newCall(request).execute()

        return response.body().toString()


    }
}