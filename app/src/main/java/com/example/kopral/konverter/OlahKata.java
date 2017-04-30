package com.example.kopral.konverter;

import android.util.Log;

public class OlahKata {
    private String katac;
    private char[] tmpKata;

    public OlahKata(String katax) {
        this.tmpKata = katax.toCharArray();
    }

    public boolean olahKataNG(String katax) {
        String[] pengater = new String[]{"ny", "m", "n", "ng"};
        String pattern2 = "";
        String pattern1 = "";
        String tempPattern = "";
        String findStr = "";
        boolean ngFirst = false;
        boolean ngTrue = false;
        String str = "r";
        String str2 = "";
        str = "l";
        str2 = "";
        Log.d("OLAHKATA", katax);
        String kata = katax.replace(".", "");//.replace(" ", "").replace(" ", "");
        Log.d("OLAHKATA", "kata1: " + kata);
        int startPickup = kata.indexOf("ng") + 2;
        if (startPickup == 2) {
            startPickup = kata.indexOf("ng", 2) + 2;
            ngFirst = true;
        }
        Log.d("OLAHKATA", "kata2: " + kata);
        Log.d("OLAHKATA", "katalength: " + kata.length());
        Log.d("OLAHKATA", "startPickup: " + startPickup);

        if (startPickup <= 2) {
            return false;
        }

        pattern2 = kata.substring(startPickup, kata.length());
        findStr = pattern2;

        if (pattern2.equals("")) {
            return false;
        }
        pattern1 = kata.substring(0, startPickup);
        String hrfDepan = pattern2.substring(0, 1);
        if (pattern1.equals(pattern2)) {
            return true;
        }
        if (ngFirst) {
            tempPattern = pattern1.substring(2, pattern1.length());
            if (new StringBuilder(String.valueOf(hrfDepan)).append(tempPattern).toString().equals(pattern2)) {
                return true;
            }
            return false;
        }
        hrfDepan = pattern2.substring(0, 1);
        int i = 0;
        while (true) {
            int length = pengater.length;
            if (i >= length) {
                return ngTrue;
            }
            if (pattern1.replace(pengater[i], hrfDepan).equals(pattern2)) {
                ngTrue = true;
            }
            i++;
        }
    }
}
