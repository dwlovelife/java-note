package establish.prototype.deepclone.serializable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flower implements Serializable {

	private static final long serialVersionUID = 126839939664064143L;
	
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
