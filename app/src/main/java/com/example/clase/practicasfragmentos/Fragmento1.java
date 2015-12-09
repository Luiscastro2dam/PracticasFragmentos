package com.example.clase.practicasfragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Clase on 01/12/2015.
 */
public class Fragmento1 extends Fragment {
    View viewFragment;
    private ListView lv;
    private static Adaptador ad;
    private ArrayList<Contacto> lista;
    private OnFragmentoInteraccionListener listener;
    MetodosObtener listaContactos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragmento1, container, false);

        lv=(ListView)viewFragment.findViewById(R.id.listView);
        MetodosObtener listaContactos=new MetodosObtener(getActivity());
        lista = (ArrayList<Contacto>) MetodosObtener. getContactos();
        for (Contacto aux:lista)
            aux.setNumeros(listaContactos.getNumeros(getActivity(), aux.getId()));
        ad = new Adaptador(getActivity(),R.layout.item,lista);
        lv.setAdapter(ad);
        lv.setTag(lista);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   listener.onInteraccion(lista.get(position));
            }
        });

        return  viewFragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentoInteraccionListener){
            listener= (OnFragmentoInteraccionListener) context;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnFragmentoInteraccionListener){
            listener= (OnFragmentoInteraccionListener) activity;
        }
    }
    public static void resetear(){
        MetodosObtener.ordenar();
        ad.notifyDataSetChanged();
    }


}
