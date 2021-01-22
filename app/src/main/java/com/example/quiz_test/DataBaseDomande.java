package com.example.quiz_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseDomande extends SQLiteOpenHelper {
    // nome Database
    public static String DATABASE_QUESTION = "domandaLista.db";
    // versione attuale database
    private static final int DATABASE_VERSION = 1;
    // nome tabella database
    private static final String TABLE_QUESTION = "DomandeLista";
    // tutti i campi usati nella tabella
    private static final String KEY_ID = "id";
    private static final String QUESTION = "domanda";
    private static final String CHOICE1 = "scelta1";
    private static final String CHOICE2 = "scelta2";
    private static final String CHOICE3 = "scelta3";
    private static final String CHOICE4 = "scelta4";
    private static final String ANSWER = "risposta";

    // la tabella delle domande crea la query in questa stringa
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE "
            + TABLE_QUESTION + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + " TEXT, " + CHOICE2 + " TEXT, " + CHOICE3 + " TEXT, "
            + CHOICE4 + " TEXT, " + ANSWER + " TEXT);";

    public DataBaseDomande(Context context) {
        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);
    }

    //questo metodo e' chiamato dal sistema se si accede al database ma non e' ancora stato creato
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUESTION); //creazione tabella domanda
    }

    //questo metodo viene chiamato quando qualsiasi modifica viene fatta al database (es: cambiamento versione)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION); //rilascia la tabella se esiste
        onCreate(db);
    }

    //metodo usato per aggiungere domande
    public long aggiungiDomanda (Domanda domanda) {
        SQLiteDatabase db = this.getWritableDatabase();
        // creazione valori
        ContentValues values = new ContentValues();
        values.put(QUESTION, domanda.getDomanda());
        values.put(CHOICE1, domanda.getScelta(0));
        values.put(CHOICE2, domanda.getScelta(1));
        values.put(CHOICE3,  domanda.getScelta(2));
        values.put(CHOICE4,  domanda.getScelta(3));
        values.put(ANSWER, domanda.getRisposta());
        // inserisci riga nella tabella domande
        long inserisci = db.insert(TABLE_QUESTION, null, values);
        return inserisci;
    }

    //per estrarre i dati e salvarli nell' arraylist di tipo Domanda
    public List<Domanda> getAllDomande() {
        List<Domanda> DomandaArrayList = new ArrayList<>();
        String querySelezione = "SELECT  * FROM " + TABLE_QUESTION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(querySelezione, null);

        // loop in tutti i records e aggiunta alla lista
        if (c.moveToFirst()) {
            do {
                Domanda domanda = new Domanda();

                String testoD= c.getString(c.getColumnIndex(QUESTION));
                domanda.setDomanda(testoD);

                String testoS1= c.getString(c.getColumnIndex(CHOICE1));
                domanda.setScelta(0,testoS1);

                String testoS2= c.getString(c.getColumnIndex(CHOICE2));
                domanda.setScelta(1,testoS2);

                String testoS3= c.getString(c.getColumnIndex(CHOICE3));
                domanda.setScelta(2,testoS3);

                String testoS4= c.getString(c.getColumnIndex(CHOICE4));
                domanda.setScelta(3,testoS4);

                String testoR= c.getString(c.getColumnIndex(ANSWER));
                domanda.setRisposta(testoR);

                // aggiunta alla lista domande
                DomandaArrayList.add(domanda);
            } while (c.moveToNext());
            Collections.shuffle(DomandaArrayList);
        }
        return DomandaArrayList;
    }
}
