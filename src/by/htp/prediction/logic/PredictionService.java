package by.htp.prediction.logic;

import java.util.Random;

import by.htp.prediction.bean.Chamomile;
import by.htp.prediction.bean.FortuneTeller;
import by.htp.prediction.bean.Petal;
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
		int n = random.nextInt(5) + 5;
		for (int i = 0; i < n; i++) {
			int petalCount = random.nextInt(5) + 5;
			forteller.getChamList().add(getOneChamomile(petalCount));
		}
	}

	public Chamomile getOneChamomile(int petalCount) {
		Chamomile chamomile = new Chamomile();
		for (int i = 0; i < petalCount; i++) {
			Petal petal = new Petal();
			petal.setNumber(i + 1);
			chamomile.getPetals().add(petal);
		}
		chamomile.setPetalCount(chamomile.getPetals().size());
		return chamomile;
	}

	public void viewChamomilesList(FortuneTeller fortel) {
		System.out.println("Chamomiles List:");
		for (Chamomile chamomile : fortel.getChamList()) {
			System.out.println("[" + chamomile.getPetals().size() + "]");
		}
	}
}
