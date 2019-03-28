import lejos.nxt.*;

public class SeguidorDeLinea{

    static TouchSensor sensorTacto = new TouchSensor(SensorPort.S2);
    NXTRegulatedMotor motorDerecho = Motor.B; //rueda derecha
    NXTRegulatedMotor motorIzquierdo = Motor.C; //rueda izquierda
    LightSensor sensorLuz = new LightSensor(SensorPort.S1);

    public void linea(int distancia){ //avanza rotaciones en ángulos i.e 1 rot = 360
        motorIzquierdo.rotate(distancia, true);
        motorDerecho.rotate(distancia, true);
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

    public void virarIzquierda(int angulo){ //movimiento curvo hacia la izquierd

        motorDerecho.rotate(angulo); //motor derecho avanza
    }

    public void virarDerecha(int angulo) {

        motorIzquierdo.rotate(angulo); //motor izquierdo avanza
    }

    public int calibrar(){ //le asigna valores a blanco y negro
		System.out.println("Posicione en blanco para detectar su valor");
        Button.ENTER.waitForPress(); //espera a presionar enter para calibrar
        int  blanco = sensorLuz.readValue();
		System.out.println("Valor medido para blanco :"+blanco+". Posicione sobre la banda negra para medir su valor");
        Button.ENTER.waitForPress();
        int  negro = sensorLuz.readValue();
		System.out.println("Valor medido para negro: "+negro);
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
		
        Button.ENTER.waitForPress();
        int luz = sensorLuz.readValue();
		int promedio = calibrar();
		//agregar delay
		System.out.println("Calibración efectuada, promedio: "+promedio+". Presione ENTER para empezar el recorrido.");
		
        Button.ENTER.waitForPress();
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
            if (luz < promedio) //está más cerca del negro
                virarDerecha(60);
            else
                virarIzquierda(60); //está hacia lo blanco
            luz = sensorLuz.readValue();
        } //hasta aqui sigue la linea

        linea(-40); //retrocede
        girarEnEje(160);
        setearGiro(50); //empieza a girar
        while (luz > promedio) {
            luz = sensorLuz.readValue();           }
            motorIzquierdo.stop();
            motorDerecho.stop();
            while (!sensorTacto.isPressed()) { //while el boton no está apretado
                if (luz < promedio) //está más cerca del negro
                    virarDerecha(60);
                else
                    virarIzquierda(60); //está hacia lo blanco
                luz = sensorLuz.readValue();
            }

        }


    public static void main(String[] args) {
        new SeguidorDeLinea().run();
    }
}
