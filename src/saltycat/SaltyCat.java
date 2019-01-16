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
  
    Image imageFondo = new Image("fondo.png");
    ImageView fondoJuego = new ImageView();
    fondoJuego.setImage(imageFondo);
    
    Image imageCaminar = new Image ("catWalk.gif");
    ImageView gatoCaminar = new ImageView();
    gatoCaminar.setImage(imageCaminar);
    
    gatoCaminar.setScaleX(3);
    gatoCaminar.setScaleY(3);
 
    
    Group root = new Group();
    
    Scene scene = new Scene(root);
    scene.setFill(Color.BLACK);
    
    // Fondo
    HBox prueba = new HBox();
    prueba.getChildren().add(fondoJuego);
    root.getChildren().add(prueba);
    
    // Gato movimiento
    HBox gatoMovimiento = new HBox();
    gatoMovimiento.getChildren().add(gatoCaminar);
    root.getChildren().add(gatoMovimiento);
    
    
    stage.setTitle("Salty Cats");
    stage.setWidth(1054);
    stage.setHeight(768);
    stage.setScene(scene); 
    stage.sizeToScene(); 
    stage.show();
  }
  
  public static void main(String[] args) {
         Application.launch(args);
     }
}
