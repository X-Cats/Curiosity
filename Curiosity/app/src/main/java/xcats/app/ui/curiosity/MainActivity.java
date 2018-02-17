package xcats.app.ui.curiosity;

import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;

public class MainActivity extends AppCompatActivity
{

    final String tbaKey = "U0rx6iHZYLFx1InrycvsfhYuxgRQPORyDM07f4Ekz2fHfftxJWAbIpzMD9SIl1sd";
    final String tbaHeader = "X-TBA-Auth-Key";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    List<String> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueAllianceEventRetrieval();
    }

    private void blueAllianceEventRetrieval() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .header(tbaHeader, tbaKey)
            .url("http://www.thebluealliance.com/api/v3/team/frc191/events/2018/simple")
            .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()){
                    throw new IOException("Unexpected code " + response);
                }
                else{
                    eventList = parseResponse(response.body().byteStream());
                    Log.d("parsedEventList",eventList.toString());

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateEventSpinner();
                        }
                    });
                }
            }
        });
    }


    private void updateEventSpinner() {
        Spinner eventSpinner = findViewById(R.id.spinnerEvent);
        ArrayAdapter<String> eventAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, eventList);
        eventAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        eventSpinner.setAdapter(eventAdapter);
    }

    public void loginClick(View view){
        Intent intent = new Intent(this, EventLandingActivity.class);

        String userName = userNameValidation();

        if (userName == null)
            return;

        String eventSelected = eventValidation();

        if( eventSelected == null)
            return;

        intent.putExtra(EXTRA_MESSAGE, eventSelected);
        startActivity(intent);
    }

    public String userNameValidation(){

        EditText userNameEditText = findViewById(R.id.editTextUser);
        String userName = String.valueOf(userNameEditText.getText());

        if (userName.isEmpty()){
            Toast.makeText(this, "Please enter your username!", Toast.LENGTH_LONG).show();
            return null;
        }

        return userName;
    }

    public String eventValidation(){

        Spinner eventSpinner= (Spinner) findViewById(R.id.spinnerEvent);
        int eventPosition = eventSpinner.getSelectedItemPosition();

        if (eventPosition == 0){

            Toast.makeText(this, "Please select an event from the list!", Toast.LENGTH_LONG).show();
            return null;
        }

        return eventList.get(eventSpinner.getSelectedItemPosition());
    }

    private List<String> parseResponse(InputStream response) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(response,"UTF-8"));
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

        String eventName = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                eventName = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return eventName;
    }
}
