package xcats.app.ui.curiosity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Gabriel Trevino on 1/27/18.
 */

public class Analyze3 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze3);
    }

    public void analyzeh3Click(View view){
        Intent intent = new Intent(this, EventLandingActivity.class);
        startActivity(intent);

    }
}
