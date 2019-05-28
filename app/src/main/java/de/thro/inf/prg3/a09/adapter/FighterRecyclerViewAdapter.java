package de.thro.inf.prg3.a09.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.thro.inf.prg3.a09.R;
import de.thro.inf.prg3.a09.model.Fighter;

public class FighterRecyclerViewAdapter extends RecyclerView.Adapter<FighterRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<Fighter> fighters = new ArrayList<>();

    public FighterRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.fighter_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fighter f = fighters.get(i);

        viewHolder.setPilot(f.getPilot());
        viewHolder.setFighterType(f.getFighterType());
        viewHolder.setFighterImage(f.getFighterImage());
    }

    @Override
    public int getItemCount() {
        return fighters.size();
    }

    public void add(Fighter f) {
        fighters.add(f);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pilotNameView;
        private TextView fighterTypeView;
        private ImageView fighterImageView;

        ViewHolder(View view) {
            super(view);
            pilotNameView = view.findViewById(R.id.pilotNameView);
            fighterTypeView = view.findViewById(R.id.fighterTypeView);
            fighterImageView = view.findViewById(R.id.fighterImageView);
        }

        void setPilot(String pilot){
            pilotNameView.setText(pilot);
        }

        void setFighterType(String fighterType){
            fighterTypeView.setText(fighterType);
        }

        void setFighterImage(Drawable fighterImage){
            fighterImageView.setImageDrawable(fighterImage);
        }
    }

}
