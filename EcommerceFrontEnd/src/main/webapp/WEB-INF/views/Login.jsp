<%@include file="Header.jsp"%>
<h2>Login Page </h2>
<div class="container">
        <div class="row">
			<div class="col-md-5 mx-auto">
			<div id="first">
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Login</h1>
						 </div>
					</div>
					
					
					<form action="perform_login" method="post" name="login">
					        <div class="form-group">
					           <label for="exampleInputUsername1">User Name</label>
					           <input type="text" class="form-control" id="exampleInputUsername1" name="username" placeholder="Enter username" pattern="[a-zA-Z0-9_]+">
					        </div>
					        
					        <div class="form-group">
					           <label for="exampleInputEmail1">Password</label><input
					            type="password" name="password" id="password"  
					           class="form-control" aria-describedby="emailHelp"
					            placeholder="Enter Password">
					        </div>
					        
					        <div class="form-group">
					           <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
					        </div>
					        
					        <div class="col-md-12 text-center ">
					           <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
					        </div>
					            
					        <div class="form-group">
						           <p class="text-center">Don't have account? <a href="<c:url value="/register"/>">Sign up here</a></p>
						        </div>
					</form>
					</div>              
	               </div>
               </div>
          </div>
        </div>
			  <!-- <div id="second">
			      <div class="myform form ">
                        <div class="logo mb-3">
                           <div class="col-md-12 text-center">
                              <h1 >Signup</h1>
                           </div>
                        </div>
                        <form action="#" name="registration">
                           <div class="form-group">
                              <label for="exampleInputEmail1">First Name</label>
                              <input type="text"  name="firstname" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Enter Firstname">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Last Name</label>
                              <input type="text"  name="lastname" class="form-control" id="lastname" aria-describedby="emailHelp" placeholder="Enter Lastname">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Email address</label>
                              <input type="email" name="email"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Password</label>
                              <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                           <div class="col-md-12 text-center mb-3">
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Get Started For Free</button>
                           </div>
                           <div class="col-md-12 ">
                              <div class="form-group">
                                 <p class="text-center"><a href="#" id="signin">Already have an account?</a></p>
                              </div>
                           </div>
                            </div>
                        </form>
                     </div>
			</div>
		</div>
      </div>    -->
         
</body>