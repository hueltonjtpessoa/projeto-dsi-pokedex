package br.com.projeto_dsi_pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto_dsi_pokedex.R
import br.com.projeto_dsi_pokedex.api.Repositorio
import br.com.projeto_dsi_pokedex.dados.Pokemon
import br.com.projeto_dsi_pokedex.dados.TipoPokemon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            "Charmander",
            4,
            listOf(
                TipoPokemon("Fogo")
            )
        )
        val pokemons = listOf(charmander, charmander, charmander, charmander, charmander)

        val pokemonsApi = Repositorio.listPokemons()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PKAdapter(pokemons)
    }
}