package com.example.desweb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_us2);
    }

    public void oncClick(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity.class);
        if(intent != null){
            startActivity(intent);
        }


    }
}