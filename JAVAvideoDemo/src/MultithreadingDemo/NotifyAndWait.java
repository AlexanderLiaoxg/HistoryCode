package MultithreadingDemo;

class Customer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����");
		
	}
	
}

class ProductorFactory implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
}


public class NotifyAndWait {
public static void main(String[] args) {
	
	Customer customers = new Customer();
	ProductorFactory pf = new ProductorFactory();
	Thread c1 = new Thread(customers, "�ͻ�һ");
	Thread p1 = new Thread(pf, "����һ");
	
	p1.start();
	synchronized(p1)
	{
		try {
			System.out.println("wait...�ȴ�������");
			p1.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	c1.start();
	synchronized(p1)
	{
	p1.notify();
	}
	System.out.println("�����ѻظ�������");
}
}
