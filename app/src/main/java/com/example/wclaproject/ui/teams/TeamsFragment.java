package com.example.wclaproject.ui.teams;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wclaproject.database.constant.SQLCommand;
import com.example.wclaproject.database.util.DBOperator;
import com.example.wclaproject.databinding.TeamsFragmentBinding;
import com.example.wclaproject.ui.teams.createResult.CreateResultActivity;
import com.example.wclaproject.ui.teams.items.TeamAdapter;
import com.example.wclaproject.ui.teams.items.TeamModel;
import com.example.wclaproject.ui.teams.viewteams.ViewTeam;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class TeamsFragment extends Fragment {
    private TeamsFragmentBinding binding;
    GridView teamsGridView;
    FloatingActionButton fab;

    String sql="";
    ArrayList<TeamModel> teamArrayList;
    Cursor cursor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = TeamsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        teamArrayList = new ArrayList<TeamModel>();
        teamsGridView = binding.allTeamsGrid;
        //DBOperator.getInstance().execSQL(SQLCommand.initDb);

        fetchTeams();

        teamsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                TeamModel team = teamArrayList.get(position);
                Intent openTeamIntent = new Intent(getActivity(), ViewTeam.class);
                Gson gson = new Gson();
                String currentTeam = gson.toJson(team);
                openTeamIntent.putExtra("currentTeam", currentTeam);
                startActivity(openTeamIntent);
            }
        });

        fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openResultIntent = new Intent(getActivity(), CreateResultActivity.class);
                startActivity(openResultIntent);
            }
        });

        return root;
    }

    public void fetchTeams(){
        sql = SQLCommand.fetchAllTeams;
        cursor = DBOperator.getInstance().execQuery(sql);


        if (cursor != null) {
            System.out.println("ALL TEAMS");

            // move cursor to first row
            System.out.println("Cursor Object: " + DatabaseUtils.dumpCursorToString(cursor));

            if (cursor.moveToFirst()) {
                do {
                    teamArrayList.add(new TeamModel(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7)
                    ));
                } while (cursor.moveToNext());
            }
            System.out.println("ALL TEAMS");
        }

        TeamAdapter adapter = new TeamAdapter(binding.allTeamsGrid.getContext(), teamArrayList);
        teamsGridView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}