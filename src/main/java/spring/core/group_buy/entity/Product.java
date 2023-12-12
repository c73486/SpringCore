package spring.core.group_buy.entity;

public class Product {
	private Integer productId;
	private String productName;
	private Integer price;
	private String unit;
	private Boolean isLaunch;
	
	public Product() {
		
	}

	public Product(Integer productId, String productName, Integer price, String unit, Boolean isLaunch) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.unit = unit;
		this.isLaunch = isLaunch;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Boolean getIsLaunch() {
		return isLaunch;
	}

	public void setIsLaunch(Boolean isLaunch) {
		this.isLaunch = isLaunch;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", unit="
				+ unit + ", isLaunch=" + isLaunch + "]";
	}
	
}
