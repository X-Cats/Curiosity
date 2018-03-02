package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import xcats.app.ui.curiosity.R;

/**
 * Created by Gabriel Trevino on 1/27/18.
 */

public class ScoutMatch4 extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    String color;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout4);

        sharedPreferences = this.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE);

        String teamNum = sharedPreferences.getString("teamNumber","0");
        color = sharedPreferences.getString("allianceColor","Red");
        Log.d("Curiosity", ""+ teamNum + color);

        TextView teamNumView = findViewById(R.id.teamNumScout4);
        teamNumView.setText(teamNum);

        styleRadioButtons();

    }

    private void styleRadioButtons() {
        RadioButton radioButton15= findViewById(R.id.climbRadioButton1);
        RadioButton radioButton16= findViewById(R.id.climbRadioButton2);
        RadioButton radioButton17= findViewById(R.id.climbRadioButton3);
        RadioButton radioButton19= findViewById(R.id.climbRadioButton4);
        RadioButton radioButton20 =  findViewById(R.id.climbRadioButton5);
        RadioButton radioButton21 =  findViewById(R.id.climbRadioButton6);
        RadioButton radioButton22 =  findViewById(R.id.climbRadioButton7);
        RadioButton radioButton23 =  findViewById(R.id.climbRadioButton8);


        if (color.equals("Red")){
            radioButton15.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton16.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton17.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton19.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton20.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton21.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton22.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            radioButton23.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));

        }
        else
        {
            radioButton15.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton16.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton17.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton19.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton20.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton21.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton22.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));
            radioButton23.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.blue)));

        }
    }

    public void scoutMatch4Click(View view){
        Intent intent = new Intent(this, ScoutMatch5.class);

        TextView teamNumView = findViewById(R.id.teamNumScout4);
        String teamNum = String.valueOf(teamNumView.getText());

        SharedPreferences.Editor editor = sharedPreferences.edit();

        RadioGroup climbRadioGroup = findViewById(R.id.climbRadioGroup);

        String climb = "No";
        String climbAssist = "No";

        switch (climbRadioGroup.getCheckedRadioButtonId()) {
            case R.id.climbRadioButton1:
            case R.id.climbRadioButton2:
                break;
            case R.id.climbRadioButton3:
            case R.id.climbRadioButton4:
            case R.id.climbRadioButton5:
                climb = "Yes";
                break;
            case R.id.climbRadioButton6:
                break;
            case R.id.climbRadioButton7:
            case R.id.climbRadioButton8:
                climbAssist = "Yes";
                break;
            default:
                break;
        }

        editor.putString("climb", climb);
        editor.putString("climbAssist", climbAssist);

        editor.commit();

        startActivity(intent);

    }

}
