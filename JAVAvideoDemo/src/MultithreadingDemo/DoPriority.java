package MultithreadingDemo;

class ThreadDemo extends Thread{
	public void run() {
		System.out.println("运行线程：" + Thread.currentThread().getName());
	}
}

public class DoPriority {
public static void main(String[] args) {
	ThreadDemo t1 = new ThreadDemo();
	ThreadDemo t2 = new ThreadDemo();
	ThreadDemo t3 = new ThreadDemo();
	ThreadDemo t4 = new ThreadDemo();
	ThreadDemo t5 = new ThreadDemo();
	t1.setPriority(1);   //Thread-0
	t2.setPriority(4);   //Thread-1
	t3.setPriority(6);   //Thread-2
	t4.setPriority(8);   //Thread-3
	t5.setPriority(10);  //Thread-4
	t1.start();t2.start();t3.start();t4.start();t5.start();
}
}
