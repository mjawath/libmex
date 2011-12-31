
package org.biz.app.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.smslib.AGateway;
import org.smslib.AGateway.Protocols;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
 

public class SmsGateWayUtil {
    
  private SerialModemGateway gateway;

 static Service service;
  
    public SmsGateWayUtil() {
        
        
//        try {
//      
//            initGateWay();
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
        
        
    }
  
  
  public void initGateWay(String portNumber,String smscNumber){
  
      try {
  Properties prop=new Properties();
  
  File dir=new File("props");
  dir.mkdir();
  
  File f=new File("props/data.prop");
          
      if(f.exists()){
      prop.load(new FileInputStream(f));
   String val=prop.getProperty("portnumber");
   String smsc=prop.getProperty("smscNumber");
   if(val!=null){
    
       System.out.println("port number is "+val);          
       System.out.println("smsc number is "+smsc);          
       
    gateway=new SerialModemGateway("modem."+portNumber,portNumber,115200,"HUAWEI Incorporated","e160");    
    gateway.setInbound(true);
    gateway.setOutbound(true);
    gateway.setSimPin("0000");
    gateway.setSmscNumber(smscNumber);// dialog
    gateway.setProtocol(Protocols.PDU);
   }   
   
      }    
      } catch (Exception e) {
      e.printStackTrace();
      }
  }
  
  public void startService()throws Exception{
  
      try {
          if(getGateway()!=null){
 service=Service.getInstance();
 
          OutboundNotification outboundNotification = new OutboundNotification();
         
service.setOutboundMessageNotification(outboundNotification);
service.addGateway(getGateway());
service.startService();



              System.out.println("service started....");
          }else{
              System.out.println("gateway is null..");
          }
      } catch (Exception e) {
      e.printStackTrace();
     throw e;
      }
  }
  
  public void stopService()throws Exception{
  
      try {
      service.stopService();    
      } catch (Exception e) {
        e.printStackTrace();
     throw e;
      }
      
  }
  
  public boolean sendSms(String phone,String message){
  
      boolean b=false;
      
      try {
    OutboundMessage msg = new OutboundMessage(phone,message);
	 
    
 boolean deli=service.sendMessage(msg);
    
          System.out.println("delivery is "+deli);
          System.out.println("failure cozz  is.. "+msg.getFailureCause());
          System.out.println("status is.. "+msg.getErrorMessage());
          
     if(!msg.getMessageStatus().FAILED.equals(OutboundMessage.MessageStatuses.FAILED)){
     
         b=false;
         return b;
         
          
     }else{
     
         b=deli;
     
     }
     
      } catch (Exception e) {
      e.printStackTrace();
      b=false;
      
      }
  
     return b;
      
  }
//////////////////////////////////////////////////////////
   public boolean sendBulkSms(List<String> numbers,String message){
  
      boolean b=false;
      
      try {
  List<OutboundMessage> lst=new ArrayList<OutboundMessage>();
          for (String phone : numbers) {
    OutboundMessage msg = new OutboundMessage(phone,message);
             lst.add(msg);
             
          }
 	 
    
 int deli=service.sendMessages(lst);
    
//          System.out.println("delivery is "+deli);
//          System.out.println("failure cozz  is.. "+msg.getFailureCause());
//          System.out.println("status is.. "+msg.getErrorMessage());
//          
//     if(!msg.getMessageStatus().FAILED.equals(OutboundMessage.MessageStatuses.FAILED)){
//     
//         b=false;
//         return b;
//         
//          
//     }else{
//     
//         b=deli;
//     
//     }
     
      } catch (Exception e) {
      e.printStackTrace();
      b=false;
      
      }
  
     return b;
      
  }
   ///////////////////////////////////////////////////////////////////

   
   public void readMessages()throws Exception{
   
       try {
           
 SmsInboundNotification in=new SmsInboundNotification();
 
 service.setInboundMessageNotification(in);
 
  
           
       } catch (Exception e) {
       e.printStackTrace();
       throw e;
       
       }
       
       
   }
   
   
   ///////////////////////////////////////////////////////////////////

   
   
   ///////////////////////////////////////////////////////////////////
 
   
   public SerialModemGateway getGateway() {
        return gateway;
    }

    /**
     * @param gateway the gateway to set
     */
    public void setGateway(SerialModemGateway gateway) {
        this.gateway = gateway;
    }
  
  	public class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(AGateway gateway, OutboundMessage msg)
		{
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}
	}

  
  
}
