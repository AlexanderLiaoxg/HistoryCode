package MultithreadingDemo;

public class RunnableandThreadDemo {
	public static void main(String[] args) {
		System.out.println("                   我们先使用继承Tread类的三个MyThread对象线程运行。\n\n");
		saleticketsTread();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n                               现在主线程休眠二秒... ...\n");

		System.out.println("\n现在采用实现Runnable接口的MyRunnable(Thread修饰)的三个接口（共享一个MyRunnable对象，从而实现了资源共享）....\n");
		saleticketsRunnable();
	}

	public static void saleticketsTread() {
		Mythread my1 = new Mythread("1号Tread类型窗口");
		Mythread my2 = new Mythread("2号Tread类型窗口");
		Mythread my3 = new Mythread("3号Tread类型窗口");
		// my3.setPriority(10);
		my1.start();
		my2.start();
		my3.start();
	}

	public static void saleticketsRunnable() {
		MyRunnable my = new MyRunnable(); // 实例化MyRunnale（Runnale接口）再用Thread装饰
		MyRunnable my2 = new MyRunnable();
		Thread thr1 = new Thread(my, "Thread装饰的Runnale壹号窗口");
		Thread thr2 = new Thread(my, "Thread装饰的Runnale二号窗口");
		Thread thr3 = new Thread(my, "Thread装饰的Runnale三号窗口");
		thr1.start();
		thr2.start();
		thr3.start();
	}

}

/** 一个Mythread代表一个线程，故Mythread里面的资源不可共享 **/
class Mythread extends Thread { // Mythread继承Thread类，覆写Run方法,不共享资源
	private int tickets = 3;
	private String windowname; // 需要自己写赋予线程名字

	public Mythread(String windowname) {
		super();
		this.windowname = windowname;
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			if (tickets > 0) {
				System.out.println(windowname + "正在卖第" + tickets-- + "张票");
			}
		}
	}

}

/** Thread修饰MyRunnable，一个Thread代表一个线程，故同一个MyRunnable里面的资源可共享 **/
class MyRunnable implements Runnable {
	private int tickets = 3;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			if (tickets > 0) {
				System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets-- + "张票");
			}
		}

	}

}
