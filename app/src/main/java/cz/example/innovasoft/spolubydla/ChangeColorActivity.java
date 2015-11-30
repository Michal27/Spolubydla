package cz.example.innovasoft.spolubydla;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ChangeColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                MainActivity.drawer.openDrawer(Gravity.LEFT);
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeColor0ButtonPressed(View view)
    {
        MainActivity.member.setColor("0");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor1ButtonPressed(View view)
    {
        MainActivity.member.setColor("1");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor2ButtonPressed(View view)
    {
        MainActivity.member.setColor("2");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor3ButtonPressed(View view)
    {
        MainActivity.member.setColor("3");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor4ButtonPressed(View view)
    {
        MainActivity.member.setColor("4");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor5ButtonPressed(View view)
    {
        MainActivity.member.setColor("5");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor6ButtonPressed(View view)
    {
        MainActivity.member.setColor("6");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor7ButtonPressed(View view)
    {
        MainActivity.member.setColor("7");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject js = new restAPI().execute("getMembers").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("activity-2-initialized"));
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }
}
