package bawei.com.demoxiangmuer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static android.graphics.BitmapFactory.decodeFile;

/**
 * Created by Mr.周 on 2017/9/27.
 */

public class ImageResizeUtils {
    public static Bitmap resizeImage(String path, int specifiedWidth) throws Exception {
        Bitmap bitmap = null;
        FileInputStream instream = null;
        File f = new File(path);
        System.out.println(path);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        instream = new FileInputStream(f);
        //int degree = readPictureDegree(path);
        BitmapFactory.Options opt = new BitmapFactory.Options();
        //照片不加载到内存 只能读取照片边框信息
        opt.inJustDecodeBounds = true;
        //获取这个图片的宽和高
        decodeFile(path, opt);
        return null;
    }

    /*private static int readPictureDegree(String path) {

        return null;
    }*/

}
