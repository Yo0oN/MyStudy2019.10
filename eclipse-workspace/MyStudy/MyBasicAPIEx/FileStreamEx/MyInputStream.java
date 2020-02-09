package FileStreamEx;
import java.io.IOException;
import java.io.InputStream;

public class MyInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream ips = null;

		try {
			ips = System.in;

			byte[] b = new byte[10];

			ips.read(b);
			System.out.println(ips.available());
//			System.out.println(ips.markSupported());
//			System.out.println(ips.available());
//			System.out.print((char) ips.read() + " ");
//			System.out.print((char) ips.read() + " ");
//
//			ips.mark(100);
//			ips.skip(5);
//			
//			System.out.print((char) ips.read() + " ");
//			System.out.print((char) ips.read() + " ");
//
//			ips.reset();
//
//			System.out.print((char) ips.read() + " ");
//			System.out.print((char) ips.read() + " ");
//
//			ips.mark(1);
//
//			System.out.print((char) ips.read() + " ");
//			System.out.print((char) ips.read() + " ");
//
//			ips.reset();
//
//			System.out.print((char) ips.read() + " ");
//			System.out.println((char) ips.read() + " ");
//			System.out.println(ips.available());

			for (int i = 0; i < 10; i++) {
				System.out.print((char) b[i] + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ips != null) {
				try {
					ips.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
