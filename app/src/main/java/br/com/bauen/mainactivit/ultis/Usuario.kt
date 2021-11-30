package br.com.bauen.mainactivit.ultis

data class Usuario(
    var codigo: Long = 0,
    var name: String = "",
    var email: String = "",
    var password: String = ""
)