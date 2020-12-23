package IOStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class ChaneDemo {
	public static void main(String[] args) throws Exception {
		File src = new File("C:\\Users\\廖兴广\\Desktop\\core.jpg");
		File dest = new File("C:\\Users\\廖兴广\\Desktop\\corebreak.jpg");

		FileChannel inChannel = new FileInputStream(src).getChannel();
		FileChannel outChannel = new FileInputStream(dest).getChannel();

		MappedByteBuffer mbuff = inChannel.map(MapMode.READ_ONLY, 0, src.length());

		outChannel.write(mbuff);

		inChannel.close();
		outChannel.close();

	}
}
