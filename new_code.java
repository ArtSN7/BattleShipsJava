import java.util.Scanner;
import java.util.Arrays;


  
class Game{

	public static boolean checking_shot_cords(int row, int col){ // checking that coordinates of shot are alright
		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){
			return true;
		}
		return false;

	}

    public static void printing_rules(){
	    System.out.print("Dear players,\n\nI am happy to see you in my game! Here you can read rules:\n\n - Each of you has a 10*10 field where u can set up 5 ships\n - Every ship must be in a single cell\n - Players are shooting in an order, but if someone hit, he has a chance to shoot one more time until he misses\n - Game finishes, when there are no ships on one of the field");
        
	    System.out.println("\n\n---------------------------------------------------------------------------");
	    System.out.print("\n\nLet's start!\n"); // introducing our game
		System.out.println("\n\n---------------------------------------------------------------------------");
	}

	public static void game_against_ai(){ // game against AI ( when u play alone )

	}

	public static void game_against_player(){ // game with 2 players

		Player player_1 = new Player();

        Player player_2 = new Player();


		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nHello, Player 1");


		player_1.CreateFieldForPlayers(); // creating field for player 1


		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){ // printing player_1's field
			System.out.println(Arrays.toString(player_1.field[i]));
		}



		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nLet's move to another player");
		System.out.println("\nHello, Player 2");


		player_2.CreateFieldForPlayers(); // creating field for player 2

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){ // printing player_2's field
			System.out.println(Arrays.toString(player_2.field[i]));
		}


        // main code that do the game
        System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nWe are ready to start playing! Good luck players!\n\n");
		System.out.println("\n---------------------------------------------------------------------------");


        // start from 241 line of code
	}

}

class Player{

    int[][] field = new int[10][10];

    int num_of_shoots = 0;

	int number_of_alive_ships = 5;


    boolean checking_coords(int row , int col){

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

    
    
    void CreateFieldForPlayers(){


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


public class new_code{
    public static void main(String[] args) {

		int value;

		Scanner input = new Scanner(System.in);

        Game game = new Game();

        game.printing_rules();

		System.out.println("\n\n---------------------------------------------------------------------------");
		System.out.println("Input 1 if you want to play alone against AI / Input 2 if you want to play with a friend");

		value = input.nextInt();

		while (value != 1 || value != 2){
			System.out.println("\n\nPlease, try again");
			System.out.println("Input 1 if you want to play alone against AI / Input 2 if you want to play with a friend");

			value = input.nextInt();
		}

		if (value == 1){
			game.game_against_ai();
		}
		else{
			game.game_against_player();
		}


    }

}
