<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<title>Contract Management</title>
</head>

<body>
	<h2>Contract Management</h2>
	 <div id="content" class="round">
	<table border="1">
		<tr>
			<th>Project</th>
			<th>Code</th>
			<th>Description</th>
			<th>Vendor</th>
			<th>Budget</th>
			<th>Committed Cost</th>
			<th>Forecast</th>
			<th>Paid</th>
			<th>Percent Complete</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${contracts}" var="contract">
			<tr>
				<td>${contract.project.name}</td>
				<td>${contract.code}</td>
				<td>${contract.description}</td>
				<td>${contract.vendor}</td>
				<td>${contract.budget}</td>
				<td>${contract.committedCost}</td>
				<td>${contract.forecast}</td>
				<td>${contract.paid}</td>
				<td>${contract.complete}</td>
				<td><a href="<c:url value='/contracts/${contract.id}' />" class="btn btn-success 
 
custom-width">edit</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>