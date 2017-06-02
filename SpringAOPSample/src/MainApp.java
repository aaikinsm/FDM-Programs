import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.config.DiConfigurator;
import com.fdmgroup.service.ShoppingCart;

public class MainApp {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(DiConfigurator.class);

		ShoppingCart sc = context.getBean(ShoppingCart.class);
		sc.addItem("apple", 25);
		sc.removeItem("apple");
		try {
			sc.empty();
		} catch (Exception e) {}
		
		System.out.println("----------------------");
		sc.loop();
		//((AnnotationConfigApplicationContext)context).close();

	}

}
