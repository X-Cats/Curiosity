package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ToggleButton;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch1 extends AppCompatActivity{

    final static String tbaKey = "U0rx6iHZYLFx1InrycvsfhYuxgRQPORyDM07f4Ekz2fHfftxJWAbIpzMD9SIl1sd";
    final static String tbaHeader = "X-TBA-Auth-Key";

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    SharedPreferences sharedPreferences;

    List<String> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout1);

        sharedPreferences = this.getSharedPreferences(
            getString(R.string.app_name), Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String jsonTeamList = sharedPreferences.getString("jsonTeamList","empty");

        if (jsonTeamList.equalsIgnoreCase("empty")) {
            blueAllianceTeamRetrieval();
        }
        else {

            Type type = new TypeToken<List<String>>() {}.getType();
            teamList = gson.fromJson(jsonTeamList, type);

            updateTeamSpinner();
        }

    }

    private void blueAllianceTeamRetrieval() {
        // TODO: Add code for getting a list of teams and setting them to spinner
        String eventCode = sharedPreferences.getString("selectedEventCode",null);

        if (eventCode == null) {
            return;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .header(tbaHeader, tbaKey)
            .url("https://www.thebluealliance.com/api/v3/event/2018"+eventCode+"/teams/simple")
            .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()){
                    throw new IOException("Unexpected code " + response);
                }
                else {
                    teamList = parseResponse(response.body().byteStream());
                    Log.d("ScoutMatch1: List Size", "There are this many teams at the event: " + teamList.size());
                    Log.d("ScoutMatch1: Team List", teamList.toString());

                    ScoutMatch1.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateTeamSpinner();

                        }
                    });

                    updateSavedTeamInfo();
                }
            }
        });

    }

    private void updateSavedTeamInfo() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String jsonTeamList = gson.toJson(teamList);
        editor.putString("jsonTeamList",jsonTeamList);
        editor.commit();
    }

    private List<String> parseResponse(InputStream response) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(response, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<String> readMessagesArray(JsonReader reader) throws IOException {
        List<String> messages = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readMessage(reader));
        }
        reader.endArray();
        return messages;
    }

    public String readMessage(JsonReader reader) throws IOException {

        String teamNumber = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("team_number")) {
                teamNumber = String.valueOf(reader.nextInt());

            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return teamNumber;
    }

    private void updateTeamSpinner() {
        Spinner eventSpinner = findViewById(R.id.teamListSpinner);

        ArrayAdapter<String> teamListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamList);
        teamListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        eventSpinner.setAdapter(teamListAdapter);
    }

    @Override
    protected void onResume(){
        super.onResume();

        RadioButton radioButton =  findViewById(R.id.radioButton);
        RadioButton radioButton2 =  findViewById(R.id.radioButton2);
        RadioButton radioButton3 =  findViewById(R.id.radioButton3);
        RadioButton radioButton4 =  findViewById(R.id.radioButton4);
        RadioButton radioButton5 =  findViewById(R.id.radioButton5);
        RadioButton radioButton6 =  findViewById(R.id.radioButton6);

        radioButton.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.graey)));
        radioButton2.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.graey)));
        radioButton3.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.graey)));
        radioButton4.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.graey)));
        radioButton5.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.graey)));
        radioButton6.setButtonTintList(ColorStateList.valueOf(this.getColor(R.color.graey)));
    }

    public void scoutMatch1Click(View view){
        Intent intent = new Intent(this, ScoutMatch2.class);

        Spinner teamNumSpinner= (Spinner) findViewById(R.id.teamListSpinner);
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
