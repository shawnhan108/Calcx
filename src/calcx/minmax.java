/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import java.util.*;
import java.lang.*;
/**
 *
 * @author SHAWN
 */
public class minmax {
        public static ArrayList<Double> String4Double (String str){
        //inteprets user inputs, convert into a list of two or more doubles.
        ArrayList<Double> output = new ArrayList<Double>();
        String inp = str.substring (str.indexOf ("(")+1, str.indexOf(")"));
        inp = inp.replaceAll("\\s","");
        while (true){
            try {
                output.add(Double.parseDouble (inp));
                break;
            }
            catch (Exception e){
                String astr = inp.substring (0, inp.indexOf(","));
                String bstr = inp.substring (inp.indexOf (",")+1, inp.length());
                output.add(Double.parseDouble(astr));
                inp = bstr;
            }
        }
        return output;
}
        
        
        public static ArrayList<Integer> String4Int (String str){
        //inteprets user inputs, convert into a list of two or more doubles.
        ArrayList<Integer> output = new ArrayList<Integer>();
        String inp = str.substring (str.indexOf ("(")+1, str.indexOf(")"));
        inp = inp.replaceAll("\\s","");
        while (true){
            try {
                output.add(Integer.parseInt (inp));
                break;
            }
            catch (Exception e){
                String astr = inp.substring (0, inp.indexOf(","));
                String bstr = inp.substring (inp.indexOf (",")+1, inp.length());
                output.add(Integer.parseInt(astr));
                inp = bstr;
            }
        }
        return output;
}   
    public static double listmin (ArrayList<Double> lst){
        //returns the smallest element in a list, with runtime O(n)
        double min = Double.POSITIVE_INFINITY;
        for (int x = 0; x< lst.size();x++){
            if (lst.get(x)< min){
                min = lst.get(x);
            }
        }
        return (min);
    }
    
    public static double listmax (ArrayList<Double> lst){
        //returns the largest element in a list, with runtime O(n)
        double max = Double.NEGATIVE_INFINITY;
        for (int x = 0; x< lst.size();x++){
            if (lst.get(x)>max){
                max = lst.get(x);
            }
        }
        return (max);
    }
}
