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

      <script type="text/javascript">
	  	 function forDB(){

		   	$('#accreditorForm1_chosen').width('95%');
		   	$('#accreditorForm2_chosen').width('95%');
		   	$('#accreditorForm3_chosen').width('95%');
		   	$('#accreditorForm4_chosen').width('95%');
		   	$('#accreditorForm5_chosen').width('95%');
		   	$('#accreditorForm6_chosen').width('95%');
		   	$('#chairpersonForm_chosen').width('95%');
		   	$('#institutionForm_chosen').width('95%');
		   }

          function genPDF() {

            var doc = new jsPDF();
            var suff = document.getElementById("suffix");
            var strsuff = suff.options[suff.selectedIndex].value;

            doc.setFontSize(12);
            doc.text(20, 55, textDate);

            doc.setFontType("bold");
            var recipient = $('#recipient').val();
            recipient = strsuff + recipient;
            doc.text(20, 70, recipient);
            var type = $('#surveytype').val();
            
            doc.setFontType("normal");
            var recipientpos = $('#recipientpos').val();
            doc.text(20, 75, recipientpos);
            var school = $('#school').val();
            doc.text(20, 80, school);
            var city = $('#city').val();
            city = city + " City";
            doc.text(20, 85, city);

            var program = $('#program').val();
            var surveyschool = $('#surveyschool').val();
            var schoolcity = $('#schoolcity').val();
            schoolcity = schoolcity + " City";
           
            var from = $("#fromdate").val().split("-");

            var startdate = new Date(from[0], from[1]-1, from[2]).getFormatDate().toString();
            
            var to = $("#todate").val().split("-");

            var todate = new Date(to[0], to[1]-1, to[2]).getFormatDate().toString();
            
            
            var signperson = $('#signperson').val();
            var signposition = $('#signposition').val();

            var chairperson = $('#chairperson').val();
            var member1 = $('#member1').val();
            var member2 = $('#member2').val();
            var member3 = $('#member3').val();
            var member4 = $('#member4').val();
            var member5 = $('#member5').val();
            var member6 = $('#member6').val();

            doc.text(20, 95, "Dear " + recipient + ":");

            var paragraph="\nWe are pleased to confirm the " + type + " Visit to the "+program+" of "+surveyschool+", "+schoolcity+" on "+startdate+" to "+todate+".\n\nFrom among the many educators experienced in survey activities, the following have been selected to carry out the evaluation of your institution:\n\n\t\tChairperson :\t"+chairperson+"\n\t\t     Members :\t"+member1+"\n\t\t\t\t              "+member2+"\n\t\t\t\t              "+member3+"\n\t\t\t\t              "+member4+"\n\t\t\t\t              "+member5+"\n\t\t\t\t              "+member6+"\n\nIn keeping with PAASCU policy, institutions may make representations concerning the composition of the team. However, since the selection already represents a careful balance of experience and expertise, should there be need for adjustment in the composition of the team, reasons for such may be presented in writing to the President by the institution. Failure to hear from you would be interpreted as your being in agreement with the composition of the team. \n\nWe look forward to visiting your institution.\n\n\nSincerely,\n\n\n"+signperson+"\n"+signposition+"";
            
            lines = doc.splitTextToSize(paragraph, 175);

            doc.text(20, 100, lines);

            doc.addImage(imgHeader, 'JPEG', 0, 0, 210, 50);
            doc.addImage(imgFooter, 'JPEG', 0, 260, 210, 50);

            var filename = recipient + " Confirmation Letter " + todayDateInput + ".pdf";

            doc.save(filename);
          }
          
          function genPDFDB() {

              var doc = new jsPDF();

              doc.setFontSize(12);
              doc.text(20, 55, textDate);

              doc.setFontType("bold");
              var recipient = $('#recipient1').val();
              doc.text(20, 70, recipient);

              doc.setFontType("normal");
              var recipientpos = $('#recipientpos1').val();
              doc.text(20, 75, recipientpos);
              var school = $('#school1').val();
              doc.text(20, 80, school);
              var city = $('#city1').val();
              city = city + " City";
              doc.text(20, 85, city);
              var type = $('#surveytype1').val();
              
              
              if($('#prog1').val())
           	  {
            	  var program = $('#prog1').val();
              }

              else if($('#dept1').val())
           	  {
            	  var program = $('#dept1').val();
              }
           	  
             
              

              doc.setFontType("bold");
              var surveyschool = $('#surveyschool1').val();
              var schoolcity = $('#schoolcity1').val();
              schoolcity = schoolcity + " City";

              var from = $("#fromdate1").val().split("-");

              var startdate = new Date(from[0], from[1]-1, from[2]).getFormatDate().toString();
              
              var to = $("#todate1").val().split("-");

              var todate = new Date(to[0], to[1]-1, to[2]).getFormatDate().toString();
              
              doc.setFontType("normal");
              var signperson = $('#signperson1').val();
              var signposition = $('#signposition1').val();

              var chairperson = $('#chairperson1').val();
              var member1 = $('#accreditor1').val();
              var member2 = $('#accreditor2').val();
              var member3 = $('#accreditor3').val();
              var member4 = $('#accreditor4').val();
              var member5 = $('#accreditor5').val();
              var member6 = $('#accreditor6').val();

              doc.text(20, 95, "Dear " + recipient + ":");

              var paragraph="\nWe are pleased to confirm the "+ type + " Visit to the "+program+" of "+surveyschool+", "+schoolcity+" on "+startdate+" to "+todate+".\n\nFrom among the many educators experienced in survey activities, the following have been selected to carry out the evaluation of your institution:\n\n\t\tChairperson :\t"+chairperson+"\n\t\t     Members :\t"+member1+"\n\t\t\t\t              "+member2+"\n\t\t\t\t              "+member3+"\n\t\t\t\t              "+member4+"\n\t\t\t\t              "+member5+"\n\t\t\t\t              "+member6+"\n\nIn keeping with PAASCU policy, institutions may make representations concerning the composition of the team. However, since the selection already represents a careful balance of experience and expertise, should there be need for adjustment in the composition of the team, reasons for such may be presented in writing to the President by the institution. Failure to hear from you would be interpreted as your being in agreement with the composition of the team. \n\nWe look forward to visiting your institution.\n\n\nSincerely,\n\n\n"+signperson+"\n"+signposition+"";
              
              lines = doc.splitTextToSize(paragraph, 175);

              doc.text(20, 100, lines);

              doc.addImage(imgHeader, 'JPEG', 0, 0, 210, 50);
              doc.addImage(imgFooter, 'JPEG', 0, 260, 210, 50);

              var filename = recipient + " Confirmation Letter " + todayDateInput + ".pdf";

              doc.save(filename);
            }
            

  	    function getDateToday()
  	    {
  	    	var obj = document.getElementById('institutionSurveyForm');
  			
  			var objToday = new Date();

  			var month = (objToday.getMonth()+1);
  			
  			if(month < 10)
  				month = '0' + month;
  			
  			var day = (objToday.getDate());
  			
  			if(day < 10)
  				day = '0' + day;
  			
  			var dateToday = objToday.getFullYear().toString() + "" +  month.toString() + "" + day.toString();
  			
  			return dateToday;
  	    }

      </script>
        
        <script>

	    $(document).ready(function() {
	    	
	    	$('#institutionSurveyForm').chosen().change(function(){
				
				$('#selectSurveyForm').empty();
				var institutionID = $('#institutionSurveyForm').find(":selected").val();
				
				
			
				$.getJSON("SurveyDetailsLoader?institutionID=" + institutionID + "&date=" + getDateToday(), function(data){
					var obj = document.getElementById('selectSurveyForm');
					
					if ( data.length > 0 ) {
				    	var option = document.createElement("option");
						option.text = "";
						option.value = 0;
						obj.add(option);
								
						$.each(data, function (key, value){
							
							var option = document.createElement("option");
							option.text = value.type + " - " +  value.degreeName + " - " + value.startDate + " to " + value.endDate;
							option.value = value.PSID;
							obj.add(option);
							
							
						});	
						$('#selectSurveyForm').trigger("chosen:updated");
				    }
				});
			});
	    	
			$('#selectSurveyForm').chosen().change(function(){
				$("#divSurveyButton").html("<button class ='btn btn-info btn-sm' onclick='genPDFSurvey()'>Download PDF</button>");
			});
	    	
			
			$('#chairpersonForm').chosen().change(function(){
				
				var textFields = document.getElementById("chairFields");
				var chair1 = document.getElementById("chairperson1");
				if(chair1)
				{
					chair1.setAttribute("value", $('#chairpersonForm').find(":selected").text());
				}
				else
				{
					var labelChair = document.createElement('label');
					var chair = document.createElement('input');
					
					labelChair.setAttribute("for", "chairperson1");
					labelChair.innerHTML = "Chairperson for the survey: ";
					
					chair.setAttribute("id", "chairperson1");
					chair.setAttribute("value", $('#chairpersonForm').find(":selected").text());
					chair.setAttribute("placeholder", "Chairperson for the survey");
					chair.setAttribute("style", "width: 100%;");
					
					textFields.appendChild(labelChair);
					textFields.appendChild(chair);
				}
		
			});
			
	    	
			$('#accreditorForm1').chosen().change(function(){
				document.getElementById("accreditor1").value =  $('#accreditorForm1').find(":selected").text();
			});
			$('#accreditorForm2').chosen().change(function(){
				document.getElementById("accreditor2").value =  $('#accreditorForm2').find(":selected").text();
			});
			$('#accreditorForm3').chosen().change(function(){
				document.getElementById("accreditor3").value =  $('#accreditorForm3').find(":selected").text();
			});
			$('#accreditorForm4').chosen().change(function(){
				document.getElementById("accreditor4").value =  $('#accreditorForm4').find(":selected").text();
			});
			$('#accreditorForm5').chosen().change(function(){
				document.getElementById("accreditor5").value =  $('#accreditorForm5').find(":selected").text();
			});
			$('#accreditorForm6').chosen().change(function(){
				document.getElementById("accreditor6").value =  $('#accreditorForm6').find(":selected").text();
			});
			
			
							
				
			$('#institutionForm').chosen().change(function(){
				
				
				$('#divProgramForm').empty();
				$('#programNum').empty();
				$('#programFields').empty();
				document.getElementById("dept1").value = "";
				document.getElementById("prog1").value = "";
				
				var institutionID = $('#institutionForm').find(":selected").val();
				
	
				$.getJSON("InstitutionForInvitationLoader?institutionID=" + institutionID, function(data){
				   
						$.each(data, function (key, value) {
						    var schoolFromLoader = value.name;
							var cityFromLoader = value.city;
							var recipientFromLoader = value.head;
							var recipientPosiFromLoader = value.hPosition;
							var educLevelFromLoader = value.educLevel;
							
							document.getElementById("recipient1").value = recipientFromLoader;
							document.getElementById("recipient-1").value = recipientFromLoader;
							document.getElementById("recipientpos1").value = recipientPosiFromLoader;
							document.getElementById("city1").value = cityFromLoader;
							document.getElementById("schoolcity1").value = cityFromLoader;
							document.getElementById("surveyschool1").value = schoolFromLoader;
							document.getElementById("school1").value = schoolFromLoader;
							document.getElementById("dept1").value = educLevelFromLoader + " Department";
							
								
				    	});
						
		    	});
				
				
				
				$.getJSON("ProgramLoader?institutionID=" + institutionID, function(data){
				    
					if(data.length > 0) 
			    	{
					
						document.getElementById("divDept1").setAttribute("style", "visibility: hidden;");
						document.getElementById("divProg1").setAttribute("style", "visibility: visible;");
							
						var programNum = document.getElementById("programNum");
	
				    	var labelNumPrograms = document.createElement("label");
				    	labelNumPrograms.innerHTML = "Number of programs to survey: "
				    	
				    	var nProgramOption = document.createElement("select");
				    	nProgramOption.setAttribute("id", "programNumberSelect");
				    	nProgramOption.setAttribute("class", "form-control underlined chosen-select");
				    	nProgramOption.setAttribute("data-placeholder", "Number of Programs to survey: ");
	
						programNum.appendChild(labelNumPrograms);
				    	
						var option1 = document.createElement("option");
						option1.text = '1';
						option1.value = '1';
						nProgramOption.add(option1);
						
						var option2 = document.createElement("option");
						option2.text = '2';
						option2.value = '2';
						nProgramOption.add(option2);
						
						var option3 = document.createElement("option");
						option3.text = '3';
						option3.value = '3';
						nProgramOption.add(option3);
						
						programNum.appendChild(nProgramOption);
						
						$('#divProgramForm').empty();
						
						var divProgramForm = document.getElementById("divProgramForm");
						var labelPrograms = document.createElement("label");
				    	labelPrograms.innerHTML = "Programs to be surveyed: "
				    	divProgramForm.appendChild(labelPrograms);
				    	divProgramForm.appendChild(document.createElement("br"));
				    	
				    	
						$.getJSON("ProgramLoader?institutionID=" + institutionID, function(data){
							var selectElement = document.createElement("select");
							selectElement.setAttribute("id", "programForm0");
							
							 var option = document.createElement("option");
								option.text = "";
								option.value = "0";
								selectElement.add(option);
							
							$.each(data, function (key, value){
								    var option = document.createElement("option");
									option.text = value.degreeName;
									option.value = value.SPID;
									selectElement.add(option);
						    	});
	
							$('#programForm0').trigger("chosen:updated");
	
							divProgramForm.appendChild(selectElement);
						});
						
						
			    	}
					else
					{
						document.getElementById("divDept1").setAttribute("style", "visibility: visible;");
						document.getElementById("divProg1").setAttribute("style", "visibility: hidden;");
					}
				});
			});
		
			$(document.body).on('change', '#programNumberSelect', function(event) {
			    
				document.getElementById("prog1").value = "";
				document.getElementById("dept1").value = "";				
				
				$('#divProgramForm').empty();
				$('#programFields').empty();
				
				
				var divProgramForm = document.getElementById("divProgramForm");
				var labelPrograms = document.createElement("label");
		    	labelPrograms.innerHTML = "Programs to be surveyed: "
		    	divProgramForm.appendChild(labelPrograms);
		    	divProgramForm.appendChild(document.createElement("br"));
				var institutionID = $('#institutionForm').find(":selected").val();
	
				var nPrograms = $('#programNumberSelect').find(":selected").val();
				
				console.log(nPrograms);
				
				
					$.getJSON("ProgramLoader?institutionID=" + institutionID, function(data){
					for(var i = 0; i<nPrograms; i++)
					{
						var selectElement = document.createElement("select");
						selectElement.setAttribute("id", "programForm"+i);
						
						var option = document.createElement("option");
							option.text = "";
							option.value = "0";
	
							selectElement.add(option);
						
						$.each(data, function (key, value){
							    var option = document.createElement("option");
								option.text = value.degreeName;
								option.value = value.SPID;
								selectElement.add(option);
					    	});
	
						$('#programForm' + i).trigger("chosen:updated");
	
						divProgramForm.appendChild(selectElement);
						divProgramForm.appendChild(document.createElement("br"));
					}	
					});
					
				
				
				
			});
		    	
			$(document.body).on('change', '#programForm0', function(event) {
			    
				if($('#programForm0').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text();
				}
				if($('#programForm1').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text() + ", " + $('#programForm1').find(":selected").text();
				}
				if($('#programForm2').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text() + ", " + $('#programForm1').find(":selected").text()  + ", " + $('#programForm2').find(":selected").text();
				}
			
			});
			
			$(document.body).on('change', '#programForm1', function(event) {
			
				if($('#programForm0').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text();
				}
				if($('#programForm1').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text() + ", " + $('#programForm1').find(":selected").text();
				}
				if($('#programForm2').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text() + ", " + $('#programForm1').find(":selected").text()  + ", and " + $('#programForm2').find(":selected").text();
				}
			
			});
					
			$(document.body).on('change', '#programForm2', function(event) {
				if($('#programForm0').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text();
				}
				if($('#programForm1').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text() + ", " + $('#programForm1').find(":selected").text();
				}
				if($('#programForm2').find(":selected").text() != "")
				{
					document.getElementById("prog1").value = $('#programForm0').find(":selected").text() + ", " + $('#programForm1').find(":selected").text()  + ", and " + $('#programForm2').find(":selected").text();
				}
			});
		    	
			    getInstitutions();
			    getAccreditors1();
			    getAccreditors2();
			    getAccreditors3();
			    getAccreditors4();
			    getAccreditors5();
			    getAccreditors6();
			    getChairpersons();
			    getInstitutionsSurvey();
			    
			});
	    
	        
		    function getInstitutionsSurvey()
			{
				var obj = document.getElementById('institutionSurveyForm');
				
				var dateToday = getDateToday();
					
				$.getJSON("InstitutionInSurveysLoader?date=" + dateToday, function(data){
					var option = document.createElement("option");
					option.text = "";
					option.value = 0;
					obj.add(option);
					
					$.each(data, function (key, value){
						var option = document.createElement("option");
						option.text = value.institutionName + " - " + value.city;
						option.value = value.institutionID;
						obj.add(option);
						
					});	
					$('#institutionSurveyForm').trigger("chosen:updated");
				});
			}
	    
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
						option.text = value.institutionName + " - " + value.city;
						option.value = value.institutionID;
						obj.add(option);
						
					});	
					$('#institutionForm').trigger("chosen:updated");
				});
				
			}
	        
	        function getChairpersons(){ 
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("chairpersonForm");
		    	
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

					$('#chairpersonForm').trigger("chosen:updated");

				});
				
			}
	
		    function getAccreditors1(){ 
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("accreditorForm1");
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

					$('#accreditorForm1').trigger("chosen:updated");

				});
				
			}
		    
		    function getAccreditors2(){
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("accreditorForm2");
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

					$('#accreditorForm2').trigger("chosen:updated");

				});
				
			}
		    
		    function getAccreditors3(){
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("accreditorForm3");
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

					$('#accreditorForm3').trigger("chosen:updated");

				});
				
			}
		    
		    function getAccreditors4(){
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("accreditorForm4");
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

					$('#accreditorForm4').trigger("chosen:updated");

				});
				
			}
        
		    function getAccreditors5(){
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("accreditorForm5");
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

					$('#accreditorForm5').trigger("chosen:updated");

				});
				
			}
		    
		    function getAccreditors6(){
		    	//GETS ALL SYSTEMS FOR THE SELECT DROPDOWN
					
		    	var obj = document.getElementById("accreditorForm6");
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

					$('#accreditorForm6').trigger("chosen:updated");

				});
				
			}
		    

		    function genPDFSurvey() {
		    	var PSID = $('#selectSurveyForm').find(":selected").val();
				
				$.getJSON("ConfirmationSurveyDetailsLoader?PSID=" + PSID + "&instID=" + $('#institutionSurveyForm').find(":selected").val(), function(data){
					$.each(data, function (key, value){
						
						var accSize = value.accSize;
	
						var degreeName = value.degreeName;
						var startdate = value.startDate;
						var todate = value.endDate;
						var type = value.type;
						
						var chairperson = value.chairperson;
						
						if(!type.includes("survey"))
						{
							type = type + " Survey";
						}
						
						var head = value.head;
						var hPosition = value.hPosition;
						var name = value.name;
						var city = value.city;
	
	
			              var doc = new jsPDF();
	
			              doc.setFontSize(12);
			              doc.text(20, 55, textDate);
	
			              doc.setFontType("bold");
			              doc.text(20, 70, head);
	
			              doc.setFontType("normal");
			              doc.text(20, 75, hPosition);
			              
			              doc.text(20, 80, name);
			            
			              city = city + " City";
			              doc.text(20, 85, city);
	
			              
			              doc.setFontType("bold");
			              var surveyschool = name;
			              var schoolcity = surveyschool + " " + city;
	
			             		              
			              doc.setFontType("normal");
			              var signperson = $('#signperson2').val();
			              var signposition = $('#signposition2').val();
	
			             
	
			              doc.text(20, 95, "Dear " + head + ":");
	
			              var paragraph="\nWe are pleased to confirm the " + type + " Visit to the "+degreeName+" Department of "+schoolcity+" on "+startdate+" to "+todate+".\n\nFrom among the many educators experienced in survey activities, the following have been selected to carry out the evaluation of your institution:\n\n\t\tChairperson :\t"+chairperson+"\n\t\t     Members :\t";
			              
			              var PSID = $('#selectSurveyForm').find(":selected").val();
							
			              
			              
		
			              
			              var json = (function () {
			            	    var json = null;
			            	    $.ajax({
			            	        'async': false,
			            	        'global': false,
			            	        'url': "AccreditorInSurveyLoader?PSID=" + PSID,
			            	        'dataType': "json",
			            	        'success': function (data) {
			            	            json = data;
			            	        }
			            	    });
			            	    return json;
			            	})(); 
			              
			              
			              
			              for(var i = 0; i<json.length; i++)
		            	  {
			            	  paragraph = paragraph + json[i]["accName"] + "\n\t\t\t\t              ";
		            	  }
			              
			              
			              
			              paragraph = paragraph + "\n\nIn keeping with PAASCU policy, institutions may make representations concerning the composition of the team. However, since the selection already represents a careful balance of experience and expertise, should there be need for adjustment in the composition of the team, reasons for such may be presented in writing to the President by the institution. Failure to hear from you would be interpreted as your being in agreement with the composition of the team. \n\nWe look forward to visiting your institution.\n\n\nSincerely,\n\n\n"+signperson+"\n"+signposition+"";
			              
			              lines = doc.splitTextToSize(paragraph, 175);
	
			              doc.text(20, 100, lines);
	
			              doc.addImage(imgHeader, 'JPEG', 0, 0, 210, 50);
			              doc.addImage(imgFooter, 'JPEG', 0, 260, 210, 50);
	
			              var filename = head + " Confirmation Letter " + todayDateInput + ".pdf";
	
			              doc.save(filename);
							
						});
					});
					
				
				
				
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
                    <h1>Create Confirmation Letter</h1>
                </div>
                <article class="content dashboard-page">
                    <ul class="nav nav-tabs" style="margin-top:-4cm;">
                        <li class="active"><a data-toggle="tab" href="#fromSurveys">From Surveys</a>
                        </li>
                        <li id="liDB" onclick="forDB();"><a data-toggle="tab" href="#fromDB">From Database</a>
                        </li>
                        <li><a data-toggle="tab" href="#manualInput">Manual Input</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div id="fromSurveys" class="tab-pane fade in active">
                        <br>
                       		<h3>Import From Upcoming Surveys</h3>
                           
                           	<div class="form-group" id = "divSurveyInstitutionForm">
								<label for="institutionSurveyForm">Step 1: Choose an institution: </label>
								<select class="form-control underlined chosen-select" data-placeholder="Choose an Institution" id="institutionSurveyForm" style="background: transparent;">
								</select>
							</div>
							
							<div class="form-group" id = "divSurveyForm">
								<label for="selectSurveyForm">Step 2: Choose a survey from the institution: </label>
								<select class="form-control underlined chosen-select" data-placeholder="Choose a survey" id="selectSurveyForm" style="background: transparent;">
								</select>
							</div>
							<label>Step 3: Input signature fields: </label>
							<br>
							<p style="display: inline-block;">Sincerely Yours,</p>
                               	<br>
                            	<input style="width: 20%;" placeholder="Signed By" id="signperson2">							
								<br>
								<input style="width: 20%;" placeholder="Position" id="signposition2">							
								<br>
								<br>
							
							<label>Step 4: Click on 'Download PDF' to download the invitation letter. Button will show once a survey is chosen.</label>
							<br>
                            
							<div id="divSurveyButton">
							</div>
								 
								
							
                        </div>
                        <div id="fromDB" class="tab-pane fade">
                        <br>
                            <h3>Import From Database</h3>
                            
								<div class="form-group" id = "divInstitutionForm">
									<label for="institutionForm">Institution to survey:</label>
									<select class="form-control underlined chosen-select" data-placeholder="Choose an Institution..." id="institutionForm" style="background: transparent;">
									</select>
								</div>
				
								<div class = "form-group" id="programNum">
								</div>
									
								<div class="form-group" id="divProgramForm">
								</div>
							
								<br>
                                <br>
                                <div class="form-group" id = "divChairpersonForm">
									<label for="chairpersonForm">Chairperson for this survey:</label>
									<select class="form-control underlined chosen-select" data-placeholder="Choose a Chairperson..." id="chairpersonForm" style="background: transparent;">
									</select>
								</div>
								<br><br>
								<div class="form-group" id = "divAccreditorForm">
									<label for="accreditorForm">Accreditors for this survey:</label>
									<select class="form-control underlined chosen-select" data-placeholder="Choose Accreditor #1..." id="accreditorForm1" style="background: transparent;">
									</select>
									<br><br>
									<select class="form-control underlined chosen-select" data-placeholder="Choose Accreditor #2..." id="accreditorForm2" style="background: transparent;">
									</select>
									<br><br>
									<select class="form-control underlined chosen-select" data-placeholder="Choose Accreditor #3..." id="accreditorForm3" style="background: transparent;">
									</select>
									<br><br>
									<select class="form-control underlined chosen-select" data-placeholder="Choose Accreditor #4..." id="accreditorForm4" style="background: transparent;">
									</select>
									<br><br>
									<select class="form-control underlined chosen-select" data-placeholder="Choose Accreditor #5..." id="accreditorForm5" style="background: transparent;">
									</select>
									<br><br>
									<select class="form-control underlined chosen-select" data-placeholder="Choose Accreditor #6..." id="accreditorForm6" style="background: transparent;">
									</select>
								</div>
								<br>
                                <br>
								<div class="form-group" id="textFields">
									<br>
									<br>
									<br>
									<h5>Edit Text Fields</h5>
									<hr>
									
                                	
                                	<input style="width: 30%;" placeholder="Recipient" id="recipient1">	
									<br>						
									<input style="width: 30%;" placeholder="Recipient Position" id="recipientpos1">							
									<br>
									<input style="width: 30%;" placeholder="Institution Name" id="school1">							
									<br>
									<input style="width: 30%;" placeholder="Institution City" id="city1">		
                                	
                                	<br><br>
									<p style="display: inline-block;">Dear &nbsp;</p><input style="width: 20%;" placeholder="Recipient" id="recipient-1"><p style="display: inline-block;">: &nbsp;</p>	
									<br>
									<br>
									
									<p style="display: inline-block;">We are pleased to confirm the</p>
									
									<input style="width: 30%;" placeholder="Survey Type" id="surveytype1">
									
									<p style="display: inline-block;">Visit to the </p>
									<div id="divDept1">
										<input style="width: 30%;" placeholder="Department" id="dept1">
									</div>
									<div id="divProg1" style="visibility: hidden;">
										<input style="width: 30%;" placeholder="Program(s)" id="prog1">
									</div>
									
									
									<p style="display: inline-block;">&nbsp; of &nbsp;</p>
									<input style="width: 30%;" placeholder="Institution Name" id="surveyschool1">
									<p style="display: inline-block;">, &nbsp;</p>
									<input style="width: 20%;" placeholder="Institution City" id="schoolcity1">
									<p style="display: inline-block;">&nbsp; from &nbsp;</p>
									<input type="date" id="fromdate1" min=todayDateInput>
									<p style="display: inline-block;">&nbsp; to &nbsp;</p>
									<input type="date" id="todate1" min=todayDateInput>
									<p style="display: inline-block;">&nbsp; .</p>
									
									<p style="display: inline-block;">From among the many educators experienced in survey activities, the following have been selected to carry out the evaluation of your institution:</p>
									<br>
									<br>
									<p style="display: inline-block;">Chairperson:</p>
									<input style="width: 20%;" placeholder="Chairperson" id="chairperson1">
									
									<p>Accreditors:</p>
									
									<input style="width: 30%;" placeholder="Accreditor #1" id="accreditor1">
									<br>
									<input style="width: 30%;" placeholder="Accreditor #2" id="accreditor2">
									<br>
									<input style="width: 30%;" placeholder="Accreditor #3" id="accreditor3">
									<br>
									<input style="width: 30%;" placeholder="Accreditor #4" id="accreditor4">
									<br>
									<input style="width: 30%;" placeholder="Accreditor #5" id="accreditor5">
									<br>
									<input style="width: 30%;" placeholder="Accreditor #6" id="accreditor6">
									<br>
									<br>
									<p>In keeping with PAASCU policy, institutions may make representations concerning the
										composition of the team. However, since the selection already represents a careful balance of
										experience and expertise, should there be need for adjustment in the composition of the
										team, reasons for such may be presented in writing to the President by the institution. Failure
										to hear from you would be interpreted as your being in agreement with the composition of the
										team. 
									</p>
									<br>
									<p>We look forward to visiting your institution.</p>
									
									<br><br>
									<p style="display: inline-block;">Sincerely Yours,</p>
                                	<br>
	                            	
                                	<input type="text" id="signperson1" value="" placeholder="Signed by">
	                                <br>
	                                <input type="text" id="signposition1" value="" placeholder="Position">
	                                <br><br>
	                            
								
								</div>
							
                                
                                
                             	<button class ="btn btn-info btn-sm" onclick="genPDFDB()">Download PDF</button>
                             
							
							
                        </div>
                        <div id="manualInput" class="tab-pane fade">
                        	<br>
                            <h3>Manual Input</h3>

                                <label for="suffix">Suffix</label><br>
							    <select name="dropdown" id="suffix">
							        <option value="Mr. ">Mr.</option>
							        <option value="Ms. ">Ms.</option>
							        <option value="Fr. ">Fr.</option>
							        <option value="Dr. ">Dr.</option>
							        <option value="Dra. ">Dra.</option>
							    </select>
							
							    <br>
							    <input type="text" id="recipient" value="" placeholder="Recipient"><br>
							    <input type="text" id="recipientpos" value="" placeholder="Recipient Position"><br>
							    <input type="text" id="school" value="" placeholder="School"><br>
							    <input type="text" id="city" value="" placeholder="City"> City<br>
							
							    <br>
							    <input type="text" id="surveytype" value="" placeholder="Survey Type"><br>							    
							    <input type="text" id="surveyschool" value="" placeholder="Survey School"><br>
							    <input type="text" id="schoolcity" value="" placeholder="School City"> City<br><br>
							    <input type="text" id="program" value="" placeholder="Program(s) (Ex. Bachelor of Arts in Animation)"><br>
							    <br><br>
							    <label for="fromdate" id="fromdatelabel">Enter start date of survey </label><br>
							   	<input type="date" id="fromdate" min=todayDateInput><br><br>
							    <label for="todate" id="todatelabel">Enter end date of survey </label><br>
							    <input type="date" id="todate" min=todayDateInput><br><br>
							
							    <input type="text" id="chairperson" value="" placeholder="Chairperson"><br>
							    <input type="text" id="member1" value="" placeholder="First Member"><br>
							    <input type="text" id="member2" value="" placeholder="Second Member"><br>
							    <input type="text" id="member3" value="" placeholder="Third Member"><br>
							    <input type="text" id="member4" value="" placeholder="Fourth Member"><br>
							    <input type="text" id="member5" value="" placeholder="Fifth Member"><br>
							    <input type="text" id="member6" value="" placeholder="Sixth Member"><br><br>
							
							
							    <input type="text" id="signperson" value="" placeholder="Signed by"><br>
							    <input type="text" id="signposition" value="" placeholder="Position"><br><br>


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