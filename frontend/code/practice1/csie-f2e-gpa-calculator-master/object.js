// object
const user1 = {
    // property : value
    name :'Andy',
    city : 30,
    address : {
        Country: 'Taiwan',
        County : 'Taipei',
        City : 'Taipei',
        District : 'ChangChi St.',
        zip : '98115'
    },
    //address : '8520 25th Ave NE Seattle 98115'
};
Object.freeze(user1.City)
console.log(user1.name);
console.log(typeof user1.city)
user1[name] = 'Josh'
user1.city += 1
user1.email = 'abc@gmail.com'
console.log(user1.city)
console.log(user1.name)
console.log(user1.address.City)

//user1 = new Object()
//console.log(user1)