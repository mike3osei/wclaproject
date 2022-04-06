package com.example.wclaproject.ui.standings;

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

import com.example.wclaproject.databinding.StandingsFragmentBinding;
import com.example.wclaproject.ui.standings.item.StandingAdapter;
import com.example.wclaproject.ui.standings.item.StandingModel;
import com.example.wclaproject.ui.teams.items.TeamAdapter;
import com.example.wclaproject.ui.standings.item.StandingModel;
import com.example.wclaproject.ui.teams.viewteams.ViewTeam;
import com.google.gson.Gson;

import java.util.ArrayList;


public class StandingsFragment extends Fragment {
    private StandingsFragmentBinding binding;
    GridView allStandingsGrid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StandingsViewModel standingsViewModel =
                new ViewModelProvider(this).get(StandingsViewModel.class);

        binding = StandingsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        allStandingsGrid = binding.allStandingsGrid;

        ArrayList<StandingModel> standingArrayList = new ArrayList<StandingModel>();
        standingArrayList.add(new StandingModel("Worcester Polytechnic Institute", "1"));
        standingArrayList.add(new StandingModel("Providence College", "2"));
        standingArrayList.add(new StandingModel("Worcester State", "3"));
        standingArrayList.add(new StandingModel("Umass Lowell", "4"));
        standingArrayList.add(new StandingModel("Clark University", "5"));
        standingArrayList.add(new StandingModel("Assumption College", "6"));
        standingArrayList.add(new StandingModel("Syracuse University", "7"));
        standingArrayList.add(new StandingModel("University of New Hampshire", "8"));
        standingArrayList.add(new StandingModel("University of Conneticut", "9"));
        standingArrayList.add(new StandingModel("Becker College", "10"));
        standingArrayList.add(new StandingModel("Holy Cross College", "11"));
        standingArrayList.add(new StandingModel("Umass Lowell", "12"));
        standingArrayList.add(new StandingModel("Clark University", "13"));
        standingArrayList.add(new StandingModel("Assumption College", "14"));
        standingArrayList.add(new StandingModel("Syracuse University", "15"));
        standingArrayList.add(new StandingModel("University of New Hampshire", "16"));
        standingArrayList.add(new StandingModel("University of Conneticut", "17"));
        standingArrayList.add(new StandingModel("Becker College", "18"));
        standingArrayList.add(new StandingModel("Holy Cross College", "19"));
        standingArrayList.add(new StandingModel("Umass Lowell", "20"));
        standingArrayList.add(new StandingModel("Clark University", "21"));
        standingArrayList.add(new StandingModel("Assumption College", "22"));
        standingArrayList.add(new StandingModel("Syracuse University", "23"));
        standingArrayList.add(new StandingModel("University of New Hampshire", "24"));
        standingArrayList.add(new StandingModel("University of Conneticut", "25"));
        standingArrayList.add(new StandingModel("Becker College", "26"));
        standingArrayList.add(new StandingModel("Holy Cross College", "27"));



        StandingAdapter adapter = new StandingAdapter(binding.allStandingsGrid.getContext(), standingArrayList);
        allStandingsGrid.setAdapter(adapter);

        allStandingsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {


                StandingModel team = standingArrayList.get(position);
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
