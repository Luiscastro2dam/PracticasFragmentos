package com.example.clase.practicasfragmentos;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Clase on 01/12/2015.
 */
public class ActividadSecundaria extends Activity {
    private Contacto contacto;
    private Contacto contactodos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactodos=null;
        if(savedInstanceState!=null){
            contactodos=(Contacto)savedInstanceState.getSerializable("valor");
        }

        if(contactodos==null){
            setContentView(R.layout.actividad2);
            contacto = (Contacto)getIntent().getExtras().getSerializable("contacto");
            Fragmento2 fragmento = (Fragmento2) getFragmentManager().findFragmentById(R.id.fragmentActidos);
            fragmento.setDato(contacto);
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("valor", contacto);
    }


}
