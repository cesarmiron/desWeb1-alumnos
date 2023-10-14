package com.example.desweb1.adaptadores;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desweb1.R;
import com.example.desweb1.entidades.Alumnos;

import java.util.ArrayList;

public class ListaAlumnosAdapter extends RecyclerView.Adapter<ListaAlumnosAdapter.AlumnoViewHolder> {

    ArrayList<Alumnos> listaAlumnos;

    public ListaAlumnosAdapter(ArrayList<Alumnos> listaAlumnos){
        this.listaAlumnos = listaAlumnos;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_alumnos, null, false);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        holder.viewNombre.setText(listaAlumnos.get(position).getNombre());
        holder.viewTelefono.setText(listaAlumnos.get(position).getTelefono());
        holder.viewCorreo.setText(listaAlumnos.get(position).getCorreo_electronico());
        holder.viewDireccion.setText(listaAlumnos.get(position).getDireccion());

    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewCorreo, viewDireccion;
        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);
            viewDireccion = itemView.findViewById(R.id.viewDireccion);

        }
    }
}
