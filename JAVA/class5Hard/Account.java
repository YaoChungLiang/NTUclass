
public class Account {
	
	private int balance = 0;
	private String owner;
	
	public Account(String owner, int init_balance) {
		this.owner = owner;
		this.balance = init_balance;
	}
	
	public void set(int amount) {
		balance = amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return owner + " -> " + balance + "\n";
	}

}
