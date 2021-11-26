package br.com.bauen.mainactivit.http

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Request

class HttpHelper {

    //POST CADASTRO CLIENTE
    fun postCliente (json: String) : String {
        //Definir URL do servidor
        val URLApi = "http://10.107.144.4:3334/register/client"

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

    //POST CADASTRO PRESTADOR
    fun postPrestador (json: String) : String {
        //Definir URL do servidor
        val URLApi = "http://10.107.144.4:3334/register/service-provider"

        //Definir o cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // Criar prestador que vai disparar a requisição
        val prestador = OkHttpClient()

        //Criar o body da requisição
        val bodyPrestador = RequestBody.create(headerHttp, json)

        //Construir a requisição POST HTTP para o servidor
        var requestPrestador = Request.Builder().url(URLApi).post(bodyPrestador).build()

        //Utilizar o client para fazer a requisição e receber a resposta
        val response = prestador.newCall(requestPrestador).execute()

        return response.body().toString()

    }

    fun login (email: String, senha: String){
        //Definir URL do servidor
        val URLApiLogin = "http://10.107.144.4:3334/login-client"

        // Criar login que vai disparar a requisição
        val loginn = OkHttpClient()

        //Construir a requisição POST HTTP para o servidor
        val requestLogin = Request
            .Builder()
            .url(URLApiLogin)
            .get()
            .build()

    }

//       //GET PRESTADOR
//        fun get(){
//       //Definir URL do servidor
//        val URLApi = "http://10.107.144.3:3334//service-provider"
//
//        // Criar cliente que vai disparar a requisição
//        val client = OkHttpClient()
//
//        //Criar uma requisição GET
//        val request = Request.Builder().url(URLApi).get().build()
//
//       //Enviar a requisição para o servidor
//        val response = client.newCall(request).execute()
//
//        //Extrair o body da requisição
//        val responseBody = response.body()
//
//        //Exibir o body da requisição
//        if (responseBody != null){
//            val json = responseBody.string()
//            println("RESPOSTA ===========" + json)
//        }
//    }
//}

       //GET Listagem
        fun get2(){
       //Definir URL do servidor
        val URLApi = "http://10.107.144.29:3334//service-provider"

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
