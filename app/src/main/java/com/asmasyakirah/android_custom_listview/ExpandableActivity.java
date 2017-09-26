package com.asmasyakirah.android_custom_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableActivity extends AppCompatActivity
{
    private static final int TITLE = R.string.list_expandable;
    private static final int REFERENCE_URL = R.string.list_expandable_url;

    ListView listView;
    ArrayList layers;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setupUI();
        setupListView();
    }

    private void setupUI()
    {
        // Setup title and description
        setTitle(getString(TITLE));
        details = (TextView) findViewById(R.id.detailTextView);
        details.setText(getString(R.string.title));
        details.append(getString(TITLE));
        details.append(getString(R.string.reference));
        details.append(getString(REFERENCE_URL));
    }

    private void setupListView()
    {
        //initializing objects
        //adding some values to our list
        layers = new ArrayList<>();
        layers.add(new Layer("Manhole", R.drawable.manhole));
        layers.add(new Layer("Cone", R.drawable.cone));
        layers.add(new Layer("Highway", R.drawable.highway));
        layers.add(new Layer("Bridge Rail", R.drawable.bridge_rail));

        //creating the adapter
        ExpandableArrayAdapter adapter = new ExpandableArrayAdapter(this, R.layout.list_expandable, layers);

        //attaching adapter to the listview. Hide divider.
        listView = (ListView) findViewById(R.id.listView);
        listView.setDivider(null);
        listView.setAdapter(adapter);
    }
}
