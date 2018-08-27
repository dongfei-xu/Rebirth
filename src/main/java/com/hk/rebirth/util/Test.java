package com.hk.rebirth.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;

public class Test {

    /**
     * @param path
     *            图片路径
     */
    public static void createAsciiPic(final String path) {
        //final String base = "\"@#&$%*o!;.";// 字符串由复杂到简单
        final String base = "#8XOHLTI)i=+;:,. ";// 字符串由复杂到简单
        try {
            final BufferedImage image = ImageIO.read(new File(path));  //读取图片
            //输出到指定文件中
            final BufferedWriter fos = new BufferedWriter(new FileWriter("D:\\img\\text\\yong.txt",false));   //true表示是否追加
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    String s = index >= base.length() ? " " : String.valueOf(base.charAt(index));
//                    System.out.print(s);
                    fos.write(s);
                }
                fos.newLine();
                System.out.println();
            }
            fos.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现图像的等比缩放
     * @param source
     * @param targetW
     * @param targetH
     * @return
     */
    private static BufferedImage resize(BufferedImage source, int targetW,
                                        int targetH) {
        // targetW，targetH分别表示目标长和宽
        int type = source.getType();
        BufferedImage target = null;
        double sx = (double) targetW / source.getWidth();
        double sy = (double) targetH / source.getHeight();
        // 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
        // 则将下面的if else语句注释即可
        if (sx < sy) {
            sx = sy;
            targetW = (int) (sx * source.getWidth());
        } else {
            sy = sx;
            targetH = (int) (sy * source.getHeight());
        }
        if (type == BufferedImage.TYPE_CUSTOM) { // handmade
            ColorModel cm = source.getColorModel();
            WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
                    targetH);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();
            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        } else
            target = new BufferedImage(targetW, targetH, type);
        Graphics2D g = target.createGraphics();
        // smoother than exlax:
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
        g.dispose();
        return target;
    }

    /**
     * 实现图像的等比缩放和缩放后的截取, 处理成功返回true, 否则返回false
     * @param inFilePath 要截取文件的路径
     * @param outFilePath 截取后输出的路径
     * @param width 要截取宽度
     * @param hight 要截取的高度
     * @throws Exception
     */
    public static boolean compress(String inFilePath, String outFilePath,
                                   int width, int hight) {
        boolean ret = false;
        File file = new File(inFilePath);
        File saveFile = new File(outFilePath);
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            ret = compress(in, saveFile, width, hight);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ret = false;
        } finally{
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }


    /**
     * 实现图像的等比缩放和缩放后的截取, 处理成功返回true, 否则返回false
     * @param in 要截取文件流
     * @param width 要截取宽度
     * @param hight 要截取的高度
     * @throws Exception
     */
    public static boolean compress(InputStream in, File saveFile,
                                   int width, int hight) {
//     boolean ret = false;
        BufferedImage srcImage = null;
        try {
            srcImage = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (width > 0 || hight > 0) {
            // 原图的大小
            int sw = srcImage.getWidth();
            int sh = srcImage.getHeight();
            // 如果原图像的大小小于要缩放的图像大小，直接将要缩放的图像复制过去
            if (sw > width && sh > hight) {
                srcImage = resize(srcImage, width, hight);
            } else {
                String fileName = saveFile.getName();
                String formatName = fileName.substring(fileName
                        .lastIndexOf('.') + 1);
                try {
                    ImageIO.write(srcImage, formatName, saveFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
                return true;
            }
        }
        // 缩放后的图像的宽和高
        int w = srcImage.getWidth();
        int h = srcImage.getHeight();
        // 如果缩放后的图像和要求的图像宽度一样，就对缩放的图像的高度进行截取
        if (w == width) {
            // 计算X轴坐标
            int x = 0;
            int y = h / 2 - hight / 2;
            try {
                saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        // 否则如果是缩放后的图像的高度和要求的图像高度一样，就对缩放后的图像的宽度进行截取
        else if (h == hight) {
            // 计算X轴坐标
            int x = w / 2 - width / 2;
            int y = 0;
            try {
                saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    /**
            * 实现图像的等比缩放和缩放后的截取, 处理成功返回true, 否则返回false
     * @param in 图片输入流
     * @param saveFile 压缩后的图片输出流
     * @param proportion 压缩比
     * @throws Exception
     */
    public static boolean compress(InputStream in, File saveFile, int proportion) {
        if(null == in
                ||null == saveFile
                ||proportion < 1){// 检查参数有效性
            //LoggerUtil.error(ImageHelper.class, "--invalid parameter, do nothing!");
            return false;
        }

        BufferedImage srcImage = null;
        try {
            srcImage = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        // 原图的大小
        int width = srcImage.getWidth() / proportion;
        int hight = srcImage.getHeight() / proportion;

        srcImage = resize(srcImage, width, hight);

        // 缩放后的图像的宽和高
        int w = srcImage.getWidth();
        int h = srcImage.getHeight();
        // 如果缩放后的图像和要求的图像宽度一样，就对缩放的图像的高度进行截取
        if (w == width) {
            // 计算X轴坐标
            int x = 0;
            int y = h / 2 - hight / 2;
            try {
                saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        // 否则如果是缩放后的图像的高度和要求的图像高度一样，就对缩放后的图像的宽度进行截取
        else if (h == hight) {
            // 计算X轴坐标
            int x = w / 2 - width / 2;
            int y = 0;
            try {
                saveSubImage(srcImage, new Rectangle(x, y, width, hight), saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    /**
     * 实现缩放后的截图
     * @param image 缩放后的图像
     * @param subImageBounds 要截取的子图的范围
     * @param subImageFile 要保存的文件
     * @throws IOException
     */
    private static void saveSubImage(BufferedImage image,
                                     Rectangle subImageBounds, File subImageFile) throws IOException {
        if (subImageBounds.x < 0 || subImageBounds.y < 0
                || subImageBounds.width - subImageBounds.x > image.getWidth()
                || subImageBounds.height - subImageBounds.y > image.getHeight()) {
            //LoggerUtil.error(ImageHelper.class, "Bad subimage bounds");
            return;
        }
        BufferedImage subImage = image.getSubimage(subImageBounds.x,subImageBounds.y, subImageBounds.width, subImageBounds.height);
        String fileName = subImageFile.getName();
        String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);
        ImageIO.write(subImage, formatName, subImageFile);
    }



    /**
     * test
     *
     * @param args
     */
    public static void main(final String[] args) throws IOException {
        Test.createAsciiPic("D:\\img\\yayong.jpg");

//        InputStream in = null;
////        缩放后需要保存的路径
//        File saveFile = new File("d:\\img\\yayong.jpg");
//        try {
//            //原图片的路径
//            in = new FileInputStream(new File("D:\\img\\yong.jpg"));
//            if(compress(in, saveFile, 3)){
//                System.out.println("图片压缩5倍！");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            in.close();
//        }
    }

}
