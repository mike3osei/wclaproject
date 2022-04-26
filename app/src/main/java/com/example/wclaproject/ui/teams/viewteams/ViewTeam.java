package com.example.wclaproject.ui.teams.viewteams;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import com.example.wclaproject.database.constant.SQLCommand;
import com.example.wclaproject.database.util.DBOperator;
import com.example.wclaproject.ui.teams.items.TeamModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wclaproject.R;

import com.example.wclaproject.databinding.TeamViewFragmentBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ViewTeam extends AppCompatActivity {

    private TeamViewFragmentBinding binding;
    ScrollView scrollView;
    TextView columnNames;

    String sql="";
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gson gson = new Gson();
        TeamModel currentTeam = gson.fromJson(getIntent().getStringExtra("currentTeam"), TeamModel.class);

        sql = SQLCommand.fetchRoster(currentTeam.getTeam_id());

        setTitle(currentTeam.getTeam_name());

        binding = TeamViewFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        scrollView = binding.scrollingGrid;


        TextView textTitle = binding.textView3;
        textTitle.setText(currentTeam.getTeam_name());


        List<String> list = new ArrayList<String>();
        list.add("Roster");
        list.add("Team Stats");
        list.add("Schedule");


        Spinner spinnerRegions = binding.spinner;
        columnNames = binding.columnNames;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegions.setAdapter(dataAdapter);


        spinnerRegions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String clickedItem=(String) list.get(position);

                if(clickedItem.equals("Roster")){
                    sql = SQLCommand.fetchRoster(currentTeam.getTeam_id());
                }else if(clickedItem.equals("Team Stats")){
                    sql = SQLCommand.fetchTeamStats(currentTeam.getTeam_id());
                }else if(clickedItem.equals("Schedule")){
                    sql = SQLCommand.fetchSchedule(currentTeam.getTeam_id());
                }

                fetchRoster();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        fetchRoster();
    }

    public void fetchRoster(){
        scrollView.removeAllViews();
        TableLayout tableLayout = new TableLayout(this);
        cursor = DBOperator.getInstance().execQuery(sql);
        List<String> items = new ArrayList();

        if (cursor != null) {
            // move cursor to first row
            if (cursor.moveToFirst()) {
                do {
                    StringBuilder sb = new StringBuilder();
                    int columnsQty = cursor.getColumnCount();
                    TableRow row = new TableRow(this);

                    for (int idx=0; idx<columnsQty; ++idx) {
                        sb.append(cursor.getColumnName(idx));
                        if (idx < columnsQty - 1)
                            sb.append("         ");

                        TextView textCol = new TextView(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_team, menu);
        return super.onCreateOptionsMenu(menu);
    }
}