package by.htp.prediction.runner;

import by.htp.prediction.bean.Client;
import by.htp.prediction.bean.FortuneTeller;
import by.htp.prediction.logic.PredictionService;

public class MainApp {

	public static void main(String[] args) {

		PredictionService service = new PredictionService();
		FortuneTeller forteller = new FortuneTeller("Rosanna");

		service.generatePredictions(forteller);
		service.getNewChamomiles(forteller);
		service.viewChamomilesList(forteller);

		Client client1 = new Client("Peter", "Job");
		Client client2 = new Client("Marie", "Love");
		Client client3 = new Client("Steven", "Car");
		Client client4 = new Client("Alexander", "Luck");

		forteller.getPrediction(client1);
		forteller.getPrediction(client2);
		forteller.getPrediction(client3);
		forteller.getPrediction(client4);
		forteller.getPrediction(client1);
		
		service.viewChamomilesList(forteller);

	}
}
