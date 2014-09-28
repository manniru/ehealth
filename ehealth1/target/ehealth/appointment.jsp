<%@include file="header.jsp" %>
<%@ page import="java.io.*,java.util.*" %>
<%! String ap=""; %>
<%
//session.setAttribute("ap", "");
if(request.getParameter("submit") != null) {
	 Enumeration paramNames = request.getParameterNames();

	   while(paramNames.hasMoreElements()) {
		   String user = session.getAttribute("username").toString();
		   ResultSet r4 = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE username='"+user+"'"); r4.next();
		   String uid = r4.getString("id");
	      String name = (String)paramNames.nextElement();
	      String value = request.getHeader(name);
	      //out.print("<tr><td>" + name + "</td>\n");	      
	      //out.println("<td> " + value + "</td></tr>\n");
	      if(!name.equals("submit")) {
	    	  int pid=5;
	    	  String no = name.substring(4, 5);
	    	  String did = name.substring(5, 6);
	    	  try {cn.createStatement().execute("UPDATE appointment SET slot"+no+"="+uid+" WHERE doctorid="+did);
	  		} catch(Exception e) { System.out.println(e); }
	    	  //System.out.println(no);
	    	  
	    	  session.setAttribute("ap", "disabled");
	    	  //System.out.println(session.getAttribute("ap").toString());
	      }
	     // else { session.setAttribute("ap", ""); }
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
	String id = rs.getString("id");
	String doctorid = rs.getString("doctorid");
	ResultSet rs2 = cn.createStatement().executeQuery("SELECT * FROM `users` WHERE id="+doctorid); rs2.next();
	String doctorname = rs2.getString("fullname");
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

									<!-- Article list -->
										<section class="box article-list">
											<h2 class="icon fa-file-text-o">From the blog</h2>
											
											<!-- Excerpt -->
												<article class="box excerpt">
													<a href="#" class="image left"><img src="images/pic04.jpg" alt="" /></a>
													<div>
														<header>
															<span class="date">December 20, 2012</span>
															<h3><a href="#">On the eve of the Mayanocalypse</a></h3>
														</header>
														<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus 
														semper mod quisturpis nisi consequat etiam lorem. Phasellus quam turpis, 
														feugiat et sit amet ornare in, hendrerit in lectus semper mod quis eget mi dolore.</p>
													</div>
												</article>

											<!-- Excerpt -->
												<article class="box excerpt">
													<a href="#" class="image left"><img src="images/pic05.jpg" alt="" /></a>
													<div>
														<header>
															<span class="date">December 15, 2012</span>
															<h3><a href="#">Life as a self-aware meme</a></h3>
														</header>
														<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus 
														semper mod quisturpis nisi consequat etiam lorem. Phasellus quam turpis, 
														feugiat et sit amet ornare in, hendrerit in lectus semper mod quis eget mi dolore.</p>
													</div>
												</article>

											<!-- Excerpt -->
												<article class="box excerpt">
													<a href="#" class="image left"><img src="images/pic06.jpg" alt="" /></a>
													<div>
														<header>
															<span class="date">December 12, 2012</span>
															<h3><a href="#">Facepalm moments in history</a></h3>
														</header>
														<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus 
														semper mod quisturpis nisi consequat etiam lorem. Phasellus quam turpis, 
														feugiat et sit amet ornare in, hendrerit in lectus semper mod quis eget mi dolore.</p>
													</div>
												</article>

										</section>
								</div>
								<div class="4u">
								
									<!-- Spotlight -->
										<section class="box spotlight">
											<h2 class="icon fa-file-text-o">Spotlight</h2>
											<article>
												<a href="#" class="image featured"><img src="images/pic07.jpg" alt=""></a>
												<header>
													<h3><a href="#">Why staplers matter</a></h3>
													<p>They hold things together</p>
												</header>
												<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus semper mod 
												quisturpis nisi consequat ornare in, hendrerit in lectus semper mod quis eget mi quat etiam 
												lorem. Phasellus quam turpis, feugiat sed et lorem ipsum dolor consequat dolor feugiat sed
												et tempus consequat etiam.</p>
												<p>Lorem ipsum dolor quam turpis, feugiat sit amet ornare in, hendrerit in lectus semper 
												mod quisturpis nisi consequat etiam lorem sed amet quam turpis.</p>
												<footer>
													<a href="#" class="button alt icon fa-file-o">Continue Reading</a>
												</footer>
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
						<div class="3u">
						
							<!-- Links -->
								<section>
									<h2>Filler Links</h2>
									<ul class="divided">
										<li><a href="#">Quam turpis feugiat dolor</a></li>
										<li><a href="#">Amet ornare in hendrerit </a></li>
										<li><a href="#">Semper mod quisturpis nisi</a></li>
										<li><a href="#">Consequat etiam phasellus</a></li>
										<li><a href="#">Amet turpis, feugiat et</a></li>
										<li><a href="#">Ornare hendrerit lectus</a></li>
										<li><a href="#">Semper mod quis et dolore</a></li>
										<li><a href="#">Amet ornare in hendrerit</a></li>
										<li><a href="#">Consequat lorem phasellus</a></li>
										<li><a href="#">Amet turpis, feugiat amet</a></li>
										<li><a href="#">Semper mod quisturpis</a></li>
									</ul>
								</section>
						
						</div>
						<div class="3u">
						
							<!-- Links -->
								<section>
									<h2>More Filler</h2>
									<ul class="divided">
										<li><a href="#">Quam turpis feugiat dolor</a></li>
										<li><a href="#">Amet ornare in in lectus</a></li>
										<li><a href="#">Semper mod sed tempus nisi</a></li>
										<li><a href="#">Consequat etiam phasellus</a></li>
									</ul>
								</section>
						
							<!-- Links -->
								<section>
									<h2>Even More Filler</h2>
									<ul class="divided">
										<li><a href="#">Quam turpis feugiat dolor</a></li>
										<li><a href="#">Amet ornare hendrerit lectus</a></li>
										<li><a href="#">Semper quisturpis nisi</a></li>
										<li><a href="#">Consequat lorem phasellus</a></li>
									</ul>
								</section>
						
						</div>
						<div class="6u">
						
							<!-- About -->
								<section>
									<h2><strong>ZeroFour</strong> by HTML5 UP</h2>
									<p>Hi! This is <strong>ZeroFour</strong>, a free, fully responsive HTML5 site
									template by <a href="http://n33.co/">AJ</a> for <a href="http://html5up.net/">HTML5 UP</a>.
									It's <a href="http://html5up.net/license/">Creative Commons Attribution</a>
									licensed so use it for any personal or commercial project (just credit us
									for the design!).</p>
									<a href="http://html5up.net" class="button alt icon fa-arrow-circle-right">More at HTML5 UP</a>
								</section>
						
							<!-- Contact -->
								<section>
									<h2>Get in touch</h2>
									<div>
										<div class="row">
											<div class="6u">
												<dl class="contact">
													<dt>Twitter</dt>
													<dd><a href="#">@untitled-corp</a></dd>
													<dt>Facebook</dt>
													<dd><a href="#">facebook.com/untitled</a></dd>
													<dt>WWW</dt>
													<dd><a href="#">untitled.tld</a></dd>
													<dt>Email</dt>
													<dd><a href="#">user@untitled.tld</a></dd>
												</dl>
											</div>
											<div class="6u">
												<dl class="contact">
													<dt>Address</dt>
													<dd>
														1234 Fictional Rd<br />
														Nashville, TN 00000-0000<br />
														USA
													</dd>
													<dt>Phone</dt>
													<dd>(000) 000-0000</dd>
												</dl>
											</div>
										</div>
									</div>
								</section>
						
						</div>
					</div>
					<div class="row">
						<div class="12u">
							<div id="copyright">
								<ul class="menu">
									<li>&copy; Untitled. All rights reserved</li>
									<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
								</ul>
							</div>
						</div>
					</div>
				</footer>
			</div>

	</body>
</html>