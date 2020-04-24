function  validate(frm){
	      alert("Client side form validations");
    	 //empty error messages
    	 document.getElementById("pnameErr").innerHTML="";
    	 document.getElementById("pageErr").innerHTML="";
    	 //read form data
    	 var name=frm.pname.value;
    	 var  age=frm.page.value;
    	 
    	 //write client side form validation logic
    	 if(name==""){
    		document.getElementById("pnameErr").innerHTML="<b>person name is required</b>";
    		 frm.pname.focus();
    		 return false;
    	 }
    	 if(age==""){
    		 document.getElementById("pageErr").innerHTML="<b>person age is required</b>";
    		 frm.page.focus();
    		 return false;
    	 }
    	 else if(isNaN(age)){
    		 document.getElementById("pageErr").innerHTML="<b>person age must be numeric value</b>";
    		 frm.page.focus();
    		 return false;
    	 }
    	 else if(age<=0 || age>125) {
    		 document.getElementById("pageErr").innerHTML="<b>person age must be in the range of 1 through 125</b>";
    		 frm.page.focus();
    		 return false;
    	 }
    	 //chage "vflag" hidden box value to "yes" indicating that client side
    	 //form validations are done
    	 frm.vflag.value="yes";
    	 return true;
     }//validate(-)
