<%@include file="header.jsp" %>
<%@page import="java.sql.*"%>
<%! String patid="",patientname = "", drugname="", dosage="", intake="", duration="", note=""; %>

<%
if(session.getAttribute("patid") != null) {
	String patid = session.getAttribute("patid").toString();
	try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM patient WHERE id="+patid); rs.next();

        patientname = rs.getString("fullname");		
		
	} catch(Exception e1) { System.out.println(e1); }
}
%>



<%
if(request.getParameter("submit") != null) {
	String patid =(session.getAttribute("patid")).toString();
	String patientname =(session.getAttribute("patientname")).toString();
	String drugname = request.getParameter("drugname");
	String dosage = request.getParameter("dosage");
	String intake = request.getParameter("intake");
	String duration = request.getParameter("duration");
	String note = request.getParameter("note");
	
	try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO prescription (PATIENTID, PATIENTNAME, DRUGNAME, DOSAGE, INTAKE, 		DURATION, NOTES) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)");
		
			ps.setString(1, patid);
			ps.setString(2, patientname);
			ps.setString(3, drugname);
			ps.setString(4, dosage);
			ps.setString(5, intake);
			ps.setString(6, duration);
			ps.setString(7, note);
			ps.executeUpdate();
			System.out.println("Record Saved!");
            	} catch (SQLException e) { e.printStackTrace(); }
                
            response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "docmain.jsp");
}

else if(request.getParameter("more") != null); {
	String drugname = request.getParameter("drugname");
	String dosage = request.getParameter("dosage");
	String intake = request.getParameter("intake");
	String duration = request.getParameter("duration");
	String note = request.getParameter("note");
	
	try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO prescription (PATIENTID, PATIENTNAME, DRUGNAME, DOSAGE, INTAKE, 		DURATION, NOTES) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)");
		
			ps.setString(1, patid);
			ps.setString(2, patientname);
			ps.setString(3, drugname);
			ps.setString(4, dosage);
			ps.setString(5, intake);
			ps.setString(6, duration);
			ps.setString(7, note);
			ps.executeUpdate();
			System.out.println("Record Saved!");
            	} catch (SQLException e) { e.printStackTrace(); }
                
            response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "prescription.jsp");
}

	
%>
<!DOCTYPE HTML>
<!--
	ZeroFour by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>No Sidebar - ZeroFour by HTML5 UP</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
	</head>
	<body class="no-sidebar">

		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					<div class="row">
						<div class="12u">
						
							<!-- Header -->
								<header id="header">
									<div class="inner">
									
										<!-- Logo -->
											<h1><a href="index.html" id="logo">ZeroFour</a></h1>
										
										<!-- Nav -->
											<nav id="nav">
												<ul>
													<li><a href="index.html">Home</a></li>
													<li>
														<span>Dropdown</span>
														<ul>
															<li><a href="#">Lorem ipsum dolor</a></li>
															<li><a href="#">Magna phasellus</a></li>
															<li>
																<span>Phasellus consequat</span>
																<ul>
																	<li><a href="#">Lorem ipsum dolor</a></li>
																	<li><a href="#">Phasellus consequat</a></li>
																	<li><a href="#">Magna phasellus</a></li>
																	<li><a href="#">Etiam dolore nisl</a></li>
																</ul>
															</li>
															<li><a href="#">Veroeros feugiat</a></li>
														</ul>
													</li>
													<li><a href="left-sidebar.html">Left Sidebar</a></li>
													<li><a href="right-sidebar.html">Right Sidebar</a></li>
													<li class="current_page_item"><a href="no-sidebar.html">No Sidebar</a></li>
												</ul>
											</nav>
									
									</div>
								</header>

						</div>
					</div>
				</div>
			</div>
		
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
													<h2>&nbsp;</h2>
													<p>Enter new patient prescription.</p>
												</header>
												
												<span class="image featured"><img src="images/db.jpg" alt="" height="300" /></span>
												
											  
											  <p>&nbsp;</p>
											<form id="form1" name="form1" method="post">	
												 <table width="300" border="1" cellspacing="1" cellpadding="0">
										    <tr><td>Patient ID:</td><td><input name='user' type='text' id='user'></td></tr>
										    		  <tr><td>Drug Name:</td><td><input name='drugname' type='text' id='drugname'></td></tr>
										    		  <tr><td>Dosage:</td><td><input name='dosage' type='text' id='dosage'></td></tr>
                                                      <tr><td>Intake:</td><td><input name='intake' type='text' id='intake'></td></tr>
                                                      <tr><td>Duration:</td><td><input name='duration' type='text' id='duration'></td></tr>
                                                      <tr><td>Note:</td><td><textarea name="name" cols="" rows="3"></textarea></tr>
                                                      <td>&nbsp;</td>
										      <td align="left"><input type="submit" name="more" id="more" value="More +">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;          <input type="submit" name="done" id="done" value="Done"></td>
										      </tr>
								              </table>
                                              </form>
											</article>
								
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		<!-- Footer Wrapper -->
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