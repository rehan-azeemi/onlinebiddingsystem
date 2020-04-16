package transformer;

import dto.CategoryDTO;
import model.Category;

public class CategoryTransformer {
	public static CategoryDTO transform(Category categoryModel){
		CategoryDTO categoryDTO= new CategoryDTO();
		if(categoryModel.getCategoryId()!=null){
			categoryDTO.setCategoryId(categoryModel.getCategoryId().toString());
		}
		if(categoryModel.getName()!=null){
			categoryDTO.setName(categoryModel.getName().toString());
		}
		return categoryDTO;
	}
}
