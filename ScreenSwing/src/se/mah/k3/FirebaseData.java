package se.mah.k3;

import java.util.ArrayList;
import java.util.HashMap;

public class FirebaseData {
	private String theme = "Circles";
	private String question = "-";
	private String creator = "-";
	private String date = "_";
	private HashMap<String, Integer> inData;
	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public HashMap<String, Integer> getInData() {
		return inData;
	}

	public void setInData(HashMap<String, Integer> inData) {
		this.inData = inData;
	}

	
	
}
