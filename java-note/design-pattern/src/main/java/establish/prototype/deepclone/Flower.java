package establish.prototype.deepclone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flower implements Cloneable {

	private String name;
	private String color;
	
	@Override
	protected Flower clone() {
		Flower flower = null;
		try {
			flower = (Flower) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flower;
	}
	
}
