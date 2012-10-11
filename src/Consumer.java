import java.util.Random;
public class Consumer implements Runnable{

	private SharedBuffer Buffer;
	
	public Consumer(SharedBuffer buffer)
	{
		this.Buffer = buffer;
	}
	
	public void run() {
		Random rand = new Random();
		
		for(int item = Buffer.Consume(); item != -1; item = Buffer.Consume())
		{
			try{
				Thread.sleep(rand.nextInt(3000));
			}
			catch(InterruptedException e){}
		}
		System.out.println("Consumed -1, stopping");
	}
}
