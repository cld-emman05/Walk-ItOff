package com.mobidev_wio.user.walkitoff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by user on 14/03/2018.
 */

public class Food {
    private final static String TAG = "Food";

    private String name, description;
    private int calories;

    public Food(String name, String description, int calories) {
        this.name = name;
        this.description = description;
        this.calories = calories;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public int getCalories()
    {
        return this.calories;
    }

    public String getCaloriesString()
    {
        return Integer.toString(this.calories);
    }
}
