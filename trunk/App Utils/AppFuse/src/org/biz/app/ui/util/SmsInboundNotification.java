
package org.biz.app.ui.util;

import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Message.MessageTypes;
 

public class SmsInboundNotification implements IInboundMessageNotification{

    public void process(AGateway ag, MessageTypes mt, InboundMessage im) {
     
        try {
         System.out.println("originator is "+im.getOriginator());
                  
        String message=im.getText();
          if(message.equalsIgnoreCase("Restart")){
//       Runtime.getRuntime().exec("shutdown.exe -r -t 0");      
//      Runtime.getRuntime().exec("shutdown.exe -r -f");      
 //       new GateWayUtil().sendSms(message, im.getOriginator());
        }else if(message.equalsIgnoreCase("Shutdown")){
              Runtime.getRuntime().exec("shutdown.exe -r -t 0");      
   
        }
     
          ag.deleteMessage(im);
       
      
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        
    }
    
    
}
