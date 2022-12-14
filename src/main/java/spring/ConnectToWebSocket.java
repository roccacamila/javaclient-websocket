package spring;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import java.lang.reflect.Type;


public class ConnectToWebSocket extends StompSessionHandlerAdapter{
	
	 @Override
	 public void afterConnected(StompSession session, StompHeaders headers) {
		 session.subscribe("/topic/cliente", this); //reemplazar cliente por el nombre del m?dulo que corresponda
	     String message = "one-time message from client";
	     session.send("/app/cliente", message); //reemplazar cliente por el nombre del m?dulo que corresponda
	 }
	 
	 @Override
	 public Type getPayloadType(StompHeaders headers) {
		 return Mensaje.class;
	  }
	 
	  @Override
	  public void handleFrame(StompHeaders headers, Object payload) {
		  Mensaje msg = (Mensaje) payload;
		  System.out.println("Contenido:"+msg.getContenido() + " - Emisor:"+msg.getEmisor());
	   }
	   
	   @Override
	   public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
		   System.out.println("Error: "+exception.getMessage());
	   }
	   @Override
	   public void handleTransportError(StompSession session, Throwable exception) {
		   System.out.println("Error: "+exception.getMessage());
	   }

}
