package consol;

import java.io.IOException;

import dao.Service;



public class testDeleteProducts {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Service service = new Service();
		int result = service.deleteProductsMoreThenOneYear();
		System.out.println("Effected Rows Are "+result);
	}

}
