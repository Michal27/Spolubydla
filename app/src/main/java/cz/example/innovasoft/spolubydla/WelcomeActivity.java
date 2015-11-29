package cz.example.innovasoft.spolubydla;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AutoCompleteTextView groupName = (AutoCompleteTextView) findViewById(R.id.groupeName);
        AutoCompleteTextView groupCode = (AutoCompleteTextView) findViewById(R.id.groupCode);
        Button createButton = (Button) findViewById(R.id.createGroupeButton);
        Button joinButton = (Button) findViewById(R.id.joinGroupButton);
        createButton.setEnabled(false);
        joinButton.setEnabled(false);

        groupName.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                AutoCompleteTextView groupName = (AutoCompleteTextView) findViewById(R.id.groupeName);
                Button createButton = (Button) findViewById(R.id.createGroupeButton);
                if (groupName.getText().length() != 0) {
                    createButton.setEnabled(true);
                }
                else
                {
                    createButton.setEnabled(false);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        groupCode.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                AutoCompleteTextView groupCode = (AutoCompleteTextView) findViewById(R.id.groupCode);
                Button joinButton = (Button) findViewById(R.id.joinGroupButton);
                if(groupCode.getText().length() != 0)
                {
                    joinButton.setEnabled(true);
                }
                else
                {
                    joinButton.setEnabled(false);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void createGroupeButtonPressed(View view)
    {
        TextView textName = (TextView) findViewById(R.id.groupeName);

        if (textName.getText().toString() != "") {
            MainActivity.group.setName(textName.getText().toString());
            MainActivity.group.setSettings("");
            MainActivity.group.setCode("");

            MainActivity.member.setName("CreateSpolubydla");

            try {
                JSONObject js = new restAPI().execute("addGroup").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            this.finish();
        }
        //ELSE CO KDYZ NEZADA JMENO GROUP else {}

    }
<<<<<<< HEAD

    public void joinGroupeButtonPressed(View view)
    {
        TextView groupC = (TextView) findViewById(R.id.groupCode);

        if (groupC.getText().toString() != "") {
            MainActivity.group.setCode(groupC.getText().toString());
            MainActivity.code = groupC.getText().toString();

            MainActivity.member.setName("JoinSpolubydla");

            try {
                JSONObject js = new restAPI().execute("joinGroup").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            try {
                JSONObject js = new restAPI().execute("getTasks").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            Log.d("Code", Integer.toString(MainActivity.allTasks.size()));


            MainActivity.displayTasks(MainActivity.allTasks);

            this.finish();
        }
        //ELSE CO KDYZ NEZADA JMENO GROUP else {}
    }


=======
>>>>>>> 46eb9b36a2175a86e893bc01b29fa94235547999
}
