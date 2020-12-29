package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class EmplReimbPostgresDAO implements EmplReimbDAO{
private ConnectionFactory cf=ConnectionFactory.getConnectionFactory();

	@Override
	public Reimbursement createTicket(Reimbursement reimbTicket, int authorID, int typeID, int statusID) {
		Connection conn=cf.getConnection();
		try {
			conn.setAutoCommit(false);
			
			String sql="insert into ers_reimbursement (reimb_amount,reimb_submitted,reimb_description, reimb_author,reimb_status_id,reimb_type_id) values(?,?,?,?,?,?) returning reimb_id;";
		
			PreparedStatement insertTicket=conn.prepareStatement(sql);
		    insertTicket.setDouble(1,reimbTicket.getReimbursementAmmount());
		    insertTicket.setTimestamp(2,Timestamp.valueOf(reimbTicket.getReimbursementSubmitted()));
		    insertTicket.setString(3,reimbTicket.getReimbursementDescription());
		    insertTicket.setInt(4,authorID);
		    insertTicket.setInt(5, statusID);
		    insertTicket.setInt(6, typeID);
		
		    ResultSet res=insertTicket.executeQuery();
		    int reimbID;
		    if(res.next()) {
		    	reimbID=res.getInt("reimb_id");
		    }else {
		    	throw new SQLException();
		    }
		    reimbTicket.setReimbursementID(reimbID);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cf.releaseConnection(conn);
		}
		
		
		return reimbTicket;
	}

	@Override
	public List<Reimbursement> findAllByUserID(int userID) {
		Connection conn=this.cf.getConnection();
		List<Reimbursement> allReimb=new ArrayList<Reimbursement>();
		try {
		String sql="select * from ers_reimbursement where reimb_author=?;";
			PreparedStatement reimbSql=conn.prepareStatement(sql);
			reimbSql.setInt(1, userID);
			ResultSet res=reimbSql.executeQuery();
			
			while(res.next()) {
				Reimbursement r=new Reimbursement();
				r.setReimbursementID(res.getInt("reimb_id"));
				r.setReimbursementStatusId(res.getInt("reimb_status_id"));
				r.setReimbursementAuthor(userID);
				r.setReimbursementAmmount(res.getDouble("reimb_amount"));
				r.setReimbursementDescription(res.getString("reimb_description"));
				r.setReimbursementResolverId(res.getInt("reimb_resolver"));
				r.setReimbursementSubmitted(res.getTimestamp("reimb_submitted").toString());
				r.setReimbursementResolved(res.getTimestamp("reimb_resolved").toString());
				allReimb.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		
		return allReimb;
	}

	@Override
	public List<Reimbursement> findAllByStatus(int statusID) {
		Connection conn=this.cf.getConnection();
		List<Reimbursement> allReimb=new ArrayList<Reimbursement>();
		try {
		String sql="select * from ers_reimbursement where reimb_status_id=?;";
		
		PreparedStatement statusSql=conn.prepareStatement(sql);
		statusSql.setInt(1, statusID);
		ResultSet res=statusSql.executeQuery();
		while(res.next()) {
			Reimbursement r=new Reimbursement();
			r.setReimbursementID(res.getInt("reimb_id"));
			r.setReimbursementStatusId(statusID);
			r.setReimbursementAmmount(res.getDouble("reimb_amount"));
			r.setReimbursementAuthor(res.getInt("reimb_author"));
			r.setReimbursementDescription(res.getString("reimb_description"));
			r.setReimbursementSubmitted(res.getTimestamp("reimb_submitted").toString());
			r.setReimbursementResolved(res.getTimestamp("reimb_resolved").toString());
			allReimb.add(r);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		
		return allReimb;
	}

	@Override
	public List<Reimbursement> findAll() {
		Connection conn=this.cf.getConnection();
		List<Reimbursement>allReimb=new ArrayList<Reimbursement>();
		try {
		String sql="select * from ers_reimbursement;";
			Statement s=conn.createStatement();
			ResultSet res=s.executeQuery(sql);
			
			while(res.next()) {
				Reimbursement r=new Reimbursement();
				r.setReimbursementStatusId(res.getInt("reimb_status_id"));
				r.setReimbursementID(res.getInt("reimb_id"));
				r.setReimbursementAmmount(res.getDouble("reimb_amount"));
				r.setReimbursementAuthor(res.getInt("reimb_author"));
				r.setReimbursementDescription(res.getString("reimb_description"));
				r.setReimbursementResolved(res.getTimestamp("reimb_resolved").toString());
				r.setReimbursementResolverId(res.getInt("reimb_resolver"));
				r.setReimbursementSubmitted(res.getTimestamp("reimb_submitted").toString());
				allReimb.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cf.releaseConnection(conn);
		}
		
		return allReimb;
		
	}

	@Override
	public Reimbursement updateStatus(Reimbursement reimb, int statusID) {
		Connection conn=this.cf.getConnection();
		try {
			conn.setAutoCommit(false);
		String sql="update ers_reimbursement set reimb_status_id=? where reimb_author=?;";
	
			PreparedStatement updateStatus=conn.prepareStatement(sql);
			updateStatus.setInt(1,statusID);
			updateStatus.setInt(2, reimb.getReimbursementAuthorId());
			updateStatus.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cf.releaseConnection(conn);
		}
		
		return reimb;
	}

}
