package cz.example.innovasoft.spolubydla;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String PREFS_NAME = "SpolubydlaPrefs";
    public static  DrawerLayout drawer;
    static public Group group;
    static public Member member;
    static public Task actualTask;
    static public ArrayList<Member> members;
    static public ArrayList<Task> userTasks;
    static public ArrayList<Task> allTasks;
    static public String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        int userId = settings.getInt("userId", -1);

        group = new Group();
        member = new Member();
        actualTask = new Task();
        members = new ArrayList<Member>();
        userTasks = new ArrayList<Task>();
        allTasks = new ArrayList<Task>();
        code = new String();

        if(userId == -1) {
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
        }
        final ActionBar actionBar = getActionBar();
        // Specify that tabs should be displayed in the action bar.

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddTaskActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerStateChanged(int newState) {
                TextView userName = (TextView) findViewById(R.id.userNameView);
                userName.setText(member.getName());

                ImageView userImage = (ImageView) findViewById(R.id.userImageView);
                /*
                Log.d("Code", member.getColor());
                if(member.getColor().equals(Integer.toString(0)))
                {
                    userImage.setColorFilter(Color.rgb(235,25,25)); //red
                }
                else if(member.getColor().equals(Integer.toString(1)))
                {
                    userImage.setColorFilter(Color.rgb(25,190,25)); //green
                }
                else if(member.getColor().equals(Integer.toString(2)))
                {
                    userImage.setColorFilter(Color.rgb(50,215,200)); //azure
                }
                else if(member.getColor().equals(Integer.toString(3)))
                {
                    userImage.setColorFilter(Color.rgb(0,128,255)); //blue
                }
                else if(member.getColor().equals(Integer.toString(4)))
                {
                    userImage.setColorFilter(Color.rgb(250,190,20)); //orange
                }
                else if(member.getColor().equals(Integer.toString(5)))
                {
                    userImage.setColorFilter(Color.rgb(150,40,250)); //purple
                }
                else if(member.getColor().equals(Integer.toString(6)))
                {
                    userImage.setColorFilter(Color.rgb(225,40,225)); //pink
                }
                else if(member.getColor().equals(Integer.toString(7)))
                {
                    userImage.setColorFilter(Color.rgb(0,0,0)); //black
                }*/
            }

            /*@Override
            public void onDrawerOpened(View drawerView) {

            }*/
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Moje"));
        tabLayout.addTab(tabLayout.newTab().setText("Všechny"));
        tabLayout.addTab(tabLayout.newTab().setText("Žebříček"));

        new restAPI().execute("getTasks");
        displayTasks(allTasks);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.nav_settings)
        {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(id == R.id.nav_showCode)
        {
            //TADY ZOBRAZIT KOD
        }
        else if(id == R.id.nav_userName)
        {
            drawer.closeDrawer(GravityCompat.START);
            startActivity(new Intent(MainActivity.this, ChangeNameActivity.class));
        }
        else if(id == R.id.nav_userColor)
        {
            drawer.closeDrawer(GravityCompat.START);
            startActivity(new Intent(MainActivity.this, ChangeColorActivity.class));
        }

        return true;
    }


    public void displayTasks(ArrayList<Task> displayTasks)
    {

        LinearLayout mainContent = (LinearLayout)findViewById(R.id.mainContent);
        mainContent.removeAllViews();

        for (int i=0; displayTasks.size() > i; i++)
        {
            View square = getLayoutInflater().inflate(R.layout.square_template, null);
            displayTasks.get(i).setMember_color("1"); //toto pak odkráglovat
            TextView taskName = (TextView) square.findViewById(R.id.taskName);
            taskName.setText(displayTasks.get(i).getDescription());

            TextView taskUser = (TextView) square.findViewById(R.id.taskUser);
            taskUser.setText(displayTasks.get(i).getMemberName());

            TextView taskPoints = (TextView) square.findViewById(R.id.taskPoints);
            taskPoints.setText(displayTasks.get(i).getPoints());

            ImageView userColor = (ImageView) square.findViewById(R.id.userImage);
            if(displayTasks.get(i).getMemberColor().equals(Integer.toString(0)))//user.color == 0
            {
                userColor.setColorFilter(Color.rgb(235,25,25)); //red
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(1)))
            {
                userColor.setColorFilter(Color.rgb(25,190,25)); //green
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(2)))
            {
                userColor.setColorFilter(Color.rgb(50,215,200)); //azure
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(3)))
            {
                userColor.setColorFilter(Color.rgb(0,128,255)); //blue
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(4)))
            {
                userColor.setColorFilter(Color.rgb(250,190,20)); //orange
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(5)))
            {
                userColor.setColorFilter(Color.rgb(150,40,250)); //purple
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(6)))
            {
                userColor.setColorFilter(Color.rgb(225,40,225)); //pink
            }
            else if(displayTasks.get(i).getMemberColor().equals(Integer.toString(7)))
            {
                userColor.setColorFilter(Color.rgb(0,0,0)); //black
            }

            mainContent.addView(square);
            mainContent.invalidate();
        }
    }
}
