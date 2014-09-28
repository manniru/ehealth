<%@include file="header.jsp" %>
<%@page import="com.anas.ehealth.Db,
java.sql.PreparedStatement,java.sql.*"%>
<%! boolean permit=true; %>
<%! String patientid= ""; %>
<%! String count=""; %>
<%
if(session.getAttribute("uid") != null) { String uid = session.getAttribute("uid").toString(); }
if(session.getAttribute("patientid") != null) { patientid = session.getAttribute("patientid").toString(); }

/**
try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT count(*) as count FROM `permission` WHERE uid="+uid+" AND `status`='Not use'"); rs.next();
		String count = rs.getString("count");
		if(count.equals("1")) { permit=false; }
		else { permit = true;}

	} catch(Exception e1) { System.out.println(e1); }
*/
%>


<%

if(request.getParameter("submit") != null) {
	//String patientid = request.getParameter("patientid");
	String ptype = request.getParameter("ptype");
	String reason = request.getParameter("reasons");
	
	
	//cn.createStatement().executeUpdate("INSERT INTO permission(pid, ptype, reasons) VALUES ("+pid+",'"+ptype+"','"+reasons+"'");
	//cn.createStatement().executeUpdate("INSERT INTO permission(pid, ptype, reasons) VALUES (1,'mm','mm')");
	
	//System.out.println("Permission Sent!");
	
	try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO permission (ptype, reasons, patientid) VALUES(?, ?, ?)");
			//ps.setInt(1, Integer.parseInt(patientid));
			ps.setString(1, ptype);
			ps.setString(2, reason);
			ps.setString(3, patientid);
			ps.executeUpdate();
			System.out.println("Record Saved!");
			//cn.close();
		} catch (SQLException e) { e.printStackTrace(); }

}
%>
<%
System.out.println("patientid"+patientid);

try {
	ResultSet rs = cn.createStatement().executeQuery("SELECT count(*) as count FROM permission WHERE patientid="+patientid); rs.next();
	count = rs.getString("count");
} catch(Exception e1) { System.out.println("e1="+e1); }

%>

		
		<!-- Main Wrapper -->
			<div id="main-wrapper">
				<div class="wrapper style1">
					<div class="inner">
				
						<!-- Feature 1 -->
							<section class="container box feature1">
								<div class="row">
									<div class="12u">
										<header class="first major">
										  <p align="center" class="style2">Request Permission Page </p>
										</header>
										
										<form id="form1" name="form1" method="post">
									 <table width="200" border="1" cellspacing="1" cellpadding="1">
										      <tr>
										        <td>Patient ID:</td>
										        <td><input name="patientid" type="text" disabled value='<%= patientid %>'><br /></td>
									          </tr>
										      <tr>
										        <td>Permission Type:</td>
										        <td>

<select name='ptype'>
  <option value="Change of Name">Change of Name</option>
  <option value="Change Email">Change Email</option>
  <option value="Change Mobile">Change Mobile</option>
  <option value="Change Address">Change Address</option>
</select>

<br />
</td>
									          </tr>

 <tr>
										        <td>Reasons:</td>
										        <td>

<select name='reasons'>
  <option value="Registration Mistake">Registration Mistake</option>
  <option value="New Details">New Details</option>
</select>


</td>
									          </tr>
									          
										      <tr>
										        <td>
										        <tr>
										        <td>&nbsp;</td>
										        <td>
										        
										        <%
										        if(count.endsWith("1")) {
										        	out.println("<font color='#FF0000' size='+2'>You already have an existing permission request ! </font>");
										        }
										        else {
										        	out.println("<br/ ><input type='submit' name='submit' value='Submit'>");
										        }
										        
										        %>
										        
										        
										        </td>
									          </tr>
									        </table>
									
									</form>
									</div>
								</div>
								
								<div class="row">
									<div class="12u">
									
									

								  </div>
								</div>
							</section>

					</div>
				</div>
	</div>
	
<%@include file="footer.jsp" %>