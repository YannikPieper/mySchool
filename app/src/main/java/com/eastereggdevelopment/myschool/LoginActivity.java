package com.eastereggdevelopment.myschool;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Choose();
    }

    public void Choose()
    {
    final Button buttonTeacher = (Button) this.findViewById(R.id.buttonTeacher);

    buttonTeacher.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {

            Intent intent1 = new Intent(getBaseContext(), uebersicht.class); //Create a new service to start the selfie countdown
            startActivity(intent1);
        }

    });

    final Button buttonStudent = (Button) this.findViewById(R.id.buttonStudent);

    buttonStudent.setOnClickListener(new View.OnClickListener() {

         public void onClick(View v) {

                Intent intent1 = new Intent(getBaseContext(), studentUebersicht.class); //Create a new service to start the selfie countdown
                startActivity(intent1);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
