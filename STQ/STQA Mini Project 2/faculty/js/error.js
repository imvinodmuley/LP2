
var x1=false,x2=false,x3=true,x4=false,x5=true,x6=false,x7=false,x8=false,x9=false,x10=false,x11=false,x12=false,x13=false,x14=false,x15=false,x16=false,x17=false,x18=false;

$(document).ready(function(){
  $('#fname').on('focusout', function(){
        if($('#fname').val() != ""){
           if(validateFname($('#fname').val())){
            $('.error').fadeOut('slow');
            x1=true;
           }else{
              $('.error').text('Invalid First Name!!!');
              $('.error').fadeIn('slow');
              x1=false;
           }
        }else{
            $('.error').text('Required..!');
            $('.error').fadeIn("slow");
            x1=false;
        }
    });

    $('#lname').on('focusout', function(){
        if($('#lname').val() != ""){
           if(validateFname($('#lname').val())){
            $('.error1').fadeOut('slow');
            x2=true;
           }else{
              $('.error1').text('Invalid Last Name!!!');
              $('.error1').fadeIn('slow');
              x2=false;
           }
        }else{
            $('.error1').text('Required..!');
            $('.error1').fadeIn("slow");
            x2=false;
        }
    });

    $('#email').on('focusout', function(){
        if($('#email').val() != ""){
           if(validateEmail($('#email').val())){
            $('.error2').fadeOut('slow');
            
           }else{
              $('.error2').text('Invalid Email!!!');
              $('.error2').fadeIn('slow');
              
           }
        }else{
            $('.error2').text('Required..!');
            $('.error2').fadeIn("slow");
            
        }
    });

    $('#phone').on('focusout', function(){
        if($('#phone').val() != ""){
           if(validatePhone($('#phone').val())){
            $('.error3').fadeOut('slow');
            x4=true;
           }else{
              $('.error3').text('Invalid Phone!!!');
              $('.error3').fadeIn('slow');
              x4=false;
           }
        }else{
            $('.error3').text('Required..!');
            $('.error3').fadeIn("slow");
            x4=false;
        }
    });

    $('#dept').on('focusout', function(){
        if($('#dept').val() != ""){
           if(validateDept($('#dept').val())){
            $('.error4').fadeOut('slow');
            
           }else{
              // $('.error4').text('Invalid Department!!!');
              // $('.error4').fadeIn('slow');
           }
        }else{
            $('.error4').text('Required..!');
            $('.error4').fadeIn("slow");
            
        }
    });

    $('#des').on('focusout', function(){
        if($('#des').val() != ""){
           if(validateDept($('#des').val())){
            $('.error5').fadeOut('slow');
            x6=true;
           }else{
              $('.error5').text('Invalid Designation!!!');
              $('.error5').fadeIn('slow');
              x6=false;
           }
        }else{
            $('.error5').text('Required..!');
            $('.error5').fadeIn("slow");
            x6=false;
        }
    });

     $('#res').on('focusout', function(){
        if($('#res').val() != ""){
           if(validateDept($('#res').val())){
            $('.error6').fadeOut('slow');
            x7=true;
           }else{
              $('.error6').text('Invalid Responsibility!!!');
              $('.error6').fadeIn('slow');
              x7=false;
           }
        }else{
            $('.error6').text('Required..!');
            $('.error6').fadeIn("slow");
            x7=false;
        }
    });

     $('#yr').on('focusout', function(){
        if($('#yr').val() != ""){
           if(validateYr($('#yr').val())){
            $('.error7').fadeOut('slow');
            x8=true;
           }else{
              $('.error7').text('Invalid Year!!!');
              $('.error7').fadeIn('slow');
              x8=false;
           }
        }else{
            $('.error7').text('Required..!');
            $('.error7').fadeIn("slow");
            x8=false;
        }
    });

     $('#mon').on('focusout', function(){
        if($('#mon').val() != ""){
           if(validateMon($('#mon').val())){
            $('.error8').fadeOut('slow');
            x9=true;
           }else{
              $('.error8').text('Invalid Month!!!');
              $('.error8').fadeIn('slow');
              x9=false;
           }
        }else{
            $('.error8').text('Required..!');
            $('.error8').fadeIn("slow");
            x9=false;
        }
    });

     $('#yr1').on('focusout', function(){
        if($('#yr1').val() != ""){
           if(validateYr1($('#yr1').val())){
            $('.error9').fadeOut('slow');
            x10=true;
           }else{
              $('.error9').text('Invalid Year!!!');
              $('.error9').fadeIn('slow');
              x10=false;
           }
        }else{
            $('.error9').text('Required..!');
            $('.error9').fadeIn("slow");
            x10=false;
        }
    });

    $('#mon1').on('focusout', function(){
        if($('#mon1').val() != ""){
           if(validateMon($('#mon1').val())){
            $('.error10').fadeOut('slow');
            x11=true;
           }else{
              $('.error10').text('Invalid Month!!!');
              $('.error10').fadeIn('slow');
              x11=false;
           }
        }else{
            $('.error10').text('Required..!');
            $('.error10').fadeIn("slow");
            x11=false;
        }
    });

    $('#aoi').on('focusout', function(){
        if($('#aoi').val() != ""){
           if(validateFname($('#aoi').val())){
            $('.error11').fadeOut('slow');
            x12=true;
           }else{
              $('.error11').text('Invalid Area of Interest!!!');
              $('.error11').fadeIn('slow');
              x12=false;
           }
        }else{
            $('.error11').text('Required..!');
            $('.error11').fadeIn("slow");
            x12=false;
        }
    });


    $('#cntJornals').on('focusout', function(){
        if($('#cntJornals').val() != ""){
           if(validatenum($('#cntJornals').val())){
            $('.error12').fadeOut('slow');
            x14=1;
           }else{
              $('.error12').text('Invalid!!!');
              $('.error12').fadeIn('slow');
              x14=0;
           }
        }
    });

    $('#cntQuali').on('focusout', function(){
        if($('#cntQuali').val() != ""){
           if(validatenum($('#cntQuali').val())){
            $('.error13').fadeOut('slow');
            x15=1;
           }else{
              $('.error13').text('Invalid!!!');
              $('.error13').fadeIn('slow');
              x15=0;
           }
        }else{
            $('.error13').text('Required..!');
            $('.error13').fadeIn("slow");
            x15=0;
        }
    });

    $('#cntBooks').on('focusout', function(){
        if($('#cntBooks').val() != ""){
           if(validatenum($('#cntBooks').val())){
            $('.error14').fadeOut('slow');
            x16=1;
           }else{
              $('.error14').text('Invalid!!!');
              $('.error14').fadeIn('slow');
              x16=0;
           }
        }
    });

    $('#cntPatents').on('focusout', function(){
        if($('#cntPatents').val() != ""){
           if(validatenum($('#cntPatents').val())){
            $('.error15').fadeOut('slow');
            x17=1;
           }else{
              $('.error15').text('Invalid!!!');
              $('.error15').fadeIn('slow');
              x17=0;
           }
        }
    });

    $('#cntConf').on('focusout', function(){
        if($('#cntConf').val() != ""){
           if(validatenum($('#cntConf').val())){
            $('.error16').fadeOut('slow');
            x18=1;
           }else{
              $('.error16').text('Invalid !!!');
              $('.error16').fadeIn('slow');
              x18=0;
           }
        }
    });
});

function validateFname(eVal){
    var val= /^[A-Za-z\s]+$/;
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

function validateRecord(eVal){
  var num=/^(10|[0-9][0-9]?)$/;
    if(num.test(eVal)){
        return true;
    }else{
        return false;
    }
}

function validatenum(eVal){
  var num=/^(100|[0-9][0-9]?)$/;
    if(num.test(eVal)){
        return true;
    }else{
        return false;
    }  
}
