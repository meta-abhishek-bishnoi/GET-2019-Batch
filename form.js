/* This function is working on Validating employee registartion form
*/
function register(){
    var isValid = true;
    resetRegisterElementColor();
    var name = document.getElementById("name").value;
    // validating name's format
    if(!validateName(name)){
        document.getElementById("name").style.borderColor = 'red';
        document.getElementById("errorname").innerHTML = "Invalid Name";
        isValid = false;
    }
    // validating email format
    var email = document.getElementById("email").value;
    if(!validateEmail(email)){
        document.getElementById("email").style.borderColor = 'red';
        document.getElementById("erroremail").innerHTML = "Invalid Email";
        isValid = false;
    }
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirm".value);
    // validating passwords
    if(!validatePassword(password,confirmPassword)){
        document.getElementById("password").style.borderColor = 'red';
        document.getElementById("confirm").style.borderColor = 'red';
        document.getElementById("errorpassword").innerHTML = "Password Mismatch<br> Invalid Password Format <br>Password must >= 8 <br>password must be alpha numeric<br> it must at least apecial character";
        isValid = false;
    }
    // validating password
    if(isValid){
        document.getElementById("register").innerHTML = "";
        document.getElementById("message").innerHTML = "You Are Registerd Sucessfully, Your Registration Id meta-0001";
        document.getElementById("message").style.color = "#90ee90";
        document.getElementById("employeeName").value = name;
        document.getElementById("employeeName").disabled = true;
    }
}
// checking name validation
function validateName(name){
    var validName =  /^[a-zA-Z ]{2,30}$/;
    return validName.test(name);
}
// checking email validation
function validateEmail(email) {
    var validMAilExpression = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email.length<6 && email.length > 250){
        return false;
    }
    return validMAilExpression.test(String(email).toLowerCase());
}
// checking password validation
function validatePassword(password,confirmPassword){
    var validPassword =  new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    if(password.localeCompare(confirmPassword)>=1){
        return false;
    }
    return validPassword.test(password);
}
// resetting all error values, so we can get only occured errors on resubmit
function resetRegisterElementColor(){
    document.getElementById("name").style.borderColor = '';
    document.getElementById("errorname").innerHTML = "";
    document.getElementById("email").style.borderColor = '';
    document.getElementById("erroremail").innerHTML = "";
    document.getElementById("password").style.borderColor = '';
    document.getElementById("confirm").style.borderColor = '';
    document.getElementById("errorpassword").innerHTML = "";
}

/**
*/
function addVehical(){
    var isValid = true;
    resetVehicalElements();
    var employeeName = document.getElementById("employeeName").value;
    if(employeeName==""){
        document.getElementById("employeeName").style.borderColor = "red";
        isValid = false;
    }
    var number = document.getElementById("number").value;
    if(number==""){
        document.getElementById("number").style.borderColor = 'red';
        isValid = false;
    }
    var employeeId = document.getElementById("employeeId").value;
    if(employeeId==""){
        document.getElementById("employeeId").style.borderColor = 'red';
        isValid = false;
    }
    var dailyRent = 0;
    var monthlyRent = 0;
    var yearlyRent = 0;
    var type = document.getElementById("type").value;
    //document.getElementById("vehical").innerHTML = type;
    if("byCycle" == type){
        //document.getElementById("vehical").innerHTML = "By Cycle";
        dailyRent = 5;
        monthlyRent = 100;
        yearlyRent = 500;
    }
    if("motorCycle" == type){
        //document.getElementById("vehical").innerHTML = "Motor Cycle";
        dailyRent = 10;
        monthlyRent = 200;
        yearlyRent = 1000;
    }
    if("fourWheeler" == type){
        //document.getElementById("vehical").innerHTML = "Four Wheeler";
        dailyRent = 20;
        monthlyRent = 500;
        yearlyRent = 3500;
    }

    if(isValid){
        document.getElementById("message").innerHTML = "";
        document.getElementById("vehical").innerHTML = "";
        document.getElementById("price").innerHTML = '<form>'+'<table>'+'<tr>'+
            '<td><label for = "plan"> Select Plan (Amount in INR)</label></td>'+
            '<td>'+
            '<select id="plan" name="plan" class="select">'+
            '<option value="'+dailyRent+'">'+dailyRent+' INR Daily</option>'+
            '<option value="'+monthlyRent+'">'+monthlyRent+' INR Monthly</option>'+
            '<option value="'+yearlyRent+'">'+yearlyRent+' INR Yearly</option>'+
            '</select>'+
            '</td>'+'</tr>'+'<tr>'+'<td></td>'+
            '<td><input type="button" value="selectPlan" onclick="selectPlan()"></td>'+
            '</tr>'+'</table>'+'</form>';
    }
}
 function resetVehicalElements(){
    document.getElementById("employeeName").style.borderColor = "";
    document.getElementById("number").style.borderColor = "";
    document.getElementById("employeeId").style.borderColor = 'red';
 }

 function selectPlan(){
    var amountINR = document.getElementById("plan").value;
    document.getElementById("price").innerHTML = 'Your Bill Amount is  '+amountINR+ ' INR only <br>'+
    'Convert Your Bill Amount To : <br><select id="currencyType" name = "currencyType" onchange="convertCurrency('+amountINR+')" class="selectsmall">'+
    '<option value="usd">USD</option>'+
    '<option value="yen">YEN</option>'+    
    '</select>'+
    ' <input type="text" name="currency" id="currency">';
    document.getElementById("currency").disabled = true;
    document.getElementById("currency").value = amountINR / 71.50;

 }

 function convertCurrency(amountINR){
    var type = document.getElementById("currencyType").value;
    var convertedAmount;
    if("usd" == type){
        convertedAmount = parseFloat(amountINR)/ 71.50;
    }
    if("yen" == type){
        convertedAmount = parseFloat(amountINR) / 0.68;
    }
    document.getElementById("currency").value = convertedAmount;
 }