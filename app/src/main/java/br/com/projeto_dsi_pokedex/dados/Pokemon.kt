package br.com.projeto_dsi_pokedex.dados

data class Pokemon(
    val number: Int,
    val name: String?,
    val types: List<TipoPokemon>?

){
    val numeroFormatado = number.toString().padStart(3, '0')

    val imagemUrl ="\"https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$numeroFormatado.png\""
}

