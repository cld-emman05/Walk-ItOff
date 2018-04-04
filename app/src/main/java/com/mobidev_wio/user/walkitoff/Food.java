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

<<<<<<< HEAD
    public String getName()
    {
<<<<<<< HEAD
        return name;
=======
        return this.name;
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
    }

    public String getDescription()
    {
<<<<<<< HEAD
        return description;
=======
        return this.description;
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
    }

    public int getCalories()
    {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
>>>>>>> parent of c0321ad... Too many to mention
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a
        return calories;
=======
        return this.calories;
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
    }

    public String getCaloriesString() {
        return Integer.toString(this.calories);
    }
}
