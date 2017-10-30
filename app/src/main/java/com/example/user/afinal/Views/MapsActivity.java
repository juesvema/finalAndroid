package com.example.user.afinal.Views;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.user.afinal.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng plaza = new LatLng(6.243054, -75.576358);
        mMap.addMarker(new MarkerOptions().position(plaza).title("Plaza Mayor"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(plaza));

        mMap.setMinZoomPreference(12.0f);
        //mMap.setMaxZoomPreference(14.0f);

        LatLng estadio = new LatLng(6.257045, -75.591117);
        mMap.addMarker(new MarkerOptions().position(estadio).title("Estadio Atanasio Girardot"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(estadio));

        LatLng jardín_botánico = new LatLng(6.270811, -75.564107);
        mMap.addMarker(new MarkerOptions().position(jardín_botánico).title("Jardín Botánico"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jardín_botánico));

        LatLng macarena = new LatLng(6.249672, -75.580506);
        mMap.addMarker(new MarkerOptions().position(macarena).title("Plaza de Toros la Macarena"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(macarena));
    }
}
