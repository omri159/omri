package com.example.hp1.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
    ListView lvSchedule;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrhours= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrhours.add("Arabic");
        arrhours.add("Hebrow");
        arrhours.add("Englesh");
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrhours);
        lvSchedule=(ListView)findViewById(R.id.lvSchedule);
        lvSchedule.setAdapter(adapter);
        lvSchedule.setBackgroundColor(Color.DKGRAY);
        lvSchedule.setOnItemClickListener(this);
        lvSchedule.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, arrhours.get(position), Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        arrhours.remove(position);
        adapter.notifyDataSetChanged();
        return false;
    }

}