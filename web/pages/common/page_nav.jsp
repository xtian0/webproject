
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">&lt   </a>
        &nbsp&nbsp&nbsp
    </c:if>
    <c:if test="${requestScope.page.pageNo > 3}">
        <a href="${requestScope.page.url}&pageNo=1">1</a>
        <c:if test="${requestScope.page.pageNo > 4}">
            ...
        </c:if>
    </c:if>

    <%--页码输出开始--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i == requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>

        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal - 2}">
                    <c:forEach begin="${requestScope.page.pageTotal - 4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNo - 2}" end="${requestScope.page.pageNo + 2}" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <%--页码输出结束--%>

    <c:if test="${requestScope.page.pageNo <= requestScope.page.pageTotal - 3}">
        <c:if test="${requestScope.page.pageNo <= requestScope.page.pageTotal - 4}">
            ...
        </c:if>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">${requestScope.page.pageTotal}</a>
    </c:if>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        &nbsp&nbsp&nbsp
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">&gt</a>
    </c:if>


</div>