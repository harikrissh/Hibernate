package pojo;

import javax.persistence.*;

@Entity
@Table(name="Phone")
public class PhoneUsingAnnotation {
	
	@Id
	@GeneratedValue //auto increment
	@Column(name = "PhoneID")
	int phoneId;
	
	@Column(name = "PhoneName")
	String phoneName;
	
	@Column(name = "RAM")
	String ramSize;
	
	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	
}
