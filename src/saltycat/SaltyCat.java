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
  
      // Fondo 1
    Image imageFondo = new Image("fondo.png");
    ImageView fondoJuego = new ImageView();
    fondoJuego.setImage(imageFondo);
    
     // Fondo 2
    Image imageFondoCamino = new Image("fondoCamino.png");
    ImageView fondoCamino = new ImageView();
    fondoCamino.setImage(imageFondoCamino);
     
     // Gato Caminando
    Image imageCaminar = new Image ("catWalk.gif");
    ImageView gatoCaminar = new ImageView();
    gatoCaminar.setImage(imageCaminar);
    gatoCaminar.setScaleX(4);
    gatoCaminar.setScaleY(4);
 
    // Gato Saltando
    Image imageSalto = new Image ("saltoGato.gif");
    ImageView gatoSaltar = new ImageView();
    gatoSaltar.setImage(imageSalto);
    gatoSaltar.setScaleX(4);
    gatoSaltar.setScaleY(4);
    
    // Gato Muerto
    Image imageMuerte = new Image ("gatoMuerte.gif");
    ImageView gatoMuerto = new ImageView();
    gatoMuerto.setImage(imageMuerte);
    gatoMuerto.setScaleX(4);
    gatoMuerto.setScaleY(4);
    
    // Gallina
    Image imageChicken = new Image ("chicken.gif");
    ImageView gallinaGF = new ImageView();
    gallinaGF.setImage(imageChicken);
    gallinaGF.setScaleX(2);
    gallinaGF.setScaleY(2);
    
    
    
    
     // Creacion de grupos
    Group root = new Group();
    Scene scene = new Scene(root);
    scene.setFill(Color.BLACK);
    
    // Fondo 1
    HBox fondo1= new HBox();
    fondo1.getChildren().add(fondoJuego);
    root.getChildren().add(fondo1);
    
    // Fondo 2
    HBox fondo2 = new HBox();
    fondo2.getChildren().add(fondoCamino);
    root.getChildren().add(fondo2);
    
    
    // Gato movimiento andar
    HBox gatoMovimiento = new HBox();
    gatoMovimiento.getChildren().add(gatoCaminar);
    gatoMovimiento.setLayoutX(150);
    gatoMovimiento.setLayoutY(600);
    root.getChildren().add(gatoMovimiento);
    
    // Gato movimiento saltar
//    HBox gatoSalto = new HBox();
//    gatoSalto.getChildren().add(gatoSaltar);
//    gatoSalto.setLayoutX(150);
//    gatoSalto.setLayoutY(600);
//    root.getChildren().add(gatoSalto);
    
    // Gato muerto
//    HBox gatoDie = new HBox();
//    gatoDie.getChildren().add(gatoMuerto);
//    gatoDie.setLayoutX(150);
//    gatoDie.setLayoutY(600);
//    root.getChildren().add(gatoDie);
    
    // Gallina picoteando
    HBox gallinaChicken = new HBox();
    gallinaChicken.getChildren().add(gallinaGF);
    gallinaChicken.setLayoutX(900);
    gallinaChicken.setLayoutY(600);
    root.getChildren().add(gallinaChicken);
    
    stage.setTitle("Salty Cats");
    stage.setWidth(1024);
    stage.setHeight(768);
    stage.setScene(scene); 
    stage.sizeToScene(); 
    stage.show();
  }
  
  public static void main(String[] args) {
         Application.launch(args);
     }
}
