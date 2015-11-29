package cz.example.innovasoft.spolubydla;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeColor0ButtonPressed(View view)
    {
        MainActivity.member.setName("0");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor1ButtonPressed(View view)
    {
        MainActivity.member.setName("1");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor2ButtonPressed(View view)
    {
        MainActivity.member.setName("2");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor3ButtonPressed(View view)
    {
        MainActivity.member.setName("3");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor4ButtonPressed(View view)
    {
        MainActivity.member.setName("4");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor5ButtonPressed(View view)
    {
        MainActivity.member.setName("5");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor6ButtonPressed(View view)
    {
        MainActivity.member.setName("6");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor7ButtonPressed(View view)
    {
        MainActivity.member.setName("7");
        try {
            JSONObject js = new restAPI().execute("changeColor").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }
}
