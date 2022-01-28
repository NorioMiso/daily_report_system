package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.LikeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;
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

    public void create() throws ServletException, IOException {
        if(checkToken()) {
            EmployeeView ev = (EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP);
            int reportId = Integer.parseInt(getRequestParam(AttributeConst.REP_ID));
            ReportView rv = reportService.findOne(reportId);

            LikeView lv = new LikeView(
                    null,
                    ev,
                    rv,
                    null,
                    null,
                    1);

            likeService.create(lv);
        }



        putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());
        redirect(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW);
    }

}
