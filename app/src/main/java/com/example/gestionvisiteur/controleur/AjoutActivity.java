package com.example.gestionvisiteur.controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

public class AjoutActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche;
    private Button ajoutBD;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        id=(EditText) findViewById(R.id.editTextId3);
        nom=(EditText) findViewById(R.id.editTextNom3);
        prenom=(EditText) findViewById(R.id.editTextPre3);
        login=(EditText) findViewById(R.id.editTextLogin3);
        mdp=(EditText) findViewById(R.id.editTextMdp3);
        adresse=(EditText) findViewById(R.id.editTextAdRue3);
        cp=(EditText) findViewById(R.id.editTextCP3);
        ville=(EditText) findViewById(R.id.editTextVille3);
        dateEmbauche=(EditText) findViewById(R.id.editTextDate3);
        ajoutBD=(Button) findViewById(R.id.ButtonModif2);

        ajoutBD.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {

        VisiteurDAO managerDao=new VisiteurDAO();

        String idV= (String) id.getText().toString();
        String nomV= (String) nom.getText().toString();
        String preV= (String) prenom.getText().toString();
        String loginV= (String) login.getText().toString();
        String mdpV= (String) mdp.getText().toString();
        String adrV= (String) adresse.getText().toString();
        String cpV= (String) cp.getText().toString();
        String villeV= (String) ville.getText().toString();
        String dateEmbV= (String) dateEmbauche.getText().toString();

        if(idV.isEmpty() || nomV.isEmpty() || preV.isEmpty() || loginV.isEmpty() || mdpV.isEmpty() || adrV.isEmpty() || cpV.isEmpty() || villeV.isEmpty() || dateEmbV.isEmpty()){
            Toast msg=Toast.makeText(getApplicationContext(),"Veuillez remplir tout les champs !", Toast.LENGTH_LONG);
        }else {

            Visiteur unVisiteur=new Visiteur(idV,nomV,preV,loginV,mdpV,adrV,cpV,villeV,dateEmbV);
            Log.d("ajouevi",unVisiteur.toString());

            String result= managerDao.addVisiteur(unVisiteur);

            if(result.contains("1")){
            Context c = getApplicationContext();
            Toast msg=Toast.makeText(c,"Le client a bie été insere !", Toast.LENGTH_LONG);
            msg.show();
            }
        else
        {
            Context c=getApplicationContext();
            Toast msg=Toast.makeText(c,"Le client n'a pas ete insere !", Toast.LENGTH_LONG);
            msg.show();
        }
        }

        Intent i=new  Intent(AjoutActivity.this,PropositionActivity.class);
        startActivity(i);

    }
}
