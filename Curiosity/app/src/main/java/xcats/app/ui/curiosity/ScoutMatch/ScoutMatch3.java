package xcats.app.ui.curiosity.ScoutMatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import xcats.app.ui.curiosity.R;

/**
 * Created by xcats on 1/20/18.
 */

public class ScoutMatch3 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout3);}


        public void scoutMatch3Click(View view){
        Intent intent = new Intent(this, ScoutMatch4.class);
        startActivity(intent);

    }


}
