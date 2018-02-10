package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import xcats.app.ui.curiosity.R;

/**
 * Created by Gabriel Trevino on 1/27/18.
 */

public class ScoutMatch4 extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout4);

        Intent i = getIntent();
        String teamNum = i.getStringExtra(ScoutMatch1.EXTRA_MESSAGE);
        color = i.getStringExtra("color");
        Log.d("Curiosity", ""+ teamNum);

        TextView teamNumView = findViewById(R.id.textView27);
        teamNumView.setText(teamNum);

        RadioButton radioButton15= findViewById(R.id.radioButton15);
        RadioButton radioButton16= findViewById(R.id.radioButton16);
        RadioButton radioButton17= findViewById(R.id.radioButton17);
        //RadioButton radioButton18= findViewById(R.id.radioButton18);
        RadioButton radioButton19= findViewById(R.id.radioButton19);
        RadioButton radioButton20 =  findViewById(R.id.radioButton20);
        RadioButton radioButton21 =  findViewById(R.id.radioButton21);
        RadioButton radioButton22 =  findViewById(R.id.radioButton22);
        RadioButton radioButton23 =  findViewById(R.id.radioButton23);
        RadioButton radioButton24 =  findViewById(R.id.radioButton24);
        RadioButton radioButton25 =  findViewById(R.id.radioButton25);


        if (color.equals("Red")){
            radioButton15.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton16.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton17.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            //radioButton18.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton19.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton20.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton21.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton22.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton23.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton24.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton25.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));

        }
        else
        {
            radioButton15.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton16.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton17.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            //radioButton18.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton19.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton20.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton21.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton22.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton23.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton24.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton25.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));

        }
    }

    public void scoutMatch4Click(View view){
        Intent intent = new Intent(this, ScoutMatch5.class);

        TextView teamNumView = findViewById(R.id.textView27);
        String teamNum = String.valueOf(teamNumView.getText());


        intent.putExtra("color", color);

        intent.putExtra(EXTRA_MESSAGE, teamNum);

        startActivity(intent);

    }

}
