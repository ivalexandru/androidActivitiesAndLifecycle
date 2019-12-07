package com.bawp.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowGuess extends AppCompatActivity {

    private TextView showGuessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        //Bundle e o clasa in care bagi chestii, that are easier to access
        //getExtras gets ALL that comes with our intent
        Bundle extra =  getIntent().getExtras();

        showGuessTextView = findViewById(R.id.received_textview);

        if(extra != null){
            String value = extra.getString("guess");
            showGuessTextView.setText(value);
            Log.d("name extra", "onCreate: " + extra.getString("name"));
            Log.d("name extra2", "onCreate: " + extra.getInt("age"));

        }

        showGuessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                //setResult(result, data):
                setResult(RESULT_OK, intent);
                //we must CLOSE the current activity (cu finish):
                finish();
            }
        });

//        if(getIntent().getStringExtra("guess") != null) {
//            //aici accesezi key pe care l-ai setat in MainActivity cu intent.putExtra()
//            String value = getIntent().getStringExtra("guess");
//            showGuessTextView.setText(value);
//        }


    }
}
