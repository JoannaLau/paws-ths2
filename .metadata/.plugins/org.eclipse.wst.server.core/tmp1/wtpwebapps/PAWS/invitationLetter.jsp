<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    	<script src='js/jquery.min.js'></script>
		<script src='js/jquery-ui.min.js'></script>
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="chosen/chosen.css">
		<script src="chosen/chosen.jquery.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js"></script>
		<meta charset="utf-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<title> PAASCU - Accreditation Schedule Manager </title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="apple-touch-icon" href="apple-touch-icon.png">
		<!-- Place favicon.ico in the root directory -->
		<link rel="stylesheet" href="css/vendor.css">
		
      <script type="text/javascript" src="js/jspdf.min.js"></script>
      <script type="text/javascript" src="js/html2canvas.min.js"></script>
   	  <link type="text/css" rel="stylesheet" href="css/stylestest.css"/>
   	  <script type="text/javascript" src="js/headerfooter.js"></script>
      
		
		
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
	    	$('#institutionForm').chosen().change(function(){
				
				$('#divProgramForm').empty();

				var institutionID = $('#institutionForm').find(":selected").val();
				
				$.getJSON("ProgramLoader?institutionID=" + institutionID, function(data){
				    if ( data.length == 0 ) {
				    	$('#divProgramForm').empty();
				    }
				    else 
			    	{
				    	var divProgramForm = document.getElementById("divProgramForm");
	
						var label1 = document.createElement("label");
						label1.setAttribute("for", "programForm");
						label1.innerText = "Program: ";
						
						var selectProgramForm = document.createElement("select");
						selectProgramForm.setAttribute("id", "programForm");
						selectProgramForm.setAttribute("class", "form-control underlined chosen-select");
						selectProgramForm.setAttribute("data-placeholder", "Choose a Program...");
						
						divProgramForm.appendChild(label1);
						divProgramForm.appendChild(selectProgramForm);
						
						var programForm = document.getElementById("programForm");
											
						
						$.each(data, function (key, value){
						    var option = document.createElement("option");
							option.text = value.degreeName;
							option.value = value.SPID;
							programForm.add(option);
							$('#programForm').trigger("chosen:updated");
				    	});
			    	}
			});
			
				$.getJSON("InstitutionForInvitationLoader?institutionID=" + institutionID, function(data){
				   
						$.each(data, function (key, value) {
						    var schoolFromLoader = value.name;
							var cityFromLoader = value.city;
							
							
							var instFields = document.getElementById('surveyschool1');
							
							
							if(instFields)
							{
								var newSurveySchool = document.getElementById("surveyschool1");
								newSurveySchool.setAttribute("value", schoolFromLoader);
								
								var newSchoolCity = document.getElementById("schoolcity1");
								newSchoolCity.setAttribute("value", cityFromLoader);
							}
							else
							{
								var textFields = document.getElementById("textFields");
								
								
								var labelSurveySchool = document.createElement('label');
								labelSurveySchool.setAttribute("for", "surveyschool1")
								labelSurveySchool.innerHTML = "Survey School ";
								var newSurveySchool = document.createElement("input");
								newSurveySchool.setAttribute("id", "surveyschool1");
								newSurveySchool.setAttribute("value", schoolFromLoader);
								newSurveySchool.setAttribute("placeholder", "SurveySchool");
								newSurveySchool.setAttribute("style", "width: 100%;");
											
								var labelSchoolCity = document.createElement('label');
								labelSchoolCity.setAttribute("for", "schoolcity1")
								labelSchoolCity.innerHTML = "School City ";
								var newSchoolCity = document.createElement("input");
								newSchoolCity.setAttribute("id", "schoolcity1");
								newSchoolCity.setAttribute("value", cityFromLoader);
								newSchoolCity.setAttribute("placeholder", "School City");
								newSchoolCity.setAttribute("style", "width: 100%;");
								
				
								textFields.appendChild(labelSurveySchool);
								textFields.appendChild(newSurveySchool);
								textFields.appendChild(labelSchoolCity);
								textFields.appendChild(newSchoolCity);
								
								
								
								
							} 
				    	});
						
						
						
			    	
			});
				
				
			
			});
	    	
			$('#accreditorForm').chosen().change(function(){
				
				var accreditorID = $('#accreditorForm').find(":selected").val();

				$.getJSON("AccreditorForInvitationLoader?accreditorID=" + accreditorID, function(data){
					$.each(data, function (key, value) {
					
						var accTextFields = document.getElementById('invited1');
						var recepientFromJSON = value.head;
						var recepientPosiFromJSON = value.hPosition;
						var instNameFromJSON = value.institutionName;
						var cityFromJSON = value.city;
						
						
						if(accTextFields)
						{
							accTextFields.setAttribute("value", $("#accreditorForm option:selected").text());
							document.getElementById("recepient1").setAttribute("value", recepientFromJSON);
							document.getElementById("recepientpos1").setAttribute("value", recepientPosiFromJSON);
							document.getElementById("school1").setAttribute("value", instNameFromJSON);
							document.getElementById("city1").setAttibute("value", cityFromJSON);
							
						}
					
						else
						{

							var textFields = document.getElementById('textFields');
							
							
							var labelFaculty = document.createElement('label');
							labelFaculty.setAttribute("for", "invited1")
							labelFaculty.innerHTML = "Invited Faculty (Accreditor)";
							var newFaculty = document.createElement("input");
							newFaculty.setAttribute("id", "invited1");
							newFaculty.setAttribute("placeholder", "Invited Faculty");
							newFaculty.setAttribute("style", "width: 100%;");
							newFaculty.setAttribute("value", $("#accreditorForm option:selected").text());

							var labelRecepient = document.createElement('label');
							labelRecepient.setAttribute("for", "recepient1")
							labelRecepient.innerHTML = "Recepient";
							var newRecepient = document.createElement("input");
							newRecepient.setAttribute("id", "recepient1");
							newRecepient.setAttribute("placeholder", "Recepient");
							newRecepient.setAttribute("style", "width: 100%;");
							newRecepient.setAttribute("value", recepientFromJSON);
							
							var labelRecepientPosition = document.createElement('label');
							labelRecepientPosition.setAttribute("for", "recepientpos1");
							labelRecepientPosition.innerHTML = "Recepient Position";
							var newRecepientPos = document.createElement("input");
							newRecepientPos.setAttribute("id", "recepientpos1");
							newRecepientPos.setAttribute("placeholder", "Recepient Position");
							newRecepientPos.setAttribute("style", "width: 100%;");
							newRecepientPos.setAttribute("value", recepientPosiFromJSON);
							
							var labelSchool = document.createElement('label');
							labelSchool.setAttribute("for", "school1");
							labelSchool.innerHTML = "School";
							var newSchool = document.createElement("input");
							newSchool.setAttribute("id", "school1");
							newSchool.setAttribute("placeholder", "School");
							newSchool.setAttribute("style", "width: 100%;");
							newSchool.setAttribute("value", instNameFromJSON);
							
							var labelCity = document.createElement('label');
							labelCity.setAttribute("for", "city1");
							labelCity.innerHTML = "City";
							var newCity = document.createElement("input");
							newCity.setAttribute("id", "city1");
							newCity.setAttribute("placeholder", "City");
							newCity.setAttribute("style", "width: 100%;");
							newCity.setAttribute("value", cityFromJSON);
							
							
							
							textFields.appendChild(labelFaculty);
							textFields.appendChild(newFaculty);
							textFields.appendChild(labelRecepient);
							textFields.appendChild(newRecepient);
							textFields.appendChild(labelRecepientPosition);
							textFields.appendChild(newRecepientPos);
							textFields.appendChild(labelSchool);
							textFields.appendChild(newSchool);
							textFields.appendChild(labelCity);
							textFields.appendChild(newCity);
							
							
							
						}
					
					});
					
				});
				
				
				
			});
		    
		    getInstitutions();
		    getAccreditors();
		    
		});
	    
	    
	    function getInstitutions(){
	    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
			var obj = document.getElementById('institutionForm');
			
			$.getJSON("InvitationInstitutionsLoader", function(data){
				
				var option = document.createElement("option");
				option.text = "";
				option.value = 0;
				obj.add(option);
				$.each(data, function (key, value){
					
					var option = document.createElement("option");
					option.text = value.institutionName + " - " + value.city + " - " + value.educLevel;
					option.value = value.institutionID;
					obj.add(option);
					
				});	
				$('#institutionForm').trigger("chosen:updated");
			});
			
		}
	    

	    function getAccreditors(){
	    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
			var obj = document.getElementById('accreditorForm');
			
			$.getJSON("InvitationAccreditorsLoader", function(data){
				
				var option = document.createElement("option");
				option.text = "";
				option.value = 0;
				obj.add(option);
				$.each(data, function (key, value){
					
					var option = document.createElement("option");
					option.text = value.accName;
					option.value = value.accID;
					obj.add(option);
					
				});	
				$('#accreditorForm').trigger("chosen:updated");
			});
			
		}
	    
	    Date.prototype.getFormatDate = function() {
	        var monthNames = [ "January", "February", "March", "April", "May", "June", 
	                           "July", "August", "September", "October", "November", "December" ];
	        return monthNames[this.getMonth()]+ ' ' + this.getDate() + ', '+this.getFullYear();
	        
	        
	    }
	

        function genPDF() {
			var doc = new jsPDF()
            var suff = document.getElementById("suffix");
            var strsuff = suff.options[suff.selectedIndex].value;
            var deptdrop = document.getElementById("department-dropdown");
            var dept = deptdrop.options[deptdrop.selectedIndex].value;

            doc.setFontSize(12)
            doc.text(20, 70, textDate)

            doc.setFontType("bold");
            var recipient = $('#recipient').val()
            recipient = strsuff + recipient;
            doc.text(20, 85, recipient)

            doc.setFontType("normal");
            var recipientpos = $('#recipientpos').val()
            doc.text(20, 90, recipientpos)
            var school = $('#school').val()
            doc.text(20, 95, school)
            var city = $('#city').val()
            city = city + " City"
            doc.text(20, 100, city)

            var invited = $('#invited').val()
            var surveyschool = $('#surveyschool').val()
            var schoolcity = $('#schoolcity').val()
            schoolcity = schoolcity + " City"
            
            var from = $("#fromdate").val().split("-");

            var startdate = new Date(from[0], from[1], from[2]).getFormatDate().toString();
            
            var to = $("#todate").val().split("-");

            var todate = new Date(to[0], to[1]-1, to[2]).getFormatDate().toString();
            
            var signperson = $('#signperson').val()
            var signposition = $('#signposition').val()

            doc.text(20, 110, "Dear " + recipient + " :")

            var paragraph = "We have invited " + invited + " to join the Resurvey Team that will visit the " + dept + " Department of " + surveyschool + ", " + schoolcity + " on " + startdate + " to " + todate + ".\n\nWe will appreciate your making " + invited + " available for the survey. We realize this will take them out of school for some time. However, school visitation can be a most rewarding experience. It is also an opportunity for professional and personal growth.\n\nThank you for sharing our concern for quality education in the country.\n\n\nSincerely yours,\n\n\n" + signperson + "\n" + signposition + "";

            lines = doc.splitTextToSize(paragraph, 175)

            var img = new Image();
            var dataURL;

            img.src = "bimb.jpg";

            img.onload = function() {
                var canvas = document.createElement('canvas');
                canvas.width = img.width;
                canvas.height = img.height;


                var context = canvas.getContext('2d');
                context.drawImage(img, 0, 0);

                window.alert("nakapasok");

                dataURL = canvas.toDataURL('image/jpeg');
            }

            doc.text(20, 120, lines)

            doc.addImage(imgHeader, 'JPEG', 0, 0, 210, 50)
            doc.addImage(imgFooter, 'JPEG', 0, 260, 210, 50)
                // doc.addImage(dataURL, 'JPEG', 20, 20, 75, 75)

            var filename = recipient + " Survey Invitation " + todayDateInput + ".pdf";

            doc.save(filename);
        }
        
        
        function genPDFDB() {
        
            var doc = new jsPDF()

			var invited = $("#accreditorForm option:selected").text();
			var chosenInstitution = $('#institutionForm').val();
			
			
			  

            doc.setFontSize(12)
            doc.text(20, 70, textDate)

            doc.setFontType("bold");
            var recipient = $('#recepient1').val()
            doc.text(20, 85, recipient)

            doc.setFontType("normal");
            var recipientpos = $('#recepientpos1').val()
            doc.text(20, 90, recipientpos)
            var school = $('#school1').val()
            doc.text(20, 95, school)
            var city = $('#city1').val()
            city = city + " City"
            doc.text(20, 100, city)

            var invited = $('#invited1').val()
            var surveyschool = $('#surveyschool1').val()
            var schoolcity = $('#schoolcity1').val()
            schoolcity = schoolcity + " City"
            
            var from = $("#fromdate1").val().split("-");

            var startdate = new Date(from[0], from[1]-1, from[2]).getFormatDate().toString();
            
            var to = $("#todate1").val().split("-");

            var todate = new Date(to[0], to[1]-1, to[2]).getFormatDate().toString();
            
            var signperson = $('#signperson1').val()
            var signposition = $('#signposition1').val()

            doc.text(20, 110, "Dear " + recipient + " :")

            
            var paragraph = "We have invited " + invited + " to join the Resurvey Team that will visit the Department of " + surveyschool + ", " + schoolcity + " on " + startdate + " to " + todate + ".\n\nWe will appreciate your making " + invited + " available for the survey. We realize this will take them out of school for some time. However, school visitation can be a most rewarding experience. It is also an opportunity for professional and personal growth.\n\nThank you for sharing our concern for quality education in the country.\n\n\nSincerely yours,\n\n\n" + signperson + "\n" + signposition + "";

          /*   var paragraph = "We have invited " + invited + " to join the Resurvey 
            Team that will visit the " + dept + " Department of " + surveyschool + 
            ", " + schoolcity + " on " + startdate + " to " + todate + ".\n\nWe will 
            appreciate your making " + invited + " available for the survey.
            We realize this will take them out of school for some time. However, 
            school visitation can be a most rewarding experience. It is also an 
            opportunity for professional and personal growth.\n\n Thank you for 
            sharing our concern for quality education in the country.\n\n\nSincerely 
            yours,\n\n\n" + signperson + "\n" + signposition + "" */

            lines = doc.splitTextToSize(paragraph, 175)

            var img = new Image();
            var dataURL;

            img.src = "bimb.jpg";

            img.onload = function() {
                var canvas = document.createElement('canvas');
                canvas.width = img.width;
                canvas.height = img.height;


                var context = canvas.getContext('2d');
                context.drawImage(img, 0, 0);

                window.alert("nakapasok");

                dataURL = canvas.toDataURL('image/jpeg');
            }

            doc.text(20, 120, lines)

            doc.addImage(imgHeader, 'JPEG', 0, 0, 210, 50)
            doc.addImage(imgFooter, 'JPEG', 0, 260, 210, 50)
                // doc.addImage(dataURL, 'JPEG', 20, 20, 75, 75)

            var filename = recipient + " Survey Invitation " + todayDateInput + ".pdf";

            doc.save(filename);
        }
        
    </script>




    <style>
        .container {
            width: 125%;
            overflow: hidden;
            display: block;
            height: 130px;
            z-index: -1;
            margin-left: -15px;
        }
        #bgvid {
            position: relative;
            top: -400px;
            margin-top: 0px;
            width: 115%
        }
        body {
            font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
            font-size: 14px;
        }
        #calendar {
            max-width: 900px;
            margin: 0 auto;
        }
        #bg {
            height: 640px;
            position: fixed;
        }
        #main {
            position: relative;
            top: -290px;
        }
        #pnum_danger,
        #pnum_info,
        #pnum_warning,
        #pnum_primary {
            font-size: 75px;
            text-align: center;
            margin-left: -2px;
            padding: 0;
            line-height: 85px;
        }
        #pnum_danger {
            color: #5c5c5c;
            transition: all 0.5s ease;
        }
        #pnum_danger:hover {
            color: #ff2b2b;
            font-size: 100px;
            cursor: pointer;
        }
        #pnum_warning {
            color: #5c5c5c;
            transition: all 0.5s ease;
        }
        #pnum_warning:hover {
            font-size: 100px;
            cursor: pointer;
            color: #fe8832;
        }
        #pnum_info {
            color: #5c5c5c;
            transition: all 0.5s ease;
        }
        #pnum_info:hover {
            color: #5ecdf3;
            font-size: 100px;
            cursor: pointer;
        }
        #pnum_primary {
            color: #5c5c5c;
            transition: all 0.5s ease;
        }
        #pnum_primary:hover {
            color: #85CE36;
            font-size: 100px;
            cursor: pointer;
        }
        #psub {
            font-size: 17px;
            color: #bcbcbc;
            text-align: center;
            margin-top: 6px;
            padding: 0;
            line-height: 20px;
        }
        #bc {
            color: white;
        }
        #bc:hover {
            color: #85CE36;
        }
        #welcome {
            position: relative;
            top: -110px;
            color: white;
            left: 40px;
            font-family: Existence-Light;
        }
        .h1 {
            font-size: 100%;
        }
        @font-face {
            font-family: Existence-Light;
            src: url(fonts/Roboto-Thin.ttf);
        }
        #notifcard {
            -webkit-box-shadow: 0px 1px 5px 0px rgba(50, 50, 50, 0.58);
            -moz-box-shadow: 0px 1px 5px 0px rgba(50, 50, 50, 0.58);
            box-shadow: 0px 1px 5px 0px rgba(50, 50, 50, 0.58);
            width: 87%;
            left: 15px;
        }
        #maincard {
            width: 100%;
            padding: 0px;
            background-color: #ffffff;
            top: -50px;
            margin-bottom: 10px;
            margin-top: 0px;
            height: 700px;
            border-radius: 3px;
            -webkit-box-shadow: 0px 9px 24px 0px rgba(0, 0, 0, 0.75);
            -moz-box-shadow: 0px 9px 24px 0px rgba(0, 0, 0, 0.75);
            box-shadow: 0px 9px 24px 0px rgba(0, 0, 0, 0.75);
        }
    </style>

    <body>
        <div class="main-wrapper" style="z-index:1;">
            <div class="app" id="app">

                <jsp:include page="sidebar.jsp" />

                <div class="container">
                    <video poster="assets/banner.jpg" id="bgvid" playsinline autoplay muted loop>
                        <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->

                        <source src="assets/vid.mp4" type="video/mp4">
                    </video>
                </div>
                <div id="welcome">
                    <h1>Create Invitation Letter</h1>
                </div>
                <article class="content dashboard-page">
                    <ul class="nav nav-tabs" style="margin-top:-4cm;">
                        <li class="active"><a data-toggle="tab" href="#fromDB">From Database</a>
                        </li>
                        <li><a data-toggle="tab" href="#manualInput">Manual Input</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div id="fromDB" class="tab-pane fade in active">
                        <br>
                            <h3>Import From Database</h3>
                            
                            	<%-- <div class="form-group">
									<label for="accreditorForm">Accreditor: </label>
		                            <br>
		                            <select class="form-control underlined chosen-select" data-placeholder="Choose an Accreditor..." id="accreditorForm" style="background: transparent;">
	                         		    <option ></option>
									    
		                         		<c:forEach var="acc" items="${accreditors}">
									        <option value="${acc.getAccreditorID()}">${acc.getHonorifics()}. ${acc.getFirstName()} ${acc.getLastName()} </option>
									    </c:forEach> 
									</select> 
								</div> --%>
									<%-- <label for="institutionForm">Institution: </label>
		                            <br>
		                            <select class="form-control underlined chosen-select" data-placeholder="Choose an Institution..." id="institutionForm" style="background: transparent;">
		                         	       <option ></option>
									
		                         	    <c:forEach var="inst" items="${institutions}">
									        <option value="${inst.getInstitutionID()}">${inst.getName()} - ${inst.getCity()} - ${inst.getEducLevel()} </option>
									    </c:forEach>
									</select> --%>
								<div class="form-group" id = "divAccreditorForm">
									<label for="accreditorForm">Accreditors:</label>
									<select class="form-control underlined chosen-select" data-placeholder="Choose an Accreditor..." id="accreditorForm" style="background: transparent;">
									</select>
								</div>
								<div class="form-group" id = "divInstitutionForm">
									<label for="institutionForm">Institutions:</label>
									<select class="form-control underlined chosen-select" data-placeholder="Choose an Institution..." id="institutionForm" style="background: transparent;">
									</select>
								</div>
								<div class="form-group" id="divProgramForm">
									
								</div>
								<div class="form-group" id="textFields">
									<br>
									<br>
									<br>
									<h5>Edit Text Fields</h5>
									<hr>
																		
									
								</div>
								
								 <label for="fromdate" id="fromdatelabel">Enter start date of survey  </label>
                                <br>
                                <input type="date" id="fromdate1" min=todayDateInput>
                                <br>
                                <br>
                                <label for="todate" id="todatelabel">Enter start date of survey  </label>
                                <br>
                                <input type="date" id="todate1" min=todayDateInput>
                                <br>
                                <br>
                                
                            	<input type="text" id="signperson1" value="" placeholder="Signed by">
                                <br>
                                <input type="text" id="signposition1" value="" placeholder="Position">
                                <br>
                                
                             	<button class ="btn btn-info btn-sm" onclick="genPDFDB()">Download PDF</button>
                             
							
							
                        </div>
                        <div id="manualInput" class="tab-pane fade">
                        	<br>
                            <h3>Manual Input</h3>

                                <label for="suffix">Suffix</label>
                                <br>
                                <select name="dropdown" id="suffix">
                                    <option value="Mr. ">Mr.</option>
                                    <option value="Ms. ">Ms.</option>
                                    <option value="Fr. ">Fr.</option>
                                    <option value="Dr. ">Dr.</option>
                                    <option value="Dra. ">Dra.</option>
                                </select>

                                <br>
                                <input type="text" id="recipient" value="" placeholder="Recipient">
                                <br>
                                <input type="text" id="recipientpos" value="" placeholder="Recipient Position">
                                <br>
                                <input type="text" id="school" value="" placeholder="School">
                                <br>
                                <input type="text" id="city" value="" placeholder="City">
                                <br>

                                <input type="text" id="invited" value="" placeholder="Invited Faculty">
                                <br>
                                <br>

                                <label for="department-dropdown">Select Department</label>
                                <br>
                                <select name="department-dropdown" id="department-dropdown">
                                    <option value="Elementary">Elementary</option>
                                    <option value="Secondary">Secondary</option>
                                    <option value="Integrated Basic Education">Integrated Basic Education</option>
                                    <option value="Tertiary">Tertiary</option>
                                    <option value="Graduate">Graduate</option>
                                    <option value="Medical">Medical</option>
                                    <option value="CECSTE">CECSTE</option>
                                </select>

                                <br>
                                <br>
                                <input type="text" id="surveyschool" value="" placeholder="Survey School">
                                <br>
                                <input type="text" id="schoolcity" value="" placeholder="School City">
                                <br>
                                <br>
                                <label for="fromdate" id="fromdatelabel">Enter start date of survey</label>
                                <br>
                                <input type="date" id="fromdate" min=todayDateInput>
                                <br>
                                <br>
                                <label for="todate" id="todatelabel">Enter end date of survey</label>
                                <br>
                                <input type="date" id="todate" min=todayDateInput>
                                <br>
                                <br>

                                <input type="text" id="signperson" value="" placeholder="Signed by">
                                <br>
                                <input type="text" id="signposition" value="" placeholder="Position">
                                <br>
                                <br>

                                <br>

                                <button class="btn btn-info btn-sm" onclick="genPDF()">Download PDF</button>
                                <!-- <input type="button" id="button" value="Submit"/> -->
					
                        </div>
                    </div>

                </article>
            </div>
        </div>
		<script type="text/javascript">
			var config = {
			  '.chosen-select'           : {},
			  '.chosen-select-deselect'  : {allow_single_deselect:true},
			  '.chosen-select-no-single' : {disable_search_threshold:10},
			  '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
			  '.chosen-select-width'     : {width:"95%"}
			}
			for (var selector in config) {
			  $(selector).chosen(config[selector]);
			}
		</script>
    </body>

    <script type="text/javascript">
    
	    Date.prototype.getMonthName = function() {
	        var monthNames = [ "January", "February", "March", "April", "May", "June", 
	                           "July", "August", "September", "October", "November", "December" ];
	        return monthNames[this.getMonth()];
	    }
	
	
	    Date.prototype.getFormatDate = function() {
	        var monthNames = [ "January", "February", "March", "April", "May", "June", 
	                           "July", "August", "September", "October", "November", "December" ];
	        return this.getDate() + ' ' + monthNames[this.getMonth()]+ ' ' + +this.getFullYear();
	        
	        
	    }
    
    
        var today = new Date();
        var textDate = new Date().getFormatDate().toString();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = dd + '/' + mm + '/' + yyyy;
        var todayDateInput = yyyy + '-' + mm + '-' + dd;
        var textDateNum = today.toString();
      
        
        function testfunction() {
            window.alert($('#fromdate').val());
        }

       
    </script>

    <script>
        $('#button').click(function() {

            var doc = new jsPDF();

            var name = $('#name').val();

            doc.setFontSize(26);
            doc.setTextColor(92, 76, 76);

            doc.text(23, 81, name);
            doc.save('test.pdf');


        });
    </script>



    <!-- Reference block for JS -->
    <div class="ref" id="ref">
        <div class="color-primary"></div>
        <div class="chart">
            <div class="color-primary"></div>
            <div class="color-secondary"></div>
        </div>
    </div>
    <script src="js/app.js"></script>



</html>