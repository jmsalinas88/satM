package ar.com.quantum.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static Boolean isValidEmail(String email)
    {

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    private static int sumDig(int n)
    {
        int a = 0;
        while (n > 0)
        {
            a = a + n % 10;
            n = n / 10;
        }
        return a;
    }

    public static boolean isValidIMEI(long n)
    {
        // Converting the number into String
        // for finding length
        String s = Long.toString(n);
        int len = s.length();

        if (len != 15)
            return false;

        int sum = 0;
        for (int i = len; i >= 1; i--)
        {
            int d = (int)(n % 10);

            // Doubling every alternate digit
            if (i % 2 == 0)
                d = 2 * d;

            // Finding sum of the digits
            sum += sumDig(d);
            n = n / 10;
        }

        return (sum % 10 == 0);
    }

    public static Bitmap getBitmapFromImageBytes(byte[] imageAsBytes)
    {
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }


    public static byte[] getImageBytesFromBase64(String base64)
    {
        return Base64.decode(base64.getBytes(), Base64.DEFAULT);
    }


    public static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();
        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            e.getStackTrace();
        }

        return bitmap;
    }

}
