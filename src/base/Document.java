package base;



public class Document {
	static int nextDocumentID = 1000;
	private String documentID;
	private String fileName;
	private String description;
        
        public Document() {}
	
	public Document( String fileName, String description) {
		setDocumentID("D" + nextDocumentID++);
		setFileName(fileName);
		setDescription(description);
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Document documentID=" + documentID + ", fileName=" + fileName 
				+ ", description=" + description ;
	}
	
	
	
	
}
