package MultithreadingDemo;

class RunnableImp implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
		System.out.println("执行线程：" + Thread.currentThread().getName());
		if(i==2) {
			System.out.println(Thread.currentThread().getName() + "已经执行了俩次进行礼让");
			Thread.yield();
		}
		}
	}

}

public class DoYeild {
public static void main(String[] args) {
	RunnableImp myRunnable = new RunnableImp();
	Thread t1 = new Thread(myRunnable,"A");
	Thread t2 = new Thread(myRunnable,"B");
	Thread t3 = new Thread(myRunnable,"C");
	Thread t4 = new Thread(myRunnable,"D");
	Thread t5 = new Thread(myRunnable,"E");
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
}
}
