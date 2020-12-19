package com.example.nicho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        this.arrayAdapterListView();
    }


    private void arrayAdapterListView()
    {
        setTitle("Favourite Songs");

        List<String> dataList = new ArrayList<String>();
        dataList.add("Only One for me");
        dataList.add("Fall");
        dataList.add("Baby gal");
        dataList.add("Inabana");
        dataList.add("Pull Up");
        dataList.add("Byafaayo");
        dataList.add("Wine Wine");

        ListView listView = (ListView)findViewById(R.id.mine);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                Toast.makeText(Lists.this, "You clicked " + clickItemObj.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}