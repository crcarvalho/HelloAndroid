package br.com.carloscarvalho.helloandroid.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.carloscarvalho.helloandroid.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nome = intent.getStringExtra("nome")
        val phone = intent.getStringExtra( "phone" );

        tvNome.text = getString(R.string.saudacao, nome, phone);
    }
}