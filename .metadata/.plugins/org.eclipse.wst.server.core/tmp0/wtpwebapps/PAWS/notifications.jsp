<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html class="no-js" lang="en">
	
    <head>
    	 <!-- IMPORTS -->
    <script src='js/jquery.min.js'></script>
	
    <script src='js/jquery-ui.min.js'></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="css/vendor.css">

	
	
 	<link title="timeline-styles" rel="stylesheet" href="css/timeline.css">
	
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
	
	buildHome();
	buildAwards();
	buildExpirations();
	buildUnconfirmedSurveys();
	
	document.getElementById("awardNotif").onclick = function() {
    window.location = "reportGA.html";
	}
	document.getElementById("unconfirmedNotif").onclick = function() {
    window.location = "confirmationPage.html";
	}
	document.getElementById("expiryNotif").onclick = function() {
    window.location = "institutionProgramProfile.html";
	}

     $('#smarttable').DataTable( {
        "scrollX": true
    } );

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
$.fn.dataTable.ext.errMode = 'none';




function buildHome(){
	var add = "";
	
	add += "<ul class='item-list striped' id='g' >";
	
	<c:forEach items="${all}" var="all">
		add += "<li class='item'  >";
		add += "<div class='item-row' id='awardNotif'> ";
	    add += "<div class='item-col fixed item-col-check'> <label class='item-check' id='select-all-items'><span></span></label> </div>";
	    	add += " <div class='item-col fixed item-col-img md'><i class='fa fa-trophy fa-2x'></i></div>";
	    		add += "<div class='item-col fixed pull-left item-col-title'>";
	    		add += " <div>   <b><c:out value='${all.getContent()}'/></b> <div>Award</div></div></div>";
	    		add += "<div class='item-col item-col-date'>";           
	         	add += "    <div class='no-overflow'> <c:out value='${all.getDateCreated()}'/> </div>";
	         	add += "<div class='col-md-1' > <i class='fa fa-times' id='deleteNotif'></i> </div></div>";
	        add += "</div>";
	    add += "</li>";    
	</c:forEach>   
	    
    add += "</ul>";
        
    
    $('#home-pills').append(add);
         
         
}

function buildAwards(){
	var add = "";
	
	add += "<ul class='item-list striped' id='g' >";
	
	<c:forEach items="${awards}" var="all">
		add += "<li class='item'  >";
		add += "<div class='item-row' id='awardNotif'> ";
	    add += "<div class='item-col fixed item-col-check'> <label class='item-check' id='select-all-items'><span></span></label> </div>";
	    	add += " <div class='item-col fixed item-col-img md'><i class='fa fa-trophy fa-2x'></i></div>";
	    		add += "<div class='item-col fixed pull-left item-col-title'>";
	    		add += " <div>   <c:out value='${all.getContent()}'/> <div>Award</div></div></div>";
	    		add += "<div class='item-col item-col-date'>";           
	         	add += "    <div class='no-overflow'> <c:out value='${all.getDateCreated()}'/> </div>";
	         	add += "<div class='col-md-1' > <i class='fa fa-times' id='deleteNotif'></i> </div></div>";
	        add += "</div>";
	    add += "</li>";    
	</c:forEach>   
	    
    add += "</ul>";
        
    
    $('#award-pills').append(add);
         
         
}

function buildExpirations(){
	var add = "";
	alert("expiration")
	add += "<ul class='item-list striped' id='g' >";
	
	<c:forEach items="${expirations}" var="expirations">
		add += "<li class='item'  >";
		add += "<div class='item-row' id='awardNotif'> ";
	    add += "<div class='item-col fixed item-col-check'> <label class='item-check' id='select-expirations.-items'><span></span></label> </div>";
	    	add += " <div class='item-col fixed item-col-img md'><i class='fa fa-exclamation fa-2x'></i></i></div>";
	    		add += "<div class='item-col fixed pull-left item-col-title'>";
	    		add += " <div>   <c:out value='${expirations.getContent()}'/> <div>Award</div></div></div>";
	    		add += "<div class='item-col item-col-date'>";           
	         	add += "    <div class='no-overflow'> <c:out value='${expirations.getDateCreated()}'/> </div>";
	         	add += "<div class='col-md-1' > <i class='fa fa-times' id='deleteNotif'></i> </div></div>";
	        add += "</div>";
	    add += "</li>";    
	</c:forEach>   
	    
    add += "</ul>";
        
    
    $('#expiration-pills').append(add);
         
         
}

function buildUnconfirmedSurveys(){
	var add = "";
	
	add += "<ul class='item-list striped' id='g' >";
	
	<c:forEach items="${unconfirmedSurveys}" var="all">
		add += "<li class='item'  >";
		add += "<div class='item-row' id='awardNotif'> ";
	    add += "<div class='item-col fixed item-col-check'> <label class='item-check' id='select-all-items'><span></span></label> </div>";
	    	add += " <div class='item-col fixed item-col-img md'> <i class='fa fa-warning fa-2x'></i></i></div>";
	    		add += "<div class='item-col fixed pull-left item-col-title'>";
	    		add += " <div>   <c:out value='${all.getContent()}'/> <div>Award</div></div></div>";
	    		add += "<div class='item-col item-col-date'>";           
	         	add += "    <div class='no-overflow'> <c:out value='${all.getDateCreated()}'/> </div>";
	         	add += "<div class='col-md-1' > <i class='fa fa-times' id='deleteNotif'></i> </div></div>";
	        add += "</div>";
	    add += "</li>";    
	</c:forEach>   
	    
    add += "</ul>";
        
    
    $('#unconfirmedSurvey-pills').append(add);
         
         
}



</script>

<style>

	#contenthole{
		
		padding:15px;
		background-color: white;
		

	}

	
	#smarttable th, #smarttable td {		
		text-align: left;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;	}
		
	#smarttable th{
		background-color:#85CE36; !important
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
		
	#smarttable tr:hover {
		background: rgba(255,255,255,1);
		background: -moz-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
		background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(255,255,255,1)), color-stop(47%, rgba(246,246,246,1)), color-stop(100%, rgba(237,237,237,1)));
		background: -webkit-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
		background: -o-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
		background: -ms-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
		background: linear-gradient(to bottom, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed', GradientType=0 );

		-webkit-box-shadow: inset 0px 1px 5px 0px rgba(0,0,0,0.49);
		-moz-box-shadow: inset 0px 1px 5px 0px rgba(0,0,0,0.49);
		box-shadow: inset 0px 1px 5px 0px rgba(0,0,0,0.49);
		cursor: pointer;}

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
		
	#notifContent{
		width:700px;
	}
	
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
		
	#bPending{
		position:relative;
		left:-120px;
		float:right;
		-webkit-box-shadow: 0px 4px 7px 1px rgba(0,0,0,0.41);
		-moz-box-shadow: 0px 4px 7px 1px rgba(0,0,0,0.41);
		box-shadow: 0px 4px 7px 1px rgba(0,0,0,0.41);
		}
		
	#deleteNotif:hover{
	color:red;
	transition: color 300ms ease;
	transition: font-size 300ms ease;
	 font-size:1.5em;
		}
		
	#expiryNotif{
	padding-top:15px;
	padding-bottom:15px;
	position:relative;
	  cursor: pointer;
	 
	}
	#expiryNotif:hover{
	background-color:#afafaf;
	color:white;
	
		-webkit-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		-moz-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		box-shadow: 0px 3px 2px 0px rgba(0,0,0,0.31);
		 transition: background-color 400ms linear;
		 transition: color 400ms linear;
		 }
	#unconfirmedNotif{
	padding-top:15px;
	padding-bottom:15px;
	position:relative;
	  cursor: pointer;
	 
	}
	#unconfirmedNotif:hover{
	background-color:#afafaf;
	color:white;
	
		-webkit-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		-moz-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		box-shadow: 0px 3px 2px 0px rgba(0,0,0,0.31);
		 transition: background-color 400ms linear;
		 transition: color 400ms linear;
		 }	 
		 
	#awardNotif{
	padding-top:15px;
	padding-bottom:15px;
	position:relative;
	  cursor: pointer;
	 
	}
	#awardNotif:hover{
	background-color:#afafaf;
	color:white;
	
		-webkit-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		-moz-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		box-shadow: 0px 3px 2px 0px rgba(0,0,0,0.31);
		 transition: background-color 400ms linear;
		 transition: color 400ms linear;
		 }
	
	#bPending:hover{
		top:3px;
		-webkit-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		-moz-box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);
		box-shadow: 0px 1px 7px 1px rgba(0,0,0,0.41);

}

		
</style>
    </head>

    <body>
	
        <div class="main-wrapper" style="z-index:1;">
            <div class="app" id="app">
				   
               <jsp:include page="sidebar.jsp" />
				  
				<div class="container">
	<video poster="assets/banner.jpg" id="bgvid"  playsinline autoplay muted loop>
  <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->

<source src="assets/vid.mp4" type="video/mp4">
</video>
</div>
            <div id="welcome">
			<h1>Notifications</h1>
			
					
			</div>
			   <header class="header" id="customheader">
			   
					
                </header>
                <article class="content dashboard-page"  >
                    <section class="section" style="position: relative; top:-135px; left:-25px; width:105%;" >
                      
                    
                      
                      
					<div class="card items">
					<div class="card sameheight-item">
                                    <div class="card-block">
                                        <div class="card-title-block">
                                            <h3 class="title">
	    		
	    				</h3> </div>
                                        <!-- Nav tabs -->
                                        <ul class="nav nav-pills">
                                            <li class="nav-item"> <a href="" class="nav-link active" data-target="#home-pills" aria-controls="home-pills" data-toggle="tab" role="tab">All</a> </li>
                                            <li class="nav-item"> <a href="" class="nav-link" data-target="#award-pills" aria-controls="awards-pills" data-toggle="tab" role="tab">Awards</a> </li>
                                            <li class="nav-item"> <a href="" class="nav-link" data-target="#expiration-pills" aria-controls="expiration-pills" data-toggle="tab" role="tab">Survey Related</a> </li>
                                            <li class="nav-item"> <a href="" class="nav-link" data-target="#unconfirmedSurvey-pills" aria-controls="unconfirmedSurvey-pills" data-toggle="tab" role="tab">Unconfirmed Surveys</a> </li>
                                        </ul>
                                        <!-- Tab panes -->

                    <div class="tab-content">
                     
<!-- Start of Home tab Content -->
                     	<div class="tab-pane fade in active" id="home-pills">
            
                        </div>
                        
                        <div class="tab-pane fade" id="award-pills">
                             
                        </div>
                        <div class="tab-pane fade" id="expiration-pills">
                                            
                        </div>
                        <div class="tab-pane fade" id="unconfirmedSurvey-pills">
                                               
                        </div>
                   </div>
                                    </div>
                                    <!-- /.card-block -->
                                </div>
                       
					
					<!--item 2-->
					
                        
                   
					
					
                    
                
					
					
					
					
					
					
					
					
                    <nav class="text-xs-right">
                        <ul class="pagination">
                            <li class="page-item"> <a class="page-link" href="">
				Prev
			</a> </li>
                            <li class="page-item active"> <a class="page-link" href="">
				1
			</a> </li>
                            <li class="page-item"> <a class="page-link" href="">
				2
			</a> </li>
                            <li class="page-item"> <a class="page-link" href="">
				3
			</a> </li>
                            <li class="page-item"> <a class="page-link" href="">
				4
			</a> </li>
                            <li class="page-item"> <a class="page-link" href="">
				5
			</a> </li>
                            <li class="page-item"> <a class="page-link" href="">
				Next
			</a> </li>
                        </ul>
                    </nav>
                    </section>
                </article>
             
               <!-- EVENT MODAL -->
       	<div id="surveyModal" class="modal fade">
    		<div class="modal-dialog modal-lg" style="width:70%;">
        		<div class="modal-content">
            	
            		<div class="modal-header">
                		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">�</span> <span class="sr-only">close</span></button>
                		<h4 id="modalTitle" class="modal-title"></h4>
            		</div>
            	
            		<div id="modalBody" class="modal-body"></div>
            		<div id="modalfooter" class="modal-footer">
					<button id="delButton" type="button" class="close" data-dismiss="modal" onclick="delayDelete(1,650)"><em id="delIcon" class="fa fa-trash-o"></em></button>
                	
           		 	</div>
        		</div>
    		</div>
		
		</div>	
             
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
		 <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>

    </body>

</html>