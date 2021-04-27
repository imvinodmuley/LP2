
var currentTab = 0;
var mycnt=0;
showTab(currentTab);

function showTab(n) {
	mycnt++;
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  fixStepIndicator(n)
}

function nextPrev(n) {
  var x = document.getElementsByClassName("tab");
  
  if (n == 1 && !validateForm()) return false;
  x[currentTab].style.display = "none";
  currentTab = currentTab + n;
  if (currentTab >= x.length) {
    document.getElementById("nextBtn").setAttribute("type", "submit");
    // document.getElementById("regForm").submit();
    return false;
  }
  showTab(currentTab);
}

function validateForm() {  
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  for (i = 0; i < y.length; i++) {
    if (y[i].value == "") {
      y[i].className += " invalid";
      valid = false;
    }
  }



  if(mycnt==1)
  {
  	
  if(x1 && x2  && x4 && x6 && x7 && x8 && x9 && x10 && x11 && x12)
  {
    valid=true;
  }
  else
  {
    var f=document.getElementById("fname").value;
    var f1=document.getElementById("lname").value;
    var f2=document.getElementById("email").value;
    var f3=document.getElementById("phone").value;
    var f4=document.getElementById("dept").value;
    var f5=document.getElementById("des").value;
    var f6=document.getElementById("res").value;
    var f7=document.getElementById("yr").value;
    var f8=document.getElementById("mon").value;
    var f9=document.getElementById("yr1").value;
    var f10=document.getElementById("mon1").value;
    var f11=document.getElementById("aoi").value;


    if(validateFname(f) && validateFname(f1) &&  validateEmail(f2) &&  validatePhone(f3) && validateDept(f5) && validateDept(f6) && validateYr(f7) && validateMon(f8) && validateYr(f9) && validateMon(f10) && validateDept(f11))
    {
      valid=true;
    }
    else
    {
      valid=false;
    }
    
    
  }

}

   if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; 
}

function fixStepIndicator(n) {
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  x[n].className += " active";
}

function checkBlank(selected_ind){
  var tabs = document.getElementsByClassName("tab");
  var inputs = tabs[0].getElementsByTagName("input");

  for(var i = 0; i < inputs.length; i++){
    if(inputs[i].value != ""){
      inputs[i].readOnly = true;
      inputs[i].setAttribute("style", "cursor: not-allowed");
    }
  }

  console.log(selected_ind);

  document.getElementById("dept")[selected_ind].selected = true;
}

function validateFname(eVal){
    var val= /^[A-Za-z\s]+$/;
    if( val.test(eVal)){
        return true;
    }else{
        return false;
    }
}

function validatePhone(eVal){
    var val= /^\d{10}$/;
    if( val.test(eVal)){
        return true;
    }else{
        return false;
    }
}

function validateDept(eVal){
    var val= /^[A-Za-z ]+$/;
    if( val.test(eVal)){
        return true;
    }else{
        return false;
    }
}

function validateEmail(eVal){
    var val = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if( val.test(eVal)){
        return true;
    }else{
        return false;
    }
}

function validateYr(eVal){
    var num=/^(100|[0-9][0-9]?)$/;
    if(num.test(eVal)){
        return true;
    }else{
        return false;
    }
}

function validateYr1(eVal){
    var num=/^(100|[0-9][0-9]?)$/;
    if(num.test(eVal)){
        return true;
    }else{
        return false;
    }
}


function validateMon(eVal){
  var num=/^(12|[0-9][0-9]?)$/;
    if(num.test(eVal)){
        return true;
    }else{
        return false;
    }
}

