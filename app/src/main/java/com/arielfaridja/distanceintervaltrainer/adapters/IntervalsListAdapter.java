package com.arielfaridja.distanceintervaltrainer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;

import com.arielfaridja.distanceintervaltrainer.R;
import com.arielfaridja.distanceintervaltrainer.entities.Interval;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class IntervalsListAdapter extends RecyclerView.Adapter<IntervalsListAdapter.ViewHolder> {
    ArrayList<Interval> intervals;

    public IntervalsListAdapter(ArrayList<Interval> intervals) {
        this.intervals = intervals;
    }

    @NonNull
    @Override
    public IntervalsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interval_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntervalsListAdapter.ViewHolder holder, int position) {
        holder.interval = intervals.get(position);
        holder.setElements();
    }

    @Override
    public int getItemCount() {
        return intervals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Interval interval;
        EditText intervalNameTitle;
        ImageButton dragItemButton;
        ImageButton plusDistanceButton;
        ImageButton minusDistanceButton;
        EditText kmInput;
        EditText kmInnerInput;
        ImageButton deleteIntervalButton;
        ImageButton intervalColorPickerButton;
        ConstraintLayout intervalListItemLayout;
        Guideline guideline;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            intervalNameTitle = ((TextInputLayout) itemView.findViewById(R.id.intervalNameTitle)).getEditText();
            dragItemButton = itemView.findViewById(R.id.dragItemButton);
            plusDistanceButton = itemView.findViewById(R.id.plusDistanceButton);
            minusDistanceButton = itemView.findViewById(R.id.minusDistanceButton);
            kmInput = itemView.findViewById(R.id.kmInput);
            kmInnerInput = itemView.findViewById(R.id.kmInnerInput);
            deleteIntervalButton = itemView.findViewById(R.id.deleteIntervalButton);
            intervalColorPickerButton = itemView.findViewById(R.id.intervalColorPickerButton);
            intervalListItemLayout = itemView.findViewById(R.id.intervalListItemLayout);
            guideline = itemView.findViewById(R.id.guideline2);
            setEnabled(false);
        }

        public void setElements() {
            intervalListItemLayout.setBackgroundColor(interval.getColor());
            intervalNameTitle.setText(interval.getName());
            kmInput.setText(String.valueOf((int) interval.getDistance()));
            kmInnerInput.setText(String.valueOf((int) ((interval.getDistance() % 1) * 100)));
        }

        void setEnabled(Boolean flag) {
            if (flag == true) {
                intervalNameTitle.setEnabled(true);
                dragItemButton.setVisibility(View.VISIBLE);
                plusDistanceButton.setVisibility(View.VISIBLE);
                minusDistanceButton.setVisibility(View.VISIBLE);
                kmInput.setEnabled(true);
                kmInnerInput.setEnabled(true);
                deleteIntervalButton.setVisibility(View.VISIBLE);
                intervalColorPickerButton.setVisibility(View.VISIBLE);
                guideline.setGuidelinePercent((float) 0.85);
            } else {
                intervalNameTitle.setEnabled(false);
                dragItemButton.setVisibility(View.GONE);
                plusDistanceButton.setVisibility(View.GONE);
                minusDistanceButton.setVisibility(View.GONE);
                kmInput.setEnabled(false);
                kmInnerInput.setEnabled(false);
                deleteIntervalButton.setVisibility(View.GONE);
                intervalColorPickerButton.setVisibility(View.GONE);
                guideline.setGuidelinePercent((float) 1.0);
            }
        }
    }
}
