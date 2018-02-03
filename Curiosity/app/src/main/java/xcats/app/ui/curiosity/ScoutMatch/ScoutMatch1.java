package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ToggleButton;


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

        Spinner teamNumSpinner= (Spinner) findViewById(R.id.spinner);
        String[] teamNumList = getResources().getStringArray(R.array.testTeamList);
        String teamNum = teamNumList[teamNumSpinner.getSelectedItemPosition()];

        ToggleButton findColor = findViewById(R.id.toggleButton3);
        String allianceColor = String.valueOf(findColor.getText());
        intent.putExtra("color", allianceColor);

        intent.putExtra(EXTRA_MESSAGE, teamNum);
        startActivity(intent);
    }

    public void colorChange (View view) {
        int id = view.getId();
        String clickedButtonName = view.getResources().getResourceName(id);
        Log.d("ScoutMatch1", "The current button name is" + clickedButtonName);
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

        Log.d("ScoutMatch1", "The current color is: " + color);

        if (color == -65536){
            view.setBackgroundColor(getResources().getColor(R.color.blue));
            pairButton.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.red));
            pairButton.setBackgroundColor(getResources().getColor(R.color.blue));
        }


    }

}
