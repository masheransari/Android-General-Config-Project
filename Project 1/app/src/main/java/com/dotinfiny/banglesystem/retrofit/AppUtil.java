package com.dotinfiny.banglesystem.retrofit;

import com.dotinfiny.banglesystem.Utils.Constants;
import com.org.dotinfiny.gamesprime.retrofit.BangleService;

public class AppUtil {

    public static BangleService getBangleService() {
        return RetrofitClient.getClient(Constants.API_URL).create(BangleService.class);
    }

}
