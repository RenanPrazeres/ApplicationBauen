package br.com.bauen.mainactivit.login

class Endereco {
    var zipcode = ""
    var street = ""
    var state = ""
    var city = ""
    var neighborhood = ""
    var number = ""

    override fun toString(): String {
        return "Endereco(zipcode='$zipcode', street='$street', state='$state', city='$city', neighborhood='$neighborhood', number='$number')"
    }


}