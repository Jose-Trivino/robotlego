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

    public void girarEnEjeHastaLinea(){

    }

    public void virarIzquierda(){ //movimiento curvo hacia la izquierda
        MA.setSpeed(baseSpeed);
        MB.setSpeed(baseSpeed+delta); //same for delta
        //¿MB es la rueda derecha?
    }

    public void virarDerecha() { //movimiento curvo hacia la derecha
        MA.setSpeed(baseSpeed + delta);
        MB.setSpeed(baseSpeed);
    }

    public int calibrar(){ //le asigna valores a blanco y negro
        int  blanco = sensorLuz.readValue();
        girarEnEje(20); //probar el ángulo
        int  negro = sensorLuz.readValue();
        girarEnEje(-20);
        return (blanco+negro)/2;
        //en volá apaña sacar el promedio y decir blanco <=> mayor al promedio, y lo correspondiente al negro
    }

    public void run() {
        calibrar();//detecta valores de blanco y negro (creo que habrá que darles rangos a los movs
        // porque el negro era como 36-40, quizás un +-10)
        int luz = sensorLuz.readValue();
        int promedio = calibrar();
        while (!sensorTacto.isPressed()) { //while el boton no está apretado
            if (luz < promedio) //está más cerca del negro
                virarIzquierda();
            else
                virarDerecha(); //está hacia lo blanco

            if (Button.ESCAPE.isDown()){
                System.out.println("Goodnight");
                System.exit(0); //termina el programa
            }
            luz = sensorLuz.readValue();
        }

        //rotarhastaestarenlalinea();
    }

    public static void main (String [] args) {
        new RobotLego().run();
    }
}
//quiero ver si se actualiza la volá remota