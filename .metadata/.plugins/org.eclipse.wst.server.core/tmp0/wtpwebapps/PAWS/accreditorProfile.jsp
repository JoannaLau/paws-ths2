<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> PAASCU - Accreditation Schedule Manager </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
		

		<!-- IMPORTS -->
    <script src='js/jquery.min.js'></script>
    <script src='js/jquery-ui.min.js'></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="css/vendor.css">
    <link href='fullcalendar.css' rel='stylesheet' />
    <link href='calendar/fullcalendar.print.css' rel='stylesheet' media='print' />
	<script src='calendar/lib/moment.min.js'></script>
	<script src='calendar/fullcalendar.min.js'></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href=" css/dataTables.bootstrap.min.css">
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>
	
 	<link title="timeline-styles" rel="stylesheet" href="css/timeline.css">
	
	<!-- END IMPORTS -->

        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <!-- Theme initialization -->
		
		<script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
            {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            }
            else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>

		<script>
		$(document).ready(function() {
			$('#smarttable').DataTable();
		} );
		</script>
		<script>
		$(document).ready(function() {
			$('#smarttable2').DataTable();
		} );
		</script>

<style>

	body {
		
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}
	#bg{
	height: 640px;
	position:fixed;
	}

</style>
    </head>

    <body>
        <div class="main-wrapper">
            <div class="app" id="app">
                <header class="header">
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		</button> </div>
                  
				    <div class="header-block header-block-search hidden-sm-down">
                        <form role="search">
                            <div class="input-container"> <i class="fa fa-search"></i> <input type="search" placeholder="Search">
                                <div class="underline"></div>
                            </div>
                        </form>
                    </div>
					
                     
                    <div class="header-block header-block-nav">
                        <ul class="nav-profile">
                            <li class="notifications new">
                                <a href="" data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <sup>
    			      <span class="counter">1</span>
    			    </sup> </a>
                                <div class="dropdown-menu notifications-dropdown-menu">
                                    <ul class="notifications-container">
                                        <li>
                                            <a href="" class="notification-item">
                                                <div class="img-col">
                                                    <div class="img" style="background-image: url('assets/faces/marcos,nelson.jpg')"></div>
                                                </div>
                                                <div class="body-col">
                                                    <p> <span class="accent">Marcos, Nelson Phd</span> Achievement: <span class="accent">Completed 100th survey</span>. </p>
                                                </div>
                                            </a>
                                        </li>
                                       
                                    </ul>
                                    <footer>
                                        <ul>
                                            <li> <a href="">
    			            View All
    			          </a> </li>
                                        </ul>
                                    </footer>
                                </div>
                            </li>
                            
                        </ul>
                    </div>
                </header>
               <jsp:include page="sidebar.jsp" />
				<article class="content grid-page">
                    <div class="title-block">
                        <h3 class="title" style="float:left;">
							<a href="Accreditors"><em class="fa fa-arrow-circle-left"></em> Accreditor List </a> 
						</h3>
						
						<h3 class="title" style="float:right;">
							<a href="EditAccreditor?accreditorID=<c:out value="${ accreditor.getAccreditorID() }"/>"><em class="fa fa-pencil"></em> Edit</a>
                        </h3>
                    </div>
					
					<section class="section">
                        <div class="row sameheight-container">
                            <div class="col-md-12">
                                <div class="card sameheight-item">
                                    <div class="card-block">
										<section class="section">
											<div class="row">
												<div class="col-md-8">
												<c:set var="acc" scope="session" value="${accreditor}"/>
													<h2 >
													<c:out value="${acc.getFullName()}"/>
													</h2>
													 <p>
													
													
													
													Discipline: <b><c:out value="${acc.getDiscipline()}"/></b><br>
													Areas of Expertise: <b><c:out value="${acc.getPrimaryArea()}"/>, <c:out value="${acc.getSecondaryArea()}"/>, <c:out value="${acc.getTertiaryArea()}"/></b><br>
													Number of Surveys : <b><c:out value="${acc.getTotalSurveys()}"/></b><br>
													<c:out value="${acc.getContact()}"/> <br>													
													E-mail: <c:out value="${acc.getEmail()}"/><br>
													<c:out value="${acc.getCity()}"/>, <c:out value="${acc.getCountry()}"/><br>
													
													</p>
												</div>
												<div class="col-md-4" >
													
												</div>
											</div>
										</section>
                                       
                                      
                                    </div>
									
                                </div>
                            </div>
							
                        </div>
						
						 <div class="row sameheight-container">
                            <div class="col-md-12">
                                <div class="card sameheight-item">
                                    <div class="card-block">
										 <section class="section">
												<br>
														<h5><small><b>Past Accreditations</b></small></h5>
													<hr>
												
													  <table id="smarttable" class="table table-striped table-bordered table-hover">
															<thead>
															  <tr>
																	<th>Institutions Surveyed</th>
																	<th>Programs</th>
																	<th>Visited From</th>
																	<th>Visited To</th>
																</tr>
															</thead>
															
															<c:forEach items="${accreditations}" var="prgs">
																<tr>
																	<td><c:out value="${prgs.getInstitution()}"/></td>
																	<td><c:out value="${prgs.getPrograms()}" escapeXml="false"/></td>
																	<td><c:out value="${prgs.getFrom()}"/></td>
																	<td><c:out value="${prgs.getTo()}"/></td>
																</tr>
																</c:forEach>
													 </table>
										 </section>
									</div>	 
								</div>		 
							</div>			 
						</div>
						 <div class="row sameheight-container">
                            <div class="col-md-12">
                                <div class="card sameheight-item">
                                    <div class="card-block">
										 <section class="section">
												<br>
														<h5><small><b>Affiliated Institutions</b></small></h5>
													<hr>
												
													  <table id="smarttable2" class="table table-striped table-bordered table-hover">
															<thead>
															  <tr>
															  		<th>Type of Affiliation</th>
																	<th>Institution</th>
																	<th>Position/Degree</th>																
																	<th>Date Entered</th>
																	<th>Date Left</th>
														
																   
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${accreditor.getWorks()}" var="works">
																<tr>
																	<td>Work</td>
																	<td><c:out value="${works.getInstitution()}"/></td>
																	<td><c:out value="${works.getPosition()}"/></td>
																	<td><c:out value="${works.getDate_entered()}"/></td>
																	<td><c:out value="${works.getDate_finished()}"/></td>
																</tr>
																</c:forEach>
																
																<c:forEach items="${accreditor.getDegrees()}" var="degs">
																<tr>
																	<td>Education</td>
																	<td><c:out value="${degs.getInstitution()}"/></td>
																	<td><c:out value="${degs.getDegree_name()}"/></td>
																	<td>No Data</td>
																	<td>No Data</td>
																</tr>
																</c:forEach>
															</tbody>
														</table>
										 </section>
									</div>	 
								</div>		 
							</div>			 
						</div>				 
								
								
                    </section><!--main section-->
					
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
				

				
             
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
          
        <script src="js/app.js"></script>
	
    </body>

</html>