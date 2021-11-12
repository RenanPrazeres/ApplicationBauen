package br.com.bauen.mainactivit.adapter
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.bauen.mainactivit.R
import model.Card


class CardsAdapter( var context: Context) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>(){

    private var listaCard = emptyList<Card>()

    fun updateListaCard(lista : List<Card>){
        listaCard = lista
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lista_prestador_layout, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        Log.i("xptoholder", "onCreateViewHolder")

        val card = listaCard[position]

        holder.textNome.text = card.nome
        holder.textDescricao.text = card.descricao
        holder.textProfissao.text = card.profissao
        holder.ratingAvaliacao.text = card.avaliacao.toString() // ARRUMAR !!!!!!!!!!!!!!

    }

    override fun getItemCount(): Int {

        Log.i("xptoholder", "getItemCount")

        return listaCard.size
    }


    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textNome = itemView.findViewById<TextView>(R.id.textNome)
        val textDescricao = itemView.findViewById<TextView>(R.id.textDescricao)
        val textProfissao = itemView.findViewById<TextView>(R.id.textProfissao)
        val ratingAvaliacao = itemView.findViewById<TextView>(R.id.ratingAvaliacao)



    }


}