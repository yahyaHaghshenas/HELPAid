package base;


import java.io.Serializable;
import java.util.*;
public class Applicant extends User  implements Serializable {
	static int nextApplicantID = 1000;
	private String IDNo;
	private String address;
	private double householdIncome;
	private Organization organization;
	private ArrayList<Document> documents;
	private  ArrayList<Disbursement> disbursements;
        
        public Applicant() {}
	
	public Applicant(String userName, String fullName, String email, 
			String mobileNo, String IDNo, String address, double householdIncome, 
			Organization organization) {
		super(userName, fullName, email, mobileNo);
		setIDNo(IDNo);
		setAddress(address);
		setHouseholdIncome(householdIncome);
		setOrganization(organization);
		setDocuments(new ArrayList<Document>());
		setDisbursements(new ArrayList<Disbursement>());

	}
	
	public Applicant(String fullname,
			String email, String mobileNo, String IDno, String address,
			double householdIncome, Organization organization) {
			this("AP" + nextApplicantID++, fullname, email, mobileNo, 
				IDno, address, householdIncome, organization);
                        this.setUserName(IDno);
		}
		

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String IDNo) {
		this.IDNo = IDNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getHouseholdIncome() {
		return householdIncome;
	}

	public void setHouseholdIncome(double householdIncome) {
		this.householdIncome = householdIncome;
	}
	
	
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public ArrayList<Disbursement> getDisbursements() {
		return disbursements;
	}

	public void setDisbursements(ArrayList<Disbursement> disbursements) {
		this.disbursements = disbursements;
	}

	
	public void addDocument(Document doc) {
		getDocuments().add(doc);
	}
	
	
	
	public void addDisbursement(Disbursement disb) {
		getDisbursements().add(disb);
	}
	
	public int numOfDisbursements() {
		return getDisbursements().size();
	}
	
	public String displayDocuments() {
		String dStr = "";
		for (Document d : documents) {
			dStr += "@@@" + d.toString() + "\n";
		}
		return dStr;
	}
	
	public String displayDisbursements() {
		String dbStr= "";
		for (Disbursement d : disbursements) {
			dbStr += d.toString() + "\n";
		}
		return dbStr;
	}

	public String toString() {
		String msg = super.toString() + ";ID No. ="+ IDNo + ", lives under address ="
				+ address + ", with household income = "+ householdIncome +", Documents"
				+ displayDocuments();
		if (numOfDisbursements() != 0)
			msg += ",  has received " + numOfDisbursements() + " disbursements.";
		return msg;
	}
}
