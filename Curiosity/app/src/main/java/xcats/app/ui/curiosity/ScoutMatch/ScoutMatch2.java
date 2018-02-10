package xcats.app.ui.curiosity.ScoutMatch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch2 extends AppCompatActivity{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    String color;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout2);

        Intent i = getIntent();
        String teamNum = i.getStringExtra(ScoutMatch1.EXTRA_MESSAGE);
        color = i.getStringExtra("color");
        Log.d("Curiosity", ""+ teamNum);

        TextView teamNumView = findViewById(R.id.textView10);
        teamNumView.setText(teamNum);

        RadioButton radioButton7= findViewById(R.id.radioButton7);
        RadioButton radioButton8= findViewById(R.id.radioButton8);
        RadioButton radioButton9= findViewById(R.id.radioButton9);
        RadioButton radioButton10= findViewById(R.id.radioButton10);
        RadioButton radioButton11= findViewById(R.id.radioButton11);
        RadioButton radioButton12= findViewById(R.id.radioButton12);
        RadioButton radioButton13 =  findViewById(R.id.radioButton13);
        RadioButton radioButton14 =  findViewById(R.id.radioButton14);

        if (color.equals("Red")){
            radioButton7.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton8.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton9.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton10.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton11.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton12.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton13.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton14.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));

        }
        else
        {
            radioButton7.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton8.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton9.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton10.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton11.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton12.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton13.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton14.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
        }
    }

    public void scoutMatch2Click(View view){
        Intent intent = new Intent(this, ScoutMatch3.class);
        TextView teamNumView = findViewById(R.id.textView10);
        String teamNum = String.valueOf(teamNumView.getText());


        intent.putExtra("color", color);

        intent.putExtra(EXTRA_MESSAGE, teamNum);
        startActivity(intent);

    }

}
