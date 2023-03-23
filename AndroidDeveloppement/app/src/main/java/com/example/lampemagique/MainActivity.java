package com.example.lampemagique;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lampemagique.Model.DCouleur;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {
    private Button button, button2, button3, button4, button5, button6, display;
    private DCouleur couleur;
    private int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onCreate called");

        button = findViewById(R.id.PRouge);
        button2 = findViewById(R.id.PVert);
        button3 = findViewById(R.id.PBlue);
        button4 = findViewById(R.id.MRouge);
        button5 = findViewById(R.id.MVert);
        button6 = findViewById(R.id.MBlue);
        display = findViewById(R.id.Display);

        // Create a new DCouleur object or retrieve the saved one (persistence courte) --
        if (savedInstanceState != null) {
            couleur = (DCouleur) savedInstanceState.getSerializable("couleur");
        } else {
            couleur = new DCouleur();
        }

        //Get the intent That was send by the  accctivity PageAcc And get the color from that intent
        String color = getIntent().getStringExtra("color");

        // Set the initial display color based on the selected color from Intent (Intent is sent from EcranAcc)
        switch (color) {
            case "red":
                couleur.setRedValue(255);
                break;
            case "black":
                couleur.setRedValue(0);
                couleur.setGreenValue(0);
                couleur.setBlueValue(0);
                break;
            case "gray":
                couleur.setRedValue(128);
                couleur.setGreenValue(128);
                couleur.setBlueValue(128);
                break;
            default:
                break;
        }

        // Set the background color of the display to the current color
        currentColor = couleur.getRGBValue();
        display.setBackgroundColor(currentColor);

        // Set the same event listener for all the buttons
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
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
        // Save the current DCouleur object
        outState.putSerializable("couleur", couleur);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("MainActivity", "onRestoreInstanceState called");
        // Retrieve the saved DCouleur object and update the display color
        couleur = (DCouleur) savedInstanceState.getSerializable("couleur");
        currentColor = couleur.getRGBValue();
        display.setBackgroundColor(currentColor);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.PRouge:
                    couleur.AddToRedvalue();
                    break;
                case R.id.PVert:
                    couleur.AddToGreenValue();
                    break;
                case R.id.PBlue:
                    couleur.AddToBlueValue();
                    break;
                case R.id.MRouge:
                    couleur.SubstractFromRedvalue();
                    break;
                case R.id.MVert:
                    couleur.SubstractFromGreenValue();
                    break;
                case R.id.MBlue:
                    couleur.SubstractFromBlueValue();
                    break;
                default:
                    break;
            }
            // Update the display color and save the current color value
            currentColor = couleur.getRGBValue();
            display.setBackgroundColor(currentColor);
        }
    };
}