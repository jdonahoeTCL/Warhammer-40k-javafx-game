/**
 * Used to contain any weapon in ID40K
 *
 */
public abstract class Weapon {
    String name;//weapon's name
    int Range;//weapon's range 
    int S;//weapon's strength
    int AP;//weapon ap AP=0 if unit has no AP
    boolean isRapidFire;
    boolean isMelee;
    boolean isMelta;
    boolean isAssault;
    boolean isHeavy;
    int Shots;
}
