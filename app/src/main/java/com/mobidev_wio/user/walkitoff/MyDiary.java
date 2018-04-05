package com.mobidev_wio.user.walkitoff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDiary extends AppCompatActivity {
    // the containers of consumptions made by the user
    private ArrayList<Food> bf_collection = new ArrayList<Food>();
    private ArrayList<Food> lunch_collection = new ArrayList<Food>();
    private ArrayList<Food> dinner_collection = new ArrayList<Food>();

    // Recyclerviews containing collections
    private RecyclerView bf_list;
    private RecyclerView lunch_list;
    private RecyclerView dinner_list;

    // adapters for RecyclerViews
    private BreakfastAdapter bfAdapter;
    private LunchAdapter lAdapter;
    private DinnerAdapter dAdapter;

    // the buttons for adding consumption
    private Button bf_btn;
    private Button lunch_btn;
    private Button dinner_btn;

    // calorie sum to be computed
    private int bf_cal_sum;
    private int lunch_cal_sum;
    private int dinner_cal_sum;

    // calorie sum to be displayed
    private TextView breakfast_cal;
    private TextView lunch_cal;
    private TextView dinner_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diary);

        setupRecyclerView();
        computeCalorieSum();
        setUpButtons();
    }

    private void setupRecyclerView() {
        this.bf_list = this.findViewById(R.id.breakfast_list);
        this.bfAdapter = new BreakfastAdapter(this.bf_collection);
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        this.bf_list.setLayoutManager(recyclerLayoutManager);
        this.bf_list.setItemAnimator(new DefaultItemAnimator());
        this.bf_list.setAdapter(this.bfAdapter);

        /* this.lunch_list = this.findViewById(R.id.lunch_list);
        this.lAdapter = new LunchAdapter(this.lunch_collection);
        recyclerLayoutManager = new LinearLayoutManager(this);
        this.lunch_list.setLayoutManager(recyclerLayoutManager);
        this.lunch_list.setItemAnimator(new DefaultItemAnimator());
        this.lunch_list.setAdapter(this.lAdapter);

        this.dinner_list = this.findViewById(R.id.dinner_list);
        this.dAdapter = new DinnerAdapter(this.dinner_collection);
        recyclerLayoutManager = new LinearLayoutManager(this);
        this.dinner_list.setLayoutManager(recyclerLayoutManager);
        this.dinner_list.setItemAnimator(new DefaultItemAnimator());
        this.dinner_list.setAdapter(this.dAdapter); */
    }

    private void computeCalorieSum() {
        this.breakfast_cal = (TextView) this.findViewById(R.id.bf_cal_sum);
        /* this.lunch_cal = (TextView) this.findViewById(R.id.lunch_cal_sum);
        this.dinner_cal = (TextView) this.findViewById(R.id.dinner_cal_sum); */

        for (int i = 0; i < this.bf_collection.size(); i++)
            this.bf_cal_sum += this.bf_collection.get(i).getCalories();

        this.breakfast_cal.setText(Integer.valueOf(this.bf_cal_sum));

        /* for (int i = 0; i < this.lunch_collection.size(); i++) {
            this.lunch_cal_sum += this.lunch_collection.get(i).getCalories();
            this.lunch_cal.setText(new Integer(this.lunch_cal_sum).toString() + " cal");
        }

        for (int i = 0; i < this.dinner_collection.size(); i++) {
            this.dinner_cal_sum += this.dinner_collection.get(i).getCalories();
            this.dinner_cal.setText(new Integer(this.dinner_cal_sum).toString() + " cal");
        }

        int sum = this.bf_cal_sum + this.lunch_cal_sum + this.dinner_cal_sum;

        this.t_cons = (TextView) this.findViewById(R.id.total_cal_sum);
        t_cons.setText(new Integer(sum).toString() + " cal");
        } */
    }

    private void setUpButtons() {
        this.bf_btn = this.findViewById(R.id.add_bf);
       /* this.lunch_btn = this.findViewById(R.id.add_lunch);
        this.dinner_btn = this.findViewById(R.id.add_dinner); */

        this.bf_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_bf = new Intent(MyDiary.this, AddFood.class);
                startActivityForResult(add_bf, AddFood.ADD_ACTIVITY_CODE);
            }
        });

       /* this.lunch_btn = this.findViewById(R.id.add_lunch);

        this.lunch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_l = new Intent(MyDiary.this, AddFood.class);
                startActivityForResult(add_l, AddFood.ADD_ACTIVITY_CODE);
            }
        });
        this.dinner_btn = this.findViewById(R.id.add_dinner);

        this.dinner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_d = new Intent(MyDiary.this, AddFood.class);
                startActivityForResult(add_d, AddFood.ADD_ACTIVITY_CODE);
            }
        }); */
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AddFood.ADD_ACTIVITY_CODE) {
            if (resultCode == AddFood.ADD_SUCCESS) {
                //for demonstration purposes, result code is used to check if adding is successful. In this scenario,
                //there is no chance for the add activity to fail.
                String name = data.getStringExtra(AddFood.FOOD_NAME_KEY);
                String desc = data.getStringExtra(AddFood.FOOD_DESC_KEY);
                int cal = data.getIntExtra(AddFood.CALORIES_KEY, 0);

                Food model = new Food(name, desc, cal);
                //for breakfast
                this.bf_collection.add(model);

                //refresh the adapter
                this.bfAdapter.notifyDataSetChanged();
            }
        }
    }
}
