package br.com.treino.core.data.network

import br.com.treino.core.data.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters (
        @QueryMap
        queries: Map<String, String>
    ): DataWrapperResponse

}