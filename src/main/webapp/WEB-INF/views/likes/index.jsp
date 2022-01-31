<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>いいね　一覧</h2>
        <table id="report_list">
            <tbody>
                <tr>
                    <th class="like_name">氏名</th>
                    <th class="like_date">日付</th>
                </tr>
                <c:forEach var="like" items="${likes}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="like_name"><c:out value="${like.employee.name}" /></td>
                        <fmt:parseDate value="${like.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                        <td class="like_date"><fmt:formatDate value='${updateDay}' pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </c:param>
</c:import>