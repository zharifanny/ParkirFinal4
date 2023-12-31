package com.example.parkirfinal4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.parkirfinal4.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val parkingSpots = listOf(
            LatLng(-7.788775807018222, 110.35624048227851),
            LatLng(-7.778911184554936, 110.36757013264425),
            LatLng(-7.787755339600307, 110.37975808985587),
            LatLng(-7.783163205463476, 110.38868448105312),
            LatLng(-7.780952159972217, 110.40636560207844),
            LatLng(-7.798640197492296, 110.37786981442171),
            LatLng(-7.798470123769661, 110.38525125329636),
            LatLng(-7.794898559625112, 110.392632692171),
            LatLng(-7.807654005813465, 110.40499231075181),
            LatLng(-7.7950686347993905, 110.40722390855112),
            LatLng(-7.8166267155870965, 110.3558643380487),
            LatLng(-7.822068803856488, 110.3666790043069),
            LatLng(-7.821218482243924, 110.37783699330348),
            LatLng(-7.8327827075780805, 110.39345817789867),
            LatLng(-7.834823419908657, 110.40032463266576)
            // Add more LatLng objects for additional parking spots
        )

        val zoomLevel = 14.0f // lower more far, higher nearer

        for (spot in parkingSpots) {
            mMap.addMarker(MarkerOptions().position(spot).title("Parking Spot"))

        }

        if (parkingSpots.isNotEmpty()) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(parkingSpots[0], zoomLevel))
        }


    }

    fun goToRincian(view: View) {
        val intent = Intent(this, RincianPilihan::class.java)
        startActivity(intent)

    }

}
