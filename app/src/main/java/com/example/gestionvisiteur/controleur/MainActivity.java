package com.example.gestionvisiteur.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button valider;
    private EditText login, mdp;
    private String login2,mdp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(EditText) findViewById(R.id.editTextTextPersonName);
        mdp=(EditText) findViewById(R.id.editTextTextPersonName2);



        valider = (Button) findViewById(R.id.buttonval);

        valider.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        VisiteurDAO managerDao=new VisiteurDAO();

        login2=login.getText().toString();
        mdp2=mdp.getText().toString();


        Visiteur result= managerDao.seConnecter(login2,mdp2);

        if(result!=null){
            Toast msg=Toast.makeText(getApplicationContext(),"Vous êtes connectés!", Toast.LENGTH_LONG);
            msg.show();
            Intent i = new Intent(MainActivity.this,PropositionActivity.class);
            startActivity(i);
        }
        else{
            Toast msg=Toast.makeText(getApplicationContext(),"Login ou mot de passe incorrect!", Toast.LENGTH_LONG);
            msg.show();
            Intent z=new Intent(MainActivity.this,MainActivity.class);

            startActivity(z);
        }



    }
}

