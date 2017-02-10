package com.e_er_de.jazzngisoringin2017.ui.artist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e_er_de.jazzngisoringin2017.R;
import com.e_er_de.jazzngisoringin2017.model.Artist;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ILM on 8/1/2016.
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.VersionViewHolder> {

    private List<Artist> artistList;
    private int rowLayout;
    Context context;
    OnItemClickListener clickListener;

    public ArtistAdapter(List<Artist> login, int rowLayout, Context context, OnItemClickListener listener) {
        this.artistList = login;
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
        final Artist model = artistList.get(i);
        versionViewHolder.bind(model, clickListener);
    }

    @Override
    public int getItemCount() {
        return artistList == null ? 0 : artistList.size();
    }

    public void animateTo(List<Artist> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<Artist> newModels) {
        for (int i = artistList.size() - 1; i >= 0; i--) {
            final Artist model = artistList.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Artist> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Artist model = newModels.get(i);
            if (!artistList.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Artist> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Artist model = newModels.get(toPosition);
            final int fromPosition = artistList.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Artist removeItem(int position) {
        final Artist model = artistList.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, Artist model) {
        artistList.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Artist model = artistList.remove(fromPosition);
        artistList.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    class VersionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_hari_service)TextView titleRes;
        @BindView(R.id.txt_edc_sn)TextView descRes;

        public VersionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Artist model, final OnItemClickListener listener) {
            titleRes.setText(model.getName());
            descRes.setText(model.getType());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(model);

                }
            });
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(Artist model);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
