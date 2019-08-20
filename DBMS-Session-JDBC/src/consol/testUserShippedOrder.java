package consol;

import java.util.List;

import dao.Service;
import pojo.UserOrder;

public class testUserShippedOrder {
 public static void main(String[] args) {
	 Service service = new Service();
	 List<UserOrder> result;
	 result = service.getUserShhipedOrders(8);
	 for(UserOrder object : result){
		 System.out.println(object.getOrderId()+" "+object.getTimestamp()+" "+object.getAmount());
	 }
 }
}
