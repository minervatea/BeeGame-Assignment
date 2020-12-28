package com.example.comp2100_appproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// login request class, inspired and learnt how to do this from youtube as described in the State of Originality
// it requests the login

public class LoginRequest extends StringRequest { //

    private static final String LOGIN="https://beegame2100.000webhostapp.com/Login.php";

    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN,listener,null);
        System.out.println("laijsdlfajsdfasdfasdfadfasdfasdfadf");
        params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }


    @Override
    public Map<String,String> getParams(){
        return params;
    }

}
