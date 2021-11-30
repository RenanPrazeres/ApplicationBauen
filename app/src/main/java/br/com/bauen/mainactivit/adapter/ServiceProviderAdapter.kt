package br.com.bauen.mainactivit.adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.bauen.mainactivit.R
import br.com.bauen.mainactivit.tables.PrestadorDeServico

class ServiceProviderAdapter (val context: Context): RecyclerView.Adapter<ServiceProviderAdapter.Holder>() {

    var listProviders = emptyList<PrestadorDeServico>()

    fun updateCategoryList(list: List<PrestadorDeServico>){
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
        holder.providerName.text = recentProviders.name
    }

    class Holder(view: View): RecyclerView.ViewHolder(view){
        val providerName = view.findViewById<TextView>(R.id.textNome)
    }
}