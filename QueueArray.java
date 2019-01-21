/**@author Oussama el aallali
 * 
 *
 */
public class QueueArray <E> {
	
	private Object[] data;
	private int numItems;
	private int rare;
	private int front;
	
	

	public int getNumItems() {
		return numItems;
	}

	public int getRare() {
		return rare;
	}

	public int getFront() {
		return front;
	}

	
	public Object [] getData() {
		return data;
	}

	public QueueArray(){
		
		data = new Object[1000000];
		
		this.front = 0;
		this.rare =0;
		this.numItems = 0;
					
	}
	
	public void  add (E item){
		
		if(this.numItems!= data.length)
			data[rare] = item;
		this.numItems++;
		rare =(rare+1)% this.data.length;
	}
	
	public E remove(){
		
		E temp = (E) this.data[this.front];
		
		this.data[front] = null;
		
		this.front = (this.front+1)% this.data.length;
		
		this.numItems--;
		
		return temp;
	}

	public boolean isEmpty(){
		
		return(this.numItems == 0);
		
	}
		

		
	}
	
	
	


