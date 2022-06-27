package com.arielfaridja.distanceintervaltrainer.adapters;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arielfaridja.distanceintervaltrainer.R;
import com.arielfaridja.distanceintervaltrainer.UI.WorkoutActivity;
import com.arielfaridja.distanceintervaltrainer.entities.Workout;

import java.util.ArrayList;

public class WorkoutsListAdapter extends RecyclerView.Adapter<WorkoutsListAdapter.ViewHolder> {

    ArrayList<Workout> workouts;

    public WorkoutsListAdapter(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.workout = workouts.get(position);
        holder.setElements();
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Workout workout;
        TextView nameTitle;
        TextView distanceTitle;
        TextView IntervalTitle;
        Button modifyButton;
        Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTitle = itemView.findViewById(R.id.workoutNameTitle);
            distanceTitle = itemView.findViewById(R.id.totalDistance);
            IntervalTitle = itemView.findViewById(R.id.totalIntervals);
            modifyButton = itemView.findViewById(R.id.modifyButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            //TODO: create click ArrayListeners
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), WorkoutActivity.class);
                intent.putExtra("workout", workout);
                view.getContext().startActivity(intent);
            });
        }

        public void setElements() {
            nameTitle.setText(workout.getName());
            distanceTitle.setText("total distance: " + workout.totalDistance());
            IntervalTitle.setText("total intervals: " + workout.totalIntervals());
            modifyButton.setOnClickListener(view -> {
                //TODO: start modify activity
            });
            deleteButton.setOnClickListener(view -> {
                new AlertDialog.Builder(view.getContext())
                        .setMessage("Are you sure you want to delete this workout?")
                        .setPositiveButton("Yes"
                                , (dialogInterface, i) -> {
                                    workouts.remove(getAdapterPosition());
                                    notifyItemRemoved(getAdapterPosition());

                                })
                        .setNegativeButton("No"
                                , (dialogInterface, i) -> {
                                    dialogInterface.dismiss();
                                }).show();
            });
        }
    }
}
