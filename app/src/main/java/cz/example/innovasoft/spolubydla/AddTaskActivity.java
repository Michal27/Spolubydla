package cz.example.innovasoft.spolubydla;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AddTaskActivity extends AppCompatActivity {

    public static List<String> users;
    public static ArrayList<Member> ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Spinner selectUser = (Spinner) findViewById(R.id.whoValue);

        users = new ArrayList<String>();
        ms = new ArrayList<Member>();
        for (int i = 0; MainActivity.members.size() > i; i++) {
            users.add(MainActivity.members.get(i).getName());
            ms.add(MainActivity.members.get(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, users);
        selectUser.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_done:
                TextView textDescription = (TextView) findViewById(R.id.taskDescription);
                if (textDescription.getText().toString() != "") {
                    MainActivity.actualTask.setDescription(textDescription.getText().toString());
                    Spinner selectUser = (Spinner) findViewById(R.id.whoValue);
                    Integer pos = Integer.valueOf(selectUser.getSelectedItemPosition());
                    MainActivity.actualTask.setMember_color(MainActivity.members.get(pos).getColor());
                    MainActivity.actualTask.setMember_id(MainActivity.members.get(pos).getId());
                    MainActivity.actualTask.setMemberName(MainActivity.members.get(pos).getName());
                    try {
                        JSONObject js = new restAPI().execute("addTask").get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    MainActivity.allTasks = new ArrayList<>();
                    MainActivity.userTasks = new ArrayList<>();

                    try {
                        JSONObject js = new restAPI().execute("getTasks").get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    MainActivity.displayTasks(MainActivity.allTasks);

                    this.finish();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
