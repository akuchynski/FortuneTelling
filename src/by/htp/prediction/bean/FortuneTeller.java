package by.htp.prediction.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FortuneTeller {

	private String name;
	private boolean mood;
	private Set<Client> clientSet = new LinkedHashSet<>();
	private Set<Prediction> predSet = new LinkedHashSet<>();
	private List<Chamomile> chamList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMood() {
		return mood;
	}

	public void setMood(boolean mood) {
		this.mood = mood;
	}

	public Set<Client> getClientSet() {
		return clientSet;
	}

	public void setClientSet(Set<Client> clientSet) {
		this.clientSet = clientSet;
	}

	public Set<Prediction> getPredSet() {
		return predSet;
	}

	public void setDivSet(Set<Prediction> predSet) {
		this.predSet = predSet;
	}

	public List<Chamomile> getChamList() {
		return chamList;
	}

	public void setChamList(List<Chamomile> chamList) {
		this.chamList = chamList;
	}

	public FortuneTeller() {
		super();
	}

	public FortuneTeller(String name) {
		super();
		this.name = name;
	}

	public void getPrediction(Client client) {

		if (isNoMood()) {
			System.out.println("No more chamomiles :(((");
			return;
		}
		
		if(client.getDate() != null){
			Date curTime = getCurrentTime();
			long deltaTime = (curTime.getTime() - client.getDate().getTime())/1000;
			if(deltaTime < 24){
				System.out.println(client.getName() + ": ask a new question after " + (24-deltaTime) + " hours!");
				return;
			}
		}
		
		
		Prediction prediction = findPrediction(client);

		if (prediction != null) {
			Chamomile chamomile = chamList.get(0);
			int k = -1;
			for (int i = 0; i < chamomile.getPetalCount(); i++) {
				if (k < prediction.getAnswers().size() - 1) {
					k++;
				} else {
					k = 0;
				}
				chamomile.getPetals().remove(0);
			}

			client.setDate(getCurrentTime());
			clientSet.add(client);
			System.out.println(client.getName() + ": " + prediction.getAnswers().get(k));
			
			chamList.remove(0);

		} else {
			
			client.setDate(getCurrentTime());
			clientSet.add(client);
			System.out.println(client.getName() + ": No answer for that question!");
			
		}
	}

	public Prediction findPrediction(Client client) {
		for (Prediction prediction : predSet) {
			if (prediction.getTitle().equals(client.getQuestion())) {
				return prediction;
			}
		}
		return null;
	}

	public boolean isNoMood() {
		if (chamList.isEmpty()) {
			mood = true;
		} else {
			mood = false;
		}
		return mood;
	}
	
	public Date getCurrentTime() {
		long curTime = System.currentTimeMillis();
		return new Date(curTime);
	}
}
