package com.example.openstreetmapspractice;


import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface VolleyCallBack {
    void onSuccess(Context context, ArrayList<Monumento> monumentos);
}
