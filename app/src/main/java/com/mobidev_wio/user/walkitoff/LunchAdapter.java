package com.mobidev_wio.user.walkitoff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by user on 14/03/2018.
 */

public class LunchAdapter extends RecyclerView.Adapter<LunchViewHolder> {
        ArrayList<Food> modelList;

public LunchAdapter(ArrayList<Food> lunch){
        this.modelList = lunch;
        }

@Override
public LunchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInstance = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_list, parent, false);

        return new LunchViewHolder(viewInstance);
        }

@Override
public void onBindViewHolder(LunchViewHolder holder, int position) {
        Food model = this.modelList.get(position);

        holder.setModelIndex(position);
        holder.getNameText().setText(model.getName());
        holder.getDescriptionText().setText(model.getDescription());
        holder.getCalorieText().setText(model.getCaloriesString());
        }

@Override
public int getItemCount() {
        return this.modelList.size();
        }
}
