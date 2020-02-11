package FileEx;
import java.util.HashMap;
import java.util.Properties;

import FileEx.MyFiles;

public class MySystemClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFiles files = new MyFiles();
		System.out.println(System.currentTimeMillis());
		System.out.println(files);
		System.lineSeparator();
		System.out.println(System.identityHashCode(files));
		System.out.println(files.hashCode());
		System.out.println(System.lineSeparator());
		//System.out.println(System.getProperties());
		//System.out.println(System.getenv());
		//System.exit(0);	//??
		//System.gc();	//??
		}

}
