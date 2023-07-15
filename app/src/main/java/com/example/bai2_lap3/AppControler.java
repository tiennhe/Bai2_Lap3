package com.example.bai2_lap3;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

public class AppControler {
    private String JsonReponse;

public void getStringVolley(Context context , TextView textView){
    RequestQueue requestQueue = Volley.newRequestQueue(context);



    String Url_aray = "http://192.168.169.100:3000/person_array.json";

    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Url_aray, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                  try {
                      JsonReponse = "" ;
                      for(int i = 0  ; i<response.length();i++){
                          JSONObject jsonObject = (JSONObject) response.get(i);

                          String name = jsonObject.getString("name");
                          String email = jsonObject.getString("email");
                          JSONObject phone = jsonObject.getJSONObject("phone");
                          String home = phone.getString("home");
                          String mobile = phone.getString("mobile");
                          JsonReponse += "Name: " + name + "\n\n";
                          JsonReponse += "Email: " + email + "\n\n";
                          JsonReponse += "Home: " + home + "\n\n";
                          JsonReponse += "Mobile: " + mobile + "\n\n";

                          textView.setText(JsonReponse);
                      }
                  }catch (Exception e){

                  }


                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
         textView.setText(error.toString());
        }
    });
    requestQueue.add(jsonArrayRequest);

}

public void getStringObject(Context context , TextView textView){
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    String Url_object = "http://192.168.169.100:3000/person_object.json";
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url_object, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {


                        String name = response.getString("name");
                        String email = response.getString("email");
                        JSONObject phone = response.getJSONObject("phone");
                        String home = phone.getString("home");
                        String mobile = phone.getString("mobile");

                        JsonReponse = "";
                        JsonReponse += "Name: " + name + "\n\n";
                        JsonReponse += "Email: " + email + "\n\n";
                        JsonReponse += "Home: " + home + "\n\n";
                        JsonReponse += "Mobile: " + mobile + "\n\n";
                        textView.setText(JsonReponse);


                    }catch (Exception e){

                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        textView.setText(error.toString());
        }
    });
    requestQueue.add(jsonObjectRequest);
}
}
