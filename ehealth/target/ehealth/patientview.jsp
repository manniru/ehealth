<%@include file="header.jsp" %>
<%! String username="", name="", dob="", gender="", address="", mobileno="", password=""; %>
<%! int patientid=0, height=0, weight=0;%>
<%
if(session.getAttribute("uid") != null) {
	String uid = session.getAttribute("uid").toString();
	System.out.println(uid);
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
	
	try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM users WHERE id="+uid); rs.next();
		patientid = rs.getInt("id");
		username = rs.getString("username");		
		password = rs.getString("password");


	} catch(Exception e1) { System.out.println(e1); }
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
										  <table width="300" border="1" cellspacing="1" cellpadding="0">
										    <tr>
										      <td>Patient ID:</td>
										      <td align="left"><strong><%= patientid %></strong></td>
									        </tr>
										    <tr>
										      <td>Patient Name:</td>
										      <td align="left"><strong><%= name %></strong></td>
									        </tr>
										    <tr>
										      <td>Gender:</td>
										      <td align="left"><strong><%= gender %></strong></td>
									        </tr>
										    <tr>
										      <td>Date of Birth:</td>
										      <td align="left"><strong><%= dob %></strong></td>
									        </tr>
										    <tr>
										      <td>Height:</td>
										      <td align="left"><strong><%= height %></strong></td>
									        </tr>
										    <tr>
										      <td>Weight:</td>
										      <td align="left"><strong><%= weight %></strong></td>
									        </tr>
										    <tr>
										      <td>Home Address:</td>
										      <td align="left"><strong><%= address %></strong></td>
									        </tr>
										    <tr>
										      <td>Mobile No:</td>
										      <td align="left"><strong><%= mobileno %></strong></td>
									        </tr>
										    <tr>
										      <td>&nbsp;</td>
										      <td align="left">&nbsp;</td>
									        </tr>
										    <tr>
										      <td>&nbsp;</td>
										      <td>&nbsp;</td>
									        </tr>
									    </table>
										  <h3>Account Information</h3>
                                          <table width="300" border="1" cellspacing="1" cellpadding="0">
										    <tr>
										      <td>Email Address:</td>
										      <td align="left"><strong><%= patientid %></strong></td>
									        </tr>
										    <tr>
										      <td>Username:</td>
										      <td align="left"><strong><%= username %></strong></td>
									        </tr>
										    <tr>
										      <td>Password:</td>
										      <td align="left"><strong><%= password %></strong></td>
									        </tr>
                                            <tr>
										      <td>&nbsp;</td>
										      <td>&nbsp;</td>
									        </tr>
									    </table>
									  </article>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="contact_tab">
                                            <footer>
													<a href="medicals.jsp" class="button alt icon fa-file-o">Medical Record</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="#" class="button alt icon fa-file-o">Continue Reading	</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="#" class="button alt icon fa-file-o">Continue Reading</a>
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

		<!-- Footer Wrapper -->
		<div id="footer-wrapper">
          <footer id="footer" class="container">
            <div class="row">
              <div class="12u">
                <div id="copyright">
                  <ul class="menu">
                    <li>&copy; AKTH eHealthcare. All rights reserved</li>
                    <li>Design: <a href="http://html5up.net">Dgreat I.T Solutions </a></li>
                  </ul>
                </div>
              </div>
            </div>
          </footer>
        </div>
	</body>
</html>