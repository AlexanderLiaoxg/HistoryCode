package MultithreadingDemo;

import java.util.ArrayList;
import java.util.List;

public class VideoSynchronizedDemo {//basket
   private List<String> list = new ArrayList<String>();
   private int maxSize;
   public VideoSynchronizedDemo(int maxSize) {
	   super();
	   this.maxSize = maxSize;
   }
   
   //生产商品
   public void produce(String name) {
	   synchronized(list) {
		   while(list.size()==this.maxSize) {
			   try {
				list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   System.out.println("\n" + Thread.currentThread().getName() + "生产商品");
		   list.add(name);
		   list.notifyAll();
	   }
   }
   
   //消费商品
   public void consume() {
	   synchronized(list) {
		   while(list.size()==0) {
			   try {
				list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   System.out.println("\n" + Thread.currentThread().getName() + "开始消费");
	       String good = list.get(list.size()-1);//从篮子里面取出一个商品
	       list.remove(list.size()-1);//去除最后一个加入的商品
	       System.out.println("\n消费的商品是："+good);
	       list.notifyAll();
	   
	   
	   
	   }
   }
}
