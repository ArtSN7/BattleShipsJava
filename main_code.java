import java.util.Arrays;
import java.util.Scanner;



public class main_code {

	static int[][] field_1 = new int[10][10]; // player 1 field with ships

	static int[][] field_2 = new int[10][10]; // player 2 field with ships


	public static boolean checking_coords(int row , int col, int player){

		row = row - 1;
		col = col - 1;

		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){ // limits of coords

			int[][] field;

			if (player == 1){
				field = field_1;
			}
			else{
				field = field_2;
			}


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


	public static void CreateFieldForPlayers(int player){

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

			if (player == 1){
				check = checking_coords(row, col, 1);
			}
			else{
				check = checking_coords(row, col, 2);
			}
			
			


			while (check == false){

				System.out.println("\n\nTry again, you've input wrong values!");

		        System.out.println("\n\nInput row for the ship num " + i + ":");
                row = input.nextInt();
                System.out.println("\n\nInput col for the ship num " + i + ":");
				col = input.nextInt();

				if (player == 1){
				    check = checking_coords(row, col, 1);
			    }
			    else{
				    check = checking_coords(row, col, 2);
			    }
			}

			if (player == 1){
				field_1[row - 1][col - 1] = 1;
			}
			else{
				field_2[row - 1][col - 1] = 1;
			}


			

		}

	}


	public static void printing_rules(){
		System.out.print("Dear players,\n\nI am happy to see you in my game! Here you can read rules:\n\n - Each of you has a 10*10 field where u can set up 5 ships\n - Every ship must be in a single cell\n - Players are shooting in an order, but if someone hit, he has a chance to shoot one more time until he misses\n - Game finishes, when there are no ships on one of the field");
        
		System.out.println("\n\n---------------------------------------------------------------------------");
		System.out.print("\n\nLet's start!\n"); // introducing our game
	}

	
	public static boolean checking_shot_cords(int row, int col){ // checking that coordinates of shot are alright
		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){
			return true;
		}
		return false;

	}
	
	
	public static void main(String[] args) {
		int whos_turn = 1; // value that shows who is shooting ( 1- first player, 2 - second player )

	    int num_of_shoots_1 = 0;

	    int num_of_shoots_2 = 0;

	    int number_of_alive_ships_1 = 5;

	    int number_of_alive_ships_2 = 5;


	    int[][] field_shoots_1 = new int[10][10]; // player 1 field where it is shown all his shoots

	    int[][] field_shoots_2 = new int[10][10]; // player 2 field where it is shown all his shoots

		printing_rules(); // printing rules

		//setting_up(); // setting up ships on the field

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nHello, Player 1");


		CreateFieldForPlayers(1); // creating field for player 1 


		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){
			System.out.println(Arrays.toString(field_1[i]));
		}



		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nLet's move to another player");
		System.out.println("\nHello, Player 2");


		CreateFieldForPlayers(2); // creating field for player 2 

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){
			System.out.println(Arrays.toString(field_2[i]));
		}




        // main code that do the game
        System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nWe are ready to start playing! Good luck players!\n\n");
		System.out.println("\n---------------------------------------------------------------------------");
		

        Scanner input = new Scanner(System.in);
		int row_c; // coordinates of the shooting
	    int col_c; // coordinates of the shooting
		boolean check_shoot = false;

        while (number_of_alive_ships_1 > 0 && number_of_alive_ships_2 > 0){ // game is being played until one of the players loses all his ships
			
			System.out.println("\n---------------------------------------------------------------------------");

			System.out.println("This is your shots (1 means that u have tried this field.)");

			for (int i = 0; i < 10; i++){
			    System.out.println(Arrays.toString(field_shoots_1[i]));
			}


			System.out.println("\nPlayer" + whos_turn + " , input  a row coordinate of the target ( 1 - 10): ");
			row_c = input.nextInt();
			System.out.println("Player" + whos_turn + " , input  a col coordinate of the target ( 1 - 10): ");
			col_c = input.nextInt();

			check_shoot = checking_shot_cords(row_c - 1, col_c - 1);

			while (check_shoot == false){
				System.out.println("\n---------------------------------------------------------------------------");
				System.out.println("Try again!");
			    System.out.println("Player" + whos_turn + " , input  a row coordinate of the target ( 1 - 10): ");
			    row_c = input.nextInt();
			    System.out.println("Player" + whos_turn + " , input  a col coordinate of the target ( 1 - 10): ");
			    col_c = input.nextInt();
				check_shoot = checking_shot_cords(row_c - 1, col_c - 1);
			}

			if (whos_turn == 1){

				field_shoots_1[row_c - 1][col_c - 1] = 1;

				if (field_2[row_c - 1][col_c - 1] == 1){ // if user killed a ship

					System.out.println("\nYou have killed a ship! You have another try.");
					System.out.println("\n---------------------------------------------------------------------------");
					number_of_alive_ships_2 = number_of_alive_ships_2 - 1;
					num_of_shoots_1 = num_of_shoots_1 + 1;

				}
				else{
					System.out.println("\nYou have missed!");
					System.out.println("\n---------------------------------------------------------------------------");

					if (whos_turn == 1){ // changing player
						whos_turn = 2;
					}
					else{
						whos_turn = 1;
					}

				}


			}
			else{

				field_shoots_2[row_c - 1][col_c - 1] = 1;

				if (field_1[row_c - 1][col_c - 1] == 1){ // if user killed a ship

					System.out.println("\nYou have killed a ship! You have another try.");
					number_of_alive_ships_1 = number_of_alive_ships_1 - 1;
					num_of_shoots_2 = num_of_shoots_2 + 1;

				}
				else{
					System.out.println("\nYou have missed!");

					if (whos_turn == 1){ // changing player
						whos_turn = 2;
					}
					else{
						whos_turn = 1;
					}

				}

			}
		}

		//after the game

		        
		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThe game is over!\n\nHere's some info:\n");
		
		if (number_of_alive_ships_1 == 0){
			System.out.println("The winner is Player 2");
			System.out.println("Number of his shots: " + num_of_shoots_2);
		}
		else{
			System.out.println("The winner is player 1");
			System.out.println("Number of his shots: " + num_of_shoots_1);
		}



	
	}



}






