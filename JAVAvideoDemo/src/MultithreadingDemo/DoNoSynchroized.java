package MultithreadingDemo;

class NoSynchroizedImp implements Runnable{

	private int tickets = 5;
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
			while (tickets > 0) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets-- + "张票");
			}
		}
}

public class DoNoSynchroized {
	public static void main(String[] args) {
		NoSynchroizedImp my = new NoSynchroizedImp();
		Thread thr1 = new Thread(my, "my装饰的Runnale壹号窗口");
		Thread thr2 = new Thread(my, "my装饰的Runnale二号窗口");
		Thread thr3 = new Thread(my, "my装饰的Runnale三号窗口");
		thr1.start();
		thr2.start();
		thr3.start();
	}

}
