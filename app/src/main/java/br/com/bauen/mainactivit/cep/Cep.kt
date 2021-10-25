package br.com.bauen.mainactivit.cep

import com.google.gson.annotations.SerializedName

data class Cep (
    var  cep: String,
    var  logradouro: String,
    var  complemento: String,
    var  bairro: String,
    @SerializedName("localidade")
    var cidade: String,
    var  uf: String,
    var  ibge: String,
    var  gia: String,
    var  ddd: String,
    var  siafi: String

)