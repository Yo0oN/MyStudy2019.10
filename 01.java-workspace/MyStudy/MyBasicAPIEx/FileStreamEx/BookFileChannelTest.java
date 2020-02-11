package FileStreamEx;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BookFileChannelTest {
	public void writeToFile() {
		Path srcPath = Paths.get("C:\\java\\byChannel.txt");
		Charset utf8 = Charset.forName("Utf-8");
		try (FileChannel writeChannel
				= FileChannel.open(srcPath, StandardOpenOption.CREATE,
						StandardOpenOption.WRITE);){
			String src = "안녕 FileChennel. 일반 I/O 대비 쉽나요?";
			ByteBuffer bBuffer = utf8.encode(src);
			int byteCnt = writeChannel.write(bBuffer);
			System.out.println(byteCnt + "byte 출력 완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookFileChannelTest bfct = new BookFileChannelTest();
		bfct.writeToFile();
	}

}
