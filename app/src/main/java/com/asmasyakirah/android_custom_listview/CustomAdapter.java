package com.asmasyakirah.android_custom_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter
{
    private static LayoutInflater inflater=null;

    private Context context;
    private String [] names;
    private int [] images;

    public CustomAdapter(Activity context, String[] names, int[] images)
    {
        this.context = context;
        this.names = names;
        this.images = images;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return names.length;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    private class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Holder holder = new Holder();
        View rowView = inflater.inflate(R.layout.list_thumbnail_1, null);
        holder.tv = rowView.findViewById(R.id.thumbnailName);
        holder.img = rowView.findViewById(R.id.thumbnailImageView);
        holder.tv.setText(names[position]);
        holder.img.setImageResource(images[position]);
        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context, "You clicked "+ names[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
