package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch3 extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout3);

        Intent i = getIntent();
        String teamNum = i.getStringExtra(ScoutMatch1.EXTRA_MESSAGE);
        Log.d("Curiosity", ""+ teamNum);

        TextView teamNumView = findViewById(R.id.textView14);
        teamNumView.setText(teamNum);
    }

        public void scoutMatch3Click(View view){
        Intent intent = new Intent(this, ScoutMatch4.class);

        TextView teamNumView = findViewById(R.id.textView14);
        String teamNum = String.valueOf(teamNumView.getText());

        intent.putExtra(EXTRA_MESSAGE, teamNum);

        startActivity(intent);

    }


}
