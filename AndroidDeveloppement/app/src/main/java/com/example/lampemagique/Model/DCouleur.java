package com.example.lampemagique.Model;

import android.graphics.Color;

import java.io.Serializable;

public class DCouleur implements Serializable {


    int colorChange = 16;


    private int RedValue;
    private int GreenValue;
    private int BlueValue;


    public DCouleur() {
        this.RedValue = 0;
        this.GreenValue = 0;
        this.BlueValue = 0;

    }

    public int getRedvalue() {
        return this.RedValue;
    }

    public int getGreenValue() {
        return this.GreenValue;
    }

    public int getBlueValue() {





        return this.BlueValue;


    }

    public int getRGBValue() {
        return Color.argb(255,RedValue,GreenValue,BlueValue);
    }


    public void AddToRedvalue(){
        if(RedValue<255) {
            RedValue += colorChange;
            RedValue = RedValue>255?255:RedValue;
        }
    }

    public void AddToGreenValue(){
        if(GreenValue<255) {
            GreenValue += colorChange;
            GreenValue = GreenValue>255?255:GreenValue;
        }
    }

    public void AddToBlueValue(){
        if(BlueValue<255) {
            BlueValue += colorChange;
            BlueValue = BlueValue>255?255:BlueValue;
        }
    }

    public void SubstractFromRedvalue(){
        if(RedValue > 0) {
            RedValue -= colorChange;
            RedValue = RedValue<0?0:RedValue;
        }
    }


    public void SubstractFromGreenValue(){
        if(GreenValue > 0) {
            GreenValue -= colorChange;
            GreenValue = GreenValue<0?0:GreenValue;
        }
    }

    public void SubstractFromBlueValue(){
        if(BlueValue > 0) {
            BlueValue -= colorChange;
            BlueValue = BlueValue<0?0:BlueValue;
        }
    }


    public void setRedValue(int i) {
        this.RedValue = i;

    }

    public void setGreenValue(int i) {
        this.GreenValue = i;
    }

    public void setBlueValue(int i) {
        this.BlueValue = i;
    }
}
