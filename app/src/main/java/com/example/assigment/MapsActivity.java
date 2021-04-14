package com.example.assigment;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText edtSearch;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setTitle("MAPS");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btnSearch = findViewById(R.id.btnSearch);
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSearch.getText().toString().equalsIgnoreCase("Trường cao đẳng thực hành FPT Polytechnic Đà Nẵng")){
                    LatLng danang = new LatLng(16.075733,108.1677603);
                    CameraPosition cp = new CameraPosition.Builder().target(danang).zoom(13).build();
                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
                }
                if (edtSearch.getText().toString().equalsIgnoreCase("Trường cao đẳng thực hành FPT Polytechnic Tây Nguyên")){
                    LatLng taynguyen = new LatLng(12.7095077,108.0738884);
                    CameraPosition cp = new CameraPosition.Builder().target(taynguyen).zoom(13).build();
                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
                }
                if (edtSearch.getText().toString().equalsIgnoreCase("Trường cao đẳng thực hành FPT Polytechnic Hồ Chí Minh")){
                    LatLng tphcm = new LatLng(10.7907973,106.6796208);
                    CameraPosition cp = new CameraPosition.Builder().target(tphcm).zoom(13).build();
                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
                }
                if (edtSearch.getText().toString().equalsIgnoreCase("Trường cao đẳng thực hành FPT Polytechnic Cần Thơ")){
                    LatLng cantho = new LatLng(10.0268264,105.7551641);
                    CameraPosition cp = new CameraPosition.Builder().target(cantho).zoom(13).build();
                    mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
                }
            }
        });
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
//        mMap.setOnMapClickListener(MapsActivity.this);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        mMap.setTrafficEnabled(true);
        mMap.setBuildingsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng hanoi = new LatLng(21.0381,105.747);
        mMap.addMarker(new MarkerOptions().position(hanoi).title("Trường cao đẳng thực hành FPT Polytechnic Hà Nội"));
        LatLng danang = new LatLng(16.075733,108.1677603);
        mMap.addMarker(new MarkerOptions().position(danang).title("Trường cao đẳng thực hành FPT Polytechnic Đà Nẵng"));
        LatLng taynguyen = new LatLng(12.7095077,108.0738884);
        mMap.addMarker(new MarkerOptions().position(taynguyen).title("Trường cao đẳng thực hành FPT Polytechnic Tây Nguyên"));
        LatLng tphcm = new LatLng(10.7907973,106.6796208);
        mMap.addMarker(new MarkerOptions().position(tphcm).title("Trường cao đẳng thực hành FPT Polytechnic Hồ Chí Minh"));
        LatLng cantho = new LatLng(10.0268264,105.7551641);
        mMap.addMarker(new MarkerOptions().position(cantho).title("Trường cao đẳng thực hành FPT Polytechnic Cần Thơ"));
        CameraPosition cp = new CameraPosition.Builder().target(hanoi).zoom(15).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
    }
}
