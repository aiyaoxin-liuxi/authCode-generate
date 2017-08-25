<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String ctx = request.getContextPath();
    request.setAttribute("path", ctx);
%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.jz_manage .mange_inner ul.two table tr td {
	border-right: 1px solid #d3d3d3;
	border-bottom: 1px solid #d3d3d3;
	/*background: #f0efef;*/
	line-height: 2;
	vertical-align: middle;
}
</style>
<!--/parts-job/webapp/css/tab.css  -->
<link rel="stylesheet" href="${basePath}/css/tab.css" />
<link rel="stylesheet" href="${basePath}/css/laydate.css" />
<%-- <script type="text/javascript" src="${basePath}/js/jquery.js"></script> --%>
<script type="text/javascript" src="${basePath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${basePath}/js/baseJs.js"></script>
<script type="text/javascript">
	
	// 弹出层
	function clickShowKey(publicKey, privateKey){
        $(".jz-tanchu,.shadow").removeClass("hide1");
        $("#showPublicKey").html(publicKey);
        $("#showPrivateKey").html(privateKey);
	}

	$(function() {
		
		$(".dianji,.guanbi").on("click",function(){
	        $(".jz-tanchu,.shadow").addClass("hide1");
	    });
		
		
		///////////////
		$(".pagesinner button").click(function() {
			var pageReg = '${pageReq}';
			var text = $(this).html();
			if (text == '上一页') {
				if ($("#prePage").val() == '0') {
					alert("已经是第一页");
				} else {
					text = Number($("#pageNo").val()) - 1;
				}
			} else if (text == '下一页') {
				if ($("#nextPage").val() == 0) {
					alert("已经是最后一页");
				} else {
					text = Number($("#pageNo").val()) + 1;
				}
			}
			$("#pageNo").val(text);
			// 		var state = $("#state").val();
			var pageNo = text;
			window.location.href = pageReg + "?pageNo=" + pageNo;
		});
		
		$("#toAddBut").click(function(){
			window.location.href = "${basePath}/authCode/toAddAuthInfo";
		});
		
	});
	function updateSub(id){
		window.location.href = "${basePath}/authCode/toUpdateAuthInfo?id=" + id;
	}
	function delSub(id){
		var params = {};
	    params.id = id;
		$.ajax({  
            url : "${basePath}/authCode/delAuthInfo",  
            type : "POST",
            data : params,
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
</script>
</script>
</head>
<body>
	<jsp:include page="/common/sys/header.jsp" />
	<div class="jz_manage">
		<div class="mange_inner">
			<jsp:include page="/common/sys/leftSys.jsp" />
            <button id="toAddBut" name="toAddBut">添加</button>
			<form action="" id="fillForm">
				<input type="hidden" name="cid" value="${companyInfo.cid}">
				<ul class="two">
					<table>
						<tr>
							<th>系统名称</th>
							<th>使用公司名称</th>
							<th>系统验证码</th>
							<th>系统公钥</th>
							<th>系统私钥</th>
							<th>加密类型</th>
							<!-- <th>起始时间</th> -->
							<th>到期时间</th>
							<!-- <th>创建时间</th> -->
							<!-- <th>备注</th> -->
							<th>操作</th>
						</tr>
						<c:if test="${authInfoList.size() == 0 }">
							<tr>
								<td colspan="12"><li style="text-align: center;"><p>未找到相关数据</p></li></td>
							</tr>
						</c:if>
						<c:if test="${authInfoList.size() > 0 }">
							<c:forEach items="${authInfoList }" var="item">
								<tr>
									<td style="display: none">${item.id}</td>
									<td>${item.sysName}</td>
									<td>${item.useCompanyName}</td>
									<td height="80px" width="400px" style="word-break:break-all">${item.sysAuth}</td>
									<td>
									   <c:if test="${item.publicKey != null}">
									       <span onclick="clickShowKey('${item.publicKey}', '${item.privateKey}')">
									                   点击查看
									       </span>
									   </c:if>
									</td>
									<td>
									   <c:if test="${item.privateKey != null}">
										   <span onclick="clickShowKey('${item.publicKey}', '${item.privateKey}')">
	                                                                                                点击查看
	                                       </span>
									   </c:if>
									</td>
									<td>${item.keyTypeName}</td>
									<%-- 
									<td>
									   <fmt:formatDate value="${item.startDate}" type="both" pattern="yyyy-MM-dd" />
									</td> 
									--%>
									<td>
									   <fmt:formatDate value="${item.endDate}" type="both" pattern="yyyy-MM-dd" />
									</td>
									<%-- 
									<td>
									   <fmt:formatDate value="${item.createDate}" type="both" pattern="yyyy-MM-dd" />
									</td>
									 --%>
									<%-- <td>${item.remark}</td> --%>
									<td>
										<a href="javascript:void(0)" onclick="updateSub('${item.id}');">重新生成</a> 
										|
										<a href="javascript:void(0)" onclick="delSub('${item.id}');">删除</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</ul>
			</form>
		</div>
	</div>
	<div class="jz-pages">
		<jsp:include page="/common/page.jsp" />
	</div>
	</form>
	
	<!--弹出框-->
	<div class="shadow hide1"></div>
	<div class="hide1 jz-tanchu jz-tanchu2 jz-tanchu_2" style="width:550px ;height: 400px;">
	    <ul>
	        <li class="one">
	            <img src="${basePath}/image/guanbi.png" alt="" class="guanbi"/>
	        </li>
	        <li>
                                公钥：
	        </li><br/>
	        <li>
	           <span id="showPublicKey"  height="80px" width="400px" style="word-break:break-all"></span>
	        </li><br/>
	        <li>
	                       私钥：
	        </li><br/>
	        <li>
	           <span id="showPrivateKey"  height="80px" width="400px" style="word-break:break-all"></span>
	        </li>
	        <br/>
	    </ul>
	</div>

</body>
</html>
