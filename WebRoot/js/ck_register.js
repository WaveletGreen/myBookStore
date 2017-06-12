/**用户注册部分 */
function $(id) {
	return document.getElementById(id);
}
function agree() {
	if ($("checkOption").checked) {
		$("submit1").disabled = false;
	} else {
		$("submit1").disabled = true;
	}
}
function change() {
	var name = $("userNameId");
	if (name.value == "请输入用户名") {
		name.value = "";
	}
}
function checkName() {
	var uname = $("userNameId");
	var regName = $("userNameMsg");
	var reName = /^[a-zA-Z]{1}\w{1,14}$/;
	if (!reName.test(uname.value)) {
		regName.innerHTML = '<font color="red">&nbsp;用户名必须是字母开头，长度必须在2~15之间</font>';
		return false;
	}
	regName.innerHTML = '';
	return true;
}

function checkPassWord() {
	var passWord = $("passWordId");
	var regpassWord = $("passWordMsg");
	var reWord = /^\w{6,15}$/;
	if (!reWord.test(passWord.value)) {
		regpassWord.innerHTML = '<font color="red">&nbsp;密码长度在6~15之间</font>';
		return false;
	}
	regpassWord.innerHTML = '';
	return true;
}

function checkRePassword() {
	var passWord1 = $("rePassWordId");
	var regpassWord1 = $("rePassWordMsg");
	var passWord = $("passWordId");
	if (passWord.value != passWord1.value) {
		regpassWord1.innerHTML = '<font color="red">&nbsp;两次密码输入不一致</font>';
		return false;
	}
	regpassWord1.innerHTML = '';
	return true;
}

function checkemail() {
	var email = $("emailId");
	var regEmail = $("emailMsg");
	var reEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if (!reEmail.test(email.value)) {
		regEmail.innerHTML = '<font color="red">&nbsp;邮箱格式不正确</font>';
		return false;
	}
	regEmail.innerHTML = '';
	return true;
}
function checkAll() {
	if (checkName() && checkpassWord() && checkREgPassword()
		&& checkPhone() && checkemail()) {
		alert(1);
		return true;
	}
	return false;
}
function msgDispear(id) {
	document.getElementById(id).innerHTML = '';
}
function unselectLicensr() {
	document.getElementById("checkOption").checked = false;

}