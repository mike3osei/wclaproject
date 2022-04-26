package com.example.wclaproject.ui.standings;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wclaproject.R;
import com.example.wclaproject.database.constant.SQLCommand;
import com.example.wclaproject.database.util.DBOperator;
import com.example.wclaproject.databinding.StandingsFragmentBinding;
import com.example.wclaproject.ui.standings.item.StandingAdapter;
import com.example.wclaproject.ui.standings.item.StandingModel;
import com.example.wclaproject.ui.teams.items.TeamAdapter;
import com.example.wclaproject.ui.standings.item.StandingModel;
import com.example.wclaproject.ui.teams.items.TeamModel;
import com.example.wclaproject.ui.teams.viewteams.ViewTeam;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class StandingsFragment extends Fragment {
    private StandingsFragmentBinding binding;
    GridView allStandingsGrid;

    String sql="";
    ArrayList<StandingModel> standingArrayList;
    Cursor cursor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StandingsViewModel standingsViewModel =
                new ViewModelProvider(this).get(StandingsViewModel.class);
        sql = SQLCommand.fetchStandings;
        standingArrayList = new ArrayList<StandingModel>();

        binding = StandingsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        allStandingsGrid = binding.allStandingsGrid;

        List<String> list = new ArrayList<String>();
        list.add("All");
        list.add("North");
        list.add("South");
        list.add("East");
        list.add("West");

        Spinner spinnerRegions = binding.spinner;
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegions.setAdapter(dataAdapter);


        spinnerRegions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String clickedItem=(String) list.get(position);

                if(clickedItem.equals("All")){
                    sql = SQLCommand.fetchStandings;
                }else{
                    sql = SQLCommand.fetchRegionStandings(clickedItem);
                }
                fetchStandings(clickedItem);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        fetchStandings("All");
        
        return root;
    }


    public void fetchStandings(String item){
        cursor = DBOperator.getInstance().execQuery(sql);
        standingArrayList.clear();

        if (cursor != null) {
            System.out.println("ALL Standings");

            // move cursor to first row
            System.out.println("Cursor Object: " + DatabaseUtils.dumpCursorToString(cursor));

            if (cursor.moveToFirst()) {
                do {
                    if(item.equals("All")){
                        standingArrayList.add(new StandingModel(
                                cursor.getString(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3)
                        ));
                    }else{
                        standingArrayList.add(new StandingModel(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4)
                        ));
                    }

                } while (cursor.moveToNext());
            }
            System.out.println("ALL Standings");
        }

        StandingAdapter adapter = new StandingAdapter(binding.allStandingsGrid.getContext(), standingArrayList);
        allStandingsGrid.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
