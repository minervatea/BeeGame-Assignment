package com.example.comp2100_appproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


// this is the first activity coming out when the app is run.
// some codes for login are inspired and learnt how to do this from youtube as described in the State of Originality
public class MainActivity extends Activity {
    public static Display display;
    GameView gameView;
    public static boolean succeed=false;
    static MediaPlayer background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);


        display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Store.gameActivityContext = this;
        Store.guideActivityContext=this;
        gameView = new GameView(this);
        //setContentView(gameView);

        background = MediaPlayer.create(MainActivity.this,R.raw.background);
        background.start();

        background.setLooping(true);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                GameOver.user_name = username1;
                GameOver.user_password = password1;

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            succeed=success;
                            if(success){
                                int scored = jsonResponse.getInt("score");
                                GameView.score = scored;
                                setContentView(gameView);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }


                    }
                };

                LoginRequest registerRequest = new LoginRequest(username1,password1,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(registerRequest);
            }
        });


    }
    public void register(View view){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    public void guest(View view){
        setContentView(gameView);
    }

}