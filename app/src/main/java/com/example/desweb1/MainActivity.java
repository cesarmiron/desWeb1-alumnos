package com.example.desweb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void oncClick(View view){
        Intent intent = null;
        intent = new Intent(this, Activity2.class);
        if(intent != null){
            startActivity(intent);
        }

    }
    public void oncClick2(View view){
        Intent intent = null;
        intent = new Intent(this, UsActivity2.class);
        if(intent != null){
            startActivity(intent);
        }

    }
    public void oncClick3(View view){
        Intent intent = null;
        intent = new Intent(this, ContactoActivity.class);
        if(intent != null){
            startActivity(intent);
        }

    }
    public void oncClick4(View view){
        Intent intent = null;
        intent = new Intent(this, CrudActivity.class);
        if(intent != null){
            startActivity(intent);
        }
    }
}