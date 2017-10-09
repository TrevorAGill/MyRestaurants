package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;

public class RestaurantsActivity extends AppCompatActivity {
    //1. declare a new variable that will hold the layout's display text element in step 2
    @Bind (R.id.locationTextView) TextView mLocationTextView;
    @Bind (R.id.listView) ListView mListView;
    private String[] restaurants = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food", "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar", "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };
    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups", "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        //2. make the variable hold the layout's display text element, be sure to cast the element as a TextView, since that is what it was mlocationTextView was declared as
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        //create the list view
        mListView = (ListView) findViewById(R.id.listView);
        //create array adapter and assign it to mListView
        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 String restaurant = ((TextView)view).getText().toString();
                                                 Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
//                                                 Log.v("RestaurantsActivity","In the onItemClickListener");
                                             }
                                         });
                Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        //3. change what the display text int the layout says
        mLocationTextView.setText("Here are all the restaurants near: " + location);
//        Log.d("RestaurantsActivity", "In the onCreate method!");
    }
}
