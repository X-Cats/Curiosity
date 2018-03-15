package xcats.app.ui.curiosity.ScoutMatch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch2 extends AppCompatActivity{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    String color;
    SharedPreferences sharedPreferences;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout2_relative);

        sharedPreferences = this.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE);

        String teamNum = sharedPreferences.getString("teamNumber","0");
        color = sharedPreferences.getString("allianceColor","Red");
        Log.d("Curiosity", ""+ teamNum + color);

        TextView teamNumView = findViewById(R.id.scout2TeamNum);
        teamNumView.setText(teamNum);

        styleRadioButtons();
    }

    private void styleRadioButtons() {

        RadioButton radioButton7= findViewById(R.id.autoBaselineSuccessRadioButton);
        RadioButton radioButton8= findViewById(R.id.autoBaselineNoAttRadioButton);
        RadioButton radioButton9= findViewById(R.id.autoBaselineFailedRadioButton);
        RadioButton radioButton10= findViewById(R.id.autoPowerCubeSuccessRadioButton);
        RadioButton radioButton11= findViewById(R.id.autoPowerCubeNoAttRadioButton);
        RadioButton radioButton12= findViewById(R.id.autoPowerCubeFailedRadioButton);
        RadioButton radioButton13 =  findViewById(R.id.autoPowerCubeScaleRadioButton);
        RadioButton radioButton14 =  findViewById(R.id.autoPowerCubeSwitchRadioButton);

        if (color.equals("Red")){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                radioButton7.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));

                radioButton8.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
                radioButton9.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
                radioButton10.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
                radioButton11.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
                radioButton12.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
                radioButton13.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
                radioButton14.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.red)));
            }
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
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
    }

    public void scoutMatch2Click(View view){

        Intent intent = new Intent(this, ScoutMatch3.class);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        Button redSwitchBottom = findViewById(R.id.buttonRedSwitchBottom);
        Button scaleBottom = findViewById(R.id.buttonScaleBottom);
        Button blueSwitchBottom = findViewById(R.id.buttonBlueSwitchBottom);

        RadioGroup autoBaselineRadioGroup = findViewById(R.id.autoBaselineRadioGroup);
        RadioGroup autoPowerCubeRadioGroup = findViewById(R.id.autoPowerCubeRadioGroup);
        int checkedBaseline = autoBaselineRadioGroup.getCheckedRadioButtonId();
        int checkedPowerCube = autoPowerCubeRadioGroup.getCheckedRadioButtonId();

        if(checkedBaseline == -1
                || checkedPowerCube == -1 ){
            Toast.makeText(getApplicationContext(),
                    "Please make sure to select an option for each field!",Toast.LENGTH_SHORT).show();
            return;
        }

        RadioGroup autoPowerCubeLocationRadioGroup = findViewById(R.id.autoPowerCubeLocationRadioGroup);
        int checkedPowerCubeLocation = autoPowerCubeLocationRadioGroup.getCheckedRadioButtonId();

        if(checkedPowerCube != R.id.autoPowerCubeNoAttRadioButton &&
                checkedPowerCubeLocation == -1) {
            Toast.makeText(getApplicationContext(),
                    "Please select where the power cube was (attempted to be?) placed!",Toast.LENGTH_SHORT).show();
            return;
        }

        String redSwitchPos = buttonColorDeterminator(redSwitchBottom);
        String scalePos = buttonColorDeterminator(scaleBottom);
        String blueSwitchPos = buttonColorDeterminator(blueSwitchBottom);

        String autoBaseline = baselineInfo(checkedBaseline);
        String autoPowerCube = powerCubeInfo(checkedPowerCube);
        String autoPowerCubeLocation = powerCubeLocation(checkedPowerCubeLocation);

        String autoCubesSwitch ="0";
        String autoCubesSwitchFail = "0";
        String autoCubesScale = "0";
        String autoCubesScaleFail = "0";

        if (autoPowerCubeLocation.equals("Switch") && autoBaseline.equals("Success")) {
            autoCubesSwitch = "1";
        } else if (autoPowerCubeLocation.equals("Switch") && autoBaseline.equals("Failure")) {
            autoCubesSwitchFail = "1";
        }

        if (autoPowerCubeLocation.equals("Scale") && autoBaseline.equals("Success")) {
            autoCubesScale= "1";
        } else if (autoPowerCubeLocation.equals("Scale") && autoBaseline.equals("Failure")) {
            autoCubesScaleFail = "1";
        }

        editor.putString("redSwitchPos", redSwitchPos);
        editor.putString("scalePos", scalePos);
        editor.putString("blueSwitchPos", blueSwitchPos);

        editor.putString("autoBaseline", autoBaseline);

        editor.putString("autoCubesSwitch", autoCubesSwitch);
        editor.putString("autoCubesSwitchFail", autoCubesSwitchFail);
        editor.putString("autoCubesScale", autoCubesScale);
        editor.putString("autoCubesScaleFail", autoCubesScaleFail);

        /*editor.putString("autoBaseline",autoBaseline);
        editor.putString("autoPowerCube", autoPowerCube);
        editor.putString("autoPowerCubeLocation", autoPowerCubeLocation);*/

        editor.commit();

        startActivity(intent);

    }

    private String baselineInfo(int checkedBaseline) {
        switch (checkedBaseline) {
            case R.id.autoBaselineSuccessRadioButton:
                return "Success";
            case R.id.autoBaselineNoAttRadioButton:
                return "No Attempt";
            case R.id.autoBaselineFailedRadioButton:
                return "Failure";
            default:
                return "";
        }
    }

    private String powerCubeInfo(int checkedPowerCube) {
        switch (checkedPowerCube) {
            case R.id.autoPowerCubeSuccessRadioButton:
                return "Success";
            case R.id.autoPowerCubeNoAttRadioButton:
                return "No Attempt";
            case R.id.autoPowerCubeFailedRadioButton:
                return "Failure";
            default:
                return "";
        }
    }

    private String powerCubeLocation(int checkedPowerCubeLocation) {
        switch (checkedPowerCubeLocation) {
            case R.id.autoPowerCubeSwitchRadioButton:
                return "Switch";
            case R.id.autoPowerCubeScaleRadioButton:
                return "Scale";
            default:
                return "";
        }
    }

    private String buttonColorDeterminator(View bottomButton) {

        ColorDrawable allianceColor = new ColorDrawable();
        boolean blueReversedPerspective = false;

        Drawable bottomButtonState = bottomButton.getBackground();
        int bottomButtonColor = 0;
        if (bottomButtonState instanceof ColorDrawable)
            bottomButtonColor = ((ColorDrawable) bottomButtonState).getColor();

        switch (color) {
            case "Red":
                allianceColor.setColor(getResources().getColor(R.color.red));
                break;
            case "Blue":
                allianceColor.setColor(getResources().getColor(R.color.blue));
                blueReversedPerspective = true;
                break;
            default:
                break;
        }
        if (blueReversedPerspective) {
            if (allianceColor.getColor() == bottomButtonColor) {
                return "L";
            } else {
                return "R";
            }
        } else {
            if (allianceColor.getColor() == bottomButtonColor) {
                return "R";
            } else {
                return "L";
            }
        }



    }

    public void colorChange (View view) {
        int id = view.getId();
        String clickedButtonName = view.getResources().getResourceName(id);
        Button pairButton = null;

        if (clickedButtonName.equals("xcats.app.ui.curiosity:id/buttonRedSwitchTop"))
            pairButton = (Button) findViewById(R.id.buttonRedSwitchBottom);
        else if (clickedButtonName.equals("xcats.app.ui.curiosity:id/buttonScaleTop"))
            pairButton = (Button) findViewById(R.id.buttonScaleBottom);
        else if (clickedButtonName.equals("xcats.app.ui.curiosity:id/buttonBlueSwitchTop"))
            pairButton = (Button) findViewById(R.id.buttonBlueSwitchBottom);
        else if (clickedButtonName.equals("xcats.app.ui.curiosity:id/buttonRedSwitchBottom"))
            pairButton = (Button) findViewById(R.id.buttonRedSwitchTop);
        else if (clickedButtonName.equals("xcats.app.ui.curiosity:id/buttonScaleBottom"))
            pairButton = (Button) findViewById(R.id.buttonScaleTop);
        else if (clickedButtonName.equals("xcats.app.ui.curiosity:id/buttonBlueSwitchBottom"))
            pairButton = (Button) findViewById(R.id.buttonBlueSwitchTop);

        int color = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();

        if (color == -65536){
            view.setBackgroundColor(getResources().getColor(R.color.blue));
            pairButton.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.red));
            pairButton.setBackgroundColor(getResources().getColor(R.color.blue));
        }


    }

}
