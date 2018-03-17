package by.htp.prediction.logic;

import java.util.Random;

import by.htp.prediction.bean.Chamomile;
import by.htp.prediction.bean.FortuneTeller;
import by.htp.prediction.bean.Prediction;

public class PredictionService {

	public void generatePredictions(FortuneTeller forteller) {

		Prediction pred1 = new Prediction();
		pred1.setTitle("Job");
		pred1.getAnswers().add("New job");
		pred1.getAnswers().add("Old job");
		pred1.getAnswers().add("Second job");

		Prediction pred2 = new Prediction();
		pred2.setTitle("Love");
		pred2.getAnswers().add("New love");
		pred2.getAnswers().add("Old love");

		Prediction pred3 = new Prediction();
		pred3.setTitle("Luck");
		pred3.getAnswers().add("Luck will come");
		pred3.getAnswers().add("Luck will not come");

		forteller.getPredSet().add(pred1);
		forteller.getPredSet().add(pred2);
		forteller.getPredSet().add(pred3);

	}

	public void getNewChamomiles(FortuneTeller forteller) {
		Random random = new Random();
		int chamCount = random.nextInt(5) + 5;
		for (int i = 0; i < chamCount; i++) {	
			Chamomile chamomile = new Chamomile();
			forteller.getChamList().add(chamomile);
		}
	}

	public void viewChamomilesList(FortuneTeller forteller) {
		System.out.println("Chamomiles List:");
		for (Chamomile chamomile : forteller.getChamList()) {
			System.out.println("[" + chamomile.getPetals().size() + "]");
		}
	}
}
