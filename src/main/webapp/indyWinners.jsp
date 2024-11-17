<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, indywinners.Pack.IndyWinner" %>
<%@ page import="indywinners_Dao.IndyWinnerDAO" %>
<%@ page import="indy.servlet.servletwinners" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indy Winners</title>
</head>
<body>
	<h1>Indianapolis 500 Winners</h1>
	<table border="1">
		<tr>
			<th>Year</th>
			<th>Driver</th>
			<th>Average Speed</th>
			<th>Country</th>
		</tr>
		 <%
            Object winnersObj = request.getAttribute("winners");
            List<IndyWinner> winners = null;

            if (winnersObj instanceof List<?>) {
                winners = (List<IndyWinner>) winnersObj;
            }

            if (winners != null && !winners.isEmpty()) {
                for (IndyWinner winner : winners) {
        %>
			<tr>
				<td><%= winner.getYear() %></td>
				<td><%= winner.getDriver() %></td>
				<td><%= winner.getAveragespeed() %></td>
				<td><%= winner.getCountry() %></td>
			</tr>
		<%
                }
            } else { 
        %>
        	<tr>
                <td colspan="4">No winners available to display.</td>
            </tr>
            
        <% 
            } 
        %>
		
	</table>
	
	<div style="margin-top: 20px">
		<% 
  			 Integer currentPageObj = (Integer) request.getAttribute("currentPage");
   			 Integer totalPagesObj = (Integer) request.getAttribute("totalPages");

   			 int currentPage = currentPageObj != null ? currentPageObj : 1;
   			 int totalPages = totalPagesObj != null ? totalPagesObj : 1;
		%>
<form action="indyWinners" method="get">
   <% if (currentPage > 1) { %>
       <button type="submit" name="page" value="<%= currentPage - 1 %>">Previous</button>
   <% } %>
   <% if (currentPage < totalPages) { %>
       <button type="submit" name="page" value="<%= currentPage + 1 %>">Next</button>
   <% } %>
</form>
	</div>
</body>
</html>