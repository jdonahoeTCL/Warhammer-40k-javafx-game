/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Used to setup stats for a AvengerShurikenCatapult weapon. 
 *
 */
public class AvengerShurikenCatapult extends Weapon {
      AvengerShurikenCatapult(){
        this.AP=5;
        this.Range=18;
        this.S=4;
        this.Shots=2;
        this.isAssault=false;
        this.isHeavy=false;
        this.isMelee=false;
        this.isMelta=false;
        this.isRapidFire=true;
        this.name="AvengerShurikenCatapult";
      }
    
}
