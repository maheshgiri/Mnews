package android.mvp.mnews.utils;

import android.mvp.mnews.models.Master;

import java.util.ArrayList;
import java.util.List;

public class MasterData {
    private static List<Master> masterList=new ArrayList<>();

    public static List<Master> getMasterList() {
        return masterList;
    }

    public static void setMasterList(List<Master> masterList) {
        MasterData.masterList = masterList;
    }
}
