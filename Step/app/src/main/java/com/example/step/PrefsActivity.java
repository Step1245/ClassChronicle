package com.example.step;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PrefsActivity extends AppCompatActivity {
    private EditText keyET, valueET;
    private Button saveBtn, getBtn;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs);
       this.keyET = findViewById(R.id.keyET);
       this.valueET = findViewById(R.id.valueET);
       this.saveBtn = findViewById(R.id.saveBtn);
       this.getBtn = findViewById(R.id.getBtn);
       this.saveBtn.setOnClickListener(this::saveAction);
       this.getBtn.setOnClickListener(this::getAction);
       this.preferences = getPreferences(MODE_PRIVATE);
    }

    public void getAction (View v) {
        String key = keyET.getText().toString();
        String value = preferences.getString(key, "NOT_FOUND");
        valueET.setText(value);
    }
    public void saveAction (View v) {
        String key = keyET.getText().toString();
        String value = valueET.getText().toString();
        if (key.isEmpty() || value.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.apply();
        keyET.setText("");
        valueET.setText("");
    }
}