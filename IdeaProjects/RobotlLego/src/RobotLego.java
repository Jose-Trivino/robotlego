import lejos.nxt.*;

public class RobotLego {

    //variables y objetos recurrentes
    static TouchSensor sensorTacto = new TouchSensor(SensorPort.S1);
    NXTRegulatedMotor MA = Motor.B; //rueda izquierda chequear qué rueda es cuál
    NXTRegulatedMotor MB = Motor.C; //rueda derecha
    LightSensor sensorLuz = new LightSensor(SensorPort.S2);
    int baseSpeed = 0; //velocidad crucero con que avanza el robot
    int delta = 0; //valor agregado a una rueda para que el robot avance ligeramente torcido

    public void linea(int distancia){ //avanza rotaciones en ángulos i.e 1 rot = 360
        MA.rotate(distancia, true);
        MB.rotate(distancia, true);
    }

    public void girarEnEje(int angulo){ //gira en su propio eje
        MA.rotate(angulo, true);
        MB.rotate(-angulo,true);
    }

    public void setearGiro(int valor){ //setear la velocidad de giro en el eje y comienza el movimiento
        MA.setSpeed(valor);
        MB.setSpeed(valor);
        MA.forward();
        MB.backward();
    }

    public void virarIzquierda(int angulo){ //movimiento curvo hacia la izquierd

        MB.rotate(angulo); //motor derecho avanza
    }

    public void virarDerecha(int angulo) { //movimiento curvo hacia la derecha
        MA.rotate(angulo) //motor izquierdo avanza
    }

    public int calibrar(){ //le asigna valores a blanco y negro
        Button.ENTER.waitForPress();
        int  blanco = sensorLuz.readValue(); //incluir el uso de botones
        Button.ENTER.waitForPress();
        int  negro = sensorLuz.readValue();
        return (blanco+negro)/2;
        //en volá apaña sacar el promedio y decir blanco <=> mayor al promedio, y lo correspondiente al negro
    }

    public void run() {
        Button.ENTER.waitForPress();
        int luz = sensorLuz.readValue();
        int promedio = calibrar();
        Button.ENTER.waitForPress();
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
            if (luz < promedio) //está más cerca del negro
                virarDerecha(60);
            else
                virarIzquierda(60); //está hacia lo blanco

            if (Button.ESCAPE.isDown()){
                System.out.println("Goodnight");
                System.exit(0); //termina el programa
            }
            luz = sensorLuz.readValue();
        } //hasta aqui sigue la linea
        linea(-40); //retrocede
        girarEnEje(160);
        setearGiro(50); //empieza a girar
        while(luz>promedio){
            luz=sensorLuz.readValue();
            if (Button.ESCAPE.isDown()) {
                System.out.println("Goodnight");
                System.exit(0); //termina el programa
            }
        }
        MA.stop();
        MB.stop();
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
            if (luz < promedio) //está más cerca del negro
                virarDerecha(60);
            else
                virarIzquierda(60); //está hacia lo blanco

            if (Button.ESCAPE.isDown()){
                System.out.println("Goodnight");
                System.exit(0); //termina el programa
            }
            luz = sensorLuz.readValue();
        }

    }

    public static void main (String [] args) {
        new RobotLego().run();
    }
}