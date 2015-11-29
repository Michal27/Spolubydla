package cz.example.innovasoft.spolubydla;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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
import java.util.ArrayList;
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
        }
        else if (args[0] == "addMember") {
            addMember();
        }
        else if (args[0] == "addTask") {
            addTask();
        }
        else if (args[0] == "getMembers") {
            getMembers();
        }
        else if (args[0] == "getTasks") {
            getUserTasks();
            getAllTasks();
        }
        else if (args[0] == "joinGroup") {
            joinMember();
        }
        else if (args[0] == "changeName") {
            changeUserName();
        }
        else if (args[0] == "changeColor") {
            changeUserColor();
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
        MainActivity.group.setCode(objs.getCode());
        MainActivity.code = objs.getCode();
    }

    protected void addMember() {
        MainActivity.member.setGroup_code(MainActivity.code);
        MainActivity.member.setColor("0");
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

    protected void joinMember() {

        MainActivity.member.setAdmin(false);
        MainActivity.member.setGroup_code(MainActivity.code);

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
            JSONParseJoinMember(response.getEntity().getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void JSONParseMember(InputStream data) {

        Gson gson = new Gson();

        Reader r = new InputStreamReader(data);

        Member objs = gson.fromJson(r, Member.class);

        MainActivity.member.setId(objs.getId());
        MainActivity.member.setColor(objs.getColor());
    }

    protected void JSONParseJoinMember(InputStream data) {

        Gson gson = new Gson();

        Reader r = new InputStreamReader(data);

        Member objs = gson.fromJson(r, Member.class);

        MainActivity.member.setId(objs.getId());
        MainActivity.member.setColor(objs.getColor());
        MainActivity.member.setGroup_id(objs.getGroup_id());
        MainActivity.group.setId(objs.getGroup_id());
    }

    protected void addTask() {

        HashMap<String, Object> hashMap = new HashMap<String, Object>();


        MainActivity.actualTask.setGroup_id(MainActivity.group.getId());
        MainActivity.actualTask.setMember_id(MainActivity.member.getId());
        MainActivity.actualTask.setMemberName(MainActivity.member.getName());
        MainActivity.actualTask.setMember_color(MainActivity.member.getColor());

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

        MainActivity.allTasks.add(MainActivity.actualTask);
        MainActivity.actualTask.Clear();
    }

    protected String getIdTask(InputStream data) {

        Gson gson = new Gson();

        Reader r = new InputStreamReader(data);

        Task objs = gson.fromJson(r, Task.class);

        return objs.getId();

    }

    public void getMembers() {
        InputStream data = null;
        HttpClient httpClient = new DefaultHttpClient();

        String url = "https://spolubydle.herokuapp.com/groups/" + MainActivity.group.getId() + "/members.json";
        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            data = response.getEntity().getContent();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {

            Reader r = new InputStreamReader(data);

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();

            JsonArray jArray = parser.parse(r).getAsJsonArray();

            for(JsonElement obj : jArray ) {
                Member m = gson.fromJson(obj, Member.class);
                MainActivity.members.add(m);
            }
        }
    }

    public void getUserTasks() {
        InputStream data = null;
        HttpClient httpClient = new DefaultHttpClient();

        String url = "https://spolubydle.herokuapp.com/members/" + MainActivity.member.getId() + "/tasks.json";
        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            data = response.getEntity().getContent();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {

            Reader r = new InputStreamReader(data);

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();

            JsonArray jArray = parser.parse(r).getAsJsonArray();

            for(JsonElement obj : jArray ) {
                Task t = gson.fromJson(obj, Task.class);
                MainActivity.userTasks.add(t);
            }
        }
    }

    public void getAllTasks() {
        InputStream data = null;
        HttpClient httpClient = new DefaultHttpClient();


        String url = "https://spolubydle.herokuapp.com/groups/" + MainActivity.group.getId() + "/tasks.json";
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            data = response.getEntity().getContent();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {

            Reader r = new InputStreamReader(data);

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();

            JsonArray jArray = parser.parse(r).getAsJsonArray();

            for(JsonElement obj : jArray ) {
                Task t = gson.fromJson(obj, Task.class);
                MainActivity.allTasks.add(t);
            }
        }
    }

    public void changeUserName() {

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("member", MainActivity.member);
        Type mapType = new TypeToken<HashMap<String, Object>>() {}.getType();

        HttpClient httpClient = new DefaultHttpClient();

        HttpPut httpPut = new HttpPut("https://spolubydle.herokuapp.com/members/" + MainActivity.member.getId() + ".json");

        httpPut.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            httpPut.setEntity(new StringEntity(new Gson().toJson(hashMap, mapType)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse response = httpClient.execute(httpPut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeUserColor() {

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("member", MainActivity.member);
        Type mapType = new TypeToken<HashMap<String, Object>>() {}.getType();

        HttpClient httpClient = new DefaultHttpClient();

        HttpPut httpPut = new HttpPut("https://spolubydle.herokuapp.com/members/" + MainActivity.member.getId() + ".json");

        httpPut.setHeader("Content-Type", "application/json; charset=utf-8");

        try {
            httpPut.setEntity(new StringEntity(new Gson().toJson(hashMap, mapType)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse response = httpClient.execute(httpPut);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}