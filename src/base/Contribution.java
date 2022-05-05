package base;


import java.time.*;

public abstract class Contribution {
	static int nextContributionID = 1000;
	private LocalDate receivedDate;
	private String contributionID;
	private Appeal appeal;

	public Contribution(Appeal appeal) {
		setReceivedDate(LocalDate.now());
		setContributionID("C" + nextContributionID++);
		setAppeal(appeal);
	}

	

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

public String getContributionID() {
	return contributionID;
}

public void setContributionID(String contributionID) {
	this.contributionID = contributionID;
}



public Appeal getAppeal() {
	return appeal;
}

public void setAppeal(Appeal appeal) {
	this.appeal = appeal;
}

@Override
public String toString() {
	return "Contribution ID: " + contributionID + " received: " +receivedDate 
			+ " Appeal ID: " + this.getAppeal().getAppealID();
			
}

}
