/*Botones de Admin*/
function adminC() {
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
function adminU() {
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
function adminD() {
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
/* Login y Registro */
/* L */
var comUser = false;
var comPwd = false;
function valuser() {
	var user = document.getElementById('user').value;
	var userER = /^([a-zA-Z]|[0-9]){6,50}/;
	if (userER.test(user)) {
		document.getElementById('user').style.color = "white";
	} else {
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
	} else {
		document.getElementById('pwd').style.color = "red";
	}
}
function valf() {
	if ((comUser == true) && (comPwd == true)) {
		document.loginform.submit();
	} else {
		alert("Algo terrible esta a punto de ocurrir");
	}
}
/* R */
var comUser = false;
var comPwd = false;
var comCpwd = false;
var comTlf = false;
var comMail = false;
var comDate = false;
var comSex = false;
function valuser() {
	var user = document.getElementById('user').value;
	var userER = /^([a-zA-Z]|[0-9]){6,50}/;
	if (userER.test(user)) {
		document.getElementById('user').style.color = "white";
		comUser = true;
	} else {
		document.getElementById('user').style.color = "red";
	}
}
function valpwd() {
	var pwd = document.getElementById('pwd').value;
	var pwdER = /^^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{6,14}$/;
	if (pwdER.test(pwd)) {
		document.getElementById('pwd').style.color = "white";
		comPwd = true;
	} else {
		document.getElementById('pwd').style.color = "red";
	}
}
function valcpwd() {
	var cpwd = document.getElementById('cpwd').value;
	var cpwdER = /^^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{6,14}$/;
	if (cpwdER.test(cpwd)) {
		document.getElementById('cpwd').style.color = "white";
		comCpwd = true;
		valpwds();
	} else {
		document.getElementById('cpwd').style.color = "red";
	}
}
function valpwds() {
	var pwd = document.getElementById('pwd').value;
	var cpwd = document.getElementById('cpwd').value;
	if (pwd == cpwd) {
		comPwd = true;
		comCpwd = true;
		console.log('todo flama');
	} else {
		alert('No coinciden las dos contraseñas. Asegurese de que es una contraseña que podrá recordar');
	}
}
function pwdError() {
	if ((comPwd == true) && (comCpwd == true)) {
		console.log("tamos bien");
	} else {
		console.log("No se lo pongamos tan facil a los malos")
	}
}
function valtlf() {
	var tlf = document.getElementById('tlf').value;
	var tlfER = /^([0-9]){9}/;
	if (tlfER.test(tlf)) {
		document.getElementById('tlf').style.color = "white";
		comTlf = true;
	} else {
		document.getElementById('tlf').style.color = "red";
	}
}
function valdate() {
	var hoy = new Date();
	var date = document.getElementById('date').value;
	var dhoy = hoy.getDate();
	var mhoy = hoy.getMonth();
	var ahoy = hoy.getFullYear() - 3;
	var hoy = ahoy + "-" + mhoy + "-" + dhoy;
	console.log(date);
	console.log(hoy);
	if (hoy > date) {
		console.log("OK");
		comDate = true;
	} else {
		console.log("Fatal error");
	}
}

function valmail() {
	var mail = document.getElementById('mail').value;
	var mailER = /^\w+([\.\-]?\w{0,})*@\w+(\.\w{2,4})+$/;
	if (mailER.test(mail)) {
		document.getElementById('mail').style.color = "white";
		comMail = true;
	} else {
		document.getElementById('mail').style.color = "red";
	}
}
function valsex() {
	var sex = document.querySelectorAll('input[name="sex"]');
	if (sex[0].checked == false && sex[1].checked == false) {
		return alert("Completa el campo sexo.");
	} else {
		comSex = true;
	}
}
function valf() {
	if ((comUser == true) && (comPwd == true) && (comCpwd == true)
			&& (comTlf == true) && (comMail == true) && (comDate == true)) {
		document.registroform.submit();
	} else {
		return false;
	}
}
/*--------- ------------------------------------------------------------------------------------*/
var j = 0;
var auxiliar = false;
var GG = true;
$(document).ready(function() {
	caja3();
});
function caja3() {
	if (GG == true) {
		caja2();
		GG = false;
	}
}
function caja2() {
	console.log("entra");
	if (auxiliar == false) {
		console.log("y va 8");
		for (var y = 0; y < 2; y++) {
			cajas();
		}
		auxiliar = true;

	} else if (auxiliar == true) {
		console.log("y con esta 2");
		for (var z = 0; z < 1; z++) {
			cajas();
			console.log(auxiliar);
		}

	} else {
	}
};
function cajas() {
	x = 0;
	var tds = document.getElementsByTagName("td");
	for (j; x < 4; j = j + 5, x++) {
		console.log("../img/" + tds[j + 4].innerHTML);
		var nombre = tds[j + 1].innerHTML;
		var col = document.createElement("div");
		var carta = document.createElement("div");
		var img = document.createElement("img");
		var cartab = document.createElement("div");
		var tcenter = document.createElement("div");
		var name = document.createElement("h5");
		var title = document.createTextNode(nombre);
		var rev = document.createElement("div");
		var opi = document.createElement("div");
		var opiC = document.createElement("div");
		var opiA = document.createElement("a");
		var opiTn = document.createTextNode("Opiniones");
		var caja = document.getElementById("caja");
		opiA.href = "#";
		opiA.className = "btn btn-outline-dark mt-auto";
		opiC.className = "text-center";
		opi.className = "card-footer p-4 pt-0 border-top-0 bg-transparent";
		rev.className = "d-flex justify-content-center small text-warning mb-2";
		opiTn.className = tds[j];
		name.className = "fw-bolder";
		name.text = "League of Legends";
		tcenter.className = "text-center";
		cartab.className = "card-body p-4";
		img.className = "card-img-top";
		img.src = "../../img/" + tds[j + 4].innerHTML;
		console.log();
		col.className = "col mb-5";
		carta.className = "card h-100";
		name.appendChild(title);
		tcenter.appendChild(name);
		for (var i = 0; i < 5; i++) {
			var divV = document.createElement("div");
			var punt = document.createElement("img");
			punt.className = "opinions";
			punt.src = "/img/dinamic/star-active.png";
			divV.appendChild(punt);
			rev.appendChild(divV);
		}
		tcenter.appendChild(rev);
		cartab.appendChild(tcenter);
		carta.appendChild(img);
		carta.appendChild(cartab);
		opiA.appendChild(opiTn);
		opiC.appendChild(opiA);
		opi.appendChild(opiC);
		carta.appendChild(opi);
		col.appendChild(carta);
		caja.appendChild(col);
	}
}