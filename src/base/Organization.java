package base;


import java.util.ArrayList;
import java.util.stream.Collectors;



public class Organization {
	static int nextOrganizationID = 1000;
	private String orgID;
	private String orgName;
	private String address;
	private ArrayList<Appeal> appeals;
	private ArrayList<OrganizationRep> reps;
	private ArrayList<Applicant> applicants;
	
	
	public Organization( String orgName, String address) {
		setOrgID("ORG" + nextOrganizationID++);
		setOrgName(orgName);
		setAddress(address);
		setReps(new ArrayList<>());
		setApplicants(new ArrayList<>());
		setAppeals(new ArrayList<>());
	}
	
	public static int getNextOrganizationID() {
		return nextOrganizationID;
	}

	
	public static void setNextOrganizationID(int nextOrganizationID) {
		Organization.nextOrganizationID = nextOrganizationID;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public ArrayList<Appeal> getAppeals() {
		return appeals;
	}

	public void setAppeals(ArrayList<Appeal> appeals) {
		this.appeals = appeals;
	}
	
	public ArrayList<OrganizationRep> getReps() {
		return reps;
	}

	
	public void setReps(ArrayList<OrganizationRep> reps) {
		this.reps = reps;
	}
	
	public ArrayList<Applicant> getApplicants() {
		return applicants;
	}

	
	public void setApplicants(ArrayList<Applicant> applicants) {
		this.applicants = applicants;
	}
	
	
	public String displayAppeals() {
		String apStr = "";
		for(Appeal a : appeals) {
			apStr += a.toString() + "\n";
		}
		return apStr;
	}
	
	public boolean add(OrganizationRep rep) {
		return getReps().add(rep);
	}
	
	public boolean add(Applicant applicant) {
		return getApplicants().add(applicant);
	}
	
	public boolean add(Appeal appeal) {
		return getAppeals().add(appeal);
	}
	
	public OrganizationRep findOrganizationRep(String username) {
		return getReps().stream()
			.filter(r -> username.equalsIgnoreCase(r.getUserName()))
			.findFirst()
			.orElse(null);		
	}

	public Applicant findApplicantByUsername(String username) {
		return getApplicants().stream()
			.filter(r -> username.equalsIgnoreCase(r.getUserName()))
			.findFirst()
			.orElse(null);		
	}

	public Applicant findApplicantByID(String IDno) {
		return getApplicants().stream()
			.filter(app -> IDno.equalsIgnoreCase(app.getIDNo()))
			.findFirst()
			.orElse(null);		
	}
	
	public Appeal findAppeal(String appealID) {
		return getAppeals().stream()
			.filter(a -> appealID.equalsIgnoreCase(a.getAppealID()))
			.findFirst()
			.orElse(null);
	}
	
	
	public String listCurrentAppeals() {
		return getAppeals().stream()
			.filter(Appeal::isCurrentAppeal)
			.map(Appeal::summaryOfAppeal) 
			.collect(Collectors.joining("\n"));
	}
	
	public String allApplicants() {
		return getApplicants().stream()
			.map(Applicant::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public int numOfAppeals() {
		return getAppeals().size();
	}
	
	public int numOfApplicants() {
		return getApplicants().size();
	}
	
	public int numOfOrganizationReps() {
		return getReps().size();
	}

	
	public String toString() {
		return "Organization orgID=" + orgID + ", orgName=" + orgName + ", address=" + address ;
	}
	
	
}
