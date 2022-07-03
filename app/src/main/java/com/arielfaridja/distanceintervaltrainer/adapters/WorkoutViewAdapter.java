package com.arielfaridja.distanceintervaltrainer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arielfaridja.distanceintervaltrainer.R;
import com.arielfaridja.distanceintervaltrainer.entities.Loop;
import com.arielfaridja.distanceintervaltrainer.entities.Workout;

public class WorkoutViewAdapter extends RecyclerView.Adapter<WorkoutViewAdapter.ViewHolder> {
    Workout workout;

    public WorkoutViewAdapter(Workout workout) {
        this.workout = workout;
    }

    @NonNull
    @Override
    public WorkoutViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loop_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewAdapter.ViewHolder holder, int position) {
        holder.loop = workout.getLoops().get(position);
        holder.setElements();
    }

    @Override
    public int getItemCount() {
        return workout.getLoops().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        Loop loop;
        ImageButton plusLoopButton;
        ImageButton minusLoopButton;
        EditText setLoopInput;
        RecyclerView intervalsList;
        ImageButton addIntervalButton;
        ImageButton loopDragButton;
        IntervalsListAdapter adapter;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            plusLoopButton = itemView.findViewById(R.id.plusLoopButton);
            minusLoopButton = itemView.findViewById(R.id.minusLoopButton);
            setLoopInput = itemView.findViewById(R.id.setLoopInput);
            intervalsList = itemView.findViewById(R.id.intervalsList);
            addIntervalButton = itemView.findViewById(R.id.addIntervalButton);
            loopDragButton = itemView.findViewById(R.id.loopDragButton);
            context = itemView.getContext();
            setEnabled(false);
        }

        public void setEnabled(Boolean flag) {
            if (flag == true) {
                plusLoopButton.setVisibility(View.VISIBLE);
                minusLoopButton.setVisibility(View.VISIBLE);
                setLoopInput.setEnabled(true);
                addIntervalButton.setVisibility(View.VISIBLE);
                loopDragButton.setVisibility(View.VISIBLE);
                setIntervalsEnabled(true);
            } else {
                plusLoopButton.setVisibility(View.GONE);
                minusLoopButton.setVisibility(View.GONE);
                setLoopInput.setEnabled(false);
                addIntervalButton.setVisibility(View.GONE);
                loopDragButton.setVisibility(View.GONE);
                setIntervalsEnabled(false);

            }
        }

        private void setIntervalsEnabled(Boolean flag) {
            if (flag = true)
                for (int i = 0; i < intervalsList.getChildCount(); i++) {
                    ((IntervalsListAdapter.ViewHolder) intervalsList
                            .getChildViewHolder(intervalsList.getChildAt(i)))
                            .setEnabled(true);
                }
            else {
                for (int i = 0; i < intervalsList.getChildCount(); i++) {
                    ((IntervalsListAdapter.ViewHolder) intervalsList
                            .getChildViewHolder(intervalsList.getChildAt(i)))
                            .setEnabled(false);
                }
            }
        }

        public void setElements() {
            setLoopInput.setText(String.valueOf(loop.getTimes()));
            adapter = new IntervalsListAdapter(loop.getIntervals());
            intervalsList.setAdapter(adapter);
            intervalsList.setLayoutManager(new LinearLayoutManager(context));
        }
    }
}
