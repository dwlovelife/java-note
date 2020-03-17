package establish.prototype.deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepPrototype implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 379323689301432850L;
	
	private String name; //属性
	private DeepCloneableTarget cloneableTarget;
	
	public DeepPrototype(String name, DeepCloneableTarget cloneableTarget) {
		super();
		this.name = name;
		this.cloneableTarget = cloneableTarget;
	}

	public DeepPrototype() {
		super();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeepCloneableTarget getCloneableTarget() {
		return cloneableTarget;
	}

	public void setCloneableTarget(DeepCloneableTarget cloneableTarget) {
		this.cloneableTarget = cloneableTarget;
	}

	/**
	 * 浅拷贝 对于A对象 B属性（对象） 只会拷贝引用 惹修改A对象中的B属性中的某个字段 会影响原赋值对象
	 * 深拷贝 拷贝实体
	 */
	//深拷贝-方式1 使用clone方法
	@Override
	protected DeepPrototype clone(){
		DeepPrototype deepPrototype = null;
		try {
			deepPrototype = (DeepPrototype) super.clone();
			deepPrototype.cloneableTarget = deepPrototype.cloneableTarget.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deepPrototype;
	}
	
	//深拷贝-方式2 使用序列化方式
	public DeepPrototype deepClone(){
		//创建流对象
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		DeepPrototype deepPrototype = null;
		try {
			//序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this); //当前这个对象以对象的方式输出
			
			//反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			deepPrototype = (DeepPrototype) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deepPrototype;
	}
	
}
