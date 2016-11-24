/**
 * Used to setup stats for a DireAvengers unit. 
 *
 */
public class DireAvengers extends unit{
    
    /**
     *
     * @param name: the name of this unit.
     * @param team: the team this unit belongs to.
     */
    public DireAvengers(String name, Boolean team)
       {
       this.name=name;
        this.S=3;
        this.BS=4;
        this.I=5;
        this.WS=4;
        this.T=3;
        this.W=1;
        this.A=1;
        this.Ld=9;
        this.Sv=4;
        this.gun=new AvengerShurikenCatapult();//will update
        this.melee=new CloseCombatWeapon();
        this.melee.S = this.S;
        this.team=team;
       }
}
