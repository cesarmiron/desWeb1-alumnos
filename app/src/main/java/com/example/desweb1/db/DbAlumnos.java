package com.example.desweb1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.desweb1.entidades.Alumnos;

import java.util.ArrayList;

public class DbAlumnos extends DbHelper {
    Context context;

    public DbAlumnos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarAlumnos(String nombre, Integer telefono, String correo_electronico, String direccion){

        long id = 0;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);
            values.put("direccion", direccion);

            id = db.insert(TABLE_ALUMNOS,  null, values);
        } catch (Exception ex){
            ex.toString();
        }
            return id;
    }

    public ArrayList<Alumnos> mostrarAlumnos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Alumnos> listaAlumnos = new ArrayList<>();
        Alumnos alumno = null;
        Cursor cursorAlumnos = null;

        cursorAlumnos = db.rawQuery("SELECT * FROM " + TABLE_ALUMNOS, null);
        if (cursorAlumnos.moveToFirst()){
            do {
                alumno = new Alumnos();
                alumno.setId(cursorAlumnos.getInt(0));
                alumno.setNombre(cursorAlumnos.getString(1));
                alumno.setTelefono(cursorAlumnos.getInt(2));
                alumno.setCorreo_electronico(cursorAlumnos.getString(3));
                alumno.setDireccion(cursorAlumnos.getString(4));
                listaAlumnos.add(alumno);
            }while (cursorAlumnos.moveToNext());
        }
        cursorAlumnos.close();

        return listaAlumnos;
    }
}
