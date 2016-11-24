/**
 * Used to setup stats for a DaemonPrince unit. 
 *
 */
public class DaemonPrince extends unit {

    /**
     *
     * @param name: the name of this unit.
     * @param team: the team this unit belongs to.
     */
    public DaemonPrince(String name, Boolean team)
       {
        this.name=name;
        this.S=6;
        this.BS=5;
        this.I=8;
        this.WS=9;
        this.T=5;
        this.W=4;
        this.A=5;
        this.Ld=9;
        this.Sv=3;
        this.gun=new PowerSword();//will update
        this.melee=new PowerSword();
        this.team=team;
        this.alive=true;
       }
}
