package com.example.login_signup.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.login_signup.Engine.RecyclerView.Adapter;
import com.example.login_signup.Engine.RecyclerView.RecyclerViewMethod;
import com.example.login_signup.Engine.Utils;
import com.example.login_signup.Modles.Model.Kala;
import com.example.login_signup.Modles.Model.Product;
import com.example.login_signup.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Utils util;
    private ImageSlider imgSliderMainActivity;
    private RecyclerView rvTitleMainActivity;
    private final Product[] products = new Product[12];
    private final Kala[] kalas = new Kala[3];
    private final String urlMobileTitle = "https://cdn.pocket-lint.com/r/s/1200x/assets/images/120309-phones-buyer-s-guide-best-smartphones-2020-the-top-mobile-phones-available-to-buy-today-image1-eagx1ykift.jpg";
    private final String urlLaptopTitle = "https://cdn.pocket-lint.com/r/s/1200x/assets/images/120309-phones-buyer-s-guide-best-smartphones-2020-the-top-mobile-phones-available-to-buy-today-image1-eagx1ykift.jpg";
    private final String urlCameraTitle = "https://cdn.pocket-lint.com/r/s/1200x/assets/images/120309-phones-buyer-s-guide-best-smartphones-2020-the-top-mobile-phones-available-to-buy-today-image1-eagx1ykift.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FillItem();
        setContentView(R.layout.activity_main);
        util = new Utils(this, MainActivity.this);
        setupView();
        showImageSlider(imgSliderMainActivity);
       // clickItemImageSlider(imgSliderMainActivity);
        btn1.setOnClickListener(view -> {
            util.setSharedPreferences("isLogin", false);
            util.goToPage(SplashActivity.class);
            finish();
        });
        rvTitleMainActivity(util);

    }


    private void rvTitleMainActivity(Utils util) {
        util.addRecyclerView(R.id.rvTitleMainActivity, new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true),
                new Adapter(this, R.layout.recyclerview_tile, 3, new RecyclerViewMethod() {
                    @Override
                    public void onItem(Adapter.ViewHolder holder, int position, View itemView) {
                        Picasso.get().load(kalas[position].getAddressImage()).into((ImageView) itemView.findViewById(R.id.imgRecyclerViewTitle));
                        ((TextView) itemView.findViewById(R.id.txtRecyclerViewTitle)).setText(kalas[position].getTitle());
                    }
                }));
    }

//    private void clickItemImageSlider(ImageSlider imageSlider) {
//        imageSlider.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemSelected(int i) {
//                Toast.makeText(MainActivity.this, imageSlider.g+"", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    private void showImageSlider(ImageSlider imageSlider) {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.mobils1, getString(R.string.mobile)));
        slideModels.add(new SlideModel(R.drawable.laptop, getString(R.string.laptop)));
        slideModels.add(new SlideModel(R.drawable.mobils1, getString(R.string.camera)));
        imgSliderMainActivity.setImageList(slideModels, true);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Toast.makeText(MainActivity.this, slideModels.get(i)+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void FillItem() {
        kalas[2] = new Kala(urlCameraTitle, getString(R.string.camera));
        kalas[1] = new Kala(urlLaptopTitle, getString(R.string.laptop));
        kalas[0] = new Kala(urlMobileTitle, getString(R.string.mobile));

    }

    private void setupView() {

        btn1 = findViewById(R.id.btn1);
        imgSliderMainActivity = findViewById(R.id.imgSliderMainActivity);

    }
}