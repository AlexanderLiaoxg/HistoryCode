package MultithreadingDemo;

public class synchronizedDemo {
	public static Object object = new Object();

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();

		thread1.start();

		thread2.start();
	}

	static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				try {
					object.wait();
				} catch (InterruptedException e) {
				}
				System.out.println("�߳�12" + Thread.currentThread().getName() + "��ȡ������");
			}
		}
	}

	static class Thread2 extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				object.notify();
				System.out.println("�߳�" + Thread.currentThread().getName() + "������object.notify()");
			}
			System.out.println("�߳�" + Thread.currentThread().getName() + "�ͷ�����");
		}
	}
}
