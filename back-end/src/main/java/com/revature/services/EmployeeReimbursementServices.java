package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface EmployeeReimbursementServices {

	public Reimbursement createReimbursement(Reimbursement r);
	public void updateStatus(int reimbursementID, int statusID);
	public List<Reimbursement> findAllTickets();
	public List<Reimbursement> findTicketByStatus(int statusID);
	public List<Reimbursement> findTicketByUser(int userID);
}
