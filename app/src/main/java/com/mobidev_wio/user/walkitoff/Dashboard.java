package com.mobidev_wio.user.walkitoff;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Dashboard extends AppCompatActivity
<<<<<<< HEAD
        implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener, StepListener {

    TextView date;
    private TextView TvSteps;
    private TextView Calburn;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "";
    private static final String TEXT_CAL_BURN = "";
    private int numSteps;
    private int calBurn;
    Calendar cal = new GregorianCalendar(Locale.TAIWAN);
=======
        implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener{

    SensorManager sensorManager;
    TextView tv_steps;
    boolean running = false;
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
<<<<<<< HEAD

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);
        Calburn = findViewById(R.id.cal_burned);
        TvSteps = findViewById(R.id.step_remaining);

        numSteps = 0;
        calBurn = 0;
        sensorManager.registerListener(Dashboard.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
=======
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede

        tv_steps = (TextView) findViewById(R.id.step_remaining);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        FloatingActionButton addMeal = (FloatingActionButton) findViewById(R.id.add_meal);
        addMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(Dashboard.this, MyDiary.class);
                startActivity(add);
            }
        });

        FloatingActionButton about = (FloatingActionButton) findViewById(R.id.about_us);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

<<<<<<< HEAD
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //setUpUI();
    }


    protected void onResume() {
        super.onResume();

    }

    protected void onPause() {
        super.onPause();
    }
    /*public void setUpUI(){
        date = (TextView) this.findViewById(R.id.date);

        String period;
=======
        /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); */
        //setUpUI();
    }

>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede

    protected void onResume()
    {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if(countSensor != null)
        {
            sensorManager.registerListener(this, countSensor, sensorManager.SENSOR_DELAY_UI);
        }
        else{
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }

<<<<<<< HEAD
        date.setText("Time to record your " + period);
    }*/
=======
    protected void onPause()
    {
        super.onPause();
        running = false;
        //to stop detectting steps
        //sensorManager.unregister(this);
    }
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

     /*@Override
   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            Intent navigate = new Intent(this, this.getClass());
            startActivity(navigate);
        } else if (id == R.id.nav_diary) {
            Intent navigate = new Intent(this, MyDiary.class);
            startActivity(navigate);
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
<<<<<<< HEAD
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
=======
        if(running)
        {
            tv_steps.setText(String.valueOf(event.values[0]));
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
        }
    }

    @Override
<<<<<<< HEAD
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS+ numSteps);
        if (numSteps % 20 == 0)
        {
              calBurn++;
              Calburn.setText(TEXT_CAL_BURN+ calBurn);
        }

                                }
}
=======
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
