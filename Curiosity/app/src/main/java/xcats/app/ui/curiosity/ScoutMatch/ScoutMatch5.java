package xcats.app.ui.curiosity.ScoutMatch;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import xcats.app.ui.curiosity.EventLandingActivity;
import xcats.app.ui.curiosity.R;

/**
 * Created by Gabriel Trevino on 1/27/18.
 */

public class ScoutMatch5 extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout5);

        sharedPreferences = this.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE);

        String teamNum = sharedPreferences.getString("teamNumber","0");

        TextView teamNumView = findViewById(R.id.textView31);
        teamNumView.setText(teamNum);
    }


    public void scoutMatch5Click(View view){

        writeToFile(getApplicationContext());

        Intent intent = new Intent(this, EventLandingActivity.class);
        startActivity(intent);

    }

    private void writeToFile(Context context) {

        String dataToWrite = getComposedStringFromSharedPrefs();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm:ss aa");
        String time = dateformat.format(c.getTime());

        String fileName  = "scoutingApp" + sharedPreferences.getString("userName","unknown") + time + ".txt";

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 43);

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile();
        File file = new File("/mnt/sdcard/", fileName);

        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(dataToWrite.getBytes());
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String getComposedStringFromSharedPrefs() {

        String cumulativeString = "";
        Map <String, ?> sharedPrefValues = sharedPreferences.getAll();

        cumulativeString += (sharedPrefValues.get("teamNumber").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("matchNumber").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("allianceColor").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("blueSwitchPos").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("redSwitchPos").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("scalePos").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("driverPos").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("robotPos").toString()) + ",";

        cumulativeString += (sharedPrefValues.get("autoBaseline").toString()) + ",";

        cumulativeString += (sharedPrefValues.get("autoCubesSwitch").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("autoCubesSwitchFail").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("autoCubesScale").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("autoCubesScaleFail").toString()) + ",";

        cumulativeString += (sharedPrefValues.get("cubesOwnSwitch").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("cubesOwnSwitchFail").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("cubesScale").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("cubesScaleFail").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("cubesOppSwitch").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("cubesOppSwitchFail").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("cubesExchanged").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("climb").toString()) + ",";
        cumulativeString += (sharedPrefValues.get("climbAssist").toString()) + ",";

        return cumulativeString;
    }
}
