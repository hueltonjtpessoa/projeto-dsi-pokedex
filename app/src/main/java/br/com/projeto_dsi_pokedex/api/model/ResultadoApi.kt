package br.com.projeto_dsi_pokedex.api.model

import br.com.projeto_dsi_pokedex.dados.Pokemon
import br.com.projeto_dsi_pokedex.dados.TipoPokemon

data class ResultadoApi(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
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