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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SimpleArrayAdapter extends ArrayAdapter<Layer>
{
    private Context context;
    private int resource;
    private List<Layer> layers;

    //constructor initializing the values
    public SimpleArrayAdapter(Context context, int resource, List<Layer> layers)
    {
        super(context, resource, layers);
        this.context = context;
        this.resource = resource;
        this.layers = layers;
    }

    private class Holder
    {
        TextView tv;
        ImageView img;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Layer layer = layers.get(position);

        Holder holder = new Holder();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View rowView = layoutInflater.inflate(resource, null, false);
        holder.img = rowView.findViewById(R.id.thumbnailImageView);
        holder.tv = rowView.findViewById(R.id.thumbnailName);
        holder.tv.setText(layer.getName());
        holder.img.setImageResource(layer.getImage());

        /*
        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context, "You clicked "+ layers.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });
        */

        //adding a click listener to the button to remove item from the list
        holder.img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                removeLayer(position);
            }
        });

        //finally returning the view
        return rowView;
    }

    //this method will remove the item from the list
    private void removeLayer(final int position)
    {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");

        //if the response is positive in the alert
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //removing the item
                layers.remove(position);

                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
