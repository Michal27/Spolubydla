package cz.example.innovasoft.spolubydla;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void createGroupeButtonPressed(View view)
    {
        TextView textName = (TextView) findViewById(R.id.groupeName);

        if (textName.getText().toString() != "") {
            MainActivity.group.setName(textName.getText().toString());
            MainActivity.group.setSettings("");
            MainActivity.group.setCode("");

            new restAPI().execute("addGroup");

            this.finish();
        }
        //ELSE CO KDYZ NEZADA JMENO GROUP else {}

    }

}
