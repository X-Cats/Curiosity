package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

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

        TextView teamNumView = findViewById(R.id.teamNumberScout3);
        teamNumView.setText(teamNum);

        styleButtons();
    }

    private void styleButtons() {

    }

    public void scoutMatch3Click(View view){
        Intent intent = new Intent(this, ScoutMatch4.class);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        ElegantNumberButton acquireGroundButton = findViewById(R.id.acquireGroundButton);
        ElegantNumberButton acquireExchangeButton = findViewById(R.id.acquireExchangeButton);
        ElegantNumberButton ownSwitchCounter = findViewById(R.id.ownSwitchSuccessCounter);
        //ElegantNumberButton ownSwitchFailureCounter = findViewById(R.id.ownSwitchFailureCounter);
        ElegantNumberButton scaleCounter = findViewById(R.id.scaleSuccessCounter);
        //ElegantNumberButton scaleFailureCounter = findViewById(R.id.scaleFailureCounter);
        ElegantNumberButton oppSwitchCounter = findViewById(R.id.oppSwitchSuccessCounter);
        //ElegantNumberButton oppSwitchFailureCounter = findViewById(R.id.oppSwitchFailureCounter);
        ElegantNumberButton exchangedCounter = findViewById(R.id.cubesExchangedCounter);

        editor.putInt("cubesAcquiredGround", Integer.parseInt(acquireGroundButton.getNumber()));
        editor.putInt("cubesAcquiredExchange",Integer.parseInt(acquireExchangeButton.getNumber()));
        editor.putInt("cubesOwnSwitch",Integer.parseInt(ownSwitchCounter.getNumber()));
        editor.putInt("cubesOwnSwitchFail", 0);
        editor.putInt("cubesScale",Integer.parseInt(scaleCounter.getNumber()));
        editor.putInt("cubesScaleFail",0);
        editor.putInt("cubesOppSwitch",Integer.parseInt(oppSwitchCounter.getNumber()));
        editor.putInt("cubesOppSwitchFail",0);
        editor.putInt("cubesExchanged",Integer.parseInt(exchangedCounter.getNumber()));

        editor.commit();
        startActivity(intent);

    }


}
