package com.example.quiz_test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // cambia il colore del testo dell' action bar
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));

        TextView txtPunteggio = findViewById(R.id.txtPunteggio);
        TextView txtMaxPunteggio = findViewById(R.id.txtPunteggioMassimo);
        // riceve il punteggio dell' ultima attivita' dall' intent
        Intent intent = getIntent();
        int punt = intent.getIntExtra("punteggio", 0);
        // mostra il punteggio attuale
        txtPunteggio.setText("Il tuo Punteggio: " + punt);

        // salva il punteggio migliore
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        int maxPunt = sPref.getInt("Migliore",0);
        if(maxPunt>punt)
            txtMaxPunteggio.setText("Migliore: "+maxPunt);
        else
        {
            txtMaxPunteggio.setText("Migliore: "+punt);
            SharedPreferences.Editor editor = sPref.edit();
            editor.putInt("Migliore", punt);
            editor.commit();
        }
    }

    public void onRepeatClick(View view) {
        Intent intent = new Intent(MainActivity.this, Quiz.class);
        startActivity(intent);
    }
}