/**@author Oussama el aallali
 * 
 *
 */
public class runWays
{
   private int minForToLand; // minutes  to land 
   private int minForToTakeoff;//minutes  to depart 
   // minutes  until this run way is not busy 
   private int TimeLeft; // 
 
                      
   /**
   * Initialize a runway.
   * @param l , t   landint time , takeoff time
   *   
   **/
   public runWays(int l, int t)
   {
	   minForToLand= l; 
	   minForToTakeoff = t;
	   TimeLeft =0;
	    
   }


   /**
   * Determine whether the runway is  busy.
   * @return
   *   true if this runway is busy ;
   *   otherwise return false
   **/   
   public boolean isBusy( )
   {
      return (TimeLeft > 0);
   }
   
   

   /**
   * Reduce the remaining time in the by one minute.
   **/
   public void reduceRemainingTime( )
   {
      if (TimeLeft > 0)
    	  TimeLeft--;
   } 
   
  

   /**
   * Start a landing.
   * 
   * @exception IllegalStateException
   *   Indicates that this washer is busy.
   **/
   public void starLanding( )
   {
      if (TimeLeft > 0)
         throw new IllegalStateException("Runway is already busy.");
      TimeLeft = this.minForToLand;
   }
   
   /**
    * Start a departing.
    * 
    * @exception IllegalStateException
    *   Indicates that this washer is busy.
    **/
   public void starTakingoff(){
    	 
	   if (TimeLeft > 0)
	         throw new IllegalStateException("Runway is already busy.");
	   TimeLeft = this.minForToTakeoff;
	   }	 
    	 
     }

