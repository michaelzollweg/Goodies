package at.fh.swenga.jpa.model;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
 
@Entity
@Table(name = "City")
 
public class CityModel implements java.io.Serializable {
 
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
 
	@Column(nullable = false, length = 30)
	private String cityName;
 
	@Column(nullable = false, length = 30)
	private String countryName;
	
	@Column(nullable = false, length = 30)
	private String stateName;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private DocumentModel document;
 
	@Version
	long version;
 
	public CityModel() {
	}
 
	public CityModel(String cityName, String countryName, String stateName) {
		super();
		this.cityName = cityName;
		this.countryName = countryName;
		this.stateName = stateName;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public DocumentModel getDocument() {
		return document;
	}
 
	public void setDocument(DocumentModel document) {
		this.document = document;
	}
 
 
 
}