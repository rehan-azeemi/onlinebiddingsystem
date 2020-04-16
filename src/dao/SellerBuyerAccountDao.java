package dao;

import java.util.List;

import model.SellerBuyerAccount;

public interface SellerBuyerAccountDao {
	public SellerBuyerAccount checkLogin(SellerBuyerAccount sellerBuyerAccount);
	public Boolean registeration(SellerBuyerAccount sellerBuyerAccount);
	public Boolean emailVerification(SellerBuyerAccount sellerBuyerAccount);
	public void disableAccount(SellerBuyerAccount sellerBuyerAccount);
	public SellerBuyerAccount checkPasswordRecovery(SellerBuyerAccount sellerBuyerAccount);
	public int updatePassword(SellerBuyerAccount sellerBuyerAccount);
	public SellerBuyerAccount checkOldPassword(SellerBuyerAccount sellerBuyerAccount);
	public List<model.Messages> getAllUsers(SellerBuyerAccount sellerBuyerAccount);
}
