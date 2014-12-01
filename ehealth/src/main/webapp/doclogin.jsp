<%@include file="header.jsp" %>
<%
if(request.getParameter("login") != null) {
	String user1="", pass1="", user2="", pass2="", role="", patientid="";
	user1 = request.getParameter("user");
	pass1 = request.getParameter("pass");
	
	//System.out.println(user1+"=="+pass1);

	
try {
	ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM users WHERE username='"+user1+"' AND password='"+pass1+"'"); rs.next();
	String userid = rs.getString("id");
	System.out.println("userid="+userid);
	ResultSet rs2 = cn.createStatement().executeQuery("SELECT * FROM employee WHERE uid="+userid); rs2.next();
	String uid = rs.getString("id");
	user2 = rs.getString("username");
	pass2 = rs.getString("password");
	role = rs.getString("role");
	session.setAttribute("uid", uid);
	session.setAttribute("username", user1);
	session.setAttribute("password", pass1);
	session.setAttribute("role", role);
	
	session.setAttribute("doctorid", rs2.getString("eid"));
	session.setAttribute("docname", rs2.getString("name"));
	session.setAttribute("mobileno", rs2.getString("mobileno"));

	if(user1.equals(user2) && pass1.equals(pass2)) {
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "docmain.jsp");
	}

	

} catch(Exception e1) { System.out.println(e1);

response.setStatus(response.SC_MOVED_TEMPORARILY);
response.setHeader("Location", "error.jsp");



}
}
%>
<%
boolean pass= false;
if(request.getParameter("action") != null && request.getParameter("action").equals("password")) {
	pass = true;

}
String username="", password = "", info="";

if(request.getParameter("pass") != null) {
	String mobileno = request.getParameter("mobileno");

	try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE id=(SELECT uid FROM `patient` WHERE mobileno='"+mobileno+"')"); rs.next();
			username = rs.getString("username");
			password = rs.getString("password");
			info = "Your username is "+username+", and Your Password="+password;

		} catch(Exception e1) { info="Mobile Number does not exit!"; }
	
}

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
										  <p align="center" class="style2">User login<br>
										  </p>
										  <form id="form1" name="form1" method="post">
										    <table width="200" border="1" cellspacing="1" cellpadding="1">
										    
										      <%
										      if(!pass) {
										      out.println("<tr><td>Username:</td><td><input name='user' type='text' id='user'></td></tr>"+
										    		  "<tr><td>Password:</td><td><input name='pass' type='password' id='pass'></td></tr>"+
										    		  "<tr><td>&nbsp;</td><td><input type='submit' name='login' value='Login'></td></tr>");
										      }
										      
										      else {
										    	  out.println("<tr><td>Mobile No:</td><td><input name='mobileno' type='text'></td></tr>"+
											    		  "<tr><td>&nbsp;</td><td><input type='submit' name='pass' value='Recover'></td></tr>");
										      }
										      
										      %>
									           <tr><td></td>
										        <td><h4><%=info %></h4></td>
									          </tr>
									          
									          <tr><td></td>
										        <td><a href="?action=password">Forgot your Password?</a></td>
									          </tr>
									        </table>
									      </form>
										  <p align="center" class="style2">&nbsp; </p>
										</header>
									</div>
								</div>
								<div class="row">
									<div class="4u">
										<section>
										  <a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
										  <header class="second icon fa-user">
												<h3>Medical Professionals </h3>
										  </header>
										</section>
									</div>
									<div class="4u">
									  <section>
											<a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
									    <header class="second icon fa-cog">									      
									      <h3>eHealthcare Facilities</h3>
								        </header>
									</section>
									</div>
								  <div class="4u">
								    <section>
											<a href="#" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
								      <header class="second icon fa-bar-chart-o">
									      <h3>Condusive Environment </h3>
									  </header>
									</section>
								  </div>
								</div>
								<div class="row">
									<div class="12u">
										<p>This project has been developed in compliance to the University of East London/FTMS College criteria for completion of undergraduate program in Bsc Software Engineering.</p>
								  </div>
								</div>
							</section>

					</div>
				</div>
	</div>
			<!-- Footer Wrapper -->
			<div id="footer-wrapper">
				<footer id="footer" class="container">
				  <div class="row">
						<div class="12u">
							<div id="copyright">
								<ul class="menu">
									<li>&copy; AKTH eHealthcare System. All rights reserved</li>
									<li>Design: <a href="http://html5up.net">Dgreat I.T Solutions </a></li>
								</ul>
							</div>
						</div>
					</div>
				</footer>
			</div>

	</body>
</html>