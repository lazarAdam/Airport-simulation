public class airPortSimulation {
/**
 *  method that runs the simulation 
 * 
 * @author Oussama el aallali
 * 
 * @param ltime landing wait time 
 * @param Ttime taking off wait time 
 * @param lProb landing probability 
 * @param Tprob take off  probability
 * @param maxfuel maximum fuel 
 * @param simtime simulation time
 * @param numRunways number ways
 * @return a string 
 */
	
public static String simulate(int ltime, int Ttime,double lProb,double Tprob,int maxfuel, int simtime, int numRunways){
	String toString = "";
	int timeStamp;// time stamp indicates the time that an plane entered the queue 
	int currentMin;// current minutes for the simulation 
	
	int numOfCrashes=0;
	
	QueueArray<Integer> landing = new QueueArray<Integer>();
	QueueArray<Integer> takingoff = new QueueArray<Integer>();
	
	
	
	
	BooleanSource landingProb = new BooleanSource(lProb);
	BooleanSource takingoffProb = new BooleanSource(Tprob);
	
	runWays  useRunway = new runWays(ltime , Ttime);
	runWays  useRunway2 = new runWays(ltime , Ttime);

	
	Averager landingWaitTime = new Averager( );
	Averager takingoffWaitTime = new Averager( );
	
	
	
	
toString+= "  Minutes to land: " + ltime + "\nl";
	
	toString+= "  Minutes to takeoff: " + Ttime;
	
	toString+= "\nl  "+"Probability of a landing plain ariving  during a Minute: " + lProb;
 
 
	toString+= "\nl  "+"Probability of a plain taking off during a Minute: " + Tprob;
 
 
	toString+= "\nl  "+" time limit  for fuel: " + maxfuel;
 
	toString+= "\nl  " + "Total simulation run time in Minutes : " + simtime;
	
	toString+= "\nl  " + "Number of Runways: " + numRunways+ "\nl";
	
	/**
	 * checking conditions of a potential arriving or departing plane in one minute  
	 * 
	 * 
	 */
	
	for(currentMin = 0; currentMin < simtime ; currentMin++ ){
		
		if((landingProb.query()== true) && (takingoffProb.query()== false)){
			
			landing.add(currentMin);
			
			
			
			System.out.println("Entered the landing only Queue");
		}
			
			else  if ((takingoffProb.query()== true) && (landingProb.query()== false)){
				
				takingoff.add(currentMin);
				
				System.out.println("Entered the tkaeoff  Queue");	
	}		
			
			else if(((landingProb.query()== true) && (takingoffProb.query()== true))){
			
			landing.add(currentMin);
			takingoff.add(currentMin);
			
			
			System.out.println("double entirs  Queue");
}

/*
 * condition of using runaways based on  priority (landing followed by departures)
 * 
 * 
 */

		if((!useRunway.isBusy())&&(!landing.isEmpty())){
				 
			
		
			timeStamp = landing.remove();
			
			if(currentMin - timeStamp > maxfuel){
				
				numOfCrashes++;
				
			}
			
			else{
			landingWaitTime.addNumber(currentMin - timeStamp);
			
			useRunway.starLanding();
			}
		
			 
		}
		// condition that allows the use of 2 runaways 
		else if ((!useRunway2.isBusy())&&(!landing.isEmpty()) && (numRunways==2)){
			 
			System.out.println("extra runway is active");
			
		timeStamp = landing.remove();
		
		if(currentMin - timeStamp > maxfuel){
			
			numOfCrashes++;
			
		}
		
		else{
		landingWaitTime.addNumber(currentMin - timeStamp);
		
		useRunway2.starLanding();
		}
	
		 
	}
		
		
		
		
		///////////////////////////////////////////////////////////////////////////
		
		
		else if((!useRunway.isBusy())&&(!takingoff.isEmpty())){
				
				
				
			timeStamp = takingoff.remove();
			
			takingoffWaitTime.addNumber(currentMin - timeStamp);
			
			useRunway.starTakingoff();
			
			
			
			}		
				
		else if ((!useRunway2.isBusy())&&(!takingoff.isEmpty())&& (numRunways==2)){
			
			System.out.println("extra runway is active 2");
			
		timeStamp = takingoff.remove();
		
		takingoffWaitTime.addNumber(currentMin - timeStamp);
		
		useRunway2.starTakingoff();
		
		
		
		}		
	
			useRunway.reduceRemainingTime();
		
			useRunway2.reduceRemainingTime();
		
		
		
		
	
	}
	
toString+= "\nl " + "-------------------------------------------------------------";
toString+= "\nl " + "  number of planes that landed :  " + landingWaitTime.howManyNumbers();
	
	toString+= "\nl " + "  number of planes that  took off:  " + takingoffWaitTime.howManyNumbers();
	
	if(landingWaitTime.howManyNumbers()>0)
		toString+= "\nl " + "  Average waiting time for landing  :  "  + landingWaitTime.average() + " Minutes" ;
	
	if(takingoffWaitTime.howManyNumbers()>0)
		toString+= "\nl" + " Average waiting time for takingoff :  "  + takingoffWaitTime.average() + " Minutes"  ;
	
	toString+= "\nl" + "  number of planes that crashed: " + numOfCrashes;
	
return toString;
	
}


}