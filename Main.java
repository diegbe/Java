import java.util.*;

public class Main {
    public static int numRows = 10;
    public static int numCols = 10;
    public static int amountOfShips = 4;
    public static Ocean oceanPl = new Ocean();
    public static Ocean oceanCp = new Ocean();

    public static void main(String[] args) {
        // Step 1 - Create ocean map
        System.out.println("*** Welcome to Battle Ship game ***");
        System.out.print(" sea is empty");
        oceanPl.printMap();
        // Step 2 - Deploy player's ships
        deployPlShips();
        // Step 3 - Deploy computer's ships
        deployCpShips();
        // Step 4 - Battle
        Battle();
        // Step 5 - Game over
        gameOver();
    }

    public static void deployPlShips() {
        Random rand = new Random();
        System.out.println("Player deploy ships... ");
        for (int i = 1; i <= amountOfShips; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter row number");
            int rowNum = input.nextInt();
            System.out.println("Enter col number");
            int colNum = input.nextInt();
            input.nextLine();
            System.out.println("Enter orientation: h for horizontal or v for vertical");
            String orientation = input.nextLine();

            oceanPl.deployPlShip(rowNum, colNum, orientation, i+1);
        }
    }

    public static void deployCpShips() {
        System.out.println("Computer deploy ships... ");
        Random rand = new Random();
        int[] lengthC = {2, 3, 4, 5};
        for (int i = 0; i < amountOfShips; i++) {
            int randNumRows = rand.nextInt(numRows - lengthC[i] - 1 + 1);
            int randNumCols = rand.nextInt(numCols - lengthC[i] - 1 + 1);
            Random random = new Random();
            boolean orientation = random.nextBoolean();
            oceanCp.deployCpShips(randNumRows, randNumCols, orientation, lengthC[i]);
        }
    }

    public static void Battle() {
        while (checkForPlShips() == true && checkForCpShips() == true) {
            if (checkForPlShips() == true) {
                playerShoot();
            }
            if (checkForCpShips() == true) {
                computerShoot();
            }
        }
        System.out.println(" --- Game over --- ");
    }

    public static void playerShoot() {
        int rowValue;
        int colValue;
        System.out.println(" Player turn ");
        Scanner input = new Scanner(System.in);
        System.out.println("Row: ");
        rowValue = input.nextInt();

        System.out.println("Column: ");
        colValue = input.nextInt();

        oceanCp.playerShoot(rowValue, colValue);
    }

    public static void computerShoot() {
        int rowValue;
        int colValue;
        System.out.println(" Computer turn ");
        rowValue = new Random().nextInt(numRows);
        colValue = new Random().nextInt(numCols);

        oceanPl.computerShoot(rowValue, colValue);
    }
    public static boolean checkForPlShips() {
        return oceanPl.checkForPlShips (numRows, numCols );
    }

    public static boolean checkForCpShips() {
        return oceanCp.checkForCpShips (numRows, numCols );
    }

    public static void gameOver(){
        if (checkForPlShips() == true && checkForCpShips() == false){
            System.out.println("* PLAYER won the battle *");
        }
        else if (checkForPlShips() == false && checkForCpShips() == true) {
            System.out.println("* COMPUTER won the battle *");
        }
    }
}
