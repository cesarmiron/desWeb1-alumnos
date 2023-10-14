package com.example.desweb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.desweb1.db.DbHelper;

public class CrudActivity extends AppCompatActivity {

    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);


    }
    public void oncClick(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity.class);
        if(intent != null){
            startActivity(intent);
        }

    }
    public void oncClick4(View view){
        Intent intent = null;
        intent = new Intent(this, RegistrarActivity.class);
        if(intent != null){
            startActivity(intent);
        }

    }
    public void oncClick5(View view){
        Intent intent = null;
        intent = new Intent(this, ListarActivity.class);
        if(intent != null){
            startActivity(intent);
        }


    }


}