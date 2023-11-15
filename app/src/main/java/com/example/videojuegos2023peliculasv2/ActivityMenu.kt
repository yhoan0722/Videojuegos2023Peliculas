package com.example.videojuegos2023peliculasv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.videojuegos2023peliculasv2.databinding.ActivityMenuBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ActivityMenu : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding
    lateinit var peliculaDBHelper: MiSQLLiteHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peliculaDBHelper = MiSQLLiteHelper(this)

//        binding.btnGuardar.setOnClickListener{
//            if(binding.txtTitulo.text.isNotBlank() && binding.txtImage.text.isNotBlank() && binding.txtYear.text.isNotBlank() && binding.txtDescripcion.text.isNotBlank()){
//                peliculaDBHelper.agregarDato(binding.txtTitulo.text.toString(), binding.txtImage.text.toString(), binding.txtYear.text.toString(), binding.txtDescripcion.text.toString())
//                binding.txtTitulo.text.clear()
//                binding.txtImage.text.clear()
//                binding.txtYear.text.clear()
//                binding.txtDescripcion.text.clear()
//                Toast.makeText(this, "Guardado",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(this, "No se ha podido guardar",Toast.LENGTH_LONG).show()
//            }
//        }

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

        val Gps = findViewById<TextView>(R.id.btnGPS)
        Gps.setOnClickListener {
            goToGPS()
        }

        val Create = findViewById<TextView>(R.id.btnInsertar)
        Create.setOnClickListener {
            goToNewPelicula()
        }
        val Back = findViewById<TextView>(R.id.btnBack)
        Back.setOnClickListener {
            goToBack()
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

    private fun goToGPS(){
        val i = Intent(this, ActivityGPS::class.java)
        startActivity(i)
    }
    private fun goToNewPelicula(){
        val i = Intent(this, ActivityNewPelicula::class.java)
        startActivity(i)
    }
    private fun goToBack(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}
