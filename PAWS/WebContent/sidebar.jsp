
<aside class="sidebar">
	<img id ="bg" src="assets/bg.jpg">
	<div class="sidebar-container">
		<div class="sidebar-header">
			<div class="brand">
				<div class="logo"> <img src="assets/logo.png" style="width:42px;height:42px; opacity:1"> </div>
				PAASCU 
			</div>
		</div>
		<nav class="menu">
			<ul class="nav metismenu" id="sidebar-menu">
				<li id="dashboard">
					<a id = "adashboard" href="/Paws"> <i class="fa fa-home"></i> Dashboard </a>
				<li id="survey">
					<a id="asurvey" href="Survey" > <i class="fa fa-table"></i> Survey Schedule </a>
				</li>
				<li id="addSurvey">
					<a href="AddSurvey" > <i class="fa fa-pencil-square-o"></i> Add New Survey </a>
				</li>
				<li id="database">
					<a href="#demo" data-toggle="collapse"> <i class="fa fa-file-text-o"></i> Database <i class="fa arrow"></i> </a>
					<ul id="demo" class="collapse">
						<li id="accreditors"> <a href="Accreditors">
							Accreditors
							</a> 
						</li>
						<li id="institutions"> <a href="Institutions">
							Institutions
							</a> 
						</li>
						<li id="schoolSystems"> <a href="SchoolSystems" >
							School Systems
							</a> 
						</li>
						<li id="programs"> <a href="Programs">
							Programs
							</a> 
						</li>
					</ul>
				</li>
				<li id="reports">
					<a href="#demo3" data-toggle="collapse" > <i class="fa fa-bar-chart"></i> Reports <i class="fa arrow"></i> </a>
					<ul id="demo3" class="collapse">
						<li> <a href="MembershipInfographics">Membership</a> </li>
						<li> <a href="SurveyVisitInfographics">Survey Visits</a> </li>
					</ul>
				</li>
				<li>
					<a href="notifications.jsp">
						<i class="fa fa-bell-o"></i> Notifications 
						<p style="width:15px; height:17px;text-align:center; border-radius:10px; font-family: Verdana; font-size:10px;float:right; background-color:red; color:white;">10</p>
					</a>
				</li>
				
				
				  <li id="news">
					<a href="#demo5" data-toggle="collapse" > <i class="fa fa-file-text-o"></i> News <i class="fa arrow"></i> </a>
					<ul id="demo5" class="collapse">
						<li id="addNews"> <a href="addNews.jsp" >
							Add News
							</a> 
						</li>
						<li id="viewNews"> <a href="ViewNews" >
							View News
							</a> 
						</li>
						
					</ul>
				</li>
				
				
                
      			<li id="docuGeneration">
					<a href="#demo4" data-toggle="collapse" onclick="javascript:setActiveDatabase()"> <i class="fa fa-file-text-o"></i> Document Generation <i class="fa arrow"></i> </a>
					<ul id="demo4" class="collapse">
						<li id="invitation"> <a href="InvitationLetter" onclick="javascript:setActiveAccreditors()">
							Invitation Letter
							</a> 
						</li>
						<li id="confirmation"> <a href="ConfirmationLetter" onclick="javascript:setActiveInstitutions()">
							Confirmation Letter
							</a> 
						</li>
						<li id="thankYouBefore"> <a href="ThankYouBeforeVisitLetter" onclick="javascript:setActiveSchoolSystem()">
							Thank You (before visit) Letter
							</a> 
						</li>
						<li id="chairperson"> <a href="ChairpersonLetter" onclick="javascript:setActivePrograms()">
							Chairperson Letter
							</a> 
						</li>
						<li id=reminder> <a href="ReminderLetter" onclick="javascript:setActivePrograms()">
							Reminder Letter
							</a> 
						</li>
					</ul>
				</li>
                
			</ul>
		</nav>
	</div>
	<footer class="sidebar-footer"></footer>
</aside>
<!-- 
<script>



var clicked = 0;


function setActiveDash(){


	localStorage.setItem("clicked", 1);

}

function setActiveDatabase(){


	localStorage.setItem("clicked", 11);

}


function setActiveSched(){


	localStorage.setItem("clicked", 2);

}

function setActiveSurvey(){


	localStorage.setItem("clicked", 3);

}


function setActiveAccreditors(){


	localStorage.setItem("clicked", 11);

}




function setActiveInstitutions(){


	localStorage.setItem("clicked", 11);

}




function setActiveSchoolSystem(){


	localStorage.setItem("clicked", 11);

}


function setActivePrograms(){


	localStorage.setItem("clicked", 11);

}


function setActiveGAawardees(){


	localStorage.setItem("clicked", 8);

}



function setActiveHistory(){


	localStorage.setItem("clicked", 9);

}



function setActiveNotif(){


	localStorage.setItem("clicked", 10);

}





</script>




<script>

$(document).ready(function() {
	

	
	var click = localStorage.getItem("clicked");

	
	if(click== 1){
		
		document.getElementById("dashboard").className = "active";

	
	}else if(click==2){
		document.getElementById("survey").className = "active";		
	} else if(click ==3){
		document.getElementById("addSurvey").className = "active";
	} else if(click ==4){
		document.getElementById("accreditors").className = "active";
	} else if(click ==5){
		document.getElementById("institutions").className = "active";
	}else if(click ==6){
		document.getElementById("schoolSystems").className = "active";
	}else if(click ==7){
		document.getElementById("programs").className = "active";
	}else if(click ==11){
		document.getElementById("demo").className = "collapse in";
		document.getElementById("demo").setAttribute("style", "height: auto;");
	}
	
	});



</script> -->

