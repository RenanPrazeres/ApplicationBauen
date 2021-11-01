package br.com.bauen.mainactivit.adapter
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import model.Card


class CardsAdapter(var listaCard: ArrayList<Card>) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>(){

    class CardViewHolder (itemView: View ) : RecyclerView.ViewHolder (itemView){
        fun bind (card : Card ){
            itemView.Textnome.text = card.nome
            itemView.TextDescricao.text = card.descricao
            itemView.RatingAvaliacao.rating = card.avaliacao
            itemView.TextProfissao.text = card.profissao



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

    }
}