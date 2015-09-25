public class ImageProcessor {

    private static Pic picture;
    private static Pic picture2;
    private int width;
    private int height;

    public static void main(String[] args) {
        if (args.length == 2) {
            picture = new Pic(args[0]);
            picture2 = new Pic(args[1]);

            ImageProcessor filter = new ImageProcessor(picture);
            filter.greyscale().show();
            filter.invert().show();
            filter.noRed().show();
            filter.blackAndWhite().show();
            filter.maximize().show();
            filter.overlay().show();
        } else if (args.length == 1) {
            picture = new Pic(args[0]);

            ImageProcessor filter = new ImageProcessor(picture);
            filter.greyscale().show();
            filter.invert().show();
            filter.noRed().show();
            filter.blackAndWhite().show();
            filter.maximize().show();
        }
    }

    public ImageProcessor(Pic picture) {
        this.picture = picture.deepCopy();
        this.width = picture.getWidth();
        this.height = picture.getHeight();
    }

    public Pic greyscale() {
        Pic latestPic = picture.deepCopy();
        Pixel indexPixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                indexPixel = latestPic.getPixels()[j][i];
                int red = indexPixel.getRed();
                int green = indexPixel.getGreen();
                int blue = indexPixel.getBlue();
                int avg = (int) ((red + green + blue) / 3);
                indexPixel.setRed(avg);
                indexPixel.setGreen(avg);
                indexPixel.setBlue(avg);
            }
        }
        return latestPic;
    }

    public Pic invert() {
        Pic latestPic = picture.deepCopy();
        Pixel indexPixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                indexPixel = latestPic.getPixels()[j][i];
                int red = indexPixel.getRed();
                int green = indexPixel.getGreen();
                int blue = indexPixel.getBlue();
                indexPixel.setRed(255 - red);
                indexPixel.setGreen(255 - green);
                indexPixel.setBlue(255 - blue);
            }
        }
        return latestPic;
    }

    public Pic noRed() {
        Pic latestPic = picture.deepCopy();
        Pixel indexPixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                indexPixel = latestPic.getPixels()[j][i];
                indexPixel.setRed(0);
            }
        }
        return latestPic;
    }

    public Pic blackAndWhite() {
        Pic latestPic = picture.deepCopy();
        Pixel indexPixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                indexPixel = latestPic.getPixels()[j][i];
                int red = indexPixel.getRed();
                int green = indexPixel.getGreen();
                int blue = indexPixel.getBlue();
                int avg = (int) ((red + green + blue) / 3);
                if (avg >= 127) {
                    indexPixel.setRed(255);
                    indexPixel.setGreen(255);
                    indexPixel.setBlue(255);
                } else {
                    indexPixel.setRed(0);
                    indexPixel.setGreen(0);
                    indexPixel.setBlue(0);
                }
            }
        }
        return latestPic;
    }

    public Pic maximize() {
        Pic latestPic = picture.deepCopy();
        Pixel indexPixel;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                indexPixel = latestPic.getPixels()[j][i];
                int red = indexPixel.getRed();
                int green = indexPixel.getGreen();
                int blue = indexPixel.getBlue();
                if ((red == green) && (red == blue) && (blue == green)) {
                    indexPixel.setBlue(blue);
                    indexPixel.setGreen(green);
                    indexPixel.setRed(red);
                } else if ((red == green) && (red > blue)) {
                    indexPixel.setBlue(0);
                } else if ((red == blue) && (red > green)) {
                    indexPixel.setGreen(0);
                } else if ((blue == green) && (blue > red)) {
                    indexPixel.setRed(0);
                } else if (red == Math.max(Math.max(red, green), blue)) {
                    indexPixel.setBlue(0);
                    indexPixel.setGreen(0);
                } else if (green == Math.max(Math.max(green, red), blue)) {
                    indexPixel.setBlue(0);
                    indexPixel.setRed(0);
                } else if (blue == Math.max(Math.max(blue, green), red)) {
                    indexPixel.setRed(0);
                    indexPixel.setGreen(0);
                }
            }
        }
        return latestPic;
    }

    public Pic overlay() {
        Pixel small;
        Pixel large;
        Pic largePicture = picture.deepCopy();
        Pic smallPicture = picture2.deepCopy();
        for (int i = 0; i < Math.min(width, picture2.getWidth()); i++) {
            for (int j = 0; j < Math.min(height, picture2.getHeight()); j++) {
                small = smallPicture.getPixels()[j][i];
                large = largePicture.getPixels()[j][i];
                int red = (int) ((small.getRed() + large.getRed()) / 2);
                int green = (int) ((small.getGreen() + large.getGreen()) / 2);
                int blue = (int) ((small.getBlue() + large.getBlue()) / 2);
                large.setRed(red);
                large.setGreen(green);
                large.setBlue(blue);
            }
        }
        return largePicture;
    }
}