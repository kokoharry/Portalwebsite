<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Form</title>
        <!-- CSS -->
        <!--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">-->
        <link rel="stylesheet" href="/static/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/static/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/static/assets/css/form-elements.css">
        <link rel="stylesheet" href="/static/assets/css/style.css">
        <script src="/static/js/jquery-1.11.1.min.js"></script>
        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="/static/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/static/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <script type="text/javascript">

    </script>
    <body>
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>Kokoharry Private Site Login Form</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Login to kokoharry's site</h3>
                            		<p><a href="#">Register</a> OR enter your information to log on:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form"  action="/login/login" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="userName">Username</label>
			                        	<input type="text" name="userName" placeholder="Username..." class="form-username form-control" id="userName">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password">
			                        </div>
                                    <#if resultMsg != null && resultMsg != ''>
                                        <div id="alrmLabel" class="form-group" style="text-align:center;">
                                            <label style="color: red ">${resultMsg}</label>
                                        </div>
                                    </#if>
                                    <button class="btn">Login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Javascript -->
        <script src="/static/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/assets/js/jquery.backstretch.min.js"></script>
        <script src="/static/assets/js/scripts.js"></script>
        <!--[if lt IE 10]>
            <script src="/static/assets/js/placeholder.js"></script>
        <![endif]-->
    </body>
</html>