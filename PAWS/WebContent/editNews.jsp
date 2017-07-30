<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit News</title>




    
    	<script src="js/jquery.min.js"></script>
    	
    	
    	
        <meta charset="utf-8">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
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
		
<script src="calendar/fullcalendar.js"></script>
    	<script src="calendar/fullcalendar.min.js"></script>
    	
    	
  
      <script type="text/javascript" src="js/jspdf.min.js"></script>
      <script src="js/jquery-2.1.3.min.js"></script>
      <script type="text/javascript" src="js/html2canvas.min.js"></script>
    <link type="text/css" rel="stylesheet" href="css/stylestest.css"/>
    
    
    
    
    
    
    
    
    
<style>

	.container{
		width: 110%;
		overflow:hidden;
		display:block;
		height: 200px;
		z-index:-1;
		margin-left:-15px;
}
	#bgvid{
		position:relative;
		top:-400px;
		margin-top:0px;
		width:110%
	
	}

	body {
		
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}
	#bg{
		height: 640px;
		position:fixed;
	}
	
	#main{
		position:relative;
		top:-290px;
	
	}
	
	#pnum_danger,#pnum_info,#pnum_warning,#pnum_primary{
		font-size:75px; 
		text-align:center;
		 margin-left: -2px;
		padding: 0;
		
		line-height:85px;
	}
	
	#pnum_danger{
	color:#5c5c5c;	
	transition: all 0.5s ease;
	}	
		#pnum_danger:hover{
		color:#ff2b2b;	
		font-size:100px;
		cursor:pointer;
		}

	#pnum_warning{
	color:#5c5c5c;	
	transition: all 0.5s ease;
	}	#pnum_warning:hover{
		font-size:100px;
		cursor:pointer;
		color:#fe8832;
		}
		
	#pnum_info{
	color:#5c5c5c;	
	transition: all 0.5s ease;
	}	#pnum_info:hover{
		color:#5ecdf3;
		font-size:100px;
		cursor:pointer;
		}
	
	#pnum_primary{
	color:#5c5c5c;	
	transition: all 0.5s ease;
	}	#pnum_primary:hover{
		color:#85CE36;
		font-size:100px;
		cursor:pointer;
		}
	
	#psub{
		font-size:17px; 
		color:#bcbcbc;
		text-align:center;
		margin-top: 6px;
		padding: 0;
		line-height:20px;
	}
	
	#bc {
		color:white;
	}
	
	#bc:hover { 
		color:#85CE36;
	}
	
	#welcome{
		position:relative;
		top:-110px;
		color:white;
		left:40px;
		font-family:Existence-Light;
		
	}
	.h1{
		font-size:100%;
	}
	
	@font-face {
		font-family: Existence-Light;
		src: url(fonts/Roboto-Thin.ttf);
	}
	
	
	
	#notifcard{
		-webkit-box-shadow: 0px 1px 5px 0px rgba(50, 50, 50, 0.58);
-moz-box-shadow:    0px 1px 5px 0px rgba(50, 50, 50, 0.58);
box-shadow:         0px 1px 5px 0px rgba(50, 50, 50, 0.58);
		width:87%;
		left:15px;
	}
	
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
		box-shadow: 0px 9px 24px 0px rgba(0,0,0,0.75);
	}
</style>
    
    
     
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.min.js"></script>
    
    
    

<script type="text/javascript">















</script>

</head>

<jsp:include page="sidebar.jsp" />
<body>






    
     <div class="main-wrapper" style="z-index:1;">
            <div class="app" id="app">
				   
              
				
				<div class="container">
	<video poster="assets/banner.jpg" id="bgvid"  playsinline autoplay muted loop>
  <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->

<source src="assets/vid.mp4" type="video/mp4">
</video>



</div>
          
		<br><br>
                <article class="content dashboard-page" >
                    <section class="section" style="position: relative; top:-130px;">
                      
					 <div class="title-block">
                        <h6 class="title" style="float:left;">
							Edit News
						</h6>
					 </div>
					
			

                        
                  
    
 <div id="sample">
 <script type="text/javascript" src="js/nicEdit.js"></script>
     
    <script type="text/javascript">
//<![CDATA[
  bkLib.onDomLoaded(function() {
    
       new nicEditor({buttonList : ['bold','italic','underline','strikeThrough','link']}).panelInstance('newsBody');

  });
  //]]>
  </script>
  
  
  
  

													
  
  <form method="post" action="EditNews">
    <c:set var="news" scope="session" value="${News}"/>
  <label>News Title: </label>&nbsp;&nbsp;<input id="newsTitle" name="title" value="<c:out value="${news.getTitle()}"/>"><br><br>
  <label>News Content: </label><br>
  <textarea rows="25" cols="200" id="newsBody" name="content">
<c:out value="${news.getContent()}"/>
</textarea>
 <br>
<label>News Image (Optional): </label>   &nbsp;&nbsp;  
    
     
    <input type="file"><br><br>
     
     <button onclick="printText();" type="submit" value="Submit">Update News</button>
  
                        

                        
    <!-- <input type="button" id="button" value="Submit"/> -->
  
  
  </form>
      
     
</div>    
</section></article></div></div>

	



</body>

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



    <script>
    
    function printText(){
        
     var nicE = new nicEditors.findEditor('newsBody');
     var x = nicE.getContent();
        
        alert(x);
    }
    
    </script>



</html>