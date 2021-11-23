package br.com.bauen.mainactivit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val MensagemList: ArrayList<Mensagem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Mensagem : Mensagem = MensagemList[position]

        holder.editTextMensagem.text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.drawable.my_bubble_shape)
        return ViewHolder(v)

//        como usar inflate para shape
    }

    override fun getItemCount(): Int {
       return MensagemList.size
    }

    class ViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        val editTextMensagem = itemView.findViewById<EditText>(R.id.editTextChat) as EditText
    }
}