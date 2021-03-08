package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

import static java.lang.Thread.sleep;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to

		Client client = new Client("temp sensor", Common.BROKERHOST, Common.BROKERPORT);

		client.connect();

		for(int i = 0; i < COUNT; i++){
			client.publish("temperature", String.valueOf(sn.read()));

			try{
				sleep(2000);

			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}

		client.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");


	}
}
