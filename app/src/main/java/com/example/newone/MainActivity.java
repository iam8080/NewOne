package com.example.newone;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.transition.Transition;
//
//import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.newone.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.time.LocalDate;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MaterialToolbar toolbar;
DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    BottomSheetBehavior bottomSheetBehavior;
    TextView greetings;
    CircularImageView Civ;
    LinearLayout linearLayout;
    Button button;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replacefragment(new HomeFragment());
        Civ = findViewById(R.id.civ);
        //BlurView


//BlurView

        Civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProfileFragment myProfileFragment = new MyProfileFragment();

                myProfileFragment.show(getSupportFragmentManager(), "fragement");

            }
        });

        //Navigationdrawer
        Toolbar toolbar = findViewById(R.id.toolbar1);
        frameLayout = findViewById(R.id.main_framelayout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.white));

 /*     CircularImageView circularImageView =findViewById(R.id.Civ);
  

        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);


            }
        });*/

     /*   MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.toolbar1);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rrrr);
        Bitmap blurredBitmap = Blurbuilder.blur( this, originalBitmap );
        materialToolbar.setBackground(new BitmapDrawable(getResources(), blurredBitmap)); */

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homenav:
                    replacefragment(new HomeFragment());

               /*     FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.setCustomAnimations();*/
                    break;

                case R.id.Favnav:
                    replacefragment(new FavFragment());
                    break;
                case R.id.settingsnav:
                    replacefragment(new SettingsFragment());
                    break;
            }

            return true;


        });
    }

    public void replacefragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelay, fragment);
        fragmentTransaction.commit();

    }


}