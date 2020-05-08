/*
const product1 = {
    name : 'Bubble Tea',
    price : 10,
    brand : 'blue origin',
    intro : function(){
        // this => object himself
        console.log(`this ${this.name} is ${this.price} from ${this.brand}`)
    }
}

console.log(product1)
// object.function()
product1.intro();
*/

// object constructor, start with capital
function Product(name, brand, price){
    this.name = name,
    this.brand = brand,
    this.price = price

    this.intro = function(){
        console.log(`${this.name} from ${this.brand} is $${this.price}`)
    }
}

const product1 = new Product('bubble tea','blueOG', 10);
console.log(`[product1]`, product1);
product1.intro()
// Q: how to serially create objects??

function Yoyocard(name, cash){
    if(typeof(cash)!= "number"){
        console.log(`invalid type of adding money`)
        return 
    }
    this.record = {}
    this.name = name,
    this.balance = cash-100,
    

    console.log(`${this.name}'s card initial with $${this.balance}`)

    this.purchase = function(title, price){
        if(this.balance+100 < price || this.balance < 0){
            console.log(`invalid balance for purchasing, puchase fail`)
            this.intro()
            return 
        }
        console.log(`You spent ${price} on ${title}`)
        this.balance -= price
        this.intro()

        // save the purchasing recodrs
        
        const now = new Date().getTime();
        this.record[now] = {
            title : title,
            price : price
        }
    }
    this.add = function(addMoney){
        this.balance += addMoney
        console.log(`Successfully add money`)
        this.intro()
    }
    this.intro = function(){
        console.log(`${this.name}'s card has ${this.balance} left`)
    }

    this.showRecords = function(){
        for (let time in this.record){
            //console.log(time)
            //console.log(this.record[time])
            const re = this.record[time]
            const timeStr = moment(parseInt(time)).format('LLLL')
            const report = `${timeStr} ${re.title}:${re.price}`
            console.log(report)
        }
    }
}

const card1 = new Yoyocard('Debo',10000)
/*
if (typeof(card1) != Object){
    throw new Error(`${card1} is not an object`)
}

card1.intro()
card1.purchase('bag',10)
card1.purchase('Bottle',100)
card1.purchase('House',1500)
card1.add(1000)
card1.showRecords()
*/

setTimeout(function(){
    card1.purchase('bag',120)
}, 1000)

setTimeout(function(){
    card1.purchase('bottle',150)
}, 1000)

setTimeout(function(){
    card1.purchase(`house`,1200)
}, 1000)

card1.add(1000)

setTimeout(function(){
    card1.showRecords()
}, 4000)