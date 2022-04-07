package com.example.gestionvisiteur.controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;

public class PropositionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ajout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);

        ajout=(Button) findViewById(R.id.buttonAj);

        ajout.setOnClickListener(this);




    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(PropositionActivity.this,AjoutActivity.class);
        startActivity(i);

    }
}
