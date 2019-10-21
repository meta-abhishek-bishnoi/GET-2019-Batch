var employeeName;
var employeeGender;
var employeeEmail;
var employeeID;
var employeePassword;
var employeeConfirmPassword;
var employeeContact;
var vehicleModel;
var vehicleNumber;
var vehicleType;
function registername(){
    if (event.keyCode==13){
        employeeName = document.getElementById("inputname").value;
        document.getElementById("errormessage").innerHTML = "";
        if(validateName(employeeName)){
            document.getElementById("employeeName").style.display="none";
            document.getElementById("employeeGender").style.display="block";
            document.getElementById("labelforgender").innerHTML= "Hello "+employeeName+", Select Your Gender";
        }else{
            errorBorder("inputname");
            document.getElementById("inputname").innerHTML = employeeName;
            document.getElementById("errormessage").innerHTML = "Invalid Name Format";
        }
    }
}
function registergender(gender){
    employeeGender = gender;
    document.getElementById("employeeGender").style.display="none";
    document.getElementById("employeeEmail").style.display="block";
}
function registeremail(){
    if (event.keyCode==13){
        employeeEmail = document.getElementById("inputemail").value;
        document.getElementById("errormessage").innerHTML = "";
        if(validateEmail(employeeEmail)){
            document.getElementById("employeeEmail").style.display="none";
            document.getElementById("employeeID").style.display="block";
        }else{
            errorBorder("inputemail");
            document.getElementById("inputemail").innerHTML = employeeEmail;
            document.getElementById("errormessage").innerHTML = "Invalid Email";
        }
    }
}
function registeremployeeid(){
    employeeID = document.getElementById("inputemployeeid").value;
    document.getElementById("employeeID").style.display="none";
    document.getElementById("employeePassword").style.display="block";
}
function registerpassword(){
    employeePassword = document.getElementById("inputpassword").value;
    document.getElementById("errormessage").innerHTML = "";
    if(isSecurePassword(employeePassword)){
        document.getElementById("inputpassword").style.border = "none";
        document.getElementById("inputpassword").style.borderBottom = "2px solid #00995c";
        document.getElementById("errormessage").innerHTML = "Password Looks Fine You Can Go Ahead";
        document.getElementById("errormessage").style.color = "#00995c";
        if (event.keyCode==13){
            document.getElementById("errormessage").innerHTML = "";
            document.getElementById("employeePassword").style.display="none";
            document.getElementById("employeeConfirmPassword").style.display="block";
        }
    }else{
        errorBorder("inputpassword");
        document.getElementById("inputpassword").innerHTML = employeePassword;
        document.getElementById("errormessage").innerHTML = "Invalid Password Format <br>"+
        "Password must >= 8 <br>password must be alpha numeric<br>"+
        "It must have at least apecial character";
        document.getElementById("errormessage").style.color = "#ff6600";
    }
}
function registerconfirmpassword(){
    employeeConfirmPassword = document.getElementById("inputconfirmpassword").value;
    document.getElementById("errormessage").innerHTML = "";
    if(validateConfirmPassword(employeePassword, employeeConfirmPassword)){
        document.getElementById("inputconfirmpassword").style.border = "none";
        document.getElementById("inputconfirmpassword").style.borderBottom = "2px solid #00995c";
        document.getElementById("errormessage").innerHTML = "Hey "+employeeName+" You can go ahead";
        if (event.keyCode==13){
            document.getElementById("errormessage").innerHTML = "";
            document.getElementById("employeeConfirmPassword").style.display="none";
            document.getElementById("employeeContact").style.display="block"; 
        }
    }else{
            errorBorder("inputconfirmpassword");
            document.getElementById("inputconfirmpassword").innerHTML = employeeConfirmPassword;
            document.getElementById("errormessage").innerHTML = "Password Mismatch";
    }
}
function registercontact(){
    employeeContact = document.getElementById("inputcontact").value;
    document.getElementById("register").style.display="none";
    document.getElementById("vehicle").style.display="block";
    document.body.style.backgroundColor = "#ffe6e6";
}
function registerVehicleModel(){
    vehicleModel = document.getElementById("inputVehicleModel").value;
    document.getElementById("vehicleModel").style.display="none";
    document.getElementById("vehicleNumber").style.display="block";
}
function registerVehicleNumber(){
    vehicleNumber = document.getElementById("inputVehicleNumber").value;
    document.getElementById("vehicleNumber").style.display="none";
    document.getElementById("vehicleType").style.display="block";
}
function registertype(type){
    var dailyRent = 0;
    var monthlyRent = 0;
    var yearlyRent = 0;
    vehicleType = type;
    if("byCycle" === vehicleType){
        dailyRent = 0.070;
        monthlyRent = 1.40;
        yearlyRent = 6.99;
    }
    if("motorCycle" === vehicleType){
        dailyRent = 0.14;
        monthlyRent = 2.79;
        yearlyRent = 13.97;
    }
    if("fourWheeler" === vehicleType){
        dailyRent = 0.28;
        monthlyRent = 6.99;
        yearlyRent = 48.91;
    }
    document.getElementById("vehicleType").style.display="none";
    document.getElementById("selectPlan").style.display="block";
    document.getElementById('labelforplan').innerHTML="Your Plans are for "+vehicleType;
    document.getElementById("radioforplan").innerHTML='<input type="radio" id="inputplan" name="inputplan" value="'+dailyRent+'" onclick="registerplan();">'+dailyRent+' $'+
     '<input type="radio" id="inputplan" name="inputplan" value="'+monthlyRent+'" onclick="registerplan();">'+monthlyRent+' $'+
     '<input type="radio" id="inputplan" name="inputplan" value="'+yearlyRent+'" onclick="registerplan();">'+yearlyRent+' $';
}
function getit(){

}
//
function errorBorder(inputId){
    document.getElementById(inputId).style.border = "none";
    document.getElementById(inputId).style.borderBottom = "2px solid #ff6600";
}
// validation
function validateName(name){
    var validName =  /^[a-zA-Z ]{2,30}$/;
    return validName.test(name);
}
function validateEmail(email) {
    var validMAilExpression = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email.length<6 && email.length > 250){
        return false;
    }
    return validMAilExpression.test(String(email).toLowerCase());
}

function isSecurePassword(password){
    var validPassword =  new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return validPassword.test(password);
}
function validateConfirmPassword(password, confirmPassword){
    if(password.localeCompare(confirmPassword)>=1){
        return false;
    }else{
        return true;
    }
}