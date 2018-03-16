package by.htp.prediction.bean;

import java.util.ArrayList;
import java.util.List;

public class Chamomile {

	private int petalCount;
	private List<Petal> petals = new ArrayList<>();

	public int getPetalCount() {
		return petalCount;
	}

	public void setPetalCount(int petalCount) {
		this.petalCount = petalCount;
	}

	public List<Petal> getPetals() {
		return petals;
	}

	public void setPetals(List<Petal> petals) {
		this.petals = petals;
	}
}
