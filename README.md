# Quiz_Test
Quiz_Test app (Read, Create questionary, survey or quiz)
------IMPORTANTE------
L'app creata genera un file .db collegato al programma.
Vengono inserite cinque domande predefinite se non vi è la presenza di alcun file .db.

Per modificare o aggiungere domande al database bisogna seguire pochi semplici passi:
1) localizzare il database
	Una volta fatto partire l' emulatore android utilizzare il tool "Device File Manager" di android studio (Barra degli strumenti -> view -> tools -> deviceFM)
	Entrati nel file manager andare in data -> data -> trovare il nome del pacchetto "com.example.quiz_test" -> databases -> domandaLista.db
2) copiare il file "domandaLista.db" appena creato 
3) scaricare e installare DB Browser (SQLite)
4) aprire il programma e cliccare "Apri Database" e selezionare il .db precedentemente creato
5) cliccare nella finestra "Naviga nei dati" e qui troveremo la nostra tabella
6) seguire i vari campi per modificare i dati o inserire nuovi valori alla tabella (id, domanda, scelta1, scelta2, scelta3, scelta4, risposta)
7) salvare la tabella e uscire dal programma
8) cerchiamo la cartella "DeviceExplorer" nel nostro esplora risorse del computer. Dentro troveremo gli emulatori utilizzati con Android Studio
9) aprite la cartella del vostro emulatore e dentro troverete le cartelle "data" con all' interno la folder "database" dove è contenuto il .db creato dal programma
10) a questo punto sostituite il .db appena modificato a quello già presente e sovrascrivete il file
11) nel Device File Manager fate click destro col mouse nella cartella database (seguite il punto n.1 per trovarla) e cliccate su upload
12) dovete trovare e uplodare la stessa cartella "database" trovata nel vostro computer e presente in "DeviceExplorer"
13) a questo punto vedrete all' interno del DeviceFM che il vostro file "domandaLista.db" avrà aggiornato orario, data e contenuto.

Per visualizzare semplicemente il contento del file .db utilizzare il tool "DataBase Inspector" di android studio (Barra degli strumenti -> view -> tools -> DataBase Inspector)
Al suo interno potrete vedere la tabella e i vari campi in sola lettura, senza avere la possibilità di modificare, eliminare, aggiungere elementi.
Seguite la guida qui sopra per poter accedere con pieno controllo al .db
