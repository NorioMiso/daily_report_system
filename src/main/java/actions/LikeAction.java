package actions;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.LikeConverter;
import actions.views.LikeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import models.Employee;
import models.Like;
import models.Report;
import services.LikeService;
import services.ReportService;

public class LikeAction extends ActionBase {

    private LikeService likeService;
    private ReportService reportService;

    @Override
    public void process() throws ServletException, IOException {
        likeService = new LikeService();
        reportService = new ReportService();

        invoke();
        likeService.close();
        reportService.close();
    }

    public void createOrUpdate() throws ServletException, IOException {
        if(checkToken()) {
            EmployeeView ev = (EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP);
            Employee e = EmployeeConverter.toModel(ev);
            ReportView rv = reportService.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));
            Report r = ReportConverter.toModel(rv);
            Like like = null;

            try {
                like = likeService.getByEmpAndRep(e, r);
            } catch (NoResultException ex) {

            }

            if(like == null) {
                LikeView lv = new LikeView(
                        null,
                        ev,
                        rv,
                        null,
                        null,
                        AttributeConst.LIKE_DONE.getIntegerValue());

                likeService.create(lv);
            } else {
                LikeView lv = LikeConverter.toView(like);
                likeService.update(lv);
            }

            putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());
            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX);
        }


    }

    public void index() throws ServletException, IOException {
        int page = getPage();
        ReportView rv = reportService.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));
        List<LikeView> likes = likeService.getPerReportPerPage(rv, page);

        long likeCount = likeService.countAllPerReport(rv);

        putRequestScope(AttributeConst.LIKES, likes);
        putRequestScope(AttributeConst.LIKE_COUNT, likeCount);
        putRequestScope(AttributeConst.PAGE, page);
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);

        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        forward(ForwardConst.FW_LIKE_INDEX);

    }

}
