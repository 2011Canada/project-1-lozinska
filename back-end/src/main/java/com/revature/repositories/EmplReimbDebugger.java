package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;

public class EmplReimbDebugger {
public static void main(String[]args) {
EmplReimbDAO rd=new EmplReimbPostgresDAO();
List<Reimbursement> r= rd.findAllByStatus(1);
for(Reimbursement reimb:r) {
	System.out.println(reimb.getReimbursementID()+" "+reimb.getReimbursementAmmount()+" "+reimb.getReimbursementAuthorId()+" "+reimb.getReimbursementStatusId());
}
}
}
