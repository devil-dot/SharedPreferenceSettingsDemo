package com.kmtstudio.sharedpreferencesettingsdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearLayout = findViewById(R.id.linearLayoutID);

        if (loadColor()!=getResources().getColor(R.color.teal_200)) {

            linearLayout.setBackgroundColor(loadColor());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.aquamarineColor) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.aquamarine));
            storeColor(getResources().getColor(R.color.aquamarine));

        } else if (item.getItemId()==R.id.maroonColor) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.maroon));
            storeColor(getResources().getColor(R.color.maroon));

        }else if (item.getItemId()==R.id.chartreuseColor) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.chartreuse));
            storeColor(getResources().getColor(R.color.chartreuse));

        }else if (item.getItemId()==R.id.lawnGreenColor) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.lawnGreen));
            storeColor(getResources().getColor(R.color.lawnGreen));

        }

        return super.onOptionsItemSelected(item);
    }

    public void storeColor(int color) {

        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor",color);
        editor.apply();

    }

    private int loadColor() {

        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor",Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("myColor",getResources().getColor(R.color.teal_200));

        return selectedColor;
    }
}