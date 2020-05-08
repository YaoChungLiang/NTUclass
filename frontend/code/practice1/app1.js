console.log('hello from JS')
// let is block-scoped
let name = 'Debo';
name = 8.000000000000001;
number = 0.2+0.4
const city = 'Taiwan'
console.log(number)
// var is finction-scoped
console.log(name);
newname = 'Debo'
// very likely to get syntex error, inefiicient
console.log('hi my name is '+ newname + ',from ' + city); 
let num = 7;
console.log(num)
// `` this string comes with special function
let intro = `Hi  I'm ${name} from ${city}`;
console.log(intro)
// choose an object
const reportObject = document.getElementById('report')
console.log('reportObject', reportObject)
reportObject.innerHTML

console.log(`[reportObject]`, reportObject)
// get all arribute of the object
console.dir(reportObject)
// change css properties
reportObject.style.backgroundColor = 'orange';
reportObject.style.borderRadius = '15px'
// get all element with the same class and put into a nodeList
document.querySelectorAll('.report')[1]
