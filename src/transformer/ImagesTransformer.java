package transformer;

import dto.ImagesDTO;
import model.Images;

public class ImagesTransformer {
	public static ImagesDTO transform(Images imagesModel){
		ImagesDTO imagesDTO = new ImagesDTO();
		if(imagesModel.getImagesId() != null){
			imagesDTO.setImagesId(imagesModel.getImagesId().toString());
		}
		if(imagesModel.getPath() != null){
			imagesDTO.setPath(imagesModel.getPath());
		}
		return imagesDTO;
	}
}
