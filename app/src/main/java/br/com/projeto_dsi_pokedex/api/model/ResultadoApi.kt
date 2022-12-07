package br.com.projeto_dsi_pokedex.api.model

import br.com.projeto_dsi_pokedex.dados.Pokemon
import br.com.projeto_dsi_pokedex.dados.TipoPokemon
// classes regulares voltadas para o armazenamento de estado
data class ResultadoApi(
    val count: Int,
    //next, previous são opcionais, podem acertar. Por isso o uso da "?" para mostrar que nem sempre estão aqui.
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name:String,
    val url:String
)

data class PokemonApiResultado(
    val id: Int,
    val name: String,
    val types: List<PokemonTipoSlot>
)

data class PokemonTipoSlot(
    val slot: Int,
    val type: TipoPokemon
)