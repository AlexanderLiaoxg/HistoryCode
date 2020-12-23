package MultithreadingDemo;

public class RunnableandThreadDemo {
	public static void main(String[] args) {
		System.out.println("                   ������ʹ�ü̳�Tread�������MyThread�����߳����С�\n\n");
		saleticketsTread();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n                               �������߳����߶���... ...\n");

		System.out.println("\n���ڲ���ʵ��Runnable�ӿڵ�MyRunnable(Thread����)�������ӿڣ�����һ��MyRunnable���󣬴Ӷ�ʵ������Դ����....\n");
		saleticketsRunnable();
	}

	public static void saleticketsTread() {
		Mythread my1 = new Mythread("1��Tread���ʹ���");
		Mythread my2 = new Mythread("2��Tread���ʹ���");
		Mythread my3 = new Mythread("3��Tread���ʹ���");
		// my3.setPriority(10);
		my1.start();
		my2.start();
		my3.start();
	}

	public static void saleticketsRunnable() {
		MyRunnable my = new MyRunnable(); // ʵ����MyRunnale��Runnale�ӿڣ�����Threadװ��
		MyRunnable my2 = new MyRunnable();
		Thread thr1 = new Thread(my, "Threadװ�ε�RunnaleҼ�Ŵ���");
		Thread thr2 = new Thread(my, "Threadװ�ε�Runnale���Ŵ���");
		Thread thr3 = new Thread(my, "Threadװ�ε�Runnale���Ŵ���");
		thr1.start();
		thr2.start();
		thr3.start();
	}

}

/** һ��Mythread����һ���̣߳���Mythread�������Դ���ɹ��� **/
class Mythread extends Thread { // Mythread�̳�Thread�࣬��дRun����,��������Դ
	private int tickets = 3;
	private String windowname; // ��Ҫ�Լ�д�����߳�����

	public Mythread(String windowname) {
		super();
		this.windowname = windowname;
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			if (tickets > 0) {
				System.out.println(windowname + "��������" + tickets-- + "��Ʊ");
			}
		}
	}

}

/** Thread����MyRunnable��һ��Thread����һ���̣߳���ͬһ��MyRunnable�������Դ�ɹ��� **/
class MyRunnable implements Runnable {
	private int tickets = 3;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			if (tickets > 0) {
				System.out.println(Thread.currentThread().getName() + "��������" + tickets-- + "��Ʊ");
			}
		}

	}

}
