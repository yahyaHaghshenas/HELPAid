package base;




import java.time.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Appeal {

	private String appealID;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String description;
	private String outcome;
	private Organization organization;
	private ArrayList<Contribution> contributions;
	private ArrayList<Disbursement> disbursements;
	static int nextAppealID = 1000;
	
	/**
	 * -----------------------------------------constructor
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public Appeal(LocalDate fromDarte, LocalDate toDate, 
			String description, Organization organization) {
		setAppealID("A" + nextAppealID++);
		setFromDate(fromDate);
		setToDate(toDate);
		setDescription(description);
		setOrganization(organization);
		setContributions(contributions);
		setDisbursements(disbursements);
		setOutcome("PENDING");
	}
	
	public Appeal() {
		this(null, null, null, null);
	}
	
	

	/**
	 * 
	 * setters and getters
	 */
	
	public static int getNextAppealID() {
		return nextAppealID;
	}

	
	public static void setNextAppealID(int nextAppealID) {
		Appeal.nextAppealID = nextAppealID;
	}
	
	public String getAppealID() {
		return appealID;
	}

	public void setAppealID(String appealID) {
		this.appealID = appealID;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public Organization getOrganization() {
		return organization;
	}

	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public ArrayList<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(ArrayList<Contribution> contributions) {
		this.contributions = contributions;
	}

	public ArrayList<Disbursement> getDisbursements() {
		return disbursements;
	}

	public void setDisbursements(ArrayList<Disbursement> disbursements) {
		this.disbursements = disbursements;
	}
	
	public String getOrganizationName() {
		return getOrganization().getOrgName();
	}
	/**
	 * 
	 * ---------------------add methods
	 */
	
	public boolean addNewDisbursement(Disbursement dis) {
            return disbursements != null ? disbursements.add(dis): false;
	}
	
	public boolean addNewContribution(Contribution con) {
            return contributions != null ? contributions.add(con): false;
	}
	
	/**
	 * ----------------------------------------------total methods
	 * @return
	 */
	public double totalContributions() {
		return getContributions().stream()
                        .filter(c -> c instanceof CashDonation)
                        .map(c -> (CashDonation) c)
                        .mapToDouble(CashDonation::getAmount)
                        .sum() +
                        getContributions().stream()
                                .filter(c -> c instanceof GoodsDonation)
                                .map(c -> (GoodsDonation) c)
                                .mapToDouble(GoodsDonation::getEstimatedValue)
                                .sum();
	}
	
	public double totalDisbursements() {
		return getDisbursements().stream()
				.mapToDouble(Disbursement::getCashAmount)
				.sum();
	}
	
	/**
	 * ---------------has methods
	 * @return
	 */
	public boolean hasContributions() {
            return contributions != null ? contributions.size() > 0 : false;
	}
	
	public boolean hasDisbursements() {
            return disbursements != null ? disbursements.size() > 0 : false;
	}
	
	
	/**
	 * -------------------------------display all
	 * @return
	 */
	
	public String allContributions() {
		return getContributions().stream()
			.map(Contribution::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public String allDisbursements() {
		return getDisbursements().stream()
			.map(Disbursement::toString)
			.collect(Collectors.joining("\n"));
	}
	
	/**
	 * --------------------------summary
	 */
	
	public String summaryOfAppeal() {
		return String.format("Appeal [%s] for %s, from %s to %s",
			getAppealID(), getDescription(), getFromDate(), getToDate());
	}
	
	
	
	/**
	 *  -------------------number of (counter)
	 */
	
	public int numOfContributions() {
            final ArrayList<Contribution> c = getContributions();
            return c != null ? c.size() : 0;
	}
	
	public int numOfDisbursements() {
            final ArrayList<Disbursement> d = getDisbursements();
            return d != null ? d.size() : 0;
	}
	
	public boolean isPastAppeal() {
		return getToDate().isBefore(LocalDate.now());
	}
	
	public boolean isCurrentAppeal() {
		return !isPastAppeal();
	}
	
	/*
	 * tostring method
	 */
	
	public String toString() {
		String msg = String.format("Appeal [%s] for %s from %s to %s, " +
			"with status [%s]", getAppealID(), getDescription(), 
			getFromDate(), getToDate(), getOutcome());
		if (hasContributions())
			msg += String.format("\n  has contributions, total %.2f",
				totalContributions());
		if (hasDisbursements())
			msg += String.format("\n  and has already disbursed %.2f",
				totalDisbursements());
		return msg;
	}
	
	
		
	
	
	
}
