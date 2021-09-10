<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 


<style>

.header
{
left:0;
width:100%;
height100px;
background-color:rgb(248, 255, 245);
text-align:center;
padding:10px;
margin-bottom:10px;
}

.display
{

display:block;

}

.table1
{

width:50%;
margin-left:25%;
margin-bottom:20px;
padding:10px;
background:lightgray;
}


 th, td { 
                padding: 5px; 
                background-color:none; 
            } 

</style>



</head>
<body>

 <div class="header">
  <h2>Update Your Information</h2>
  <p class="text-danger">You can Only update your information only single time .</p>
  </div>


<div class="display">


<form method="post" action="/admission/controller" enctype="multipart/form-data">

 <c:forEach var="product" items="${product}">	

<table class="table1">
 
   <tr class="p-3 mb-2 bg-secondary text-white" align="left">  <td colspan="6" > General Information </td> <td></td>  </tr>
 
       <tr> 
	            <td> Applicant's Name : </td>  
	            <td>   <input type="text" name="name" class="form-control" value="${product.name}" required/>  </td>
         </tr>   
         
          <tr> 
	            <td> Father's Name : </td>  
	            <td>   <input type="text" name="fathername" class="form-control" value="${product.fathername}" required/>  </td>
         </tr>  
         
          <tr> 
	            <td> Mother's Name : </td>  
	            <td>   <input type="text" name="mothername" class="form-control" value="${product.mothername}" required/>  </td>
         </tr>  
         
          <tr> 
	            <td> Date of Birth : </td>  
	            <td>   <input type="date" name="dateofbirth" class="form-control" value="${product.dateofbirth}" required/>  </td>
         </tr>  
         
         
                         
	   <tr> 
	            <td>  Contact mobile : </td>  
	            <td>   <input type="number" name="mobile" maxlength="11" class="form-control" value="${product.mobile}" required/>  </td>
       </tr> 
            
       <tr>        
         <td> Quota :   <input type="text" name="name" value="${product.quota}" readonly  class="text-danger" /> </td>
        <td>  
		        <select name="quota"  class="form-control" required>
					    <option value="general">general</option>
					    <option value="freedom fighter">freedom fighter</option>
					    <option value="tribal">tribal</option>			  
			    </select>
	     </td>	
       </tr>     
         
        <tr> 
        
         <td>Apply Unit :  <input type="text" name="name" value="${product.unit}" readonly  class="text-danger" />  </td>
        <td> 
		        <select name="unit" class="form-control" required>
					    <option value="KA">KA</option>
					    <option value="KHA">KHA</option>
					    <option value="GA">GA</option>			  
			    </select>
	     </td>	
       </tr> 
       
 </table>




<!--  


<table  class="table table-primary text-left table-hover">
 
 

      
      
        <tr> 
	            <td>  Name : </td>  
	            <td>   <input type="text" name="name" value="${product.name}"  />  </td>
         </tr>       
         
            <tr> 
	            <td> Father Name : </td>  
	            <td>   <input type="text" name="fathername" value="${product.fathername}"  />  </td>
         </tr>  
            <tr> 
	            <td> Mother Name : </td>  
	            <td>   <input type="text" name="mothername" value="${product.mothername}"  />  </td>
         </tr>  
         
            <tr> 
	            <td>  Date Of Birth : </td>  
	            <td>   <input type="date" name="dateofbirth" value="${product.dateofbirth}"  />  </td>
         </tr>              
	   <tr> 
	            <td>  Contact mobile : </td>  
	            <td>   <input type="number" name="mobile"  value="${product.mobile}"/>  </td>
       </tr> 
            
       <tr>        
         <td>Quota : </td>
        <td> 
		        <select name="quota" required>
					    <option value="general">general</option>
					    <option value="fr">fr</option>
					    <option value="tribal">tribal</option>			  
			    </select>
	     </td>	
       </tr>     
         
        <tr> 
        
         <td>Apply Unit : </td>
        <td> 
		        <select name="unit" required>
					    <option value="a">a</option>
					    <option value="b">b</option>
					    <option value="c">c</option>			  
			    </select>
	     </td>	
       </tr>
       
       --> 
       
        <table class="table1">      
       
     <tr class="p-3 mb-2 bg-secondary text-white" align="left">  <td colspan="6" > SSC information </td> <td></td>  </tr>
       
      <tr>       
      <td>  Roll No  </td>
      <td>   <input type="number" name="sscroll" class="form-control"  value="${product.sscroll}" required/>  </td>	
       
      <td>  Registration No  </td>
      <td>   <input type="number" name="sscreg" class="form-control" value="${product.sscreg}"  required/>  </td>
      </tr>
        
      <tr>        
      <td>  Passing year  </td>  
       <td>   <input type="number" name="sscyear" class="form-control" value="${product.sscyear}" required/>  </td>
      <td>  G.P.A  </td>
       <td>   <input type="number" name="sscgpa" placeholder="0.0" step="0.01" min="0" max="5" class="form-control" value="${product.sscgpa}" required/>  </td>  
      </tr>
       
       <tr>
      <td>Group :  <input type="text" name="name" value="${product.sscgroup}" readonly  class="text-danger"   />  </td>
       <td> 
		        <select name="sscgroup" class="form-control" required>
					    <option value="science">Science</option>
					    <option value="arts">Arts</option>
					    <option value="commerce">Commerce</option>			  
			    </select>
	     </td>		
      <td>Board : <input type="text" name="name" value="${product.sscboard}" readonly  class=" text-danger" /> </td>
        <td> 
		        <select name="sscboard" class="form-control" required>
					    <option value="barishal">Barishal</option>
					    <option value="dinajpur">Dinajpur</option>
					    <option value="chittagong">Chittagong</option>			    
					    <option value="comilla">Comilla</option>
					    <option value="dhaka">Dhaka</option>
					    <option value="rajshahi">Rajshahi</option>				    
					    <option value="jessore">Jessore</option>
					    <option value="madrasah">Madrasah</option>			   
			    </select>
	     </td>		   
       </tr>      
       
       
     
 </table>
       
       
     <!--   
       
       
       <tr><td class="text-danger"> <b> SSC information  </b></td> <td></td></tr>
       
        <tr> 
	             <td>  Roll : </td>  
	            <td>   <input type="number" name="sscroll"  value="${product.sscroll}" />  </td>
         </tr>    
          <tr> 
	             <td>  Registration no : </td>  
	            <td>   <input type="number" name="sscreg" value="${product.sscreg}"   />  </td>
         </tr>                 
	   <tr> 
	            <td>  Passing year : </td>  
	            <td>   <input type="number" name="sscyear" value="${product.sscyear}" />  </td>
       </tr>  
       
        <tr> 
	            <td>  G.P.A : </td>  
	            <td>   <input type="number" name="sscgpa" placeholder="0.0" step="0.01" min="0" max="5" value="${product.sscgpa}" />  </td>
       </tr>      
      
       <tr>       
         <td>Group : </td>
        <td> 
		        <select name="sscgroup">
					    <option value="science">Science</option>
					    <option value="arts">Arts</option>
					    <option value="commerce">Commerce</option>			  
			    </select>
	     </td>		     
       </tr>      
       
             <tr>       
         <td>Board : </td>
        <td> 
		        <select name="sscboard" >
					    <option value="barishal">Barishal</option>
					    <option value="dinajpur">Dinajpur</option>
					    <option value="chittagong">Chittagong</option>			    
					    <option value="comilla">Comilla</option>
					    <option value="dhaka">Dhaka</option>
					    <option value="rajshahi">Rajshahi</option>				    
					    <option value="jessore">Jessore</option>
					    <option value="madrasah">Madrasah</option>			   
			    </select>
	     </td>		     
       </tr>   
       
       -->
       
       
        <table class="table1">          
       
       
            <tr class="p-3 mb-2 bg-secondary text-white" align="left">   <td colspan="6" > HSC information </td> <td></td>  </tr>
       
      <tr>       
     <td>  Roll No  </td>
       <td>   <input type="number" name="hscroll" class="form-control" value="${product.hscroll}" required/>  </td>
     <td>  Registration No  </td>      
        <td>   <input type="number" name="hscreg" class="form-control" value="${product.hscreg}" required/>  </td>	  
      </tr>
      
      <tr>
      <td>  Passing year  </td>  
         <td>   <input type="number" name="hscyear" class="form-control" value="${product.hscyear}" required/>  </td>
      <td>  G.P.A  </td> 
        <td>   <input type="number" name="hscgpa" placeholder="0.0" step="0.01" min="0" max="5" class="form-control" value="${product.hscgpa}"  required/>  </td>
      
      </tr>
      <tr>
      <td>Group :<input type="text" name="name" value="${product.hscgroup}" readonly  class="text-danger" /> </td>
      
        <td> 
		        <select name="hscgroup" class="form-control" required>
					    <option value="science">Science</option>
					    <option value="arts">Arts</option>
					    <option value="commerce">Commerce</option>			  
			    </select>
	     </td>	
      <td>Board : <input type="text" name="name" value="${product.hscboard}" readonly  class="text-danger" /> </td>
       <td> 
		        <select name="hscboard" class="form-control" required>
					    <option value="barishal">Barishal</option>
					    <option value="dinajpur">Dinajpur</option>
					    <option value="chittagong">Chittagong</option>			    
					    <option value="comilla">Comilla</option>
					    <option value="dhaka">Dhaka</option>
					    <option value="rajshahi">Rajshahi</option>				    
					    <option value="jessore">Jessore</option>
					    <option value="madrasah">Madrasah</option>			   
			    </select>
	     </td>		     
       </tr>      



       
       
 </table>
       
       
       <!-- 
       
       
          <tr><td class="text-danger"> <b> HSC information </b> </td> <td></td></tr>
          <tr> 
	             <td>  Roll : </td>  
	            <td>   <input type="number" name="hscroll" value="${product.hscroll}" />  </td>
         </tr>   
         
          <tr> 
	             <td>  Registration no : </td>  
	            <td>   <input type="number" name="hscreg" value="${product.hscreg}"   />  </td>
         </tr>   
                         
	   <tr> 
	            <td>  Passing year : </td>  
	            <td>   <input type="number" name="hscyear" value="${product.hscyear}" />  </td>
       </tr>  
       
        <tr> 
	            <td>  G.P.A : </td>  
	            <td>   <input type="number" name="hscgpa" placeholder="0.0" step="0.01" min="0" max="5" value="${product.hscgpa}"   />  </td>
       </tr>      
      
       <tr>       
         <td>Group : </td>
        <td> 
		        <select name="hscgroup" >
					    <option value="science">Science</option>
					    <option value="arts">Arts</option>
					    <option value="commerce">Commerce</option>			  
			    </select>
	     </td>		     
       </tr>      
       
             <tr>       
         <td>Board : </td>
        <td> 
		        <select name="hscboard" >
					    <option value="barishal">Barishal</option>
					    <option value="dinajpur">Dinajpur</option>
					    <option value="chittagong">Chittagong</option>			    
					    <option value="comilla">Comilla</option>
					    <option value="dhaka">Dhaka</option>
					    <option value="rajshahi">Rajshahi</option>				    
					    <option value="jessore">Jessore</option>
					    <option value="madrasah">Madrasah</option>			   
			    </select>
	     </td>		     
       </tr>  
       
       
        -->
        
        
         <table class="table1">      
       
           <tr> 
	            <td>  Payment Status : </td>  
	            <td>   <input type="hidden" name="payment" value="NO" readonly/> NO </td>
         </tr>  
   
              <tr> 
	            <td>  Exam Roll : </td>  
	            <td>   <input  type="text" name="roll" value="${product.roll}" readonly /> </td>
	            
	       </tr> 
	       

       
          <tr> 
	            <td> Registration Date : </td>  
	            <td>   <input  type="text" name="roll" value="${product.date}" readonly /> </td>
	            
	       </tr> 
	       
	        <tr> <td></td>      
	           <td> 
	           <button type="submit" name="submit" value="Update_Info">Update</button>
	     
	           </td>
         </tr>
       
 
 </table>
        
       <!-- 
        
         <tr> 
	            <td>  Payment Status : </td>  
	            <td>   <input type="hidden" name="payment" value="NO" readonly/> NO </td>
         </tr>  
       
  
        <tr> 
	            <td>  Exam Roll : </td>  
	            <td>   <input  type="text" name="roll" value="${product.roll}" readonly /> </td>
	            
	       </tr> 
	       
	         <tr> 
	            <td> Registration Date : </td>  
	            <td>   <input  type="text" name="roll" value="${product.date}" readonly /> </td>
	            
	       </tr> 
	       
	        --> 
	       
	       
 
 </c:forEach>
 
 <!-- 
 </table>
 
 -->


</form>




</body>
</html>