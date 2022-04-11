package com.example.gestionvisiteur.controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import java.util.ArrayList;

public class ConsultActivity extends AppCompatActivity {
    VisiteurDAO manageDao=new VisiteurDAO();
    private ArrayList<Visiteur> visiteurs = new ArrayList<Visiteur>();
    private ListView listeV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);


        listeV =(ListView) findViewById(R.id.ListVisiteur);

        visiteurs= manageDao.recupVisiteur();

        ArrayAdapter monAdapater=new ArrayAdapter(this, android.R.layout.simple_list_item_1,visiteurs);

        listeV.setAdapter(monAdapater);

        listeV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Visiteur vistItem=(Visiteur) listeV.getAdapter().getItem(i);
                Intent z = new Intent(ConsultActivity.this,DetailsActivity.class);
                startActivity(z);
            }
        });


    }
}
