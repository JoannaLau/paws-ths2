<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en">

    
    <head>
<!-- IMPORTS -->

	<link rel="stylesheet" href="css/main.css"/>
    
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
 	<script id="google_map_api_script" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVizdQeh3udy11xDc5Ao2YStR2gLc-rfc&v=3.exp&libraries=places"></script>
    <script type="text/javascript" src="js/map.js"></script>
    
    
    
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

		<script>
        function autocomplete(){
        var input = document.getElementById('street_address');

        var autocomplete = new google.maps.places.Autocomplete(input);
        }
        google.maps.event.addDomListener(window, 'load', autocomplete);
    </script>
    
<script >	

$(document).ready(function() {
	getSystems();

	var systemForm = document.getElementById('systemForm');
	/* initialize the external events
	-----------------------------------------------------------------*/
	$('#street_address').bind('input', function() { 
		  $('.pac-container').css("top", "200px"); 
		//$('.pac-container').remove();
	    
	    // get the current value of the input field.
	});
	

	$('#systemForm').chosen().change(function(){
		document.getElementById('ssID').value= $('#systemForm').find(":selected").val();
	
	});
	$('#datepicker').datepicker({
 		format: "MM dd, yyyy",
 		autoclose:true,
 	});
	$('#external-events .fc-event').each(function() {

		// store data so the calendar knows to render an event upon drop
		$(this).data('event', {
			title: $.trim($(this).text()), // use the element's text as the event title
			stick: true // maintain when user navigates (see docs on the renderEvent method)
		});

		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,
			revert: true,      // will cause the event to go back to its
			revertDuration: 0  //  original position after the drag
		});

	});

	
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,basicWeek,basicDay'
		},
		defaultDate: '2016-09-12',
		navLinks: true, // can click day/week names to navigate views
		editable: true,
		droppable: true, // this allows things to be dropped onto the calendar
		drop: function() {
				$(this).remove();
			}
		,
		eventDrop: function(event, delta, revertFunc) {
	        alert(event.title + " was dropped on " + event.start.format());
	    },
	    eventReceive: function(event) {
	        alert(event.title + " was dropped on " + event.start.format());
	    },
	    eventRender: function(event, element) {
            element.append( "<a class='closeon'> Delete</a>" );
            element.find(".closeon").click(function() {
            	alert(event.title + " was removed.");
               $('#calendar').fullCalendar('removeEvents',event._id);
            });
        },

		eventLimit: true, // allow "more" link when too many events
		events: [
			{
				title: 'All Day Event',
				start: '2016-09-01'
			},
			{
				title: 'Conference',
				start: '2016-09-11'
			},
			{
				title: 'Meeting',
				start: '2016-09-12T10:30:00',
				end: '2016-09-12T12:30:00'
			},
			{
				title: 'Lunch',
				start: '2016-09-12T12:00:00'
			},
			{
				title: 'Meeting',
				start: '2016-09-12T14:30:00'
			},
			{
				title: 'Happy Hour',
				start: '2016-09-12T17:30:00'
			},
			{
				title: 'Dinner',
				start: '2016-09-12T20:00:00'
			},
			{
				title: 'Birthday Party',
				start: '2016-09-13T07:00:00'
			}
		]
	});
	
});

function getSystems(){
	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
	var obj = document.getElementById('systemForm');
  		
	$.getJSON("SystemsLoader", function(data){
		var option = document.createElement("option");
		option.text = "";
		option.value = 0;
		obj.add(option);
		$.each(data, function (key, value){
		<c:set var="inst" value="${institution}"/>
			var systemID = "<c:out value="${inst.getSchoolSystemID()}"/>";
			var option = document.createElement("option");
			option.text = value.systemName;
			option.value = value.systemID;
			if(systemID == value.systemID)
	            option.setAttribute("selected", true);
			obj.add(option);
			
		});	
		$('#systemForm').trigger("chosen:updated");
	});
	
}

function saveInstitution() {

	var id = "<c:out value='${institution.getInstitutionID()}'/>";

	  $.ajax({
        url: 'UpdateInstitution?institutionID=' + id + '&' + $('#instForm').serialize(),
        type: 'POST',
        async: false,  
        success: function(result) {

        	window.location.href = "Institutions";
        }
    });
    alert('Institution successfully edited! Redirecting you to the institutions page...');

} 








function validateForm() {
	
	
	var ssName = document.forms["addInstForm"]["ssName"].value;
	var institutionName = document.forms["addInstForm"]["institutionName"].value;
    var institutionName = document.forms["addInstForm"]["institutionName"].value;
    var institutionAcronym = document.forms["addInstForm"]["institutionAcronym"].value;
    var membershipDate = document.forms["addInstForm"]["membershipDate"].value;
    var city =  document.forms["addInstForm"]["city"].value;
    
    var entry = ssName +"|"+institutionName+"|"+city
    
	var errorDiv = document.getElementById('error');
	
   
    if(duplicateCheck(entry)){
    if(ssName=="0"){
    	document.location.href = "#top";
    	errorDiv.setAttribute("style", "display: inline");
		errorDiv.innerHTML = 'One or more required fields has not been filled';
        return false;	
    }    
    else if (institutionName == "") {
    	alert("asd")
    	document.location.href = "#top";
    	errorDiv.setAttribute("style", "display: inline");
		errorDiv.innerHTML = 'One or more required fields has not been filled';
        return false;
    }
    else if (institutionAcronym == "") {
    	document.location.href = "#top";
    	errorDiv.setAttribute("style", "display: inline");
		errorDiv.innerHTML = 'One or more required fields has not been filled';
        return false;
    }
    else if (membershipDate == "") {
    	document.location.href = "#top";
    	errorDiv.setAttribute("style", "display: inline");
		errorDiv.innerHTML = 'One or more required fields has not been filled';
        return false;
    }
    else if (city == "") {
    	document.location.href = "#top";
    	errorDiv.setAttribute("style", "display: inline");
		errorDiv.innerHTML = 'One or more required fields has not been filled';
        return false;
    }
    else{
    	document.location.href = "#top";
    	errorDiv.setAttribute("style", "display: inline");
		errorDiv.className = "alert alert-success";
		errorDiv.innerHTML ='Institution successfully added!';
      	
    	location.href = 'institutions.jsp';
        }}
    else return false;
}






</script>

<script>


	





function addProp(){
	$("#progBar").html("<div class='progress-bar progress-bar-success' role='progressbar' style='width:33%' id='progDetails'>1. Details</div><div class='progress-bar progress-bar-success progress-bar-striped' role='progressbar' style='width:33%' id='progProponents'>2. Proponents </div>");

}

function addDet(){
	$("#progBar").html("<div class='progress-bar progress-bar-success progress-bar-striped' role='progressbar' style='width:33%' id='progDetails'>1. Details</div>");

}

function addSure(){
	$("#progBar").html("<div class='progress-bar progress-bar-success' role='progressbar' style='width:33%' id='progDetails'>1. Details</div><div class='progress-bar progress-bar-success' role='progressbar' style='width:33%' id='progProponents'>2. Proponents </div><div class='progress-bar progress-bar-success progress-bar-striped' role='progressbar' style='width:33%' id='progProponents'>3. Final </div>");

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
    #error{
        display: none;
        }
</style>


    </head>

    <body onLoad="initialize(${inst.getLatitude()}, ${inst.getLongitude()});" class="frontend">
    	 
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
				<form method="post" onsubmit="return validateForm()" action="UpdateInstitution" class="form">
				
				 <div class="title-block">
                        <h3 class="title" style="float:left;">
							<a href="Institutions"> List of Institutions </a> > Edit Institution
						</h3>
			     </div>
			     
			       <div class="alert alert-danger" role="alert" id="error">
					
					</div>
                
				
				 <section class="section" id="section">   
				 <div class="tab-content">     
				 	<div id="menu1" class="tab-pane fade in active">          
					
					<c:set var="inst" scope="session" value="${institution}"/>
      			
						<div class="col-md-12">
									<div class="card card-block sameheight-item">
										<div class="title-block">
											<h3 class="title">
							Edit Institution Form
						</h3> </div>
					<div class="form-group">
  						<label for="sel1">School System:</label><br>
  						<select class="form-control underlined chosen-select" data-placeholder="Choose a System..." id="systemForm" style="background: transparent;" name="ssName">
							 				
  						</select>
  						<input type="hidden" value="${inst.getInstitutionID()}" name="institutionID">
  					</div>
					
					
							<div class="form-group" style="width:48%; padding-right"> 
								<label class="control-label">Institution Name</label> 
								<input type="text" class="form-control underlined" style="width:90%;"  placeholder="e.g. De La Salle University" name="institutionName" value="${inst.getName()}"> 
							</div>
							<div class="form-group" style="width:48%; padding-right"> <label class="control-label">Institution Acronym</label> <input type="text" class="form-control underlined" style="width:90%;"  placeholder="e.g. DLSU-M" name="institutionAcronym" value="${inst.getInstitutionAcronym()}"> </div>
							<br><br><br>	
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Institution Address</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. 2401 Taft Avenue, 1004 Manila, Philippines" name="address" value="${inst.getAddress()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">City of Institution </label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. Manila" name="city" value="${inst.getCity()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Date of Membership</label> <input id="datepicker" type="text" class="form-control underlined" style="width:90%;" placeholder="" name="membershipDate" value="${inst.getDateAddedWord()}"> </div>
											
							<br><br><br>	
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Country of Institution </label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. Philippines" name="country" value="${inst.getCountry()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Institution Website</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. http://www.dlsu.edu.ph/" name="website" value="${inst.getWebsite()}"> </div>
							<br><br><br>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Institution Contact No. <i>(separate using semi-colon)</i></label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. (632) 523-4152 ; 247-6921" name="contactNumber" value="${inst.getContactNumber()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Institution Fax No.</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. 432-8586 " name="fax" value="${inst.getFax()}"> </div>
							<br><br><br>			
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Institution Head</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. Mr. Jose T. Pardo" name="institutionHead" value="${inst.getHead()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Position of the Head</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. Chairman" name="position"value="${inst.getContactPosition()}"> </div>
							<br><br><br>	
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Email of the Head</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. chairperson@email.com" name="headEmail" value="${inst.getContactEmail()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Institution Contact Person</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. Firstname Lastname" name="contactPerson" value="${inst.getContactPerson()}"> </div>
							<br><br><br>			
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Position of the Contact Person</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. Chairman" name="contactPosition" value="${inst.getContactPosition()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Email of Contact Person</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="e.g. person@email.com" name="contactEmail" value="${inst.getContactEmail()}"> </div>
							<br><br>
							<label>Coordinates: Search for the coordinates (longitude and latitude) in the map below.</label>		
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Latitude</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="Search for the latitude" name="latitude" value="${inst.getLatitude()}"> </div>
							<div class="form-group"  style="width:48%; padding-right"> <label class="control-label">Longitude</label> <input type="text" class="form-control underlined" style="width:90%;" placeholder="Search for the longitude" name="longitude" value="${inst.getLongitude()}"> </div>
			
					</div>
				</div>

							
						<div class="col-md-12">
								<div class="form-group">
									<hr>
<!-- 									<button type="submit" class="btn btn-success" onclick="location.href = 'institutionProfile_sample.html'; alert('Successfully added Institutions! \nYou may now add programs in this School System.')" data-toggle="tab" style="float:right; padding-right:15px;"> -->
<!-- 									Submit then add Programs  						 -->
<!-- 									</button> -->
									
									<button type="submit" class="btn btn-info"  style="float:right; padding-right:15px;">
									Submit
									</button>
								</div>
						</div>
        			</div>
				   </section>
				   
				   </form>
					<section class="container clearfix" style="max-width: 800px;">
			            <div id="map_container" class="clearfix">
			                <div id="search_street_container" class="col-md-12">
			                    <form id="frm_show_address" name="frm_show_address" action="#"
			                          class="fromAddress printHidden row">
			                        <div class="col-md-9 col-sm-8 col-xs-8">
			                            <input id="street_address" name="street_address" type="text" class="textBefore vpsClearOnFocus" placeholder="House number, Street, City etc..." />
			                        </div>
			                        
			                        <div class="col-md-2 col-sm-4 col-xs-10">
			                            <input type="submit" value="Show Location" class="submitOn"/>
			                            <div class="clear"></div>
			                        </div>
			                    </form>
			                </div>
			                <div id="map_canvas_container" class="container maps_divs col-md-12">
			                    <div id="map_canvas"></div>
			                </div>
			                <div class="mapDir"></div>
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
		
		<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-2613916-1', 'auto');
	  ga('send', 'pageview');

		</script>
		
		</body>

</html>