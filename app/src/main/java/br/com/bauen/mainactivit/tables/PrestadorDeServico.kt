package br.com.bauen.mainactivit.tables

data class PrestadorDeServico(
    var phone: String,
    var name: String,
    var cpf: String,
    var rg: String,
    var password: String,
    var email: String,
    var born: String,
    var room: String,
    var address: Endereco,
    var photo: String? = "",
    var nameService: String? = ""
)

