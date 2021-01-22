package com.example.quiz_test;

// classe Domanda per descriverne la struttura
public class Domanda {

    private String domandaSingola;
    private String[] scelta = new String[4];
    private String risposta;

    public Domanda() { }

    public Domanda(String domandaSingola, String[] scelte, String risposta) {
        this.domandaSingola = domandaSingola;
        this.scelta[0] = scelte[0];
        this.scelta[1] = scelte[1];
        this.scelta[2] = scelte[2];
        this.scelta[3] = scelte[3];
        this.risposta = risposta;
    }

    public String getDomanda() {
        return domandaSingola;
    }

    public String getScelta(int i) {
        return scelta[i];
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public void setScelta(int i, String scelta) { this.scelta[i] = scelta; }

    public void setDomanda(String domandaSingola) {
        this.domandaSingola = domandaSingola;
    }
}
