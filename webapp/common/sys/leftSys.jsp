<%@ page pageEncoding="UTF-8" %>
<%@ include file="/common/common.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="one">
            <li style="text-align: left;">
                <a href="${basePath}/authCode/getAuthInfoList" class="onc_m <c:if test="${active == 'sett_list' }">actived</c:if>">验证码信息</a>
            </li>
</ul>