package base;

import java.time.*;

public class CashDonation extends Contribution{
	
	private double amount;
	private String paymentChannel;
	private String referenceNo;
	
	
	public CashDonation(Appeal appeal, double amount, String paymentChannel,
			String referenceNo) {
			super(appeal);
			setAmount(amount);
			setPaymentChannel(paymentChannel);
			setReferenceNo(referenceNo);
		}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getPaymentChannel() {
		return paymentChannel;
	}


	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}


	public String getReferenceNo() {
		return referenceNo;
	}


	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	
	public String toString() {
		return super.toString() + " with amount: RM"+ getAmount() + " psymentChannel: "+
				getPaymentChannel()+ " and reference No " + getReferenceNo();
	}
	
	
}
