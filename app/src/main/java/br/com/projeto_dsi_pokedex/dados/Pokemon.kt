package br.com.projeto_dsi_pokedex.dados

data class Pokemon(
    val imagemUrl: String? = null,
    val nome: String,
    val numero: Int? = null,
    val url:String,
    val tipos: List<TipoPokemon>? = null

){
    val numeroFormatado = numero.toString().padStart(3, '0')
}

