package com.example.wclaproject.ui.standings.item;

import com.example.wclaproject.R;
import com.example.wclaproject.ui.teams.items.TeamModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class StandingAdapter extends ArrayAdapter<StandingModel> {
    public StandingAdapter(@NonNull Context context, ArrayList<StandingModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_card_item, parent, false);
        }

        StandingModel standingModel = getItem(position);
        TextView teamRankView = listItemView.findViewById(R.id.listCardRank);
        teamRankView.setText(Integer.toString(position+1));

        TextView teamNameView = listItemView.findViewById(R.id.listCardName);
        teamNameView.setText(standingModel.getTeam());

        TextView teamStandingsView = listItemView.findViewById(R.id.listCardStanding);
        teamStandingsView.setText(standingModel.getRecord());

        return listItemView;
    }
}
