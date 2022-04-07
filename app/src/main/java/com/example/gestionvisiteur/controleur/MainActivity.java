package com.example.gestionvisiteur.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestionvisiteur.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valider = (Button) findViewById(R.id.buttonval);

        valider.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this,PropositionActivity.class);
        startActivity(i);

    }
}

