<%@page import="java.awt.EventQueue,
java.awt.event.ActionListener,
java.awt.event.ActionEvent,
java.util.Date,
java.io.*,
java.net.URL,
java.net.HttpURLConnection,
java.io.BufferedReader,
java.util.Properties,
java.sql.Connection,
java.sql.DriverManager,
java.sql.ResultSet,
java.sql.SQLException,
java.sql.Statement,
java.sql.ResultSetMetaData"%>

<%! public String uid = ""; %>

<% if(session.getAttribute("uid")!= null) {
	uid = session.getAttribute("uid").toString();
}
%>
<%

Connection cn = null;
try { Class.forName("com.mysql.jdbc.Driver");
cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehealth", "root", "");
System.out.println("connected");
} catch(Exception e) { System.out.println(e); }
/**
try {
	ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM users WHERE username='admin'"); rs.next();
	System.out.println(rs.getString("password"));
} catch(Exception e1) { System.out.println(e1); }
*/

%>

<%
if(request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
	session.setAttribute("uid", "");
	session.setAttribute("username", "");
	session.setAttribute("password", "");
	session.setAttribute("role", "");
	
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp");
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
		<title>Home -AKTH eHealthcare System</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<style type="text/css">
<!--
.style1 {font-weight: bold}
.style2 {color: #333333}
-->
        </style><noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
	</head>
	<body class="homepage">

		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					<div class="row">
						<div class="12u">
						
							<!-- Header -->
								<header id="header">
								  <div class="inner">
									
										<!-- Logo -->
											<h1><a href="index.html" id="logo"><img src="images/logo.png" alt="" width="80" height="60" border="0" title="" /></a></h1>
											
										
									      <!-- Nav -->
										  <nav id="nav">
											  <ul>
												  <li class="current_page_item"><a href="index.jsp">Home</a></li>
												  <li><a href="main.jsp">Main</a></li>
												  <li>
													  <span>Patient</span>
													  <ul>
														  <li><a href="patientview.jsp">My Page </a></li>
														  <li><a href="patientedit.jsp">Edit Record</a></li>
														  <li><a href="permission.jsp">Request Edit Permission </a></li>
													  </ul>
												  </li>
												  <li><a href="appointment.jsp">Appointment</a></li>
												  <%
												   
												  if(uid.equals("")) {
													 out.println("<li><a href='login.jsp'>Login</a></li>");
												  }
												  else { 
													  out.println("<li><a href='?action=logout'>Logout</a></li>");
													  }
												  %>
												  
												  <li><a href="contact.jsp">Contact Us </a></li>
											  </ul>
										  </nav>
									</div>
								</header>
								
								
								
								

						</div>
					</div>
				</div>
			</div>