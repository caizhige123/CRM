package desktop.test;
/*
 * 打开指定网页并截图
 */
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;
public class DeskTopTest {
	public static void main(String[] args) {
		if (!java.awt.Desktop.isDesktopSupported()) {
			System.err.println("Desktop is not supported (fatal)");
			System.exit(1);
		}

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
		if (!desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
			System.err.println("Desktop doesn't support the browse action (fatal)");
			System.exit(1);
		}
		
		try {
			URI uri = URI.create("http://chuangshi.qq.com/read/bk/ds/56973023-m.html");
			desktop.browse(uri);
			Thread.sleep(8000); // 8 seconds is enough to load the any page.
			Robot robot = new Robot();
			// Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize() );
			Rectangle rectangle = new Rectangle(300, 90, 1000, 720);
			BufferedImage image = robot.createScreenCapture(rectangle);
			File outputfile = new File("G:\\prictice\\test.jpg");
			ImageIO.write(image, "jpg", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
