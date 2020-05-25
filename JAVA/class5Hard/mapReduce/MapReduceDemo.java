public class MapReduceDemo {
	
	private static int size = 10000000;
	private static boolean[] array;
	
	public static void main(String[] args) {
	
		arrayGen();
		int[] nServers = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
		
		for (int num: nServers) {
			
			long t0 = System.nanoTime();
			simulate(num);
			long t1 = System.nanoTime();
			System.out.printf("%2d threads: %7.2f ms\n", num, (t1 - t0) / 1e6);
		
		}
	}
	
	public static void arrayGen() {
		
		boolean[] array = new boolean[size];
		for (int i = 0; i < size; i++) {
			if (Math.random() < 0.1)
				array[i] = true;
		}
		
		MapReduceDemo.array = array;
	}
	
	public static void simulate(int nServers) {
		
		Service[] services = new Service[nServers];
		Thread[] workers = new Thread[nServers];

		int start_idx = 0;
		int end_idx;
		int howMany = size / nServers;

		for(int i = 0; i < nServers; i++) {
			end_idx = start_idx + howMany - 1;
			services[i] = new Service(array, start_idx, end_idx);
			workers[i] = new Thread(services[i]);
			workers[i].start();
			start_idx = end_idx + 1;
		}

		try {
			for(int i = 0; i < nServers; i++)
				workers[i].join();
		} catch(InterruptedException e) {
			// do nothing
		}

		int total = 0;
		for(int i = 0; i < nServers; i++) {
			total += services[i].getResult();
		}
		
	}
}

class Service implements Runnable {
	
	private boolean[] data;
	private int start_idx;
	private int end_idx;
	private int result;

	public Service(boolean[] data, int start_idx, int end_idx) {
		this.data = data;
		this.start_idx = start_idx;
		this.end_idx = end_idx;
	}
	
	public int getResult() {
		return result;
	}
	
	public void run() {
		for(int i = start_idx; i <= end_idx; i++) if(data[i]) result++;
	}
}
