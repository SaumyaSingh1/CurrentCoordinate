package com.saumya.maps

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationmanager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val locationlistener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                if (location != null) {
                    location.latitude
                    location.longitude

                }

                Log.e("TAG", location?.latitude.toString())
                Log.e("Longtitude", location?.latitude.toString())
                Toast.makeText(applicationContext, location?.latitude.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

            }

            override fun onProviderEnabled(provider: String?) {

            }

            override fun onProviderDisabled(provider: String?) {

            }

        }
        if (ContextCompat.checkSelfPermission(
                baseContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
        }
        btnloc.setOnClickListener {
            locationmanager.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationlistener, null)
        }

    }
}
