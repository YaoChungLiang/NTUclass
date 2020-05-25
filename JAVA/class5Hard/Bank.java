
public class Bank {
	
	private Account[] accounts;
	private String name;
	
	public Bank(String bank_name, int size) {
		
		this.name = bank_name;
		this.accounts = new Account[size];
		
		for (int i = 0; i < size; i++) {
			accounts[i] = new Account("User " + i, 0);
		}
		
	}
	
	public void booking(String name, int acc_no, int amount) {
		
//		int old_balance = accounts[acc_no].getBalance();
//		int new_balance = old_balance + amount;
//		accounts[acc_no].set(new_balance);
//        synchronized(accounts[acc_no]){          
//        }
		accounts[acc_no].set(accounts[acc_no].getBalance() + amount);
//		System.out.println(name + " add 1 dollar to account " + acc_no + ".");
		
	}
	
	@Override
	public String toString() {
		
		StringBuffer output = new StringBuffer();
		output.append(name + " maintains " + accounts.length + " accounts as follows:\n");
		
		for (Account account: accounts) output.append(account);
		
		return output.toString();
	}

}
