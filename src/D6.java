

/**
 *
 * @author Ryan Silver
 */
public class D6 {

    /**
     *roll
     * @param num:number of dice to throw
     * @param success:minimum roll to hit/wound/save on the D6
     * @return: total number of successes 
     * rolls num RNG d6's and returns the total number of successes 
     */
  public interface IRandom {

   public double random();

}

public class ConcreteRandom implements IRandom {

   public double random() {
      return Math.random();
   }

}

public class MockedRandomWrapper implements IRandom {

   private double theDouble;    

   public MockedRandomWrapper(double theDouble) {
       this.theDouble = theDouble;
   }

   public double random() { 
       return theDouble;
   }

}

IRandom irandom;

public D6(IRandom irandom)
{
this.irandom = irandom;
}
public D6()
{
    this.irandom = new ConcreteRandom();
}


    public int roll(int num, int success) {
        int sum = 0;
       
        
        for (int i = 0; i < num; i++) {
            if ((((int) (irandom.random() * 6)) + 1) >= success) {
                sum += 1;
            }
        }
        return sum;
    }
    
    public int charge(){ 
        System.out.println(irandom.random());
    return ( (((int) (irandom.random() * 6)) + 1)  
            + (((int) (irandom.random() * 6)) + 1)) ;}
}
