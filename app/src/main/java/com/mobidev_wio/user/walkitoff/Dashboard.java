package com.mobidev_wio.user.walkitoff;

import android.content.Intent;
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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

<<<<<<< HEAD
public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener{
=======
public class Dashboard extends AppCompatActivity
<<<<<<< HEAD
<<<<<<< HEAD
        implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener, StepListener {
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a

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

    SensorManager sensorManager;
    TextView tv_steps;
    boolean running = false;
<<<<<<< HEAD

    TextView date;
=======
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
=======
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView date;
    Calendar cal = new GregorianCalendar(Locale.TAIWAN);
>>>>>>> parent of c0321ad... Too many to mention
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a

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
<<<<<<< HEAD
=======
=======
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
=======
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
>>>>>>> parent of c0321ad... Too many to mention
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */
                Intent add = new Intent(Dashboard.this, MyDiary.class);
                startActivity(add);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a
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
<<<<<<< HEAD

=======
    /*public void setUpUI(){
        date = (TextView) this.findViewById(R.id.date);

        String period;
=======
        /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); */
        //setUpUI();
    }

>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
=======
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setUpUI();
    }

    public void setUpUI(){
        date = (TextView) this.findViewById(R.id.date);
>>>>>>> parent of c0321ad... Too many to mention

        String period;

        if(cal.get(Calendar.HOUR) >= 0 && cal.get(Calendar.HOUR) < 6)
            period = "Midnight Snack";

<<<<<<< HEAD
<<<<<<< HEAD
        date.setText("Time to record your " + period);
    }*/
=======
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a
    protected void onPause()
    {
        super.onPause();
        running = false;
        //to stop detectting steps
        //sensorManager.unregister(this);
    }
<<<<<<< HEAD
=======
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
=======
        else if(cal.get(Calendar.HOUR) >= 6 && cal.get(Calendar.HOUR) < 12)
            period = "Breakfast";
>>>>>>> parent of c0321ad... Too many to mention

        else if(cal.get(Calendar.HOUR) >= 12 && cal.get(Calendar.HOUR) < 18)
            period = "Lunch";

        else
            period = "Dinner";

        date.setText("Time to record your " + period);
    }
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

<<<<<<< HEAD
    /*@Override
=======
    @Override
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
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
    }

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
<<<<<<< HEAD

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
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
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
<<<<<<< HEAD
}
=======
=======
>>>>>>> parent of c0321ad... Too many to mention
}
>>>>>>> c0321ad557c04213966e7d697a6d6dcd87af1ede
>>>>>>> ef8a1d50e7dd51a42c85c89c1289fd0a97ce6e3a
