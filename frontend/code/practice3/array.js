const  numberList = [20,32,45,78,45,84]
for ( let n in numberList){
    console.log(`${n} : ${numberList[n]}`)
}

for (let i = numberList.length-1; i > -1 ;i--){
    console.log(`${i} : ${numberList[i]}`)
}

numberList.forEach(function(i, idx){console.log(`idx:${idx}, number:${i}`)})