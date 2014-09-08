package eHealth;

	public class Diagnosis {
		public int id;
		public String doctorid;
		public String patientid;
		public String patientname;
		public String diagnosis;
		public String notes;
	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDoctorid() {
			return doctorid;
		}
		public void setDoctorid(String doctorid) {
			this.doctorid = doctorid;
		}
		public String getPatientid() {
			return patientid;
		}
		public void setPatientid(String patientid) {
			this.patientid = patientid;
		}
		public String getPatientname() {
			return patientname;
		}
		public void setPatientname(String patientname) {
			this.patientname = patientname;
			
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
	
}
