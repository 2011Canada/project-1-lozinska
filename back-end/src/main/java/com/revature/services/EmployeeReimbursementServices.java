package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface EmployeeReimbursementServices {

	public Reimbursement createReimbursement(Reimbursement r, int authorID, int statusID, int typeID);
	public Reimbursement updateStatus(Reimbursement r, int statusID);
	public List<Reimbursement> findAllTickets();
	public List<Reimbursement> findTicketByStatus(int statusID);
	public List<Reimbursement> findTicketByUser(int userID);
}
