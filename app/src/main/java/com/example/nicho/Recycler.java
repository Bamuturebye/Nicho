package com.example.nicho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    WorkOne adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView=findViewById(R.id.university);

        ArrayList<String> elements = new ArrayList<>();
        elements.add("MUST");
        elements.add("IUIU");
        elements.add("KIU");
        elements.add("KYU");
        elements.add("MUK");
        elements.add("UMU");

        //set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new WorkOne(this,elements);
        //adapter.setClickListener((ItemClickListener) this);;
        recyclerView.setAdapter(adapter);

    }

    //    @Override
    public void onItemClick(View view, int position) {

    }

}
