package com.example.gestionvisiteur.controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import java.util.ArrayList;

public class ModifierActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    ArrayList<Visiteur> lesVisit;
    VisiteurDAO managerDao = new VisiteurDAO();
    private String id,nom,prenom,login,mdp,adresse,cp,ville,date;
    private EditText editId,editNom,editPre,editLog,editMdp,editAdr,editCp,editVi,editD;
    Spinner spinnerVisiteur;
    private Button but18,butret18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        but18=(Button) findViewById(R.id.ButtonModif18);
        but18.setOnClickListener(this);

        butret18=(Button) findViewById(R.id.buttonRetour4);
        butret18.setOnClickListener(this);

        editId=(EditText) findViewById(R.id.editTextId4);
        editNom=(EditText) findViewById(R.id.editTextNom4);
        editPre=(EditText) findViewById(R.id.editTextPre4);
        editLog=(EditText) findViewById(R.id.editTextLogin4);
        editMdp=(EditText) findViewById(R.id.editTextMdp4);
        editAdr=(EditText) findViewById(R.id.editTextAdRue4);
        editCp=(EditText) findViewById(R.id.editTextCP4);
        editVi=(EditText) findViewById(R.id.editTextVille4);
        editD=(EditText) findViewById(R.id.editTextDate4);

        spinnerVisiteur=(Spinner) findViewById(R.id.spinnVisiteur);

        lesVisit=managerDao.recupVisiteur();

        ArrayAdapter<Visiteur> spinVisiteursAdapter = new ArrayAdapter<>(this.getBaseContext(),android.R.layout.simple_spinner_item);

        for (int i=0;i<lesVisit.size();i++){
            spinVisiteursAdapter.add(lesVisit.get(i));
        }

        spinnerVisiteur.setAdapter(spinVisiteursAdapter);

        spinnerVisiteur.setOnItemSelectedListener(this);

    }
        @Override
        public void onClick (View view){
        Visiteur visit = (Visiteur) spinnerVisiteur.getSelectedItem();
        switch(view.getId()) {
            case R.id.ButtonModif18:

            String AncId = visit.getId();

            String newId = editId.getText().toString();
            String newNom = editNom.getText().toString();
            String newPrenom = editPre.getText().toString();
            String newLog = editLog.getText().toString();
            String newMDP = editMdp.getText().toString();
            String newAdr = editAdr.getText().toString();
            String newCp = editCp.getText().toString();
            String newVille = editVi.getText().toString();
            String newDate = editD.getText().toString();

                if(newId.isEmpty() || newNom.isEmpty() || newPrenom.isEmpty() || newLog.isEmpty() || newMDP.isEmpty() || newAdr.isEmpty() || newCp.isEmpty() || newVille.isEmpty() || newDate.isEmpty()){
                    Toast msg=Toast.makeText(getApplicationContext(),"Veuillez remplir tout les champs !", Toast.LENGTH_LONG);
                }else {
                    Visiteur majVisiteur=new Visiteur(newId,newNom,newPrenom,newLog,newMDP,newAdr,newCp,newVille,newDate);
                    Log.d("modif",majVisiteur.toString2());

                    String result= managerDao.modifierVisiteur(majVisiteur,AncId);

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

                Intent i=new  Intent(ModifierActivity.this,PropositionActivity.class);
                startActivity(i);
                break;

            case R.id.buttonRetour4:
                Intent z=new Intent(ModifierActivity.this,PropositionActivity.class);
                startActivity(z);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Visiteur selected =  (Visiteur) spinnerVisiteur.getSelectedItem();
        id=selected.getId();
        nom=selected.getNom();
        prenom=selected.getPrenom();
        login=selected.getLogin();
        mdp=selected.getMdp();
        adresse=selected.getAdresse();
        cp=selected.getCp();
        ville=selected.getVille();
        date=selected.getDateEmbauche();

        editId.setText(id);
        editNom.setText(nom);
        editPre.setText(prenom);
        editLog.setText(login);
        editMdp.setText(mdp);
        editAdr.setText(adresse);
        editCp.setText(cp);
        editVi.setText(ville);
        editD.setText(date);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
