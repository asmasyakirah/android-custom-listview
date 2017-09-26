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

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<Layer>
{
    private Context context;
    private int resource;
    private List<Layer> layers;

    //constructor initializing the values
    public CustomArrayAdapter(Context context, int resource, List<Layer> layers)
    {
        super(context, resource, layers);
        this.context = context;
        this.resource = resource;
        this.layers = layers;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View rowView = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView img = rowView.findViewById(R.id.thumbnailImageView);
        TextView tv = rowView.findViewById(R.id.thumbnailName);

        //getting the hero of the specified position
        Layer hero = layers.get(position);

        //adding values to the list item
        img.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        tv.setText(hero.getName());

        //adding a click listener to the button to remove item from the list
        img.setOnClickListener(new View.OnClickListener()
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
