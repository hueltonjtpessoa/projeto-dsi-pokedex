package br.com.projeto_dsi_pokedex.dados

data class Pokemon(
    val imagemUrl: String?,
    val name: String?,
    val url: String?,
    val numero: Int,
    val tipos: List<TipoPokemon>?

){
    val numeroFormatado = numero.toString().padStart(3, '0')
}

