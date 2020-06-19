import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class Lab5 {

	public static void main(String[] args) {
		
		int N = 100000;
		simulation(new AIPlayer(), N);
		simulation(new BinarySearch(), N);
		simulation(new SuperAI(), N);

	}
	
	public static void simulation(Player p, int N) {
		
		int wins = 0;
		
		for (int i = 1; i <= N; i++) {
			Game curr_game = new Game(p);
			curr_game.run();
			if (curr_game.hasWon()) wins++;
		}
		
		System.out.printf("%18s (%.4f)\n", p, (double) wins / N);
		
	}

}

interface Play{
	int next(int l,int u);
}

abstract class Player implements Play{
	public abstract int next(int l, int u);
}

class AIPlayer extends Player {

	@Override
	public int next(int l, int u) {
		Random rand = new Random();
		return rand.nextInt(u- l + 1) + l;
	}

	@Override
	public String toString() {
		return "Naive AI";
	}
	
}

class BinarySearch extends AIPlayer {
	
	@Override
	public int next(int l, int u) {
		return (l+u)/2;
	}

	@Override
	public String toString() {
		return "Binary Search AI";
	}
	
}

class SuperAI extends AIPlayer {
	
	@Override
	public int next(int l, int u) {
		// your work here
		return l;

	}

	@Override
	public String toString() {
		return "Super AI";
	}
	
}

class HumanPlayer extends Player {
	
	private Scanner input = new Scanner(System.in);
	private String name;

	HumanPlayer(String name) {
		this.name = name;
	}

	@Override
	public int next(int l, int u) {
		return input.nextInt();
	}

	@Override
	public String toString() {
		return "Human Player: " + this.name;
	}
}


class Game {
	
	private final int s;
	private final Player player;
	private int low = 0, high = 99;
	private boolean win = false;
	
	boolean hasWon() {
		return win;
	}
	
	Game(Player player) {
		this.s = (int) (Math.random() * 100);
		this.player = player;
	}
	
	void run() {
		
		// your work here
		while(true){
			int goal = player.next(this.low, this.high);
			if (goal > this.s){
				this.high = goal -1;
			}else if(goal < this.s){
				this.low = goal+1;
			}else{
				this.win = true;
				break;
			}
			if (this.low==this.high){
				break;
			}
		}

	}
	
}
