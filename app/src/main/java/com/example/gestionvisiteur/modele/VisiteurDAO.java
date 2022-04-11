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
    public ArrayList<Visiteur> recupVisiteur() {
        String result = "";
        String params="";
        ArrayList<Visiteur> lesVisiteurs=new ArrayList<Visiteur>();
        //adresse de l'URL de l\'API à interroger et fichier php permettant la recuperation des visiteurs
        String myUrl="http://mick-souloumiac1.alwaysdata.net/API/getVisiteurs.php";
        HttpPostRequest postRequest = new HttpPostRequest();
        try{
            result = postRequest.execute(new String []{myUrl, params}).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            JSONArray array=new JSONArray(result);
            for(int i=0;i < array.length();i++){
                String id = array.getJSONObject(i).getString("id");
                String nom = array.getJSONObject(i).getString("prenom");
                String prenom = array.getJSONObject(i).getString("nom");
                String login = array.getJSONObject(i).getString("login");
                String mdp = array.getJSONObject(i).getString("mdp");
                String adresse = array.getJSONObject(i).getString("adresse");
                String cp = array.getJSONObject(i).getString("cp");
                String ville = array.getJSONObject(i).getString("ville");
                String dateEmbauche = array.getJSONObject(i).getString("dateEmbauche");

                lesVisiteurs.add(new Visiteur(id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche));
            }

        }

    catch (JSONException e) {
        e.printStackTrace();
    }
        return lesVisiteurs;
}


}
