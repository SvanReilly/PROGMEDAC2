package com.example.practica9_1_php;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface VolleyCallBack {
    void onSuccess(Context context, ArrayList<Monumento> monumentos);
}
