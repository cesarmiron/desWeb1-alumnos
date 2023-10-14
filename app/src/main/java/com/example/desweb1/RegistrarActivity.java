package com.example.desweb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.desweb1.db.DbAlumnos;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrarActivity extends AppCompatActivity {

    EditText txtId, txtNombre, intTelefono, txtCorreoElectronico, txtDireccion;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtId = findViewById(R.id.idId);
        txtNombre = findViewById(R.id.idNombre);
        intTelefono = findViewById(R.id.idCelular);
        txtCorreoElectronico = findViewById(R.id.idCorreo);
        txtDireccion = findViewById(R.id.idDireccion);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerWs();
                /*enviarWs(txtNombre.getText().toString(), intTelefono.getText().toString(), txtCorreoElectronico.getText().toString(),
                        txtDireccion.getText().toString());*/

            }
        });

        /* public void onClick(View view) {
             DbAlumnos dbAlumnos = new DbAlumnos(RegistrarActivity.this);
             long id = dbAlumnos.insertarAlumnos(txtNombre.getText().toString(), Integer.valueOf(intTelefono.getText().toString()),
                     txtCorreoElectronico.getText().toString(), txtDireccion.getText().toString());

             if (id > 0){
                 Toast.makeText(RegistrarActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                 limpiar();
             }else {
                 Toast.makeText(RegistrarActivity.this, "REGISTRO NO GUARDADO", Toast.LENGTH_LONG).show();
             }
         }*/
    }

    private void LeerWs() {

        String url = "http://34.31.199.77/api/get-alumno";

        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtId.setText(jsonObject.getString("id"));
                    txtNombre.setText(jsonObject.getString("nombre"));
                    intTelefono.setText(jsonObject.getString("telefono"));
                    txtCorreoElectronico.setText(jsonObject.getString("correo"));
                    txtDireccion.setText(jsonObject.getString("direcccion"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }

    /*private void enviarWs(final String nombre, final String telefono, final String correo, final String direccion) {

        String url = "http://34.31.199.77/api/save-alumno";

        StringRequest postResquest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegistrarActivity.this, "RESULTADO PUT = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("telefono", telefono);
                params.put("correo", correo);
                params.put("direccion", direccion);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(postResquest);
    }*/



    /*private void limpiar(){
        txtNombre.setText("");
        intTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtDireccion.setText("");
        btnRegistrar.setText("");

    }*/
    public void oncClick(View view){
        Intent intent = null;
        intent = new Intent(this, MainActivity.class);
        if(intent != null){
            startActivity(intent);
        }
    }
}