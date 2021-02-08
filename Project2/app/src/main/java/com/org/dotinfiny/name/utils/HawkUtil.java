package com.org.dotinfiny.name.utils;

import android.content.Context;

import com.org.dotinfiny.name.Constants;
import com.orhanobut.hawk.Hawk;

public class HawkUtil {

    private static final String PREFS_NAME = "bangle_system_ref";
    public static HawkUtil instance;
    private Context context;

    private HawkUtil(Context context) {
        this.context = context;
    }

    public static HawkUtil getInstance(Context context) {
        if (instance == null) {
            instance = new HawkUtil(context);
            Hawk.init(context).build();
        }
        return instance;
    }

    public String getUserToken() {
        if (Hawk.contains(Constants.PREF_USER_TOKEN)) {
            return Hawk.get(Constants.PREF_USER_TOKEN, null);
        }
        return null;
    }

    public void updateUserInfo(String userToken/*, UserModel user*/) {
        Hawk.put(Constants.PREF_USER_TOKEN, userToken);
//        Hawk.put(Constants.PREF_USER_ID, user.get_id());
    }

    public String getUserId() {
        return Hawk.get(Constants.PREF_USER_ID, null);
    }

    public void doLogout() {
        Hawk.delete(Constants.PREF_USER_ID);
        Hawk.delete(Constants.PREF_USER_TOKEN);
    }


    public String getPendingEnteries() {
        return Hawk.get(Constants.PREF_PENDING_ENTERIES);
    }

    public void updatePendingEnteries(String id) {
        if (Hawk.contains(Constants.PREF_PENDING_ENTERIES)) {
            String enteries = getPendingEnteries();
            enteries += "," + id;
            Hawk.put(Constants.PREF_PENDING_ENTERIES, enteries);
        } else {
            Hawk.put(Constants.PREF_PENDING_ENTERIES, id);
        }
    }

    public void removeEnteries() {
        Hawk.delete(Constants.PREF_PENDING_ENTERIES);
    }
}
