package com.example.clase.practicasfragmentos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Agregar extends AppCompatActivity {
       private EditText et1;
       private  EditText et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);//metemos el layout

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

    }
    /*evento del boton de agregar*/
    public void agregar(View v){
       // List<Contacto> personas;
       // personas=MetodosObtener.getListaContactos(this);
       // long id = personas.size();
        long id = MetodosObtener.devolverid();
        String nombre;
        String telefono;
        ArrayList<String> numeros = new ArrayList<>();
        /*introducimos los datos del texto*/
        nombre = et1.getText().toString();
        telefono = et2.getText().toString();

        if(!nombre.isEmpty() && !telefono.isEmpty()) {
            numeros.add(telefono);//metemos el telefono en el arrayList
            MetodosObtener.agregarContactos(new Contacto(id, nombre, numeros));
            Fragmento1.resetear();//para que lo muestre despuedes de añadirlo
            finish();//cerramos
        }if(nombre.isEmpty() && !telefono.isEmpty()){
            Toast.makeText(getApplicationContext(), "Nombre vacio rellenalo", Toast.LENGTH_LONG).show();
        }else if(telefono.isEmpty()&&!nombre.isEmpty()){
            Toast.makeText(getApplicationContext(), "Telefono vacio rellenalo", Toast.LENGTH_LONG).show();
        }else{
           // Toast.makeText(getApplicationContext(), "Debes rellenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
    /*evento del boton salir*/
    public void  salir(View v){
        finish(); //cierra la ventana
    }
}
