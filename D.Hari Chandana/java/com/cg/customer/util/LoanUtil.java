package com.cg.customer.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.cg.customer.dto.LoanDetails;
import com.cg.customer.entity.LoanApplication;

@Component
public class LoanUtil {

	public LoanDetails toDetails(LoanApplication loan) {
		return new LoanDetails(loan.getApplicationid(), loan.getDate(), loan.getLoanAppliedAmount(), loan.getLoanApprovedAmount(),
				loan.isLandVerificationApproval(), loan.isFinanceVerificationApproval(), loan.isAdminApproval(), loan.getStatus(), loan.getId());
	}

	public List<LoanDetails> toDetails(List<LoanApplication> loans) {
		List<LoanDetails> loanList = new ArrayList<>();
		for (LoanApplication loan : loans) {
			LoanDetails details = toDetails(loan);
			loanList.add(details);
		}
		return loanList;
	}

}
