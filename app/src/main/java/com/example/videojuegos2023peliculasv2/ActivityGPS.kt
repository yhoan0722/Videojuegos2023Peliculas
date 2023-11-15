package com.example.videojuegos2023peliculasv2

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.type.LatLng
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class ActivityGPS : AppCompatActivity(), OnMapReadyCallback,  GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener{

    private val locationService:LocationService = LocationService()
    private lateinit var map:GoogleMap

    companion object{
        const val  REQUEST_CODE_LOCATION = 0
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)
        createFragment()


    }
    private fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.gps) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //createMarker()
        createMarkerCinerama()
        createMarkerCinemark()
        createMarkerCinePlanet()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableocation()
    }
//    private fun createMarker(){
//        val coordinates = com.google.android.gms.maps.model.LatLng(-7.150933, -78.506069)
//        val marker = MarkerOptions().position(coordinates).title("UPN")
//        map.addMarker(marker)
//        map.animateCamera(
//            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
//            4000,
//            null
//        )
//    }
        //Ubicación Cines
    //Cinerama
    private fun createMarkerCinerama(){
        val coordinates = com.google.android.gms.maps.model.LatLng(-7.149000266022831, -78.51002280422887)
        val marker = MarkerOptions().position(coordinates).title("Cinerama")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    //CineMark
    private fun createMarkerCinemark(){
        val coordinates = com.google.android.gms.maps.model.LatLng(-7.15167159383081, -78.50529138888798)
        val marker = MarkerOptions().position(coordinates).title("Cinemark")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
        //CinePlanet
    private fun createMarkerCinePlanet(){
        val coordinates = com.google.android.gms.maps.model.LatLng(-7.154335358608435, -78.5059031023823)
        val marker = MarkerOptions().position(coordinates).title("Cine Planet")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    } //Fin cines

    private fun isLocationPermissionGranted() =  ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun enableocation(){
        if (!::map.isInitialized) return
        if(isLocationPermissionGranted()){
          map.isMyLocationEnabled = true
        }else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this,"ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(this,"Para activar la localización ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    override fun onResumeFragments(){
        super.onResumeFragments()
        if(!::map.isInitialized) return
        if(!isLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(this,"Para activar la loca", Toast.LENGTH_SHORT).show()
        }
    }

    //Nos lleva a nuestra ubicación actual
    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Boton pulsado", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Estás en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()
    }
}