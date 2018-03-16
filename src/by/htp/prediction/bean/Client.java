package by.htp.prediction.bean;

import java.util.Date;

public class Client {

	private String name;
	private String question;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client(String name, String question) {
		super();
		this.name = name;
		this.question = question;
	}
}
