package com.asmasyakirah.android_custom_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SimpleBaseAdapterActivity extends AppCompatActivity
{
    private static final int TITLE = R.string.list_simple_base_adapter;
    private static final int REFERENCE_URL = R.string.list_simple_base_adapter_url;

    Context context;
    ListView listView;
    TextView details;

    public static int [] images =
    {
            R.drawable.manhole,
            R.drawable.cone,
            R.drawable.highway,
            R.drawable.bridge_rail
    };

    public static String [] names =
    {
            "Manhole",
            "Cone",
            "Highway",
            "Bridge Rail"
    };

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
        context=this;

        // Implement listView using BaseAdapter
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new SimpleBaseAdapter(this, names, images));
    }
}
