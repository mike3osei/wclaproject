package com.example.wclaproject.ui.stats.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wclaproject.R;
import com.example.wclaproject.ui.stats.item.StatsModel;

import java.util.ArrayList;

public class StatsAdapter extends ArrayAdapter<StatsModel> {
    public StatsAdapter(@NonNull Context context, ArrayList<StatsModel> courseModelArrayList) {
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

        StatsModel courseModel = getItem(position);
        TextView teamNameView = listItemView.findViewById(R.id.listCardText);
        teamNameView.setText(courseModel.getRank());

        TextView teamDescView = listItemView.findViewById(R.id.listCardDesc);
        teamDescView.setText(courseModel.getName());


        return listItemView;
    }
}
