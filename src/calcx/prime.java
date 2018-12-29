/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import java.util.*;


/**
 *
 * @author SHAWN
 */
public class prime {
    
    public static ArrayList<Integer> listPrime (int a){
        //give a list of prime numbers under a given positive integer n>1.
        //use the method of sieve of Eratosthenes.
        //with runtime O(n log (log n))
        ArrayList<Integer> out = new ArrayList<Integer> ();
        ArrayList<Boolean> acc=new ArrayList<Boolean>(Arrays.asList(new Boolean[a+1]));
        Collections.fill(acc, Boolean.TRUE);
        for (int i = 2; i<= Math.sqrt(a);i++){
            for (int m = 2; m<= (a/i); m++){
                acc.set((i*m), Boolean.FALSE);
            }
        }
        for (int n = 2; n<=a; n++){
            if (acc.get(n)==Boolean.TRUE){
                out.add(n);
            }
        }
        return (out);
    }
    
    public static boolean isPrime (int a){
        //will be executed while interpreter reads prime?(a)
        //runtime O(sqrt(n))
        boolean out = true;
        if (a<2){
                out = false;
            }
        else {
            for (int i = 2; i <= Math.sqrt (a); i++){
            if (a%i == 0){
                out = false;
                break;
            }
            }
        }
        return (out);
    }
    
    public static ArrayList <ArrayList<Integer>> comb (ArrayList <ArrayList<Integer>> l1, ArrayList <ArrayList<Integer>> l2){
        //will be used in primFac
        //this method combines two 2D lists l1 and l2, 
        //with restriction that l1 only has length 1.
        //will have runtime O(n)
        boolean hasEle = false;
        for (int i = 0; i<= (l2.size() - 1);i++){
            if (l1.get(0).get(0) == l2.get(i).get(0)){
                hasEle = true;
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(l2.get(i).get(0));
                temp.add(1, l1.get(0).get(1)+l2.get(i).get(1));
                l2.remove(i);
                l2.add(i,temp);
                break;
                }
        }
        if (!(hasEle)){
            l2.add(l1.get(0));
        }
        return(l2);
    }
    
    public static boolean isFactor (int a, int b){
        if (b==0){
            if (a==0){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            if (a%b == 0){
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public static ArrayList <ArrayList<Integer>> primeFac (int a){
        //take an input in the form of an integer,
        //and return the prime factorization in a list of pairs (factor, power).
        //use a 2D list structure.
        //this method cannot deal with the conditions where a = 0 or 1. 
        ArrayList<ArrayList<Integer>> factorization = new ArrayList<ArrayList<Integer>>();
        if (isPrime(a)){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(a);
            temp.add(1,1);
            factorization.add(temp);
        }
        else if (a<0){
            return (primeFac(-a));
        }
        else {
            ArrayList<Integer> check = listPrime(a/2);
            ArrayList<Integer> checks = new ArrayList<Integer>();
            for (int h =0; h<check.size(); h++){
                if (a%(check.get(h))==0){
                    checks.add(check.get(h));
                }
            }
            for (int j =0;j<checks.size();j++){
                ArrayList<Integer> ele = new ArrayList<Integer>();
                ele.add(checks.get(j));
                int counter = 0;
                while (a%checks.get(j) == 0){
                    counter++;
                    a = a/checks.get(j);
                }
                ele.add(1, counter);
                factorization.add(ele);
            }
        }
        for (int i=0;i<factorization.size();i++){
            if (factorization.get(i).get(1)==0){
                factorization.remove(i);
            }
        }
        return (factorization);
    }
    
    public static String primeFacOut (ArrayList <ArrayList<Integer>> lst){
        //to formulae the output of primeFac better.
        String out = "";
        for (int i = 0; i< lst.size(); i++){
            out = out + lst.get(i).get(0)+"x"+lst.get(i).get(1)+"+";          
        }
        out = out.substring(0, out.length()-1);
        return (out);
    }
}