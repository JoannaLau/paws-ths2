<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${news.getTitle()}" /></title>
<meta charset="UTF-8">
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import sementic.css components-->
<link type="text/css" rel="stylesheet" href="css/semantic.css" />

<link type="text/css" rel="stylesheet" href="components/icon.css" />


<link type="text/css" rel="stylesheet" href="css/style.css" />


<meta charset="UTF-8">


<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script
	src="http://cdn.jsdelivr.net/jquery.glide/1.0.6/jquery.glide.min.js"></script>

<script type="text/javascript" src="js/semantic.min.js"></script>
<!--<link type="text/css" rel="stylesheet" href="css/style.css" />
    -->
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<script>
	$(document)
			.ready(
					function() {
						
						var date = "${date}";
						var complete = date.split('-');
						var str_month = [ '', 'January', 'February', 'March',
								'April', 'May', 'June', 'July', 'August',
								'September', 'October', 'November', 'December' ];
						if (complete[1] < 10)
							document.getElementById("datePosted").innerHTML = "Posted on "
									+ str_month[complete[1].substring(1)]
									+ ' '
									+ complete[2] + ', ' + complete[0];
						else
							document.getElementById("datePosted").innerHTML = "Posted on "
									+ str_month[complete[1]]
									+ ' '
									+ complete[2] + ', ' + complete[0];
					});
</script>




</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="main-body-container">

		<div class="ui grid">





			<div class="sixteen wide column">



				<h2 class="ui header">
						<c:out value="${title}" />
					<div id="datePosted" class="sub header"></div>
					<hr>
				</h2>

				<br>





				<div id="image">

					<center>
						<img src="/static/${image}"
							style="width: 70%; height: auto;">
					</center>

				</div>
				<br> <br>

				<div id="newsContent" align="justify">${content}</div>








			</div>

		</div>

		<br> <br> <br>
	</div>
	<jsp:include page="footer.jsp" />



</body>






<script>
	$('.ui.dropdown').dropdown();
	$('.slider').glide({
		autoplay : 2000,
		arrowsWrapperClass : 'slider-arrows',
		arrowRightText : '',
		arrowLeftText : '',
	});
</script>








</html>