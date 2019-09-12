package mdb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import model.ProductModel;

@Stateless
public class ProductSender {
	
	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/jms/queue/productqueue")
	private Queue queue;
	
	public void sendMensage(ProductModel productModel) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer producer = session.createProducer(queue);
			ObjectMessage message = session.createObjectMessage(productModel);
			producer.send(message);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
