package com.example.wclaproject.ui.teams.viewteams;

import android.os.Bundle;

import com.example.wclaproject.ui.teams.items.TeamModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wclaproject.R;

import com.example.wclaproject.databinding.TeamViewFragmentBinding;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ViewTeam extends AppCompatActivity {

    private TeamViewFragmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gson gson = new Gson();
        TeamModel currentTeam = gson.fromJson(getIntent().getStringExtra("currentTeam"), TeamModel.class);

        setTitle(currentTeam.getTeam_name());

        binding = TeamViewFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());


        ArrayList<String> players = new ArrayList<String>();
        players.add("Michael Osei");
        players.add("Justice Smith");
        players.add("Danny Green");
        players.add("Nathaniel Green");
        players.add("Justice Smith");
        players.add("Danny Green");
        players.add("Nathaniel Green");
        players.add("Justice Smith");
        players.add("Danny Green");
        players.add("Nathaniel Green");
        players.add("Justice Smith");
        players.add("Danny Green");
        players.add("Nathaniel Green");

        final ListView playersList = findViewById(R.id.playersTeamsList);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.player_list_item, R.id.simpleTextField, players);
        playersList.setAdapter(arrayAdapter);
        playersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) playersList.getItemAtPosition(position);
                Toast.makeText(ViewTeam.this,clickedItem,Toast.LENGTH_LONG).show();
            }
        });


        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}