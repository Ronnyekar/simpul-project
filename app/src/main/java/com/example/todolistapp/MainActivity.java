package com.example.todolistapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.todolistapp.fragment.FragmentChat;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.todolistapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mchatfab, mtaskfab;
    ExtendedFloatingActionButton mmenufab;
    TextView chattextview, tasktextview;
    Boolean isAllFabsVisible;
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;
    private FragmentTransaction ft;
    private FragmentManager fm;
    private FragmentChat fragmentChat;
    private AppCompatActivity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();b
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        context=this;
        activity = this;

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        BuatFragment();

        mmenufab = findViewById(R.id.menufab);
        mchatfab = findViewById(R.id.chatfab);
        mtaskfab = findViewById(R.id.taskfab);
        chattextview =
                findViewById(R.id.chatfabtext);
        tasktextview =
                findViewById(R.id.taskfabtext);

        mchatfab.setVisibility(View.GONE);
        mtaskfab.setVisibility(View.GONE);
        chattextview.setVisibility(View.GONE);
        tasktextview.setVisibility(View.GONE);

        isAllFabsVisible = false;

        mmenufab.shrink();

        mmenufab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {
                            // when isAllFabsVisible becomes
                            // true make all the action name
                            // texts and FABs VISIBLE.
                            mchatfab.show();
                            mtaskfab.show();
                            chattextview
                                    .setVisibility(View.VISIBLE);
                            tasktextview
                                    .setVisibility(View.VISIBLE);
                            mmenufab.extend();
                            isAllFabsVisible = true;
                        } else {
                            mchatfab.hide();
                            mtaskfab.hide();
                            chattextview
                                    .setVisibility(View.GONE);
                            tasktextview
                                    .setVisibility(View.GONE);
                            mmenufab.shrink();
                            isAllFabsVisible = false;
                        }
                    }
                });
        mchatfab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent Chatintent = new Intent(MainActivity.this, ChatActivity.class);
                        startActivity(Chatintent);
                        Toast.makeText
                                (MainActivity
                                                .this, "Menu Chat",
                                        Toast.LENGTH_SHORT).show();
                    }
                });

        mtaskfab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent TaskIntent = new Intent(MainActivity.this, TaskActivity.class);
                        startActivity(TaskIntent);
                        Toast.makeText
                                (MainActivity
                                                .this, "Menu Task",
                                        Toast.LENGTH_SHORT).show();
                    }
                });
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.menufab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        final ListView listViewmenu = (ListView) findViewById(R.id.listViewMenu);

        final ArrayList<menu_model> listMenu = new ArrayList<>();
        listMenu.add(new menu_model("Menu 1", "Description menu 1", R.drawable.tasklogo));
        listMenu.add(new menu_model("Menu 2", "Description menu 2", R.drawable.tasklogo));
        listMenu.add(new menu_model("Menu 3", "Description menu 3", R.drawable.tasklogo));
        listMenu.add(new menu_model("Menu 4", "Description menu 4", R.drawable.tasklogo));
        listMenu.add(new menu_model("Menu 5", "Description menu 5", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 6", "Description menu 6", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 7", "Description menu 7",R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 8", "Description menu 8", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 9", "Description menu 9", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 10", "Description menu 10", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 11", "Description menu 11", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 12", "Description menu 12", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 13", "Description menu 13", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 14", "Description menu 14", R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 15", "Description menu 15",R.drawable.actionbuttonlogo));
        listMenu.add(new menu_model("Menu 16", "Description menu 16", R.drawable.actionbuttonlogo));

        final MenuAdapter menuAdapter = new MenuAdapter(listMenu, this);
        listViewmenu.setAdapter(menuAdapter);
        listViewmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menu_model dataModel= listMenu.get(position);
                Snackbar.make(view, dataModel.getTitle()+ "\n" +dataModel.getDescription(), Snackbar.LENGTH_SHORT)
                        .setAction("No action", null).show();
            }
        });
    }

    private void BuatFragment() {
        fragmentChat = new FragmentChat(activity, context);

        ft.add(R.id.konten, fragmentChat);
        ft.commit();
    }

    public void TampilPesan() {
        Intent i = new Intent(MainActivity.this, TampilPesan.class);
        startActivity(i);
        onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}