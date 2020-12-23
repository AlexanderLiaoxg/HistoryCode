package IOStreamDemo;

import java.io.IOException;

public class JVM {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		StringBuffer sb = new StringBuffer("1");
		for (int i = 0; i < 1000000; i++) {
			sb.append(i);
		}
		System.out.println(rt.availableProcessors());// 虚拟机可用处理器数量
		System.out.println(rt.maxMemory());// 虚拟机可用最大内存数量
		System.out.println(rt.freeMemory());// 虚拟机空间内存数量
		String[] cmd = { "C:\\Users" };
		try {
			rt.exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
