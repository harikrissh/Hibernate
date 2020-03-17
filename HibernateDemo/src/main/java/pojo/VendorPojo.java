package pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Vendor2")
public class VendorPojo {
	
	@Id
	@GeneratedValue
	@Column(name="vendorid")
	int vId;
	
	@Column(name="vendorname", length=25, nullable=false)
	String vName;
	
	@Column(name="vendormail", length=50)
	String vMail;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=CustomerPojo.class, cascade=CascadeType.ALL)
	@JoinColumn(name="vendorid", referencedColumnName="vendorid")
	Set<CustomerPojo> cust;

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvMail() {
		return vMail;
	}

	public void setvMail(String vMail) {
		this.vMail = vMail;
	}

	public Set<CustomerPojo> getCust() {
		return cust;
	}

	public void setCust(Set<CustomerPojo> cust) {
		this.cust = cust;
	}
	
}
