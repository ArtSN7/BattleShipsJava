import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


  

class AI{

	    
	int[][] field = new int[10][10]; // field with ships

	int[][] field_shoots = new int[10][10]; // field with shots

    int num_of_shoots = 0; // number of shots

	int number_of_alive_ships = 5; // number of alive ship in matrix


	boolean shot_check(int row, int col){ // checking 

		if (field_shoots[row][col] == 1){ // if Ai has already done a shot to this coords return false, else true
			return false;
		}

		return true;

	}


	int[] DoShot(){ // shooting programm for AI

		int row;
		int col;
		boolean check;

		Random rand = new Random(); // creating object random

		row = rand.nextInt(10); // creating random row coord
		col = rand.nextInt(10); // creating random col coord

		check = shot_check(row, col); // checking if this coords are used

		while (check == false){ // creating coords until they are being not used


			row = rand.nextInt(10);
			col = rand.nextInt(10);

			check = shot_check(row, col);

		}

		field_shoots[row][col] = 1; // adding shot to the matrix

		int[] ret = {row, col}; // returning coords of the shot in order to check them in main code

		return ret;


	}


	void CreateFieldAI(){ // creating field for AI

		int row;
		int col;
		boolean check;

		Random rand = new Random(); // creating random object

		for (int i = 0; i <= 4; i++){ // creating field for AI

			row = rand.nextInt(10); // random row
			col = rand.nextInt(10); // random col

			check = checking_coords(row, col); // checking coords 

			while (check == false){ // until coords are valid
				row = rand.nextInt(10);
				col = rand.nextInt(10);
				check = checking_coords(row, col);
			}

			field[row][col] = 1; // adding ship to the matrix
		}

	}



	boolean checking_coords(int row , int col){ // just checking coords

		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){ // limits of coords

            // checking if there are no ships
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





}




class Game{

	public static boolean checking_shot_cords(int row, int col){ // checking that coordinates of shot are alright
		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){
			return true;
		}
		return false;

	}

    
	
	public static void printing_rules(){ // printing rules before starting the game
	    System.out.print("Dear players,\n\nI am happy to see you in my game! Here you can read rules:\n\n - Each of you has a 10*10 field where u can set up 5 ships\n\n - Every ship must be in a single cell\n\n - Players are shooting one after another, but if someone kills a ship, he has a chance to shoot one more time until he misses\n\n - Game finishes, when there are no ships on one of the field");
        
	    System.out.println("\n\n---------------------------------------------------------------------------");
	    System.out.print("\n\nLet's start!\n"); // introducing our game
		System.out.println("\n\n---------------------------------------------------------------------------");
	}

	
	
	public static void game_against_ai(){ // game against AI ( when u play alone )

		int whos_turn = 1; // value that shows who shoots ( 1 - player, 2 - ai)

		int[] values = {0, 0}; // coord of ai shot

		//setting up a user stuff

		Player player_1 = new Player();

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nHello, Player");

		player_1.CreateFieldForPlayers(); // creating field for player 1

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThat's your field\n\n");

		for (int i = 0; i < 10; i++){ // printing player_1's field
			System.out.println(Arrays.toString(player_1.field[i]));
		}


		System.out.println("\n---------------------------------------------------------------------------");

		//finishing doing stuff with user



		//starting setting up an AI

		System.out.println("\nSetting up AI...\n");
		System.out.println("\nGive us a second...\n");
		System.out.println("\n---------------------------------------------------------------------------");

		AI ai = new AI(); //  creating AI object

		ai.CreateFieldAI(); // creating field for AI

		
		// player starts first, then AI shoots randomly until he won't shoot new point ( need to check shot_field )
		// main code that do the game
        System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\n\nWe are ready to start playing! Good luck player!\n\n");
		System.out.println("\n---------------------------------------------------------------------------");


		Scanner input = new Scanner(System.in);

		int row_c; // coordinates of the shooting
	    int col_c; // coordinates of the shooting

		boolean check_shoot = false;


		//playing game

		while (player_1.number_of_alive_ships > 0 && ai.number_of_alive_ships > 0){ // game is being played until one of the players loses all his ships
			
			System.out.println("\n---------------------------------------------------------------------------");

			if (whos_turn == 1){

				System.out.println("This is your shots (1 means that u have tried this field.)");

				for (int i = 0; i < 10; i++){
			    	System.out.println(Arrays.toString(player_1.field_shoots[i]));
				}

				System.out.println("\nPlayer, input  a row coordinate of the target ( 1 - 10): \n");
			    row_c = input.nextInt();

				System.out.println("\nPlayer, input  a col coordinate of the target ( 1 - 10): \n");
				col_c = input.nextInt();

				check_shoot = checking_shot_cords(row_c - 1, col_c - 1); // checking shot coords



				while (check_shoot == false){ // asking for coords until they valid
					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("Try again! You have input invalid coordinates!");
			    	System.out.println("\nPlayer" + whos_turn + " , input  a row coordinate of the target ( 1 - 10): \n");
			    	row_c = input.nextInt();
			    	System.out.println("\nPlayer" + whos_turn + " , input  a col coordinate of the target ( 1 - 10): \n");
			    	col_c = input.nextInt();
					check_shoot = checking_shot_cords(row_c - 1, col_c - 1);
				}

				// checking results of shot

				player_1.field_shoots[row_c - 1][col_c - 1] = 1; // adding that these coords were used

				if (ai.field[row_c - 1][col_c - 1] == 1){ // if user killed a ship

					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nBAAAAM!!!\n");
					System.out.println("\nYou have killed a ship! You have another try.");
					System.out.println("\n---------------------------------------------------------------------------");

					ai.number_of_alive_ships = ai.number_of_alive_ships - 1; // reducing number of alive ships

					ai.field[row_c - 1][col_c - 1] = 0; // deleting dead ship from matrix

					player_1.num_of_shoots = player_1.num_of_shoots+ 1; // adding number of shots

				}
				else{
					
					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nOOOOPSSS\n");
					System.out.println("\nYou have missed!");
					System.out.println("\n---------------------------------------------------------------------------");

					whos_turn = 2; // changing turn if user misses
				}

				// finishing checking result of the shot
			}
			else{ // AI is shooting

				System.out.println("\n\nNow it's time for AI to have a shot! Be scared of power of random!\n");

				values = ai.DoShot(); // coords of ai shot

				if (player_1.field[values[0]][values[1]] == 1){ // if ai kills someone

					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nBAAAAM!!!\n");
					System.out.println("\nAI has killed a ship! He will shoot again.");
					System.out.println("\n---------------------------------------------------------------------------");

					player_1.number_of_alive_ships = player_1.number_of_alive_ships - 1; // reducing number of alive ships

					player_1.field[values[0]][values[1]] = 0; // deleting ship from matrix

					ai.num_of_shoots = ai.num_of_shoots + 1; // adding number of shots
				}
				else{
				    System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nOOOOPSSS\n");
					System.out.println("\nYou have missed!");
					System.out.println("\n---------------------------------------------------------------------------");

					whos_turn = 1; // chaning turn if ai misses
				}



			}

		}



		//after the game printing results

		        
		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThe game is over!\n\nHere's some info:\n");
		System.out.println("\n---------------------------------------------------------------------------");
		
		if (player_1.number_of_alive_ships == 0){
			System.out.println("\nThe winner is AI");
			System.out.println("\nNumber of his shots: " + ai.num_of_shoots);
		}
		else{
			System.out.println("\nThe winner is player 1");
			System.out.println("\nNumber of his shots: " + player_1.num_of_shoots);
		}
		
	}

	
	
	public static void game_against_player(){ // game with 2 players

		int whos_turn = 1;

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


		Scanner input = new Scanner(System.in);
		int row_c; // coordinates of the shooting
	    int col_c; // coordinates of the shooting
		boolean check_shoot = false;

		//playing game

		while (player_1.number_of_alive_ships > 0 && player_2.number_of_alive_ships > 0){ // game is being played until one of the players loses all his ships
			
			System.out.println("\n---------------------------------------------------------------------------");

			System.out.println("This is your shots (1 means that u have tried this field.)");

			for (int i = 0; i < 10; i++){
			    System.out.println(Arrays.toString(player_1.field_shoots[i])); 
			}


			System.out.println("\nPlayer" + whos_turn + " , input  a row coordinate of the target ( 1 - 10): \n");
			row_c = input.nextInt();
			System.out.println("\nPlayer" + whos_turn + " , input  a col coordinate of the target ( 1 - 10): \n");
			col_c = input.nextInt();

			check_shoot = checking_shot_cords(row_c - 1, col_c - 1);

			while (check_shoot == false){
				System.out.println("\n---------------------------------------------------------------------------");
				System.out.println("Try again! You have input invalid coordinates!");
			    System.out.println("\nPlayer" + whos_turn + " , input  a row coordinate of the target ( 1 - 10): \n");
			    row_c = input.nextInt();
			    System.out.println("\nPlayer" + whos_turn + " , input  a col coordinate of the target ( 1 - 10): \n");
			    col_c = input.nextInt();
				check_shoot = checking_shot_cords(row_c - 1, col_c - 1);
			}


			// checking results of the turn 

			if (whos_turn == 1){

				player_1.field_shoots[row_c - 1][col_c - 1] = 1; // adding shot coords to the matrix

				if (player_2.field[row_c - 1][col_c - 1] == 1){ // if user killed a ship

					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nBAAAAM!!!\n");
					System.out.println("\nYou have killed a ship! You have another try.");
					System.out.println("\n---------------------------------------------------------------------------");

					player_2.number_of_alive_ships = player_2.number_of_alive_ships - 1; // subtract 1 dead ship from player's alive ships

					player_2.field[row_c - 1][col_c - 1] = 0; // delete dead shi from matrix
					player_1.num_of_shoots = player_1.num_of_shoots+ 1; // add 1 to the number of shots

				}
				else{
					
					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nOOOOPSSS\n");
					System.out.println("\nYou have missed!");
					System.out.println("\n---------------------------------------------------------------------------");

					if (whos_turn == 1){ // changing player
						whos_turn = 2; // chaning turn if user misses
					}
					else{
						whos_turn = 1; // chaning turn if user misses
					}

				}


			}
			else{

				player_2.field_shoots[row_c - 1][col_c - 1] = 1; // adding shot coords to the matrix

				if (player_1.field[row_c - 1][col_c - 1] == 1){ // if user killed a ship

					// printing that he killed a ship
					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nBAAAAM!!!\n");
					System.out.println("\nYou have killed a ship! You have another try.");
					System.out.println("\n---------------------------------------------------------------------------");

					player_1.number_of_alive_ships = player_1.number_of_alive_ships - 1; // subtract 1 dead ship from player's alive ships

					player_1.field[row_c - 1][col_c - 1] = 0; // delete dead shi from matrix
					player_2.num_of_shoots = player_2.num_of_shoots + 1; // add 1 to the number of shots

				}
				else{
					System.out.println("\n---------------------------------------------------------------------------");
					System.out.println("\nOOOOPSSS\n");
					System.out.println("\nYou have missed!");
					System.out.println("\n---------------------------------------------------------------------------");

					if (whos_turn == 1){ // changing player
						whos_turn = 2; // changin turn if user misses
					}
					else{
						whos_turn = 1; // changing turn if user misses
					}

				}

			}
		}

		//after the game, just printing results
		        
		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("\nThe game is over!\n\nHere's some info:\n");
		System.out.println("\n---------------------------------------------------------------------------");
		
		if (player_1.number_of_alive_ships == 0){
			System.out.println("\nThe winner is Player 2");
			System.out.println("\nNumber of his shots: " + player_2.num_of_shoots);
		}
		else{
			System.out.println("\nThe winner is player 1");
			System.out.println("\nNumber of his shots: " + player_1.num_of_shoots);
		}


	}

}


class Player{

    int[][] field = new int[10][10]; // field with ships

	int[][] field_shoots = new int[10][10]; // field of shots 

    int num_of_shoots = 0; // how many shots player did

	int number_of_alive_ships = 5; // amount of ships of the player in the matrix 


    boolean checking_coords(int row , int col){ // checking coords of the ships ( if coords are in the matrix, if there are no ships around coords)

		row = row - 1;
		col = col - 1;

		if (row >= 0 && row <= 9 && col >= 0 && col <= 9){ // limits of coords

            // checking if there are any ships around the coords ( if not return true, else return false)
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

    
    
    void CreateFieldForPlayers(){ // function which creates field for player 


		int row, col;
		boolean check; 

		Scanner input = new Scanner(System.in); // creating Scanner object for input

		row = 0; // just value for next row inputs
		col = 0; // just value for next col inputs
		check = false; // shows if coords are valid or not

		System.out.println("\n\n\nNow we are going to put 5 ships to the field.");

		

		for (int i = 1; i <= 5; i++){ // asking coordinates for 5 ships

            System.out.println("\n\nInput row for the ship number " + i + ":");
            row = input.nextInt(); // getting row coord

            System.out.println("\n\nInput col for the ship number " + i + ":");
			col = input.nextInt(); // getting column coord

			check = checking_coords(row, col); // checking if coords are valid
			
			


			while (check == false){ // asking for valid coords until they are right

				System.out.println("\n\nTry again, you've input wrong values! ( You need to input one integer from 1 to 10 )");

		        System.out.println("\n\nInput row for the ship number " + i + ":");
                row = input.nextInt();
                System.out.println("\n\nInput col for the ship number " + i + ":");
				col = input.nextInt();

                check = checking_coords(row, col);


			}

			field[row - 1][col - 1] = 1; // adding ship to the field
			


			

		}

	}

}




public class battle_ship{ // main part of the code which starts the game
    public static void main(String[] args) {

		int value; // type of game

		Scanner input = new Scanner(System.in); // creating object Scanner for inputting value ( type of game )

        Game game = new Game(); // creating object game 

        game.printing_rules(); // printing rules

		System.out.println("\n\n---------------------------------------------------------------------------");
		System.out.println("Input 1 if you want to play alone against AI   |     Input 2 if you want to play with a friend");

		value = input.nextInt(); // user pick type of game

		System.out.println("\n\n---------------------------------------------------------------------------");

		while (value != 1 && value != 2){ // picks until value is 1 or 2
			System.out.println("\n\nPlease, try again. You need to input 1 or 2");
			System.out.println(" ");
			System.out.println("Input 1 if you want to play alone against AI   |     Input 2 if you want to play with a friend");

			value = input.nextInt(); // if value is invalid, then we ask to input it again
		}

		if (value == 1){ // if value is 1 
			game.game_against_ai(); // starting game with AI
		}
		else{ // if value is 2
			game.game_against_player(); // starting game with 2 player
		}


    }

}
