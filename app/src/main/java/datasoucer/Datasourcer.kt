package datasoucer

import model.Card

class Datasourcer {

    companion object {
        fun getCard () : ArrayList <Card>{
            var cards  = ArrayList <Card>()

            cards.add(Card("RenanPrazeres", "Mais de 30 Serviços", 5.0f,"Eletricista"))
            cards.add(Card("Ligia", "Mais de 25 Serviços", 4.0f,"Pedreiro"))
            cards.add(Card("Beatriz", "Mais de 10 Serviços", 3.0f,"Azulejista"))
            cards.add(Card("helder", "Mais de 32 Serviços", 2.0f,"Pedreiro"))
            cards.add(Card("Kauan", "Mais de 33 Serviços", 1.0f,"jardinerio"))
            cards.add(Card("Jean", "Mais de 300 Serviços", 6.0f,"Eletricista"))
            cards.add(Card("Vanessa", "Mais de 130 Serviços", 4.0f,"Eletricista"))
            cards.add(Card("Gabriel", "Mais de 320 Serviços", 3.0f,"Eletricista"))
            cards.add(Card("Rafaela", "Mais de 31 Serviços", 5.0f,"Eletricista"))
            cards.add(Card("Carine", "Mais de 33 Serviços", 4.0f,"Eletricista"))
            cards.add(Card("Bruna", "Mais de 20 Serviços", 5.0f,"Eletricista"))

            return cards
        }
    }
}