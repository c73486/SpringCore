package spring.core.group_buy.entity;

import java.util.Date;
import java.util.List;

public class Cart {
	private Integer cartId;
	private Integer userId;
	private List<CartItem> cartItems;
	private Boolean isCheckout;
	private Date checkoutTime;
	
	public Cart() {
		
	}

	public Cart(Integer cartId, Integer userId, List<CartItem> cartItems, Boolean isCheckout) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartItems = cartItems;
		this.isCheckout = isCheckout;
		setIsCheckout(isCheckout);
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Boolean getIsCheckout() {
		return isCheckout;
	}

	public void setIsCheckout(Boolean isCheckout) {
		if(this.isCheckout) {
			return; //此單已結帳 不可重新結帳
		}
		if(isCheckout) {
			this.setCheckoutTime(new Date());
		}
		this.isCheckout = isCheckout;
	}
	
	public Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", cartItems=" + cartItems + ", isCheckout="
				+ isCheckout + ", checkoutTime=" + checkoutTime + "]";
	}

	
}
