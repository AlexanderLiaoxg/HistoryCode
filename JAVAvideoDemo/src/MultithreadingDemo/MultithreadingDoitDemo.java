package MultithreadingDemo;

class Info {
	private String name = "��΢�Ǻͻ�Ϊ";
	private String content = "��Ƶ����оƬ���ֻ�";
	private boolean flag = false;

	public synchronized void set(String name, String content) throws Exception {
		System.out.println("��ʼ������");
		if (!flag) {
			super.wait();
		}
		this.setName(name);
		Thread.sleep(400);
		this.setContent(content);
		flag = false;
		System.out.println(name + "," + content);
		super.notify();

	}

	public synchronized void get() throws Exception {
		System.out.println("��ʼ���ѣ�");
		if (flag) {
			super.wait();
		}
		Thread.sleep(400);
		System.out.println("��˾���ƣ�" + this.getName() + "\t��Ʒ���ƣ�" + this.getContent());
		flag = true;
		super.notify();
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

class Productor implements Runnable {
	private Info info = null;

	public Productor(Info info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = false; // �½���flag����flag�Ǳ�flag
		for (int i = 0; i < 10; i++) {
			if (flag) {
				try {
					this.info.set("��Ϊ", "�ֻ�" + i);
					flag = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;
			} else {
				try {
					this.info.set("��΢��", "��Ƶ����оƬ" + i);
					flag = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

class Consumer implements Runnable {

	private Info info = null;

	public Consumer(Info info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				this.info.get();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class MultithreadingDoitDemo {
	public static void main(String[] args) {
		Info info = new Info();
		Productor p = new Productor(info);
		Consumer c = new Consumer(info);
		new Thread(p).start();
		new Thread(c).start();
	}

}
