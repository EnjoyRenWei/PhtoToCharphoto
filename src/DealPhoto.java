import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class DealPhoto {
	static String str="$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;: \"^`'.,";
	static int unit=256/str.length()+1;
	public static void getImagePixel(String image) throws Exception {
		int[] rgb = new int[3];
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int width = bi.getWidth();
		int height = bi.getHeight();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = bi.getRGB(j, i); 
				rgb[0] = (pixel & 0xff0000) >> 16; //rֵ
				rgb[1] = (pixel & 0xff00) >> 8;  //gֵ
				rgb[2] = (pixel & 0xff);  //bֵ
				System.out.print(getChar(rgb[0], rgb[1], rgb[2]));
			}
			System.out.println("");
		}
	} 
	public static String getChar(int r,int g,int b){
		int gray = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b); //����Ҷ�
		String result = str.substring(gray/unit, (gray/unit)+1); //�������Ӧ���ַ�
		return result;
	}
	public static void main(String[] args) {
		try {
			DealPhoto.getImagePixel("ͼƬ·��");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
