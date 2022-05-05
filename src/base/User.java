package base;

import java.io.Serializable;



public abstract class User implements Comparable<User>, Serializable {
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String mobileNo;
	
	
	public User(String userName,  String fullName, 
			String email, String mobileNo) {
            setUserName(userName);
            setFullName(fullName);
            setEmail(email);
            setMobileNo(mobileNo);
            setPassword(getDefaultPassword());
	}
	
	public User() {
		setUserName("not set");
		setPassword("not set");
		setFullName("not set");
		setEmail("not set");
		setMobileNo("not set");
		
	}
	
	private String getDefaultPassword() {
		return "Welcome123" + getFullName().charAt(0);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return getUserName().equalsIgnoreCase(
				((User) obj).getUserName());
		}
		return false;
	}
	
	
	public int compareTo(User rhs) {

		return getFullName().compareToIgnoreCase(rhs.getFullName());
	}

	@Override
	public String toString() {
		return "User userName= " + userName + ", password= " + password + ", fullName= " 
				+ fullName + ", email=" + email+ ", mobileNo=" + mobileNo ;
	}
	
	

}
