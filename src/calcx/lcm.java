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
public class lcm {
    public static int lcmtwo (int a, int b){
        if (a==0){
            return 0;
        }
        else if (b==0){
            return 0;
        }
        else if (a<0){
            return (lcmtwo (-a,b));
        }
        else if (b<0){
            return (lcmtwo (a, -b));
        }
        else if (a==1){
            return b;
        }
        else if (b==1){
            return a;
        }
        else {
            int temp = 1;
            while (!((temp%a==0)&&(temp%b==0))){
                temp++;
            }
            return temp;
        }
    }
    public static int lcmcalc (ArrayList<Integer> lst){
        if (lst.size()==1){
            return (lst.get(0));
        }
        else{
            int newlcm = lcmtwo (lst.get(0), lst.get(1));
            lst.remove(1);
            lst.remove(0);
            lst.add(0, newlcm);
            return (lcmcalc (lst));
        }
    }
}

