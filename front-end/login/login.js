function redirect(user){
   
    sessionStorage.setItem("userInfo",JSON.stringify(user));
    var role=user.role;
   // var role=1;
    if(role==1){
        location.href='../employeePage/employee.html';
    }
    else{
        location.href='../managerPage/manager.html';
    }
}
/*
async function loginFun(e){
    console.log("Im here");
    e.preventDefault();
    let username=document.getElementById("userId").value;
    let password=document.getElementById("passwordId").value;

    const credentials={
        username,
        password
    };
    try{
        console.log("inside fun");
        let res= await fetch("http://localhost:8080/empreimb/login",{
            mode: 'no-cors',
         method:'POST',
         body:JSON.stringify(credentials),
         headers:{
             "Content-Type":"application/json"
         }   
        });
        let user= await res.JSON();
        redirect(user);
    }
    catch(e){
        alert("User does not exist");
        location.href='./login.html';
        console.log(e);
    }
  //  if(username=='aharris'&&password=='12345'){
    //    location.href='../employeePage/employee.html';
   // }
}*/
function loadDoc(){
    console.log("First inside");
    var xhttp=new XMLHttpRequest();
    xhttp.onreadystatechange=function(){
        console.log("Second inside");
        if(this.readyState==4&&this.status==200){
            console.log("Third inside");
            var user= res.JSON();
            redirect(user);
        }
    };
    xhttp.open('POST','http://localhost:8080/empreimb/login');
xhttp.send();
}
document.getElementsByTagName("form")[0].addEventListener('submit',loadDoc);