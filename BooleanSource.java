/**@author Oussama el aallali
 * 
 *
 */
public class BooleanSource
{
   private double probability; // The approximate probability of query( ) returning true.
                      
   /**
   * Initialize a BooleanSource.
   * @param p
   *  
   * @exception IllegalArgumentException
   *   Indicates that p is outside of its legal range.
   **/
   public BooleanSource(double p)
   {
       if ((p < 0) || (1 < p))
           throw new IllegalArgumentException("Illegal p: " + p);
       probability = p;
   }

   /**
   * Get the next value from this 
   * @return
   *   The return value is either true or false 
   **/   
   public boolean query( )
   {
      return (Math.random( ) < probability);
   }

   
}
