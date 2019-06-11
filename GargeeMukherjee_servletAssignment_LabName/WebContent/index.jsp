<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Training</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <table class="table">
  <thead class="thead-dark">
    <tr>
      
      <th scope="col">Training ID</th>
      <th scope="col">Training Name</th>
      <th scope="col">Available Seats</th>
      <th scope="col"></th>
    </tr>
  </thead>
  

<%
   try{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/practiceassignmentsdb", "root", "");
	   String query = "Select * from training_master";
	   Statement stmt=dbCon.createStatement();
	   ResultSet rs=stmt.executeQuery(query);
	   while(rs.next())
	   {
	   %>
	   <tbody>
       <tr>
         <td><%= rs.getInt("trainingID") %></td>
         <td><%= rs.getString("trainingName") %></td>
         <td id = "seats<%=rs.getInt("trainingID")%>"><%= rs.getString("availableSeats") %></td>
         <td><button class ="btn btn-primary" onclick = "loadTable(<%= rs.getInt("trainingID")%>)">Enroll</button></td>
       </tr>
       </tbody>
	   <%

	   }
	   %>
	       </table>
	       <%
   }catch(SQLException e){
	   
   }
%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

function loadTable(id){
	varS = "seats"+id;
	$('#'+varS).load("enroll?id="+id,function(responseValue, statusValue, xhr){
	});
}

</script>
</body>
</html>