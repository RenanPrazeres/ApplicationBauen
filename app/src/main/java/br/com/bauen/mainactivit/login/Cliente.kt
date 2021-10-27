package br.com.bauen.mainactivit.login

class Cliente {
    var name = ""
    var email = ""
    var phone = ""
    var born =  ""
    var cpf =  ""
    var rg = ""
    var password = ""
    var room = ""
    override fun toString(): String {
        return "Cliente(nome='$name', email='$email', celular='$phone', dataNascimento='$born', " +
                "cpf='$cpf', rg='$rg', senha='$password', espaçoReformando='$room')"
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
//    var profissao = ""

