/**
 * @author Abhishek Bishnoi
 * @since Aug 20, 2019
 */
package consol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.Service;


public class testInsertImages {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		List<String> images = new ArrayList<String>();
		int productId = 11;
		images.add("kitchenSet-Box-Front");
		images.add("kitchenSet-Box-Back");
		images.add("kitchenSet-Top-View");
		images.add("kitchenSet-Side-View");
		Service service = new Service();
		boolean result = service.addImage(images, productId);
		System.out.println("Images Inserted Sucessfully: "+result);
	}

}
