package xcats.app.ui.curiosity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        String[] eventList = getResources().getStringArray(R.array.testEventList);
        int eventPosition = eventSpinner.getSelectedItemPosition();

        if (eventPosition == 0){

            Toast.makeText(this, "Please select an event from the list!", Toast.LENGTH_LONG).show();
            return null;
        }

        return eventList[eventSpinner.getSelectedItemPosition()];
    }
}
