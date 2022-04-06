package com.example.wclaproject.ui.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wclaproject.R;
import com.example.wclaproject.databinding.StatsFragmentBinding;
import com.example.wclaproject.ui.teams.viewteams.ViewTeam;

import java.util.ArrayList;

public class StatsFragment extends Fragment {
    private StatsFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StatsViewModel statsViewModel =
                new ViewModelProvider(this).get(StatsViewModel.class);

        binding = StatsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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

        final ListView playersList = root.findViewById(R.id.statsTeamsList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.player_list_item, R.id.simpleTextField, players);
        playersList.setAdapter(arrayAdapter);
        playersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) playersList.getItemAtPosition(position);
                Toast.makeText(getContext(),clickedItem,Toast.LENGTH_LONG).show();
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
