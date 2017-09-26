package com.asmasyakirah.android_custom_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity
{
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToListView(View view)
    {
        // Get button tag
        int tag = Integer.parseInt(view.getTag().toString());

        switch (tag)
        {
            case 0:
                intent = new Intent(this, SimpleBaseAdapterActivity.class);
                break;

            case 1:
                intent = new Intent(this, SimpleArrayAdapterActivity.class);
                break;

            case 2:
                intent = new Intent(this, ExpandableActivity.class);
                break;

            default:
                intent = null;
        }

        if (intent != null)
        {
            startActivity(intent);
        }
    }
}
