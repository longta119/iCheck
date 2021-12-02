package iCheck;

public class SpeedingPenalty {

	  static private int[] ExcessSpeed = { 0, 10, 20, 30, 45 };
	  static private int[] DemeritPoints = { 1, 3, 4, 5, 6 };
	  static private float[] Fine = { 360.0f, 481.0f, 599.0f, 1441.0f, 3762.0f };
	  static private boolean[] LicenceSuspension = { false, false, false, true, true }; // false is No, true is Yes
	  static int speed;

	  /**
	   * determines the array index for the speeding offence
	   *
	   * @param overSpeed - number of km/h over the speed limit
	   * @return the array index where overSpeed is found, return -1 if overSpeed is
	   *         not found
	   */
	  private static byte findPenaltyIndex(int overSpeed) {
	    byte index = -1;

	    if (overSpeed > 0) {
	      for (int i = ExcessSpeed.length - 1; i >= 0; i--) {
	        if (overSpeed > ExcessSpeed[i]) {
	         index = (byte) i;
	         break;
	        }
		  }
	    }
	    
		return index;
	  }
		  
	  /**
	   * determine the demerit point index for speeding offence
	   * @param overSpeed - number of km/h over the speed limit
	   * @return the demerit point index where overSpeed is found
	   */
	  public static int findDemeritPoint(int overSpeed) {
		int point = 0;
			
	    for (int i = 0; i <= DemeritPoints.length - 1; i++) {
	      if(findPenaltyIndex(overSpeed) == i) {
	        point = DemeritPoints[i];
	        break;
	      }
	    }
	    
	    return point;
	  }
		  
	  /**
	   * determine the fine index for speeding offence
	   * @param overSpeed - number of km/h over the speed limit
	   * @return the fine index where overSpeed is found
	   */
	  public static float findFine(int overSpeed) {
	    float fine = 0f;
		    
	    for (int i = 0; i <= Fine.length; i++) {
	      if(findPenaltyIndex(overSpeed) == i) {
	        fine = Fine[i];
	        break;
	      }
	    }
	    
	    return fine;
	  }
		  
	  /**
	   * determine whether the driver's licence is still valid or not
	   * @param overSpeed - number of km/h over the speed limit
	   * @return the licence status - true if the licence is suspended; false if not
	   */
	  public static boolean licenceSuspended(int overSpeed) {
		boolean status = false;
			
	    for (int i = 0; i <= LicenceSuspension.length; i++) {
	      if(findPenaltyIndex(overSpeed) == i) {
	    	status = LicenceSuspension[i];
	    	break;
	      }
	    }
		    
	    if(status)
	      return true;
	    else
	      return false;
	  }
		  
	  /**
	   * sets the driver's over spped
	   * @param spd - number of km/h over the speed limit
	   */
	  public void setSpeed(int spd) {
	    speed = spd;
	  }
		  
	  /**
	   * @return the driver's over speed
	   */
	  public int getSpeed() {
	    return speed;
	  }

}
