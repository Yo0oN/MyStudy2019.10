package SystemStreamEx;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BookInheritSerializeTest {
	static class Parent{
		protected String name;
	}
	static class Child extends Parent implements Serializable{
		private static final long serialVersionUID = 4261512421193094142L;
		private int age;
		public Child(String name, int age) {
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			return "Child [age=" + age + ", name=" + name + "]";
		}
		private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
			out.writeUTF(name);
			out.defaultWriteObject();
		}
		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			name = in.readUTF();
			in.defaultReadObject();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File target = new File("C:\\Temp\\objParent.dat");
		Child child = new Child("홍길동", 20);
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(target));
			ois = new ObjectInputStream(new FileInputStream(target));
			
			oos.writeObject(child);
			Object readed = ois.readObject();
			if(readed != null && readed instanceof Child) {
				Child casted = (Child) readed;
				System.out.println(casted);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (oos != null) {try { oos.close(); } catch (IOException e) {}}
					if (oos != null) {try { oos.close(); } catch (IOException e) {}}
		}
	}
}
