<%@include file="header.jsp" %>
<%
if(request.getParameter("submit") != null) {
	String patid="", patientname="", mobileno="";
    
	String patientid = request.getParameter("pid");
	
try {
	ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM patient WHERE id="+patientid); rs.next();
	
	patientname = rs.getString("fullname");
	mobileno = rs.getString("mobileno");
	patid = rs.getString("id");
    
	session.setAttribute("patid", patid);
	session.setAttribute("patientname", patientname);
	session.setAttribute("mobileno", mobileno);
	}catch(Exception e1) { out.println("Patient Does not Exist");} 
    
    response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "diagnosis.jsp");
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
												  <p>ENTER PATIENT ID TO CONTINUE...</p>
										</header>
										<form name="form2" method="post" action="">
										  <label>Patient ID:
										    <input type="text" name="pid" id="pid">
										    <br>
										    <input type="submit" name="submit" id="submit" value="Proceed &gt;&gt;">
										  </label>
										</form>
										<h2>&nbsp;</h2>
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