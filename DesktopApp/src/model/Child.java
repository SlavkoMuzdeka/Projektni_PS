package model;


public class Child extends Person{
	
	private String fatherName;
	private String motherName;
	private String fatherPhoneNumber;
	private String motherPhoneNumber;
	private String height;
	private String weight;
	private String  selectionDate;
	private String idGroup;
	private MedicalClearance medicalClearance;
	private Note note;
	private Boolean isHere;
	private ArrivalAndDeparatureTime arrivalAndDeparatureTime;

	public Child(String name, String surname, String uid, String dateOfBirth, String id, Address address,
			String fatherName, String motherName, String fatherPhoneNumber, String motherPhoneNumber, String height,
			String weight, MedicalClearance medicalClearance, Note note) {
		super(name, surname, uid, dateOfBirth, id,address);
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.fatherPhoneNumber = fatherPhoneNumber;
		this.motherPhoneNumber = motherPhoneNumber;
		this.height = height;
		this.weight = weight;
		this.medicalClearance= medicalClearance;
		this.note = note;
	}
	
	public Child() {
		
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherPhoneNumber() {
		return fatherPhoneNumber;
	}

	public void setFatherPhoneNumber(String fatherPhoneNumber) {
		this.fatherPhoneNumber = fatherPhoneNumber;
	}

	public String getMotherPhoneNumber() {
		return motherPhoneNumber;
	}

	public void setMotherPhoneNumber(String motherPhoneNumber) {
		this.motherPhoneNumber = motherPhoneNumber;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSelectionDate() {
		return selectionDate;
	}

	public void setSelectionDate(String selectionDate) {
		this.selectionDate = selectionDate;
	}

	public String getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}

	public MedicalClearance getMedicalClearance() {
		return medicalClearance;
	}

	public void setMedicalClearance(MedicalClearance medicalClearance) {
		this.medicalClearance = medicalClearance;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Boolean getIsHere() {
		return isHere;
	}

	public void setIsHere(Boolean isHere) {
		this.isHere = isHere;
	}

	public ArrivalAndDeparatureTime getArrivalAndDeparatureTime() {
		return arrivalAndDeparatureTime;
	}

	public void setArrivalAndDeparatureTime(ArrivalAndDeparatureTime arrivalAndDeparatureTime) {
		this.arrivalAndDeparatureTime = arrivalAndDeparatureTime;
	}
	
	@Override
	public String toString() {
		return getName() + "  " + getSurname();
	}
	
}
