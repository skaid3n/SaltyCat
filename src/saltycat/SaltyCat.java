package saltycat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
import java.util.concurrent.ThreadLocalRandom;
import javafx.geometry.Pos;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

public class SaltyCat extends Application {
Random aleatorio = new Random();
    
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

int velocidadG=-4;

final int TEXT_SIZE = 24;
int hightScore;

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
int pos1Gallina1= ThreadLocalRandom.current().nextInt(1100, 1400); 
//Gallina 2
int pos1Gallina2= ThreadLocalRandom.current().nextInt(1700, 2000);
//Gallina 3
int pos1Gallina3= ThreadLocalRandom.current().nextInt(2300, 2600);
//Gallina 4
int pos1Gallina4= ThreadLocalRandom.current().nextInt(2900, 3100);
            
Group root = new Group();
Group gatoMovimiento;
Group gatoDie;

Group gallinaGrupo1;
Group gallinaGrupo2;
Group gallinaGrupo3;
Group gallinaGrupo4;

int gatoVel = 0;
int gatoY = 600;
int gatoX = 150; 
int gatoYsalto = 0;
int gatoLimit=600;

Rectangle suelo;
Rectangle gatoCuerpo;

    @Override
  public void start(Stage stage){  
      fondosYGatos();
      gashinitas();
      
      
      
    
    //Texto de score
    textScore = new Text("0");

    Scene scene = new Scene(root, posicionX, posicionY);
    stage.setTitle("Salty Cats");
    stage.setScene(scene);
    stage.show();
    
    //Layout principal
    HBox paneScores = new HBox();
    paneScores.setTranslateY(20);
    paneScores.setMinWidth(posicionX);
    paneScores.setAlignment(Pos.CENTER);
    paneScores.setSpacing(100);
    root.getChildren().add(paneScores);
    //Layout puntuacion actual
    HBox paneActualScores = new HBox();
    paneActualScores.setSpacing(10);
    paneScores.getChildren().add(paneActualScores);
    //Layout puntuacion maxima
    HBox paneMaximaScores = new HBox();
    paneMaximaScores.setSpacing(10);
    paneScores.getChildren().add(paneMaximaScores);
    //Texto de etiqueta para puntuacion
    Text textoTituloPuntuacion = new Text("Score");
    textoTituloPuntuacion.setFont(Font.font(TEXT_SIZE));
    textoTituloPuntuacion.setFill(Color.BLUE);
     //Texto para puntuacion
    textScore = new Text("0");
    textScore.setFont(Font.font(TEXT_SIZE));
    textScore.setFill(Color.BLUE);
    //Texto de etiqueta para puntuacion maxima
    Text textoTituloMaximaPuntuacion = new Text("Max.Score");
    textoTituloMaximaPuntuacion.setFont(Font.font(TEXT_SIZE));
    textoTituloMaximaPuntuacion.setFill(Color.BLUE);
    //Texto para puntuacion
    Text textoMaximaPuntuacion = new Text("0");
    textoMaximaPuntuacion.setFont(Font.font(TEXT_SIZE));
    textoMaximaPuntuacion.setFill(Color.BLUE);
    //Añadir los textos a los layaut reservados
    paneActualScores.getChildren().add(textoTituloPuntuacion);
    paneActualScores.getChildren().add(textScore);
    paneMaximaScores.getChildren().add(textoTituloMaximaPuntuacion);
    paneMaximaScores.getChildren().add(textoMaximaPuntuacion);
    
        
        
    AnimationTimer animationFondo = new AnimationTimer(){
    @Override  
        public void handle (long now){
                fondoMontañas();
                fondoCamino();
                crearMovimientoGato();
                gallinasGrupo();    
                rectanguloGato();

                if(score>hightScore){
                //Cambiar puntuacion mas alta
                hightScore=score;
                textoMaximaPuntuacion.setText(String.valueOf(hightScore));
            }
            gatoY += gatoVel;
//            Shape colision = Shape.intersect(suelo, );

        }     
    };
    
    animationFondo.start();
            scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                case W:
                     gatoVel=-4;  

                break;
                
                case R:
                    this.resetGame();
                    animationFondo.start();
                    break;
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {   
           gatoVel= +4;
           

        });  
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
        
        suelo = new Rectangle();
        suelo.setWidth(1024);
        suelo.setHeight(10);
        suelo.setY(670);
        suelo.setFill(BLACK);
        


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
        
        root.getChildren().add(suelo);
       
        Image imageMuerte = new Image ("gatoMuerte.gif");
        gatoMuerto = new ImageView();
        gatoMuerto.setImage(imageMuerte);
        gatoMuerto.setScaleX(4);
        gatoMuerto.setScaleY(4);
                   
        Image imageCaminar = new Image ("catWalk.gif");
        gatoCaminar = new ImageView();
        gatoCaminar.setImage(imageCaminar);
        gatoCaminar.setScaleX(4);
        gatoCaminar.setScaleY(4);
 
                   
            gatoCuerpo = new Rectangle();
            gatoCuerpo.setWidth(50);
            gatoCuerpo.setHeight(100);
            gatoCuerpo.setY(570);
            gatoCuerpo.setX(130);
            gatoCuerpo.setFill(BLUE);
            gatoCuerpo.setVisible(true);
            
        
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
        
        gallinaGrupo1 = new Group();
        gallinaGrupo1.getChildren().add(gallinaG1);
        gallinaGrupo1.setLayoutX(pos1Gallina1);
        gallinaGrupo1.setLayoutY(600);
        root.getChildren().add(gallinaGrupo1);

        gallinaGrupo2 = new Group();
        gallinaGrupo2.getChildren().add(gallinaG2);
        gallinaGrupo2.setLayoutX(pos1Gallina2);
        gallinaGrupo2.setLayoutY(600);
        root.getChildren().add(gallinaGrupo2);

        gallinaGrupo3 = new Group();
        gallinaGrupo3.getChildren().add(gallinaG3);
        gallinaGrupo3.setLayoutX(pos1Gallina3);
        gallinaGrupo3.setLayoutY(600);
        root.getChildren().add(gallinaGrupo3);

        gallinaGrupo4 = new Group();
        gallinaGrupo4.getChildren().add(gallinaG4);
        gallinaGrupo4.setLayoutX(pos1Gallina4);
        gallinaGrupo4.setLayoutY(600);
        root.getChildren().add(gallinaGrupo4);
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
       
       private void crearMovimientoGato(){


            gatoMovimiento = new Group();
            gatoMovimiento.getChildren().add(gatoCaminar);
            gatoMovimiento.getChildren().add(gatoCuerpo);
            gatoMovimiento.setLayoutX(gatoX); 
            gatoMovimiento.setLayoutY(gatoY);
            
            root.getChildren().add(gatoCuerpo);
            root.getChildren().add(gatoMovimiento);

            
     }   
       
       private void gallinasGrupo(){

        int min = 550;
        int max = 1100;
        
        gallinaGrupo1.setLayoutX(pos1Gallina1);
        pos1Gallina1+=velocidadG;

        if (pos1Gallina1 <= -110){
        int separacion = ThreadLocalRandom.current().nextInt(min, max);    
          pos1Gallina1= pos1Gallina4 + separacion;
        }      

        gallinaGrupo2.setLayoutX(pos1Gallina2);
        pos1Gallina2+=velocidadG;
        
        if (pos1Gallina2 <= -110){
           int separacion =ThreadLocalRandom.current().nextInt(min, max);
            pos1Gallina2= pos1Gallina1 + separacion;
        } 
        
        gallinaGrupo3.setLayoutX(pos1Gallina3);
        pos1Gallina3+=velocidadG;
        
        if (pos1Gallina3 <= -110){
           int separacion = ThreadLocalRandom.current().nextInt(min, max);
            pos1Gallina3= pos1Gallina2 + separacion;
        } 
        
        gallinaGrupo4.setLayoutX(pos1Gallina4);
        pos1Gallina4+=velocidadG;
        
        if (pos1Gallina4 <= -110){
           int separacion = ThreadLocalRandom.current().nextInt(min, max);
            pos1Gallina4= pos1Gallina1 + separacion;
        }
       }
  
  private void resetGame(){
      score = 0;
      textScore.setText(String.valueOf(score));
      

    posicionX= 1024;
    posicionY= 768;

    pos1Fondo= 0;
    pos2Fondo1= 1024;

    pos1FondoCamino= 0;
    pos2FondoCamino= 1024;

    velocidad= -1 ;
    velocidadCamino = -2;
    velocidadG=-4;


    //Gallina 1
    pos1Gallina1= ThreadLocalRandom.current().nextInt(1100, 1400); 
    //Gallina 2
    pos1Gallina2= ThreadLocalRandom.current().nextInt(1700, 2000);
    //Gallina 3
    pos1Gallina3= ThreadLocalRandom.current().nextInt(2300, 2600);
    //Gallina 4
    pos1Gallina4= ThreadLocalRandom.current().nextInt(2900, 3100);

//    gatoVel = 0;
    gatoY = 600;
    gatoX = 150; 
    gatoYsalto = 0;
//      Random random = new Random();
//      gallinaGrupo1.setLayoutX(900)= random.nextInt();
  }
  
  private void rectanguloGato() {
      gatoCuerpo.setY(gatoY);
      
  }
  public static void main(String[] args) {
         Application.launch(args);
     }
}

