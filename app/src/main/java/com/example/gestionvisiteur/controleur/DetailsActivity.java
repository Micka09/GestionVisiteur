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

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    private String AncidV,nomV,prenomV,loginV,mdpV,adresseV,cpV,villeV,dateEmbaucheV;
    private EditText editId,editNom,editPrenom,editLog,editMdp,editAdr,editCp,editVill,editDate;
    private Button modif,supp;
    VisiteurDAO managerDao=new VisiteurDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        AncidV=getIntent().getStringExtra("id");
        nomV=getIntent().getStringExtra("nom");
        prenomV=getIntent().getStringExtra("prenom");
        loginV=getIntent().getStringExtra("login");
        mdpV=getIntent().getStringExtra("mdp");
        adresseV=getIntent().getStringExtra("adresse");
        cpV=getIntent().getStringExtra("cp");
        villeV=getIntent().getStringExtra("ville");
        dateEmbaucheV=getIntent().getStringExtra("dateEmbauche");

        editId=(EditText) findViewById(R.id.editTextId4);
        editNom=(EditText) findViewById(R.id.editTextNom4);
        editPrenom=(EditText) findViewById(R.id.editTextPre4);
        editLog=(EditText) findViewById(R.id.editTextLogin4);
        editMdp=(EditText) findViewById(R.id.editTextMdp4);
        editAdr=(EditText) findViewById(R.id.editTextAdRue4);
        editCp=(EditText) findViewById(R.id.editTextCP4);
        editVill=(EditText) findViewById(R.id.editTextVille4);
        editDate=(EditText) findViewById(R.id.editTextDate4);

        modif=(Button) findViewById(R.id.ButtonModif18);
        supp=(Button) findViewById(R.id.buttonSuppModif);

        editId.setText(AncidV);
        editNom.setText(nomV);
        editPrenom.setText(prenomV);
        editLog.setText(loginV);
        editMdp.setText(mdpV);
        editAdr.setText(adresseV);
        editCp.setText(cpV);
        editVill.setText(villeV);
        editDate.setText(dateEmbaucheV);

        modif.setOnClickListener(this);
        supp.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ButtonModif18:



                String newId= editId.getText().toString();
                String newNom=editNom.getText().toString();
                String newPre=editPrenom.getText().toString();
                String newLog=editLog.getText().toString();
                String newMdp=editMdp.getText().toString();
                String newAdr=editAdr.getText().toString();
                String newCp=editCp.getText().toString();
                String newVill=editVill.getText().toString();
                String newDate=editDate.getText().toString();

                if(newId.isEmpty() || newNom.isEmpty() || newPre.isEmpty() || newLog.isEmpty() || newMdp.isEmpty() || newAdr.isEmpty() || newCp.isEmpty() || newVill.isEmpty() || newDate.isEmpty()){
                    Toast msg=Toast.makeText(getApplicationContext(),"Veuillez remplir tout les champs !", Toast.LENGTH_LONG);
                }else {
                    Visiteur majVisiteur=new Visiteur(newId,newNom,newPre,newLog,newMdp,newAdr,newCp,newVill,newDate);
                    Log.d("modif",majVisiteur.toString2());

                    String result= managerDao.modifierVisiteur(majVisiteur,AncidV);

                    if(result.contains("1")){
                        Context c = getApplicationContext();
                        Toast msg=Toast.makeText(c,"Le client a bien été modifié !", Toast.LENGTH_LONG);
                        msg.show();
                    }
                    else
                    {
                        Context c=getApplicationContext();
                        Toast msg=Toast.makeText(c,"Le client n'a pas pu être modifié !", Toast.LENGTH_LONG);
                        msg.show();
                    }
                }

                Intent i=new  Intent(DetailsActivity.this,PropositionActivity.class);
                startActivity(i);
                break;
            case R.id.buttonSuppModif:


                    String idaSupp=AncidV;
                    Visiteur visiASupp=new Visiteur(idaSupp);
                    String result=managerDao.supprimerVisiteur(visiASupp);

                if(result.contains("1")){
                    Context c = getApplicationContext();
                    Toast msg=Toast.makeText(c,"Le client a bien été supprimé!", Toast.LENGTH_LONG);
                    msg.show();
                }
                else
                {
                    Context c=getApplicationContext();
                    Toast msg=Toast.makeText(c,"Le client n'a pas pu être supprrimé !", Toast.LENGTH_LONG);
                    msg.show();
                }
                Intent z=new  Intent(DetailsActivity.this,PropositionActivity.class);
                startActivity(z);
                break;



                }

        }


    }

