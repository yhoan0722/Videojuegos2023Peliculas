package com.example.videojuegos2023peliculasv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.videojuegos2023peliculasv2.databinding.ActivityActualizarBinding
import com.example.videojuegos2023peliculasv2.databinding.ActivityBorrarBinding

class ActivityActualizar : AppCompatActivity() {
    lateinit var binding: ActivityActualizarBinding
    lateinit var peliculaDBHelper: MiSQLLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        binding = ActivityActualizarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peliculaDBHelper = MiSQLLiteHelper(this)


        val Backing = findViewById<TextView>(R.id.btnRegresar)
        Backing.setOnClickListener {
            goToBack()
        }

        binding.btnActualizar.setOnClickListener{
            if(binding.txtId.text.isNotBlank() && binding.txtTitulo.text.isNotBlank() && binding.txtImage.text.isNotBlank() &&
                binding.txtYear.text.isNotBlank() && binding.txtDescripcion.text.isNotBlank()){
                peliculaDBHelper.modificarDato(
                    binding.txtId.text.toString().toInt(),
                    binding.txtTitulo.text.toString(),
                    binding.txtImage.text.toString(),
                    binding.txtYear.text.toString(),
                    binding.txtDescripcion.text.toString())
                binding.txtId.text.clear()
                binding.txtTitulo.text.clear()
                binding.txtImage.text.clear()
                binding.txtYear.text.clear()
                binding.txtDescripcion.text.clear()
                Toast.makeText(this, "Actualizado",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No deben estar vacíos los campos",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun goToBack(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}