/**
 * Used to setup Tables commonly used in ID40K. 
 *
 */
public class Tables {
      final private int[] toHit={0,6,5,4,3,2};
      final private int[][] toHitAssualt={{4,4,5,5,5,5,5,5,5,5},
                                           {3,4,4,4,5,5,5,5,5,5},
                                           {3,3,4,4,4,4,5,5,5,5},
                                           {3,3,3,4,4,4,4,4,5,5},
                                           {3,3,3,3,4,4,4,4,4,4},
                                           {3,3,3,3,3,4,4,4,4,4},
                                           {3,3,3,3,3,3,4,4,4,4},
                                           {3,3,3,3,3,3,3,4,4,4},
                                           {3,3,3,3,3,3,3,3,4,4},
                                           {3,3,3,3,3,3,3,3,3,4}};
      final private int[][] toWound={{4,5,6,20,20,20,20,20,20,20},
                             {3,4,5,6,6,20,20,20,20,20},
                             {2,3,4,5,6,6,20,20,20,20},
                             {2,2,3,4,5,6,6,20,20,20},
                             {2,2,2,3,4,5,6,6,20,20},
                             {2,2,2,2,3,4,5,6,6,20},
                             {2,2,2,2,2,3,4,5,6,6},
                             {2,2,2,2,2,2,3,4,5,6},
                             {2,2,2,2,2,2,2,3,4,5},
                             {2,2,2,2,2,2,2,2,3,4}};
    /**
     *Method to use to get success parameter for shooting
     * @param Bs:shooter's Ballistic Skill(BS)
     * @return
     */
    public int getToHit(int Bs){return toHit[Bs];}
    /**
     *Method to use to get success parameter for assualt
     * @param Wsa:attackers WS (weapon skill)
     * @param Wsd:defenders WS (weapon skill)
     * @return:the required roll for a success attacking in assualt
     */
    public int getToHitAssualt(int Wsa,int Wsd){return toHitAssualt[Wsa][Wsd];} //toHitAssualt[Wsa][Wsd];
    /**
     *
     * @param S:attackers strength
     * @param T:defender's toughness 
     * @return: required roll to wound 
     */
    public int getToWound(int S,int T){
        return  toWound[S][T];
    }
    Tables() {
    }
}
