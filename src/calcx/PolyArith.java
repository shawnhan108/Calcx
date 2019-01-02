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
 * @author SHAWN and Allen
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
        if (f1.isEmpty()){
            return f2;
        }
        else if (f2.isEmpty()){
            return f1;
        }
        else{
            for (int i = 0; i<f2.size();i++){
                if (is2DMember(f1,f2.get(i))){
                    add2D(f1,f2.get(i));
                }
                else{
                    f1.add(f2.get(i));
                }
            }
        }
        return nozero(f1);
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
        return (nozero(f1));
    }
    
    public static ArrayList<ArrayList<Double>> derivative (ArrayList<ArrayList<Double>> f1){
        //finds the derivative of a polynomial 
        
        ArrayList<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> term = new ArrayList<Double>();
        for (int i = 0; i<f1.size();i++){
            
            term = f1.get(i); 
            term.set(0, term.get(0) * term.get(1));
            term.set(1, term.get(1) - 1); 
            
            result.add(i, term); 
            
        }
        
        result = (nozero(f1));
        
        return result;
    }
    
    public static ArrayList<ArrayList<Double>> multOne (ArrayList<ArrayList<Double>> f1, ArrayList<Double> f2){
        //multiply a polynomial by a monomial, takes O(length(f1))
        ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i<f1.size();i++){
            ArrayList<Double> temp = new ArrayList<>();
            temp.add(f1.get(i).get(0)* f2.get(0));
            temp.add(f1.get(i).get(1)+f2.get(1));
            out.add(temp);
        }
        return out;
    }
    
    public static ArrayList<ArrayList<Double>> multPoly (ArrayList<ArrayList<Double>> f1, ArrayList<ArrayList<Double>> f2){
        //multiply two polynomials f1, f2 together using multOne: O(n)
        //Altogether, takes O(length(f1)*length(f2))
        //efficiency may be improved if have more time.
        ArrayList<ArrayList<Double>> out = new ArrayList<>();
        for (int m = 0; m<f2.size();m++){
            ArrayList<ArrayList<Double>> temp = new ArrayList<>();
            temp = multOne(f1,f2.get(m));
            ArrayList<ArrayList<Double>>temp2 = addPoly(out,temp);
            out = temp2;
        }
        return (nozero(out));
    }
    
    
    public static double polyDeg (ArrayList<ArrayList<Double>> f){
        //returns the degree of the polynomial.
        ArrayList<ArrayList<Double>> temp = new ArrayList<ArrayList<Double>>();
        double deg = Double.NEGATIVE_INFINITY;
        for (int x = 0; x<f.size();x++){
            if (deg<f.get(x).get(1)){
                deg = f.get(x).get(1);
            }
        }
        return deg;
    }
    
    public static ArrayList<ArrayList<ArrayList<Double>>> Add3D (ArrayList<ArrayList<ArrayList<Double>>> f1, ArrayList<ArrayList<ArrayList<Double>>> f2){
        ArrayList<ArrayList<ArrayList<Double>>> out = new ArrayList<ArrayList<ArrayList<Double>>> ();
        out.add(addPoly(f1.get(0),f2.get(0)));
        out.add(addPoly(f1.get(1),f2.get(1)));
        return out;
    }
    //STILL HAVE A LOT OF BUGS.
    public static ArrayList<ArrayList<ArrayList<Double>>> intDivPoly (ArrayList<ArrayList<Double>> f1,ArrayList<ArrayList<Double>> f2){
        //calculates the result of f1 divided by f2, with quotient polynomial only having integer coefficients
        //output as a 3D list (a pair of 2D list), with first element as quotient and second as remainder.
        //needs to check if f2 is empty in interpreter.
        //THE OUTPUT SHOULD BE REARRANGED USING "REARR" FUNCTION IN INTERPRETER.
        ArrayList<ArrayList<Double>> p1 = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> p2 = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> zero = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> zeroUnit = new ArrayList<Double>();
        zeroUnit.add(0.0);
        zeroUnit.add(0.0);
        zero.add(zeroUnit); //now zero = [[0.0, 0.0]]
        ArrayList<ArrayList<ArrayList<Double>>> out = new ArrayList<ArrayList<ArrayList<Double>>>();
        ArrayList<ArrayList<Double>> empty = new ArrayList<ArrayList<Double>>();
        out.add(empty);
        out.add(empty);//now out = [[],[]]
        p1 = nozero(f1);
        p2 = nozero(f2);    
        while (true){
            if (p1.isEmpty()){
                out.set(0,addPoly(out.get(0),zero));
                out.set(1,addPoly(out.get(1),zero));
                return out;
            }
            else if (polyDeg(p1)<polyDeg(p2)){
                //quotient is zero, and remainder is p1.
                out.set(0,addPoly(out.get(0),zero));
                out.set(1,addPoly(out.get(1),p1));
                return out;
            }
            else if (polyDeg(p1)==polyDeg(p2)){
                ArrayList<Double> polyQuotient = new ArrayList<Double>();
                int quotient = (int)(p1.get(0).get(0)/p2.get(0).get(0));
                Double quotient1 = (double) quotient;
                polyQuotient.add(quotient1);
                polyQuotient.add(0.0);
                ArrayList<ArrayList<Double>>temp = new ArrayList<ArrayList<Double>>();
                temp.add(polyQuotient);
                out.set(0,addPoly(out.get(0),temp));
                ArrayList<ArrayList<Double>>remainder = new ArrayList<ArrayList<Double>>();
                remainder = subsPoly(p1,multPoly(p2,temp));
                out.set(1,addPoly(out.get(1),remainder));
                return out;
            }
            else{
                int quotient = (int)(p1.get(0).get(0)/p2.get(0).get(0));
                Double quotient1 = (double) quotient;

                if (quotient==0){
                    System.out.println("i was run");
                    System.out.println("p1 is: "+p1);                    
                    out.set(0, addPoly(out.get(0),zero));
                    out.set(1, addPoly(out.get(1),p1));
                    return out;
                }
                else {
                    System.out.println(out);
                    
                    ArrayList<Double> quotientUnit = new ArrayList<Double>();
                    quotientUnit.add(quotient1);
                    quotientUnit.add(p1.get(0).get(1)-p2.get(0).get(1));
                    System.out.println(quotientUnit);
                    ArrayList<ArrayList<Double>> component = new ArrayList<ArrayList<Double>>();
                    component.add(quotientUnit);
                    System.out.println(component);
                    out.set(0,addPoly(out.get(0),component));//finished adding quotient
                    p1 = subsPoly(p1,multPoly(p2,component));
                    System.out.println("later..."+out);
                    System.out.println("new P1"+p1);
                    System.out.println("new P2"+p2);
                    return (Add3D(out,intDivPoly(p1,p2)));
                }
            }
        }
    }
    
    //STILL HAVE BUGS
    public static ArrayList<ArrayList<ArrayList<Double>>> doubleDivPoly (ArrayList<ArrayList<Double>> f1,ArrayList<ArrayList<Double>> f2){
        //calculates the result of f1 divided by f2, with quotient polynomial having non-integer coefficients
        //output as a 3D list (a pair of 2D list), with first element as quotient and second as remainder.
        //needs to check if f2 is empty in interpreter.
        ArrayList<ArrayList<Double>> p1 = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> p2 = new ArrayList<ArrayList<Double>>();
        p1 = nozero(f1);
        p2 = nozero(f2);
        ArrayList<ArrayList<ArrayList<Double>>> out = new ArrayList<ArrayList<ArrayList<Double>>>();
        ArrayList<ArrayList<Double>> empty = new ArrayList<ArrayList<Double>>();
        out.add(empty);
        out.add(empty);//now out = [[],[]]
        ArrayList<ArrayList<Double>> zero = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> zeroUnit = new ArrayList<Double>();
        zeroUnit.add(0.0);
        zeroUnit.add(0.0);
        zero.add(zeroUnit); //now zero = [[0.0, 0.0]]
        while (true){
            if (p1.isEmpty()){
                out.set(0,addPoly(out.get(0),zero));
                out.set(1,addPoly(out.get(1),zero));
                return out;
            }
            else if (polyDeg(p1)<polyDeg(p2)){
                //quotient is zero, and remainder is p1.
                out.set(0,addPoly(out.get(0),zero));
                out.set(1,addPoly(out.get(1),p1));
                return out;
            }
            else if (polyDeg(p1)== polyDeg(p2)){
                double quotientOut = roundTo (p1.get(0).get(0)/p2.get(0).get(0),2);
                ArrayList<Double> quotientUnit = new ArrayList<Double>();
                quotientUnit.add(quotientOut);
                quotientUnit.add(0.0);
                ArrayList<ArrayList<Double>> quotient = new ArrayList<ArrayList<Double>>();
                quotient.add(quotientUnit);//quotient now is a 2D arrayList.
                out.set(0,addPoly(out.get(0),quotient));
                double realQuotient = p1.get(0).get(0)/p2.get(0).get(0);
                ArrayList<Double> realQuotientUnit = new ArrayList<Double>();
                realQuotientUnit.add(realQuotient);
                realQuotientUnit.add(0.0);
                ArrayList<ArrayList<Double>> realQuotientList = new ArrayList<ArrayList<Double>>();
                realQuotientList.add(realQuotientUnit);
                ArrayList<ArrayList<Double>> remainder = new ArrayList<ArrayList<Double>>();
                remainder = subsPoly(p1,multPoly(p2,realQuotientList));
                out.set(1,addPoly(out.get(1),remainder));
                return out;
            }
            else{
                double quotientCoeff = roundTo (p1.get(0).get(0)/p2.get(0).get(0),2);
                ArrayList<Double> quotientUnit = new ArrayList<Double>();
                quotientUnit.add(quotientCoeff);
                quotientUnit.add(p1.get(0).get(1)-p2.get(0).get(1));
                ArrayList<ArrayList<Double>> quotient = new ArrayList<ArrayList<Double>>();
                quotient.add(quotientUnit);//this is the current component of the quotient.
                ArrayList<ArrayList<Double>> oldQuotient = out.get(0);
                out.set(0, addPoly(oldQuotient,quotient));
                //now the quotient in output is updated.
                double realQuotient = p1.get(0).get(0)/p2.get(0).get(0);
                ArrayList<Double> realQuotientUnit = new ArrayList<Double>();
                realQuotientUnit.add(realQuotient);
                realQuotientUnit.add(p1.get(0).get(1)-p2.get(0).get(1));
                ArrayList<ArrayList<Double>> realQuotientList = new ArrayList<ArrayList<Double>>();
                realQuotientList.add(realQuotientUnit);//this is the real current component of the quotient.
                p1= subsPoly(p1,multPoly(p2,realQuotientList));
                return (Add3D (out,doubleDivPoly(p1,p2)));
            }
        }
    }
    
    public static double plugin (double x, ArrayList<ArrayList<Double>> f) {
        
        int i = f.size(); 
        ArrayList<Double> term = new ArrayList<Double>();
        double ANS = 0; 
        
        while (i > 0) {
            
            i--;
            term = f.get(i); 
            ANS = ANS + term.get(0) * StrictMath.pow(x, term.get(1)); 
            
        } 
        
        return ANS; 
        
    } 
    
    public static double findroot (double a, double b, ArrayList<ArrayList<Double>> f) {
        // Need Interpreter to check that f(a) and f(b) has different sign or else cannot use this function
        // Need Interpreter to then check this function actually gives a value between a and b. 
        double x = (a + b)/2; 
        double ANS = x - plugin(x, f) / plugin(x, derivative(f)); 
        
        while (StrictMath.abs(plugin(ANS, f) - 0) > 0.0000000000000001) {
            
            ANS = ANS - plugin(ANS, f) / plugin(ANS, derivative(f)); 
            
        }
        
        return ANS; 
        
    } 
    
}
