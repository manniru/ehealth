<%@include file="header.jsp" %>
		
		
		<!-- Main Wrapper -->
			<div id="main-wrapper">
				<div class="wrapper style1">
					<div class="inner">
				
						<!-- Feature 1 -->
							<section class="container box feature1">
								<div class="row">
									<div class="12u">
										<header class="first major">
										  <p align="center" class="style2">Welcome <%= session.getAttribute("username") %>.... </p>
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
	
<%@include file="footer.jsp" %>