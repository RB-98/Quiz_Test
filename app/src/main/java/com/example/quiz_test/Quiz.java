package com.example.quiz_test;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private DomandeLista libreriaDomande = new DomandeLista();

    private TextView punteggioTot;   // punteggio totale corrente
    private TextView domanda;  // domanda a cui si deve rispondere attualmente
    private TextView numQuesito; // numero della domanda a cui si deve rispondere attualmente
    private Button btnScelta1; // scelta multipla 1 per la domanda corrente
    private Button btnScelta2; // scelta multipla 2 per la domanda corrente
    private Button btnScelta3; // scelta multipla 3 per la domanda corrente
    private Button btnScelta4; // scelta multipla 4 per la domanda corrente

    private String rispostaGiusta;  // risposta corretta per a domanda attuale
    private int punt = 0;  // punteggio corrente
    private int numDomanda = 0; // numero della domanda

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // cambia il colore del testo dell' action bar
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        // prepara la schermata per la prima domanda con quattro risposte da scegliere
        punteggioTot = findViewById(R.id.punteggio);
        numQuesito = findViewById(R.id.numDomanda);
        domanda = findViewById(R.id.domanda);
        btnScelta1 = findViewById(R.id.scelta1);
        btnScelta2 = findViewById(R.id.scelta2);
        btnScelta3 = findViewById(R.id.scelta3);
        btnScelta4 = findViewById(R.id.scelta4);

        libreriaDomande.initDomande(getApplicationContext());
        aggiornaDomanda();
        // mostra il punteggio corrente totale al giocatore
        aggiornaPunteggio(punt);
    }

    private void aggiornaDomanda(){
        // controlla se ci sono altre domande
        if(numDomanda<libreriaDomande.getLunghezza() ){
            // cambia il testo per la nuova domanda con le relative nuove risposte
            numQuesito.setText("Domanda n."+Integer.toString(numDomanda+1));
            domanda.setText(libreriaDomande.getDomanda(numDomanda));
            btnScelta1.setText(libreriaDomande.getScelta(numDomanda, 1));
            btnScelta2.setText(libreriaDomande.getScelta(numDomanda, 2));
            btnScelta3.setText(libreriaDomande.getScelta(numDomanda, 3));
            btnScelta4.setText(libreriaDomande.getScelta(numDomanda,4));
            rispostaGiusta = libreriaDomande.getRisposta(numDomanda);
            numDomanda++;
        }
        else {
            Toast.makeText(Quiz.this, "Era l' ultima domanda!!! Quiz concluso!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Quiz.this, MainActivity.class);
            intent.putExtra("punteggio", punt); // passa il punteggio alla seconda schermata
            startActivity(intent);
        }
    }

    // mostra il punteggio totale al giocatore
    private void aggiornaPunteggio(int punti) {
        punteggioTot.setText(""+punt+"/"+libreriaDomande.getLunghezza());
    }

    public void onClick(View view) {
        //funzionamento bottone risposta
        Button risposta = (Button) view;
        // se la risposta e' giusta, aumenta il punteggio
        if (risposta.getText().equals(rispostaGiusta)){
            punt = punt + 1;
            Toast.makeText(Quiz.this, "Risposta Esatta!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(Quiz.this, "Risposta Sbagliata!", Toast.LENGTH_SHORT).show();
        // mostra il punteggio corrente totale al giocatore
        aggiornaPunteggio(punt);
        // quando l' utente ha risposto alla domanda attuale, ci si sposta alla prossima se presente
        aggiornaDomanda();
    }
}