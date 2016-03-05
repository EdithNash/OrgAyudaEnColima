package com.example.sonia.orgayudaencolima;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Organizaciones extends AppCompatActivity {
    //arreglos de titulos e imagenes
    ListViewAdapterOrg adapter;

    String[] titulo = new String[]{
            "Caminemos Juntos con Amor, Luz y Esperanza A.C.",
            "Antes de Partir A.C.",
            "Fundación Ceili",
            "Fundación para la Protección de la Niñez"
    };

    int[] imagenes = {
            R.drawable.caminemos,
            R.drawable.adp,
            R.drawable.ceili,
            R.drawable.ninez1
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Seleccionar opción", Toast.LENGTH_SHORT).show();
            }
        });
        /// selecciona la lista en pantalla segun su ID
        final ListView listaOrg = (ListView) findViewById(R.id.Org);
        adapter = new ListViewAdapterOrg(this, titulo, imagenes);
        listaOrg.setAdapter(adapter);


        // registra una acción para el evento click
        listaOrg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                //LLamado a otra activity
                switch (i) {
                    case 0:
                        //setContentView(R.layout.activity_maps_caminemos);
                       setContentView(R.layout.activity_caminemosjuntos);
                        // muestra un mensaje
                        //Toast.makeText(getApplicationContext(), "Tel. 312 594 83 46 ", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //setContentView(R.layout.activity_antesdepartir);
                        setContentView(R.layout.activity_maps_antes_partir);
                        break;
                    case 2:
                        setContentView(R.layout.activity_ceili);
                        //setContentView(R.layout.activity_maps_ceili);
                        break;
                    case 3:
                        setContentView(R.layout.activity_ninez);
                        //setContentView(R.layout.activity_maps_ninez);
                        break;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_organizaciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
