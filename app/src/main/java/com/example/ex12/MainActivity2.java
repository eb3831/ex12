package com.example.ex12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent gi = getIntent();

        TextView resultValue = findViewById(R.id.resultValue);
        String result = gi.getStringExtra("result");
        resultValue.setText("THE LAST RESULT WAS: " + result);
    }
    public void backToMain(View view) {
        finish();
    }
}