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
	    	
    		$.getJSON("DecisionsLoader?PSID=${PSID}", function(data){
				
				if ( data.length > 0 ) {
			    	$.each(data, function (key, value){
						if(data.length > 0)
						{
							if(value.decisionBy == "Board")
							{
								$('#boardInput').val(value.decision);	
							}
							else if(value.decisionBy == "Team")
							{
								$('#teamInput').val(value.decision);	
								
							}
							else if(value.decisionBy == "Commission")
							{		
								$('#commInput').val(value.decision);	
							}
						}
						
					});	
			    }
			});
		});
	
    	
    	function saveDecision()
    	{
    		var teamChoice;
    		var boardChoice;
    		var commChoice;
    		var text;
    		
    		if ($("#teamChoice1").prop("checked"))
 			{
    			teamChoice = $("#teamChoice1").val() + " " + $("#teamChoice1years").val() + " years";
 			}
    		else if ($("#teamChoice2").prop("checked"))
 			{
    			teamChoice = "Re-accreditation after " +  $("#teamAreaNyears1").val() + " years with a WRITTEN PROGRESS REPORT on the " + $("#teamAreaNth1").val() + " year on the areas " + $("#teamChoiceArea").val();
 			}
    		else if ($("#teamChoice3").prop("checked"))
 			{
    			teamChoice = "Re-accreditation after " +  $("#teamAreaNyears2").val() + " years with an Interim Visit on the " + $("#teamAreaNth2").val() + " year on the areas " + $("#teamChoiceArea1").val();
 			}
    		else if ($("#teamChoice4").prop("checked"))
 			{
    			teamChoice = $("#teamChoice4").val();
    			text = $("#teamArea").val();
 			}
    		
    		
    		
    		if ($("#boardChoice1").prop("checked"))
 			{
    			boardChoice = $("#boardChoice1").val() + " " + $("#boardChoice1years").val() + " years";
 			}
    		else if ($("#boardChoice2").prop("checked"))
 			{
    			boardChoice = "Re-accreditation after " +  $("#boardAreaNyears1").val() + " years with a WRITTEN PROGRESS REPORT on the " + $("#boardAreaNth1").val() + " year on the areas " + $("#boardChoiceArea").val();
 			}
    		else if ($("#boardChoice3").prop("checked"))
 			{
    			boardChoice = "Re-accreditation after " +  $("#boardAreaNyears2").val() + " years with an Interim Visit on the " + $("#boardAreaNth2").val() + " year on the areas " + $("#boardChoiceArea1").val();
 			}
    		else if ($("#boardChoice4").prop("checked"))
 			{
    			boardChoice = $("#boardChoice4").val();
    			text = $("#boardArea").val();
 			}
    		
    		
    		
    		if ($("#commChoice1").prop("checked"))
 			{
    			commChoice = $("#commChoice1").val() + " " + $("#commChoice1years").val() + " years";
 			}
    		else if ($("#commChoice2").prop("checked"))
 			{
    			commChoice = "Re-accreditation after " +  $("#commAreaNyears1").val() + " years with a WRITTEN PROGRESS REPORT on the " + $("#commAreaNth1").val() + " year on the areas " + $("#commChoiceArea").val();
 			}
    		else if ($("#commChoice3").prop("checked"))
 			{
    			commChoice = "Re-accreditation after " +  $("#commAreaNyears2").val() + " years with an Interim Visit on the " + $("#commAreaNth2").val() + " year on the areas " + $("#commChoiceArea1").val();
 			}
    		else if ($("#commChoice4").prop("checked"))
 			{
    			commChoice = $("#commChoice4").val();
    			text = $("#commArea").val();
 			}
    		
    		document.location.href = "UpdateSurveyDecision?surveyID=${surveyID}&PSID=${PSID}&boardChoice=" + boardChoice + "&teamChoice=" + teamChoice + "&commChoice=" + commChoice + "&text=" + text;
    		
    		
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
                    <h4>Decision for ${title}</h4>
                    <br>
                    <h6>${surveyType}</h6>
                </div>
                
                <article class="content dashboard-page" style="padding-bottom:10px;">
                    
					<div>
					<form>
                    <h4> <b>Team Decision :</b> </h4>
                    <input id="teamInput" style="width:900px;">
                    
                    <label class='control-label' style='width:100%;'> <br><input id="teamChoice1" name='opt_team' class='radio ' type='radio'  value='Re-accreditation for a period of'>	<span>Re-accreditation for a period of
                    <select id = "teamChoice1years">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    
                    </span> <br> <hr></label>
                    
   			 		<label class='control-label' style='width:100%;'> <br><input id="teamChoice2" name='opt_team' class='radio ' type='radio'  value='Re-accreditation after'>	<span>Re-accreditation after 
                    <select id = "teamAreaNyears1">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    years with a WRITTEN PROGRESS REPORT on the 
                    <select id = "teamAreaNth1">
                    	<option value = "3rd">3rd</option>
                    	<option value = "4th">4th</option>
                    	<option value = "5th">5th</option>
                    	<option value = "6th">6th</option>
                    	<option value = "7th">7th</option>
                    </select>
                    year on the areas
                    <br>
                    <input type='text' id="teamChoiceArea" style="width:900px;">
                    
                    
                    </span> <br> <hr></label>
   			 		
   			 		<label class='control-label' style='width:100%;'> <br><input id="teamChoice3" name='opt_team' class='radio ' type='radio'  value='Re-accreditation for'>	<span>Re-accreditation for 
                    <select id = "teamAreaNyears2">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    years with an INTERIM VISIT on the 
                    <select id = "teamAreaNth2">
                    	<option value = "3">3rd</option>
                    	<option value = "4">4th</option>
                    	<option value = "5">5th</option>
                    	<option value = "6">6th</option>
                    	<option value = "7">7th</option>
                    </select>
                    year on the areas
                    <br>
                    <input type='text' id="teamChoiceArea1" style="width:900px;">
                    
                    
                    </span> <br> <hr></label>
   			 		
   			 		<label class='control-label' style='width:100%;'> <input id="teamChoice4" name='opt_team'class='radio' type='radio' value='Re-accreditation deferred'> <span>Re-accreditation deferred</span>  </label>
   			 		<label>Reasons for deferment:</label>
   			 		<input type='text' id="teamArea1" name='areas' style="width:900px;">
   			 		</form>
					<hr>
					<br>
					<br>
					<br>
					<form>
					
					<br>
					<br>
					
					<h4> <b>Commission Decision : </b></h4>
                    <input id="commInput" style="width:900px;">
                    
                    <label class='control-label' style='width:100%;'> <br><input id="commChoice1" name='opt_team' class='radio ' type='radio'  value='Re-accreditation for a period of'>	<span>Re-accreditation for a period of
                    <select id = "commChoice1years">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    
                    </span> <br> <hr></label>
                    
   			 		<label class='control-label' style='width:100%;'> <br><input id="commChoice2" name='opt_team' class='radio ' type='radio'  value='Re-accreditation after'>	<span>Re-accreditation after 
                    <select id = "commAreaNyears1">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    years with a WRITTEN PROGRESS REPORT on the 
                    <select id = "commAreaNth1">
                    	<option value = "3">3rd</option>
                    	<option value = "4">4th</option>
                    	<option value = "5">5th</option>
                    	<option value = "6">6th</option>
                    	<option value = "7">7th</option>
                    </select>
                    year on the areas
                    <br>
                    <input type='text' id="commChoiceArea" style="width:900px;">
                    
                    
                    </span> <br> <hr></label>
   			 		
   			 		<label class='control-label' style='width:100%;'> <br><input id="commChoice3" name='opt_team' class='radio ' type='radio'  value='Re-accreditation for'>	<span>Re-accreditation for 
                    <select id = "commAreaNyears2">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    years with an INTERIM VISIT on the 
                    <select id = "commAreaNth2">
                    	<option value = "3">3rd</option>
                    	<option value = "4">4th</option>
                    	<option value = "5">5th</option>
                    	<option value = "6">6th</option>
                    	<option value = "7">7th</option>
                    </select>
                    year on the areas
                    <br>
                    <input type='text' id="commChoiceArea1" style="width:900px;">
                    
                    
                    </span> <br> <hr></label>
   			 		
   			 		<label class='control-label' style='width:100%;'> <input id="commChoice4" name='opt_team'class='radio' type='radio' value='Re-accreditation deferred'> <span>Re-accreditation deferred</span>  </label>
   			 		<label>Reasons for deferment:</label>
   			 		<input type='text' id="commmArea1" name='areas' style="width:900px;">
   			 		</form>
					
					
					<br>
					<br>
					<h4> <b> Board Decision : </b></h4>
                    <input id="boardInput" style="width:900px;">
                    
                    <label class='control-label' style='width:100%;'> <br><input id="boardChoice1" name='opt_team' class='radio ' type='radio'  value='Re-accreditation for a period of'>	<span>Re-accreditation for a period of
                    <select id = "boardChoice1years">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    
                    </span> <br> <hr></label>
                    
   			 		<label class='control-label' style='width:100%;'> <br><input id="boardChoice2" name='opt_team' class='radio ' type='radio'  value='Re-accreditation after'>	<span>Re-accreditation after 
                    <select id = "boardAreaNyears1">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    years with a WRITTEN PROGRESS REPORT on the 
                    <select id = "boardAreaNth1">
                    	<option value = "3">3rd</option>
                    	<option value = "4">4th</option>
                    	<option value = "5">5th</option>
                    	<option value = "6">6th</option>
                    	<option value = "7">7th</option>
                    </select>
                    year on the areas
                    <br>
                    <input type='text' id="boardChoiceArea" style="width:900px;">
                    
                    
                    </span> <br> <hr></label>
   			 		
   			 		<label class='control-label' style='width:100%;'> <br><input id="boardChoice3" name='opt_team' class='radio ' type='radio'  value='Re-accreditation for'>	<span>Re-accreditation for 
                    <select id = "boardAreaNyears2">
                    	<option value = "3">3 years</option>
                    	<option value = "4">4 years</option>
                    	<option value = "5">5 years</option>
                    	<option value = "6">6 years</option>
                    	<option value = "7">7 years</option>
                    </select>
                    years with an INTERIM VISIT on the 
                    <select id = "boardAreaNth2">
                    	<option value = "3">3rd</option>
                    	<option value = "4">4th</option>
                    	<option value = "5">5th</option>
                    	<option value = "6">6th</option>
                    	<option value = "7">7th</option>
                    </select>
                    year on the areas
                    <br>
                    <input type='text' id="boardChoiceArea1" style="width:900px;">
                    
                    
                    </span> <br> <hr></label>
   			 		
   			 		<label class='control-label' style='width:100%;'> <input id="boardChoice4" name='opt_team'class='radio' type='radio' value='Re-accreditation deferred'> <span>Re-accreditation deferred</span>  </label>
   			 		<label>Reasons for deferment:</label>
   			 		<input type='text' id="boardArea1" name='areas' style="width:900px;">
   			 		</form>
					<hr>
					<br>
					<br>
					<br>
					<button onclick="saveDecision();" class ='btn btn-info btn-sm' style="padding-bottom: 7px;">Update Decision</button>
              

   			 		<!-- 
   			 		
   			 		<input type='hidden' name='PSID' value='"+PSID+"'>
   			 		<input type='hidden' name='surveyID' value='"+surveyID+"'> 
   			 		<input type='hidden' name='type'value='Preliminary'> 
   			 		 
   			 		   -->
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