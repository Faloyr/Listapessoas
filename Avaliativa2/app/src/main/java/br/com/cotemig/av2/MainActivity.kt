package br.com.cotemig.av2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Luis Gonzaga Barbosa Silva
        //Matrícula: 72201231
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onResume() {
        super.onResume()
        getPessoas()
    }
    fun getPessoas() {
        var instace = RetrofitUtil.getInstance("https://6734c0aea042ab85d11b7a30.mockapi.io/")
        var endpoint = instace.create(IPessoaEndpoint::class.java)

        var contexto = this

        endpoint.get().enqueue(object : Callback<ArrayList<PessoaModel>> {
            override fun onResponse(
                call: Call<ArrayList<PessoaModel>>,
                response: Response<ArrayList<PessoaModel>>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        var retorno: ArrayList<PessoaModel> = response?.body()!!

                        var recyclerviw = findViewById<RecyclerView>(R.id.rvPessoas)
                        recyclerviw.adapter = PessoaAdapter(contexto, retorno)
                        recyclerviw.layoutManager = LinearLayoutManager(contexto)
                        recyclerviw.itemAnimator = DefaultItemAnimator()
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<PessoaModel>>, t: Throwable) {
                Toast.makeText(contexto, "Erro na chamada", Toast.LENGTH_SHORT).show()
            }

        })
    }
}