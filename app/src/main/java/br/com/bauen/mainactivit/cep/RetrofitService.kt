package br.com.bauen.mainactivit.cep

import br.com.bauen.mainactivit.cep.Cep
import model.Card
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface RetrofitService {
    //Método que será responsável por chamar a API
    // https://viacep.com.br/ws/06600025/json/
    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") cep: String): Call<Cep>
    @GET("{uf}/{cidade}/{logradouro}/json")

    fun getCEPByLogradouro(
        @Path("uf") uf: String,
        @Path("cidade") cidade: String,
        @Path("logradouro") logradouro: String) : Call<List<Cep>>

}

//interface RetrofitService2{
//    //Método que será responsável por chamar a API
//    // "http://10.107.144.29:3334//service-provider"
//    @GET("{CARD}/json/")
//    fun getCARD(@Path("CARD") card: String): Call<Card>
//    @GET("{nome}/{descricao}/{avaliacao}/{profissao}/json")
//
//    fun getCARDS(
//        @Path("nome") nome: String,
//        @Path("descricao") descricao: String,
//        @Path("avaliacao") avavilacao: String,
//        @Path("profissao") profissao: String) : Call<List<Card>>
//
//}



interface ApiService {
    @GET("/Card")
    fun fetchAllCard(): Call<List<Card>>
}