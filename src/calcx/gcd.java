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
public class gcd {
    public static ArrayList<Integer> numlist= new ArrayList();

    public static void String4gl (String str){
        //inteprets user inputs, convert into a list of two or more integers.
        String inp = str.substring (str.indexOf ("(")+1, str.indexOf(")"));
        inp = inp.replaceAll("\\s","");
        while (true){
            try {
                numlist.add(Integer.parseInt (inp));
                break;
            }
            catch (Exception e){
                String astr = inp.substring (0, inp.indexOf(","));
                String bstr = inp.substring (inp.indexOf (",")+1, inp.length());
                numlist.add(Integer.parseInt(astr));
                inp = bstr;
            }
    }
}

    public static int gcdtwo (int x, int y){
        //Calculates the gcd of two integers
        if (x<y){
            return (gcdtwo (y, x));
        }
        //assume (x>y)
        else if (y<0){
            return (gcdtwo(x, -y));
        }
        else if (x<0){
            return (gcdtwo(-x, y));
        }
        else if (x==0){
            return y;
        }
        else if (y==0){
            return x;
        }
        else if (x==1){
            return 1;
        }
        else if (y==1){
            return 1;
        }
        else{
            //perform GCDWR
            return (gcdtwo(y, x%y));
        }
    }

    public static int gcdcalc (ArrayList<Integer> lst){
        if (lst.size()==1){
            return (lst.get(0));
        }
        else{
            int newgcd = gcdtwo (lst.get(0), lst.get(1));
            lst.remove(1);
            lst.remove(0);
            lst.add(0, newgcd);
            return (gcdcalc (lst));
        }
    }
        public static void main(String[] args) {
        //Scans user input in the form of "gcd(a1,a2,..an)" and store the
        //numbers in a list.
        //System.out.println(Integer.parseInt (" 14"));
        while (true){
            System.out.println("Please enter in the form of gcd (a1, a2, ..., an)");
            Scanner sc = new Scanner (System.in);
            String input = sc.nextLine();
            String str = new String (input);
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
    }

}
