package base;


import java.time.*;
public class Disbursement {
	private LocalDate disbursementDate;
	private double cashAmount;
	private double goodsDisbursed;
	private Appeal appeal;
	private Applicant applicant;
	
	public Disbursement(LocalDate disbursementDate, double cashAmount, double goodsDisbursed
			, Applicant applicant) {
		setDisbursementDate(disbursementDate);
		setCashAmount(cashAmount);
		setGoodsDisbursed(goodsDisbursed);
		setApplicant(applicant);
	}

	public LocalDate getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(LocalDate disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public double getGoodsDisbursed() {
		return goodsDisbursed;
	}

	public void setGoodsDisbursed(double goodsDisbursed) {
		this.goodsDisbursed = goodsDisbursed;
	}
	
	

	public Appeal getAppeal() {
		return appeal;
	}

	public void setAppeal(Appeal appeal) {
		this.appeal = appeal;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Disbursement disbursementDate: " + disbursementDate + ", cashAmount: " + cashAmount
				+ ", goodsDisbursed: " + goodsDisbursed + " Appeal ID: " + this.getAppeal().getAppealID()
				+ "Applicant: " + this.getApplicant().getUserName();
	}
	
}
