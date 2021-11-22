package br.com.bauen.mainactivit.tables

data class Cliente (
    var name: String,
    var email: String,
    var phone: String,
    var born: String,
    var cpf: String,
    var rg: String,
    var password: String,
    var endereco: Endereco,
    var room: String
)