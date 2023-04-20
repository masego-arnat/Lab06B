
    import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab6B {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Number of lines of Program: ");
        int lines = input.nextInt();
        input.nextLine(); // Consume the newline character

        for (int i = 1; i <= lines; i++) {
            System.out.print("Enter String#" + i + ": ");
            String str = input.nextLine();

            StringTokenizer st = new StringTokenizer(str, "+-*/ ", true);

            int count = 0;
            boolean operatorFlag = false;
            boolean identifierFlag = false;
            String previousToken = "";
            // System.out.print("Output =\n");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.matches("[A-Za-z]")) {
                    if (operatorFlag || (previousToken.matches("[A-Za-z]") && !previousToken.equals(token))) {
                        System.out.println("#" + count + " SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
                        System.out.println("CONCLUSION-->Wrong expression: " + str + " No Derivation done! PLS RE-ENTER A VALID STRING");
                        break;
                    } else {
                        identifierFlag = true;
                    }
                } else if (token.matches("[+\\-*/]")) {
                    if (operatorFlag || !identifierFlag) {
                        System.out.println("#" + count + " SEMANTIC ERROR- two operators (*,-,+,/) or Identifier (A to Z and a to z) cannot be written together!");
                        System.out.println("CONCLUSION-->Wrong expression: " + str + " No Derivation done! PLS RE-ENTER A VALID STRING");
                        break;
                    } else {
                        operatorFlag = true;
                    }
                } else {
                    System.out.println("#" + count + " SYNTAX ERROR- Use of Special Characters ie &, &&, $, %, !, , etc, not permitted.");
                    System.out.println("CONCLUSION-->Wrong expression: " + str + " No Derivation done! PLS RE-ENTER A VALID STRING");
                    break;
                }
                previousToken = token;
                count++;
            }
            if (count > 0 && !operatorFlag) {
                System.out.println("#" + count + " SEMANTIC ERROR -Invalid String! There is no operator in the String ( +, /, -, * )");
                System.out.println("CONCLUSION-->Wrong expression: " + str + " No Derivation done! PLS RE-ENTER A VALID STRING");
            } else if (count == 0 || !identifierFlag) {
                System.out.println("#" + count + " SYNTAX ERROR- Numbers 0,1 to 9 are not allowed. String should contain A to Z and a to z & operators +,-,*,/");
                System.out.println("CONCLUSION-->Wrong expression: " + str + " No Derivation done! PLS RE-ENTER A VALID STRING");
            } else {
                System.out.println("TOTAL NUMBER OF TOKENS FOR STRING#" + i + ":" + count);
                System.out.println("END OF STRING#" + i);
                if (i < lines) {
                    System.out.println("===================");
                }
            }
        }
        input.close();
    }


         
            
                    



    // public static void main(String[] args) {
    //     Scanner input = new Scanner(System.in);

    //     System.out.print("Enter Number of lines of Program: ");
    //     int lines = input.nextInt();
    //     input.nextLine(); // Consume the newline character

    //     for (int i = 1; i <= lines; i++) {
    //         System.out.print("Enter String#" + i + ": ");
    //         String str = input.nextLine();

    //         StringTokenizer st = new StringTokenizer(str, "+-*/ ", true);

    //         int count = 0;
    //         boolean hasSyntaxError = false;
    //         System.out.print("Output =\n");
    //         while (st.hasMoreTokens()) {
    //             String token = st.nextToken();
    //             if (token.matches("[A-Za-z]+")) {
    //                 count++;
    //                 System.out.println("TOKEN#" + count + " " + token + " Identifier");
    //             } else if (token.matches("[+\\-*/]")) {
    //                 count++;
    //                 System.out.println("TOKEN#" + count + " " + token + " operator");
    //             } else if (!token.trim().isEmpty()) {
    //                 hasSyntaxError = true;
    //                 System.out.println("SYNTAX ERROR: \"" + token + "\" is not a valid token");
    //             }
    //         }
    //         if (!hasSyntaxError) {
    //             System.out.println("TOTAL NUMBER OF TOKENS FOR STRING#" + i + ":" + count);
    //             System.out.println("END OF STRING#" + i);
    //             if (i < lines) {
    //                 System.out.println("===================");
    //             }
    //         } else {
    //             System.out.println("SYNTAX ERROR(S) DETECTED IN STRING#" + i);
    //         }
    //     }
    //     input.close();
    // }

}

