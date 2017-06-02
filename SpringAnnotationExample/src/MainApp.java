import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fdmgroup.config.DiConfigurator;
import com.fdmgroup.service.Car;
import com.fdmgroup.service.Scooter;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DiConfigurator.class);
		Car car = context.getBean(Car.class);
		System.out.println(car);
		System.out.println("-------------------------------------");
		Scooter scooter = (Scooter) context.getBean("scooter");
		System.out.println(context.getBean("company"));
		System.out.println(scooter);		
				
		((AnnotationConfigApplicationContext)context).close();
	}
}
