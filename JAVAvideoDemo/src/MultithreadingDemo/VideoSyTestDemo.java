package MultithreadingDemo;

public class VideoSyTestDemo {
public static void mian() {
	// TODO Auto-generated method stub
	   VideoSynchronizedDemo basket = new VideoSynchronizedDemo(5);
	   //����������p1\p2
	   VideoSyProducer p1 = new VideoSyProducer(basket);
	   VideoSyProducer p2 = new VideoSyProducer(basket);
	   //����������
	   VideoSyConsumer c1 = new VideoSyConsumer(basket);
	   VideoSyConsumer c2 = new VideoSyConsumer(basket);
	   
	   new Thread(p1,"---������һ---").start();
	   new Thread(p2,"---������һ---").start();
	   new Thread(p1,"---������һ---").start();
	   new Thread(p1,"---������һ---").start();
}
}
