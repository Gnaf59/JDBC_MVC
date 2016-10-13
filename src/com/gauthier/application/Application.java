/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gauthier.application;

import com.gauthier.controler.ControlerReservation;
import com.gauthier.model.GestionDonnees;
import com.gauthier.view.ViewReservation;

/**
 *
 * @author Dev
 */
public class Application  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GestionDonnees model =new GestionDonnees();
        model.remplirCollections();
        ViewReservation viewReservation=new ViewReservation(model);
        ControlerReservation controlerReservation= new ControlerReservation(model,viewReservation);
        model.addObserver(viewReservation);
    }
    
}
