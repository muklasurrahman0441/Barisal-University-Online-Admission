<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/admission/controller"  method="post">


Clear Dtabase for new year : >> 
<input type="submit" name="submit" value="clearseatplan">

</form>
<hr>


Set All Values  zero ( 0 )<br><br>

<div>
<form method="post" action="/admission/controller" enctype="multipart/form-data">

 <table>
 
       <tr> 
	            <td>  Name : </td>  
	            <td>   <input type="text" name="name" required/>  </td>
         </tr>                   
	   <tr> 
	            <td>  Contact mobile : </td>  
	            <td>   <input type="number" name="mobile" required/>  </td>
       </tr> 
            
       <tr>        
         <td>Quota : </td>
        <td> 
        <input type="text" name="quota" required/>
		       
	     </td>	
       </tr>     
         
        <tr> 
        
         <td>Apply Unit : </td>
        <td> <input type="text" name="unit" required/>
		      
	     </td>	
       </tr> 
       
       <tr><td> <h2>SSC information </h2></td></tr>
       
        <tr> 
	             <td>  Roll : </td>  
	            <td>   <input type="number" name="sscroll" required/>  </td>
         </tr>    
          <tr> 
	             <td>  Registration no : </td>  
	            <td>   <input type="number" name="sscreg" required/>  </td>
         </tr>                 
	   <tr> 
	            <td>  Passing year : </td>  
	            <td>   <input type="number" name="sscyear" required/>  </td>
       </tr>  
       
        <tr> 
	            <td>  G.P.A : </td>  
	            <td>   <input type="number" name="sscgpa" placeholder="0.0" step="0.01" min="0" max="5" required/>  </td>
       </tr>      
      
       <tr>       
         <td>Group : </td>
        <td> <input type="text" name="sscgroup" required/>
		       
	     </td>		     
       </tr>      
       
             <tr>       
         <td>Board : </td>
        <td>  <input type="text" name="sscboard" required/>
		       
	     </td>		     
       </tr>   
       
       
          <tr><td> <h2>HSC information </h2></td></tr>
          <tr> 
	             <td>  Roll : </td>  
	            <td>   <input type="number" name="hscroll" required/>  </td>
         </tr>   
         
          <tr> 
	             <td>  Registration no : </td>  
	            <td>   <input type="number" name="hscreg" required/>  </td>
         </tr>   
                         
	   <tr> 
	            <td>  Passing year : </td>  
	            <td>   <input type="number" name="hscyear" required/>  </td>
       </tr>  
       
        <tr> 
	            <td>  G.P.A : </td>  
	            <td>   <input type="number" name="hscgpa" placeholder="0.0" step="0.01" min="0" max="5" required/>  </td>
       </tr>      
      
       <tr>       
         <td>Group : </td>
        <td> <input type="text" name="hscgroup" required/>
		      
	     </td>		     
       </tr>      
       
             <tr>       
         <td>Board : </td>
        <td> <input type="text" name="hscboard" required/>
		       
	     </td>		     
       </tr>  
       
         <tr> 
	            <td>  Payment Status : </td>  
	            <td>   <input type="hidden" name="payment" value="NO" readonly/> NO </td>
         </tr>  
       
        <tr> 
	            <td> <input type="file" name="image"> </td>  
	          
         </tr> 
       
        <tr> 
	            <td>  Exam Roll : </td>  
	            <td>   <input type="text" name="roll" /> NO </td>
	            
	       </tr> 
	        <tr>       
	           <td> <input type="submit" name="submit" value="superupload">  </td>
         </tr>
 
 </table>
 



</form>
</div>


<h2>${success}</h2>
<a href="/admission/controller?submit=unitview">click to view </a>

</body>
</html>