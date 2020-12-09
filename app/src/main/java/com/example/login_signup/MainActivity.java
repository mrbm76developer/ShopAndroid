package com.example.login_signup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Utils util;
    private ImageSlider imgSliderMainActivity;
    private ImageView imgMobileMainActivity, imgLaptopMainActivity, imgCameraMainActivity;
    private ListView lvMobileMainActivity, lvLaptopMainActivity, lvCameraMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        showImageSlider();
        clickItemImageSlider(imgSliderMainActivity);
        lvCameraMainActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lvLaptopMainActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lvMobileMainActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn1.setOnClickListener(view -> {
            util.setSharedPreferences("isLogin", false);
            util.goToPage(MainActivity.this, SplashActivity.class);
            finish();
        });


    }

    private void clickItemImageSlider(ImageSlider imageSlider) {
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                SlideModel sm = null;
                if (sm.getTitle().equals(getString(R.string.mobile))) {
                    util.goToPage(MainActivity.this, PageBransActivity.class);
                } else if (sm.getTitle().equals(getString(R.string.laptop))) {
                    util.goToPage(MainActivity.this, PageBransActivity.class);
                } else if (sm.getTitle().equals(getString(R.string.camera))) {
                    util.goToPage(MainActivity.this, PageBransActivity.class);
                }
            }
        });

    }

    private void showImageSlider() {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.mobils1, getString(R.string.mobile)));
        slideModels.add(new SlideModel(R.drawable.laptop, getString(R.string.laptop)));
        slideModels.add(new SlideModel(R.drawable.mobils1, getString(R.string.camera)));
        imgSliderMainActivity.setImageList(slideModels, true);
    }

    private void setupView() {
        util = new Utils(MainActivity.this);
        btn1 = findViewById(R.id.btn1);
        imgSliderMainActivity = findViewById(R.id.imgSliderMainActivity);
        imgMobileMainActivity = findViewById(R.id.imgMobileMainActivity);
        imgLaptopMainActivity = findViewById(R.id.imgLaptopMainActivity);
        imgCameraMainActivity = findViewById(R.id.imgCameraMainActivity);
        lvMobileMainActivity = findViewById(R.id.lvMobileMainActivity);
        lvLaptopMainActivity = findViewById(R.id.lvLaptopMainActivity);
        lvCameraMainActivity = findViewById(R.id.lvCameraMainActivity);
    }
}