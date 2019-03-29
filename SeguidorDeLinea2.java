import lejos.nxt.*;
//config ganadora= delta = 300, baseSpeed = 0
public class SeguidorDeLinea2 {

    //variables y objetos recurrentes
    static TouchSensor sensorTacto = new TouchSensor(SensorPort.S2);
    NXTRegulatedMotor motorDerecho = Motor.B; //rueda derecha
    NXTRegulatedMotor motorIzquierdo = Motor.C; //rueda izquierda
    LightSensor sensorLuz = new LightSensor(SensorPort.S1);
    int baseSpeed = 50; //velocidad crucero con que avanza el robot

    public void linea(int distancia){ //avanza rotaciones en ángulos i.e 1 rot = 360
        motorIzquierdo.rotate(distancia, true);
        motorDerecho.rotate(distancia);
    }

    public void girarEnEje(int angulo){ //gira en su propio eje
        motorIzquierdo.rotate(angulo, true);
        motorDerecho.rotate(-angulo,true);
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
		int promedio = calibrar();
		//agregar delay
		System.out.println("Calibracion efectuada, promedio: "+promedio+". Presione ENTER para empezar el recorrido.");
		
        Button.ENTER.waitForPress();
		int delta=0;
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
			delta=25*Math.abs(luz-promedio);
			motorDerecho.forward();
			motorIzquierdo.forward();
            if (luz <= promedio) //está más cerca del negro
                virarDerecha(delta);
				
            else
                virarIzquierda(delta); //está hacia lo blanco
			
            luz = sensorLuz.readValue();
        } //hasta aqui sigue la linea

        linea(-40); //retrocede
        girarEnEje(160);
        setearGiro(50); //empieza a girar
		
        while (luz > promedio) {
            luz = sensorLuz.readValue();           
            motorIzquierdo.stop();
            motorDerecho.stop();
		}
		while (!sensorTacto.isPressed()) { //while el boton no está apretado
		delta=30*Math.abs(luz-promedio);
		motorDerecho.forward();
		motorIzquierdo.forward();
		if (luz <= promedio) //está más cerca del negro
			virarDerecha(delta);
		else
			virarIzquierda(delta); //está hacia lo blanco
		luz = sensorLuz.readValue();
		}
	}
        

    public static void main (String [] args) {
        new SeguidorDeLinea2().run();
    }
}