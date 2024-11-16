package br.com.cotemig.av2

import retrofit2.Call
import retrofit2.http.GET



interface IPessoaEndpoint {

    @GET("pessoa")
    fun get(): Call<ArrayList<PessoaModel>>



}