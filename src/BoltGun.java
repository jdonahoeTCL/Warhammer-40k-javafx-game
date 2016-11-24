/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Used to setup stats for a BoltGun weapon. 
 *
 */
public class BoltGun extends Weapon {
    BoltGun(){
        this.AP=5;
        this.Range=24;
        this.S=4;
        this.Shots=1;
        this.isAssault=false;
        this.isHeavy=false;
        this.isMelee=false;
        this.isMelta=false;
        this.isRapidFire=true;
        this.name="BoltGun";
    }
}
