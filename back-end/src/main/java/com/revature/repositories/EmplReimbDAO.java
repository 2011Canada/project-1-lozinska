package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface EmplReimbDAO {
	
public Reimbursement createTicket(Reimbursement reimbTicket,int authorID, int typeID,int statusID);

public List<Reimbursement> findAllByUserID(int userID);

public List<Reimbursement> findAllByStatus(int statusID);

public List<Reimbursement> findAll();

public Reimbursement updateStatus(Reimbursement reimb, int statusID);


}
