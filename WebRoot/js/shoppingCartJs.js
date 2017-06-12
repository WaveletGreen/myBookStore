/**
 * 
 */
/**
 * 传入Book的ID，condit只能是增量
 */
function chageAmount(id, condit) {
	var ele = document.getElementById(id);
	var subBut = document.getElementById("butSub" + id);
	var addBut = document.getElementById("butAdd" + id);

	ele.value = parseInt(ele.value) + condit;

	location.href = "/bookStore/servlet/shoppingServlet?book_id=" + id
			+ "&amount=" + parseInt(condit);

}

function checkValidate() {
	var items = document.getElementsByName("nums");
	calculateTotalPrice();
}
function delItem(id) {
	var ele = document.getElementById("bname" + id);
	if (confirm("确定要删除商品《" + ele.textContent + "》吗？")) {
		location.href = "/bookStore/servlet/shoppingDelServlet?book_id=" + id;
	}
}
function calculateTotalPrice() {
	var TotalCost = 0;
	var prices = document.getElementsByName("price");
	var nums = document.getElementsByName("nums");
	for ( var int = 0; int < prices.length; int++) {
		TotalCost += prices[int].value * nums[int].value;
	}
	document.getElementById("cost").textContent = TotalCost;
	document.getElementById("totalCost").value = TotalCost;
}
var oldValue = 0;
function getValidate(id) {
	oldValue = document.getElementById(id).value;
}
function setValidate(id) {
	var ele = document.getElementById(id);
	var newValue = ele.value;
	var offset = newValue - oldValue;
	location.href = "/bookStore/servlet/shoppingServlet?book_id=" + id
			+ "&amount=" + parseInt(offset);
}