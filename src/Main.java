import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SymbolException {
        Scanner scr = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Entry text");
            String text = scr.nextLine();
            byte[] array = text.getBytes();

            try {
                checkSymbol(array);
                flag = false;
            } catch (SymbolException ex) {
                ex.printStackTrace();
            }

            try {
                upperLower(array);
            } catch (SymbolException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void checkSymbol(byte[] array) throws SymbolException {
        char l = ' ';
        int c = 0;
        for (byte symbol : array) {
            if (Character.isDigit(symbol)) {
                throw new SymbolException("Symbols return");
            }
            if (l == symbol) {
                c++;
            } else {
                l = (char)symbol;
                c = 1;
            }
            if (c == 3) {
                throw new SymbolException("Symbols return");
            }
        }
    }
    public static void upperLower(byte[] array) throws SymbolException {
        char symbol1 = ' ';
        char symbol2 = ' ';
        for(byte symbol : array) {
            if (symbol <= 90) {
                symbol1 = 1;
            } else {
                symbol1 = 2;
            }
            if (symbol <= 122) {
                symbol2 = 2;
            } else {
                symbol2 = 1;
            }
            if (symbol1 != symbol2) {
                throw new SymbolException("Different register");
            }
        }
    }
}