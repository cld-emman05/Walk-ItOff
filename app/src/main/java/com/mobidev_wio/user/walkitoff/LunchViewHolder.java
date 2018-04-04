package com.mobidev_wio.user.walkitoff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 14/03/2018.
 */

public class LunchViewHolder extends RecyclerView.ViewHolder {

    private TextView nameText;
    private TextView descriptionText;
    private TextView calorieText;
    private int modelIndex = -1;

    public LunchViewHolder(View itemView) {
        super(itemView);

        this.nameText = itemView.findViewById(R.id.food_name_text);
        this.descriptionText = itemView.findViewById(R.id.food_desc_text);
        this.calorieText = itemView.findViewById(R.id.food_cal);

    }

    public TextView getNameText()
    {
        return nameText;
    }

    public TextView getDescriptionText()
    {
        return descriptionText;
    }

    public TextView getCalorieText()
    {
        return calorieText;
    }

    public void setModelIndex(int modelIndex)
    {
        this.modelIndex = modelIndex;
    }
}
