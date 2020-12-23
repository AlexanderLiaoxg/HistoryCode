package MultithreadingDemo;

class Info {
	private String name = "中微星和华为";
	private String content = "视频处理芯片和手机";
	private boolean flag = false;

	public synchronized void set(String name, String content) throws Exception {
		System.out.println("开始生产！");
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
		System.out.println("开始消费！");
		if (flag) {
			super.wait();
		}
		Thread.sleep(400);
		System.out.println("公司名称：" + this.getName() + "\t产品名称：" + this.getContent());
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
		boolean flag = false; // 新建的flag，此flag非彼flag
		for (int i = 0; i < 10; i++) {
			if (flag) {
				try {
					this.info.set("华为", "手机" + i);
					flag = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;
			} else {
				try {
					this.info.set("中微星", "视频处理芯片" + i);
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
