package establish.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {
	
	
	private static final long serialVersionUID = 6904670069596629667L;
	
	private String cloneName;
	private String cloneClass;
	
	
	
	public String getCloneName() {
		return cloneName;
	}

	public String getCloneClass() {
		return cloneClass;
	}

	//构造器
	public DeepCloneableTarget(String cloneName,String cloneClass){
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}
	
	@Override
	protected DeepCloneableTarget clone()  {
		DeepCloneableTarget cloneableTarget = null;
		try {
			cloneableTarget = (DeepCloneableTarget) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cloneableTarget;
	}
	
}
