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
public class PolyBasic {
    public static int countDec (double num){
        //counts the number of decimal digits of num.
        String text = Double.toString(Math.abs(num));
        int intP = text.indexOf('.');
        int decP= text.length() - intP - 1;
        return decP;
    }
    
    public static double roundTo (double num, int precision){
        //takes in a double and round it to [precision] decimal places.
        if (countDec(num)<= precision){
            return num;
        }
        else{
            double mag = (Math.pow(10,precision));
            return (Math.round(num* mag))/mag;
        }
    }
    
    public static double calcVal (double a, ArrayList<ArrayList<Double>> f){
        //takes in a variable value and a polynomial in the form of 2D list
        //calculates the value of the polynomial, and round it to 2 decimals
        double result = 0;
        for (int i = 0; i<f.size();i++){
            double coeff = f.get(i).get(0);
            double exp = f.get(i).get(1); 
            double subval = coeff * (Math.pow(a, exp));
            result = result + subval;
        }
        return (roundTo(result, 2));
    }
    
    public static ArrayList<ArrayList<Double>> myAppend (ArrayList<ArrayList<Double>> f1, ArrayList<ArrayList<Double>> f2){
        //input two 2D lists, and append f2 on f1 by the second element in descending order.
        //assume f1 is already in descending order.
        ArrayList<ArrayList<Double>> out = f1;
        int temp = f1.size();
        int temp2 = f2.size();
        for (int i = 0; i<temp2;i++){
            for (int m = 0; m<temp;m++){
                if (f1.get(m).get(1) < f2.get(i).get(1)){
                    out.add(m,f2.get(i));
                    break;
                }
                else if (m == (temp -1)){
                    out.add(f2.get(i));
                }
            }
        }
        return f1;
    }
    
    public static ArrayList<ArrayList<ArrayList<Double>>> parent = new ArrayList<ArrayList<ArrayList<Double>>>();
    //this 3D list needs to be reset before each time want to merge sort a polynomial.
    
    public static ArrayList<ArrayList<Double>> rearrhelper (ArrayList<ArrayList<ArrayList<Double>>> f){
        //perform merge sort using recursion, runtime O(nlogn)
        System.out.println(f);
        if (f.size()==1){
            return (f.get(0));
        }
        else if (f.size() ==2){
            return (myAppend (f.get(0),f.get(1)));
        }
        else if ((f.size())%2 == 0){
            ArrayList<ArrayList<ArrayList<Double>>> parent1 = new ArrayList<ArrayList<ArrayList<Double>>>();
            while (f.size()>=2){
                ArrayList<ArrayList<Double>> temp1 = new ArrayList<ArrayList<Double>>();
                temp1 = myAppend (f.get(0),f.get(1));
                parent1.add(temp1);
                f.remove(1);
                f.remove(0);
            }
            parent = parent1;
            return(rearrhelper(parent));
        }
        else {
            ArrayList<ArrayList<ArrayList<Double>>> parent1 = new ArrayList<ArrayList<ArrayList<Double>>>();
            while(f.size()>=3){
                ArrayList<ArrayList<Double>> temp1 = new ArrayList<ArrayList<Double>>();
                temp1 = myAppend (f.get(0),f.get(1));
                parent1.add(temp1);
                f.remove(1);
                f.remove(0);
            }
            ArrayList<ArrayList<Double>> temp2 = parent.get(0);
            parent = parent1;
            parent.add(temp2); 
            return(rearrhelper(parent));
        }
    }
    
    public static ArrayList<ArrayList<Double>> rearr (ArrayList<ArrayList<Double>> f){
        //rearranges a polynomial f in descending order.
        //perform merge sort using recursion, runtime O(nlogn)
        //need to first map the 2D list into a 3D list.
        for (int i = 0; i < f.size();i++){
            ArrayList<ArrayList<Double>> temp = new ArrayList<ArrayList<Double>>();
            temp.add(f.get(i));
            parent.add(temp);
        }
        return (rearrhelper(parent));
    }
    
}