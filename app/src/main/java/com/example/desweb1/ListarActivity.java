package com.example.desweb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.desweb1.adaptadores.ListaAlumnosAdapter;
import com.example.desweb1.db.DbAlumnos;
import com.example.desweb1.entidades.Alumnos;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    RecyclerView listaAlumnos;
    ArrayList<Alumnos> listaArrayAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        listaAlumnos = findViewById(R.id.listaAlumnos);
        listaAlumnos.setLayoutManager(new LinearLayoutManager(this));

        DbAlumnos dbAlumnos = new DbAlumnos(ListarActivity.this);

        listaArrayAlumnos = new ArrayList<>();

        ListaAlumnosAdapter adapter = new ListaAlumnosAdapter(dbAlumnos.mostrarAlumnos());
        listaAlumnos.setAdapter(adapter);

    }
}