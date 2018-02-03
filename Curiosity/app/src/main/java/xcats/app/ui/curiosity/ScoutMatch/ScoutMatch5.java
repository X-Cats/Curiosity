package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import xcats.app.ui.curiosity.EventLandingActivity;
import xcats.app.ui.curiosity.R;

/**
 * Created by Gabriel Trevino on 1/27/18.
 */

public class ScoutMatch5 extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout5);

        Intent i = getIntent();
        String teamNum = i.getStringExtra(ScoutMatch1.EXTRA_MESSAGE);
        Log.d("Curiosity", ""+ teamNum);

        TextView teamNumView = findViewById(R.id.textView31);
        teamNumView.setText(teamNum);
    }


    public void scoutMatch5Click(View view){
        Intent intent = new Intent(this, EventLandingActivity.class);

        TextView teamNumView = findViewById(R.id.textView31);
        String teamNum = String.valueOf(teamNumView.getText());

        intent.putExtra(EXTRA_MESSAGE, teamNum);
        startActivity(intent);

    }
}
