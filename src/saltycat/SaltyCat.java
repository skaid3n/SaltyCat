package saltycat;

import javafx.animation.AnimationTimer;
 import javafx.application.Application;
 import javafx.geometry.Rectangle2D;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
 import javafx.scene.paint.Color;
 import javafx.stage.Stage; 

public class SaltyCat extends Application {

int posicionX= 1024;
int posicionY= 768;

int pos1Fondo= 0;
int pos2Fondo1= 1024;


int velocidad= -2 ;


    @Override
  public void start(Stage stage){
      
    Group root = new Group();
    Scene scene = new Scene(root, posicionX, posicionY);
    stage.setTitle("Salty Cats");
    stage.setScene(scene);
    stage.show();
  
      // Imagen y grupo de fondo
    Image imageFondo = new Image("fondo.png");
    ImageView fondoJuego = new ImageView();
    ImageView fondoJuego1 = new ImageView();
    
    fondoJuego.setImage(imageFondo);
    fondoJuego1.setImage(imageFondo);
    
    fondoJuego.setFitWidth(1024);
    fondoJuego.setFitHeight(768);
    fondoJuego1.setFitWidth(1024);
    fondoJuego1.setFitHeight(768);
    
    root.getChildren().add(fondoJuego);
    root.getChildren().add(fondoJuego1);
    
    AnimationTimer animationFondo = new AnimationTimer(){
    @Override
    public void handle (long now){
        fondoJuego.setX(pos1Fondo);
        fondoJuego1.setX(pos2Fondo1);
        pos1Fondo+=velocidad;
        pos2Fondo1+=velocidad;
        
        if (pos1Fondo >= 1023){
            
                   
        }
        
        }
    };
    animationFondo.start();
    
    
    
//    HBox fondo1= new HBox();
//    fondo1.getChildren().add(fondoJuego);
//    root.getChildren().add(fondo1);
    
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
    
//    stage.setTitle("Salty Cats");
//    stage.setWidth(1024);
//    stage.setHeight(768);
//    stage.setScene(scene); 
//    stage.sizeToScene(); 
//    stage.show();
  }
  
  public static void main(String[] args) {
         Application.launch(args);
     }
}
