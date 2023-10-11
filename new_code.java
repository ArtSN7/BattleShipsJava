import java.util.Scanner;
import java.util.Arrays;


  
class Game{

    public static void printing_rules(){
	    System.out.print("Dear players,\n\nI am happy to see you in my game! Here you can read rules:\n\n - Each of you has a 10*10 field where u can set up 5 ships\n - Every ship must be in a single cell\n - Players are shooting in an order, but if someone hit, he has a chance to shoot one more time until he misses\n - Game finishes, when there are no ships on one of the field");
        
	    System.out.println("\n\n---------------------------------------------------------------------------");
	    System.out.print("\n\nLet's start!\n"); // introducing our game
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

        //Game game = new Game();

        //game.printing_rules();

        Player player_1 = new Player();

        Player player_2 = new Player();

        player_1.CreateFieldForPlayers();

        player_2.CreateFieldForPlayers();

        // player_1.field - getting player's field ( they are different for players )



    }

}
