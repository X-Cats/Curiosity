package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch1 extends AppCompatActivity{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout1);
    }

    public void scoutMatch1Click(View view){
        Intent intent = new Intent(this, ScoutMatch2.class);

        Spinner eventSpinner= (Spinner) findViewById(R.id.spinner);
        String[] eventList = getResources().getStringArray(R.array.testTeamList);
        String eventSelected = eventList[eventSpinner.getSelectedItemPosition()];

        intent.putExtra(EXTRA_MESSAGE, eventSelected);
        startActivity(intent);
    }
}
