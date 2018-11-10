package br.com.carloscarvalho.helloandroid.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.carloscarvalho.helloandroid.R
import br.com.carloscarvalho.helloandroid.model.Pedido
import br.com.carloscarvalho.helloandroid.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders
                .of( this )
                .get(MainViewModel::class.java)

        //Preenche variaveis
        mainViewModel.nomeCliente = intent.getStringExtra("nome")
        mainViewModel.telefoneCliente = intent.getStringExtra( "phone" )


        cbAtum.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.atumSelecionado = isChecked
        }
        cbBacon.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.baconSelecionado = isChecked
        }
        cbMussarela.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.mussarelaSelecionado = isChecked
        }
        cbCalabresa.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.calabresaSelecionado = isChecked
        }


        //Preenche textView da Tela com valores do nome do cliente e telefone
        tvNome.text = getString(R.string.saudacao, mainViewModel.nomeCliente, mainViewModel.telefoneCliente)

        //Preenche dados da tela com valor preenchido na viewmodel
        cbAtum.isChecked = mainViewModel.atumSelecionado
        cbBacon.isChecked = mainViewModel.baconSelecionado
        cbMussarela.isChecked = mainViewModel.mussarelaSelecionado
        cbCalabresa.isChecked = mainViewModel.calabresaSelecionado

        btCalcular.setOnClickListener{
            val intent = Intent( this, CheckoutActivity::class.java)
            intent.putExtra("pedido", gerarPedido())
            startActivity(intent)
        }
    }

    private fun gerarPedido(): Pedido {
        return Pedido(mainViewModel.nomeCliente, mainViewModel.telefoneCliente)
    }
}
