<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Contract Management</title>
	<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<h2>Contract Management</h2>
    <div class="row">Contract Details</div>
    <div id="content" class="round">
	<form:form method="POST" modelAttribute="contract" id="cform" >
        <form:input type="hidden" path="id" id="id"/>
        
        <table class="table">
        <tr>
			<td class="leftColumn">Code</td>
			<td class="rightColumn">
				 <form:input type="text" path="code" id="code" class="input.form"/>
            <div class="error">
           		<form:errors path="code" class="help-inline"/>
            </div>
			</td>
		</tr>
		
		<tr>
			<td class="leftColumn">Description</td>
			<td class="rightColumn">
				 <form:input type="text" path="description" id="description" class="input.form"/>
            <div class="error">
           		<form:errors path="description" class="help-inline"/>
            </div>
			</td>
		</tr>
		
       	<tr>
			<td class="leftColumn">Vendor</td>
			<td class="rightColumn">
				 <form:input type="text" path="vendor" id="vendor" class="input.form"/>
            <div class="error">
           		<form:errors path="vendor" class="help-inline"/>
            </div>
			</td>
		</tr>
		
		<tr>
			<td class="leftColumn">Budget</td>
			<td class="rightColumn">
				 <form:input type="text" path="budget" id="budget" class="input.form"/>
            <div class="error">
           		<form:errors path="budget" class="help-inline"/>
            </div>
			</td>
		</tr>
		
        <tr>
			<td class="leftColumn">Committed Cost</td>
			<td class="rightColumn">
				 <form:input type="text" path="committedCost" id="committedCost" class="input.form"/>
            <div class="error">
           		<form:errors path="committedCost" class="help-inline"/>
            </div>
			</td>
		</tr>
		<tr>
			<td class="leftColumn">Forecast</td>
			<td class="rightColumn">
				 <form:input type="text" path="forecast" id="forecast" class="input.form"/>
            <div class="error">
           		<form:errors path="forecast" class="help-inline"/>
            </div>
			</td>
		</tr>
		<tr>
			<td class="leftColumn">Paid</td>
			<td class="rightColumn">
				 <form:input type="text" path="paid" id="paid" class="input.form"/>
            <div id="error" class="error">
           		<form:errors path="paid"/>
            </div>
			</td>
		</tr>
		<tr>
			<td class="leftColumn">Complete</td>
			<td class="rightColumn">
				 <form:input type="text" path="complete" id="complete" class="input.form"/>
            <div class="error">
           		<form:errors path="complete" class="help-inline"/>
            </div>
			
		</tr>
       	</table>
        <div class="row">
         <input type="submit" value="Update"/> or <a href="<c:url value='/contracts' />">Cancel</a>
        </div>
    </form:form>    
	</div>
	
</body>
</html>