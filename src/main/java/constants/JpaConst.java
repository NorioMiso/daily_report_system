package constants;

public interface JpaConst {

    String PERSISTENCE_UNIT_NAME = "daily_report_system";

    int ROW_PER_PAGE = 15;

    String TABLE_EMP = "employees";

    String EMP_COL_ID = "id"; //id
    String EMP_COL_CODE = "code"; //社員番号
    String EMP_COL_NAME = "name"; //氏名
    String EMP_COL_PASS = "password"; //パスワード
    String EMP_COL_ADMIN_FLAG = "admin_flag"; //管理者権限
    String EMP_COL_CREATED_AT = "created_at"; //登録日時
    String EMP_COL_UPDATED_AT = "updated_at"; //更新日時
    String EMP_COL_DELETE_FLAG = "delete_flag"; //削除フラグ

    int ROLE_ADMIN = 1; //管理者権限ON(管理者)
    int ROLE_GENERAL = 0; //管理者権限OFF(一般)
    int EMP_DEL_TRUE = 1; //削除フラグON(削除済み)
    int EMP_DEL_FALSE = 0; //削除フラグOFF(現役)

    String TABLE_REP = "reports";

    String REP_COL_ID = "id"; //id
    String REP_COL_EMP = "employee_id"; //日報を作成した従業員のid
    String REP_COL_REP_DATE = "report_date"; //いつの日報かを示す日付
    String REP_COL_TITLE = "title"; //日報のタイトル
    String REP_COL_CONTENT = "content"; //日報の内容
    String REP_COL_CREATED_AT = "created_at"; //登録日時
    String REP_COL_UPDATED_AT = "updated_at"; //更新日時

    String TABLE_LIKE = "likes";

    String LIKE_COL_ID = "id";
    String LIKE_COL_EMP = "employee_id";
    String LIKE_COL_REP = "report_id";
    String LIKE_COL_CREATED_AT = "created_at";
    String LIKE_COL_UPDATED_AT = "updated_at";
    String LIKE_COL_LIKED_FLAG = "liked_flag";

    int LIKE_DONE = 1;
    int LIKE_NONE = 0;

    String ENTITY_EMP = "employee"; //従業員
    String ENTITY_REP = "report"; //日報
    String ENTITY_LIKE = "like";

    String JPQL_PARM_CODE = "code"; //社員番号
    String JPQL_PARM_PASSWORD = "password"; //パスワード
    String JPQL_PARM_EMPLOYEE = "employee"; //従業員
    String JPQL_PARM_REPORT = "report";

    //NamedQueryの nameとquery
    //全ての従業員をidの降順に取得する
    String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll"; //name
    String Q_EMP_GET_ALL_DEF = "SELECT e FROM Employee AS e ORDER BY e.id DESC"; //query
    //全ての従業員の件数を取得する
    String Q_EMP_COUNT = ENTITY_EMP + ".count";
    String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";
    //社員番号とハッシュ化済パスワードを条件に未削除の従業員を取得する
    String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodeAndPass";
    String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code = :" + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;
    //指定した社員番号を保持する従業員の件数を取得する
    String Q_EMP_COUNT_RESISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
    String Q_EMP_COUNT_RESISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;

    //全ての日報をidの降順に取得する
    String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
    String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";
    //全ての日報の件数を取得する
    String Q_REP_COUNT = ENTITY_REP + ".count";
    String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";
    //指定した従業員が作成した日報を全件idの降順で取得する
    String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
    String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";
    //指定した従業員が作成した日報の件数を取得する
    String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
    String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;


    //すべてのlikeをidの降順に取得する
    //String Q_LIKE_GET_ALL = ENTITY_LIKE + ".getAll";
    //String Q_LIKE_GET_ALL_DEF = "SELECT l FROM Like AS l ORDER BY l.id DESC";
    //すべてのlikeの件数を取得する
    //String Q_LIKE_COUNT = ENTITY_LIKE + ".count";
    //String Q_LIKE_COUNT_DEF = "SELECT COUNT(l) FROM like AS l";

    //指定した日報に押されたいいね(likedFlag==1)を全件idの降順で取得する
    String Q_LIKE_GET_ALL_MINE = ENTITY_LIKE + ".getAllMine";
    String Q_LIKE_GET_ALL_MINE_DEF = "SELECT l FROM Like AS l WHERE l.report = :" + JPQL_PARM_REPORT + " AND l.likedFlag = 1 ORDER BY l.id DESC";
    //指定した日報に押されたいいね(likedFlag==1)の件数を取得する
    String Q_LIKE_COUNT_ALL_PER_REPORT = ENTITY_LIKE + ".countAllPerReport";
    String Q_LIKE_COUNT_ALL_PER_REPORT_DEF = "SELECT COUNT(l) FROM Like AS l WHERE l.report = :" + JPQL_PARM_REPORT + " AND l.likedFlag = 1";
    //指定した従業員が、指定した日報に押したいいねを取得する(likedFlagは0でも1でも取得する)
    String Q_LIKE_GET_BY_EMP_AND_REP = ENTITY_LIKE + ".getByEmpAndRep";
    String Q_LIKE_GET_BY_EMP_AND_REP_DEF = "SELECT l FROM Like AS l WHERE l.employee = :" + JPQL_PARM_EMPLOYEE + " AND l.report = :" + JPQL_PARM_REPORT;
}
