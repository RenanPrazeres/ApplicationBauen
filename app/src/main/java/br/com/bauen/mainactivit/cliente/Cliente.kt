package br.com.bauen.mainactivit.cliente

import android.graphics.Bitmap

class Cliente {
    var nome = ""
    var email = ""
    var celular = ""
    var cep = ""
    var rua = ""
    var estado = ""
    var cidade = ""
    var bairro = ""
    var numeroResidencia = ""
    var complemento =  ""
    var dataNascimento =  ""
    var cpf =  ""
    var rg = ""
    var senha = ""
    var senhaConfirmacao = ""
    var profissao = ""
    override fun toString(): String {
        return "Cliente(nome='$nome', email='$email', celular='$celular', cep='$cep', rua='$rua', estado='$estado', " +
                "cidade='$cidade', bairro='$bairro', numeroResidencia='$numeroResidencia', complemento='$complemento', dataNascimento='$dataNascimento', " +
                "cpf='$cpf', rg='$rg', senha='$senha', senhaConfirmacao='$senhaConfirmacao', profissao='$profissao')"
    }


}

//    var id: Int = 0,
//    var nome: String,
//    var email: String,
//    var celular: Double,
//    var cep: Double,
//    var rua: String,
//    var estado: String,
//    var cidade: String,
//    var bairro: String,
//    var numeroResidencia: Double,
//    var complemento: String,
//    var dataNascimento: String,
//    var cfp: Double,
//    var rg: Double,
//   var senha: String,
//    var profissao: String,
//    var altura: Double,
//    var sexo: Char,
//    var foto: Bitmap? = null

