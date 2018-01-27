package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import xcats.app.ui.curiosity.R;

/**
 * Created by Gabriel Trevino on 1/27/18.
 */

public class ScoutMatch4 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout4);}

    public void scoutMatch4Click(View view){
        Intent intent = new Intent(this, ScoutMatch5.class);
        startActivity(intent);

    }

}
