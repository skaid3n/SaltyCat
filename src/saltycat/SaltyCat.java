package saltycat;

 import javafx.application.Application;
 import javafx.geometry.Rectangle2D;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
 import javafx.scene.paint.Color;
 import javafx.stage.Stage; 

public class SaltyCat extends Application {
    
    @Override
  public void start(Stage stage){
  
    Image image = new Image("fondoBueno.png");
    ImageView fondoJuego = new ImageView();
    fondoJuego.setImage(image);
//    fondoJuego.setScaleX(2);
//    fondoJuego.setScaleY(2);
 
    
    Group root = new Group();
    Scene scene = new Scene(root);
    scene.setFill(Color.BLACK);
    HBox prueba = new HBox();
    prueba.getChildren().add(fondoJuego);
    root.getChildren().add(prueba);
    
    stage.setTitle("Salty Cats");
    stage.setWidth(1200);
    stage.setHeight(650);
    stage.setScene(scene); 
    stage.sizeToScene(); 
    stage.show();
  }
  
  public static void main(String[] args) {
         Application.launch(args);
     }
}
