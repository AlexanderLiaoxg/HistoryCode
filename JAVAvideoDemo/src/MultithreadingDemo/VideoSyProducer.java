package MultithreadingDemo;

import javax.swing.JOptionPane;

public class VideoSyProducer implements Runnable{
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
			String name = JOptionPane.showInputDialog("请输入生产的商品");
		this.basket.consume();//从篮子中消费一个商品
		}
		}
	public VideoSyProducer(VideoSynchronizedDemo basket) {
		super();
		this.basket = basket;
	}

}
