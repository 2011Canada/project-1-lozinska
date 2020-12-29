package com.revature.models;

public class Reimbursement {
private int reimbursementID;
private double reimbursementAmmount;
private String reimbursementSubmitted;
private String reimbursementResolved;
private String reimbursementDescription;
private int reimbursementAuthorId;
private int reimbursementResolverId;
private int reimbursementStatusId;

public int getReimbursementStatusId() {
	return reimbursementStatusId;
}
public void setReimbursementStatusId(int reimbursementStatusId) {
	this.reimbursementStatusId = reimbursementStatusId;
}
public void setReimbursementAuthorId(int reimbursementAuthorId) {
	this.reimbursementAuthorId = reimbursementAuthorId;
}
public int getReimbursementID() {
	return reimbursementID;
}
public void setReimbursementID(int reimbursementID) {
	this.reimbursementID = reimbursementID;
}
public double getReimbursementAmmount() {
	return reimbursementAmmount;
}
public void setReimbursementAmmount(double reimbursementAmmount) {
	this.reimbursementAmmount = reimbursementAmmount;
}
public String getReimbursementSubmitted() {
	return reimbursementSubmitted;
}
public void setReimbursementSubmitted(String reimbursementSubmitted) {
	this.reimbursementSubmitted = reimbursementSubmitted;
}
public String getReimbursementResolved() {
	return reimbursementResolved;
}
public void setReimbursementResolved(String reimbursementResolved) {
	this.reimbursementResolved = reimbursementResolved;
}
public String getReimbursementDescription() {
	return reimbursementDescription;
}
public void setReimbursementDescription(String reimbursementDescription) {
	this.reimbursementDescription = reimbursementDescription;
}
public int getReimbursementAuthorId() {
	return reimbursementAuthorId;
}
public void setReimbursementAuthor(int reimbursementAuthorId) {
	this.reimbursementAuthorId = reimbursementAuthorId;
}
public int getReimbursementResolverId() {
	return reimbursementResolverId;
}
public void setReimbursementResolverId(int reimbursementResolverId) {
	this.reimbursementResolverId = reimbursementResolverId;
}
public Reimbursement(double reimbursementAmmount, String reimbursementSubmitted, String reimbursementResolved,
		String reimbursementDescription, int reimbursementAuthorId, int reimbursementResolverId,int reimbursementStatus) {
	super();
	this.reimbursementAmmount = reimbursementAmmount;
	this.reimbursementSubmitted = reimbursementSubmitted;
	this.reimbursementResolved = reimbursementResolved;
	this.reimbursementDescription = reimbursementDescription;
	this.reimbursementAuthorId = reimbursementAuthorId;
	this.reimbursementResolverId = reimbursementResolverId;
	this.reimbursementStatusId=reimbursementStatusId;
}
public Reimbursement() {
	super();
	// TODO Auto-generated constructor stub
}

}
