package br.com.cotemig.av2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PessoaAdapter (val contexto: Context, val lista: ArrayList<PessoaModel>) :
    RecyclerView.Adapter<PessoaAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvNome = view.findViewById<TextView>(R.id.tvNome)
        val tvNacionalidade = view.findViewById<TextView>(R.id.tvNacionalidade)
        val tvDataN = view.findViewById<TextView>(R.id.tvDataN)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(contexto).inflate(R.layout.lista_item, parent, false))
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNome.text = lista[position].nome
        holder.tvNacionalidade.text = lista[position].Nacionalidade
        holder.tvDataN.text = lista[position].dtNascimento

    }
}