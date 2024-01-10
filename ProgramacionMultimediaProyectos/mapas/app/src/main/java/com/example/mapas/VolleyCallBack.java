package com.example.mapas;

import android.content.Context;

import java.util.ArrayList;

public interface VolleyCallBack {
    void onSuccess(Context context, ArrayList<Monumento> monumentos);
}
