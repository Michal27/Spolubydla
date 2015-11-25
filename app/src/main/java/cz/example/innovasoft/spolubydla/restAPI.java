package cz.example.innovasoft.spolubydla;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by tom on 25.11.15.
 */
public class restAPI extends AsyncTask<String, String, JSONObject> {
    private ProgressDialog pDialog;


    @Override
    protected JSONObject doInBackground(String... args) {
        // Getting JSON from URL


        addGroup(args[0]);
        return null;

    }

    protected void addGroup(String str) {

        Group group = new Group();

        group.name = "kokinek";
        group.settings = "123456";
        group.code = "";

        Gson gson = new Gson();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("group", group);
        Type mapType = new TypeToken<HashMap<String, Object>>() {}.getType();

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("https://spolubydle.herokuapp.com/groups.json");

        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            httpPost.setEntity(new StringEntity(new Gson().toJson(hashMap, mapType)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            Log.d("POST", EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void deleteGroup(String id) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete httpDelete = new HttpDelete("https://spolubydle.herokuapp.com/groups/9.json");

        httpDelete.setHeader("Content-Type", "application/json; charset=utf-8");

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpDelete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        try {
            Log.d("DELETE", EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}