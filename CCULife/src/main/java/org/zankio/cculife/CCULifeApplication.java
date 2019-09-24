package org.zankio.cculife;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;

import io.fabric.sdk.android.Fabric;
import org.zankio.ccudata.base.source.http.HTTPSource;
import org.zankio.cculife.override.Net;

import javax.net.ssl.X509TrustManager;


public class CCULifeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        X509TrustManager trustManager = Net.generateTrustManagers(this, "ecourse_ssl.crt");
        HTTPSource.trustManager.put("ecourse.ccu.edu.tw", trustManager);
        HTTPSource.sslSocketFactory.put("ecourse.ccu.edu.tw", Net.generateSSLSocketFactory(trustManager));

        X509TrustManager trustManager1 = Net.generateTrustManagers(this, "wwwtaiwanbustw.crt");
        HTTPSource.trustManager.put("www.taiwanbus.tw", trustManager1);
        HTTPSource.sslSocketFactory.put("www.taiwanbus.tw", Net.generateSSLSocketFactory(trustManager1));

        X509TrustManager trustManager2 = Net.generateTrustManagers(this, "ptxtransportdatatw.crt");
        HTTPSource.trustManager.put("ptx.transportdata.tw", trustManager2);
        HTTPSource.sslSocketFactory.put("ptx.transportdata.tw", Net.generateSSLSocketFactory(trustManager2));


    }
}
