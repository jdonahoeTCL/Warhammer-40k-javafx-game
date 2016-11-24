
import com.sun.org.apache.regexp.internal.REProgram;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.image.*;

// @author Ryan Silver
/**
 * Contains all representations for a single infantry unit in warhammer 40K
 *
 * @author Ryan Silver
 */
public abstract class unit {

    //demo fields
    //abstract void draw();
    //declare fields
    //declare nonabstract methods 
    String name;
    int WS;//unit's weaponskill
    int BS;//unit's ballistic skill
    int S;//unit's strength
    int T;//unit's toughness
    int W;//unit's wounds 
    int I;//Unit's initiave
    int A;//unit's number of close combat attacks
    int Ld;//unit's leadership
    int Sv;//unit's ARMOR save
    Weapon gun;
    Weapon melee;
    boolean shot;
    boolean moved;
    boolean charged;
    boolean team;
    ImageView rep;
    boolean alive = true;
    /**
     * Figures out what to call and loops until one or both units die.
     *
     * @param tM: the current turn manager.
     * @param root: the game Pane so units can properly disappear when killed.
     */
    public void resolveCloseCombat(turnManager tM, Pane root) {

        Tables t = new Tables();
        D6 d = new D6();
        unit first;
        unit second;
        if (tM.selected.I == tM.targeted.I) {//selected and targeted are the same speed
            //selected charges and gets bonus attacks. 
            tM.selected.A++;//selected is assumed to be the charger because of how turn manager works
            attackResolveNoOrder(tM, tM.selected, tM.targeted, root);
            tM.selected.A--;
            //first round is now over no more bonus attacks
            while(tM.selected.alive && tM.targeted.alive){
                attackResolveNoOrder(tM, tM.selected, tM.targeted, root);
            }
        }else{
            //figure out who goes first
            if(tM.selected.I> tM.targeted.I){
                first=tM.selected;
                second=tM.targeted;
            }else{
                first=tM.targeted;
                second=tM.selected;
            }
            if(first.charged){//first charged and gets bonus attacks.
                first.A++;
                attackResolveInOrder(tM, first, second, root);
                first.A--;
            }else{//second charged and gets bonus attacks
                second.A++;
                attackResolveInOrder(tM, first, second, root);
                second.A--;
            }
            //first round is now over no more bonus attacks
            while(first.alive && second.alive){
                attackResolveInOrder(tM, first, second, root);
            }
        }  
    }

    /**
     * resolves combat for both combatants in two separate loops while not
     * checking if the unit "second" has died or not For use with close combat
     * when both units has equal initiate.
     *
     * @param tM: turn manager current in use by Window
     * @param first: a unit
     * @param second: a unit
     * @param root: current Pane of window.
     */
    public void attackResolveNoOrder(turnManager tM, unit first, unit second, Pane root) {//for combatants with equal initative 
        Tables t = new Tables();
        D6 d = new D6();
        int firstTh = t.getToHitAssualt(first.WS, second.WS);
        int secondTh = t.getToHitAssualt(second.WS, first.WS);
        int hits = d.roll(first.A, firstTh);
        int wounds = d.roll(hits, t.getToWound(first.melee.S, second.T));;//roll to wound.
        System.out.println(wounds);
        while (wounds > 0) {
            if (d.roll(1, second.Sv) == 1) {//wound was saved
                window.setStatusUpdate("Wound was saved!");
            } else {//wound was not saved 
                 window.setStatusUpdate("Enemy Unit Killed!");
                second.W--;
                if (second.W == 0) {
                    second.die(root);
                    break;
                }
            }
            wounds--;//
        }
        hits = d.roll(second.A, secondTh);
        wounds = d.roll(hits, t.getToWound(second.melee.S, first.T));//roll to wound.
        while (wounds > 0) {
            if (d.roll(1, first.Sv) == 1) {//wound was saved
                 window.setStatusUpdate("Wound was saved!");
            } else {//wound was not saved 
                window.setStatusUpdate("Your Unit Killed!");
                first.W--;
                if (first.W == 0) {
                    first.die(root);
                    break;
                }
            }
            wounds--;//
        }

    }


    /**
     * Resolves combat for two units in order of their 'I' stat. 
     * 
     * @param first: unit with higher I attribute.  
     * @param second:unit with lower I attribute.
     * @param root: the pane being used in the window class.
     * @param tM: turn manager currently in use by Window
     */
    public void attackResolveInOrder(turnManager tM, unit first, unit second, Pane root) {

        Tables t = new Tables();
        D6 d = new D6();
        int firstTh = t.getToHitAssualt(first.WS, second.WS);
        int hits = d.roll(first.A, firstTh);//second charged but 
        //first is still faster
        //
        int wounds = d.roll(hits, t.getToWound(first.melee.S, second.T));;//roll to wound.
        while (wounds > 0) {
            if (d.roll(1, second.Sv) == 1) {//wound was saved
               window.setStatusUpdate("Wound was saved!");
            } else {//wound was not saved 
                 window.setStatusUpdate("Unit Killed!");
                second.W--;
                if (second.W == 0) {
                    second.die(root);
                    break;
                }
            }
            wounds--;//
        }
        if (second.alive) {
            int secondTh = t.getToHitAssualt(second.WS, first.WS);
            hits = d.roll(second.A, secondTh);//second charged but 
            //first is still faster

            wounds = d.roll(hits, t.getToWound(second.melee.S, first.T));//roll to wound.
            while (wounds > 0) {
                if (d.roll(1, first.Sv) == 1) {//wound was saved
                     window.setStatusUpdate("Wound was saved!");
                } else {//wound was not saved 
                     window.setStatusUpdate("Unit Killed!");
                    first.W--;
                    if (first.W == 0) {
                        first.die(root);
                        break;
                    }
                }
                wounds--;//
            }
        }
    }

    /**
     * Processes a shooting attack and randomizes outcome.
     *
     * @param tM: current Turn manager.
     * @param Distance: the distance inbetween the units in pixels rounded to nearest whole. 
     * @param d6: an instance of the D6 class
     * @param t: an instance of the tables class
     * @param root: Current Pane being used in window. 
     */
    public void shoot(turnManager tM, int Distance, D6 d6, Tables t, Pane root) {

        if (tM.selected.shot) {
            return;
        }

        tM.selected.shot = true;

        if ((tM.selected.gun.Range * 30) >= Distance) {
            int Tw = t.getToWound(gun.S, tM.targeted.T);
            int Th = tM.selected.BS;
            int shots = tM.selected.gun.Shots;

            if (tM.selected.gun.isRapidFire && ((tM.selected.gun.Range * 15) >= Distance)) {
                shots = 2;
            }

            int hits = d6.roll(shots, Th);//roll to hit.

            int wounds = d6.roll(hits, Tw);;//roll to wound
            //if(wounds==0)
            //System.out.println("Attack Failed");
            if(wounds==0)
                 window.setStatusUpdate("Attack Failed!");
            while (wounds > 0) {
                if (d6.roll(1, Sv) == 1) {//wound was saved
                     window.setStatusUpdate("Wound was saved!");
                } else {//wound was not saved 

                    tM.targeted.W--;
                    if (tM.targeted.W == 0) {
                         window.setStatusUpdate("Unit Killed!");
                        tM.targeted.die(root);
                        return;
                    }
                }
                wounds--;//
            }
        } else {
             window.setStatusUpdate("Weapon out of Range!");
        }
    }

    /**
     * Sets up a charge and executes overwatch if the charge is possible.
     * 
     * @param tM: the turnManager being used in window
     * @param distance: distance between the two units
     * @param root: the pane from window
     */
    public void charge(turnManager tM, int distance, Pane root) {
            distance = distance / 30;        
        if (distance <= 12) {
            D6 d6 = new D6();
            Tables t = new Tables();
            tM.selected.charged = true;
            //have targeted fire overwatch
            turnManager temptm = new turnManager();
            temptm.selected = tM.targeted;
            temptm.targeted = tM.selected;
            temptm.selected.shot = false;

            int tempws=temptm.selected.WS;
            temptm.selected.WS=1;
            shoot(temptm,0,d6,t,root);
            temptm.selected.WS=tempws;
            //roll charge range and charge if sufficent
            int charge = ((((int) (Math.random() * 6)) + 1)
                    + (((int) (Math.random() * 6)) + 1));
            System.out.println("charge distance" + charge);
            System.out.println("required" + distance);
            if (charge >= distance) {
                if (tM.player1Turn()) {
                    tM.selected.setPos(tM.targeted.rep.getLayoutX() - 30, tM.targeted.rep.getLayoutY());
                } else {
                    tM.selected.setPos(tM.targeted.rep.getLayoutX() + 30, tM.targeted.rep.getLayoutY());
                }
                resolveCloseCombat(tM, root);
                if(!tM.selected.alive)
                     window.setStatusUpdate("Charge Successful, but your unit died in combat!");
                else
                window.setStatusUpdate("Charge Successful!");
            } else {
                 window.setStatusUpdate("Charge Failed!");
                 
                 if(!tM.selected.alive)
                     window.setStatusUpdate("Died to Overwatch");
            }
        } else {
             window.setStatusUpdate("Cannot Charge! Out of range!");

        }
    }

    /**
     *
     * @param x: move unit to x
     * @param y: move unit to y move unit to x,y
     */
    public void setPos(double x, double y) {
        rep.setLayoutX(x);
        rep.setLayoutY(y);
    }

    /**
     *
     * @return: X position of unit.
     */
    public double getPosX() {
        return rep.getLayoutX();
    }

    /**
     *
     * @return: Y position of unit.
     */
    public double getPosY() {
        System.out.println(rep.getY());
        return rep.getLayoutY();
    }

    /**
     * Used whenever a unit dies. it removes the unit from play and makes it possible to win. 
     * @param root: the pane used in window. removes unit from play.
     */
    public void die(Pane root) {
        alive = false;
        root.getChildren().remove(rep);
    }

    /**
     * Used to handle a mouse click in a game. Action changes based off of turn and phase.
     * @param e: the mouse event.
     * @param tM: the turn manager used in window
     * @param movementAssist: A circle used in window to assist with movement
     * @param root: the pane used in window
     * @param targetingAssist: A line that us used to help figure distance
     * between units This method handles all possible events for a mouse clicked
     * action including movement, shooting, and assualt.
     */
    public void handleMouseClick(MouseEvent e, turnManager tM, Circle movementAssist, Pane root, Line targetingAssist) {
       window.setStatusUpdate("");
        if (tM.getTurn() == team) {
            if (tM.isMove()) {
                //select the unit and have the circle move it
                tM.selected = this;
                if (!root.getChildren().contains(movementAssist)) {
                    root.getChildren().add(movementAssist);
                }
                movementAssist.setCenterX(rep.getLayoutX() + 11);
                movementAssist.setCenterY(rep.getLayoutY() + 10);
            }
            if (tM.isShoot()) {
                //select the unit that is shooting
                tM.selected = this;
                targetingAssist.setStartX(rep.getLayoutX() + 11);
                targetingAssist.setStartY(rep.getLayoutY() + 10);

            }
            if (tM.isAssualt()) {
                //select the unit to charge
                tM.selected = this;
                targetingAssist.setStartX(rep.getLayoutX() + 11);
                targetingAssist.setStartY(rep.getLayoutY() + 10);
            }

        } else {
            if (tM.isMove()) {
                //nothing to do here
                return;
            }
            if (tM.isShoot()) {
                //target the unit to shoot and have him shoot.
                tM.targeted = this;
                targetingAssist.setEndX(rep.getLayoutX());
                targetingAssist.setEndY(rep.getLayoutY());
                Point2D p1 = new Point2D(targetingAssist.getStartX(), targetingAssist.getStartY());
                Point2D p2 = new Point2D(targetingAssist.getEndX(), targetingAssist.getEndY());
                int distance = (int) p1.distance(p2);
                if (tM.selected != null) {
                    if (!tM.selected.shot) {//see if that unit had shot yet
                        D6 d6 = new D6();
                        Tables table = new Tables();
                        shoot(tM, distance, d6, table, root);//resolve shooting attack
                    }
                }
            }
            if (tM.isAssualt()) {
                //same initial process as shooting
                tM.targeted = this;
                targetingAssist.setEndX(rep.getLayoutX());
                targetingAssist.setEndY(rep.getLayoutY());
                Point2D p1c = new Point2D(targetingAssist.getStartX(), targetingAssist.getStartY());
                Point2D p2c = new Point2D(targetingAssist.getEndX(), targetingAssist.getEndY());
                int distance = (int) p1c.distance(p2c);
                if (!tM.selected.charged &&  tM.selected != null) {
                    charge(tM, distance, root);
                }
            }
        }
    }

    /**
     *
     * @return: String representation of this unit's stats. 
     */
    public String toString() {
        return ("WS: " + WS + " BS: " + BS + " S: " + S + " T: " + T + " W: " + W + " I: " + I + " A: " + A
                + " LD: " + Ld + " SV: " + Sv);

    }

}
