package com.example.step.rasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.step.MainActivity;
import com.example.step.PostServies;
import com.example.step.R;
import com.example.step.RetrofitHelper;
import com.google.gson.internal.bind.JsonTreeReader;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RaspActivity extends AppCompatActivity {
    ListView listView;
     ArrayList<Group> arrayList;
    static ArrayList<Group> groups;
    private ArrayAdapter<Group> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasp);
        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        groups = new ArrayList<>();
        PostServies s = RetrofitHelper.instance().create(PostServies.class);
        Call<ArrayList<ArrayList<String>>> call = s.getData("1Kkk3XekYQ2qn1lkCC3uHp4sWhA8syyPyn6yLeBffBCY","kakoi");
        call.enqueue(new Callback<ArrayList<ArrayList<String>>>() {
            @Override
            public void onResponse(Call<ArrayList<ArrayList<String>>> call, Response<ArrayList<ArrayList<String>>> response) {
                ArrayList<ArrayList<String>> data = response.body();
                Group group = null;
                int day = -1;
                for (ArrayList<String> raw:data){
                    for (int i = 0; i < raw.size(); i++) {
                        String s = raw.get(i);
                        Pattern pattern = Pattern.compile("([А-Я]+\\-\\d{2}\\-\\d{2})$");
                        Matcher matcher = pattern.matcher(s);

                        if (matcher.find()) {
                            group = new Group(i, matcher.group(1),Integer.parseInt(matcher.group(1).split("\\-")[2]));
                            arrayList.add(group);
                            groups.add(group);
                            day = -1;
                        } else {
                            if (5 == raw.size()) {
                                if (s.contains("День недели") && i == 0) {
                                    continue;
                                }
                                if (!s.equals("") && i == 0) {
                                    day = day +1;
                                }
                                if (day >= 0 && group != null) {
                                    Teacher t = new Teacher(raw.get(3));
                                    Subject sub = new Subject(raw.get(2) + raw.get(4));
                                    Lesson lesson = new Lesson(t,group,sub,"","",day);
                                    group.lessons.add(lesson);
                                    break;
                                }
                            } else {

                            }
                        }
                    }
                }
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<ArrayList<String>>> call, Throwable t) {

            }
        });
        arrayAdapter = new ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Intent intent = new Intent(RaspActivity.this, RaspActivity3.class);
                intent.putExtra("abrakatabra", i);
                startActivity(intent);
            }
        });
    }
}
