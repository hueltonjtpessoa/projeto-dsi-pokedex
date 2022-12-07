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

            val pokemons: List<Pokemon> = it.map {

                //Remove a URL
                val numeroConvertido = it.url.toString().replace("https://pokeapi.co/api/v2/pokemon/","")

                Pokemon(it.imagemUrl,
                    it.name,
                    it.url,
                    //Remove a Barra
                    numeroConvertido.substring(0,numeroConvertido.length-1).toInt(),
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