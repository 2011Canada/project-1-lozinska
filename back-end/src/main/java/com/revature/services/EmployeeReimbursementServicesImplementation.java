package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.EmplReimbDAO;

public class EmployeeReimbursementServicesImplementation implements EmployeeReimbursementServices{
EmplReimbDAO ed;
public EmployeeReimbursementServicesImplementation(EmplReimbDAO ed) {
	this.ed=ed;
}
	@Override
	public Reimbursement createReimbursement(Reimbursement r, int authorID, int typeID, int statusID) {
		
		return ed.createTicket(r, authorID, typeID, statusID);
	}

	@Override
	public Reimbursement updateStatus(Reimbursement r, int statusID) {
		// TODO Auto-generated method stub
		return ed.updateStatus(r, statusID);
	}

	@Override
	public List<Reimbursement> findAllTickets() {
		// TODO Auto-generated method stub
		return ed.findAll();
	}

	@Override
	public List<Reimbursement> findTicketByStatus(int statusID) {
		// TODO Auto-generated method stub
		return ed.findAllByStatus(statusID);
	}

	@Override
	public List<Reimbursement> findTicketByUser(int userID) {
		// TODO Auto-generated method stub
		return ed.findAllByUserID(userID);
	}

}
