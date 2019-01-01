/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import java.util.*;
import static calcx.gcd.*;
import static calcx.lcm.*;
import static calcx.prime.*;
import static calcx.Basicop.*; 
import static calcx.minmax.*;
import static calcx.PolyBasic.*;
import static calcx.PolyArith.*;
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
            //System.out.println(diophantine(-3973, 754, 29));           
            System.out.println("Please enter in the form of gcd (a1, a2, ..., an)");
            System.out.println("or enter in the form of lcm(a1,a2,...an)");
            System.out.println("or enter in the form of primefac (a)"); 
            System.out.println("or enter in the form of primefac (a)"); 
            System.out.println("or enter in the form of max(a1,a2,a3,...,an)");
            System.out.println("or enter in the form of min(a1,a2,a3,...,an)");
            System.out.println("prime?(a),factor?(a,b),coprime?(a,b)");
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
            else if ((str.charAt(0) == 'm')&&(str.charAt(1) == 'a')&&(str.charAt(2) == 'x')){
                try{                    
                    Double n = listmax(String4Double(str));
                    System.out.println(n);
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                }                 
            }
            else if ((str.charAt(0) == 'm')&&(str.charAt(1) == 'i')&&(str.charAt(2) == 'n')){
                try{                    
                    Double n = listmin(String4Double(str));
                    System.out.println(n);
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                }                 
            }
            else if ((str.charAt(0) == 'p')&&(str.charAt(1) == 'r')&&(str.charAt(2) == 'i')&&(str.charAt(3) == 'm')&&(str.charAt(4) == 'e')&&(str.charAt(5) == '?')){
                try{                    
                    String4gl(str);
                    System.out.println(isPrime(numlist.get(0)));
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                }                 
            }
            else if ((str.charAt(0) == 'f')&&(str.charAt(1) == 'a')&&(str.charAt(2) == 'c')&&(str.charAt(3) == 't')&&(str.charAt(4) == 'o')&&(str.charAt(5) == 'r')&&(str.charAt(6) == '?')){
                try{                    
                    String4gl(str);
                    System.out.println(isFactor(numlist.get(0), numlist.get(1)));
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                }                 
            }
            else if ((str.charAt(0) == 'c')&&(str.charAt(1) == 'o')&&(str.charAt(2) == 'p')&&(str.charAt(3) == 'r')&&(str.charAt(4) == 'i')&&(str.charAt(5) == 'm')&&(str.charAt(6) == 'e')&&(str.charAt(7) == '?')){
                try{                    
                    String4gl(str);
                    System.out.println(isCoprime(numlist.get(0), numlist.get(1)));
                    break;
                }
                catch (Exception e1){
                    System.out.println("Invalid input. Please try again.");
                }                 
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }

        }
    }
    
}
