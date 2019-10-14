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
        if(validateName(employeeName)){
            document.getElementById("employeeName").style.display="none";
            document.getElementById("employeeGender").style.display="block";
            document.getElementById("labelforgender").innerHTML= "Hello "+employeeName+", Select Your Gender";
        }else{
            document.getElementById("inputname").style.border = "2px solid #ffd11a";
            document.getElementById("inputname").innerHTML="";
        }
    }
}
function registergender(gender){
    employeeGender = gender;
    document.getElementById("employeeGender").style.display="none";
    document.getElementById("employeeEmail").style.display="block";
}
function registeremail(){
    employeeEmail = document.getElementById("inputemail").value;
    document.getElementById("employeeEmail").style.display="none";
    document.getElementById("employeeID").style.display="block";
}
function registeremployeeid(){
    employeeID = document.getElementById("inputemployeeid").value;
    document.getElementById("employeeID").style.display="none";
    document.getElementById("employeePassword").style.display="block";
}
function registerpassword(){
    employeePassword = document.getElementById("inputpassword").value;
    document.getElementById("employeePassword").style.display="none";
    document.getElementById("employeeConfirmPassword").style.display="block";
}
function registerconfirmpassword(){
    employeeConfirmPassword = document.getElementById("inputconfirmpassword").value;
    document.getElementById("employeeConfirmPassword").style.display="none";
    document.getElementById("employeeContact").style.display="block";
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
// validation
function validateName(name){
    var validName =  /^[a-zA-Z ]{2,30}$/;
    return validName.test(name);
}