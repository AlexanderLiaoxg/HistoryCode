package MultithreadingDemo;

import javax.swing.JOptionPane;

public class VideoSyConsumer implements Runnable{
private VideoSynchronizedDemo basket;  //basket
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.basket.consume();//从篮子中消费一个商品
		}
		}
	public VideoSyConsumer(VideoSynchronizedDemo basket) {
		super();
		this.basket = basket;
	}

}