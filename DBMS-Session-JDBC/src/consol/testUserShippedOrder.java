package consol;

import java.util.List;

import dao.UserOrder;
import util.Service;

public class testUserShippedOrder {
 public static void main(String[] args) {
	 Service service = new Service();
	 List<UserOrder> result;
	 result = service.getUserShhipedOrders(2);
	 for(UserOrder object : result){
		 System.out.println(object.getOrderId()+" "+object.getTimestamp()+" "+object.getAmount());
	 }
 }
}
