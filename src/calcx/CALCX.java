/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import static calcx.gcd.String4gl;
import static calcx.gcd.gcdcalc;
import static calcx.gcd.numlist;
import static calcx.lcm.lcmcalc;
import static calcx.lcm.lcmtwo;
import static calcx.prime.isPrime;
import static calcx.prime.listPrime;
import static calcx.prime.primeFac;
import static calcx.prime.primeFacOut;
import java.util.*;
import java.util.stream.IntStream;
/**
 *
 * @author SHAWN
 */
public class CALCX {
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
            while (true){
            System.out.println("Please enter in the form of gcd (a1, a2, ..., an)");
            System.out.println("or enter in the form of lcm(a1,a2,...an)");
            System.out.println("or enter in the form of primefac (a)");
            Scanner sc = new Scanner (System.in);
            String input = sc.nextLine();
            String str = new String (input);
            if ((str.charAt(0) == 'g')&&(str.charAt(1) == 'c')&&(str.charAt(2) == 'd')){
                try{
                    String4gl(str);
                    int n = gcdcalc(numlist);
                    System.out.println(n);
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                } 
            }
            else if ((str.charAt(0) == 'l')&&(str.charAt(1) == 'c')&&(str.charAt(2) == 'm')){
                try{
                    String4gl(str);
                    int n = lcmcalc(numlist);
                    System.out.println(n);
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                } 
            }
            else if ((str.charAt(0) == 'p')&&(str.charAt(1) == 'r')&&(str.charAt(2) == 'i')&&(str.charAt(3) == 'm')&&(str.charAt(4) == 'e')&&(str.charAt(5) == 'f')&&(str.charAt(6) == 'a')&&(str.charAt(7) == 'c')){
                try{
                    int a = Integer.parseInt(str.substring (str.indexOf ("(")+1, str.indexOf(")")));
                    System.out.println(primeFacOut(primeFac(a)));
                    break;
                }
                catch (Exception e){
                    System.out.println("Invalid input. Please try again.");
                }
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }

        }
    }
    
}
