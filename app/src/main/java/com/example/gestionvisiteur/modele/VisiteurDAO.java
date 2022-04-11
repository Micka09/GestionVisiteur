package com.example.gestionvisiteur.modele;

import android.util.Log;

import com.example.gestionvisiteur.request.HttpPostRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class VisiteurDAO {

    public VisiteurDAO() {
    }


    public String addVisiteur(Visiteur unVisiteur) {
        String result = "";
        //adresse de l'URL de l\'API à interroger et fichier php permettant d'\ajouter le visiteur
        String myUrl="http://mick-souloumiac1.alwaysdata.net/API/addVisiteur.php";
        //informations à transmettre pour effectuer l'ajout
        String params =
                "id="+unVisiteur.getId()+"&nom="+unVisiteur.getNom()+
                "&prenom="+unVisiteur.getPrenom()+
                "&login="+unVisiteur.getLogin()+
                "&mdp="+unVisiteur.getMdp()+
                "&adresse="+unVisiteur.getAdresse()+
                "&cp="+unVisiteur.getCp()+
                "&ville="+unVisiteur.getVille()+
                "&dateEmbauche="+unVisiteur.getDateEmbauche() ;
        Log.d("requete",params);

        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("resultat",result);
        return result;
    }

}
