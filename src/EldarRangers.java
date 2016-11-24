/**
 * Used to setup stats for a EldarRangers unit. 
 *
 */
public class EldarRangers extends unit {
        /**
     *
     * @param name: the name of this unit.
     * @param team: the team this unit belongs to.
     */
      EldarRangers(String name,boolean team){
        this.name=name;
        this.S=3;
        this.BS=4;
        this.I=5;
        this.WS=4;
        this.T=3;
        this.W=1;
        this.A=1;
        this.Ld=8;
        this.Sv=5;
        this.gun=new RangerLongRifle();
        this.melee=new CloseCombatWeapon();
        this.melee.S = this.S;
        this.team=team;
        this.alive=true;
    }
}
