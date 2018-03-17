package by.htp.prediction.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chamomile {

	private List<Petal> petals;

	public Chamomile() {
		super();
		this.petals = new ArrayList<>();
		generatePetals();
	}

	public List<Petal> getPetals() {
		return petals;
	}

	public void setPetals(List<Petal> petals) {
		this.petals = petals;
	}
	
	private void generatePetals() {
		Random random = new Random();
		int petalCount = random.nextInt(5) + 5;
		for (int i = 0; i < petalCount; i++) {
			Petal petal = new Petal();
			petal.setNumber(i + 1);
			this.petals.add(petal);
		}
	}

	@Override
	public String toString() {
		return "Chamomile [petals=" + petals + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((petals == null) ? 0 : petals.hashCode());
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
		Chamomile other = (Chamomile) obj;
		if (petals == null) {
			if (other.petals != null)
				return false;
		} else if (!petals.equals(other.petals))
			return false;
		return true;
	}
}
