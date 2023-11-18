package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activities.QuizActivity;
import com.example.myapplication.Models.QuestionModel;
import com.example.myapplication.Models.SetModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemSetBinding;

import java.util.ArrayList;

// Adapter class for the RecyclerView displaying sets
public class setAdapter extends RecyclerView.Adapter<setAdapter.viewHolder> {

    // Context of the application
    Context context;

    // List of SetModel objects representing different sets
    ArrayList<SetModel> list;

    // Constructor to initialize the adapter with context and list of sets
    public setAdapter(Context context, ArrayList<SetModel> list) {
        this.context = context;
        this.list = list;
    }

    // Inflates the layout for individual set items and creates a new viewHolder
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflates the layout for individual set items
        View view = LayoutInflater.from(context).inflate(R.layout.item_set,parent,false);

        // Creates a new viewHolder with the inflated layout
        return new viewHolder(view);
    }

    // Binds data to the views of an individual set item
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        // Retrieves the SetModel object at the given position
        final SetModel model = list.get(position);

        // Sets the name of the set to the corresponding TextView in the layout
        holder.binding.setName.setText(model.getSetName());

        // Sets an OnClickListener to handle item click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Passes the selected category to QuizActivity using an Intent
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra("Chapter", model.getSetName());
                context.startActivity(intent);
            }
        });
    }

    // Returns the total number of items in the list
    @Override
    public int getItemCount() {
        return list.size();
    }

    // ViewHolder class representing individual items in the RecyclerView
    public class viewHolder extends RecyclerView.ViewHolder {

        // ViewBinding for the item_set layout
        ItemSetBinding binding;

        // Constructor to initialize the viewHolder with the inflated layout
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            // Initializes the ViewBinding for the item_set layout
            binding = ItemSetBinding.bind(itemView);
        }
    }
}
