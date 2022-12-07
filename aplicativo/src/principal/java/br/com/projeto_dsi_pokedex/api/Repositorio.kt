package br.com.projeto_dsi_pokedex.api

import br.com.projeto_dsi_pokedex.api.model.PokemonApiResultado
import br.com.projeto_dsi_pokedex.api.model.ResultadoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repositorio {
    private val service:Service
    init {
        val retrofit = Retrofit.Builder() /** biblioteca Retrofit para requisições HTTP */
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(Service::class.java)
    }

    fun listPokemons(limit: Int = 251): ResultadoApi? {
        val call = service.listaPokemons(limit)

        return call.execute().body()

    }

    fun getPokemon(number:Int): PokemonApiResultado? {
        val call = service.getPokemon(number)

        return call.execute().body()

    }

}
