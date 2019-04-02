import lejos.nxt.*;
import lejos.util.Delay;
//config ganadora= delta = 300, baseSpeed = 0
public class SeguidorDeLinea2{

    //variables y objetos recurrentes
    static TouchSensor sensorTacto = new TouchSensor(SensorPort.S2);
    NXTRegulatedMotor motorDerecho = Motor.B; //rueda derecha
    NXTRegulatedMotor motorIzquierdo = Motor.C; //rueda izquierda
    LightSensor sensorLuz = new LightSensor(SensorPort.S1);
    int baseSpeed = 0; //velocidad crucero con que avanza el robot

    public void linea(int distancia){ //avanza rotaciones en ángulos i.e 1 rot = 360
        motorIzquierdo.rotate(distancia, true);
        motorDerecho.rotate(distancia);
    }
	

    public void girarEnEje(int angulo){ //gira en su propio eje
        motorIzquierdo.rotate(-angulo, true);
        motorDerecho.rotate(angulo);
    }
	public void setearVelocidad(int velocidad){
		motorDerecho.setSpeed(velocidad);
		motorIzquierdo.setSpeed(velocidad);
	}
    public void setearGiro(int valor){ //setear la velocidad de giro en el eje y comienza el movimiento
        motorIzquierdo.setSpeed(valor);
        motorDerecho.setSpeed(valor);
        motorIzquierdo.forward();
        motorDerecho.backward();
    }

    public void virarIzquierda(int delta){ //movimiento curvo hacia la izquierda
        motorIzquierdo.setSpeed(baseSpeed);
        motorDerecho.setSpeed(baseSpeed+delta);
    }

    public void virarDerecha(int delta) { //movimiento curvo hacia la derecha
        motorIzquierdo.setSpeed(baseSpeed + delta);
        motorDerecho.setSpeed(baseSpeed);
    }

    public int calibrar(){ //le asigna valores a blanco y negro
        System.out.println("Posicione en blanco para medir");
        Button.ENTER.waitForPress(); //espera a presionar enter para calibrar
        int  blanco = sensorLuz.readValue();
        System.out.println("Valor blanco :"+blanco+". Posicione sobre banda negra para medir");
        Button.ENTER.waitForPress();
        int  negro = sensorLuz.readValue();
        System.out.println("Valor negro: "+negro);
        return (blanco+negro)/2;
    }
	public void musica(){
		Sound.setVolume(100);
		  Sound.playTone(523,70);  // play tone according to light sensor readings
		  Delay.msDelay(170);                                        // wait 200 milliseconds before checking again
		  Sound.playTone(523,70);  // play tone according to light sensor readings
		  Delay.msDelay(170);  
		  Sound.playTone(523,70);  // play tone according to light sensor readings
		  Delay.msDelay(170);  
		  Sound.playTone(523,70);  // play tone according to light sensor readings
		  Delay.msDelay(500);  
		  Sound.playTone(415,70);  // play tone according to light sensor readings
		  Delay.msDelay(500);  
		  Sound.playTone(466,70);  // play tone according to light sensor readings
		  Delay.msDelay(500);  
		  Sound.playTone(523,70);  // play tone according to light sensor readings
		  Delay.msDelay(400);  
		  Sound.playTone(466,70);  // play tone according to light sensor readings
		  Delay.msDelay(170);  
		  Sound.playTone(523,70);  // play tone according to light sensor readings
		  Delay.msDelay(200);  
	}

    public void run() {
        Button.ESCAPE.addButtonListener(new ButtonListener() {  //listener de botón para detectar cuándo se
            //presiona el botón ESCAPE
            @Override
            public void buttonPressed(Button b) {
                System.exit(0); //termina el programa cuando ESCAPE es presionado
            }

            @Override
            public void buttonReleased(Button b) {
            }
        });
		
        System.out.println("Presione ENTER para comenzar.");
        Button.ENTER.waitForPress();
        int luz = sensorLuz.readValue();
        int promedio = calibrar()+2;
        //agregar delay
        System.out.println("Calibracion efectuada, promedio: "+promedio+". Presione ENTER para empezar el recorrido.");

        Button.ENTER.waitForPress();
        int delta=300;
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
            motorDerecho.forward();
            motorIzquierdo.forward();
            if (luz <= promedio) //está más cerca del negro
                virarIzquierda(delta);
                //hacer la velocidad basevariable cuando la dif es muy chica, pq avanza lento cuando se queda en línea recta final
            else
                virarDerecha(delta); //está hacia lo blanco

            luz = sensorLuz.readValue();
        } //hasta aqui sigue la linea
		motorDerecho.stop();
		motorIzquierdo.stop();
		setearVelocidad(500);
		linea(-150);
        girarEnEje(300);
		
        virarIzquierda(delta);
		
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
		motorDerecho.forward();
        motorIzquierdo.forward();
            if (luz <= promedio) //está más cerca del negro
                virarDerecha(delta);
            else
                virarIzquierda(delta); //está hacia lo blanco
			
            luz = sensorLuz.readValue();
        }
		
		motorDerecho.stop();
		motorIzquierdo.stop();
		Delay.msDelay(100);
		musica();
		
    }


    public static void main (String [] args) {
        new SeguidorDeLinea2().run();
    }
}