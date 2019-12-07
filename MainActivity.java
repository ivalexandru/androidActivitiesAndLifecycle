package com.bawp.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showGuess;
    private Button showAlternate;

    private EditText enterGuess;

    private final int REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGuess = findViewById(R.id.button_guess);
        enterGuess = findViewById(R.id.guess_field);

        showAlternate = findViewById(R.id.alternateButton);

        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //extract the text from a TextView:
                String guess = enterGuess.getText().toString().trim();


                //te asiguri ca inainte de apasare buton se tasteaza ceva:
                if(!guess.isEmpty()){

                    //de unde pleci, unde ajungi:
                    //go from the MainActivity to ShowGuess activity
                    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                    // putExtra(cheie, valoare)
                    intent.putExtra("guess", guess);
                    intent.putExtra("name", "bond");
                    intent.putExtra("age", 34);

                    //startActivity() simplu, doar porneste, dar nu stie ca tre sa astepte un rezultat
                    //startActivity(intent);
                    //daca vreau sa si primesc ceva inapoi de la celalalt activity, pui asa:
                    startActivityForResult(intent, REQUEST_CODE);

                } else {
                    Toast.makeText(MainActivity.this,
                            "pls entr guess",
                            Toast.LENGTH_SHORT)
                            .show();
                }


            }
        });

        showAlternate.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, showAlternate.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == RESULT_OK){
                assert data != null; // se ASIGURA ca data un e NULL
                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
