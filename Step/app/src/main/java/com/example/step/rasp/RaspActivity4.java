package com.example.step.rasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.step.PostServies;
import com.example.step.R;
import com.example.step.RetrofitHelper;

import java.util.ArrayList;

import retrofit2.Call;

public class RaspActivity4 extends AppCompatActivity {
    ListView listView;
    ArrayList arrayList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp4);
        listView = findViewById(R.id.lv);
        int group = getIntent().getIntExtra("group", 0);
        int day = getIntent().getIntExtra("day", 0);
        Group g = RaspActivity.groups.get(group);
        for (int i = 0; i < g.lessons.size(); i++) {
            Lesson lesson = g.lessons.get(i);
            if (lesson.getDay0fWeek() == day)
            arrayList.add(lesson);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(arrayAdapter);
    }
}