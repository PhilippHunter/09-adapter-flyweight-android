package de.thro.inf.prg3.a09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

import de.thro.inf.prg3.a09.adapter.FighterRecyclerViewAdapter;
import de.thro.inf.prg3.a09.model.Fighter;
import de.thro.inf.prg3.a09.model.FighterFactory;
import de.thro.inf.prg3.a09.adapter.FighterListAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int FIGHTER_COUNT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FighterFactory fighterFactory = new FighterFactory(this);
        FighterRecyclerViewAdapter fighterListAdapter = new FighterRecyclerViewAdapter(this);

        final RecyclerView fighterListView = findViewById(R.id.fighter_list_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        fighterListView.setLayoutManager(layoutManager);
        fighterListView.setAdapter(fighterListAdapter);

        for (int i = 0; i < FIGHTER_COUNT; i++) {
            fighterListAdapter.add(fighterFactory.createFighter());
        }
    }
}
