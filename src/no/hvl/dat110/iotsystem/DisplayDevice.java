package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

import static java.lang.Thread.sleep;

public class DisplayDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		System.out.println("Display starting ...");

		// TODO - START

		// create a client object and use it to

		Client client = new Client("display", Common.BROKERHOST, Common.BROKERPORT);

		client.connect();

		client.createTopic("temperature");

		client.subscribe("temperature");


		for (int i = 0; i < COUNT; i++) {
			client.receive();

			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		client.unsubscribe("temperature");

		client.disconnect();

		
		// TODO - END
		
		System.out.println("Display stopping ... ");

		
	}
}
