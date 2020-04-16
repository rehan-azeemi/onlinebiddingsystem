package dto;

public class UsersAndProductsDTO {
	private String sbaId;
	private String name;
	private String postedBidProductsId;
	private String postedBidProductsName;
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
	public String getPostedBidProductsId() {
		return postedBidProductsId;
	}
	public void setPostedBidProductsId(String postedBidProductsId) {
		this.postedBidProductsId = postedBidProductsId;
	}
	public String getPostedBidProductsName() {
		return postedBidProductsName;
	}
	public void setPostedBidProductsName(String postedBidProductsName) {
		this.postedBidProductsName = postedBidProductsName;
	}
	
}
