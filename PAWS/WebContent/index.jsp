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
    <script src="js/date.js"></script>
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <!-- 	<link title="timeline-styles" rel="stylesheet" href="css/datepicker.css"> -->
    <!-- END IMPORTS -->
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
    
    <script>
    	$(document).ready(function() {
    		var objToday = new Date(),
        	weekday = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'),
        	dayOfWeek = weekday[objToday.getDay()],
        	domEnder = function() { var a = objToday; if (/1/.test(parseInt((a + "").charAt(0)))) return "th"; a = parseInt((a + "").charAt(1)); return 1 == a ? "st" : 2 == a ? "nd" : 3 == a ? "rd" : "th" }(),
        	dayOfMonth = today + ( objToday.getDate() < 10) ? '0' + objToday.getDate() + domEnder : objToday.getDate() + domEnder,
        	months = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'),
        	curMonth = months[objToday.getMonth()],
        	curYear = objToday.getFullYear(),
        	curHour = objToday.getHours() > 12 ? objToday.getHours() - 12 : (objToday.getHours() < 10 ? "0" + objToday.getHours() : objToday.getHours()),
        	curMinute = objToday.getMinutes() < 10 ? "0" + objToday.getMinutes() : objToday.getMinutes(),
        	curSeconds = objToday.getSeconds() < 10 ? "0" + objToday.getSeconds() : objToday.getSeconds(),
        	curMeridiem = objToday.getHours() > 12 ? "PM" : "AM";
       		var today = "Today is " + dayOfWeek + " " + dayOfMonth + " of " + curMonth + ", " + curYear;
       		
       		
    		$("#today").text(today);
        
    		$.getJSON("DashboardLoader?day1="+Date.monday().toString('yyyy-MM-dd')+"&day2="+Date.tuesday().toString('yyyy-MM-dd')+"&day3="+Date.wednesday().toString('yyyy-MM-dd')+"&day4="+Date.thursday().toString('yyyy-MM-dd')+"&day5="+Date.friday().toString('yyyy-MM-dd')+"&day6="+Date.saturday().toString('yyyy-MM-dd')+"&today="+Date.today().toString('yyyy-MM-dd'), function(data){
				
				
				$.each(data, function (key, value){
					$("#pnum_primary").text(value.count);
					$("#pnum_info").text(value.countMonth);
					$("#pnum_warning").text(value.countUnread);
					$("#pnum_danger").text(value.countUnconfirmed);
					
					
				});
				       
    			
    		});
    		
    		
    		
    	});
    	
    
    </script>
    
    <style>
        .container {
            width: 110%;
            overflow: hidden;
            display: block;
            height: 200px;
            z-index: -1;
            margin-left: -15px;
        }
        #bgvid {
            position: relative;
            top: -400px;
            margin-top: 0px;
            width: 110%
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
</head>

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
                <h1>Welcome back!</h1>
            </div>
            <header class="header" style="top:150px; background-color:FFFFFF; height:57px; -webkit-box-shadow: 0px 2px 11px 2px rgba(50, 50, 50, 0.58);
-moz-box-shadow:    0px 2px 11px 2px rgba(50, 50, 50, 0.58);
box-shadow:         0px 2px 11px 2px rgba(50, 50, 50, 0.58); ">
                <div class="header-block header-block-collapse hidden-lg-up">
                    <button class="collapse-btn" id="sidebar-collapse-btn">
                        <i class="fa fa-bars"></i>
                    </button>
                </div>

                <div style="position:relative; left:5%">
                
                    <h3><small id="today"></small></h3>
                </div>
               
            </header>
            <article class="content dashboard-page">
                <section class="section" style="position: relative; top:-130px;">


                    <!--Start Card format-->
                    <div class="col-xl-3">
                        <div class="card card-primary" id="notifcard">
                            <div class="card-header">
                                <div class="header-block">
                                    <p class="title"> Week events </p>
                                </div>
                            </div>
                            <div class="card-block">

                                <p id="pnum_primary"></p>
                                <p id="psub"> Upcoming </p>

                            </div>
                            <div class="card-footer"> <a href="Survey">View Calendar</a> </div>
                        </div>
                    </div>

                    <div class="col-xl-3">
                        <div class="card card-info" id="notifcard">
                            <div class="card-header">
                                <div class="header-block">
                                    <p class="title"> Month events </p>
                                </div>
                            </div>
                            <div class="card-block">
                                <p id="pnum_info"></p>
                                <p id="psub"> Total </p>
                            </div>
                            <div class="card-footer"> <a href="Survey">View Calendar</a> </div>
                        </div>
                    </div>

                    <div class="col-xl-3">
                        <div class="card card-warning" id="notifcard">
                            <div class="card-header">
                                <div class="header-block">
                                    <p class="title"> Notifications </p>
                                </div>
                            </div>
                            <div class="card-block">
                                <p id="pnum_warning"></p>
                                <p id="psub"> Unread </p>
                            </div>
                            <div class="card-footer"> <a href="Notifications">View Notifications</a> </div>
                        </div>
                    </div>

                    <div class="col-xl-3">
                        <div class="card card-danger" id="notifcard">
                            <div class="card-header">
                                <div class="header-block">
                                    <p class="title"> Unconfirmed </p>
                                </div>
                            </div>
                            <div class="card-block">
                                <p id="pnum_danger"></p>
                                <p id="psub"> Surveys </p>
                            </div>
                            <div class="card-footer"> <a href="Notifications?view=unconfirmedSurveys">View Unconfimed</a> </div>
                        </div>
                    </div>

                    <!--End Card format-->

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
            <script src="js/vendor.js"></script>
            <script src="js/app.js"></script>
	</div>
	</div>

</body>

</html>