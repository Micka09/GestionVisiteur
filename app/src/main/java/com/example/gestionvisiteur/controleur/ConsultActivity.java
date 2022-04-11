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
                z.putExtra("id",vistItem.getId());
                z.putExtra("nom",vistItem.getNom());
                z.putExtra("prenom",vistItem.getPrenom());
                z.putExtra("login",vistItem.getLogin());
                z.putExtra("mdp",vistItem.getMdp());
                z.putExtra("adresse",vistItem.getAdresse());
                z.putExtra("cp",vistItem.getCp());
                z.putExtra("ville",vistItem.getVille());
                z.putExtra("dateEmbauche",vistItem.getDateEmbauche());

                startActivity(z);
            }
        });


    }
}
