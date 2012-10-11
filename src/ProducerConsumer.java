import java.io.*;
public class ProducerConsumer {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int p = 0;
		
		System.out.println("Enter size of buffer");
		try{
			n = Integer.parseInt(br.readLine());
			System.out.println("Enter number of productions");
			p = Integer.parseInt(br.readLine());
		}
		catch(IOException e)
		{
			System.err.println("IOException occured :(");
		}
		
		if(n != 0 && p != 0){
			SharedBuffer buffer = new SharedBuffer(n);
			(new Thread(new Producer(buffer, p))).start();
			(new Thread(new Consumer(buffer))).start();
		}
		
	}

}
