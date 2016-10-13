/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gauthier.controler;


import com.gauthier.view.ViewReservation;
import com.gauthier.model.GestionDonnees;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Dev
 */
public class ControlerReservation {

    private GestionDonnees model;
    private final ViewReservation view;

    public ControlerReservation(GestionDonnees model, ViewReservation viewReservation) {
        this.model = model;
        this.view = viewReservation;
        
    }

    public void ajoutListener() {
        view.getBtAnnuler().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        view.getBtValider().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(view.getChampNombrePers().getText()) && !"".equals(view.getListAdherent().getSelectedItem().toString()) && !"".equals(view.getListRepresentation().getSelectedItem().toString())) {
                    
                    model.enregistrementReservation(view.getListAdherent().getSelectedIndex(), view.getListRepresentation().getSelectedIndex(), Integer.parseInt(view.getChampNombrePers().getText()));

                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir correctement les champs\n aucun champ vide accepté", "ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Gestion des évènements de la JTextfield ChampNombrePersonne
        view.getChampNombrePers().addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent evt) {
                model.calculTotal(view.getChampTotal(), view.getChampNombrePers(), view.getListRepresentation());
            }

            @Override
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
                    evt.consume();
                }
            }

        });

        view.getListRepresentation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.calculTotal(view.getChampTotal(), view.getChampNombrePers(), view.getListRepresentation());
            }
        });

    }

}
