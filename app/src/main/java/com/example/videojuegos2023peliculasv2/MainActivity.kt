package com.example.videojuegos2023peliculasv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.videojuegos2023peliculasv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var peliculaDBHelper: MiSQLLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peliculaDBHelper = MiSQLLiteHelper(this)

        binding.btnGuardar.setOnClickListener{
            if(binding.txtTitulo.text.isNotBlank() && binding.txtImage.text.isNotBlank() && binding.txtYear.text.isNotBlank() && binding.txtDescripcion.text.isNotBlank()){
                peliculaDBHelper.agregarDato(binding.txtTitulo.text.toString(), binding.txtImage.text.toString(), binding.txtYear.text.toString(), binding.txtDescripcion.text.toString())
                binding.txtTitulo.text.clear()
                binding.txtImage.text.clear()
                binding.txtYear.text.clear()
                binding.txtDescripcion.text.clear()
                Toast.makeText(this, "Guardado",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No se ha podido guardar",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnListaPeliculas.setOnClickListener{
            val intentListView = Intent(this, ActivityLista:: class.java)
            startActivity(intentListView)
        }




        val Delete = findViewById<TextView>(R.id.btnBorrar)
        Delete.setOnClickListener {
                goToDelete()
        }

        val Update = findViewById<TextView>(R.id.btnActualizarPelicula)
        Update.setOnClickListener {
                goToUpdate()
        }



        //binding.btnActualizar.setOnClickListener{
        //    if(binding.txtId.text.isNotBlank() && binding.txtTitulo.text.isNotBlank() && binding.txtImage.text.isNotBlank() &&
        //        binding.txtYear.text.isNotBlank() && binding.txtDescripcion.text.isNotBlank()){
        //        peliculaDBHelper.modificarDato(
        //            binding.txtId.text.toString().toInt(),
        //            binding.txtTitulo.text.toString(),
        //            binding.txtImage.text.toString(),
        //            binding.txtYear.text.toString(),
        //            binding.txtDescripcion.text.toString())
        //        binding.txtId.text.clear()
        //        binding.txtTitulo.text.clear()
        //        binding.txtImage.text.clear()
        //        binding.txtYear.text.clear()
        //        binding.txtDescripcion.text.clear()
        //        Toast.makeText(this, "Actualizado",Toast.LENGTH_LONG).show()
        //    }else{
        //        Toast.makeText(this, "No deben estar vacíos los campos",Toast.LENGTH_LONG).show()
        //    }
        //}

    }
    private fun goToDelete(){
        val i = Intent(this, ActivityBorrar::class.java)
        startActivity(i)
    }

    private fun goToUpdate(){
        val i = Intent(this, ActivityActualizar::class.java)
        startActivity(i)
    }
}