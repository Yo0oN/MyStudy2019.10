/**
 * 
 */
// 함수 선언
function doFunc1() {
	console.log('Hello Function');
}
function doFunc2(data1) {
	console.log('data1 : ' + data1);
}
// 매개변수가 다 들어가지 않아도 에러는 없다.
function doFunc3(data1, data2) {
	console.log('data1 : ' + data1 + ', data2 : ' + data2);
}
// 함수 생성시 리턴타입을 기재하지 않는다.
function doFunc4(data1, data2) {
	var sum = data1 + data2;
	return sum;
}