/**@author Oussama el aallali
 * 
 *
 */

public class Averager
{
   private int count;  // How many numbers have been given to this averager
   private double sum; // Sum of all the numbers given to this averager
                      
   /**
   * Initialize an Averager
   * param - none
   * 
   **/
   public Averager( )
   {
       count =0;
       sum = 0;
   }


   /**
   * 
   * @param value
   *   the next number to give to this Averager
   * @exception IllegalStateException
   * 
   **/   
   public void addNumber(double value)
   {
      if (count == Integer.MAX_VALUE)
         throw new IllegalStateException("Too many numbers");
      count++;
      sum += value;
   }
 

   /**
   * Provide an average of all numbers given to this Averager.
   * @return
   *   the average of all the numbers that have been given to this
   *   
   **/
   public double average( )
   {
      if (count == 0)
         return Double.NaN;
      else
         return sum/count;
   } 


   /**
   * Provide a count of how many numbers have been given to this Averager.
   * @return
   *   the count of how many numbers have been given to this Averager
   **/
   public int howManyNumbers( )
   {
      return count;
   }
}
