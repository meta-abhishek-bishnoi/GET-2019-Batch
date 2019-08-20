package consol;

import util.Service;

public class testDeleteProducts {
	public static void main(String[] args) {
		Service service = new Service();
		int result = service.deleteProductsMoreThenOneYear();
		System.out.println("Effected Rows Are "+result);
	}

}
