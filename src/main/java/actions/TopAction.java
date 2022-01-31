package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import services.LikeService;
import services.ReportService;

public class TopAction extends ActionBase {

    private ReportService reportService;
    private LikeService likeService;

    @Override
    public void process() throws ServletException, IOException {
        reportService = new ReportService();
        likeService = new LikeService();

        invoke();

        likeService.close();
        reportService.close();
    }

    public void index() throws ServletException, IOException {
        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        int page = getPage();
        List<ReportView> reports = reportService.getMinePerPage(loginEmployee, page);
        List<Long> likeCounts = likeService.getLikeCountsPerReports(reports);
        long myReportsCount = reportService.countAllMine(loginEmployee);

        putRequestScope(AttributeConst.REPORTS, reports);
        putRequestScope(AttributeConst.LIKE_COUNTS, likeCounts);
        putRequestScope(AttributeConst.REP_COUNT, myReportsCount);
        putRequestScope(AttributeConst.PAGE, page);
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);

        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        forward(ForwardConst.FW_TOP_INDEX);
    }
}
