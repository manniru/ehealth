<%@include file="header.jsp" %>
<%!String name="", prescription="", diagnosis="", notes="", pnotes="", pdate="", date="", drugname="", dosage="", intake="", duration="", status = ""; %>
<%! int doctorid=0 ,patientid=0;  %>
<%! String uid2=""; %>

<%
if(session.getAttribute("uid") != null) {
	uid2 = session.getAttribute("uid").toString();
	System.out.println(uid);
	try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM diagnosis WHERE patientid=(SELECT id FROM patient WHERE uid="+uid+")"); rs.next();
		patientid = rs.getInt("patientid");
		doctorid = rs.getInt("doctorid");
		name = rs.getString("patientname");		
		diagnosis = rs.getString("diagnosis");
		notes = rs.getString("notes");
	} catch(Exception e1) { System.out.println("e1="+e1); }
	
	/**try {
		ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM `prescription` WHERE patientid=(SELECT id FROM `patient` WHERE uid="+uid); rs.next();
		drugname = rs.getString("drugname");
		dosage = rs.getString("dosage");		
		intake = rs.getString("intake");
		duration = rs.getString("duration");
		status = rs.getString("status");
		pdate = rs.getString("status");
		pnotes = rs.getString("notes");

	} catch(Exception e1) { System.out.println(e1); }**/
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
													<h2>Medical Records</h2>
													<p>All informations are as at the previous visit.</p>
												</header>
												
												<span class="image featured"><img src="images/pic08.jpg" alt="" /></span>
												
											  <h2>Medical records contain sensitive information and should not be shared with third parties.</h2>
												<h2>If you are in this page mistakingly, please click close.</h2>
												<p>&nbsp;</p>
												
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
										      <td>Last Seen Physician:</td>
										      <td align="left"><strong><%= doctorid %></strong></td>
									        </tr>
										    <tr>
										      <td>Most Recent Diagnosis:</td>
										      <td align="left"><strong><%= diagnosis %></strong></td>
									        </tr>
										    <tr>
										      <td>Most Recent Prescription:</td>
										      <table width="500" border="1" cellspacing="1" cellpadding="0">
						      						<tr>
						        						<td>Drug</td>
						       							<td>Dosage</td>
						        						<td>Intake</td>
						        						<td>Duration</td>
						        						<td>Status</td>
					          						</tr>
                                                    <tr>
                                                    <%
                                                    System.out.println(uid2);
                                                    try {
                                                    	ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM prescription WHERE patientid=(SELECT id FROM patient WHERE uid="+uid2+")");
                                                    	while(rs.next()) {
                                                    	
                                                    		out.println("<tr><td>"+rs.getString("drugname")+
                                                    				"</td><td>"+rs.getString("dosage")+
                                                    				"</td><td>"+rs.getString("intake")+
                                                    				"</td><td>"+rs.getString("duration")+
                                                    				"</td><td>"+rs.getString("status")+
                                                    				"</td></tr>");
                                                    	}
                                                    } catch(Exception e) { System.out.println("e2"+e); }
                                                    
                                                    %>
													</tr>
										    <tr>
										      <td>Conclusions and Extras:</td>
										      <td align="left"><strong><%= notes %>.|<%=pnotes%></strong></td>
									        </tr>
										    <tr>
										      <td>Last visit:</td>
										      <td align="left"><strong><%=date%></strong></td>
									        </tr>
										    <tr>
										      <td>&nbsp;</td>
										      <td align="left">&nbsp;</td>
									        </tr>
										 </table>
											</article>
								
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
<%@include file="footer.jsp" %>
