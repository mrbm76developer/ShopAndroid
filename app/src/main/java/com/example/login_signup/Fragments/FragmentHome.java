package com.example.login_signup.Fragments;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FragmentHome extends Fragment {
    private final Kala[] kalas = new Kala[3];
    private final Product[] products = new Product[8];
    private ImageSlider imgSliderFragmentHome;
    private RecyclerView rvTitleHomeFragment, rvMostSeenFragmentHome, rvLatestProductFragmentHome;
    private Toolbar toolbarFragmentHome;
    private final Context context;

    public FragmentHome(Context context) {
        this.context = context;
    }

    public static FragmentHome newInstance(Context context) {
        return new FragmentHome(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        FillItem();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setupView(view);
        Utils util = new Utils(getActivity(), getActivity());
        showImageSlider(imgSliderFragmentHome);
        setRvTitleFragmentHome(util);
        setRvMostSeen(util);
        setRvLatestProduct(util);
        return view;
    }


    private void setRvTitleFragmentHome(Utils util) {
        util.addRecyclerView(rvTitleHomeFragment, new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true),
                new Adapter(getActivity(), R.layout.recyclerview_tile, 3, new RecyclerViewMethod() {
                    @Override
                    public void onItem(Adapter.ViewHolder holder, int position, View itemView) {
                        Picasso.get().load(kalas[position].getAddressImage()).into((ImageView) itemView.findViewById(R.id.imgRecyclerViewTitle));
                        ((TextView) itemView.findViewById(R.id.txtRecyclerViewTitle)).setText(kalas[position].getTitle());
                    }
                }));
    }

    private void setRvMostSeen(Utils util) {
        final Product[] product1 = this.products.clone();
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return Long.compare(t1.getDate().getTime(), product.getDate().getTime());
            }
        });
        util.addRecyclerView(rvMostSeenFragmentHome, new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true),
                new Adapter(getActivity(), R.layout.recycler_view_most_seen, 8, (holder, position, itemView) -> {
                    ImageView imgRvItemMobileFragmentHome = itemView.findViewById(R.id.imgRvItemMobileFragmentHome);
                    TextView txtPriceMain = itemView.findViewById(R.id.txtRvPriceMainFragmentHome);
                    TextView txtNameKala = itemView.findViewById(R.id.txtRvtNameKalaFragmentHome);
                    TextView txtNameProduct = itemView.findViewById(R.id.txtRvNameProductFragmentHome);
                    TextView txtOffPrice = itemView.findViewById(R.id.txtRvOffPriceFragmentHome);
                    TextView txtFinalPrice = itemView.findViewById(R.id.txtRvFinalPriceFragmentHome);
                    txtPriceMain.setPaintFlags(txtPriceMain.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    txtNameKala.setText(products[position].getKala().getTitle() + " :");
                    txtNameProduct.setText(products[position].getName());
                    txtOffPrice.setText(products[position].getOff() + "%");
                    long totalPrice = (long) products[position].getPrice() - ((long) products[position].getPrice() * (long) products[position].getOff());
                    txtFinalPrice.setText(totalPrice + "");
                    txtPriceMain.setText(products[position].getPrice() + "");
                    Picasso.get().load(products[position].getImageAddress()).into(imgRvItemMobileFragmentHome);


                }));
    }

    private void setRvLatestProduct(Utils util) {
        final Product[] product = this.products.clone();
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return Long.compare(t1.getDate().getTime(), product.getDate().getTime());
            }
        });
        util.addRecyclerView(rvLatestProductFragmentHome, new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true),
                new Adapter(getActivity(), R.layout.recycler_view_latest_product, 8, (holder, position, itemView) -> {
                    ImageView imgRvItemMobileFragmentHome = itemView.findViewById(R.id.imgRvLatestProductItemMobileFragmentHome);
                    TextView txtPriceMain = itemView.findViewById(R.id.txtRvLatestProductPriceMainFragmentHome);
                    TextView txtNameKala = itemView.findViewById(R.id.txtRvLatestProductNameKalaFragmentHome);
                    TextView txtNameProduct = itemView.findViewById(R.id.txtRvLatestProductNameProductFragmentHome);
                    TextView txtOffPrice = itemView.findViewById(R.id.txtRvLatestProductOffPriceFragmentHome);
                    TextView txtFinalPrice = itemView.findViewById(R.id.txtRvLatestProductFinalPriceFragmentHome);
                    txtPriceMain.setPaintFlags(txtPriceMain.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    txtNameKala.setText(products[position].getKala().getTitle() + " :");
                    txtNameProduct.setText(products[position].getName());
                    txtOffPrice.setText(products[position].getOff() + "%");
                    long totalPrice = (long) products[position].getPrice() - ((long) products[position].getPrice() * (long) products[position].getOff());
                    txtFinalPrice.setText(totalPrice + "");
                    txtPriceMain.setText(products[position].getPrice() + "");
                    Picasso.get().load(products[position].getImageAddress()).into(imgRvItemMobileFragmentHome);


                }));
    }


    private void showImageSlider(ImageSlider imageSlider) {
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        String urlMobileSlider = "https://cdn.pocket-lint.com/r/s/1200x/assets/images/124434-phones-news-buyer-s-guide-best-android-phones-2020-image12-f8jqeoinot.jpg";
        slideModels.add(new SlideModel(urlMobileSlider, getString(R.string.mobile)));
        String urlLaptopSlider = "https://images.squarespace-cdn.com/content/v1/569706fb5dc6def15843549d/1598012438800-CJHZELMO6QWC0K4B7WZ3/ke17ZwdGBToddI8pDm48kO7Eo6tFk5HvtZpmqPxQWgp7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UfOgY6xFgOD6e8Hk4s2PeEKB9Kc5UxGySR6cbfyGWYQEBsc6d8xABtQMYHwnG515BA/Best+Laptops+Money+Can+Buy+in+2020+%28August+2020+Updated+List%29.JPG?format=1000w";
        slideModels.add(new SlideModel(urlLaptopSlider, getString(R.string.laptop)));
        String urlCameraSlider = "https://cdn.mos.cms.futurecdn.net/tTy74Zvzrt4QYKrZLZFGm9-320-80.jpg";
        slideModels.add(new SlideModel(urlCameraSlider, getString(R.string.camera)));
        imgSliderFragmentHome.setImageList(slideModels, true);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Toast.makeText(getActivity(), slideModels.get(i) + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void FillItem() {
        //Kala
        String urlCameraTitle = "https://ddo0fzhfvians.cloudfront.net/uploads/icons/png/13507429761582793670-512.png";
        kalas[2] = new Kala(urlCameraTitle, getString(R.string.camera));
        String urlLaptopTitle = "https://ddo0fzhfvians.cloudfront.net/uploads/icons/png/14042731251582793666-512.png";
        kalas[1] = new Kala(urlLaptopTitle, getString(R.string.laptop));
        String urlMobileTitle = "https://ddo0fzhfvians.cloudfront.net/uploads/icons/png/19971090021582793662-512.png";
        kalas[0] = new Kala(urlMobileTitle, getString(R.string.mobile));
        //Mobile Samsung
        products[0] = new Product("Galaxy A01", 3545000, 20, (byte) 20, kalas[0], new Date((new Date().getTime() - 100)), "https://cellucity.co.za/wp-content/uploads/2020/04/Samsung-Galaxy-A01-Black.jpg");
        products[1] = new Product("Galaxy A51", 9525000, 10, (byte) 42, kalas[0], new Date((new Date().getTime() - 200)), "https://www.did.ie/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/m/sm-a515fzkveuu_1.jpg");
        //Mobile Xiaomi
        products[2] = new Product("Redmi 8A", 4600000, 50, (byte) 42, kalas[0], new Date((new Date().getTime() - 50)), "https://mihamrah.com/wp-content/uploads/2019/10/Xiaomi-Redmi-8A-600x600.jpg");
        products[3] = new Product("Redmi Note 8", 5900000, 51, (byte) 15, kalas[0], new Date((new Date().getTime() - 150)), "https://www.gizmochina.com/wp-content/uploads/2019/09/Xiaomi-Redmi-Note-8-1-500x500.jpg");
        //Mobile Apple
        products[4] = new Product("Iphone 12 Pro", 42000000, 35, (byte) 60, kalas[0], new Date((new Date().getTime() - 500)), "https://www.telstra.com.au/content/dam/tcom/lego/2020/plans-devices/mobiles/iphone-12-pro/shared-iphone-12-pro-pacific-blue-01-900x1200.jpg");
        products[5] = new Product("Iphone 11 Pro Max", 60000000, 42, (byte) 25, kalas[0], new Date((new Date().getTime() - 1000)), "https://www.gizmochina.com/wp-content/uploads/2019/09/Apple-iPhone-11-Pro-Max-1-500x500.jpg");
        //Mobile Huawei
        products[6] = new Product("P30 Lite", 7200000, 100, (byte) 30, kalas[0], new Date((new Date().getTime() - 160)), "https://images-na.ssl-images-amazon.com/images/I/61ichz%2BYnFL._AC_SX425_.jpg");
        products[7] = new Product("Y9 Prime 2019", 5600000, 88, (byte) 10, kalas[0], new Date((new Date().getTime() - 2000)), "https://s.mobile.ir/Static/cache/prd/38604_0_0.jpg");


    }

    private void setupView(View view) {

        //  btn1 = findViewById(R.id.btn1);
        imgSliderFragmentHome = view.findViewById(R.id.imgSliderFragmentHome);
        toolbarFragmentHome = view.findViewById(R.id.toolbarFragmentHome);
        rvTitleHomeFragment = view.findViewById(R.id.rvTitleFragmentHome);
        rvMostSeenFragmentHome = view.findViewById(R.id.rvMostSeenFragmentHome);
        rvLatestProductFragmentHome = view.findViewById(R.id.rvLatestProductFragmentHome);

    }
}