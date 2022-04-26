package com.example.wclaproject.ui.teams.items;

import com.example.wclaproject.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<TeamModel> {
    public TeamAdapter(@NonNull Context context, ArrayList<TeamModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        TeamModel courseModel = getItem(position);
        TextView teamNameView = listItemView.findViewById(R.id.cardText);
        teamNameView.setText(courseModel.getTeam_name());

        TextView teamDescView = listItemView.findViewById(R.id.cardDesc);
        teamDescView.setText(courseModel.getTeam_region());

        System.out.println(courseModel.getTeam_city());



        return listItemView;
    }
}
