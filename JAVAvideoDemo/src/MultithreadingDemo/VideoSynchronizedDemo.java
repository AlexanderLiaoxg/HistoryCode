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
   
   //������Ʒ
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
		   System.out.println("\n" + Thread.currentThread().getName() + "������Ʒ");
		   list.add(name);
		   list.notifyAll();
	   }
   }
   
   //������Ʒ
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
		   System.out.println("\n" + Thread.currentThread().getName() + "��ʼ����");
	       String good = list.get(list.size()-1);//����������ȡ��һ����Ʒ
	       list.remove(list.size()-1);//ȥ�����һ���������Ʒ
	       System.out.println("\n���ѵ���Ʒ�ǣ�"+good);
	       list.notifyAll();
	   
	   
	   
	   }
   }
}
