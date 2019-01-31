package com.fashionqueue.app;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Application extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/nunito_sans_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }


}
