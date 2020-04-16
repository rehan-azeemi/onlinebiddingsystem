package dto;

import javax.persistence.Column;

public class SellerBuyerAccountDTO {
	private String sbaId;
	private String name;
	
	public String getSbaId() {
		return sbaId;
	}
	public void setSbaId(String sbaId) {
		this.sbaId = sbaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
