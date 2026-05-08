package src.services;

public class ImageService {

    public boolean isValidImageFile(String fileName) {
        String lowerFileName = fileName.toLowerCase();

        return lowerFileName.endsWith(".png")
                || lowerFileName.endsWith(".jpg")
                || lowerFileName.endsWith(".jpeg");
    }

    public String getImageCategoryFolder(String category) {
        switch (category.toLowerCase()) {
            case "top":
                return "assets/tops/";
            case "bottom":
                return "assets/bottoms/";
            case "shoe":
                return "assets/shoes/";
            case "outerwear":
                return "assets/outerwear/";
            default:
                return "assets/";
        }
    }
}