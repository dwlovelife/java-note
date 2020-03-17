package establish.prototype.deepclone;

public class Client {
	public static void main(String[] args) {
		DeepPrototype deepPrototype = new DeepPrototype();
		deepPrototype.setName("Jack");
		DeepCloneableTarget cloneableTarget = new DeepCloneableTarget("JackFriend", "targetClass");
		deepPrototype.setCloneableTarget(cloneableTarget);
		
		DeepPrototype deepPrototype2 = deepPrototype.clone();
		System.out.println(deepPrototype.getCloneableTarget().hashCode());
		System.out.println(deepPrototype2.getCloneableTarget().hashCode());
	}
}
