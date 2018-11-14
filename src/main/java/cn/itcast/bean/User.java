package cn.itcast.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
@Component("user")
@Service("user")//service层
@Controller("user")//web层
@Repository("user")//dao层
*/

@Component("user")
//指定对象的作用范围
//@Scope(scopeName="singleton")
public class User {
	private String name;
	@Value("18")
	private Integer age;
	
	/**
	 * 
	 * @Autowired //自动装配
	 * 问题：如果匹配多个类型一致的对象。将无法选择具体注入哪一个对象
	 * @Qualifier("Car2")//使用@Qualifier注解告诉Spring容器自动装配哪个名称的对象。
	 * 
	 */
	@Resource(name="car2")//手动注入，指定注入那个名称的对象
	private Car car;
	
	 
	
	public User() {
		super();
	}

	public User(String name, Car car) {
		super();
		System.out.println("User(String name, Car car)");
		this.name = name;
		this.car = car;
	}
	
	public User(Car car,String name) {
		super();
	 	System.out.println("User(Car car,String name)");
		this.name = name;
		this.car = car;
	}
	
	public User(Integer name,Car car) {
		super();
		System.out.println("User(Car car,String name)");
		this.name = name+"";
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@PostConstruct//在对象被创建之后调用
	public void init(){
		System.out.println("我是初始化方法");
	}
	
	@PreDestroy//在对象被销毁之前调用
	public void destory(){
		System.out.println("我是销毁方法");
	}
	
	public String getName() {
		return name;
	}
	@Value("Tom")
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
}
