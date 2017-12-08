<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html class="no-js" lang="en">

    <head>
    <script src='js/jquery.min.js'></script>
    <script src='js/jquery-ui.min.js'></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
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
        </script><link href='fullcalendar.css' rel='stylesheet' />
        
<link href='calendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='calendar/lib/moment.min.js'></script>
<script src='calendar/fullcalendar.min.js'></script>



<script>

		

function addAlert(asd){
	$('#section').append('<div class="alert alert-success"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Success!</strong> Successfully added survey called: '+asd +'.</div> <br>');
}



function addProgram(){
	
	var strUser = $('#program option:selected').text();
	
	var x = document.createElement("LI");
	
	x.innerHTML = "" + strUser + "";
	x.classList.add("list-group-item");
	
	var b = document.createElement("BUTTON");
	b.type="button";
	b.innerHTML = "<i class='fa fa-trash-o'></i> Delete";
	b.classList.add("btn");
	b.classList.add("btn-link");
	b.classList.add("btn-sm");
	b.onclick = function (){
		this.parentNode.parentNode.removeChild(this.parentNode);
	}
	b.style = "float:right;";
	
	$('#addedList').append(x);
	x.appendChild(b);
	
	
	var lal = document.getElementById("added");
	lal.scrollTop = lal.scrollHeight;
	}	
	
	

function changeDetails(){
	$("#progProponents").className = "progress-bar progress-bar-success progress-bar-striped";
	$("#progDetails").className = "progress-bar progress-bar-success";
	$("#progSure").className = "progress-bar progress-bar-success";
}
</script>
<style>

	body {
		
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: -35px auto;
		padding: 10px;
background: rgba(255,255,255,1);
background: -moz-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(255,255,255,1)), color-stop(47%, rgba(246,246,246,1)), color-stop(100%, rgba(237,237,237,1)));
background: -webkit-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -o-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -ms-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed', GradientType=1 );	
	 box-shadow: 1px 2px 5px #C0C0C0;
	}
	
	.fc-day-number{
		color: black;
	}
	
	#bg{
	height: 640px;
	position:fixed;
	}
	
	#progItem{
	
    border: 1px solid #ececec;
    border-radius: 10px;
	padding: 5px 5px 5px 5px;
	}

</style>
    </head>

    <body>
    	 
        <div class="main-wrapper">
      				
        			
      			</div>
      			
    		

  	
			
            <div class="app" id="app">
                
            <jsp:include page="sidebar.jsp" />
				
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
				
                <article class="content dashboard-page">
				 <div class="title-block">
                        <h3 class="title" style="float:left;">
                        
							<a href="ViewInstitution?institutionID=<%=request.getParameter("ID") %>"> <em class="fa fa-arrow-circle-left"></em> <%=request.getParameter("Name") %></a> 
						</h3>
			     </div>
				<section class="section" id="section2"> 
    					<form method="POST" action="AddProgramToInst" class="form">
    					<div id="add" style="float:left; width: 100%; height: 460px;" class="card sameheight-item">
    					<div class="card-block">
    					<h3>Select General Field of Discipline</h3>
    					<div class="form-group">
  						<select name = "general" class="form-control" id="program">
  						<%@page import="java.util.ArrayList"%>
  						<%@page import="Models.Program"	%>
  						<%@page import="Utilities.ProgramUtil" %>
  						<%ArrayList<Program> programs = new ArrayList<Program>();%>
  						<%ProgramUtil progUtil = new ProgramUtil();%>
  						<%programs = progUtil.getPrograms(); %>
  						<option><i></i></option>
  							<%for(Program temp: programs){ %>
  							<option value=<%=temp.getProgramID()%> ><%=temp.getName() %></option>
    						<%} %>
  						</select>
					</div>
					<br><br>
					<div class="form-group">
						<label>Specific Program Name: </label><input type="text" style="width: 100%;" placeholder="Enter Specific Name of the Program" class="form-control underlined" name="specific" id="surveyName">
  						</div>
  						<input type="hidden" name="instID" value=<%=request.getParameter("ID") %>>
  						<br>
  						<button type="submit" class="btn btn-success"  style="float:right;">
  						<em class="fa fa-floppy-o"></em> Save Program
  						</button>
  						</div>
  						</div>
  					
  					
  					
        			</form>
        				
        			</section>
        			<hr>
        			
  						
  						
  					 </article>
  					</div>
					
				  
               
             
             
        		  
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
       </div></div>
        <script src="js/app.js"></script>
		
		
		</body>

</html> --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en">

    <head>
<!-- IMPORTS -->
    
    <script src='js/jquery.min.js'></script>
<!--     <script src='js/jquery-ui.min.js'></script> -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="css/vendor.css">
<!--     <link href='fullcalendar.css' rel='stylesheet' /> -->
<!--     <link href='calendar/fullcalendar.print.css' rel='stylesheet' media='print' /> -->
<!-- 	<script src='calendar/lib/moment.min.js'></script> -->
	<link rel="stylesheet" href="chosen/chosen.css">
 	<script src="chosen/chosen.jquery.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
	
	
<!--  	<link title="timeline-styles" rel="stylesheet" href="css/timeline.css"> -->
 	<script src="js/bootstrap-datepicker.min.js"></script>
 	<link rel="stylesheet" href="css/bootstrap-datepicker.css">
 	
    
    
<!-- 	<link title="timeline-styles" rel="stylesheet" href="css/datepicker.css"> -->
	<!-- END IMPORTS -->
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


<script >	

$(document).ready(function() {
	getPrograms();
	$('#programForm').chosen().change(function(){
		document.getElementById('programID').value= $('#programForm').find(":selected").val();
		
	});
});

function getPrograms(){
	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
	var obj = document.getElementById('programForm');
	
	$.getJSON("AllProgramsLoader", function(data){
		var option = document.createElement("option");
		option.text = "";
		option.value = 0;
		obj.add(option);
		$.each(data, function (key, value){
			var option = document.createElement("option");
			option.text = value.name;
			option.value = value.programID;
			obj.add(option);
			
		});	
		$('#programForm').trigger("chosen:updated");
	});
	
}

function validateForm() {
	alert($('#programID').val());
	   location.href = 'AddProgramToInst?instID=' + ${ID} + '&educLevelID=' + $("#educLevel option:selected").val() + '&programID=' + $('#programID').val() + '&degreeName=' + $('#degName').val();
       
	   alert('Accreditor successfully added! Redirecting you to the accreditors page...');
  //  document.location.href = "Accreditors"; 
}

</script>
<!-- 
<script>

function validateForm() {
	
	
	var ssName = document.forms["addInstForm"]["ssName"].value;
	var institutionName = document.forms["addInstForm"]["institutionName"].value;
    var institutionName = document.forms["addInstForm"]["institutionName"].value;
    var institutionAcronym = document.forms["addInstForm"]["institutionAcronym"].value;
    var membershipDate = document.forms["addInstForm"]["membershipDate"].value;
    var city =  document.forms["addInstForm"]["city"].value;
    
    var entry = ssName +"|"+institutionName+"|"+city
   
    if(duplicateCheck(entry)){
    if(ssName=="0"){
    	alert("School System must be selected");
        return false;	
    }    
    else if (institutionName == "") {
        alert("Institution Name must be filled out");
        return false;
    }
    else if (institutionAcronym == "") {
        alert("Institution Acronym must be filled out");
        return false;
    }
    else if (membershipDate == "") {
        alert("Membership Date must be filled out");
        return false;
    }
    else if (city == "") {
        alert("City must be filled out");
        return false;
    }
    else{
    	alert("succesfully added institution!");
    	location.href = 'institutions.jsp';
        }}
    else return false;
}
</script>
 -->

<style>

	body {
		
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: -35px auto;
		padding: 10px;
background: rgba(255,255,255,1);
background: -moz-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(255,255,255,1)), color-stop(47%, rgba(246,246,246,1)), color-stop(100%, rgba(237,237,237,1)));
background: -webkit-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -o-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -ms-linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: linear-gradient(45deg, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed', GradientType=1 );	
	 box-shadow: 1px 2px 5px #C0C0C0;
	}
	
	.fc-day-number{
		color: black;
	}
	
	#bg{
	height: 640px;
	position:fixed;
	}

</style>


    </head>

    <body>
    	 
        <div class="main-wrapper">
      				
        			
      			</div>
      			
    		

  	
			
            <div class="app" id="app">
                <header class="header">
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
    			<i class="fa fa-bars"></i>
    		</button> </div>
                    
                    
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
				
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
				
         
                <article class="content dashboard-page">
				
				 <div class="title-block">
                        <h3 class="title" style="float:left;">
							<a href="ViewInstitution?institutionID=${ID}"> ${name} </a> > Add New Program
						</h3>
			     </div>
				
				 <section class="section" id="section">   
				 <div class="tab-content">     
				 	<div id="menu1" class="tab-pane fade in active">          

						<div class="col-md-12">
									<div class="card card-block sameheight-item">
										<div class="title-block">
											<h3 class="title">
												Add New Program to ${name}
											</h3> </div>
																<div class="form-group">
					  						<label for="sel1">Program<b style="color:red">*</b> </label>
					  						<br>
					  						<select class="form-control underlined chosen-select" data-placeholder="Choose a Program..." id="programForm" style="background: transparent;" name="progName">
												 				
					  						</select>
					  						<input type="hidden" id="programID">
					  						<br>
					  						<br>
					  						<br>
					  						<label for="educLevel">Select Education Level of this program<b style="color:red">*</b> </label>
					  						<br>
					  						
					  						<br>
					  						<select name="dropdown" id="educLevel">
					  						    <option value="1">Elementary Education</option>
			                                    <option value="2">Secondary Education</option>
			                                    <option value="3">Integrated Basic Education</option>
			                                    <option value="4">Tertiary Education</option>
			                                    <option value="5">Graduate Education</option>
			                                    <option value="6">Medical Education</option>
			                                    <option value="7">CECSTE</option>
			                                    
			                                </select>
					  						
					  					</div>
										
										<br><br>
										
										<div class="form-group" style="width:48%; padding-right"> <label class="control-label">Degree Name<b style="color:red">*</b></label> <input type="text" class="form-control underlined" style="width:90%;"  placeholder="e.g. BS-Computer Science" name="degreeName" id="degName"> </div>

									</div>
								</div>

							
						<div class="col-md-12">
						        
								<div class="form-group">
									<hr>
<!-- 									<button type="submit" class="btn btn-success" onclick="location.href = 'institutionProfile_sample.html'; alert('Successfully added Institutions! \nYou may now add programs in this School System.')" data-toggle="tab" style="float:right; padding-right:15px;"> -->
<!-- 									Submit then add Programs  						 -->
<!-- 									</button> -->
									
									<button type="submit" onclick="validateForm()" class="btn btn-info" style="float:right; padding-right:15px;">
									Save
									</button>
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
       </div></div>
        <script src="js/app.js"></script>
		
			
		
		
		</body>

</html>