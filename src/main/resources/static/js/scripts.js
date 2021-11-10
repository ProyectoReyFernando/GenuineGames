/*Botones de Admin*/
function adminC(){
                var activate = document.getElementsByName("create");
                for (var i = 0; i < activate.length; i++) {
                    activate[i].style.display = "block";
                }
                var deactivate1 = document.getElementsByName("update");
                for (var i = 0; i < deactivate1.length; i++) {
                    deactivate1[i].style.display = "none";
                }
                var deactivate2 = document.getElementsByName("delete");
                for (var i = 0; i < deactivate2.length; i++) {
                    deactivate2[i].style.display = "none";
                }
            }
function adminU(){
                var activate = document.getElementsByName("update");
                for (var i = 0; i < activate.length; i++) {
                    activate[i].style.display = "block";
                }
                var deactivate1 = document.getElementsByName("create");
                for (var i = 0; i < deactivate1.length; i++) {
                    deactivate1[i].style.display = "none";
                }
                var deactivate2 = document.getElementsByName("delete");
                for (var i = 0; i < deactivate2.length; i++) {
                    deactivate2[i].style.display = "none";
                }
            }
function adminD(){
                var activate = document.getElementsByName("delete");
                for (var i = 0; i < activate.length; i++) {
                    activate[i].style.display = "block";
                }
                var deactivate1 = document.getElementsByName("update");
                for (var i = 0; i < deactivate1.length; i++) {
                    deactivate1[i].style.display = "none";
                }
                var deactivate2 = document.getElementsByName("create");
                for (var i = 0; i < deactivate2.length; i++) {
                    deactivate2[i].style.display = "none";
                }
            }
/*---------------------------------------------------------------------------------------*/
/*Login y Registro*/
/*L*/
var comUser = false;
		var comPwd = false;
		function valuser() {
			var user = document.getElementById('user').value;
			var userER = /^([a-zA-Z]|[0-9]){6,50}/;
			if (userER.test(user)) {
				document.getElementById('user').style.color = "white";
			}
			else {
				document.getElementById('user').style.color = "red";
				document.getElementById('caja_error').hidden = false;
			}
		}
		function valpwd() {
			var pwd = document.getElementById('pwd').value;
			var pwdER = /^^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{6,14}$/;
			if (pwdER.test(pwd)) {
				document.getElementById('pwd').style.color = "white";
				comPwd = true;
			}
			else {
				document.getElementById('pwd').style.color = "red";
			}
		}
		function valf() {
			if ((comUser == true) && (comPwd == true)) {
				document.loginform.submit();
			}
			else {
				alert("Algo terrible esta a punto de ocurrir");
			}
		}
/*R*/
var comUser=false;
        var comPwd=false;
        var comCpwd=false;
        var comTlf=false;
        var comMail=false;
        var comDate=false;
        var comSex=false;
      function valuser(){
        var user=document.getElementById('user').value;
        var userER=/^([a-zA-Z]|[0-9]){6,50}/;
        if(userER.test(user)){
        document.getElementById('user').style.color="white";
        comUser=true;
        }
        else{
        document.getElementById('user').style.color="red";
        }
      }
      function valpwd(){
        var pwd=document.getElementById('pwd').value;
        var pwdER=/^^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{6,14}$/;
        if(pwdER.test(pwd)){
        document.getElementById('pwd').style.color="white";
        comPwd=true;
        }
        else{
        document.getElementById('pwd').style.color="red";
        }
      }
      function valcpwd(){
        var cpwd=document.getElementById('cpwd').value;
        var cpwdER=/^^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{6,14}$/;
        if(cpwdER.test(cpwd)){
        document.getElementById('cpwd').style.color="white";
        comCpwd=true;
        valpwds();
        }
        else{
        document.getElementById('cpwd').style.color="red";
        }
      }
      function valpwds(){
        var pwd=document.getElementById('pwd').value;
        var cpwd=document.getElementById('cpwd').value;
        if(pwd==cpwd){
          comPwd=true;
          comCpwd=true;
        console.log('todo flama');
        }
        else{
        alert('No coinciden las dos contraseñas. Asegurese de que es una contraseña que podrá recordar');
        }
      }
      function pwdError(){
        if ((comPwd==true)&&(comCpwd==true)) {
          console.log("tamos bien");
        }
        else{
          console.log("No se lo pongamos tan facil a los malos")
        }
      }
      function valtlf(){
        var tlf=document.getElementById('tlf').value;
        var tlfER=/^([0-9]){9}/;
        if(tlfER.test(tlf)){
        document.getElementById('tlf').style.color="white";
        comTlf=true;
        }
        else{
        document.getElementById('tlf').style.color="red";
        }
      }
      function valdate(){
        var hoy = new Date();
        var date = document.getElementById('date').value;
        var dhoy = hoy.getDate();
        var mhoy = hoy.getMonth();
        var ahoy = hoy.getFullYear()-3;
        var hoy = ahoy +"-"+mhoy+"-"+dhoy;
        console.log(date);
        console.log(hoy);
        if (hoy>date) {
          console.log("OK");
          comDate=true;
        }
        else{
          console.log("Fatal error");
        }
      }

      function valmail(){
        var mail=document.getElementById('mail').value;
        var mailER=/^\w+([\.\-]?\w{0,})*@\w+(\.\w{2,4})+$/;
        if(mailER.test(mail)){
        document.getElementById('mail').style.color="white";
        comMail=true;
        }
        else{
        document.getElementById('mail').style.color="red";
        }
      }
      function valsex(){
        var sex= document.querySelectorAll('input[name="sex"]');
        if (sex[0].checked == false && sex[1].checked==false) {
            return alert("Completa el campo sexo.");
        }
        else{
          comSex=true;
        }
      }
      function valf(){
        if((comUser==true)&&(comPwd==true)&&(comCpwd==true)&&(comTlf==true)&&(comMail==true)&&(comDate==true)){
        document.registroform.submit();
        }
        else{
        return false;
        }
      }
/*----------------------------------------------------------------------------------------------*/