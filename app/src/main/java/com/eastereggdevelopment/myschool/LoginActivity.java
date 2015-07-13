package com.eastereggdevelopment.myschool;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eastereggdevelopment.myschool.R;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class LoginActivity extends Activity {
    EditText username,password,res_email,code;
    Button login,cont,cont_code,cancel,cancel1;
    String usernametxt,passwordtxt,email_res_txt,code_txt;
    List<NameValuePair> params;
    SharedPreferences pref;
    Dialog reset;
    ServerRequest sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sr = new ServerRequest();

        username = (EditText)findViewById(R.id.Username); //Get Access to the different views of the activity_login.xml file
        password = (EditText)findViewById(R.id.Password);
        login = (Button)findViewById(R.id.LoginButton);

        pref = getSharedPreferences("AppPref", MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {  //Set the OnClickListener for the login Button


            @Override
            public void onClick(View view) {
                usernametxt = username.getText().toString();
                passwordtxt = password.getText().toString();
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", usernametxt));
                params.add(new BasicNameValuePair("password", passwordtxt));
                ServerRequest sr = new ServerRequest();
                JSONObject json = sr.getJSON("http://10.0.2.2:8080/startup_log",params);
                if(json != null){
                    try{
                        String jsonstr = json.getString("response");

                        if(json.getBoolean("res")){
                            String token = json.getString("token");
                            String grav = json.getString("grav");
                            SharedPreferences.Editor edit = pref.edit();
                            //Storing Data using SharedPreferences
                            edit.putString("token", token);
                            edit.putString("grav", grav);
                            edit.commit();
                            Intent teacheractivity = new Intent(LoginActivity.this,NavigationDrawerFragmentTeacher.class);

                            startActivity(teacheractivity);
                            finish();
                        }

                        Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Server Connection failed",Toast.LENGTH_LONG).show();

                }
            }
        });

    }




}