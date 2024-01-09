/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.model;

import com.mycompany.rentacar.ui.CocheCard;

/**
 *
 * @author j1
 */
public interface SelectionListener {
    void onCardSelected(Coche selected);
    void onCardUnselected();
}
