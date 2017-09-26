package com.asmasyakirah.android_custom_listview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ExpandableArrayAdapter extends ArrayAdapter<Layer>
{
    private Context context;
    private int resource;
    private List<Layer> layers;

    //constructor initializing the values
    public ExpandableArrayAdapter(Context context, int resource, List<Layer> layers)
    {
        super(context, resource, layers);
        this.context = context;
        this.resource = resource;
        this.layers = layers;
    }

    private class Holder
    {
        LinearLayout headLayout;
        LinearLayout bodyLayout;
        ImageView toggleImg;
        TextView titleTv;
        TextView descriptionTv;
        ImageView descriptionImg;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Layer layer = layers.get(position);

        final Holder holder = new Holder();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View rowView = layoutInflater.inflate(resource, null, false);
        holder.headLayout = rowView.findViewById(R.id.headLayout);
        holder.bodyLayout = rowView.findViewById(R.id.bodyLayout);
        holder.toggleImg = rowView.findViewById(R.id.toggleImageView);
        holder.titleTv = rowView.findViewById(R.id.titleTextView);
        holder.descriptionTv = rowView.findViewById(R.id.descriptionTextView);
        holder.descriptionImg = rowView.findViewById(R.id.descriptionImageView);
        holder.titleTv.setText(layer.getName());
        holder.descriptionTv.setText(layer.getName() + " " + layer.getName() + " " + layer.getName());
        holder.descriptionImg.setImageResource(layer.getImage());

        // Add this to disable click effect.
        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Do nothing
            }
        });

        //adding a click listener to the button to remove item from the list
        holder.headLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                toggleView(holder, position);
            }
        });

        //finally returning the view
        return rowView;
    }

    private void toggleView(Holder holder, final int position)
    {
        switch (holder.bodyLayout.getVisibility())
        {
            case View.VISIBLE:
                holder.bodyLayout.setVisibility(View.GONE);
                holder.toggleImg.setImageResource(R.drawable.circle_down);
                break;

            default:
                holder.bodyLayout.setVisibility(View.VISIBLE);
                holder.toggleImg.setImageResource(R.drawable.circle_right);
        }
    }
}
