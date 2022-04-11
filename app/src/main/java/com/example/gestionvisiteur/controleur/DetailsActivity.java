package com.example.gestionvisiteur.controleur;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionvisiteur.R;

public class DetailsActivity extends AppCompatActivity {
    private String idV,nomV,prenomV,loginV,mdpV,adresseV,cpV,villeV,dateEmbaucheV;
    private EditText editId,editNom,editPrenom,editLog,editMdp,editAdr,editCp,editVill,editDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        idV=getIntent().getStringExtra("id");
        nomV=getIntent().getStringExtra("nom");
        prenomV=getIntent().getStringExtra("prenom");
        loginV=getIntent().getStringExtra("login");
        mdpV=getIntent().getStringExtra("mdp");
        adresseV=getIntent().getStringExtra("adresse");
        cpV=getIntent().getStringExtra("cp");
        villeV=getIntent().getStringExtra("ville");
        dateEmbaucheV=getIntent().getStringExtra("dateEmbauche");

        editId=(EditText) findViewById(R.id.editTextId2);
        editNom=(EditText) findViewById(R.id.editTextNom2);
        editPrenom=(EditText) findViewById(R.id.editTextPre2);
        editLog=(EditText) findViewById(R.id.editTextLogin2);
        editMdp=(EditText) findViewById(R.id.editTextMdp2);
        editAdr=(EditText) findViewById(R.id.editTextAdRue2);
        editCp=(EditText) findViewById(R.id.editTextCP2);
        editVill=(EditText) findViewById(R.id.editTextVille2);
        editDate=(EditText) findViewById(R.id.editTextDate2);

        editId.setText(idV);
        editNom.setText(nomV);
        editPrenom.setText(prenomV);
        editLog.setText(loginV);
        editMdp.setText(mdpV);
        editAdr.setText(adresseV);
        editCp.setText(cpV);
        editVill.setText(villeV);
        editDate.setText(dateEmbaucheV);


    }

}
