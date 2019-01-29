package com.example.calsys.retro_custom_class.recy;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calsys.retro_custom_class.R;

import java.util.List;


public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.RecyclerViewHolder> {

    private List<Inventory> RVsList;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView name_text;
        public CardView card_view ;


        public RecyclerViewHolder(View view) {
            super(view);

            name_text = view.findViewById(R.id.name_text);
            card_view = view.findViewById(R.id.card_view);

        }
    }

    public ArrayAdapter(List<Inventory> RVsList) {
        this.RVsList = RVsList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new RecyclerViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        Inventory e = RVsList.get(position);

        holder.name_text.setText(e.getName());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id=RVsList.get(position).getId();
                Toast.makeText(view.getContext(), "Item is clicked "+ id, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return RVsList.size();
    }
}
