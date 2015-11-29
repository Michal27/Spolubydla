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
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor1ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor2ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor3ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor4ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor5ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor6ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }

    public void changeColor7ButtonPressed(View view)
    {
        //TADY UDELAT ZMENU BARVY UZIVATELE
        MainActivity.drawer.openDrawer(Gravity.LEFT);
        this.finish();
    }
}
