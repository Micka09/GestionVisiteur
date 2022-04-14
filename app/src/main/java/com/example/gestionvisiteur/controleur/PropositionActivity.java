package com.example.gestionvisiteur.controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;

public class PropositionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ajout;
    private Button cons;
    private Button modif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);

        cons=(Button) findViewById(R.id.buttonCo);
        cons.setOnClickListener(this);

        ajout=(Button) findViewById(R.id.buttonAj);
        ajout.setOnClickListener(this);

        modif=findViewById(R.id.buttonMo);
        modif.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonCo:
                Intent i = new Intent(PropositionActivity.this,ConsultActivity.class);
                startActivity(i);
                break;

            case R.id.buttonAj:
                Intent z = new Intent(PropositionActivity.this,AjoutActivity.class);
                startActivity(z);
                break;

            case R.id.buttonMo:
                Intent y=new Intent(PropositionActivity.this, ModifierActivity.class);
                startActivity(y);
                break;
        }


    }
}
