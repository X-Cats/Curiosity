package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch2 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout2);

        Intent i = getIntent();
        String teamNum = i.getStringExtra(ScoutMatch1.EXTRA_MESSAGE);
        Log.d("Curiosity", ""+ teamNum);

        TextView teamNumView = findViewById(R.id.textView10);
        teamNumView.setText(teamNum);
    }

    public void scoutMatch2Click(View view){
        Intent intent = new Intent(this, ScoutMatch3.class);
        startActivity(intent);

    }

}
