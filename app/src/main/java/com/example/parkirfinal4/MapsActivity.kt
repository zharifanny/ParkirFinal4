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
            LatLng(-7.796240934704353, 110.36399469167071),
            LatLng(-7.813029139214178, 110.37699449156794),
            LatLng(-7.822085153080336, 110.3646777884106),
            LatLng(-7.813879477515826, 110.36566484109207),
            LatLng(-7.83352180983347, 110.38227307888698)
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

    fun goToPilihan(view: View) {
        val intent = Intent(this, PilihanParkirActivity::class.java)
        startActivity(intent)

    }

}
