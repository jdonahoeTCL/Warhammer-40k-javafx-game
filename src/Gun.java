
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Used in testing. 
 *
 */
public class Gun extends Weapon {
    protected Circle c;
    

    public Gun(double radius,double x,double y,String color){
        
        c = new Circle();
        c.setRadius(radius);
        c.setFill(Paint.valueOf(color));
        c.setLayoutX(x);
        c.setLayoutY(y);
        
      

    }

    public void setX(double x){
        this.c.setLayoutX(x);
       
    }


    public void Sety(double y)
    {
        this.c.setLayoutY(y);
    }
    
   
	}//class Gun
