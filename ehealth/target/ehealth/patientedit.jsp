<%@include file="header.jsp" %>
<%@page import="java.sql.*"%>
<%! String name="", dob="", gender="", address="", mobileno=""; %>
<%! int patientid=0, height=0, weight=0;%>
<%
if(session.getAttribute("uid") != null) {
	String uid = session.getAttribute("uid").toString();
	try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM patient WHERE uid="+uid); rs.next();
		patientid = rs.getInt("id");
		name = rs.getString("fullname");		
		dob = rs.getString("dob");
		gender = rs.getString("gender");
		height = rs.getInt("height");
		weight = rs.getInt("weight");
		address = rs.getString("address");
		mobileno = rs.getString("mobileno");

	} catch(Exception e1) { System.out.println(e1); }
}
%>



<%
if(request.getParameter("submit") != null) {
	String patid = request.getParameter("patid");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String dob = request.getParameter("dob");
	String height = request.getParameter("height");
	String weight = request.getParameter("weight");
	String address = request.getParameter("address");
	String mobileno = request.getParameter("mobileno");
	String code = request.getParameter("code");
	
	System.out.println(patid);
	
	try {
		String sql = "UPDATE `patient` SET `fullname`=?,`dob`=?,`gender`=?,`address`=?,`mobileno`=? WHERE id=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, dob);
		ps.setString(3, gender);
		ps.setString(4, address);
		ps.setString(5, mobileno);
		ps.setString(6, patid);
		ps.executeUpdate();
		System.out.println("Record Updated!");
		//cn.close();
	} catch (SQLException e) { e.printStackTrace(); }

}

	
%>
		
		<!-- Main Wrapper -->
	<div id="main-wrapper">
				<div class="wrapper style2">
					<div class="inner">
						<div class="container">
							<div class="row">
								<div class="12u skel-cell-important">
									<div id="content">

										<!-- Content -->
									
									  <article>
												<header class="major">
													<h2>My Page </h2>
													<p>Welcome to your medical profile. </p>
												</header>
												<span class="image featured"><img src="images/pic09.png" alt="" width="800" height="300" /></span>
										  <h3>Patient Information</h3>
										  <form id="form1" name="form1" method="post">
										    <table width="300" border="1" cellspacing="1" cellpadding="0">
										      <tr>
										        <td>Patient ID:</td>
										        <td><input name="patientid" disabled type="text" value="<%= patientid %>">
										        <input name='patid' type="hidden" value="<%= patientid %>">
										        </td>
									          </tr>
										      <tr>
										        <td>Patient Name:</td>
										        <td><input name="name" type="text" value="<%= name %>"></td>
									          </tr>
										      <tr>
										        <td>Gender:</td>
										        <td><input name="gender" type="text" value="<%= gender %>"></td>
									          </tr>
										      <tr>
										        <td>Date of Birth:</td>
										        <td><input name="dob" type="text" value="<%= dob %>"></td>
									          </tr>
										      <tr>
										        <td>Height:</td>
										        <td><input name="height" disabled type="text" value="<%= height %>"></td>
									          </tr>
										      <tr>
										        <td>Weight:</td>
										        <td><input name="weight" disabled type="text" value="<%= weight %>"></td>
									          </tr>
										      <tr>
										        <td>Home Address:</td>
										        <td><input name="address" type="text" value="<%= address %>"></td>
									          </tr>
										      <tr>
										        <td>Mobile No:</td>
										        <td><input name="mobileno" type="text" value="<%= mobileno %>"></td>
									          </tr>
									          <tr>
										        <td>Enter permission code:</td>
										        <td><input name="pcode" type="text"></td>
									          </tr>
										      <tr>
										        <td>&nbsp;</td>
										        <td><p>&nbsp;
										          </p>
										          <p>
										            <input type="submit" name="submit" id="submit" value="Submit">
								                </p></td>
									          </tr>
										      <tr>
										        <td>&nbsp;</td>
										        <td>&nbsp;</td>
									          </tr>
									        </table>
							            </form>
										  <p>&nbsp;</p>
									  </article>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="contact_tab">
                                            <footer>
													<a href="#" class="button alt icon fa-file-o">Continue Reading</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="#" class="button alt icon fa-file-o">Continue Reading	</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="#" class="button alt icon fa-file-o">Continue Reading</a>
				  </footer>
      </div>
				<div class="wrapper style3">
					<div class="inner">
						<div class="container">
							<div class="row">
							  <div class="8u">
												<!-- Excerpt -->
												<article class="box excerpt">
												  <div>
														  <header></header>
														  <!-- Excerpt -->
														  <article class="box excerpt"></article>
														<h2 align="justify">Conditions.</h2>
														<div align="justify">
														  <ul>
														    <li>eHealthcare System provides you with information with much effectiveness and ease. </li>
														    <li>Information peovided here are only for authorised users and therefore should not be shared carelessly. </li>
														    <li>By Login in to this page, you have agreed to work with absolute discretion in accordance with the constitutional law that gives access to health information only to the individual and his closest relative.</li>
														    <li>Dessiminating this information in any form and through any medium is solely on the user and the management of Aminu Kano Teaching Hospital shall not be held responsible.</li>
													      </ul>
												    </div>
														<p align="justify">- Management </p>
												  </div>
										  </article>
										</section>
								</div>
						  </div>
						</div>
					</div>
				</div>
			</div>
<%@include file="footer.jsp" %>