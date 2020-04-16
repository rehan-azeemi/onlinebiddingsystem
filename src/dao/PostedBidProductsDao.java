package dao;

import java.util.List;
import model.PostedBidProducts;

import model.Category;

public interface PostedBidProductsDao {
	public List<Category> getAllCategories();
	public Boolean addPostedBidProduct(PostedBidProducts postedBidProducts);
	public List<PostedBidProducts> getAllPostedBidProducts();
	public PostedBidProducts getPostedBidProductsWithId(PostedBidProducts postedBidProducts);
}
