public class Cipher {
    String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
            "R","S","T","U","V","W","X","Y","Z"};
    String[][] array = new String[5][5];
    String splittedLetter;
    String alphabetLetter;
    int l = 0;
    String lastReplacedLetter;

    // method to send key word used to fill the array
    void sendKeyWord(String keyWord) {
        String[] splitted = keyWord.replaceAll("\\s", "").split("");
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (k < splitted.length) {
                    splittedLetter = splitted[k];
                    boolean isDuplicate = false;

                    for (int m = 0; m < array.length; m++) {
                        for (int n = 0; n < array[m].length; n++) {
                            String arrayLetter = array[m][n];
                            if (splittedLetter.equals("I")) {
                                if (arrayLetter != null) {
                                    if (arrayLetter.equals("J")) {
                                        isDuplicate = true;
                                    }
                                }
                            }
                            if (splittedLetter.equals("J")) {
                                if (arrayLetter != null) {
                                    if (arrayLetter.equals("I")) {
                                        isDuplicate = true;
                                    }
                                }
                            }
                            if (splittedLetter.equals(arrayLetter)) {
                                isDuplicate = true;
                            }
                        }
                    }

                    if (!isDuplicate) {
                        array[i][j] = splittedLetter;
                    } else {
                        j--;
                    }
                    k++;
                } else {
                    while (array[i][j] == null) {
                        alphabetLetter = alphabet[l];
                        boolean isDuplicate = false;
                        for (int m = 0; m < splitted.length; m++) {
                            splittedLetter = splitted[m];
                            if (alphabetLetter.equals("I")) {
                                if (splittedLetter.equals("J")) {
                                    isDuplicate = true;
                                }
                            }
                            if (alphabetLetter.equals("J")) {
                                if (splittedLetter.equals("I")) {
                                    isDuplicate = true;
                                }
                            }
                            if (alphabetLetter.equals(splittedLetter)) {
                                isDuplicate = true;
                            }
                        }
                        if (!isDuplicate) {
                            array[i][j] = alphabetLetter;
                        }
                        l++;
                    }
                }
            }
        }
    }

    void printArray() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    String encrypt(String word) {
        String[] splitted = word.replaceAll("\\s", "").split("");
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < splitted.length; k+=2) {
            String letter1 = splitted[k];
            String letter2 = splitted[k+1];
            System.out.print(letter1 + letter2 + " ");
            int row1 = 0;
            int row2 = 0;
            int column1 = 0;
            int column2 = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (letter1.equals("I") || letter1.equals("J")) {
                        replace(letter1);
                    }
                    if (letter1.equals(array[i][j])) {
                        row1 = i;
                        column1 = j;
//                        System.out.println(array[i][j]);
                    }
                    if (lastReplacedLetter != null) {
                        undoReplace();
                    }

                    if (letter2.equals("I") || letter2.equals("J")) {
//                        System.out.print(array[1][0]);
                        replace(letter2);
//                        System.out.print(array[1][0] + " ");
                    }
                    if (letter2.equals(array[i][j])) {
                        row2 = i;
                        column2 = j;
                    }
                    if (lastReplacedLetter != null) {
                        undoReplace();
                    }
                }
            }

            if (row1 == row2) {
                if (column1 != array[row1].length-1) {
                    letter1 = array[row1][column1+1];
                } else {
                    letter1 = array[row1][0];
                }
                if (column2 != array[row2].length-1) {
                    letter2 = array[row2][column2+1];
                } else {
                    letter2 = array[row2][0];
                }
            } else if (column1 == column2) {
//                System.out.println("row = " + row1 + " column = " + column2
//                        + " letter = " + array[row1][column2]);
//                System.out.println("row = " + row2 + " column = " + column2
//                        + " letter = " + array[row2][column2]);
                if (row1 != array[column1].length-1) {
                    letter1 = array[row1+1][column1];
                } else {
                    letter1 = array[0][column1];
                }
                if (row2 != array[column2].length-1) {
                    letter2 = array[row2+1][column2];
                } else {
                    letter2 = array[0][column2];
                }
            } else {
                letter1 = array[row1][column2];
                letter2 = array[row2][column1];
            }

            sb.append(letter1).append(letter2);
            sb.append(" ");
        }

        System.out.println();
        return sb.toString();
    }

    String decrypt(String word) {
        String[] splitted = word.replaceAll("\\s", "").split("");
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < splitted.length; k+=2) {
            String letter1 = splitted[k];
            String letter2 = splitted[k+1];
            System.out.print(letter1 + letter2 + " ");
            int row1 = 0;
            int row2 = 0;
            int column1 = 0;
            int column2 = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (letter1.equals("I") || letter1.equals("J")) {
                        replace(letter1);
                    }
                    if (letter1.equals(array[i][j])) {
                        row1 = i;
                        column1 = j;
//                        System.out.println(array[i][j]);
                    }
                    if (lastReplacedLetter != null) {
                        undoReplace();
                    }

                    if (letter2.equals("I") || letter2.equals("J")) {
//                        System.out.print(array[1][0]);
                        replace(letter2);
//                        System.out.print(array[1][0] + " ");
                    }
                    if (letter2.equals(array[i][j])) {
                        row2 = i;
                        column2 = j;
                    }
                    if (lastReplacedLetter != null) {
                        undoReplace();
                    }
                }
            }

            if (row1 == row2) {
                if (column1 != 0) {
                    letter1 = array[row1][column1-1];
                } else {
                    letter1 = array[row1][array[row1].length-1];
                }
                if (column2 != 0) {
                    letter2 = array[row2][column2+1];
                } else {
                    letter2 = array[row2][array[row2].length-1];
                }
            } else if (column1 == column2) {
//                System.out.println("row = " + row1 + " column = " + column2
//                        + " letter = " + array[row1][column2]);
//                System.out.println("row = " + row2 + " column = " + column2
//                        + " letter = " + array[row2][column2]);
                if (row1 != 0) {
                    letter1 = array[row1-1][column1];
                } else {
                    letter1 = array[array.length-1][column1];
                }
                if (row2 != 0) {
                    letter2 = array[row2-1][column2];
                } else {
                    letter2 = array[array.length-1][column2];
                }
            } else {
                letter1 = array[row1][column2];
                letter2 = array[row2][column1];
            }

            sb.append(letter1).append(letter2);
            sb.append(" ");
        }

        System.out.println();
        return sb.toString();
    }

    // method to replace "I" or "J" as they share the same array index
    void replace(String letter) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (letter.equals("I")) {
                    if (array[i][j].equals("J")) {
                        array[i][j] = "I";
                        lastReplacedLetter = "J";
                        break;
                    }
                } else if (letter.equals("J")) {
                    if (array[i][j].equals("I")) {
                        array[i][j] = "J";
                        lastReplacedLetter = "I";
                        break;
                    }
                } else {
                    System.out.println("Wrong letter to replace");
                }
            }
        }
    }

    // method to undo replacing
    void undoReplace() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].equals("I")) {
                    if (lastReplacedLetter.equals("J")) {
                        array[i][j] = "J";
                    }
                } else if (array[i][j].equals("J")) {
                    if (lastReplacedLetter.equals("I")) {
                        array[i][j] = "I";
                    }
                }
            }
        }
    }
}
