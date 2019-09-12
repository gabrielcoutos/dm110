package mdb;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import dao.AuditoriaDAO;
import entity.Auditoria;
import model.ProductModel;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(
				propertyName="destinationType", 
				propertyValue="javax.jms.Queue"					
		),
		@ActivationConfigProperty(
				propertyName="destination",
				propertyValue="java:/jms/queue/productqueue"
		),
		@ActivationConfigProperty(
				propertyName="maxSession",
				propertyValue="5"
		)
})
public class ProductMDB implements MessageListener {
	
	@EJB
	private AuditoriaDAO dao;

	@Override
	public void onMessage(Message msg) {
		if(msg instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) msg;
			try {
				if(objectMessage.getObject() instanceof ProductModel) {
					ProductModel pm = (ProductModel)objectMessage.getObject();
					Auditoria auditoria = new Auditoria();
					auditoria.setCod(pm.getCodigo());
					auditoria.setDate(new Date());
					auditoria.setOperacao("Criacao");
					dao.insert(auditoria);
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
