<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="${basePath}/js/jedate/skin/jedate.css">
<script type="text/javascript" src="${basePath}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${basePath}/js/laydate.js"></script>
    <script type="text/javascript" src="${basePath}/js/jquery.datetimepicker.full.min.js"></script>
    <script type="text/JavaScript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=YSVNtKs8ZniM2lnx4ahlDTQQDr5N3CLF" type="text/javascript"></script>
<script type="text/javascript" src="${basePath}/js/baseJs.js"></script>
</head>
<script type="text/javascript">

$(function(){
	$("#updateSub").click(function(){
		if(checkFrom()){
            $.ajax({  
                url : "${basePath}/authCode/updateAuthInfo",  
                type : "POST",
                data : $('#updateForm').serialize(),
                dataType : 'json',
                success : function(res){
                	res = $.parseJSON(res);
                    if(res.success){
                        alert(res.errmsg);
                        window.location.href = "${basePath}/authCode/getAuthInfoList";
                    }else{
                        alert("异常："+res.errmsg);
                    }
                }
            });
		}
	});
	
});

// 验证
function checkFrom(){
	if(!checkCommon($("#sysName").val(), "系统名称")){
		return false;
	}
	if(!checkCommon($("#useCompanyName").val(), "使用系统公司名称")){
        return false;
	}
	if(!checkCommon($("#keyType").val(), "加密类型")){
        return false;
	}
	return true;
}


</script>
<body>
    <form action="" id="updateForm">
    <input type="hidden" id="id" name="id" value="${authInfo.id}">
	<table border="1px">
		<tr>
			<td>系统名称</td>
			<td><input type="text" id="sysName" name="sysName" value="${authInfo.sysName }"/></td>
		</tr>
		<tr>
			<td>使用公司名称</td>
			<td><input type="text" id="useCompanyName" name="useCompanyName" value="${authInfo.useCompanyName }"/></td>
		</tr>
		<tr>
			<td>加密类型</td>
			<td>
			     <select id="keyType" name="keyType">
			         <option value="">请选择</option>
                        <c:forEach items="${keyTypeMap }" var="eachone">
                            <option value="${ eachone.key}" <c:if test="${authInfo.keyType eq eachone.key }">selected="selected"</c:if>>${ eachone.value}</option>
                        </c:forEach>
			     </select>
			</td>
		</tr>
		<tr>
			<td>起始时间</td>
			<td>
                <input id="wStartDate" placeholder="起始日期" class="laydate-icon data" value=<fmt:formatDate value="${authInfo.startDate}" type="both" pattern="yyyy-MM-dd" />  onFocus="var endDate=$dp.$('endDate');WdatePicker({onpicked:function(){endDate.focus();$dp.$('startDate').value=this.value;},maxDate:'#F{$dp.$D(\'endDate\')}',minDate:'%y-%M-{%d+1}',readOnly:true})"/>
                <input type="hidden" id="startDate" name="startDate" value=<fmt:formatDate value="${authInfo.startDate}" />
            </td>
		</tr>
		<tr>
			<td>到期时间</td>
			<td>
				<input id="wEndDate" placeholder="结束日期" class="laydate-icon data" value=<fmt:formatDate value="${authInfo.endDate}" type="both" pattern="yyyy-MM-dd" /> onFocus="WdatePicker({onpicked:function(){$dp.$('endDate').value=this.value;},minDate:'#F{$dp.$D(\'startDate\')}',readOnly:true})" />
				<input type="hidden" id="endDate" name="endDate" value=<fmt:formatDate value="${authInfo.endDate}" />
			</td>
		</tr>
		
		<tr>
			<td>备注</td>
			<td><input type="text" id="remark" name="remark" ${authInfo.remark }/></td>
		</tr>
	</table>
	<input type="button" id="updateSub" value="修改">
	</form>
	<br>
	<br>
	<br>
	<div class="jz-pages"></div>
</body>
</html>
