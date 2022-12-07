package com.example.restaurantreview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private RestaurantReview restaurantReview;
    private List<RestaurantReview> savedReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtName = findViewById(R.id.txtName);
        EditText txtFoodRating = findViewById(R.id.txtFoodRating);
        final SeekBar serviceSeekbar = (SeekBar) findViewById(R.id.serviceSeek);
        serviceSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d(TAG, "onProgressChanged() called with: seekBar = [" + seekBar + "], i = [" + i + "], b = [" + b + "]");
                ((TextView) findViewById(R.id.txtServiceRating)).setText("Service Quality Rating : " + i);
                if (restaurantReview == null) {
                    restaurantReview = new RestaurantReview();
                }
                restaurantReview.setServiceQuality(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        RadioGroup radioGroup = findViewById(R.id.radioFoodGroup);
        radioGroup.setOnCheckedChangeListener((radioGroup1, i) -> {
            Log.i(TAG, "onCheckedChanged: " + i);
            if (restaurantReview == null) {
                restaurantReview = new RestaurantReview();
            }
            restaurantReview.setVegOnly(i == R.id.radioVeg);
        });

        ((CheckBox) findViewById(R.id.checkparking)).setOnCheckedChangeListener((compoundButton, b) -> restaurantReview.setHasParking(b));

        findViewById(R.id.btnSave).setOnClickListener(view -> {
            RestaurantReview finalRestaurantView = new RestaurantReview();
            finalRestaurantView.setName(txtName.getText().toString());
            finalRestaurantView.setFoodQuality(Float.parseFloat(txtFoodRating.getText().toString()));
            finalRestaurantView.setHasParking(restaurantReview.isHasParking());
            finalRestaurantView.setVegOnly(restaurantReview.isVegOnly());
            finalRestaurantView.setServiceQuality(restaurantReview.getServiceQuality());

            Log.i(TAG, "onCreate: " + restaurantReview.toString());
            if (savedReview == null) {
                savedReview = new ArrayList<>();
            }
            savedReview.add(finalRestaurantView);
            restaurantReview = null;

            ((Button) findViewById(R.id.btnShow)).setText("Show Review (" + savedReview.size() + ")");
            clearAll();
        });

        findViewById(R.id.btnShow).setOnClickListener(view -> {
            if (savedReview != null && savedReview.size() > 0) {
                String[] listItem = new String[savedReview.size()];
                for (int i = 0; i < savedReview.size(); i++) {
                    final RestaurantReview restaurantReview = savedReview.get(i);
                    listItem[i] = String.format("\n\nName : %s\nFood quality : %s\nService quality : %s\nFood Type: %s\nHas Parking : %s\n\n",
                            restaurantReview.getName(), restaurantReview.getFoodQuality(), restaurantReview.getServiceQuality(),
                            restaurantReview.isVegOnly() ? "Veg" : "Veg & Non-Veg", restaurantReview.isHasParking() ? "Yes" : "No");
                }
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
                ((ListView) findViewById(R.id.listView)).setAdapter(adapter);
                findViewById(R.id.btnView).setVisibility(View.GONE);
                findViewById(R.id.scroll).setVisibility(View.GONE);
                findViewById(R.id.showData).setVisibility(View.VISIBLE);
            } else Toast.makeText(this, "No reviews to show", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnClose).setOnClickListener(view -> {
            findViewById(R.id.btnView).setVisibility(View.VISIBLE);
            findViewById(R.id.scroll).setVisibility(View.VISIBLE);
            findViewById(R.id.showData).setVisibility(View.GONE);
        });
    }

    private void clearAll() {
        ((EditText) findViewById(R.id.txtName)).setText("");
        ((EditText) findViewById(R.id.txtFoodRating)).setText("");
        ((SeekBar) findViewById(R.id.serviceSeek)).setProgress(0);
        ((TextView) findViewById(R.id.txtServiceRating)).setText("Service Quality Rating");
        ((RadioGroup) findViewById(R.id.radioFoodGroup)).clearCheck();
        ((CheckBox) findViewById(R.id.checkparking)).setChecked(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater =  getMenuInflater();
        Inflater.inflate(R.menu.menusettings , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}