package com.example.videojuegos2023peliculasv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.videojuegos2023peliculasv2.databinding.ActivityMenuBinding
import com.example.videojuegos2023peliculasv2.databinding.ActivityNewPeliculaBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ActivityNewPelicula : AppCompatActivity() {
    lateinit var binding: ActivityNewPeliculaBinding
    lateinit var peliculaDBHelper: MiSQLLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPeliculaBinding.inflate(layoutInflater)
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
    }
}