package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.LikeConverter;
import actions.views.LikeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import constants.JpaConst;
import models.Like;

public class LikeService extends ServiceBase{
    public List<LikeView> getPerReport(ReportView report) {
        List<Like> likes = em.createNamedQuery(JpaConst.Q_LIKE_GET_ALL_MINE, Like.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getResultList();
        return LikeConverter.toViewList(likes);
    }

    public long countAllPerReport (ReportView report) {
        long count = (long)em.createNamedQuery(JpaConst.Q_LIKE_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getSingleResult();
        return count;
    }

    public void create(LikeView lv) {
        LocalDateTime ldt = LocalDateTime.now();
        lv.setCreatedAt(ldt);
        lv.setUpdatedAt(ldt);
        createInternal(lv);
    }

    public void update(LikeView lv) {
        if(lv.getLikedFlag() == 0) {
            lv.setLikedFlag(1);
        } else {
            lv.setLikedFlag(0);
        }
        LocalDateTime ldt = LocalDateTime.now();
        lv.setUpdatedAt(ldt);
        updateInternal(lv);
    }

    private Like findOneInternal(int id) {
        return em.find(Like.class, id);
    }

    private void createInternal(LikeView lv) {
        em.getTransaction().begin();
        em.persist(LikeConverter.toModel(lv));
        em.getTransaction().commit();
    }

    private void updateInternal(LikeView lv) {
        em.getTransaction().begin();
        Like l = findOneInternal(lv.getId());
        LikeConverter.copyViewToModel(l, lv);
        em.getTransaction().commit();
    }
}
