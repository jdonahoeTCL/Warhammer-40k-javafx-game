

import java.awt.MouseInfo;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.stage.*;
import static javafx.application.Application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/*
Quick information.
1 in = 30 pixels
this is to scale with the unit sizes chosen.
move,shoot,assualt
*/
/**
 * The main for a game of ID40K.
 *
 */
public class window extends Application {
    Pane pane1, root , pane2;
    Scene scene1, scene2, scene3;
    Stage thestage;
    boolean player1Selected = false;
    int player1UnitSelected =88;
    int player2UnitSelected = 88;
    unit[] redTeam = new unit[5];
    unit[] blueTeam = new unit[5];
    unit selectedUnit;
    turnManager turnM = new turnManager();
    Circle movementAssist = new Circle(50, 50, 150, Paint.valueOf("yellow"));
    Line targetingAssist=new Line();
    Text t1 = new Text("");
    Text t2 = new Text("Movement Phase");
    static Text t3 = new Text("Status Update:");
    
    String Phase;
      Image grassTexture = new Image("snow_ground.png");
        Image player1Victory = new Image("PlayerOneWins.png");
        Image player2Victory = new Image("PlayerTwoWins.png");
        Image SpaceMarine = new Image("spacemarine.png");
        Image EldarRanger = new Image("Eldar Ranger.png");
        Image DireAvenger = new Image("Dire Avenger.png");
        Image EldarGuardianDefenders = new Image("Eldar Guardian Defenders.jpg");
        Image draw = new Image("Draw.png");
    
    @Override
    public void start(Stage primaryStage) {
       thestage=primaryStage;
       Button smUnit=new Button("          Space Marines        ");
       Button erUnit=new Button("          Eldar Rangers         ");
       Button daUnit=new Button("          Dire Avengers         ");
    Button egdUnit = new Button("Eldar Guardian Defenders");
       
       smUnit.setLayoutX(550);
       smUnit.setLayoutY(250);
       
       erUnit.setLayoutX(550);
       erUnit.setLayoutY(290);
       
       daUnit.setLayoutX(550);
       daUnit.setLayoutY(330);
       
       egdUnit.setLayoutX(550);
       egdUnit.setLayoutY(370);
       
       smUnit.setOnAction(e-> ButtonClicked(e,0));
       erUnit.setOnAction(e-> ButtonClicked(e, 1));
       daUnit.setOnAction(e-> ButtonClicked(e, 2));
       egdUnit.setOnAction(e->ButtonClicked(e,3));
       
        Image unitSelectionScreen = new Image("ID-40k Unit Selection Screen.jpg");
        ImageView iv2 = new ImageView();
        iv2.setImage(unitSelectionScreen);
        
       
        pane1 = new Pane();
        pane1.getChildren().add(iv2);
        pane1.getChildren().add(smUnit);
        pane1.getChildren().add(erUnit);
        pane1.getChildren().add(daUnit);
        pane1.getChildren().add(egdUnit);
       
        pane2 = new Pane();
        
        
       
        ImageView iv1 = new ImageView();
      
        
        
        
        iv1.setFitHeight(795);
        iv1.setFitWidth(1400);
        iv1.setImage(grassTexture);
        ImageView iv3 = new ImageView();
        iv3.setFitHeight(107);
        iv3.setFitWidth(602);
        
   
        Tables T = new Tables();
        root = new Pane();
        scene1 = new Scene(pane1, 1200, 625);
        scene2 = new Scene(root, 1200, 625);
        scene3 = new Scene(pane2,602,107);
       
        primaryStage.setTitle("warhammer game");
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
   
     
       t2.setLayoutX(525);
       t2.setLayoutY(25);
       t2.setFont(Font.font ("Verdana", 20));
   
       
        Button phaseAdv=new Button("Next Phase");
        Button phasePrv=new Button("Previous Phase");
        Button passTurn=new Button("Pass Turn");
   
       phaseAdv.setLayoutX(1000);
       phaseAdv.setLayoutY(600);
       
       
        phasePrv.setLayoutX(900);
        phasePrv.setLayoutY(600);
       
   
        passTurn.setLayoutX(1100);
        passTurn.setLayoutY(600);
     
        phaseAdv.setOnAction(e->{
            if(turnM.getPhase()==3)
                turnM.pass(blueTeam,redTeam);
            else
            turnM.incPhase();
           setPhaseText(t2, turnM);
           t2.setFill(Paint.valueOf("Black"));
        if((!blueTeam[0].alive && !blueTeam[1].alive && !blueTeam[2].alive && !blueTeam[3].alive && !blueTeam[4].alive)&&(!redTeam[0].alive && !redTeam[1].alive && !redTeam[2].alive && !redTeam[3].alive && !redTeam[4].alive))
            {
                iv3.setImage(draw);
             thestage.setScene(scene3); 
            }
            else if(!blueTeam[0].alive && !blueTeam[1].alive && !blueTeam[2].alive && !blueTeam[3].alive && !blueTeam[4].alive)
              {
            iv3.setImage(player1Victory);
             thestage.setScene(scene3); 
              }
                    else if(!redTeam[0].alive && !redTeam[1].alive && !redTeam[2].alive && !redTeam[3].alive && !redTeam[4].alive)
           {
         iv3.setImage(player2Victory);
              thestage.setScene(scene3); 
           }
        });
        phasePrv.setOnAction(e->{
           turnM.decPhase();
           setPhaseText(t2, turnM);
           t2.setFill(Paint.valueOf("Black"));
        });
        passTurn.setOnAction(e->{
            turnM.pass(blueTeam, redTeam);
            setPhaseText(t2, turnM);
            t2.setFill(Paint.valueOf("Black"));
            if((!blueTeam[0].alive && !blueTeam[1].alive && !blueTeam[2].alive && !blueTeam[3].alive && !blueTeam[4].alive)&&(!redTeam[0].alive && !redTeam[1].alive && !redTeam[2].alive && !redTeam[3].alive && !redTeam[4].alive))
            {
                iv3.setImage(draw);
             thestage.setScene(scene3); 
            }
            else if(!blueTeam[0].alive && !blueTeam[1].alive && !blueTeam[2].alive && !blueTeam[3].alive && !blueTeam[4].alive)
              {
            iv3.setImage(player1Victory);
             thestage.setScene(scene3); 
              }
                    else if(!redTeam[0].alive && !redTeam[1].alive && !redTeam[2].alive && !redTeam[3].alive && !redTeam[4].alive)
           {
         iv3.setImage(player2Victory);
              thestage.setScene(scene3); 
           }
        });
       
        movementAssist.setOpacity(.5);
     
        t1.setLayoutX(10);
        t1.setLayoutY(620);
        
      
        t3.setLayoutX(520);
        t3.setLayoutY(600);
        t3.setFont(Font.font ("Verdana", 14));

        
        root.getChildren().add(iv1);
        root.getChildren().add(phaseAdv);
        root.getChildren().add(phasePrv);
        root.getChildren().add(passTurn);
        root.getChildren().add(t2);
        root.getChildren().add(t3);
        pane2.getChildren().add(iv3);
        
 
     
        
       
       
       }
        
    /**
     * Creates a new game.
     */
    public void createGame()
    {
   int depth = 30; //Setting the uniform variable for the glow width and height
    DropShadow borderGlowP1= new DropShadow();
    borderGlowP1.setOffsetY(0f);
    borderGlowP1.setOffsetX(0f);
    borderGlowP1.setColor(Color.RED);
    borderGlowP1.setWidth(depth);
    borderGlowP1.setHeight(depth);
     DropShadow borderGlowP2= new DropShadow();
    borderGlowP2.setOffsetY(0f);
    borderGlowP2.setOffsetX(0f);
    borderGlowP2.setColor(Color.BLUE);
    borderGlowP2.setWidth(depth);
    borderGlowP2.setHeight(depth);
        Image selectedImagePlayer1 = SpaceMarine;
        Image selectedImagePlayer2 = SpaceMarine;
       
         for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0) {//generate red team
                  
                
                    if(player1UnitSelected==0)
                    {
                    selectedUnit = new SpaceMarine("unit" + (j + 1),false);
                    selectedImagePlayer1 = SpaceMarine;
                    }
                    else if(player1UnitSelected==1)
                    {
                         selectedUnit = new EldarRangers("unit" + (j + 1),false);
                         selectedImagePlayer1 = EldarRanger;
                    }
                    else if(player1UnitSelected==2)
                    {
                        selectedUnit = new DireAvengers("unit" + (j+1), false);
                        selectedImagePlayer1 = DireAvenger;
                    }
                    else if(player1UnitSelected==3)
                    {
                          selectedUnit = new EldarGuardianDefenders("unit" + (j + 1),false);
                          selectedImagePlayer1 = EldarGuardianDefenders;
                    }
                 
                   selectedUnit.rep = new ImageView();
                   selectedUnit.rep.setImage(selectedImagePlayer1);
                   selectedUnit.rep.setLayoutX(50);
                   selectedUnit.rep.setLayoutY((j+1)*100);
                   selectedUnit.rep.setEffect(borderGlowP1);
                   redTeam[j] = selectedUnit;
                    
                }
                if (i == 1) { //generate blue team
                    if(player2UnitSelected==0)
                    {
                         selectedUnit = new SpaceMarine("unit" + (j + 1),true);
                          selectedImagePlayer2 = SpaceMarine;
                    }
                    else if(player2UnitSelected==1)
                    {
                         selectedUnit = new EldarRangers("unit" + (j + 1),true);
                         selectedImagePlayer2 = EldarRanger;
                    }
                    else if(player2UnitSelected==2)
                    {
                         selectedUnit = new DireAvengers("unit" + (j + 1),true);
                         selectedImagePlayer2 = DireAvenger;
                    }
                    else if(player2UnitSelected==3)
                    {
                         selectedUnit = new EldarGuardianDefenders("unit" + (j + 1),true);
                       selectedImagePlayer2 = EldarGuardianDefenders;
                            }
                   
                   
                   selectedUnit.rep = new ImageView();
                   selectedUnit.rep.setImage(selectedImagePlayer2);
                   selectedUnit.rep.setLayoutX(1150);
                   selectedUnit.rep.setLayoutY((j+1)*100);
                   selectedUnit.rep.setEffect(borderGlowP2);
                    blueTeam[j] = selectedUnit;
                }
                }
     
      
           
        }
              
           for (int i = 0; i < redTeam.length; i++) {
            root.getChildren().add(redTeam[i].rep);
        }
        for (int i = 0; i < blueTeam.length; i++) {
            root.getChildren().add(blueTeam[i].rep);
        }
         movementAssist.setOnMouseClicked(r -> {
            if (!turnM.selected.moved && turnM.isMove()) {
                turnM.selected.rep.setLayoutX(r.getX());
                turnM.selected.rep.setLayoutY(r.getY());
                turnM.selected.moved = true;

            }
            root.getChildren().remove(movementAssist);
        });
            blueTeam[0].rep.setOnMouseClicked(t -> { 
            blueTeam[0].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        blueTeam[1].rep.setOnMouseClicked(t -> {
            blueTeam[1].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        blueTeam[2].rep.setOnMouseClicked(t -> {
            blueTeam[2].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        blueTeam[3].rep.setOnMouseClicked(t -> {
            blueTeam[3].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        blueTeam[4].rep.setOnMouseClicked(t -> {
            blueTeam[4].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        redTeam[0].rep.setOnMouseClicked(t -> {
            redTeam[0].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        redTeam[1].rep.setOnMouseClicked(t -> {
            redTeam[1].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        redTeam[2].rep.setOnMouseClicked(t -> {
            redTeam[2].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        redTeam[3].rep.setOnMouseClicked(t -> {
            redTeam[3].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
        redTeam[4].rep.setOnMouseClicked(t -> {
            redTeam[4].handleMouseClick(t,turnM, movementAssist,root,targetingAssist);
        });
         blueTeam[0].rep.setOnMouseEntered(r -> {
            setText(t1, blueTeam[0]);
            t1.setFill(Paint.valueOf("blue"));
        });
        redTeam[0].rep.setOnMouseEntered(r -> {
            setText(t1, redTeam[0]);
            t1.setFill(Paint.valueOf("red"));
        });
        blueTeam[1].rep.setOnMouseEntered(r -> {
            setText(t1, blueTeam[1]);
            t1.setFill(Paint.valueOf("blue"));
        });
        redTeam[1].rep.setOnMouseEntered(r -> {
            setText(t1, redTeam[1]);
            t1.setFill(Paint.valueOf("red"));
        });
        blueTeam[2].rep.setOnMouseEntered(r -> {
            setText(t1, blueTeam[2]);
            t1.setFill(Paint.valueOf("blue"));
        });
        redTeam[2].rep.setOnMouseEntered(r -> {
            setText(t1, redTeam[2]);
            t1.setFill(Paint.valueOf("red"));
        });
        blueTeam[3].rep.setOnMouseEntered(r -> {
            setText(t1, blueTeam[3]);
            t1.setFill(Paint.valueOf("blue"));
        });
        redTeam[3].rep.setOnMouseEntered(r -> {
            setText(t1, redTeam[3]);
            t1.setFill(Paint.valueOf("red"));
        });
        blueTeam[4].rep.setOnMouseEntered(r -> {
            setText(t1, blueTeam[4]);
            t1.setFill(Paint.valueOf("blue"));
        });
        redTeam[4].rep.setOnMouseEntered(r -> {
            setText(t1, redTeam[4]);
            t1.setFill(Paint.valueOf("red"));
        
        });
              for (int i = 0; i < blueTeam.length; i++) {
            blueTeam[i].rep.setOnMouseExited(q-> {
                t1.setText("");
                t1.setFill(Paint.valueOf("black"));
            });
            redTeam[i].rep.setOnMouseExited(q -> {
                t1.setText("");
                t1.setFill(Paint.valueOf("black"));
            });
        }
         root.getChildren().add(t1);
    }
    
    /**
     *
     * @param e: event created by the click
     * @param unitID: unit's integer title
     */
    public void ButtonClicked(ActionEvent e, int unitID)
    {
           if(player1Selected == false)
           {
               player1UnitSelected = unitID;
               player1Selected = true;
           }
           else 
           {
             player2UnitSelected = unitID;
             createGame();
             thestage.setScene(scene2); 
           }
          
    }
 
    /**
     *
     * @param t: text Parameter to be set
     * @param u: unit to base text on
     */
    public void setText(Text t, unit u) {
        t.setText("UNIT STATS: " + u.toString());
    }

    /**
     *
     * @param t: instance of text to be modified 
     * @param tM: instance of turnmanager in use
     */
    public void setPhaseText(Text t, turnManager tM)
    {
        if(tM.getPhase()==1)
             t.setText("Movement Phase");
        else if(tM.getPhase()==2)
            t.setText("Shooting Phase");
        else if(tM.getPhase()==3)
        t.setText("Assualt Phase");
    }


    /**
     * Update a status. 
     * @param s: used to set a status update 
     */
    
    public static void setStatusUpdate(String s)
    {
     t3.setText("Status Update: " + s);
    }

    /**
     *
     * @param args: args to launch game with. please leave blank.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
