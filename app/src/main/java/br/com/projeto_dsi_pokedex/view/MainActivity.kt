package br.com.projeto_dsi_pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.projeto_dsi_pokedex.R
import br.com.projeto_dsi_pokedex.api.Repositorio
import br.com.projeto_dsi_pokedex.dados.Pokemon
import br.com.projeto_dsi_pokedex.dados.TipoPokemon

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        /*
        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            "Charmander",
            4,
            listOf(
                TipoPokemon("Fogo")
            )
        )

        val pokemons = listOf(charmander, charmander, charmander, charmander, charmander)
        */

        Thread(Runnable {
            metodoPokemons()
        }).start()


    }

    private fun metodoPokemons() {
        val pokemonsResultado = Repositorio.listPokemons()

        pokemonsResultado?.results?.let {

            val pokemons: List<Pokemon> = it.map {


                Pokemon(it.imagemUrl,
                    it.nome,
                    1,
                    listOf(TipoPokemon("Fire"))
                )
            }



            val layoutManager = LinearLayoutManager(this)
            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PKAdapter(pokemons)
            }

        }


    }
}