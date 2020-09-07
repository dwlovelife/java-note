package establish.prototype.deepclone.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 花园 
 */
@Data
@AllArgsConstructor
public class Garden implements Serializable {
	
	private static final long serialVersionUID = 2231850409918603998L;
	//面积
	private double area;
	private Flower flower;
	
	//深拷贝-方式2 使用序列化方式
	public Garden deepClone(){
		//创建流对象
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		Garden garden = null;
		try {
			//序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this); //当前这个对象以对象的方式输出
			
			//反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			garden = (Garden) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return garden;
	}
	
}
