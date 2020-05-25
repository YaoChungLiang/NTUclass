
public class BankEmployee extends Thread {
	
	private String name;
	private Bank bank;
	private int account_no;
	
	public BankEmployee(String name, Bank bank, int acc_no) {
		
		this.name = name;
		this.bank = bank;
		this.account_no = acc_no;
		this.start();
		
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 1000; i++) {
			bank.booking(name, account_no, 1);
		}
		System.out.println(name + " completed.");
		
	}

}
