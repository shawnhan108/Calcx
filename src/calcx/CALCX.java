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
import java.util.concurrent.Callable;
/**
 *
 * @author SHAWN
 */
public class CALCX {
    /**
     * @param args the command line arguments
     */
        public static int gcdCallable (String str){
                String4gl(str);
                int n = gcdcalc(numlist);
                return n;
        }        
        
        public static int lcmCallable (String str){
                String4gl(str);
                int n = lcmcalc(numlist);
                return (n);                    
        }
        public static String primeFacCallable (String str){
            int a = Integer.parseInt(str.substring (str.indexOf ("(")+1, str.indexOf(")")));
            return (primeFacOut(primeFac(a)));
        }
        public static Double maxCallable (String str){
            Double n = listmax(String4Double(str));
            return n;
        }
        public static Double minCallable (String str){
            Double n = listmin (String4Double(str));
            return n;
        }
        public static boolean primehuhCallable (String str){
            String4gl(str);
            return isPrime(numlist.get(0));
        }
        public static boolean factorhuhCallable (String str){
            String4gl(str);
            return (isFactor(numlist.get(0), numlist.get(1)));
        }
        public static boolean coprimeHuhCallable (String str){
            String4gl(str);
            return (isCoprime(numlist.get(0), numlist.get(1)));
        }
        public static double logCallable (String str){
            ArrayList<Double> temp = String4Double(str);
            return log (temp.get(0),temp.get(1));
        }
        public static int rmdCallable (String str){
            ArrayList<Integer> temp = String4Int(str);
            return remainder (temp.get(0), temp.get(1));
        }
        
        public static int changeBase10Callable (String str){
            ArrayList<Integer> temp = String4Int (str);
            return basechangeto10 (temp.get(0), temp.get(1));
        }
        
        public static int changeBaseCallable (String str){
            ArrayList<Integer> temp = String4Int (str);
            return baseChange (temp.get(0), temp.get(1),temp.get(2));
        }
        
        public static Double randCallable (String str){
            ArrayList<Integer> temp = String4Int (str);
            return rand(temp.get(0), temp.get(1),temp.get(2));
        }
        
        public static Integer randIntCallable (String str){
            ArrayList<Integer> temp = String4Int (str);
            return randint(temp.get(0),temp.get(1));
        }
        
        public static ArrayList<Integer> diophantineCallable (String str){
            ArrayList<Integer> temp = String4Int(str);
            return diophantine (temp.get(0),temp.get(1),temp.get(2));
        }
        


        public static void main(String[] args) throws Exception {
            //Store all functions in hashmap(s), first as the string, second as lambda expression
            mainWindow f = new mainWindow();
            f.setVisible(true);
            Map <String, Callable> funcMap = new HashMap<>();
            while (true){
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
            funcMap.put("gcd", ()->gcdCallable(str));
            funcMap.put("lcm", ()->lcmCallable(str));
            funcMap.put("primefac", ()->primeFacCallable(str));
            funcMap.put("max",()->maxCallable(str));
            funcMap.put("min",()->minCallable(str));
            funcMap.put("prime?", ()->primehuhCallable(str));
            funcMap.put("factor?", ()->factorhuhCallable(str));
            funcMap.put("coprime?", ()->coprimeHuhCallable(str));
            funcMap.put("sinrad",()->sinrad(String4Basic(str)));
            funcMap.put("sindeg",()->sindeg(String4Basic(str))); 
            funcMap.put("cosrad",()->cosrad(String4Basic(str)));
            funcMap.put("cosdeg",()->cosdeg(String4Basic(str)));
            funcMap.put("tanrad",()->tanrad(String4Basic(str)));
            funcMap.put("tandeg",()->tandeg(String4Basic(str)));
            funcMap.put("arcsinrad",()->arcsinrad(String4Basic(str)));
            funcMap.put("arcsindeg",()->arcsindeg(String4Basic(str))); 
            funcMap.put("arccosrad",()->arccosrad(String4Basic(str)));
            funcMap.put("arccosdeg",()->arccosdeg(String4Basic(str)));
            funcMap.put("arctanrad",()->arctanrad(String4Basic(str)));
            funcMap.put("arctandeg",()->arctandeg(String4Basic(str)));
            funcMap.put("log10",()->log10(String4Basic(str)));
            funcMap.put("ln",()->ln(String4Basic(str)));
            funcMap.put("log",()->logCallable(str));
            funcMap.put("remainder",()->rmdCallable(str));
            funcMap.put("base10", ()->changeBase10Callable(str));
            funcMap.put("baseChange",()->changeBaseCallable(str));
            funcMap.put("floor", ()->floor((int) String4Basic(str)));
            funcMap.put("ceiling", ()->ceiling((int) String4Basic(str)));
            funcMap.put("rand", ()->randCallable(str));
            funcMap.put("randint",()->randIntCallable(str));
            funcMap.put("diophantine",()->diophantineCallable(str));
            funcMap.put("unitmod",()->unitmod((int)String4Basic(str)));
            funcMap.put("primemod",()->primemod((int)String4Basic(str)));
            funcMap.put("irreducmod",()->irreducmod((int)String4Basic(str)));
            
            
            //if ((str.charAt(0) == 'g')&&(str.charAt(1) == 'c')&&(str.charAt(2) == 'd')){
            String command = str.substring(0,str.indexOf("("));
            command = command.replaceAll("\\s","");
            System.out.println(funcMap.get(command).call());
        }
    }
    
}
