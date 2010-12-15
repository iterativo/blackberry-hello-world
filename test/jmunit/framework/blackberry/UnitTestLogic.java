package jmunit.framework.blackberry;

import java.util.Vector;
/*
 * UnitTestLogic.java
 *
 * Created on November 8, 2006, 12:32 PM
 *
 * @author jfisher
 */
public class UnitTestLogic extends Thread{
    static Vector resultsVector = new Vector();
    static Vector infoVector = new Vector();
    
    public void addResultArray(String[] result){
        try {
            resultsVector.addElement(result);
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
    
    public int getNumberofResults(){
        int resultsvectorSize = resultsVector.size();
        return resultsvectorSize;
    }
    
    public String[] getResultArray(int index){
        return (String[]) resultsVector.elementAt(index);
    }
    
     public void addInfoString(String info){
        try {
            infoVector.addElement(info);
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }
    
    public int getNumberofInfo(){
        int infovectorSize = infoVector.size();
        return infovectorSize;
    }
    
    public String[] getInfoArray(){
        String[] returnArray = new String[infoVector.size()];
        infoVector.copyInto(returnArray);
        return returnArray;
    }
    
    
}
