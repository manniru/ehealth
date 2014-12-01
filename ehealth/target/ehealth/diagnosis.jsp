<%@include file="header.jsp" %>
<%@page import="java.sql.*"%>
//<%! String pname="", patid="", docid=""; %>

<%
if(request.getParameter("submit") != null) {
	String docid = session.getAttribute("doctorid").toString();
	String patid = session.getAttribute("patid").toString();
	String pname = session.getAttribute("patientname").toString();
	String diagnosis = request.getParameter("diagnosis");
	String note = request.getParameter("note");
	
	System.out.println("diag"+diagnosis);
	try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO diagnosis (DOCTORID, PATIENTID, PATIENTNAME, DIAGNOSIS, NOTES) "
			+ "VALUES(?, ?, ?, ?, ?)");
			
			ps.setString(1, docid);
			ps.setString(2, patid);
			ps.setString(3, pname);
			ps.setString(4, diagnosis);
			ps.setString(5, note);
			ps.executeUpdate();
			System.out.println("Record Saved!");

	} catch (SQLException e) { e.printStackTrace(); }

		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "prescription.jsp");
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
													<h2>Diagnosis </h2>
													<p>Enter New Diagnosis Here.</p>
												</header>
												<span class="image featured"><img src="images/pic09.png" alt="" width="800" height="300" /></span>
										  <h3>Patient Information</h3>
										  <form id="form1" name="form1" method="post">
										    <table width="300" border="1" cellspacing="1" cellpadding="0">
										      <tr>
										        <td>Patient ID:</td>
										        <td><input name="patientid" disabled type="text" value="<%= patid %>">
										        <input name='patid' type="hidden" value="<%= patid %>">
										        </td>
									          </tr>
										      <tr>
										        <td>Patient Name:</td>
										        <td><input name="name" disabled type="text" value="<%= pname %>"></td>
									          </tr>
										      <tr>
										        <td>Diagnosis:</td>
										        <td><textarea name="name" cols="" rows="3"></textarea></td>
									          </tr>
										      <tr>
										        <td>Notes:</td>
										        <td><textarea name="name" cols="" rows="3"></textarea></td>
									          </tr>
										      
										      <tr>
										        <td>&nbsp;</td>
										        <td><p>&nbsp;
										          </p>
										          <p>
										            <input type="submit" name="submit" id="submit" value="Proceed to Prescription">
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