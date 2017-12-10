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
        	$( ".loader" ).remove();
        	var div = document.createElement("div");
        	div.setAttribute("class", "loader");
        	document.getElementById("load").appendChild(div);
        	
        	var honorifics = $('#honorifics').val();
        	var firstName = $('#firstName').val();
        	var lastName = $('#lastName').val();
        	var middleName = $('#middleName').val();
        	var position = $('#position').val();
        	var year = $('#year').val();
        	var city = $('#city').val();
        	var institution = $('#institution').val();
        	
        	var boardPositionID = $('#boardPositionID').find(":selected").val();	

        	var errorDiv = document.getElementById('error');
        	
        	if(honorifics == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

       		   $( ".loader" ).remove();
                   
        	}else if(firstName == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                   
        	}else if(middleName == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                   
        	}else if(lastName == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

          		$( ".loader" ).remove();
                      
        	}else if(boardPositionID == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                   
        	}else if(year == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                   
        	}else if(position == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                
        	}else if(institution == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                   
        	}else if(city == ""){
        		errorDiv.setAttribute("style", "display: inline");
        		errorDiv.innerHTML = 'One or more required fields has not been filled';

        		   $( ".loader" ).remove();
                   
        		
        	}else
        	{
        		var year = $("#year").val();
        		var positionID = $('#boardPositions').find(":selected").val();
        		var positionName = $('#boardPositions').find(":selected").text();
        		
        		if(positionID < 3)
        		{
        			$.getJSON("BoardMemberYearLoader?year="+year+"&positionID="+positionID, function(data) {
						
	            		if(data.length > 0)
						{
							$.each(data, function(key, value) {
	                            
								errorDiv.setAttribute("style", "display: inline");
				        		errorDiv.innerHTML ="Error! You have already assigned " + value.name + " as a " + $('#boardPositions').find(":selected").text() + " for the year " + $("#year").val();
			                    $( ".loader" ).remove();
	                         });
						}
						else
						{
							$.ajax({
				                url: 'AddBoardMember?' + $('#bmForm').serialize(),
				                type: 'POST',
				                async: false,
				                dataType: 'json',
				                success: function(result) {
				                	console.log($('#bmForm').serialize());
				
				                }
				            });
							errorDiv.setAttribute("style", "display: inline");
							errorDiv.className = "alert alert-success";
			        		errorDiv.innerHTML = 'Board Member successfully added! Redirecting you to the Board Members page...';
				          	document.location.href = "BoardMembers";
						}
	   		    	});
        		}
        		else
				{
					$.ajax({
		                url: 'AddBoardMember?' + $('#bmForm').serialize(),
		                type: 'POST',
		                async: false,
		                dataType: 'json',
		                success: function(result) {
		                	console.log($('#bmForm').serialize());
		
		                }
		            });
					errorDiv.setAttribute("style", "display: inline");
					errorDiv.className = "alert alert-success";
	        		errorDiv.innerHTML = 'Board Member successfully added! Redirecting you to the Board Members page...';
		          	document.location.href = "BoardMembers";
				}
            	
        	}
/*             alert('Error! You have already assigned Tabora as a president for the year 2017.');
 */   	     	
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
        
          
        #error{
        display: none;
        }
        
		.loader 
		{
				    border: 10px solid #e7e7e7; /* Light grey */
				    border-top: 10px solid #9acd32; /* Blue */
				    border-radius: 50%;
				    width: 50px;
				    height: 50px;
				    margin: auto;
				    animation: spin 1s linear infinite;
		}
			
		@keyframes spin {
		    0% { transform: rotate(0deg); }
		    100% { transform: rotate(360deg); }
		}
           
       
    </style>
</head>

<body>
    <div class="main-wrapper">
    </div>
    <div class="app" id="app">
        
       	
       	<jsp:include page="sidebar.jsp" />
       	
        <div class="sidebar-overlay" id="sidebar-overlay"></div>
        <form id="bmForm">
            <article class="content dashboard-page">
                <div class="title-block">
                    <h3 class="title" style="float:left;">
      					<a href="BoardMembers"> List of Board Members </a> > Add New Board Member
     				</h3>
                </div>
                
                
                	<div class="alert alert-danger" role="alert" id="error">
					
					</div>
                
                <div id="load"></div>
                <br>
                <div class="row sameheight-container" id="formID">
                     <div class="col-md-12">
                         <div class="card sameheight-item">
                             <div class="card-block">
								<section class="section">
									<div class="form-group row">
	                                     <div class="col-xs-2">
	                                         <label><span style="color:red">*</span>Honorifics:</label>
	                                          <input type="text" class="form-control underlined" id="honorifics" name="honorifics" list="honorificsSuggestions">
	                                         <datalist id="honorificsSuggestions">
	                                         </datalist>
	                                     </div>
	                                     <div class="col-xs-4">
	                                         <label><span style="color:red">*</span>First Name:</label>
	                                         <input type="text" class="form-control underlined" id="firstName" name="firstName">
	                                     </div>
	                                     <div class="col-xs-2">
	                                         <label><span style="color:red">*</span>Middle Initial:</label>
	                                         <input type="text" class="form-control underlined" id="middleName" name="middleName">
	                                     </div>
	                                     <div class="col-xs-4">
	                                         <label><span style="color:red">*</span>Last Name:</label>
	                                         <input type="text" class="form-control underlined" id="lastName" name="lastName">
	                                     </div>
                               		</div>
                                 	<div class="form-group row">
                                     	<div class="col-xs-4">
	                                     	<label><span style="color:red">*</span>Board Position:</label>
	                                     	<br>
											<select id="boardPositions" name="boardPositionID">
                                     			<option value="1">President</option>
                                     			<option value="2">Vice President</option>
                                     			<option value="3">Corporate Secretary / Treasurer</option>
                                     			
                                     		</select>
                                     	</div>
	                                    <div class="col-xs-4">
	                                     	<label><span style="color:red">*</span>Year:</label>
											<input type="text" pattern="\d*" maxlength="4" class="form-control underlined" onkeypress="return isNumberKey(event)" id="year" name="year">
	                                     </div>
                                	 </div>
								</section>
                              </div>
		                 </div>
                     </div>
							
                   </div>
                 <h6>&nbsp;WORK</h6>
                         <div class="row sameheight-container">
                            <div class="col-md-12">
                                <div class="card sameheight-item">
                                    <div class="card-block">
										<section class="section"> 
											<div class="form-group row">
	                                       		<div class="col-xs-4">
	                                            	<label><span style="color:red">*</span>Position:</label>
							 						<input type="text" class="form-control underlined" id="position" name="position" list="positionSuggestions">
							                        <datalist id="positionSuggestions">
								                    </datalist>
												</div>
												<div class="col-xs-4">
	                                            	<label><span style="color:red">*</span>Institution:</label>
							 						<input type="text" class="form-control underlined" id="institution" name="institution" list="instSuggestions">
							                        <datalist id="instSuggestions">
								                    </datalist>
												</div>
	                                            <div class="col-xs-4">
													<label><span style="color:red">*</span>City:</label>
							 						<input type="text" class="form-control underlined" id="city" name="city" list="citySuggestions">
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