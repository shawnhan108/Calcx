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
            ArrayList<ArrayList<Double>> f1 = new ArrayList<ArrayList<Double>>();
            ArrayList<ArrayList<Double>> f2 = new ArrayList<ArrayList<Double>>();
            ArrayList<Double> ex1 = new ArrayList<Double>();
            ArrayList<Double> ex2 = new ArrayList<Double>();
            ArrayList<Double> ex3 = new ArrayList<Double>();
            ArrayList<Double> ex4 = new ArrayList<Double>();
            ArrayList<Double> ex5 = new ArrayList<Double>();
            ArrayList<Double> ex6 = new ArrayList<Double>();
            ex1.add(4.0);
            ex1.add(2.0);
            ex2.add(2.0);
            ex2.add(1.0);
            ex3.add(4.0);
            ex3.add(0.0);
            ex4.add(3.0);
            ex4.add(1.0);
            ex5.add(1.0);
            ex5.add(0.0);
            //ex6.add(6.0);
            //ex6.add(9.0);
            f1.add(ex1);
            f1.add(ex2);
            f1.add(ex3);
            f2.add(ex4);
            f2.add(ex5);
            //f2.add(ex6);
            System.out.println(4/3);
            System.out.println(f2);
            //System.out.println(intDivPoly(f1,f2)); 
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
