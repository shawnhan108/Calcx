/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;

import java.util.Random;
import java.util.Scanner;
import static calcx.gcd.gcdtwo;

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
    
    public static int basechange(int Original, int Final, int Input) {
        
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
    
    public static int[] diophantine(int a, int b, int d) {
        
        int quotients[] = null; 
        int p; 
        int s;
        int i = 0;
        int r = d / gcdtwo(a, b);
        int acc = 0; 
        
        if (a > b) {
            
            p = a; 
            s = b;
            
        } else if (b > a) {
            
            p = b; 
            s = a; 
            
        } else {
            
            return new int[] {2 * r, -1 * r}; 
            
        }
        
        while ((p > 0) && (s > 0)) {
            
            System.out.println(quotients); 
            
            if (p % s == 0) {
                
                quotients[i] = p/s; 
                break; 
                
            }
            
            acc = ((p - p % s) / s);
            quotients[i] = acc; 
            
            if (p % s == 1) {
                
                break;
                
            }
            
            p = s;
            s = p % s; 
            i++; 
           
        }
        
        i = quotients.length - 1; 
        int u = 1;
        int v = - quotients[i];
        int k = 0; 
        
        while (i >= 0) {
            
            k = v; 
            v = u - v * quotients[i - 1]; 
            u = k; 
            
            i--;
            
        }
        
        
        if (((Math.abs(u) > Math.abs(v)) && (a > b)) || ((Math.abs(u) < Math.abs(v)) && (a < b))){
            
            return new int[] {r * v, r * u}; 
            
        } else {
            
            return new int[] {r * u, r * v}; 
            
        }
        
    }
    
    public static boolean coprime(int a, int b) {
        
        if (gcdtwo(a, b) == 1) {
            
            return true;
            
        } else {
            
            return false; 
            
        }
        
    }
    
    
    public static int[] unitmod(int n) {
        
        int[] unit = null; 
        int i = 1;
        int c = 0; 
        
        while (i < n){
            
            if (gcdtwo (n, i) == 1) {
            
                unit[c] = i; 
                i++;
                c++; 
            
            } else {
                
                i++;
                
            }   
            
        }
        
        return unit; 
        
    }
    
    public static int[] primemod(int n) {
        
        int[] unit = null; 
        int i = 1;
        int c = 0; 
        
        while (i < n){
            
            if (gcdtwo(n, i) == 1) {
            
                unit[c] = i; 
                i++;
                c++; 
            
            } else {
                
                i++;
                
            }   
            
        }
        
        return unit; 
        
    }
}
