const express = require('express');
const router = express.Router();
const db = require('../db');
// reference login checker (not a guard,everyone can pass)
const loginChecker = require('../middleware/login-checker')

// before entering routers below
loginChecker(router); 


// 首頁路由
router.get('/', async function (req, res, next) {
  // TODO: 取得產品列表
  const collection = await db.collection('product-list').orderBy('createdAt','desc').get()
  //.then()
  //.catch(err => console.log(err));
  const productList = [];
  //console.log('[collection]', collection)
  collection.forEach(doc => {
    const product = doc.data();
    product.id = doc.id;
    console.log(product);
    productList.push(product);

  })
  res.locals.productList = productList;
  // by views/index.ejs 's template to generate html's response to user
  res.render('index');
});

// about this website
router.get('/about',  (req,res,next) => {
  //res.locals.{variable name} = {data}
  res.locals.title = "title of website"; // pass the data of title into template
  res.locals.author = {
    name: 'Andy',
    age: 29,
    city: 'Taipei'
  };
  res.render('about');
});


// API示範頁面
router.get('/api-demo', function (req, res, next) {
  res.render('api-demo');
});

// 名言頁面
router.get('/quote/:num', function (req, res, next) {
  const quoteList = [
    {
      author: "莊子",
      img: 'https://picsum.photos/id/1042/1000/600',
      text: "相濡以沫，不如相忘於江湖。"
    },
    {
      author: "老子",
      img: 'https://picsum.photos/id/1044/1000/600',
      text: "天下皆知美之為美，斯惡矣。皆知善之為善，斯不善矣。"
    },
    {
      author: "孔子",
      img: 'https://picsum.photos/id/112/1000/600',
      text: "知者不惑，仁者不憂，勇者不懼。"
    }
  ];
  // TODO: 根據:num參數選擇渲染的資料
  let number = parseInt(req.params.num);  // request params number
  console.log('[number]',number );
  // 規則：使用/3的餘數為資料取得索引
  number = number%3;
  const quote = quoteList[number];
  console.log('[quote]',quote)
  // pass data to template
  res.locals.q = quote;
  // TODO: 渲染相對應的畫面
  res.render('quote')
  
});

module.exports = router;
