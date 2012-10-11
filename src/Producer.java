import java.util.Random;
public class Producer implements Runnable{

	private SharedBuffer Buffer;
	private int n;
	private int maxProductions;
	
	public Producer(SharedBuffer b, int maxProductions)
	{
		this.Buffer = b;
		this.maxProductions = maxProductions;
		n = 0;
	}
	
	public void run() {
		
		Random rand = new Random();
		for(int i = 0; i < maxProductions; i++)
		{
			int item = GetNextFactorial();
			Buffer.Produce(item);
			try{
				Thread.sleep(rand.nextInt(1000));
			}
			catch(InterruptedException e){}
		}
		Buffer.Produce(-1);
	}
	
	private int GetNextFactorial()
	{
		int factorial = 1;
		
		n++;
		for(int i = 1; i <= n; i++)
			factorial *= i;
		
		return factorial;
	}

}
