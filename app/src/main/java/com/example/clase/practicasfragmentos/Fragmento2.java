package com.example.clase.practicasfragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Clase on 01/12/2015.
 */
public class Fragmento2 extends Fragment {
    private View viewFragment;
    private TextView tvNombre,tvTelefonos;
    private Contacto contacto;

    public Fragmento2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragmento2, container, false);
        tvNombre= (TextView) viewFragment.findViewById(R.id.tvnom);
        tvTelefonos = (TextView)viewFragment.findViewById(R.id.tvnumeros);

        return viewFragment;
    }
    public void setDato(Contacto contacto){

        tvNombre.setText(contacto.getNombre());
        List<String> numero=contacto.getNumeros();
        System.out.println("luisa"+numero.toString());

            tvTelefonos.setText(numero.toString());


    }
}
