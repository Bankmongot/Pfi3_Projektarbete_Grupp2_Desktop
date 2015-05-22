package se.mah.k3;

import java.util.HashMap;

public class FirebaseData {
	private String theme = "Circles";
	private String question = "-";
	private String creator = "-";
	private String date = "_";
	private HashMap<String, Integer> inData;
	
	//Temp shit
	private long Vote1;
	private long Vote2;
	private long Vote3;
	private long Vote4;
	
	private String alt1;
	private String alt2;
	private String alt3;
	private String alt4;
	
	

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

	public long getVote1() {
		return Vote1;
	}

	public void setVote1(long vote1) {
		Vote1 = vote1;
	}

	public long getVote2() {
		return Vote2;
	}

	public void setVote2(long vote2) {
		Vote2 = vote2;
	}

	public long getVote3() {
		return Vote3;
	}

	public void setVote3(long vote3) {
		Vote3 = vote3;
	}

	public long getVote4() {
		return Vote4;
	}

	public void setVote4(long vote4) {
		Vote4 = vote4;
	}

	public String getAlt1() {
		return alt1;
	}

	public void setAlt1(String alt1) {
		this.alt1 = alt1;
	}

	public String getAlt2() {
		return alt2;
	}

	public void setAlt2(String alt2) {
		this.alt2 = alt2;
	}

	public String getAlt3() {
		return alt3;
	}

	public void setAlt3(String alt3) {
		this.alt3 = alt3;
	}

	public String getAlt4() {
		return alt4;
	}

	public void setAlt4(String alt4) {
		this.alt4 = alt4;
	}

	
	
}
