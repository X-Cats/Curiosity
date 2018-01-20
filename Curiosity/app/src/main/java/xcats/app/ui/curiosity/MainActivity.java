package xcats.app.ui.curiosity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginClick(View view){
        Intent intent = new Intent(this, EventLandingActivity.class);

        Spinner eventSpinner= (Spinner) findViewById(R.id.spinnerEvent);
        String[] eventList = getResources().getStringArray(R.array.testEventList);
        String eventSelected = eventList[eventSpinner.getSelectedItemPosition()];

        intent.putExtra(EXTRA_MESSAGE, eventSelected);
        startActivity(intent);
    }
}
