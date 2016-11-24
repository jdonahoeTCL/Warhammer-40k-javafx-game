/**
 * Used to setup stats for a SpaceMarine unit. 
 *
 */
public class SpaceMarine extends unit {
    /**
    *
    * @param name: the name of this unit.
    * @param team: the team this unit belongs to.
    */
    SpaceMarine(String name,boolean team){
        this.name=name;
        this.S=4;
        this.BS=4;
        this.I=4;
        this.WS=4;
        this.T=4;
        this.W=1;
        this.A=1;
        this.Ld=8;
        this.Sv=3;
        this.gun=new BoltGun();
        this.melee=new CloseCombatWeapon();
        this.melee.S = this.S;
        this.team=team;
        this.alive=true;
    }
}
