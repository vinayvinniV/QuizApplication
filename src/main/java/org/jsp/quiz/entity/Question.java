package org.jsp.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String title;
	private String a;
	private String b;
	private String c;
	private String d;
	private String ans;
	@Enumerated(EnumType.STRING)
	private QuestionStatus status;
	

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(int id, String title, String a, String b, String c, String d, String ans, QuestionStatus status) {
		super();
		this.id = id;
		this.title = title;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.ans = ans;
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public QuestionStatus getStatus() {
		return status;
	}

	public void setStatus(QuestionStatus status) {
		this.status = status;
	}
	
	
	
	

	
	
	

}
