package establish.prototype.improve;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 花园 
 */
@Data
@AllArgsConstructor
public class Garden implements Cloneable {
	
	//面积
	private double area;
	private Flower flower;
	
	@Override
	protected Garden clone() {
		Garden garden = null;
		try {
			garden = (Garden) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return garden;
	}
	
}
