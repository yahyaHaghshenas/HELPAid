package base;




public class GoodsDonation extends Contribution{
	private String description;
	private double estimatedValue;
	
	public GoodsDonation(Appeal appeal, String description,
			double estimatedVlue) {
		super(appeal);
		setDescription(description);
		setEstimatedValue(estimatedValue);
	}
	
	


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}





	public String toString() {
		return  super.toString() + " GoodsDonation description=" + description + ","
				+ " estimatedValue=" + estimatedValue;
	}
	
	
	
}
