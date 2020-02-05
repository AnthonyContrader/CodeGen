
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for Admin ">
<meta name="author" content="Vittorio Valent">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>

<body>
	<%@include file="css/header.jsp"%>




	

<div class="main" >
<h1 style="color: #39A8E8;" >Welcome <b><u>${user.getUsername()}</u></b></h1>
</div>
<div style="text-align:center; margin-bottom: -45px;margin-top: -5px;"> 
	<video style="margin-top:-3%;width:50%; height:auto;" align="center"  autoplay loop>
	  <source src="/images/intro.mp4" type="video/mp4">
	  Your browser does not support HTML5 video.
	</video>
</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>