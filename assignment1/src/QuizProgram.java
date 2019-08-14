import java.util.*;
import java.util.Scanner;

public class QuizProgram {
    public static void main(String[] args) {

        int n1, n2, c, ans;
        float gradeCount = 0;

        for (int d = 0; d < 5; d++) {
            Random rand = new Random();
            n1 = rand.nextInt(100); // nextInt method accepts int n and returns an int from 0 to (n-1)
            n2 = rand.nextInt(n1);
            c = rand.nextInt(2);
            if (c == 0) {
                System.out.print("What is the answer to " + n1 + " + " + n2 + " = ");
                ans = new Scanner(System.in).nextInt();
                if (n1 + n2 == ans) {
                    System.out.println("You are correct!");
                    gradeCount += 1;
                } else {
                    System.out.println("Sorry, the correct answer is " + (n1 + n2));

                }
            }
            else if (c == 1) {
                System.out.print("What is the answer to " + n1 + " - " + n2 + " = ");
                ans = new Scanner(System.in).nextInt();
                if (n1 - n2 == ans) {
                    System.out.println("You are correct!");
                    gradeCount += 1;
                } else {
                    System.out.println("Sorry, the correct answer is " + (n1 - n2));

                }
            }
        }

        float grade = (gradeCount/5)*100;
        System.out.println("You scored " + grade + "% on the quiz");
    }
}
