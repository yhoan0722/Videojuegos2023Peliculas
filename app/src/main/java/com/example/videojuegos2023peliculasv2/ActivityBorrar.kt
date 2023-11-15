package com.example.videojuegos2023peliculasv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.videojuegos2023peliculasv2.databinding.ActivityBorrarBinding

class ActivityBorrar : AppCompatActivity() {
    lateinit var binding: ActivityBorrarBinding
    lateinit var peliculaDBHelper: MiSQLLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrar)
        binding = ActivityBorrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peliculaDBHelper = MiSQLLiteHelper(this)

        binding.btnBorrar.setOnClickListener{
            var cantidad =  0

            if(binding.txtId.text.isNotBlank() ) {
                cantidad = peliculaDBHelper.borrarDato(binding.txtId.text.toString().toInt())
                binding.txtId.text.clear()

                Toast.makeText(
                    this,
                    "Datos Borrados: $cantidad",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        val Backing = findViewById<TextView>(R.id.btnRegresar)
        Backing.setOnClickListener {
            goToBack()
        }
    }
    private fun goToBack(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}