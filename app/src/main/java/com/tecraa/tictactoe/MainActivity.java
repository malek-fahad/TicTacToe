package com.tecraa.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.tecraa.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //binding.mainLogoIV.animate().translationY(-1000f);
        //binding.mainAppTitleTV.animate().translationY(1000f);

        binding.mainLogoIV.animate().translationY(0f).setDuration(2000);
        binding.mainAppTitleTV.animate().translationY(0f).setDuration(2000);

        new Handler().postDelayed(() -> buttonVisible(),2500);

        binding.gameStartBtn.setOnClickListener(v->{
            openGamePage();
        });




    }

    private void openGamePage() {
        startActivity(new Intent(MainActivity.this,GameActivity.class));
        finish();
    }


    private void buttonVisible() {
        binding.gameStartBtn.setVisibility(View.VISIBLE);
    }
}