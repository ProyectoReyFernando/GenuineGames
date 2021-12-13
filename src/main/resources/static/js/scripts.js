$(document).ready(function() {
	categoria();
	caja2();
	punct();
	punc();
});
/*---------------------------------------------------------------------------------------*/
/* Login y Registro */
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
	} else {
		alert('No coinciden las dos contraseñas. Asegurese de que es una contraseña que podrá recordar');
	}
}

function pwdError() {
	if ((comPwd == true) && (comCpwd == true)) {
	} else {
		alert("Debe poner la misma contraseña en las 2 op")
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
	if (hoy > date) {
		comDate = true;
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
var exit = false;
var tds = {};

function caja2() {
	if (auxiliar == false) {
		for (var y = 0; y < 2; y++) {
			cajas();
		}
		auxiliar = true;

	} else if (auxiliar == true) {
		for (var z = 0; z < 1; z++) {
			cajas();
		}
	}
};
function cajas() {
	x = 0;

	if (document.getElementsByClassName("filtrado").length != 0) {
		tds = document.getElementsByClassName("filtrado");
	} else {
		tds = document.getElementsByClassName("Sfiltrar");
	}
	var caja = document.getElementById("caja");

	for (j; x < 4 && exit == false && caja != null; j = j + 6, x++) {
		if (j + 7 > tds.length) {
			x = 4;
			exit = true;
		}
		if (tds[j + 5].innerHTML== "") {
			var punt = 0;
		} else {
			var punt = parseInt(tds[j + 5].innerHTML);
		}
		var name = tds[j + 1].innerHTML;
		var nombre = tds[j + 1].innerHTML;

		var form = document.createElement("form");
		var img = document.createElement("img");
		var col = document.createElement("div");
		var cartab = document.createElement("div");
		var title = document.createTextNode(nombre);
		var submit = document.createElement("input");
		var textcenter = document.createElement("div");
		var divpunt = document.createElement("div");
		var h5 = document.createElement("h5");
		var carta = document.createElement("div");
		form.action = "/user/infoGame/" + name;
		submit.className = "btn btn-outline-dark mt-auto";
		col.className = "col mb-5";
		img.className = "card-img-top";
		h5.name = "juego";
		textcenter.className = "text-center";
		divpunt.className = "d-flex justify-content-center small text-warning mb-2";
		h5.className = "fw-bolder";
		cartab.className = "card-body p-4";
		carta.className = "card h-100";
		submit.type = "submit";
		img.src = "../../img/" + tds[j + 4].innerHTML;
		submit.value = "Opiniones";
		form.className = "mt-2";
		for (var i = 0; i < 5; i++) {
			var divstar = document.createElement("div");
			var puntstar = document.createElement("img");
			if (i < punt) {
				puntstar.src = "/img/dinamic/star-active.png";
				puntstar.className = "opinions";
				divstar.appendChild(puntstar);
				divpunt.appendChild(divstar);
			} else {
				puntstar.src = "/img/dinamic/star-deactive.png";
				puntstar.className = "opinions";
				divstar.appendChild(puntstar);
				divpunt.appendChild(divstar);
			}

			h5.appendChild(title);
			textcenter.appendChild(h5);
			textcenter.appendChild(divpunt);
			cartab.appendChild(textcenter);
			carta.appendChild(img);

			carta.appendChild(cartab);
			carta.appendChild(submit);
			form.appendChild(carta);
			caja.appendChild(form);
		}
	}

}
function categoria() {
	var salir = false;
	var elementos = document.getElementsByClassName("Sfiltrar cat");
	let lista = [];
	for (var j = 0; j < elementos.length; j++) {
		salir = false;
		for (var k = 0; k < lista.length && salir == false && elementos != 0; k++) {
			if (elementos[j].innerHTML == lista[k] && j != k) {

				salir = true;
			}
		}
		if (salir == false) {
			lista.push(elementos[j].innerHTML);
		}
	}
	var ul = document.getElementById("categoria");
	for (var l = 0; l < lista.length; l++) {
		var a = document.createElement("a");
		var li = document.createElement("li");
		var text = document.createTextNode(lista[l]);
		li.className = "dropdown-item";
		a.href = "/user/categoria/" + lista[l];
		a.className = "text-dark text-decoration-none";
		a.appendChild(text);
		li.appendChild(a);
		ul.appendChild(li);

	}

}
function activar() {
	var algo = document.getElementById("oculto");
	algo.style.color = "red";
	algo.style.display = "block";
}
function punct() {
	var punt = (document.getElementById("puncjuegos") != null) ? document.getElementById("puncjuegos").innerHTML : null;
	var punct = document.getElementById("punct");
	var divstar = document.createElement("div");
	var text = document.createTextNode(punt);
	if (punct != null) {
		punct.appendChild(text);
	}

	for (var i = 0; i < 5 && punct != null; i++) {
		var puntstar = document.createElement("img");
		puntstar.setAttribute("onmouseOver", "puntuarV(" + i + ")");
		puntstar.setAttribute("onclick", "puntuarS(" + (i + 1) + ")");

		if (i < punt) {
			puntstar.src = "/img/dinamic/star-active.png";
			puntstar.className = "opinions";
			punct.appendChild(puntstar)
		} else {
			puntstar.src = "/img/dinamic/star-deactive.png";
			puntstar.className = "opinions " + i;
			punct.appendChild(puntstar)
		}

	}
}
function punc() {
	var punt = (document.getElementById("puncjuegos") != null) ? document.getElementById("puncjuegos").innerHTML : null;
	var punct = document.getElementById("punc");
	var divstar = document.createElement("div");
	var text = document.createTextNode(punt);
	if (punct != null) {
		punct.appendChild(text);
	}

	for (var i = 0; i < 5 && punct != null; i++) {
		var puntstar = document.createElement("img");
		if (i < punt) {
			puntstar.src = "/img/dinamic/star-active.png";
			puntstar.className = "opinions";
			punct.appendChild(puntstar)
		} else {
			puntstar.src = "/img/dinamic/star-deactive.png";
			puntstar.className = "opinions " + i;
			punct.appendChild(puntstar)
		}

	}
}
function puntuarV(i) {
	var img = document.getElementsByClassName("opinions");
	var punct = document.getElementById("punct");
	for (var j = 0; j < 5 && img != null; j++) {
		if (j <= i) {
			img[j].src = "/img/dinamic/star-active.png";
		} else {
			img[j].src = "/img/dinamic/star-deactive.png";
		}
	}

}
function puntuarS(valor) {
	var img = document.getElementsByClassName("opinions " + valor);
	var nombre = document.getElementById("nombrejuego").innerHTML;
	window.location.replace("/user/infogame/valoration/" + valor + "/" + nombre);
}