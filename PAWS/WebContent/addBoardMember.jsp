<!doctype html>
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
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> PAASCU - Accreditation Schedule Manager </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <!-- Place favicon.ico in the root directory -->
    <!-- Theme initialization -->
    <script>
        var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) : {};
        var themeName = themeSettings.themeName || '';
        if (themeName) {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
        } else {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
        }
    </script>
    <!--         <link href='fullcalendar.css' rel='stylesheet' /> -->
    <!-- <link href='calendar/fullcalendar.print.css' rel='stylesheet' media='print' /> -->
    <!-- <script src='calendar/lib/moment.min.js'></script> -->
    <!-- <script src='calendar/fullcalendar.min.js'></script> -->
    <script>
        $(document).ready(function() {
        	getHonorifics();
        	getCities();
        	getInstitutions();
        	getPositions();
        	
        	
			var format = "MM dd, yyyy";
			
		     $('#datepicker2').datepicker({
		    	 format: "MM dd, yyyy",
			 	 autoclose:true,
		     });
		     $('#datepicker3').datepicker({
		    	 format: "MM dd, yyyy",
			 	 autoclose:true,
		     });
		     $('#datepicker1').datepicker({
		    	 format: "MM dd, yyyy",
			 	 autoclose:true,
		     });
		    
        });
        
        function isNumberKey(evt){
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }
        
        function getHonorifics() {
            //GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
 			var honorifics = document.getElementById("honorificsSuggestions");
          
            $.getJSON("HonorificsLoader", function(data) {
               
                $.each(data, function(key, value) {
                    var option1 = document.createElement("option");
                    option1.text = value.honorifics;
                   	 
                    honorifics.appendChild(option1);

                });

            });
        }

        function getCities() {
            //GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
        		var city = document.getElementById("citySuggestions");
          
            $.getJSON("CitiesLoader", function(data) {
               
                $.each(data, function(key, value) {
                    var option1 = document.createElement("option");
                    option1.text = value.city;
                   	 
                    city.appendChild(option1);

                });

            });
        }
        
        function getPositions() {
            //GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
        		var p = document.getElementById("positionSuggestions");
          
            $.getJSON("PositionsLoader", function(data) {
               
                $.each(data, function(key, value) {
                    var option1 = document.createElement("option");
                    option1.text = value.position;
                   	 
                    p.appendChild(option1);

                });

            });
            
           
        }
        

        function getInstitutions() {
            //GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
        		
            $.getJSON("AllInstitutionsLoader", function(data) {
               
                $.each(data, function(key, value) {
                	var inst = document.getElementById("instSuggestions");
                    
                	var option1 = document.createElement("option");
                    option1.text = value.institutionName;
                   	 
                    inst.appendChild(option1);

                });

            });
        }
      

        function saveBoardMember() {
        	console.log( $('#bmForm').serializeArray() );
        	  $.ajax({
                url: 'AddBoardMember?' + $('#bmForm').serialize(),
                type: 'POST',
                async: false,
                dataType: 'json',
                success: function(result) {
                	console.log($('#bmForm').serialize());

                }
            });
            alert('Accreditor successfully added! Redirecting you to the accreditors page...');
          	document.location.href = "BoardMembers";
        }

        function togglePresent() {
            $('#datepicker3').prop('disabled', function(i, v) {
                return !v;
            });
        }
    </script>
    <style>
        body {
            font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
            font-size: 14px;
        }
        #calendar {
            max-width: 900px;
            margin: -35px auto;
            padding: 10px;
            background: rgba(255, 255, 255, 1);
            background: -moz-linear-gradient(45deg, rgba(255, 255, 255, 1) 0%, rgba(246, 246, 246, 1) 47%, rgba(237, 237, 237, 1) 100%);
            background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(255, 255, 255, 1)), color-stop(47%, rgba(246, 246, 246, 1)), color-stop(100%, rgba(237, 237, 237, 1)));
            background: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 1) 0%, rgba(246, 246, 246, 1) 47%, rgba(237, 237, 237, 1) 100%);
            background: -o-linear-gradient(45deg, rgba(255, 255, 255, 1) 0%, rgba(246, 246, 246, 1) 47%, rgba(237, 237, 237, 1) 100%);
            background: -ms-linear-gradient(45deg, rgba(255, 255, 255, 1) 0%, rgba(246, 246, 246, 1) 47%, rgba(237, 237, 237, 1) 100%);
            background: linear-gradient(45deg, rgba(255, 255, 255, 1) 0%, rgba(246, 246, 246, 1) 47%, rgba(237, 237, 237, 1) 100%);
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed', GradientType=1);
            box-shadow: 1px 2px 5px #C0C0C0;
        }
        .fc-day-number {
            color: black;
        }
        #bg {
            height: 640px;
            position: fixed;
        }
        #maincard {
            height: 750px;
        }
       
    </style>
</head>

<body>
    <div class="main-wrapper">
    </div>
    <div class="app" id="app">
        <header class="header">
            <div class="header-block header-block-collapse hidden-lg-up">
                <button class="collapse-btn" id="sidebar-collapse-btn">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="header-block header-block-search hidden-sm-down">
                <form role="search">
                    <div class="input-container">
                        <i class="fa fa-search"></i>
                        <input type="search" placeholder="Search">
                        <div class="underline"></div>
                    </div>
                </form>
            </div>
            <div style="margin-left:-150px;">
                <div class="progress" style="width:500px; height:20px;" id="progBar">
                    <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" style="width:50%" id="progDetails">
                        1. Details
                    </div>
                </div>
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
                              </a>
                                    </li>
                                </ul>
                            </footer>
                        </div>
                    </li>
                </ul>
            </div>
        </header>
       	
       	<jsp:include page="sidebar.jsp" />
       	
        <div class="sidebar-overlay" id="sidebar-overlay"></div>
        <form id="bmForm">
            <article class="content dashboard-page">
                <div class="title-block">
                    <h3 class="title" style="float:left;">
      					<a href="BoardMembers"> List of Board Members </a> > Add New Board Member
     				</h3>
                </div>
                
                <div class="row sameheight-container" id="formID">
                     <div class="col-md-12">
                         <div class="card sameheight-item">
                             <div class="card-block">
								<section class="section">
									<div class="form-group row">
	                                     <div class="col-xs-2">
	                                         <label>Honorifics:</label>
	                                          <input type="text" class="form-control underlined" id="surveyName" name="honorifics" list="honorificsSuggestions">
	                                         <datalist id="honorificsSuggestions">
	                                         </datalist>
	                                     </div>
	                                     <div class="col-xs-4">
	                                         <label>First Name:</label>
	                                         <input type="text" class="form-control underlined" id="surveyName" name="firstName">
	                                     </div>
	                                     <div class="col-xs-2">
	                                         <label>Middle Initial:</label>
	                                         <input type="text" class="form-control underlined" id="surveyName" name="middleName">
	                                     </div>
	                                     <div class="col-xs-4">
	                                         <label>Last Name:</label>
	                                         <input type="text" class="form-control underlined" id="surveyName" name="lastName">
	                                     </div>
                               		</div>
                                 	<div class="form-group row">
                                     	<div class="col-xs-4">
	                                     	<label>Board Position:</label>
	                                     	<br>
											<select id="boardPositions" name="boardPositionID">
                                     			<option value="1">President</option>
                                     			<option value="2">Vice President</option>
                                     			<option value="3">Corporate Secretary / Treasurer</option>
                                     			
                                     		</select>
                                     	</div>
	                                    <div class="col-xs-4">
	                                     	<label>Year:</label>
											<input type="text" pattern="\d*" maxlength="4" class="form-control underlined" onkeypress="return isNumberKey(event)" id="surveyName" name="year">
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
											<div class="form-group row">
	                                       		<div class="col-xs-4">
	                                            	<label>Position:</label>
							 						<input type="text" class="form-control underlined" id="surveyName" name="position" list="positionSuggestions">
							                        <datalist id="positionSuggestions">
								                    </datalist>
												</div>
												<div class="col-xs-4">
	                                            	<label>Institution:</label>
							 						<input type="text" class="form-control underlined" id="surveyName" name="institution" list="instSuggestions">
							                        <datalist id="instSuggestions">
								                    </datalist>
												</div>
	                                            <div class="col-xs-4">
													<label>City:</label>
							 						<input type="text" class="form-control underlined" id="surveyName" name="city" list="citySuggestions">
							                        <datalist id="citySuggestions">
								                    </datalist>
							                    </div>
						  					</div>
											
										</section>
                                       
                                      
                                    </div>
									
                                </div>
                            </div>
							
                        </div>
                              
                

                        <div class="form-group" style="float:right;top:25px;">
                            <button type="button" class="btn btn-success" onclick="saveBoardMember();" style="position:relative;top:35px; right:0px;" data-toggle="tab" href="#menu2">
                                Submit
                            </button>
                        </div>
                      
            </article>
        </form>
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
        </div>
        <script src="js/app.js"></script>
</body>

</html>