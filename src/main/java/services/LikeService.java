package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import actions.views.LikeConverter;
import actions.views.LikeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.JpaConst;
import models.Employee;
import models.Like;
import models.Report;

public class LikeService extends ServiceBase{

    // 指定したレポートに対するいいねのリストを1ページ分返す
    public List<LikeView> getPerReportPerPage(ReportView report, int page) {
        List<Like> likes = em.createNamedQuery(JpaConst.Q_LIKE_GET_ALL_MINE, Like.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return LikeConverter.toViewList(likes);
    }

    // 指定したレポートに対するいいねの数を返す
    public long countAllPerReport (ReportView report) {
        long count = (long) em.createNamedQuery(JpaConst.Q_LIKE_COUNT_ALL_PER_REPORT, Long.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getSingleResult();
        return count;
    }

    // idを引数として、LikeViewを返す
    public LikeView findOne(int id) {
        return LikeConverter.toView(findOneInternal(id));
    }

    // 指定した従業員が、指定したレポートにしたいいねを返す
    public Like getByEmpAndRep(Employee employee, Report report) {
        Like like = em.createNamedQuery(JpaConst.Q_LIKE_GET_BY_EMP_AND_REP, Like.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, employee)
                .setParameter(JpaConst.JPQL_PARM_REPORT,  report)
                .getSingleResult();

        return like;
    }

    public void create(LikeView lv) {
        LocalDateTime ldt = LocalDateTime.now();
        lv.setCreatedAt(ldt);
        lv.setUpdatedAt(ldt);
        createInternal(lv);
    }

    public void update(LikeView lv) {
        if(lv.getLikedFlag() == AttributeConst.LIKE_NONE.getIntegerValue()) {
            lv.setLikedFlag(AttributeConst.LIKE_DONE.getIntegerValue());
        } else {
            lv.setLikedFlag(AttributeConst.LIKE_NONE.getIntegerValue());
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

    public List<Long> getLikeCountsPerReports(List<ReportView> reports) {
        List<Long> likeCounts = new ArrayList<Long>();
        for(ReportView report : reports) {
            long likeCount = countAllPerReport(report);
            likeCounts.add(likeCount);
        }
        return likeCounts;
    }
}
