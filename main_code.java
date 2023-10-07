import java.util.Arrays;
import java.util.Scanner;



class Player{

	int player_number; // player's number

	int number_of_alive_ships; // number of ships which are alive

	static int[][] field = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		}; // player's field with ships


    public Player(int number){

		this.player_number = number; // declaring what number is our player


		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\n\nHello, Player_" + player_number); // saying hello to player

	}

	public static void cleaning_field(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				field[i][j] = 0;
			}
		}
	}

	


	public static boolean checking_coords(int row , int col){

		row = row - 1;
		col = col - 1;

		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){ // limits of coords

			if (row == 0){
				if (col == 0){
					if (field[row][col] == 0 && field[row][col + 1] == 0 && field[row + 1][col] == 0 && field[row + 1][col + 1] == 0){
						return true;
					}
				}

				if (col == 9){
					if (field[row][col] == 0 && field[row][col - 1] == 0 && field[row + 1][col] == 0 && field[row + 1][col - 1] == 0){
						return true;
					}
				}

				if (col != 9 && col != 0){
					if (field[row][col] == 0 && field[row][col + 1] == 0 && field[row][col - 1] == 0 && field[row + 1][col] == 0 && field[row + 1][col + 1] == 0 && field[row + 1][col - 1] == 0){
						return true;
					}
				}

			}

			if (row == 9){

				if (col == 0){
					if (field[row][col] == 0 && field[row][col + 1] == 0 && field[row - 1][col] == 0 && field[row - 1][col + 1] == 0){
						return true;
					}
				}

				if (col == 9){
					if (field[row][col] == 0 && field[row][col - 1] == 0 && field[row - 1][col] == 0 && field[row - 1][col - 1] == 0){
						return true;
					}
				}

				if (col != 9 && col != 0){
					if (field[row][col] == 0 && field[row][col + 1] == 0 && field[row][col - 1] == 0 && field[row - 1][col] == 0 && field[row - 1][col + 1] == 0 && field[row - 1][col - 1] == 0){
						return true;
					}
				}

			}

			if (row != 9 && row != 0){

				if (col == 0){
					if (field[row][col] == 0 && field[row][col + 1] == 0 && field[row - 1][col] == 0 && field[row - 1][col + 1] == 0 && field[row + 1][col] == 0 && field[row + 1][col + 1] == 0){
						return true;
					}
				}

				if (col == 9){
					if (field[row][col] == 0 && field[row][col - 1] == 0 && field[row - 1][col] == 0 && field[row - 1][col - 1] == 0 && field[row + 1][col] == 0 && field[row + 1][col - 1] == 0){
						return true;
					}
				}

				if (col != 9 && col != 0){
					if (field[row][col] == 0 && field[row][col + 1] == 0 && field[row][col - 1] == 0 && field[row + 1][col] == 0 && field[row + 1][col + 1] == 0 && field[row + 1][col - 1] == 0 && field[row - 1][col] == 0 && field[row - 1][col + 1] == 0 && field[row - 1][col - 1] == 0){
						return true;
					}
				}
			}
		}

		return false;
		
	}


	public static void CreateFieldForPlayers(){

		int row, col;
		boolean check; 

		Scanner input = new Scanner(System.in);

		row = 0;
		col = 0;
		check = false;

		System.out.println("\n\n\nNow we are going to put 5 ships to the field.");

		

		for (int i = 1; i <= 5; i++){ // asking coordinates for 5 ships

            System.out.println("\n\nInput row for the ship num " + i + ":");
            row = input.nextInt();

            System.out.println("\n\nInput col for the ship num " + i + ":");
			col = input.nextInt();
			
			check = checking_coords(row, col);


			while (check == false){

				System.out.println("\n\nTry again, you've input wrong values!");

		        System.out.println("\n\nInput row for the ship num " + i + ":");
                row = input.nextInt();
                System.out.println("\n\nInput col for the ship num " + i + ":");
				col = input.nextInt();

				check = checking_coords(row, col);
			}

			field[row - 1][col - 1] = 1;

		}

	}

}








public class main_code {

	static int[][] field_1 = new int[10][10]; // player 1 field

	static int[][] field_2 = new int[10][10]; // player 2 field


	public static void setting_up(){

		Player player_1 = new Player(1); // creating player_1

		player_1.CreateFieldForPlayers(); // creating field for player 1 

		field_1 = player_1.field;

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){
			System.out.println(Arrays.toString(field_1[i]));
		}


		// cleaning up the field 
		player_1.cleaning_field();


		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nLet's move to another player");

		Player player_2 = new Player(2); // creating player_2

		player_2.CreateFieldForPlayers(); // creating field for player 2 

		field_2 = player_2.field;

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){
			System.out.println(Arrays.toString(field_2[i]));
		}

		// cleaning up the field 
		player_2.cleaning_field();

	}



	public static void printing_rules(){
		System.out.print("Dear players,\n\nI am happy to see you in my game! Here you can read rules:\n\n - Each of you has a 10*10 field where u can set up 5 ships\n - Every ship must be in a single cell\n - Players are shooting in an order, but if someone hit, he has a chance to shoot one more time until he misses\n - Game finishes, when there are no ships on one of the field");
        
		System.out.println("\n---------------------------------------------------------------------------");
		System.out.print("\n\nLet's start!\n"); // introducing our game
	}

	
	
	
	public static void main(String[] args) {

		printing_rules(); // printing rules

		setting_up(); // setting up ships on the field



	
	}



}






