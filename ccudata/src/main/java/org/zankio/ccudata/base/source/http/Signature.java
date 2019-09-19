package org.zankio.ccudata.base.source.http;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.zankio.ccudata.train.model.HMAC_SHA1;



public class Signature {

    public static int acheck;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String Sauth() {
        String sAuth="";
        String APPID = "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF";
        String APPKey = "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF";


        String xdate = getServerTime();
        String SignDate = "x-date: " + xdate;


        String Signature="";
        try {

            Signature = HMAC_SHA1.Signature(SignDate, APPKey);
        } catch (SignatureException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("Signature :" + Signature);
      return  sAuth = "hmac username=\"" + APPID + "\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\"" + Signature + "\"";

    }

    public static boolean check() {
        int checks = acheck;
        if (checks == 1)
        {
            acheck = 0;
            return true;
        }
        else
        return false;
    }


    public static String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());

    }

}

