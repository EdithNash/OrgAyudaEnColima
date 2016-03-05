package com.example.sonia.orgayudaencolima;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class antesdepartir extends AppCompatActivity {
    private TextView uriweb;
    private TextView direction;
    private TextView makecall;
    private Intent callIntent;
    private String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antesdepartir);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Gracias!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        direction = (TextView)findViewById(R.id.uridireccion);
        uriweb = (TextView)findViewById(R.id.uriweb);
        makecall = (TextView)findViewById(R.id.makecall);

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setContentView(R.layout.activity_maps_caminemos);

                   /* Intent i = new Intent(this,MapsCaminemos.class );
                    startActivity(i);*/
                } catch (ActivityNotFoundException ex) {
                    Log.e("Dialog", "Error", ex);
                }
            }
        });

        uriweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlWeb();
            }
        });

        makecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
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
