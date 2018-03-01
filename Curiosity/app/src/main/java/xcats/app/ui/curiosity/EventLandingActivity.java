package xcats.app.ui.curiosity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import xcats.app.ui.curiosity.ScoutMatch.ScoutMatch1;

/**
 * Created by sithcoder on 1/15/18.
 */

public class EventLandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_landing);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

        Intent i = getIntent();
        String s = i.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if(s != null){
            Log.d("Curiosity", s);
            getSupportActionBar().setTitle(s);
        }
    }

    public void scoutMatchClick(View view){

        Intent intent = new Intent(this, ScoutMatch1.class);
        startActivity(intent);
    }

    public void analyzeMatchClick(View view){

        Intent intent = new Intent(this, Analyze1.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (true) {

        } else {
            super.onBackPressed();
        }
    }
}
