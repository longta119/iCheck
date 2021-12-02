package iCheck;

public class Driver {

	  private String licenceNo;				// the driver's licence number
	  private String licenceClass;			// the driver's licence class 
	  private String firstName;				// the driver's first name
	  private String lastName;				// the driver's last name
	  private String address;				// the driver's home address
	  private String suburb;				// the driver's home 
	  private String postcode;				// the driver's home address post code
	  private int demeritPoint;				// the driver's licence demerit point
	  private String licenceStatus;			// the driver's licence status
		  
	  /**
	   * sets the driver's licence number
	   * @param licNo The driver's licence number
	   */
	  public void setLicenceNo(String licNo) {
	    licenceNo = licNo;
	  }
		  
	  /**
	   * sets the driver's licence class
	   * @param licClass The driver's licence class
	   */
	  public void setLicenceClass(String licClass) {
	    licenceClass = licClass;
	   }
		  
	  /**
	   * sets the driver's first name
	   * @param fName The driver's first name
	   */
	  public void setFirstName(String fName) {
	    firstName = fName;
	  }
		  
	  /**
	   * sets the driver's last name
	   * @param lName The driver's last name
	   */
	  public void setLastName(String lName) {
	    lastName = lName;
	  }
		  
	  /**
	   * sets the driver's home address
	   * @param add The driver's home address
	   */
	  public void setAddress(String add) {
	    address = add;
	  }
		  
	  /**
	   * sets the driver's home address suburb
	   * @param sub The driver's home address suburb
	   */
	  public void setSuburb(String sub) {
	    suburb = sub;
	  }
		  
	  /**
	   * sets the driver's home address post code
	   * @param code The driver's home address post code
	   */
	  public void setPostCode(String code) {
	    postcode = code;
	  }
		  
	  /**
	   * sets the driver's licence demerit points
	   * @param points The driver's licence demerit points
	   */
	  public void setDemeritPoint(int points) {
	    demeritPoint = points;
	  }
		  
	  /**
	   * sets the driver's licence status
	   * @param licStt The driver's licence status
	   */
	  public void setLicenceStatus(String licStt) {
	    licenceStatus = licStt;
	  }
		  
	  /**
	   * @return The driver's licence number
	   */
	  public String getLicenceNo() {
	    return licenceNo;
	  }
		  
	  /**
	   * @return The driver's licence class
	   */
	  public String getLicenceClass() {
		return licenceClass;
	  }
		  
	  /**
	   * @return The driver's first name
	   */
	  public String getFirstName() {
	    return firstName;
	  }
		  
	  /**
	   * @return The driver's last name
	   */
	  public String getLastName() {
	    return lastName;
	  }
		  
	  /**
	   * @return The driver's home address
	   */
	  public String getAddress() {
		return address;
	  }
		  
	  /**
	   * @return The driver's home address suburb
	   */
	  public String getSuburb() {
		return suburb;
	  }
		  
	  /**
	   * @return The driver's home address post code
	   */
	  public String getPostCode() {
	    return postcode;
	  }
		  
	  /**
	   * @return The driver's licence demerit points
	   */
	  public int getDemeritPoint() {
		return demeritPoint;
	  }
		  
	  /**
	   * @return The driver's licence status
	   */
	  public String getLicenceStatus() {
		return licenceStatus;
	  }
	  
}
