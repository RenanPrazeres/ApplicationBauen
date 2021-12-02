package br.com.bauen.mainactivit.adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.bauen.mainactivit.R
import br.com.bauen.mainactivit.tables.PrestadorDeServico
import com.bumptech.glide.Glide

class ServiceProviderAdapter (val context: Context): RecyclerView.Adapter<ServiceProviderAdapter.Holder>() {

    var listProviders = emptyList<PrestadorDeServico>()

    fun updateProviderList(list: List<PrestadorDeServico>){
        listProviders = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceProviderAdapter.Holder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.lista_prestador_layout, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listProviders.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val recentProviders = listProviders[position]

        val randomProjects = (7..27).random()

        val randomRating = (2..5).random()

        val rating = randomRating.toString() + "F"

        holder.providerName.text = recentProviders.name
        holder.nameService.text = recentProviders.nameService
        holder.projects.text = "Mais de ${randomProjects} Projetos Realizados"
        holder.ratingProvider.rating = rating.toFloat()

        Glide.with(holder.itemView.getContext()).load(recentProviders.photo).into(holder.ivProviderImage)

    }

    class Holder(view: View): RecyclerView.ViewHolder(view){
        val providerName = view.findViewById<TextView>(R.id.textNome)
        val ivProviderImage = view.findViewById<ImageView>(R.id.foto_listagem)
        val nameService = view.findViewById<TextView>(R.id.textProfissao)
        val projects = view.findViewById<TextView>(R.id.textDescricao)
        val ratingProvider = view.findViewById<RatingBar>(R.id.ratingAvaliacao)

    }
}