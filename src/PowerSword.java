/**
 * Used to setup stats for a PowerSword weapon. 
 *
 */
public class PowerSword extends Weapon{
    PowerSword()
            {
    this.AP=3;
    this.Range=0;
    this.S=6;
    this.Shots=0;
    this.isAssault=true;
    this.isHeavy=true;
    this.isMelee=true;
    this.isMelta=false;
    this.isRapidFire=false;
    this.name="PowerSword";
            }
}
