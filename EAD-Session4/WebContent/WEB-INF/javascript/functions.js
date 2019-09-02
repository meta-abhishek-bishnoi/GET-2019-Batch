function getAmount(){
    var dailyRent = 0;
    var monthlyRent = 0;
    var yearlyRent = 0;
    var type = document.getElementById("type").value;
    //document.getElementById("vehical").innerHTML = type;
    if("byCycle" == type){
        //document.getElementById("vehical").innerHTML = "By Cycle";
        dailyRent = 0.070;
        monthlyRent = 1.40;
        yearlyRent = 6.99;
    }
    if("motorCycle" == type){
        //document.getElementById("vehical").innerHTML = "Motor Cycle";
        dailyRent = 0.14;
        monthlyRent = 2.79;
        yearlyRent = 13.97;
    }
    if("fourWheeler" == type){
        //document.getElementById("vehical").innerHTML = "Four Wheeler";
        dailyRent = 0.28;
        monthlyRent = 6.99;
        yearlyRent = 48.91;
    }
    document.getElementById("plan").innerHTML = '<option value="'+dailyRent+'">'+dailyRent+' USD Daily</option>'+
            '<option value="'+monthlyRent+'">'+monthlyRent+' USD Monthly</option>'+
            '<option value="'+yearlyRent+'">'+yearlyRent+' USD Yearly</option>';
}

function changeAmount(){
    var type = document.getElementById("currencyType").value;
    var amount = document.getElementById("plan").value;
    var convertedAmount;
    if("inr" == type){
        convertedAmount = parseFloat(amount)* 71.50;
    }
    if("yen" == type){
        convertedAmount = parseFloat(amount) / 106.42;
    }
    document.getElementById("converted").innerHTML = "your Amount In "+ type.toUpperCase()
    +" is "+convertedAmount;
}
