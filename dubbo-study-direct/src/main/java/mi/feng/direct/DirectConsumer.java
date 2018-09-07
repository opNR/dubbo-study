package mi.feng.direct;

import mi.feng.direct.api.DirectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: MiFeng
 * @Date: 2018/9/7 10:15
 * @Description:
 */
public class DirectConsumer {

    public static void main(String[] args) {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-direct-consumer.xml"});
        context.start();

        DirectService directService = (DirectService) context.getBean("directService");  // get remote service proxy

        while (true){
            try {
                Thread.sleep(1000);

                String hello = directService.sayHello("world"); // call remote method
                System.out.println(hello);  // get result

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
