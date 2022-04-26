package com.example.wclaproject.ui.stats;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wclaproject.R;
import com.example.wclaproject.database.constant.SQLCommand;
import com.example.wclaproject.database.util.DBOperator;
import com.example.wclaproject.databinding.StandingsFragmentBinding;
import com.example.wclaproject.databinding.StatsFragmentBinding;
import com.example.wclaproject.ui.standings.StandingsViewModel;
import com.example.wclaproject.ui.standings.item.StandingAdapter;
import com.example.wclaproject.ui.standings.item.StandingModel;
import com.example.wclaproject.ui.teams.viewteams.ViewTeam;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends Fragment {
    private StatsFragmentBinding binding;
    ScrollView scrollView;
    TextView columnNames;

    String sql="";
    Cursor cursor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sql = SQLCommand.fetchHighScore;

        binding = StatsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        scrollView = binding.scrollingGrid;

        List<String> list = new ArrayList<String>();
        list.add("High Scoring");
        list.add("Most Championships");
        list.add("Home Advantage");
        list.add("History of Champions");
        list.add("Popular Stadiums");
        list.add("Experienced Coaches");
        list.add("Roster Count");


        Spinner spinnerRegions = binding.spinner;
        columnNames = binding.columnNames;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegions.setAdapter(dataAdapter);


        spinnerRegions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String clickedItem=(String) list.get(position);

                if(clickedItem.equals("High Scoring")){
                    sql = SQLCommand.fetchHighScore;
                }else if(clickedItem.equals("Most Championships")){
                    sql = SQLCommand.fetchMostChamps;
                }else if(clickedItem.equals("Team Stats Totals")){
                    //sql = SQLCommand.fetchTeamStatsTot;
                }else if(clickedItem.equals("Team Stats Average")){
                    //sql = SQLCommand.fetchTeamStatsAvg;
                }else if(clickedItem.equals("Home Advantage")){
                    sql = SQLCommand.fetchHomeAdvantage;
                }else if(clickedItem.equals("History of Champions")){
                    sql = SQLCommand.fetchHistoryChamps;
                }else if(clickedItem.equals("Popular Stadiums")){
                    sql = SQLCommand.fetchPopularStadiums;
                }else if(clickedItem.equals("Experienced Coaches")){
                    sql = SQLCommand.fetchExperiencedCoaches;
                }else if(clickedItem.equals("Roster Count")){
                    sql = SQLCommand.fetchRosterCount;
                }

                fetchStats();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        fetchStats();

        return root;
    }

    public void fetchStats(){
        scrollView.removeAllViews();
        TableLayout tableLayout = new TableLayout(getContext());
        cursor = DBOperator.getInstance().execQuery(sql);

        if (cursor != null) {
            // move cursor to first row
            if (cursor.moveToFirst()) {
                do {
                    StringBuilder sb = new StringBuilder();
                    int columnsQty = cursor.getColumnCount();
                    TableRow row = new TableRow(getContext());

                    for (int idx=0; idx<columnsQty; ++idx) {

                        sb.append(cursor.getColumnName(idx));
                        if (idx < columnsQty - 1)
                            sb.append("         ");

                        TextView textCol = new TextView(getContext());
                        textCol.setTextColor(Color.BLACK);
                        textCol.setText(cursor.getString(idx));
                        textCol.setPadding(15, 15, 15, 15);
                        row.addView(textCol);
                    }
                    String itemName = sb.toString();
                    columnNames.setText(itemName);

                    tableLayout.addView(row);
                } while (cursor.moveToNext());
            }
        }
        scrollView.addView(tableLayout);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
