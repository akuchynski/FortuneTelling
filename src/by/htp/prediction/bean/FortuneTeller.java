package by.htp.prediction.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FortuneTeller {

	private String name;
	private boolean mood;
	private Set<Client> clientSet;
	private Set<Prediction> predSet;
	private List<Chamomile> chamList;

	public FortuneTeller() {
		super();
	}

	public FortuneTeller(String name) {
		super();
		this.name = name;
		this.clientSet = new LinkedHashSet<>();
		this.predSet = new LinkedHashSet<>();
		this.chamList = new ArrayList<>();
	}

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
	
	@Override
	public String toString() {
		return "FortuneTeller [name=" + name + ", mood=" + mood + ", clientSet=" + clientSet + ", predSet=" + predSet
				+ ", chamList=" + chamList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chamList == null) ? 0 : chamList.hashCode());
		result = prime * result + ((clientSet == null) ? 0 : clientSet.hashCode());
		result = prime * result + (mood ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((predSet == null) ? 0 : predSet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FortuneTeller other = (FortuneTeller) obj;
		if (chamList == null) {
			if (other.chamList != null)
				return false;
		} else if (!chamList.equals(other.chamList))
			return false;
		if (clientSet == null) {
			if (other.clientSet != null)
				return false;
		} else if (!clientSet.equals(other.clientSet))
			return false;
		if (mood != other.mood)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (predSet == null) {
			if (other.predSet != null)
				return false;
		} else if (!predSet.equals(other.predSet))
			return false;
		return true;
	}

	public void getPrediction(Client client) {
		if (isNoMood()) {
			System.out.println("No more chamomiles :(((");
		} else {
			if (checkLastDate(client)) {
				System.out.println(client.getName() + ": Ask a new question after 24h!");
				return;
			}
			getAnswer(client);
			clientSet.add(client);
		}
	}

	private boolean isNoMood() {
		if (chamList.isEmpty()) {
			mood = true;
		}
		return mood;
	}

	private boolean checkLastDate(Client client) {
		if (client.getDate() == null) {
			client.setDate(getCurrentTime());
		} else {
			long deltaTime = (getCurrentTime().getTime() - client.getDate().getTime()) / 86400000;
			if (deltaTime < 1) {
				return true;
			}
		}
		return false;
	}

	private void getAnswer(Client client) {
		Prediction prediction = findPrediction(client);
		if (prediction.getTitle() != null) {
			Chamomile chamomile = chamList.get(0);
			int answerNum = chamomile.getPetals().size() % prediction.getAnswers().size();
			if (answerNum == 0) {
				answerNum = prediction.getAnswers().size();
			}
			chamomile.getPetals().remove(0);
			System.out.println(client.getName() + ": " + prediction.getAnswers().get(answerNum-1));
			chamList.remove(0);
		} else {
			System.out.println(client.getName() + ": No answer for that question!");
		}
	}

	private Prediction findPrediction(Client client) {
		for (Prediction prediction : predSet) {
			if (prediction.getTitle().equals(client.getQuestion())) {
				return prediction;
			}
		}
		return new Prediction();
	}

	private Date getCurrentTime() {
		long curTime = System.currentTimeMillis();
		return new Date(curTime);
	}
}
