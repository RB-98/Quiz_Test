package com.example.quiz_test;

//classe per la lista delle domande
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class DomandeLista {
    // dichiaro lista domande
    List <Domanda> list = new ArrayList<>();
    DataBaseDomande dataBaseDomande;

    // ritorno il numero di domande nella lista
    public int getLunghezza(){ return list.size(); }
    // ritorno la domanda dalla lista in base all' indice
    public String getDomanda(int a) { return list.get(a).getDomanda(); }
    // ritorna una sola risposta in base all' indice
    // basato sul numero delle risposte a scelta multipla nella lista (1, 2, 3, 4)
    public String getScelta(int index, int num) { return list.get(index).getScelta(num-1); }
    // ritorna la risposta giusta della domanda in base all' indice della lista
    public String getRisposta(int a) {
        return list.get(a).getRisposta();
    }



    public void initDomande(Context context) {
        dataBaseDomande = new DataBaseDomande(context);
        list = dataBaseDomande.getAllDomande(); // prende domande, scelte, risposte dal database

        if (list.isEmpty()) {// se la lista e' vuota, popola il database con domande, scelte, risposte
            dataBaseDomande.aggiungiDomanda(new Domanda("Quale delle seguenti affermazioni relative al tipo boolean del linguaggio di programmazione JAVA è vera",
                    new String[]{"le espressioni di tipo boolean si possono usare nel ciclo while ma non nel ciclo for",
                            "le espressioni di tipo boolean sono utili solo quando si devono scrivere istruzioni if annidate",
                            "le espressioni di tipo boolean sono sempre vere o sempre falsele espressioni di tipo boolean sono sempre vere o sempre false",
                            "le espressioni di tipo boolean si possono usare per specificare una condizione"},
                    "le espressioni di tipo boolean si possono usare per specificare una condizione"));
            dataBaseDomande.aggiungiDomanda(new Domanda("Se un metodo A invoca un metodo B, come può B modificare il contenuto una variabile creata da A?",
                    new String[]{"la variabile può essere contenuta in un oggetto creato da A il cui riferimento è passato come parametro al metodo B",
                            "non è possibile",
                            "basta passare come parametro attuale al metodo B la variabile di A che si intende modificare",
                            "basta dichiarare la variabile static in A"},
                    "la variabile può essere contenuta in un oggetto creato da A il cui riferimento è passato come parametro al metodo B"));
            dataBaseDomande.aggiungiDomanda(new Domanda("Quale delle seguenti affermazioni relative alle istruzioni di ciclo while e di ciclo for è vera",
                    new String[]{"non c'è nessuna differenza tra le due istruzioni di ciclo while e di ciclo for",
                            "il ciclo while consente di esprimere cicli indefiniti mentre il ciclo for consente di esprimere solo cicli definiti",
                            "ciclo while e ciclo for consentono di esprimere cicli indefiniti",
                            "esistono elaborazioni che possono essere realizzate con un ciclo for, ma non con un ciclo while"},
                    "ciclo while e ciclo for consentono di esprimere cicli indefiniti"));
            dataBaseDomande.aggiungiDomanda(new Domanda("Quale delle seguenti affermazioni relative agli array del linguaggio di programmazione JAVA è vera?",
                    new String[]{"gli array sono un tipo di dato primitivo",
                            "gli array consentono di memorizzare collezioni di dati eterogenei (di tipo diverso)",
                            "gli array possono essere sempre ridimensionati ove serva più spazio per memorizzare i dati",
                            "gli array consentono di memorizzare collezioni di dati omogenei (dello stesso tipo)"},
                    "gli array consentono di memorizzare collezioni di dati omogenei (dello stesso tipo)"));
            dataBaseDomande.aggiungiDomanda(new Domanda("Quando viene creata una variabile di istanza?",
                    new String[]{"al momento della dichiarazione di classe in cui è contenuta",
                            "al momento della creazione dell'oggetto nel quale è definita",
                            "durante l'esecuzione del blocco in cui è dichiarata",
                            "quando le viene assegnato un valore"},
                    "al momento della creazione dell'oggetto nel quale è definita"));

            list = dataBaseDomande.getAllDomande();
            // prendi la lista dal database di nuovo

        }
    }

}
