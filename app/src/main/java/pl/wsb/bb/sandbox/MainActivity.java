package pl.wsb.bb.sandbox;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            if(savedInstanceState != null && savedInstanceState.containsKey("editText")) {
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(savedInstanceState.getString("editText"));
        }
        /*
        Podłączanie setOnClickListener do kontrolki -> tworzenie metody View.onClickListener() -> Akcja implementowana w onClick(View v)
        */
        final Button button = (Button) findViewById(R.id.button3);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context moj_context = getApplicationContext();
                        Toast.makeText(moj_context, "Znaleziony Przycisk", Toast.LENGTH_SHORT).show();
                    }
                });

        final ImageButton buttonNowy = (ImageButton) findViewById(R.id.imageButton);
        buttonNowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context moj_context = getApplicationContext();
                Toast.makeText(moj_context, getAndroidVer(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /* Zapisywanie stanu jednego z pól tekstowych */
  /* public void onSaveInstanceState(Bundle saveInstanceState) {
        EditText editText = (EditText) findViewById(R.id.editText);
        saveInstanceState.putString("editText",editText.getText().toString());
        super.onSaveInstanceState(saveInstanceState);
    }*/

    /*  METODA ZWRACAJĄCA AKTUALNĄ WERSJĘ API I SDK ANDROIDA I ew. NAZWĘ */
    public String getAndroidVer(){
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        String codename = Build.VERSION.CODENAME;
        return "wersja Androida: " + sdkVersion + " (" + release +" - " + codename + ")";
    }



    /*
    Implementacja Okna dialogowego Tak/Nie -> kolejność według zaleceń android.
     */
    public void onClick(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage("Czy na pewno?").setNegativeButton("NIE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Context context = getApplicationContext();
                CharSequence tekst = "JESTEŚ NA NIE!";
                int czasTrwania = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, tekst, czasTrwania);
                toast.show();
            }
        }).setPositiveButton("TAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Context context = getApplicationContext();
                CharSequence tekst = "JESTEŚ NA TAK!";
                int czasTrwania = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, tekst, czasTrwania);
                toast.show();
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
    /*
    Implementacja Toast.
     */
    public void onClickToast(View view) {
        Context context = getApplicationContext();
        CharSequence tekst = "Udało się oto \"toast\"!";
        int czasTrwania = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, tekst, czasTrwania);
        toast.show();

    }


    public void secondActivity(View view) {
        Intent intent1 = new Intent(this, Main2Activity.class);
        intent1.putExtra("klucz", "wartość"); // Wartości, które Main2Activity może wykorzystać
        startActivity(intent1);

    }


}
