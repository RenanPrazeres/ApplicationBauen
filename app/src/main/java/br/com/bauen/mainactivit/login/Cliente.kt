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
                "cpf='$cpf', rg='$rg', senha='$password', reformado='$room')"
    }
}

