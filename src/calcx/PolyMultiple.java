/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import static calcx.PolyBasic.*;
import static calcx.PolyArith.*;
import java.util.*;

/**
 *
 * @author SHAWN
 */
public class PolyMultiple {
    public static ArrayList<ArrayList<Double>> addPolyMultiple (ArrayList<ArrayList<ArrayList<Double>>> lst){
        ArrayList<ArrayList<Double>> acc = lst.get(0);
        lst.remove(0);
        for (int x=0; x<lst.size();x++){
            acc = addPoly(acc,lst.get(x));
        }
        return acc;
    }
    
    public static ArrayList<ArrayList<Double>> subPolyMultiple (ArrayList<ArrayList<ArrayList<Double>>> lst){
        ArrayList<ArrayList<Double>> acc = lst.get(0);
        lst.remove(0);
        for (int x=0; x<lst.size();x++){
            acc = subsPoly(acc,lst.get(x));
        }
        return acc;
    }
    
    public static ArrayList<ArrayList<Double>> multPolyMultiple (ArrayList<ArrayList<ArrayList<Double>>> lst){
        ArrayList<ArrayList<Double>> acc = lst.get(0);
        lst.remove(0);
        for (int x=0; x<lst.size();x++){
            acc = multPoly(acc,lst.get(x));
        }
        return acc;
    }
}
