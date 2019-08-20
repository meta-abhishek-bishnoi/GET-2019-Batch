package consol;

import java.util.List;

import dao.Service;
import pojo.CategoryCount;


public class testCategoryCount {
	public static void main(String[] args) {
		Service service = new Service();
		List<CategoryCount> result = service.parentCategoryWithChildCount();
		System.out.println("Category (Child Count)");
		for(CategoryCount object : result){
			System.out.println(object.getCategoryName()+" ("+object.getCategoryCount()+")");
		}
	}
}
