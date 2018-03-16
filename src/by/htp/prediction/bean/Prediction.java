package by.htp.prediction.bean;

import java.util.ArrayList;
import java.util.List;

public class Prediction {

	private String title;
	private List<String> answers = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
}
