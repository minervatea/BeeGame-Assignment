package com.example.comp2100_appproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

// this activity is called when the user hits the button called register
// some codes for registration are inspired and learnt how to do this from youtube as described in the State of Originality

public class Registration extends Activity {
    public static boolean registered=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        final EditText usernameE = (EditText) findViewById(R.id.username_r);
        final EditText passwordE = (EditText) findViewById(R.id.password_r);
        Button go = (Button) findViewById(R.id.go);
        MainActivity.background.start();


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "d";
                String username = usernameE.getText().toString();
                String password = passwordE.getText().toString();
                int score = 300;

                Response.Listener<String> responseListiner = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(Registration.this,MainActivity.class);
                                startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                                builder.setMessage("Registration failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        }catch (JSONException e){
                            e.printStackTrace();

                        }

                    }
                };

                if(!username.equals("") &&!password.equals("")){
                    RegisterRequest registerRequest = new RegisterRequest(name,username,password,score,responseListiner);
                    RequestQueue queue = Volley.newRequestQueue(Registration.this);
                    queue.add(registerRequest);
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                    builder.setMessage("Registration failed")
                            .setNegativeButton("Retry",null)
                            .create()
                            .show();
                    registered=false;

                }

            }
        });

    }




}
