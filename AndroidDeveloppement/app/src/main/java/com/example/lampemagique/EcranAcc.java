package com.example.lampemagique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lampemagique.Model.DCouleur;

public class EcranAcc extends AppCompatActivity {

    private Button RedDisplay, BlackDisplay, GrayDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecranacc);

        RedDisplay = findViewById(R.id.InitRed);
        BlackDisplay = findViewById(R.id.InitBlack);
        GrayDisplay = findViewById(R.id.InitGray);


        RedDisplay.setOnClickListener(listener);
        BlackDisplay.setOnClickListener(listener);
        GrayDisplay.setOnClickListener(listener);


    }




    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.InitRed:
                    OpenMainActivityRedDisplay();

                    break;
                case R.id.InitBlack:
                    OpenMainActivityBlackDisplay();
                    break;
                case R.id.InitGray:
                    OpenMainActivityGrayDisplay();
                    break;
                default:
                    break;
            }

        }
    };


    public void OpenMainActivityRedDisplay(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("color", "red");
        startActivity(intent);


    }

    public void OpenMainActivityBlackDisplay(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("color", "black");
        startActivity(intent);


    }

    public void OpenMainActivityGrayDisplay(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("color", "gray");
        startActivity(intent);


    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity", "onSaveInstanceState called");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("MainActivity", "onRestoreInstanceState called");

    }




}