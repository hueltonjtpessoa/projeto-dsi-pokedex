package br.com.projeto_dsi_pokedex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto_dsi_pokedex.R
import br.com.projeto_dsi_pokedex.dados.Pokemon
import com.bumptech.glide.Glide

// Classe Adapter com os métodos implementados
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

            //Carregar imagem com o Glide
            item.let{
                Glide.with(itemView.context).load("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+item.numeroFormatado+".png").into(imageViewPokemon)

                textViewNumero.text = "Nº ${item.numeroFormatado}"
                textViewNome.text = item.name
                textViewTipo1.text = item.types!![0].name

                // If checando se o Pokemon tem mais de um Tipo

                if(item.types.size > 1){
                    textViewTipo2.visibility = View.VISIBLE
                    textViewTipo2.text = item.types[1].name
                }else {
                    textViewTipo2.visibility = View.GONE
                }
        }

        }
    }
}