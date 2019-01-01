/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import java.util.ArrayList;
import static calcx.PolyBasic.*;
import java.util.Objects;

/**
 *
 * @author SHAWN
 */
public class PolyArith {
    public static double polySummation (int lower, int upper, ArrayList<ArrayList<Double>> f){
        //summation
        if (lower > upper){
            return 0;
        }
        else{
            double sum = 0;
            for (int i = lower; i<= upper; i++){
            sum = sum + calcVal (i, f);
            }
            return sum;
        }       
    }
    
    public static double polyProduct (int lower, int upper, ArrayList<ArrayList<Double>> f){
        //product
        if (lower > upper){
            return 1;
        }
        else{
            double product = 1;
            for (int i = lower; i<= upper; i++){
                product = product * calcVal (i, f);
            }
            return product;
        }
    }
    
    public static boolean is2DMember (ArrayList<ArrayList<Double>> lst1, ArrayList<Double> lst2){
        //checks if a list is a member of 2D list, signalled by the second element (exponent).
        boolean out = false;
        for (int i = 0; i<lst1.size();i++){
            if (Objects.equals(lst2.get(1), lst1.get(i).get(1))){
                out = true;
                break;
            }
        }
        return out;
    }
    
    public static ArrayList<ArrayList<Double>> add2D (ArrayList<ArrayList<Double>> lst1, ArrayList<Double> lst2){
        //insert a list into a 2D list
        //assume lst2 is already a member of lst1, according to function is2DMember
        for (int i = 0; i<lst1.size();i++){
            if (Objects.equals(lst2.get(1), lst1.get(i).get(1))){
                ArrayList<Double> temp = new ArrayList<Double>();
                temp.add(lst2.get(0)+lst1.get(i).get(0));
                temp.add(lst2.get(1));
                lst1.add(i,temp);
                lst1.remove(i+1);
                break;
            }
        }
        return lst1;
    }
    
    public static ArrayList<ArrayList<Double>> subs2D (ArrayList<ArrayList<Double>> lst1, ArrayList<Double> lst2){
        //insert a list into a 2D list
        //assume lst2 is already a member of lst1, according to function is2DMember
        for (int i = 0; i<lst1.size();i++){
            if (Objects.equals(lst2.get(1), lst1.get(i).get(1))){
                ArrayList<Double> temp = new ArrayList<Double>();
                temp.add(lst1.get(i).get(0)-lst2.get(0));
                temp.add(lst2.get(1));
                lst1.add(i,temp);
                lst1.remove(i+1);
                break;
            }
        }
        return lst1;
    }
    
    public static ArrayList<ArrayList<Double>> nozero (ArrayList<ArrayList<Double>> f){
        //if coefficient = 0, then remove that component.
        for (int i = 0; i<f.size();i++){
            if (f.get(i).get(0)==0){
                f.remove(i);
            }
        }
        return (f);
    }
       
    public static ArrayList<ArrayList<Double>> addPoly (ArrayList<ArrayList<Double>> f1, ArrayList<ArrayList<Double>> f2){
        //add two polynomials together by merging two 2D arraylists f1,f2 together.
        //assume f1 is output.
        for (int i = 0; i<f2.size();i++){
            if (is2DMember(f1,f2.get(i))){
                add2D(f1,f2.get(i));
            }
            else{
                f1.add(f2.get(i));
            }
        }
        System.out.println(f1);
        return (nozero(rearr(f1)));
    }
    
    public static ArrayList<ArrayList<Double>> subsPoly (ArrayList<ArrayList<Double>> f1, ArrayList<ArrayList<Double>> f2){
        //substract polynomial f1 by f2 
        for (int i = 0; i<f2.size();i++){
            if (is2DMember(f1,f2.get(i))){
                subs2D(f1,f2.get(i));
            }
            else{
                ArrayList<Double> temp = new ArrayList<Double>();
                temp.add(-1*(f2.get(i).get(0)));
                temp.add(f2.get(i).get(1));
                f1.add(temp);
            }
        }
        return (nozero(rearr(f1)));
    }
}