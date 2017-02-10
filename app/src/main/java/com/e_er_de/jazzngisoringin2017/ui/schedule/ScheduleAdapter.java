package com.e_er_de.jazzngisoringin2017.ui.schedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e_er_de.jazzngisoringin2017.R;
import com.e_er_de.jazzngisoringin2017.model.Artist;
import com.e_er_de.jazzngisoringin2017.model.Schedule;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ILM on 8/1/2016.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.VersionViewHolder> {

    private List<Schedule> scheduleList;
    private int rowLayout;
    Context context;
    OnItemClickListener clickListener;

    public ScheduleAdapter(List<Schedule> login, int rowLayout, Context context, OnItemClickListener listener) {
        this.scheduleList = login;
        this.rowLayout = rowLayout;
        this.context = context;
        this.clickListener = listener;
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VersionViewHolder versionViewHolder, int i) {
        final Schedule model = scheduleList.get(i);
        versionViewHolder.bind(model, clickListener);
    }

    @Override
    public int getItemCount() {
        return scheduleList == null ? 0 : scheduleList.size();
    }

    public void animateTo(List<Schedule> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<Schedule> newModels) {
        for (int i = scheduleList.size() - 1; i >= 0; i--) {
            final Schedule model = scheduleList.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Schedule> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Schedule model = newModels.get(i);
            if (!scheduleList.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Schedule> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Schedule model = newModels.get(toPosition);
            final int fromPosition = scheduleList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Schedule removeItem(int position) {
        final Schedule model = scheduleList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, Schedule model) {
        scheduleList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Schedule model = scheduleList.remove(fromPosition);
        scheduleList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    class VersionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_hari_service)TextView titleRes;
        @BindView(R.id.txt_edc_sn)TextView descRes;

        public VersionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Schedule model, final OnItemClickListener listener) {
            titleRes.setText(model.getName());
            descRes.setText(model.getStart_hour() + "-" + model.getEnd_hour());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);

                }
            });
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(Schedule model);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
