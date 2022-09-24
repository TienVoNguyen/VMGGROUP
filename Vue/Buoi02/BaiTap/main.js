// Destructuring: phân rã phần tử của obj và arr.
//REST: Lấy ra những phần còn lại
//==> sử dụng với destructuring, thuộc tính của function: định nghĩa tham sô
//Spread: Toán tử giải. Dùng (...) trước array or object
// Demo rest, destructuring
let array = ['Nguyen Tien Vo', 'Mai Xuan Thanh', 'Nong Van Dat']
let [a, b, c] = array;
console.log(a, b, c);
let [d,...rest] = array;
console.log(d);
console.log(rest);
function logger([...rest]) {
    console.log(rest);
}
logger([1, 2, 3, 4, 5])
///
// Demo Spread
let array1 = [ ' Javascript ' , ' Ruby ' , ' PHP ' ] ;
let array2 = [ ' ReactJS ' , ' Dart ' ] ;
let array3 = [...array2, ...array1 ] ; 
console.log(array3)
