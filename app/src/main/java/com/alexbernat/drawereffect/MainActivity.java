package com.alexbernat.drawereffect;

import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        final CoordinatorLayout content = (CoordinatorLayout) findViewById(R.id.content);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.open, R.string.close){

            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                content.setTranslationX(slideX);
                content.setScaleX(1 - slideOffset/scaleFactor);
                content.setScaleY(1 - slideOffset/scaleFactor);
            }
        };

        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setDrawerElevation(0f);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Snackbar snackbar = Snackbar.make(content, "Snackbar", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (snackbar.isShown()){
                            snackbar.dismiss();
                        }
                        Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        }, 2000);
    }


}
