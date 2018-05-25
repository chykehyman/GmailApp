package com.andela.android.gmailapp.view;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.andela.android.gmailapp.R;
import com.andela.android.gmailapp.adapter.MessageAdapter;
import com.andela.android.gmailapp.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> messages = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        displayMessages();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is a nice app", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * chooses a random color from array.xml
     */
    private int getRandomMaterialColor() {
        int returnColor = Color.GRAY;
        int arrayId = getResources().getIdentifier("mdcolor_400", "array", getPackageName());

        if (arrayId != 0) {
            TypedArray colors = getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }

    private void generateMessages(List<Message> messages) {
        messages.add(new Message("Kenya AirWays", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "https://bit.ly/2HOv4xm", getRandomMaterialColor()));
        messages.add(new Message("Google", "New sign-in from iPhone",
                "New sign-in from iPhone. Hi Chike, we just rec", "9:25 PM",
                "", getRandomMaterialColor()));
        messages.add(new Message("Pivotal Tracker", "The Tracker Backlog—MAY 2018 Newsletter",
                "Tracker’s new story templates; how to set up your important", "9:20 PM",
                "", getRandomMaterialColor()));
        messages.add(new Message("Andela", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "", getRandomMaterialColor()));
        messages.add(new Message("Code School", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "", getRandomMaterialColor()));
        messages.add(new Message("Nigeria Tech", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:20 PM",
                "https://bit.ly/2jr0saS", getRandomMaterialColor()));
        messages.add(new Message("UniLag Portal", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "", getRandomMaterialColor()));
        messages.add(new Message("Kenya AirWays", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "https://bit.ly/2HOv4xm", getRandomMaterialColor()));
        messages.add(new Message("Kenya AirWays", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "https://bit.ly/2HOv4xm", getRandomMaterialColor()));
        messages.add(new Message("Kenya AirWays", "New Way To Fly",
                "New way to fly with us. We have a brand new way where we now", "9:30 PM",
                "https://bit.ly/2HOv4xm", getRandomMaterialColor()));
        messages.add(new Message("Pivotal Tracker", "The Tracker Backlog—MAY 2018 Newsletter",
                "Tracker’s new story templates; how to set up your important", "9:20 PM",
                "", getRandomMaterialColor()));
        messages.add(new Message("Pivotal Tracker", "The Tracker Backlog—MAY 2018 Newsletter",
                "Tracker’s new story templates; how to set up your important", "9:20 PM",
                "", getRandomMaterialColor()));
    }

    private void displayMessages() {
        generateMessages(messages);

        recyclerView = findViewById(R.id.messages_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MessageAdapter(this, messages));
    }
}
