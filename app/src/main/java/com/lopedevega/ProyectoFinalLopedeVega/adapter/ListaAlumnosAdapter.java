package com.lopedevega.ProyectoFinalLopedeVega.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lopedevega.ProyectoFinalLopedeVega.R;
import com.lopedevega.ProyectoFinalLopedeVega.entities.Alumnos;

import java.util.ArrayList;

public class ListaAlumnosAdapter extends RecyclerView.Adapter<ListaAlumnosAdapter.AlumnoViewHolder> {

    ArrayList<Alumnos> listaAlumnos;

    public ListaAlumnosAdapter(ArrayList<Alumnos> listaAlumnos){
        this.listaAlumnos = listaAlumnos;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumno_item, null, false);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {

        holder.viewNombre.setText(listaAlumnos.get(position).getNombre());
        holder.viewTelefono.setText(listaAlumnos.get(position).getTelefono());
        holder.viewCorreo.setText(listaAlumnos.get(position).getCorreo_electronico());

    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewCorreo;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.tvNombre);
            viewTelefono = itemView.findViewById(R.id.tvTelefono);
            viewCorreo = itemView.findViewById(R.id.tvCorreo);

        }
    }
}
