package br.com.projeto_dsi_pokedex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto_dsi_pokedex.R
import br.com.projeto_dsi_pokedex.dados.Pokemon

class PKAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PKAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bdView(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bdView(item: Pokemon) = with(itemView) {
            val imageViewPokemon = findViewById<ImageView>(R.id.imageViewPokemon)
            val textViewNumero = findViewById<TextView>(R.id.textViewNumero)
            val textViewNome = findViewById<TextView>(R.id.textViewNome)
            val textViewTipo1 = findViewById<TextView>(R.id.textViewTipo1)
            val textViewTipo2 = findViewById<TextView>(R.id.textViewTipo2)

            // TODO: Carregar imagem com o Glide

            textViewNumero.text = "Nº ${item.numero}"
            textViewNome.text = item.nome
            textViewTipo1.text = item.tipos[0].nome

            if(item.tipos.size > 1){
                textViewTipo2.visibility = View.VISIBLE
                textViewTipo2.text = item.tipos[1].nome
            }else {
                textViewTipo2.visibility = View.GONE
            }
        }
    }
}