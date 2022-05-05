package base;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


public class HelpAid {
	private ArrayList<Organization> organizations;
	private ArrayList<Appeal> appeals;
	private ArrayList<User> users;

	
	

	
	public HelpAid() {
		
		setOrganizations(new ArrayList<>());
		setAppeals(new ArrayList<>());
		setUsers( new ArrayList<>());
		
	}
	
	
	

	public ArrayList<Organization> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(ArrayList<Organization> organization) {
		this.organizations = organization;
	}
	public ArrayList<Appeal> getAppeals() {
		return appeals;
	}
	public void setAppeals(ArrayList<Appeal> appeal) {
		this.appeals = appeal;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	} 

	
	/**
	 * -------------------------------------add methods
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
            return users.add(user);
	}
	
	public boolean addOrganization(Organization organization) {
            return getOrganizations().add(organization);
	}
	
	public boolean addAppeal(Appeal appeal) {
            return getAppeals().add(appeal);
	}
	
	
	/**
	 * -------------------------------------------------------finds
	 */
	/**
	 * ----------------------find user
	 */
	public User findUser(String userName) {
		return getUsers().stream()
				.filter(u -> userName.equalsIgnoreCase(u.getUserName()))
				.findFirst()
				.orElse(null);
	}
	
	public Applicant findApplicantID(String userID) {
		Applicant found = null;
		for(int i = 0; i < getUsers().size(); i++) {
			User u = getUsers().get(i);
			if(u instanceof Applicant) {
				if(((Applicant) u).getIDNo().equals(userID))
					found = (Applicant) u;
			}
		}
		return found;
	}
	
	public Organization findOrg(String orgID) {
		return getOrganizations().stream()
			.filter(o -> orgID.equalsIgnoreCase(o.getOrgID()))
			.findFirst()
			.orElse(null);
	}
	
	public Appeal findAppeal(String appealID) {
		return getAppeals().stream()
				.filter(a -> appealID.equalsIgnoreCase(a.getAppealID()))
				.findFirst()
				.orElse(null);
	}
	
	
	
	/**
	 * ------------------------------toString methods
	 * @return
	 */
	
	public String organizationsToString() {
		return getOrganizations().stream()
				.map(Organization::toString)
				.collect(Collectors.joining("\n"));
	}
	
	public String appealsToString() {
		return getAppeals().stream()
				.map(Appeal::toString)
				.collect(Collectors.joining("\n"));
	}
	
	public String usersToString() {
		return getUsers().stream()
				.map(User::toString)
				.collect(Collectors.joining("\n"));
	}
	
	public String listUsersSortedByFullname() {
		return getUsers().stream()
			.sorted()
			.map(User::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public String listSortedAppeals() {
		return getAppeals().stream()
			.sorted(Comparator.comparing(
				Appeal::getOrganizationName)
				.thenComparing(Appeal::getFromDate))
			.map(Appeal::toString)
			.collect(Collectors.joining("\n"));
	}
	
	public int numOfUsers() {
		return getUsers().size();
	}
	
	public int numOfAppeals() {
		return getAppeals().size();
	}
	
	public int numOfOrganizations() {
		return getOrganizations().size();
	}
	
	public ArrayList<Appeal> currentAppealList() {
		return (ArrayList<Appeal>) getAppeals().stream()
			.filter(Appeal::isCurrentAppeal)
			.collect(Collectors.toList());
	}

	public ArrayList<Appeal> pastAppealList() {
		return (ArrayList<Appeal>) getAppeals().stream()
			.filter(Appeal::isPastAppeal)
			.collect(Collectors.toList());
	}
	
	public boolean duplicateApplicant(String IDno) {
		Applicant app = getUsers().stream()
			.filter(Applicant.class::isInstance)
			.map(a -> (Applicant) a)
			.filter(a -> a.getIDNo().equalsIgnoreCase(IDno))
			.findAny()
			.orElse(null);
		return app != null; 
	}
	
}
