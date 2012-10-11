
public class SharedBuffer {
	
	private int[] buffer;
	private int count;
	
	public SharedBuffer(int items)
	{
		buffer = new int[items];
		count = 0;
	}
	
	public synchronized int Consume()
	{
		while(count == 0){
			try{
				//Wait for item to be produced
				System.out.println("Waiting for production...");
				wait();
			}
			catch(InterruptedException e)
			{}
		}
		int value = buffer[count - 1];
		count--;
		System.out.println("Consumed: "+value);
		displayBuffer();
		notifyAll();
		return value;
	}
	
	public synchronized void Produce(int item)
	{
		while(count == buffer.length)
		{
			try{
				//Wait for items to be consumed
				System.out.println("Waiting for consumption...");

				wait();
			}
			catch(InterruptedException e){}
		}
		
		buffer[count] = item;
		count++;
		System.out.println("Produced: "+item);
		displayBuffer();
		notifyAll();
	}
	
	public void displayBuffer()
	{
		System.out.print("Buffer = [ ");
		for(int i = 0; i < count; i++)
		{
			System.out.print(buffer[i] + " ");
		}
		System.out.println("]");
	}

}