package com.example.sonia.orgayudaencolima;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class caminemosjuntos extends AppCompatActivity implements OnClickListener {

    private TextView uriweb;
    private TextView direction;
    private TextView makecall;
    private Intent callIntent;
    private String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caminemosjuntos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Gracias!!", Toast.LENGTH_SHORT).show();
            }
        });

        direction = (TextView)findViewById(R.id.uridireccion);
        uriweb = (TextView)findViewById(R.id.uriweb);
        makecall = (TextView)findViewById(R.id.makecall);

        direction.setOnClickListener(this);
        uriweb.setOnClickListener(this);
        makecall.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uridireccion:
                setContentView(R.layout.activity_maps_caminemos);
                break;
            case R.id.uriweb:
                urlWeb();
                break;
            case R.id.makecall:
                call();
                break;
        }
    }

    public void call(){
       try{
           callIntent=new Intent(Intent.ACTION_CALL);
           callIntent.setData(Uri.parse("3121223099"));
           startActivity(callIntent);
       }catch (ActivityNotFoundException ex){
           Log.e("Dialog", "Error",ex );
       }
    }

    public void urlWeb(){
        try{
            d = "https://www.facebook.com/CaminemosJuntosConAmorLuzYEsperanza/";
            Uri uri = Uri.parse(d);
            Intent intnav = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intnav);
        }catch (ActivityNotFoundException ex){
            Log.e("Dialog", "Error",ex );
        }
    }


}
