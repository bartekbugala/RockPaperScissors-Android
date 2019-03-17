package pl.wsb.bb.sandbox;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private String wyborGracza;
    private int wynikGry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void kamien(View view) {
        wyborGracza = "KAMIEŃ";
        losowanie(wyborGracza);
    }

    public void papier(View view) {
        wyborGracza = "PAPIER";
        losowanie(wyborGracza);
    }

    public void nozyce(View view) {
        wyborGracza = "NOŻYCE";
        losowanie(wyborGracza);
    }

    public void losowanie(String wyborGracza){
        String[] wyborKomputera = {"KAMIEŃ", "PAPIER", "NOŻYCE"};
        int i = new Random().nextInt(wyborKomputera.length);
        String losowyWybor = (wyborKomputera[i]);

        if (wyborGracza == losowyWybor) {
            Context context = getApplicationContext();
            CharSequence tekst = "Przeciwnik: " +losowyWybor+ " - REMIS";
            int czasTrwania = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, tekst, czasTrwania);
            toast.show();
        }
        else if ((wyborGracza == "KAMIEŃ" && losowyWybor == "PAPIER") || (wyborGracza == "PAPIER" && losowyWybor == "NOŻYCE") || (wyborGracza == "NOŻYCE" && losowyWybor == "KAMIEŃ")) {
            Context context = getApplicationContext();
            CharSequence tekst = "Przeciwnik: " +losowyWybor+ " - PRZEGRAŁEŚ.";
            int czasTrwania = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, tekst, czasTrwania);
            toast.show();
            wynikGry--;
        }
        else if ((losowyWybor == "KAMIEŃ" && wyborGracza == "PAPIER") || (losowyWybor == "PAPIER" && wyborGracza == "NOŻYCE") || (losowyWybor == "NOŻYCE" && wyborGracza == "KAMIEŃ")) {
            Context context = getApplicationContext();
            CharSequence tekst = "Przeciwnik: " +losowyWybor+ " - WYGRAŁEŚ!";
            int czasTrwania = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, tekst, czasTrwania);
            toast.show();
            wynikGry++;
        }

        TextView tekst=(TextView)findViewById(R.id.licznik);
        tekst.setText("Twój wynik: "+wynikGry);
    }
}
