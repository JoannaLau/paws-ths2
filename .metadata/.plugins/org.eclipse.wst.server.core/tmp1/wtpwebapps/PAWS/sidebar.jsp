
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
					<a id = "adashboard" href="index.html" onclick="javascript:setActiveDash()"> <i class="fa fa-home"></i> Dashboard </a>
				<li id="survey">
					<a id="asurvey" href="survey.jsp" onclick="javascript:setActiveSched()"> <i class="fa fa-table"></i> Survey Schedule </a>
				</li>
				<li id="addSurvey">
					<a href="AddSurvey" onclick="javascript:setActiveSurvey()"> <i class="fa fa-pencil-square-o"></i> Add New Survey </a>
				</li>
				<li id="database">
					<a href="#demo" data-toggle="collapse" onclick="javascript:setActiveDatabase()"> <i class="fa fa-file-text-o"></i> Database <i class="fa arrow"></i> </a>
					<ul id="demo" class="collapse">
						<li id="accreditors"> <a href="Accreditors" onclick="javascript:setActiveAccreditors()">
							Accreditors
							</a> 
						</li>
						<li id="institutions"> <a href="Institutions" onclick="javascript:setActiveInstitutions()">
							Institutions
							</a> 
						</li>
						<li id="schoolSystems"> <a href="SchoolSystems" onclick="javascript:setActiveSchoolSystem()">
							School Systems
							</a> 
						</li>
						<li id="programs"> <a href="Programs" onclick="javascript:setActivePrograms()">
							Programs
							</a> 
						</li>
					</ul>
				</li>
				<li id="reports">
					<a href="#demo3" data-toggle="collapse" > <i class="fa fa-bar-chart"></i> Reports <i class="fa arrow"></i> </a>
					<ul id="demo3" class="collapse">
						<li> <a href="reportGA.html" onclick="javascript:setActiveGAawardees()">GA Awardees</a> </li>
						<li> <a href="reportHistory.html" onclick="javascript:setActiveHistory()">History</a> </li>
					</ul>
				</li>
				<li>
					<a href="notifications.jsp" onclick="javascript:setActiveNotif()">
						<i class="fa fa-bell-o"></i> Notifications 
						<p style="width:15px; height:17px;text-align:center; border-radius:10px; font-family: Verdana; font-size:10px;float:right; background-color:red; color:white;">10</p>
					</a>
				</li>
                
                	<li>
					<a href="documentGeneration.html">
						<i class="fa fa-file-text-o"></i> Document Generation
					</a>
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

