package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Like;

public class LikeConverter {

    public static Like toModel(LikeView lv) {
        return new Like(
                lv.getId(),
                EmployeeConverter.toModel(lv.getEmployee()),
                ReportConverter.toModel(lv.getReport()),
                lv.getCreatedAt(),
                lv.getUpdatedAt(),
                //nullかどうか？
                lv.getLikedFlag() == null
                        //nullならnullを代入
                        ? null
                        //nullじゃなければ、画面の表示が1かどうか？
                        : lv.getLikedFlag() == AttributeConst.LIKE_DONE.getIntegerValue()
                            //画面の表示が1なら1を代入
                            ? JpaConst.LIKE_DONE
                            //画面の表示が1じゃなければ0を代入
                            : JpaConst.LIKE_NONE);
    }

    public static LikeView toView(Like l) {
        if (l == null) {
            return null;
        }

        return new LikeView(
                l.getId(),
                EmployeeConverter.toView(l.getEmployee()),
                ReportConverter.toView(l.getReport()),
                l.getCreatedAt(),
                l.getUpdatedAt(),
                l.getLikedFlag() == null
                    ? null
                    : l.getLikedFlag() == JpaConst.LIKE_DONE
                        ? AttributeConst.LIKE_DONE.getIntegerValue()
                        : AttributeConst.LIKE_NONE.getIntegerValue()
                );
    }

    public static List<LikeView> toViewList(List<Like> list) {
        List<LikeView> lvs = new ArrayList<>();

        for (Like l : list) {
            lvs.add(toView(l));
        }
        return lvs;
    }

    public static void copyViewToModel(Like l, LikeView lv) {
        l.setId(lv.getId());
        l.setEmployee(EmployeeConverter.toModel(lv.getEmployee()));
        l.setReport(ReportConverter.toModel(lv.getReport()));
        l.setCreatedAt(lv.getCreatedAt());
        l.setUpdatedAt(lv.getUpdatedAt());
        l.setLikedFlag(lv.getLikedFlag());
    }


}
