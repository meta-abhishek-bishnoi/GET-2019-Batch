package dao;

public class CategoryCount {
	String categoryName;
	int categoryCount;
	
	public CategoryCount(String categoryName, int categoryCount) {
		super();
		this.categoryName = categoryName;
		this.categoryCount = categoryCount;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public int getCategoryCount() {
		return categoryCount;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}
	
}
