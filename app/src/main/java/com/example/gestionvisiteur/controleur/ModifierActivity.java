package com.example.gestionvisiteur.controleur;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import java.util.ArrayList;

public class ModifierActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Visiteur> lesVisit;
    VisiteurDAO managerDao = new VisiteurDAO();
    Spinner spinnerVisiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        spinnerVisiteur=(Spinner) findViewById(R.id.spinnVisiteur);

        lesVisit=managerDao.recupVisiteur();

        ArrayAdapter<Visiteur> spinVisiteursAdapter = new ArrayAdapter<>(this.getBaseContext(),android.R.layout.simple_spinner_item);

        for (int i=0;i<lesVisit.size();i++){
            spinVisiteursAdapter.add(lesVisit.get(i));
        }

        spinnerVisiteur.setAdapter(spinVisiteursAdapter);



    }
        @Override
        public void onClick (View view){


    }

}
