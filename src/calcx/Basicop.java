/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;

import java.util.Random;
import java.util.Scanner;
import static calcx.gcd.gcdtwo;
import java.util.ArrayList;
import static calcx.prime.*;

/**
 *
 * @author zhang
 */
public class Basicop {
    
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in); 
        boolean running = true;
        
        double m = arcsindeg(0.5);
        double v = Math.log(-2); 
        System.out.println(m);
        System.out.println(v);
        System.out.println(basechangeto10(3, 1201));
        
        while (running) {
            
            String input = k.next(); 
            
        }
    }
    
    public static double sinrad(double theta) {
        double ANS = StrictMath.sin(theta); 
        return ANS;     
    }
    
    public static double sindeg(double theta) {
        double ANS = StrictMath.sin(StrictMath.toDegrees(theta)); 
        return ANS; 
    }
    
    public static double cosrad(double theta) {
        double ANS = StrictMath.cos(theta); 
        return ANS;     
    }
    
    public static double cosdeg(double theta) {
        double ANS = StrictMath.cos(StrictMath.toDegrees(theta)); 
        return ANS; 
    }
    
    public static double tanrad(double theta) {
        double ANS = StrictMath.tan(theta); 
        return ANS;     
    }
    
    public static double tandeg(double theta) {
        double ANS = StrictMath.tan(StrictMath.toDegrees(theta)); 
        return ANS; 
    }
    
    public static double arcsinrad(double ratio) {
        double ANS = StrictMath.asin(ratio); 
        return ANS;     
    }
    
    public static double arcsindeg(double ratio) {
        double ANS = StrictMath.toDegrees(StrictMath.asin(ratio)); 
        return ANS; 
    }
    
    public static double arccosrad(double ratio) {
        double ANS = StrictMath.acos(ratio); 
        return ANS;     
    } 
    
    public static double arccosdeg(double ratio) {
        double ANS = StrictMath.toDegrees(StrictMath.acos(ratio)); 
        return ANS; 
    }
    
    public static double arctanrad(double ratio) {
        double ANS = StrictMath.atan(ratio); 
        return ANS;     
    }
    
    public static double arctandeg(double ratio) {
        double ANS = StrictMath.toDegrees(StrictMath.atan(ratio)); 
        return ANS; 
    }
    
    public static double log10(double num) {
        double ANS = StrictMath.log10(num);
        return ANS; 
    }
    
    public static double ln(double num) {
        double ANS = StrictMath.log(num);
        return ANS; 
    }
    
    public static double log(double base, double num) {
        double ANS = (StrictMath.log(num))/(StrictMath.log(base)); 
        return ANS;
    }
    
    public static int remainder(int dividend, int divisor) {
        int ANS = (dividend % divisor); 
        return ANS;
    } 
    
    public static int basechangeto10(int Original, int Input) {
        int k = Input; 
        int i = (k % 10);
        int b = Original; 
        
        while (k > 0) {
            k = ((k - (k % 10)) / 10);
            i = i + (k % 10) * b; 
            b = b * Original;     
        } 
        
        return i; 
        
    }
    
    public static int Maxpow(int Final, int Input) {
        int k = Input;
        int b = Final; 
        int e = 0; 
        while (k >= StrictMath.pow(Final, e)) {
            e++;    
        } 
        
        return (e - 1); 
        
    }
    
    public static int integerpower(int b, int e) {
        
        int i = 1;
        
        while (e > 0) {
            
            i = i * b; 
            e--; 
            
        }
        
        return i; 
    }
    
    public static int basechangefrom10(int Final, int Input, int maxpow) {
        int k = Input; 
        int e = maxpow; 
        int i = 0;
        int b = Final; 
        
        while (k >= 0) {
            
            int d = integerpower(b, e);             
            i = 10 * i + (k - (k % d)) / d; 
            k = (k % d);
            e--;     
        } 
        
        return i; 
        
    }
    
    public static int baseChange(int Original, int Final, int Input) {
        
        int ANS = basechangefrom10(Final, basechangeto10(Original, Input), Maxpow(Final, Input)); 
        return ANS; 
        
    }
    
    public static double floor(int num) {
        
        double c = StrictMath.floor(num); 
        
        return c; 
        
    }
    
    public static double ceiling(int num) {
        
        double c = StrictMath.ceil(num);
        
        return c; 
        
    }
    
    public static double rand(int lower, int upper, int decimal) {
        
        Random r = new Random();
        int c = integerpower(10, decimal); 
        double ANS = (lower + (r.nextInt (c *(upper - lower)))) / c; 
        
        return ANS; 
        
    }

    public static int randint(int lower, int upper) {
        
        Random r = new Random();
        int ANS = lower + (r.nextInt (upper - lower)); 
        
        return ANS;
        
    }
    
    public static ArrayList<Integer> diophantine(int a, int b, int d) {
        //Solve any diophantine equation in the form of ax+by=d.
        //output as a list with two elements, [x,y].
        ArrayList<Integer> quotients = new ArrayList<Integer>();
        int p; 
        int s;
        int i = 0;
        int r = d / gcdtwo(a, b);
        int acc = 0; 
        
        if (a % b == 0) {
            
            quotients.add(0, r);
            quotients.add(1, (- (a / b) + 1) *r);
            return quotients; 
            
        } else if (b % a == 0) {
            
            quotients.add(0, (- (b / a) + 1) * r);
            quotients.add(1, r);
            return quotients; 
            
        } else if (StrictMath.abs(a) > StrictMath.abs(b)) {
            
            p = a;
            s = b;
            
            if (a < 0) {
                
                p = -a; 
                
            }
            
            if (b < 0) {
                
                s = -b;
                
            }  
            
        } else if (StrictMath.abs(b) > StrictMath.abs(a)) {
            
            p = b; 
            s = a; 
            
            if (b < 0) {
                
                p = -b; 
                
            }
            
            if (a < 0) {
                
                s = -a;
                
            } 
            
        } else {
            
            quotients.add(0,2*r);
            quotients.add(1,-1*r);
            return quotients; 
 
        } 
        
        
        //now assume p>s, perform Euclidian Algorithm
        while ((p > 0) && (s > 0)) {
            
            if (p % s == 0 || p % s == 1) {
                
                break; 
                
            }
            
            acc = ((p - p % s) / s);
            quotients.add(i, acc);
            
            acc = p; 
            p = s;
            s = acc % s; 
            i++; 
            
           
        }
        
        i = quotients.size() - 1; 
        int u = 1;
        int v = - quotients.get(i);
        int k = 0; 
        
        while (i > 0) {
            
            k = v; 
            v = u - v * quotients.get(i-1);
            u = k; 
            
            i--;
            
        }
        
        ArrayList<Integer> output = new ArrayList <Integer>();
        
        if (a*u*r + b*v*r == d) {
            output.add(0, r*u);
            output.add(1, r*v);
        } else if (-a*u*r + b*v*r == d){
            output.add(0, -r*u);
            output.add(1, r*v);
        } else if (a*u*r - b*v*r == d){
            output.add(0, r*u);
            output.add(1, -r*v);
        } else if (-a*u*r - b*v*r == d){
            output.add(0, -r*u);
            output.add(1, -r*v);
        } else if (a*v*r + b*u*r == d) {
            output.add(0, r*v);
            output.add(1, r*u);
        } else if (-a*v*r + b*u*r == d) {
            output.add(0, -r*v);
            output.add(1, r*u);
        } else if (a*v*r - b*u*r == d) {
            output.add(0, r*v);
            output.add(1, -r*u);
        } else if (-a*v*r - b*u*r == d) {
            output.add(0, -r*v);
            output.add(1, -r*u);
        }
        
            return output;
       
        }

        public static boolean isCoprime(int a, int b) {

            if (gcdtwo(a, b) == 1) {

                return true;

            } else {

                return false; 

            }

        }


        public static ArrayList<Integer> unitmod(int n) {

            ArrayList<Integer> unit = new ArrayList <Integer>(); 
            int i = 1;
            int c = 0; 

            while (i < n){

                if (gcdtwo (n, i) == 1) {

                    unit.add(c, i); 
                    i++;
                    c++; 

                } else {

                    i++;

                }   

            }

            return unit; 
        
    }
    
    public static ArrayList<Integer> primemod(int n) {
        
        ArrayList<Integer> prime = new ArrayList <Integer>(); 
        int i = 1;
        int c = 0; 
        
        while (i < n){
            
            if (isPrime (gcdtwo (n, i))) {
            
                prime.add(c, i); 
                i++;
                c++; 
            
            } else {
                
                i++;
                
            }   
            
        }
        
        return prime; 
        
    }
    
    public static ArrayList<Integer> irreducmod(int n) {
        
        ArrayList<Integer> irreducibles = new ArrayList <Integer>(); 
        int i = 1;
        int c = 0; 
        
        while (i < n){
            
            if ((isPrime (gcdtwo (n, i))) && (n % integerpower(i, 2) == 0)) {
            
                irreducibles.add(c, i); 
                i++;
                c++; 
            
            } else {
                
                i++;
                
            }   
            
        }
        
        return irreducibles; 
        
    }
    
}
