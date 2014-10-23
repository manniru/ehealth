<%@include file="header.jsp" %>
<%@ page import="java.io.*,java.util.*,com.anas.ehealth.dao.Dao,java.sql.PreparedStatement" %>
<%! String ap=""; %>
<%
session.setAttribute("ap", "");
if(request.getParameter("submit") != null) {
	 Enumeration paramNames = request.getParameterNames();
		Dao dao = new Dao();
	   while(paramNames.hasMoreElements()) {
		   String user = session.getAttribute("username").toString();
		   ResultSet r4 = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE username='"+user+"'"); r4.next();
		   String uid = r4.getString("id");
		   ResultSet r5 = cn.createStatement().executeQuery("SELECT * FROM `patient` WHERE uid='"+uid+"'"); r5.next();
	      String name = (String)paramNames.nextElement();
	      String value = request.getHeader(name);
	      //out.print("<tr><td>" + name + "</td>\n");	      
	      //out.println("<td> " + value + "</td></tr>\n");
	      if(!name.equals("submit")) {
	    	  int pid=5;
	    	  String no = name.substring(4, 5);
	    	  String did = name.substring(5, 6);
	    	  String patid = r5.getString("id");
	    	  String date = dao.getDate();
	    	  String time = dao.getTime(no, did);
	    	  System.out.println(no+ did+ patid+ date+ time);
	    	  try {
	    		  
	    		  cn.createStatement().execute("UPDATE appointment SET slot"+no+"="+uid+" WHERE doctorid="+did);
	  		
	    		  PreparedStatement ps = cn.prepareStatement("INSERT INTO patappointment (DOCTORID, PID, TIME, DATE, SLOTNUMBER) "
	  					+ "VALUES(?, ?, ?, ?, ?)");
	  			
	  			ps.setString(1, did);
	  			ps.setString(2,patid);
	  			ps.setString(3,time);
	  			ps.setString(4,date);
	  			ps.setString(5,no);
	  			ps.executeUpdate();
	  			System.out.println("Record Saved!");
	  		   
	    	  
	    	  
	    	  } catch(Exception e) { System.out.println(e); }
	    	  System.out.println(no);
	    	  
	    	  session.setAttribute("ap", "disabled");
	    	  //System.out.println(session.getAttribute("ap").toString());
	      }
	     	  else { session.setAttribute("ap", ""); }
	   }
	   
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "appointment.jsp");

}
%>
<% if(session.getAttribute("ap") != null) { ap = session.getAttribute("ap").toString(); }
//System.out.println(ap);
%>
		
		<!-- Main Wrapper -->
			<div id="main-wrapper">
				<div class="wrapper style2">
					<div class="inner">
						<div class="container">
						  <form id="form1" name="form1" method="post">
						    <table width="500" border="1" cellspacing="1" cellpadding="0">
						      <tr>
						        <td>Doctor ID</td>
						        <td>Doctor Name</td>
						        <td>Slot 1</td>
						        <td>Slot 2</td>
						        <td>Slot 3</td>
					          </tr>
						      <%
try { ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `appointment`"); //rs.next();
int sn = 1;
while(rs.next()){
	String id = rs.getString("sno");
	String doctorid = rs.getString("doctorid");
	ResultSet rs2 = cn.createStatement().executeQuery("SELECT * FROM `employee` WHERE eid="+doctorid); rs2.next();
	String doctorname = rs2.getString("name");
	String slot1 = rs.getString("slot1");
	String slot2 = rs.getString("slot2");
	String slot3 = rs.getString("slot3");
	out.println("<tr>");
	//out.println("<td>"+id+"</td>");
	out.println("<td>"+doctorid+"</td>");
	out.println("<td>"+doctorname+"</td>");
	
	
	ResultSet r = null;
	if(slot1==null) { out.println("<td><input type='radio' "+ap+" name='slot1"+doctorid+"'></td>"); }
	else {
		r = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE id="+slot1); r.next();
		out.println("<td>"+r.getString("fullname")+"</td>"); }
	
	if(slot2==null) { out.println("<td><input type='radio' "+ap+" name='slot2"+doctorid+"'></td>"); }
	else { 
		r = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE id="+slot2); r.next();
		out.println("<td>"+r.getString("fullname")+"</td>"); }
	
	if(slot3==null) { out.println("<td><input type='radio' "+ap+" name='slot3"+doctorid+"'></td>"); }
	else { 
		r = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE id="+slot3); r.next();
		out.println("<td>"+r.getString("fullname")+"</td>"); }
	
	/**
	out.println("<td><select name='cmd"+id+"'>"+
			  "<option value='install' selected>Install IPTV</option>"+
			  "<option value='uninstall'>UnInstall IPTV</option>"+
			  "<option value='restart'>Restart IPTV</option>"+
			 "<option value='pushdata'>Push Data</option>"+
			  "<option value='reboot'>Reboot</option>"+
			  "<option value='shutdown'>Shutdown</option>"+
			"</select><input type='submit' name='adb' id='submit' value='Adb "+id+"'></td>");
	*/
	out.println("</tr>");
	sn++;
}

} catch(Exception e) { System.out.println(e); }
%>

<tr align="center"><td></td><td></td><td><input type="submit" name="submit" id="submit" value="Submit"></td></tr>
					        </table>
						    
					      </form>
						</div>
					</div>
				</div>
				<div class="wrapper style3">
					<div class="inner">
						<div class="container">
							<div class="row">
								<div class="8u">
</div>
				</div>
			</div>										
				</div>
			</div>

<%@include file="footer.jsp" %>