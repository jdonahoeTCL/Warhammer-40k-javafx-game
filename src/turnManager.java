

/**
 *
 * @author Ryan Silver
 */
public class turnManager {

    private boolean turn;//false for player 1/blue true for player 2/red
    private int phase;//1 for movement,2 for shooting, 3 for assualt
    unit selected;//used in all shooting chargeing and movement 
    unit targeted;//used in all shooting, and chargeing
    turnManager() {
        turn = false;
        phase = 1;
    }

    /**
     * pass turn from player 1 to two or vice versa.
     * @param one:List of units for player 1
     * @param two:List of units for player 2
     */
    public void pass(unit[] one, unit[] two) {
        if (!turn) {
            for (int i = 0; i < one.length; i++) {
                one[i].moved = false;
                one[i].shot = false;
                one[i].charged = false;
            }
        }
        else{
            for (int i = 0; i < two.length; i++) {
                two[i].moved = false;
                two[i].shot = false;
                two[i].charged = false;
               
            }
        }
        targeted=null;
        selected=null;
        phase=1;
        turn=!turn;
                
        //resolve close combat
        
    }

    /**
     *
     * @return: True if is player 1 turn
     */
    public boolean player1Turn(){return !turn;}

    /**
     *
     * @return: true if is player 2 turn
     */
    public boolean player2Turn(){return turn;}

    /**
     *Go to next phase
     */
    public void incPhase(){if(phase<3)phase+=1;}

    /**
     *go back to previous phase
     */
    public void decPhase(){if(phase>1)phase-=1;}

    /**
     *
     * @return: return the current phase
     */
    public int getPhase(){return phase;}

    /**
     *
     * @return: return true if is movement phase
     */
    public boolean isMove(){return phase==1;}

    /**
     *
     * @return: return true if is shooting phase
     */
    public boolean isShoot(){return phase==2;}

    /**
     *
     * @return: return true if is assualt phase.
     */
    public boolean isAssualt(){return phase==3;}

    /**
     *
     * @return: returns true or false based on who's turn it is 
     */
    public boolean getTurn(){return turn;}
    
  

    
}
