import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Idk extends Application {
    public void start(Stage stage) {
    	stage.setTitle("Test");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
       
        Line line = new Line();
        line.setStrokeWidth(25);
        line.setStartX(50); 
        line.setStartY(50);
        line.setEndX(50); 
        line.setEndY(250);
        
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(15);

       stage.setScene(scene); 
        stage.sizeToScene(); 
        root.getChildren().add(line);
        root.getChildren().add(circle);
        stage.setScene(scene);
        stage.show();
    }
	    
	public static String randomNameGenerator() {
		Random r = new Random();
		
		int frstNameParts = 20;
		int scndNameParts = 20;
		
		int frstLastNameParts = 17;
		int scndLastNameParts = 20;
		int thrdLastNameParts = 16;
		
		Object[]nameParts1 = new Object[frstNameParts + 1];
		Object[]nameParts2 = new Object[scndNameParts + 1];
		
		Object[]lastNameParts1 = new Object[frstLastNameParts + 1];
		Object[]lastNameParts2 = new Object[scndLastNameParts + 1];
		Object[]lastNameParts3 = new Object[thrdLastNameParts + 1];
				
		nameParts1[0] = "Hu";
		nameParts1[1] = "Je";
		nameParts1[2] = "Mem";
		nameParts1[3] = "Cun";
		nameParts1[4] = "Boun";
		nameParts1[5] = "Da";
		nameParts1[6] = "Jeff";
		nameParts1[7] = "De";
		nameParts1[8] = "Lou";
		nameParts1[9] = "A";
		nameParts1[10] = "Jo";
		nameParts1[11] = "Bif";
		nameParts1[12] = "Moon";
		nameParts1[13] = "Man";
		nameParts1[14] = "Mi";
		nameParts1[15] = "Shaq";
		nameParts1[16] = "Keem";
		nameParts1[17] = "Fourth";
		nameParts1[18] ="Ban";
		nameParts1[19] ="Du";
		nameParts1[20] ="Fish";
		
		nameParts2[0] = "jo";
		nameParts2[1] = "ty";
		nameParts2[2] = "sus";
		nameParts2[3] = "ter";
		nameParts2[4] = "mer";
		nameParts2[5] = "rude";
		nameParts2[6] = "vid";
		nameParts2[7] = "ery";
		nameParts2[8] = "gh";
		nameParts2[9] = ""; //Intentionally empty
		nameParts2[10] = "dolf";
		nameParts2[11] = "moon";
		nameParts2[12] = "man";
		nameParts2[13] = "chael";
		nameParts2[14] = "eel";
		nameParts2[15] = "strat";
		nameParts2[16] = "chan";
		nameParts2[17] = "nus";
		nameParts2[18] = "ez";
		nameParts2[19] = "ke";
		nameParts2[20] = "meth";
		
		lastNameParts1[0] = "Lan";
		lastNameParts1[1] = "Fuk";
		lastNameParts1[2] = "Cum";
		lastNameParts1[3] = "Bong";
		lastNameParts1[4] = "Job";
		lastNameParts1[5] = "Sand";
		lastNameParts1[6] = "Man";
		lastNameParts1[7] = "Hit";
		lastNameParts1[8] = "Neg";
		lastNameParts1[9] = "Dähn";
		lastNameParts1[10] = "Hite";
		lastNameParts1[11] = "In";
		lastNameParts1[12] = "O' U";
		lastNameParts1[13] = "Nu";
		lastNameParts1[14] = "Na";
		lastNameParts1[15] = "Nice";
		lastNameParts1[16] = "Belly";
		lastNameParts1[17] = "Ur";
		
		lastNameParts2[0] = "bo";
		lastNameParts2[1] = "boy";
		lastNameParts2[2] = "seek";
		lastNameParts2[3] = "snort";
		lastNameParts2[4] = "ken";
		lastNameParts2[5] = "storm";
		lastNameParts2[6] = "pus";
		lastNameParts2[7] = "dude";
		lastNameParts2[8] = "lor";
		lastNameParts2[9] = "job";
		lastNameParts2[10] = "ro";
		lastNameParts2[11] = "man";
		lastNameParts2[12] = "sert";
		lastNameParts2[13] = "eal";
		lastNameParts2[14] = "ts";
		lastNameParts2[15] = "ru";
		lastNameParts2[16] = "boo";
		lastNameParts2[17] = "kem";
		lastNameParts2[18] = "belly";
		lastNameParts2[19] = "button";
		lastNameParts2[20] = "mom";
		
		lastNameParts3[0] = "lo";
		lastNameParts3[1] = "man";
		lastNameParts3[2] = "er";
		lastNameParts3[3] = "ovic";
		lastNameParts3[4] = "ton";
		lastNameParts3[5] = "sy";
		lastNameParts3[6] = "der";
		lastNameParts3[7] = "ty";
		lastNameParts3[8] = "no";
		lastNameParts3[9] = "ä";
		lastNameParts3[10] = "zer";
		lastNameParts3[11] = "ion";
		lastNameParts3[12] = "y";
		lastNameParts3[13] = "dan";
		lastNameParts3[14] = "to";
		lastNameParts3[15] = "on";
		lastNameParts3[16] = "son";
		
		String name = "";
		name += (nameParts1[r.nextInt(frstNameParts + 1)]);
		name += (nameParts2[r.nextInt(scndNameParts + 1)]);
		name += (" ");
		name += (lastNameParts1[r.nextInt(frstLastNameParts + 1)]);
		name += (lastNameParts2[r.nextInt(scndLastNameParts + 1)]);
		if(r.nextInt(10 + 1) >= 5) {
			name += (lastNameParts3[r.nextInt(thrdLastNameParts + 1)]);
		}
		
		return name;
	}
	
	public static void test (String[] args) {
		Application.launch(args);
	}
}

