package br.com.carloscarvalho.helloandroid.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.carloscarvalho.helloandroid.R
import br.com.carloscarvalho.helloandroid.extensions.value
import br.com.carloscarvalho.helloandroid.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btFazerPedido.setOnClickListener{
            fazerPedido()
        }


    }

    private fun fazerPedido() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("nome", inputNome.value() );
        intent.putExtra("phone", inputPhone.value() );
        startActivity(intent)
    }
}
