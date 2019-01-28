package saltycat;

import java.util.Random;
import javafx.animation.AnimationTimer;
 import javafx.application.Application;
 import javafx.geometry.Rectangle2D;
 import javafx.scene.Group;
 import javafx.scene.Scene; 
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
 import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
 import javafx.scene.paint.Color;
import javafx.scene.text.Text;
 import javafx.stage.Stage; 

public class SaltyCat extends Application {
    
int posicionX= 1024;
int posicionY= 768;

int pos1Fondo= 0;
int pos2Fondo1= 1024;

int pos1FondoCamino= 0;
int pos2FondoCamino= 1024;

int velocidad= -1 ;
int velocidadCamino = -2;
           
int score;
Text textScore;

int velocidadG=-2;

ImageView fondoJuego = new ImageView();
ImageView fondoJuego1 = new ImageView();

ImageView fondoCamino = new ImageView();
ImageView fondoCamino1 = new ImageView();

ImageView gatoMuerto = new ImageView();
ImageView gatoSaltar = new ImageView();
ImageView gatoCaminar = new ImageView();

ImageView gallinaG1 = new ImageView();
ImageView gallinaG2 = new ImageView();
ImageView gallinaG3 = new ImageView();
ImageView gallinaG4 = new ImageView();

//Gallina 1
int pos1Gallina1= 1100;
//Gallina 2
int pos1Gallina2= 1400;
//Gallina 3
int pos1Gallina3= 1700;
//Gallina 4
int pos1Gallina4= 2000;
            

Group root = new Group();
Group gatoMovimiento;
Group gatoSalto;
Group gatoDie;

    @Override
  public void start(Stage stage){
     
      fondosYGatos();
    
    //Texto de score
    textScore = new Text("0");

    Scene scene = new Scene(root, posicionX, posicionY);
    stage.setTitle("Salty Cats");
    stage.setScene(scene);
    stage.show();
    
    
    AnimationTimer animationFondo = new AnimationTimer(){
    @Override
    
        public void handle (long now){
                fondoMontañas();
                fondoCamino();
            
        } 
    };
    
    animationFondo.start();
//  
//            scene.setOnKeyPressed((KeyEvent event)-> {
//            switch(event.getCode()){
//                case W:
//                    gatoMovimiento.setVisible(false);
////                    gatoSalto.setVisible(true);
//                    gatoSalto.setLayoutX(300);
//                    
//                    break;
//            }
//        });
//        scene.setOnKeyReleased((KeyEvent event) -> {
//             
//        }); 
  
  }
       private void fondosYGatos(){
                   // Imagen fondo montañas 
        Image imageFondo = new Image("fondo.png");

        fondoJuego = new ImageView();
        fondoJuego1 = new ImageView();

        fondoJuego.setImage(imageFondo);
        fondoJuego1.setImage(imageFondo);

        fondoJuego.setFitWidth(1024);
        fondoJuego.setFitHeight(768);
        fondoJuego1.setFitWidth(1024);
        fondoJuego1.setFitHeight(768);

        root.getChildren().add(fondoJuego);
        root.getChildren().add(fondoJuego1);
        
        Image imageFondoCamino = new Image("fondoCamino.png");

        fondoCamino = new ImageView();
        fondoCamino1 = new ImageView();

        fondoCamino.setImage(imageFondoCamino);
        fondoCamino1.setImage(imageFondoCamino);

        fondoCamino.setFitWidth(1024);
        fondoCamino.setFitHeight(768);

        fondoCamino1.setFitWidth(1024);
        fondoCamino1.setFitHeight(768);

        root.getChildren().add(fondoCamino);
        root.getChildren().add(fondoCamino1);
        
                    
        Image imageMuerte = new Image ("gatoMuerte.gif");
        gatoMuerto = new ImageView();
        gatoMuerto.setImage(imageMuerte);
        gatoMuerto.setScaleX(4);
        gatoMuerto.setScaleY(4);
            
        Image imageSalto = new Image ("saltoGato.gif");
        gatoSaltar = new ImageView();
        gatoSaltar.setImage(imageSalto);
        gatoSaltar.setScaleX(4);
        gatoSaltar.setScaleY(4);
      
                   
        Image imageCaminar = new Image ("catWalk.gif");
        gatoCaminar = new ImageView();
        gatoCaminar.setImage(imageCaminar);
        gatoCaminar.setScaleX(4);
        gatoCaminar.setScaleY(4);
 
       }
       
       private void gashinitas(){
        Image imageChicken = new Image ("chicken.gif");
    
        gallinaG1 = new ImageView();
        gallinaG2 = new ImageView();
        gallinaG3 = new ImageView();
        gallinaG4 = new ImageView();

        gallinaG1.setImage(imageChicken);
        gallinaG2.setImage(imageChicken);
        gallinaG3.setImage(imageChicken);
        gallinaG4.setImage(imageChicken);

        gallinaG1.setScaleX(2);
        gallinaG1.setScaleY(2);

        gallinaG2.setScaleX(2);
        gallinaG2.setScaleY(2);

        gallinaG3.setScaleX(2);
        gallinaG3.setScaleY(2);

        gallinaG4.setScaleX(2);
        gallinaG4.setScaleY(2);
       }
       
       private void fondoMontañas(){
        fondoJuego.setX(pos1Fondo);
        fondoJuego1.setX(pos2Fondo1);
        pos1Fondo+=velocidad;
        pos2Fondo1+=velocidad;
        
        if (pos2Fondo1 == 0){
            pos1Fondo = 1024;
        }
        if (pos1Fondo == 0){
            pos2Fondo1 = 1024;         
        }
       }
      
       private void fondoCamino(){
           
        fondoCamino.setX(pos1FondoCamino);
        fondoCamino1.setX(pos2FondoCamino);
        pos1FondoCamino+= velocidadCamino;
        pos2FondoCamino+= velocidadCamino;
        
        if (pos2FondoCamino==0){
            pos1FondoCamino = 1024;
        }
        if (pos1FondoCamino== 0){
            pos2FondoCamino = 1024;
        }
       }
  
       private void crearGatoMuerto(){
            gatoDie = new Group();
            gatoDie.getChildren().add(gatoMuerto);
            gatoDie.setLayoutX(150);
            gatoDie.setLayoutY(600);
            root.getChildren().add(gatoDie); 
       }
       
       private void crearSaltoGato(){

            gatoSalto = new Group();
            gatoSalto.getChildren().add(gatoSaltar);
            gatoSalto.setLayoutX(150);
            gatoSalto.setLayoutY(600);
            root.getChildren().add(gatoSalto);
       }
       
       private void crearMovimientoGato(){

            gatoMovimiento = new Group();
            gatoMovimiento.getChildren().add(gatoCaminar);
            gatoMovimiento.setLayoutX(150); 
            gatoMovimiento.setLayoutY(600);
            root.getChildren().add(gatoMovimiento);
     }
       
       private void gallinasGrupo(){

        Random aleatorio = new Random();
  
        Group gallinaGrupo1 = new Group();
        gallinaGrupo1.getChildren().add(gallinaG1);
        gallinaGrupo1.setLayoutX(pos1Gallina1);
        gallinaGrupo1.setLayoutY(600);
        root.getChildren().add(gallinaGrupo1);

        Group gallinaGrupo2 = new Group();
        gallinaGrupo2.getChildren().add(gallinaG2);
        gallinaGrupo2.setLayoutX(pos1Gallina2);
        gallinaGrupo2.setLayoutY(600);
        root.getChildren().add(gallinaGrupo2);

        Group gallinaGrupo3 = new Group();
        gallinaGrupo3.getChildren().add(gallinaG3);
        gallinaGrupo3.setLayoutX(pos1Gallina3);
        gallinaGrupo3.setLayoutY(600);
        root.getChildren().add(gallinaGrupo3);

        Group gallinaGrupo4 = new Group();
        gallinaGrupo4.getChildren().add(gallinaG4);
        gallinaGrupo4.setLayoutX(pos1Gallina4);
        gallinaGrupo4.setLayoutY(600);
        root.getChildren().add(gallinaGrupo4);

    
 
        int separacion = aleatorio.nextInt(300);
        pos1Gallina1= 1100 + separacion;

        separacion = aleatorio.nextInt(300);
        pos1Gallina2= pos1Gallina1 + separacion;

        separacion = aleatorio.nextInt(300);
        pos1Gallina3= pos1Gallina2 + separacion;
   
        separacion = aleatorio.nextInt(300);
        pos1Gallina4= pos1Gallina3 + separacion;      
        
        gallinaGrupo1.setLayoutX(pos1Gallina1);
        pos1Gallina1+=velocidadG;
        
        if (pos1Gallina1 == -110){
            pos1Gallina1 = 1100 ;
        }      
        
        gallinaGrupo2.setLayoutX(pos1Gallina2);
        pos1Gallina2+=velocidadG;
        
        if (pos1Gallina2 == -110){
            pos1Gallina2 = pos1Gallina1+300;
        } 
        
        gallinaGrupo3.setLayoutX(pos1Gallina3);
        pos1Gallina3+=velocidadG;
        
        if (pos1Gallina3 == -110){
            pos1Gallina3 = pos1Gallina2+300;
        } 
        
        gallinaGrupo4.setLayoutX(pos1Gallina4);
        pos1Gallina4+=velocidadG;
        
        if (pos1Gallina4 == -110){
            pos1Gallina4 = pos1Gallina3+300;
        }         
       }
  
  private void resetGame(){
      score = 0;
      textScore.setText(String.valueOf(score));
      
//      Random random = new Random();
//      gallinaGrupo1.setLayoutX(900)= random.nextInt();
  }
    
  public static void main(String[] args) {
         Application.launch(args);
     }
}

