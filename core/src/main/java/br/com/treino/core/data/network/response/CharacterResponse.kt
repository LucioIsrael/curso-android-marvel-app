package br.com.treino.core.data.network.response

data class CharacterResponse (
    val id : Int,
    val name: String,
    val thumbnail: ThumbnailResponse
)