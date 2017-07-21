<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<!doctype html>
<html class="no-js" lang="en">

    <head>
     	 <!-- IMPORTS -->
    <script src='js/jquery.min.js'></script>
	
    <script src='js/jquery-ui.min.js'></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="css/vendor.css">
   
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href=" css/dataTables.bootstrap.min.css">
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>
	
 	<link title="timeline-styles" rel="stylesheet" href="css/timeline.css">
	
	<!-- END IMPORTS -->
    	
    	
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> PAASCU - Accreditation Schedule Manager </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
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

 

    $('#smarttable').DataTable( {
        initComplete: function () {
            this.api().columns().every( function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                    .appendTo( $(column.footer()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        }
    } );
		
} );
</script>

<style>

	#contenthole{
		-webkit-box-shadow: 0px 4px 13px -4px rgba(0,0,0,0.5);
		-moz-box-shadow: 0px 4px 13px -4px rgba(0,0,0,0.5);
		box-shadow: 0px 4px 13px -4px rgba(0,0,0,0.5);
		padding:10px;
		background-color: #f8f8f8;
	}

	
	#smarttable th, #smarttable td {		
		text-align: left;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;	}
		
	#smarttable th{
	
		color:#3c4731;
		font-size:110%;		}

	#smarttable td{
		padding:15px;
		padding-left:10px;
		border: none;
		color:#3c4731;		}


	#smarttable tr:nth-child(even){
		background-color:#e6f2da;}
	
	.container{
		width: 125%;
		overflow:hidden;
		display:block;
		height: 130px;
		z-index:-1;
		margin-left:-15px;}
		


	#bgvid{
		position:relative;
		top:-400px;
		margin-top:0px;
		width:115%	}

	body {		
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;	}
		
	#bg{
		height: 640px;
		position:fixed;	}
	
	#main{
		position:relative;
		top:-290px;	}
	
	#pnum_danger,#pnum_info,#pnum_warning,#pnum_primary{
		font-size:75px; 
		text-align:center;
		margin-left: -2px;
		padding: 0;
		
		line-height:85px;	}
		
	#pnum_danger{
	color:#ff2b2b;	}
	
	#pnum_warning{
		color:#fe8832;	}
	
	#pnum_info{
		color:#5ecdf3;	}
	
	#pnum_primary{
		color:#85CE36;	}
	
	#psub{
		font-size:17px; 
		color:#bcbcbc;
		text-align:center;
		margin-top: 6px;
		padding: 0;
		line-height:20px;	}
	
	#bc {
		color:white;	}
	
	#bc:hover { 
		color:#85CE36;	}
	
	#welcome{
		position:relative;
		top:-65px;
		color:white;
		left:20px;
		font-family:Existence-Light;	}
		
	.h1{
		font-size:100%;	}
	
	@font-face {
		font-family: Existence-Light;
		src: url(fonts/Roboto-Thin.ttf);}
		
	@font-face {
		font-family: Existence-Medium;
		src: url(fonts/Roboto-Regular.ttf);	}
			
	#notifcard{
		-webkit-box-shadow: 0px 1px 5px 0px rgba(50, 50, 50, 0.58);
		-moz-box-shadow:    0px 1px 5px 0px rgba(50, 50, 50, 0.58);
		box-shadow:         0px 1px 5px 0px rgba(50, 50, 50, 0.58);
		width:87%;
		left:15px;	}
	
	#customheader{
		overflow:hidden;
		top:122px;  
		height:10px; 
		-webkit-box-shadow: 0px 2px 6px 2px rgba(50, 50, 50, 0.58);
		-moz-box-shadow:    0px 2px 6px 2px rgba(50, 50, 50, 0.58);
		box-shadow:         0px 2px 7px 2px rgba(50, 50, 50, 0.58); 
		font-family:Existence-Medium;
		color:#f4f4f4;
		font-size:90%;
		/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#e2e2e2+0,dbdbdb+50,d1d1d1+51,fefefe+100;Grey+Gloss+%231 */
		background: rgb(226,226,226); /* Old browsers */
		background: -moz-linear-gradient(top,  rgba(226,226,226,1) 0%, rgba(219,219,219,1) 50%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%); /* FF3.6-15 */
		background: -webkit-linear-gradient(top,  rgba(226,226,226,1) 0%,rgba(219,219,219,1) 50%,rgba(209,209,209,1) 51%,rgba(254,254,254,1) 100%); /* Chrome10-25,Safari5.1-6 */
		background: linear-gradient(to bottom,  rgba(226,226,226,1) 0%,rgba(219,219,219,1) 50%,rgba(209,209,209,1) 51%,rgba(254,254,254,1) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#fefefe',GradientType=0 ); /* IE6-9 */	}
	
	#customheader h2{
	color:black;	}
		
	#maincard{
		width:100%;
		padding:0px;
		background-color: #ffffff;
		top:-50px;
		margin-bottom: 10px;
		margin-top: 0px;
		height:700px;
		border-radius: 3px;
	   
		-webkit-box-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);
		-moz-box-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);
		box-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);	}
		
</style>

<script>
	j$ = jQuery.noConflict();
	j$(document).ready( function () {
		var contactTable = j$('[id$="smarttable"]').DataTable({
			order: [[1, 'asc']],
			
			initComplete: function() {
				var api = this.api();
				var select = j$('[id$=educLevelsSelect]');
				api.column(0).data().unique().sort().each( function ( d, j ) {
					select.append( '<option value="'+d+'">'+d+'</option>' )
				} );   
			}
		});
	
		j$('[id$=educLevelsSelect]').change(function() {
			var val = j$.fn.dataTable.util.escapeRegex(
				j$(this).val()
			);
			contactTable.column(0)
				.search( val == 'All' ? '' : '^'+val+'$', true, false )
				.draw();
		});
	});

		/* 	$(document).ready(function() {
				
				
				
				
				
				var educLevels = document.getElementById('educLevelSelect');

				
				//EVENT LISTENER FOR CHOOSING A SYSTEM, CHANGING THE INSTITUTIONS AND SHOWING WHAT'S UNDER THAT SYSTEM
				$('#educLevelSelect').on("change", function(event){
					var educLevelID = $('#educLevelSelect').find(":selected").val();
					

					if(educLevelID == 0)
					{
						$('#tableInstitutions').empty();
						
						$.getJSON("AllInstitutionsLoader", function(data){
							
							if(data.length == 0)
								{
								}
							else
								{
								
								$.each(data, function (key, value){
								
									var tr = document.createElement("tr");
									tr.setAttribute("id", "trID");
									
									var educLevel = value.educLevel;
									var institutionID = value.institutionID;
									var name = value.institutionName;
									var systemName = value.system;
									var acronym = value.acronym;
									var dateAdded = value.dateAdded;
									var city = value.city;
									
									var td1 = document.createElement("td");
									var td2 = document.createElement("td");
									var td3 = document.createElement("td");
									var td4 = document.createElement("td");
									var td5 = document.createElement("td");
									var td6 = document.createElement("td");
									var td7 = document.createElement("td");
									

									td1.appendChild(document.createTextNode(educLevel));
									td2.appendChild(document.createTextNode(name));
									td3.appendChild(document.createTextNode(systemName));
									td4.appendChild(document.createTextNode(acronym));
									td5.appendChild(document.createTextNode(dateAdded));
									td6.appendChild(document.createTextNode(city));
									
									
									tr.appendChild(td1);
									tr.appendChild(td2);
									tr.appendChild(td3);
									tr.appendChild(td4);
									tr.appendChild(td5);
									tr.appendChild(td6);
									
									
									var a1 = document.createElement("a");
									var a2 = document.createElement("a");
									var a3 = document.createElement("a");
									
									a1.setAttribute("href", "ViewInstitution?institutionID=" + institutionID);
									a2.setAttribute("href", "EditInstitution?institutionID=" + institutionID);
									a3.setAttribute("href", "DeleteInstitution?institutionID=" + institutionID);
									
									a1.innerHTML = "View";
									a2.innerHTML = "Edit";
									a3.innerHTML = "Delete";
									
									td7.appendChild(a1);
									td7.appendChild(a2);
									td7.appendChild(a3);
						        	
									tr.appendChild(td7);
								
									var table = document.getElementById("tableInstitutions");
									table.appendChild(tr);
								
								});	
							}
						});
					}
					
					else
					{
						$('#tableInstitutions').empty();
					
						$.getJSON("InstitutionsEducLevelLoader?educLevelID=" + educLevelID, function(data){
							
							if(data.length == 0)
								{
								}
							else
								{
								
								$.each(data, function (key, value){
								
									var tr = document.createElement("tr");
									tr.setAttribute("id", "trID");
									
									var educLevel = value.educLevel;
									var institutionID = value.institutionID;
									var name = value.institutionName;
									var systemName = value.system;
									var acronym = value.acronym;
									var dateAdded = value.dateAdded;
									var city = value.city;
									
									var td1 = document.createElement("td");
									var td2 = document.createElement("td");
									var td3 = document.createElement("td");
									var td4 = document.createElement("td");
									var td5 = document.createElement("td");
									var td6 = document.createElement("td");
									var td7 = document.createElement("td");
									

									td1.appendChild(document.createTextNode(educLevel));
									td2.appendChild(document.createTextNode(name));
									td3.appendChild(document.createTextNode(systemName));
									td4.appendChild(document.createTextNode(acronym));
									td5.appendChild(document.createTextNode(dateAdded));
									td6.appendChild(document.createTextNode(city));
									
									
									tr.appendChild(td1);
									tr.appendChild(td2);
									tr.appendChild(td3);
									tr.appendChild(td4);
									tr.appendChild(td5);
									tr.appendChild(td6);
									
									
									var a1 = document.createElement("a");
									var a2 = document.createElement("a");
									var a3 = document.createElement("a");
									
									a1.setAttribute("href", "ViewInstitution?institutionID=" + institutionID);
									a2.setAttribute("href", "EditInstitution?institutionID=" + institutionID);
									a3.setAttribute("href", "DeleteInstitution?institutionID=" + institutionID);
									
									a1.innerHTML = "View";
									a2.innerHTML = "Edit";
									a3.innerHTML = "Delete";
									
									td7.appendChild(a1);
									td7.appendChild(a2);
									td7.appendChild(a3);
						        	
									tr.appendChild(td7);
								
									var table = document.getElementById("tableInstitutions");
									table.appendChild(tr);
								});	
							}
						});
					}
				});
			}); */
			</script>
    </head>

    <body>
        <div class="main-wrapper">
            <div class="app" id="app">
               
                <jsp:include page="sidebar.jsp" />
				
                <div class="container">
	<video poster="assets/banner.jpg" id="bgvid"  playsinline autoplay muted loop>
  <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->

<source src="assets/vid.mp4" type="video/mp4">
</video>
</div>
            <div id="welcome">
			<h1>List of Institutions</h1>
			
						<button type="button"  style="float:right; position:relative;left:-50px; top:-52px; color:#3c4731;" class="btn btn-oval btn-secondary" onclick="location.href='addInstitution.jsp';"><em class="fa fa-plus"></em><b> Add Institution</b></button>
                   
			</div>
			   <header class="header" id="customheader">
			   
					
                </header>
                <article class="content dashboard-page"  >
                    <section class="section" style="position: relative; top:-135px; left:-25px; width:105%;" >
                       <div class="table-responsive" style="width:100%; float:right;" id="contenthole">
										
											<br>
											<label for="educLevels">Education Level: </label>
										<!-- 	<select id="educLevelSelect" name="smarttable_length" aria-controls="smarttable" class="form-control input-sm" style="width:50%">
												<option value="0">ALL</option>
												<option value="1">Elementary Education</option>
												<option value="2">Secondary Education</option>
												<option value="3">Integrated Basic Education</option>
												<option value="4">Tertiary Education</option>
												<option value="5">Graduate Education</option>
												<option value="6">Medical Education</option>
												<option value="7">CECSTE</option>
												
											</select> -->
											
											<select id="educLevelsSelect"><option value="All">All</option></select>
 
											<br>
											     <table id="smarttable" class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                      <tr>
                                                            <th>Education Level</th>
                                                            <th>Institution Name</th>
                                                            <th>System</th>
                                                            <th>Acronym</th>
                                                            <th>Date of Membership</th>
                                                            <th>City</th>
                                                            
                                                             <th>Controls</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id = "tableInstitutions">
													
													 <c:forEach items="${institutions}" var="inst" >
														<tr>
															<td> <c:out value="${inst.getEducLevel()}"/> 
															<td> <c:out value="${inst.getName()}"/> </td>
															<td> <c:out value="${inst.getSchoolSystemName()}"/> </td>
															<td> <c:out value="${inst.getInstitutionAcronym()}"/> </td>
															<td> <c:out value="${inst.getDateAdded()}"/> </td>
															<td> <c:out value="${inst.getCity()}"/> </td>
															
															<td>
															<a href="ViewInstitution?institutionID=<c:out value='${inst.getInstitutionID()}'/>">View</a>
												         	 <a href="EditInstitution?institutionID=<c:out value='${inst.getInstitutionID()}'/>">Edit</a>
												        	  <a href="DeleteInstitution?institutionID=<c:out value='${inst.getInstitutionID()}'/>">Delete</a></td>
												        	</td>
														</tr>
													</c:forEach>
														
                                                    </tbody>
                                                </table>
                                            </div>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>
						
                    </section>
                </article>
             
             
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