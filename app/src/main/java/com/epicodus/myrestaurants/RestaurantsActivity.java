package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantsActivity extends AppCompatActivity {
    //1. declare a new variable that will hold the layout's display text element in step 2
    private TextView mlocationTextView;
    private ListView mListView;
    private String[] restaurants = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Tilt", "Andina",
            "Lardo", "Portland City Grill", "Pho Hung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        //2. make the variable hold the layout's display text element, be sure to cast the element as a TextView, since that is what it was mlocationTextView was declared as
        mlocationTextView = (TextView) findViewById(R.id.locationTextView);
        //create the list view
        mListView = (ListView) findViewById(R.id.listView);
        //create array adapter and assign it to mListView
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 String restaurant = ((TextView)view).getText().toString();
                                                 Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
                                             }
                                         });
                Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        //3. change what the display text int the layout says
        mlocationTextView.setText("Here are all the restaurants near: " + location);
    }
}
