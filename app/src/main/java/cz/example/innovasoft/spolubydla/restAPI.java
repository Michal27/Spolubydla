package cz.example.innovasoft.spolubydla;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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

        if (args[0] == "addGroup") {
            addGroup();
            addMember();
        }
        else if (args[0] == "addTask") {
            addTask();
        }

        return null;

    }

    protected void addGroup() {

        Gson gson = new Gson();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("group", MainActivity.group);
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
            JSONParseGroup(response.getEntity().getContent());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void JSONParseGroup(InputStream data) {

        Gson gson = new Gson();

        Reader r = new InputStreamReader(data);

        Group objs = gson.fromJson(r, Group.class);

        MainActivity.group.setId(objs.getId());

    }

    protected void addMember() {
        Gson gson = new Gson();
        MainActivity.member.setGroup_id(MainActivity.group.getId());
        MainActivity.member.setAdmin(false);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("member", MainActivity.member);
        Type mapType = new TypeToken<HashMap<String, Object>>() {}.getType();

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("https://spolubydle.herokuapp.com/members.json");

        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            httpPost.setEntity(new StringEntity(new Gson().toJson(hashMap, mapType)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse response = httpClient.execute(httpPost);
            JSONParseMember(response.getEntity().getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void JSONParseMember(InputStream data) {

        Gson gson = new Gson();

        Reader r = new InputStreamReader(data);

        Member objs = gson.fromJson(r, Member.class);

        MainActivity.member.setId(objs.getId());

    }

    protected void addTask() {
        Gson gson = new Gson();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        MainActivity.actualTask.setGroup_id(MainActivity.group.getId());
        MainActivity.actualTask.setMember_id(MainActivity.member.getId());
        MainActivity.actualTask.setDescription("Vyper psa");

        hashMap.put("task", MainActivity.actualTask);
        Type mapType = new TypeToken<HashMap<String, Object>>() {}.getType();

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("https://spolubydle.herokuapp.com/tasks.json");

        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            httpPost.setEntity(new StringEntity(new Gson().toJson(hashMap, mapType)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse response = httpClient.execute(httpPost);
            MainActivity.actualTask.setId(getIdTask(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainActivity.tasks.add(MainActivity.actualTask);
        MainActivity.actualTask.Clear();
    }

    protected String getIdTask(InputStream data) {

        Gson gson = new Gson();

        Reader r = new InputStreamReader(data);

        Task objs = gson.fromJson(r, Task.class);

        return objs.getId();

    }

    protected void deleteGroup() {

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