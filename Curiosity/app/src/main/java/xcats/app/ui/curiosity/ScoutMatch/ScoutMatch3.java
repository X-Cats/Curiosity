package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch3 extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    String color;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout3);

        sharedPreferences = this.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE);

        String teamNum = sharedPreferences.getString("teamNumber","0");
        color = sharedPreferences.getString("allianceColor","Red");

        Log.d("Curiosity", ""+ teamNum + color);

        TextView teamNumView = findViewById(R.id.textView14);
        teamNumView.setText(teamNum);

        RadioButton radioButton18= findViewById(R.id.radioButton18);

        if (color.equals("Red"))
        {
            radioButton18.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
        }

        else
        {
            radioButton18.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
        }

    }

        public void scoutMatch3Click(View view){
        Intent intent = new Intent(this, ScoutMatch4.class);

        TextView teamNumView = findViewById(R.id.textView14);
        String teamNum = String.valueOf(teamNumView.getText());

        intent.putExtra("color", color);

        intent.putExtra(EXTRA_MESSAGE, teamNum);

        startActivity(intent);

    }


}
