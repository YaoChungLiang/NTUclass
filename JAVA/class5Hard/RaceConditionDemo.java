
public class RaceConditionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Bank CTBC = new Bank("CTBC", 5); 
		BankEmployee e1 = new BankEmployee("Arthur", CTBC, 1);
		BankEmployee e2 = new BankEmployee("Mint", CTBC, 1);
		
		e1.join();
		e2.join();
		
		System.out.println(CTBC);

	}

}
