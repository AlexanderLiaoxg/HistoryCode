package MultithreadingDemo;

public class WheelDemo extends Thread{
         int num;
         String name;
         public static void main(String[] args) {
			WheelDemo w = new WheelDemo(6, "��˽�");
			WheelDemo s = new WheelDemo(6, "�����");
			w.start();
			s.start();
			for(int i=1;i<=w.num;i++) {
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName());
			}
		}
		public WheelDemo(int num,String name) {
			super();
			this.num = num;
			this.name = name;
		}
		
		public void run() {
			for(int i=1;i<=num;i++) {
				System.out.println(name + "�����" +i+"Ͱˮ" + "��ʣ" + (num-i) + "Ͱˮ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	 
}
