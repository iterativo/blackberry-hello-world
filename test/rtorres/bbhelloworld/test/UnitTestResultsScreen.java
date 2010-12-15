package rtorres.bbhelloworld.test;

import jmunit.framework.blackberry.UnitTestLogic;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

/*
 * unittestresultsScreen.java
 *
 * Created on November 8, 2006, 12:29 PM
 * RIM Blackberry Screen Class
 *
 * @author jfisher
 */
public class UnitTestResultsScreen extends MainScreen 
{
    int numberofResults;
    UnitTestLogic utl = new UnitTestLogic();
    Bitmap green = Bitmap.getBitmapResource("green.png");
    Bitmap red = Bitmap.getBitmapResource("red.png");
    Bitmap cross = Bitmap.getBitmapResource("cross.png");
    Bitmap icon = Bitmap.getBitmapResource("buniticon.png");
    VerticalFieldManager vfm1 = new VerticalFieldManager();
    VerticalFieldManager vfm2 = new VerticalFieldManager();
    VerticalFieldManager vfm3 = new VerticalFieldManager();
    VerticalFieldManager vfm4 = new VerticalFieldManager();
    HorizontalFieldManager hfm = new HorizontalFieldManager();
    int pass = 0;
    int fail = 0;
    
    /** Creates a new instance of unittestresultsScreen */
    public UnitTestResultsScreen() {
        try{
            FontFamily theFam = FontFamily.forName("SYSTEM");
            net.rim.device.api.ui.Font theFont = theFam.getFont(net.rim.device.api.ui.Font.PLAIN, 12);
            net.rim.device.api.ui.Font.setDefaultFont(theFont);
        }catch(Exception e){
            
        }
        vfm1.add(new BitmapField(cross));
        vfm2.add(new LabelField("Method: "));
        vfm3.add(new LabelField("Test: "));
        vfm4.add(new LabelField("Result: "));
        
        numberofResults = utl.getNumberofResults();
        for(int i = 0 ; i < numberofResults ; i++){
            String[] resultArray = utl.getResultArray(i);
            if(resultArray[2].equals("pass")){
                vfm1.add(new BitmapField(green));
                pass++;
            }else{
                vfm1.add(new BitmapField(red));
                fail++;
            }
            vfm2.add(new LabelField(resultArray[0] + " "));
            vfm3.add(new LabelField(resultArray[1] + " "));
            vfm4.add(new LabelField(resultArray[2] + " ", Field.FOCUSABLE));
        }
        
        vfm1.add(new BitmapField(cross));
        vfm2.add(new LabelField(""));
        vfm3.add(new LabelField(""));
        
        vfm1.add(new BitmapField(cross));
        vfm2.add(new LabelField("Pass: "));
        vfm3.add(new LabelField("" + pass));
        
        vfm1.add(new BitmapField(cross));
        vfm2.add(new LabelField("Fail: "));
        vfm3.add(new LabelField("" + fail));
        
        vfm1.add(new BitmapField(cross));
        vfm2.add(new LabelField("Total: "));
        vfm3.add(new LabelField("" + numberofResults));

        hfm.add(vfm1);
        hfm.add(vfm2);
        hfm.add(vfm3);
        hfm.add(vfm4);
        add(new BitmapField(icon));
        add(new SeparatorField());
        add(hfm);
        add(new SeparatorField());
        add(new LabelField("Details:"));
        String[] reportsArray = utl.getInfoArray();
        for(int i = 0 ; i < reportsArray.length; i++){
            add(new LabelField(reportsArray[i], Field.FOCUSABLE));
        }
    }
    
    /** Standard Escape-key handler */
    public boolean keyChar(char key, int status, int time) {
        boolean retval = false;
        switch (key) {
            case Characters.ESCAPE:
                System.exit(1);
                break;
            default:
                retval = super.keyChar(key, status, time);
        }
        return retval;
    }
}