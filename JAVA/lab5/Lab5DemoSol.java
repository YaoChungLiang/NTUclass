import java.util.Scanner;

public class Lab5DemoSol {

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

abstract class Player {
	abstract int next(int l, int u);
}

class AIPlayer extends Player {

	@Override
	public int next(int l, int u) {
		return (int) (Math.random() * (u - l + 1) + l);
	}

	@Override
	public String toString() {
		return "Naive AI";
	}
	
}

class BinarySearch extends AIPlayer {
	
	@Override
	public int next(int l, int u) {
		return (u + l) / 2;
	}

	@Override
	public String toString() {
		return "Binary Search AI";
	}
	
}

class SuperAI extends AIPlayer {
	
	@Override
	public int next(int l, int u) {
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
		
		while (true) {

			int g = player.next(low, high);

			if (g > s) {
				high = g - 1;
			} else if (g < s) {
				low = g + 1;
			} else {
				win = true;
				break;
			}

			if (low == high) break;

		}

	}
	
}
