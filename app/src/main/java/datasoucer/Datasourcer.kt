package datasoucer

import model.Card

class Datasourcer {

    companion object {
        fun getCard () : ArrayList <Card>{
            var cards  = ArrayList <Card>()

            cards.add(Card("RenanPrazeres", "Mais de 30 Serviços", "Eletricista"))
            cards.add(Card("Ligia", "Mais de 25 Serviços", "Pedreiro"))
            cards.add(Card("Beatriz", "Mais de 10 Serviços", "Azulejista"))
            cards.add(Card("helder", "Mais de 32 Serviços", "Pedreiro"))
            cards.add(Card("Kauan", "Mais de 33 Serviços", "jardinerio"))
            cards.add(Card("Jean", "Mais de 300 Serviços", "Eletricista"))
            cards.add(Card("Vanessa", "Mais de 130 Serviços", "Eletricista"))
            cards.add(Card("Gabriel", "Mais de 320 Serviços", "Eletricista"))
            cards.add(Card("Rafaela", "Mais de 31 Serviços", "Eletricista"))
            cards.add(Card("Carine", "Mais de 33 Serviços", "Eletricista"))
            cards.add(Card("Bruna", "Mais de 20 Serviços", "Eletricista"))

            return cards
        }
    }
}