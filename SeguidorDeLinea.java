/* SeguidorDeLinea.java */

import lejos.nxt.*;

public class SeguidorDeLinea {
	public void run(){
		LightSensor l = new LightSensor(SensorPort.S1);
		boolean correr = true;
		while (correr){
		int f = l.readNormalizedValue();
		System.out.println(f);
		try{
			Thread.sleep (100);
		} catch(Exception e){
		}
		if (Button.ENTER.isDown()){
			correr = false;
		}
		}		
	}
		
	public static void main (String[] args) {
		new SeguidorDeLinea().run();
	}
}