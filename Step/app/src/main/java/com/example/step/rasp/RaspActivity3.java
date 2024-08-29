package com.example.step.rasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.step.R;

import java.util.ArrayList;

public class RaspActivity3 extends AppCompatActivity {
    ListView listView;
    public static ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp);
        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.add("Понедельник");
        arrayList.add("Вторник");
        arrayList.add("Среда");
        arrayList.add("Четверг");
        arrayList.add("Пятница");
        arrayList.add("Суббота");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Intent intent = new Intent(RaspActivity3.this, RaspActivity4.class);
                int group = getIntent().getIntExtra("abrakatabra", i);
                intent.putExtra("day", i);
                intent.putExtra("group", group );
                startActivity(intent);
        };
    });
}
}