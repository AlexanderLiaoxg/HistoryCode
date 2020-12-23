package MultithreadingDemo;

public class VideoSyTestDemo {
public static void mian() {
	// TODO Auto-generated method stub
	   VideoSynchronizedDemo basket = new VideoSynchronizedDemo(5);
	   //俩个生产者p1\p2
	   VideoSyProducer p1 = new VideoSyProducer(basket);
	   VideoSyProducer p2 = new VideoSyProducer(basket);
	   //俩个消费者
	   VideoSyConsumer c1 = new VideoSyConsumer(basket);
	   VideoSyConsumer c2 = new VideoSyConsumer(basket);
	   
	   new Thread(p1,"---生产者一---").start();
	   new Thread(p2,"---生产者一---").start();
	   new Thread(p1,"---消费者一---").start();
	   new Thread(p1,"---消费者一---").start();
}
}
