package com.example.comp2100_appproject;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// register request class, inspired and learnt how to do this from youtube as described in the State of Originality
// it requests the registration
public class RegisterRequest extends StringRequest { //

    private static final String REGISTRATION="https://beegame2100.000webhostapp.com/Register.php";
    private Map<String, String> infos;

    public RegisterRequest(String name, String username, String password, int score, Response.Listener<String> listener){
        super(Method.POST, REGISTRATION,listener,null);
        infos = new HashMap<>();
        infos.put("name",name);
        infos.put("username",username);
        infos.put("password",password);
        infos.put("score",score+"");
    }

    @Override
    public Map<String,String> getParams(){
        return infos;
    }

}
