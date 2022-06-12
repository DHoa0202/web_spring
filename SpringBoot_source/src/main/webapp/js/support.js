// Messages bootstrap
var toastElList = [].slice.call(document.querySelectorAll('.toast'))
var toastList = toastElList.map(function(toastEl) {
	return new bootstrap.Toast(toastEl)
})
toastList.forEach(toast => toast.show())

// File image upload
function upFile(set, input) {
	input = input.files[0];
	const reader = new FileReader();

	reader.addEventListener('load', () =>
		document.querySelector(set).src = reader.result
	);
console.log(set);
	if (input) reader.readAsDataURL(input);
}

function amount(p, price, amounId) {
	amountPrice = (p.value == null || p.value < 0 ? 0 : p.value * price);
	amountPrice = amountPrice.toLocaleString('en-US');
	document.querySelector(amounId).innerHTML = amountPrice;
}