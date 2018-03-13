package com.mobidev_wio.user.walkitoff;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddFood extends AppCompatActivity {
    private final static String TAG = "AddRestaurantActivity";

    public final static int ADD_ACTIVITY_CODE = 1;
    public final static int EDIT_ACTIVITY_CODE = 2;

    public final static int ADD_SUCCESS = 1;
    public final static int ADD_FAILED = -1; //not really used.

    public final static String REQUEST_CODE_KEY = "REQUEST_CODE_KEY";
    public final static String FOOD_NAME_KEY = "FOOD_NAME_KEY";
    public final static String FOOD_DESC_KEY = "FOOD_DESC_Key";
    public final static String CALORIES_KEY = "CALORIES_KEY";
    public final static String EDIT_MODEL_INDEX_KEY = "EDIT_MODEL_INDEX_KEY";

    private EditText nameText;
    private EditText descText;
    private EditText caloriesText;

    private int editModelIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        this.nameText = this.findViewById(R.id.food_name_text);
        this.descText = this.findViewById(R.id.food_desc_text);
        this.caloriesText = this.findViewById(R.id.calories_text);

        this.setupButtons();
        this.inputEditData();
    }

    private void setupButtons() {
        Button cancelBtn = this.findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFood.this.finish();
            }
        });

        Button submitBtn = this.findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AddFood.this.validateInput()) {
                    AddFood.this.bundleData();
                    AddFood.this.finish();
                }
            }
        });
    }

    private void inputEditData() {
        Intent intent = this.getIntent();
        int code = intent.getIntExtra(REQUEST_CODE_KEY, 1);
        if(code == EDIT_ACTIVITY_CODE) {
            //load input data
            this.nameText.setText(intent.getStringExtra(FOOD_NAME_KEY));
            this.descText.setText(intent.getStringExtra(FOOD_DESC_KEY));
            this.caloriesText.setText(Integer.toString(intent.getIntExtra(CALORIES_KEY, 0)));
            this.editModelIndex = intent.getIntExtra(EDIT_MODEL_INDEX_KEY, -1);
        }
    }

    private boolean validateInput() {
        if(this.nameText.getText().toString().length() == 0) {
            //dismiss keyboard so prompt can be seen.
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.nameText.getWindowToken(), 0);
            this.displayPrompt("Name cannot be blank.");
            return false;
        }

        if(this.descText.getText().toString().length() == 0) {
            //dismiss keyboard so prompt can be seen.
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.descText.getWindowToken(), 0);
            this.displayPrompt("Description cannot be blank.");
            return false;
        }

        //check calories
        int calories = -1;
        if(this.caloriesText.getText().toString().length() > 0) {
            calories = Integer.parseInt(AddFood.this.caloriesText.getText().toString());
        }

        if(calories <= 0 || calories > 10000) {
            //dismiss keyboard so prompt can be seen.
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(caloriesText.getWindowToken(), 0);
            this.displayPrompt("Weight should be between 1 and 50.");
            return false;
        }

        return true;
    }

    /*
     * Bundles the data into an intent and sends it back to the previous activity who called it.
     */
    private void bundleData() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(FOOD_NAME_KEY, this.nameText.getText().toString());
        resultIntent.putExtra(FOOD_DESC_KEY, this.descText.getText().toString());
        resultIntent.putExtra(CALORIES_KEY, Integer.parseInt(this.caloriesText.getText().toString()));
        resultIntent.putExtra(EDIT_MODEL_INDEX_KEY, this.editModelIndex);
        this.setResult(ADD_SUCCESS, resultIntent);
    }

    private void displayPrompt(String message) {
        Snackbar snackbar = Snackbar.make(AddFood.this.findViewById(R.id.add_food_layout), message,3000);

        TextView snackbarActionTextView =  snackbar.getView().findViewById( android.support.design.R.id.snackbar_text );
        snackbarActionTextView.setTextSize(20);
        snackbarActionTextView.setTypeface(snackbarActionTextView.getTypeface(), Typeface.BOLD);

        snackbar.show();
    }
}
