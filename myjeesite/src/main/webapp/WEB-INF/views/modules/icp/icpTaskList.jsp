<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>备案任务管理</title>
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
		<li class="active"><a href="${ctx}/icp/icpTask/">备案任务列表</a></li>
		<shiro:hasPermission name="icp:icpTask:edit"><li><a href="${ctx}/icp/icpTask/form">备案任务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="icpTask" action="${ctx}/icp/icpTask/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>任务名称：</label>
				<form:input path="taskname" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>任务状态：</label>
				<form:select path="state" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('icptaskstate')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>任务名称</th>
				<th>任务状态</th>
				<th>备案数</th>
				<th>文档名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="icp:icpTask:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="icpTask">
			<tr>
				<td><a href="${ctx}/icp/icpTask/form?id=${icpTask.id}">
					${icpTask.taskname}
				</a></td>
				<td>
					${fns:getDictLabel(icpTask.state, 'icptaskstate', '')}
				</td>
				<td>
					${icpTask.icpinfototal}
				</td>
				<td>
					${icpTask.zipname}
				</td>
				<td>
					<fmt:formatDate value="${icpTask.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${icpTask.remarks}
				</td>
				<shiro:hasPermission name="icp:icpTask:edit"><td>
    				<a href="${ctx}/icp/icpTask/form?id=${icpTask.id}">修改</a>
					<a href="${ctx}/icp/icpTask/delete?id=${icpTask.id}" onclick="return confirmx('确认要删除该备案任务吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>