package br.com.bauen.mainactivit.tables

class PrestadorDeServico {
    var name : String = ""
    var email = ""
    var phone = ""
    var born =  ""
    var cpf =  ""
    var rg = ""
    var password = ""
    var room = ""

    override fun toString(): String {
        return "PrestadorDeServico(nomePrestador='$name', emailPrestador='$email', phonePrestador='$phone', " +
                "dataNascimentoPrestador='$born', cpfPrestador='$cpf', rgPrestador='$rg', passwordPrestador='$password', roomPrestador='$room')"
    }
}