package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantsActivity extends AppCompatActivity {
    //1. declare a new variable that will hold the layout's display text element in step 2
    private TextView mlocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        //2. make the variable hold the layout's display text element, be sure to cast the element as a TextView, since that is what it was mlocationTextView was declared as
        mlocationTextView = (TextView) findViewById(R.id.locationTextView);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        //3. change what the display text int the layout says
        mlocationTextView.setText("All restaurants near " + location);
    }
}
