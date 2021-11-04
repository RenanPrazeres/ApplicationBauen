package adapter
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import model.Card

class CardsAdapter(var listaCard: ArrayList<Card>) : RecyclerView.Adapter<CardsAdapter.CardViewHolder>(){

    class CardViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView){
       fun bind ( card : Card) {


           itemView.textnome.text = card.nome
           itemView.textDescricao.text = card.descricao
           itemView.ratingAvaliacao.rating = card.avaliacao
           itemView.textProfissao.text = card.profissao

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

    }
}