package br.com.projeto_dsi_pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        Thread(Runnable {
            metodoPokemons()
        }).start()

    }

    private fun metodoPokemons() {
        val pokemonsResultado = Repositorio.listPokemons()
        pokemonsResultado?.results?.let {
            val pokemons: List<Pokemon> = it.map { resultado ->
                val number = resultado.url
                    .replace("https://pokeapi.co/api/v2/pokemon/","")
                    .replace("/","").toInt()
                val pokemonsResultado = Repositorio.getPokemon(number)
                pokemonsResultado?.let {
                    Pokemon(
                        pokemonsResultado.id,
                        pokemonsResultado.name,
                        pokemonsResultado.types.map { type ->
                            type.type
                        }
                    )
                }!!
            }


            val layoutManager = LinearLayoutManager(this)
            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PKAdapter(pokemons)
            }

        }


    }
}