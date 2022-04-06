package com.example.wclaproject.ui.teams;

import android.content.Intent;
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

import com.example.wclaproject.databinding.TeamsFragmentBinding;
import com.example.wclaproject.ui.teams.items.TeamAdapter;
import com.example.wclaproject.ui.teams.items.TeamModel;
import com.example.wclaproject.ui.teams.viewteams.ViewTeam;
import com.google.gson.Gson;

import java.util.ArrayList;

public class TeamsFragment extends Fragment {
    private TeamsFragmentBinding binding;
    GridView teamsGridView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = TeamsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        teamsGridView = binding.allTeamsGrid;
        ArrayList<TeamModel> teamArrayList = new ArrayList<TeamModel>();
        teamArrayList.add(new TeamModel("Worcester Polytechnic Institute", "Engineers"));
        teamArrayList.add(new TeamModel("Providence College", "Friars"));
        teamArrayList.add(new TeamModel("Worcester State", "Bears"));
        teamArrayList.add(new TeamModel("Umass Lowell", "Grizzlies"));
        teamArrayList.add(new TeamModel("Clark University", "Rabbits"));
        teamArrayList.add(new TeamModel("Assumption College", "Bulldogs"));
        teamArrayList.add(new TeamModel("Syracuse University", "Lions"));
        teamArrayList.add(new TeamModel("University of New Hampshire", "Sharks"));
        teamArrayList.add(new TeamModel("University of Conneticut", "Huskies"));
        teamArrayList.add(new TeamModel("Becker College", "Heat"));
        teamArrayList.add(new TeamModel("Holy Cross College", "Dolphins"));
        teamArrayList.add(new TeamModel("Umass Lowell", "Grizzlies"));
        teamArrayList.add(new TeamModel("Clark University", "Rabbits"));
        teamArrayList.add(new TeamModel("Assumption College", "Bulldogs"));
        teamArrayList.add(new TeamModel("Syracuse University", "Lions"));
        teamArrayList.add(new TeamModel("University of New Hampshire", "Sharks"));
        teamArrayList.add(new TeamModel("University of Conneticut", "Huskies"));
        teamArrayList.add(new TeamModel("Becker College", "Heat"));
        teamArrayList.add(new TeamModel("Holy Cross College", "Dolphins"));
        teamArrayList.add(new TeamModel("Umass Lowell", "Grizzlies"));
        teamArrayList.add(new TeamModel("Clark University", "Rabbits"));
        teamArrayList.add(new TeamModel("Assumption College", "Bulldogs"));
        teamArrayList.add(new TeamModel("Syracuse University", "Lions"));
        teamArrayList.add(new TeamModel("University of New Hampshire", "Sharks"));
        teamArrayList.add(new TeamModel("University of Conneticut", "Huskies"));
        teamArrayList.add(new TeamModel("Becker College", "Heat"));
        teamArrayList.add(new TeamModel("Holy Cross College", "Dolphins"));



        TeamAdapter adapter = new TeamAdapter(binding.allTeamsGrid.getContext(), teamArrayList);
        teamsGridView.setAdapter(adapter);

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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}