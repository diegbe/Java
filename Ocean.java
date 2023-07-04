public class Ocean {
    int numRows = 10;
    int numCols = 10;
    String [][] ocean;

    public Ocean (){
        this.ocean = new String [numRows][numCols];
    }

    public void printMap() {
        System.out.println("\n  0 1 2 3 4 5 6 7 8 9 ");
        char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int row = 0; row < charArray.length; row++) { //Create the numbers
            System.out.print(charArray[row] + "|");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(ocean[row][col]);
                }
            }
            System.out.println("|" + charArray[row]);
        }
        System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
    }

    public void deployPlShip(int rowNum, int colNum, String orientation, int length){
            if (orientation.equals("h")) { // Horizontal
                for (int j = 0; j < length; j++) {
                    if ((colNum + j) < 10) {
                        ocean[rowNum][colNum + j] = "X ";
                    } else {
                        System.out.println("Ship is outside the board, try again");
                        break;
                    }
                }
                System.out.println("Player board ");
                this.printMap();
            } else {
                for (int j = 0; j < length; j++) {
                    if ((rowNum + j) < 10) {
                        ocean[rowNum + j][colNum] = "X ";
                    } else {
                        System.out.println("Ship is outside the board, try again");
                        break;
                    }
                }
                System.out.println("Player board ");
                this.printMap();
            }
    }

    public void deployCpShips(int randNumRows, int randNumCols, boolean orientation, int lengthC){
            ocean[randNumRows][randNumCols] = "X ";
            for (int j = 1; j < lengthC; j++) {
                if (orientation == false) {
                    ocean[randNumRows][randNumCols + j] = "X ";
                } else {
                    ocean[randNumRows + j][randNumCols] = "X ";
                }
            }
        System.out.println("Computer board ");
        this.printMap();
    }

    public void playerShoot(int rowValue, int colValue) {
        if (ocean[rowValue][colValue] == "X ") {
            System.out.println("Hit");
            ocean[rowValue][colValue] = "1 ";
            this.printMap();
        } else if (ocean[rowValue][colValue] == null) {
            System.out.println("Miss");
            ocean[rowValue][colValue] = "0 ";
            this.printMap();
        } else {
            System.out.println("Already been shoot");
            this.printMap();
        }
    }

    public void computerShoot(int rowValue, int colValue) {
        if (ocean[rowValue][colValue] == "X ") {
            System.out.println("Hit");
            ocean[rowValue][colValue] = "1c";
            this.printMap();
        } else if (ocean[rowValue][colValue] == null) {
            System.out.println("Miss");
            ocean[rowValue][colValue] = "0c";
            this.printMap();
        } else {
            System.out.println("Already been shoot");
            this.printMap();
        }

    }

    public boolean checkForPlShips(int numRows, int numCols) {
        for (int row = 0; row <= numRows - 1; row++) {
            for (int col = 0; col <= numCols - 1; col++) {
                if (ocean[row][col] == "X ") {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForCpShips(int numRows, int numCols) {
        for (int row = 0; row <= numRows - 1; row++) {
            for (int col = 0; col <= numCols - 1; col++) {
                if (ocean[row][col] == "X ") {
                    return true;
                }
            }
        }
        return false;
    }

}
