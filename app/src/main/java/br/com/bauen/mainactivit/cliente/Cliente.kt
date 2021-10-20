package br.com.bauen.mainactivit.cliente

import android.graphics.Bitmap

class Cliente (
    var id: Int = 0,
    var nome: String,
    var email: String,
    var celular: Double,
    var cep: Double,
    var rua: String,
    var estado: String,
    var cidade: String,
    var bairro: String,
    var numeroResidencia: Double,
    var complemento: String,
    var dataNascimento: String,
    var cfp: Double,
    var rg: Double,
   var senha: String,
//    var profissao: String,
//    var altura: Double,
//    var sexo: Char,
    var foto: Bitmap? = null
)
