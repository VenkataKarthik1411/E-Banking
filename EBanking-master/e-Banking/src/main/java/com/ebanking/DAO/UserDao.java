package com.ebanking.DAO;

import java.util.ArrayList;

import com.ebanking.model.BankStatement;
import com.ebanking.model.BankUserDetails;

public interface UserDao {
	
	boolean userRegistration(BankUserDetails bankUserDetails);
	BankUserDetails userLogin(String emailid,String password);
	boolean debitamount(BankStatement statementDr);
	boolean creditamount(BankStatement statementCr);
	boolean forgetPassword(String emailid,String newPassword);

}
