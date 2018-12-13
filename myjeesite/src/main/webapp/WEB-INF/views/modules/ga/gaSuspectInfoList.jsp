<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>疑似主叫号码管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/ga/gaSuspectInfo/">疑似主叫号码列表</a></li>
		<shiro:hasPermission name="ga:gaSuspectInfo:edit"><li><a href="${ctx}/ga/gaSuspectInfo/form">疑似主叫号码添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="gaSuspectInfo" action="${ctx}/ga/gaSuspectInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>诈骗号码：</label>
				<form:input path="callingnumber" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="gender" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否诈骗团伙成员：</label>
				<form:select path="belonggang" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否诈骗：</label>
				<form:select path="isswindle" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否改号：</label>
				<form:select path="isfake" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>冒充目标：</label>
				<form:input path="faketarget" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>上报标志：</label>
				<form:select path="uploadflag" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('ga_upload_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>诈骗号码</th>
				<th>性别</th>
				<th>更新时间</th>
				<th>是否诈骗</th>
				<th>是否改号</th>
				<th>冒充目标</th>
				<th>上报标志</th>
				<shiro:hasPermission name="ga:gaSuspectInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gaSuspectInfo">
			<tr>
				<td><a href="${ctx}/ga/gaSuspectInfo/form?id=${gaSuspectInfo.id}">
					${gaSuspectInfo.callingnumber}
				</a></td>
				<td>
					${fns:getDictLabel(gaSuspectInfo.gender, 'sex', '')}
				</td>
				<td>
					<fmt:formatDate value="${gaSuspectInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(gaSuspectInfo.isswindle, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(gaSuspectInfo.isfake, 'yes_no', '')}
				</td>
				<td>
					${gaSuspectInfo.faketarget}
				</td>
				<td>
					${fns:getDictLabel(gaSuspectInfo.uploadflag, 'ga_upload_flag', '')}
				</td>
				<shiro:hasPermission name="ga:gaSuspectInfo:edit"><td>
    				<a href="${ctx}/ga/gaSuspectInfo/form?id=${gaSuspectInfo.id}">修改</a>
					<a href="${ctx}/ga/gaSuspectInfo/delete?id=${gaSuspectInfo.id}" onclick="return confirmx('确认要删除该疑似主叫号码吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>