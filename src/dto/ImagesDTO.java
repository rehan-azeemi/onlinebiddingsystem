package dto;

import javax.persistence.Column;

public class ImagesDTO {
private String imagesId;
private String path;

public String getImagesId() {
	return imagesId;
}
public void setImagesId(String imagesId) {
	this.imagesId = imagesId;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}

}
