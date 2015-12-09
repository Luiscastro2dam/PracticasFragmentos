package com.example.clase.practicasfragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements OnFragmentoInteraccionListener {

    private String valor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        MetodosObtener listaContactos=new MetodosObtener(this);
    }
    //------------menu principal--------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.agregar: {
                Intent i = new Intent(this,Agregar.class);
                startActivity(i);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    //-----------------------------------------------------------
    @Override
    public void onInteraccion(Contacto contacto) {
        Fragmento2 fragment = (Fragmento2) getFragmentManager().findFragmentById(R.id.fragmentDetall);
        if (fragment == null || !fragment.isInLayout()) {
            //Vertical
            Intent i=new Intent (this,ActividadSecundaria.class);
            Bundle b= new Bundle();
            b.putSerializable("contacto", contacto);
            i.putExtras(b);
            startActivity(i);
        }else{
            //Horizontal
            fragment.setDato(contacto);
        }
    }


}
