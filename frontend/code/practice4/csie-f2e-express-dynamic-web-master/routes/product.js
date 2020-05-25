const express = require('express');
const router = express.Router();
// add db
const db = require('../db');
const adminGuard = require('../middleware/admin-guard');

// 產品詳情路由
router.get('/show/:pid', function (req, res, next) {
    // 渲染 product/show.ejs
    res.render('product/show');
});

adminGuard(router)

// 建立產品路由
router.get('/create', function (req, res, next) {
    // 渲染 product/create.ejs
    res.render('product/create');
});

// 編輯產品路由 dynamic router
router.get('/edit/:pid', async function (req, res, next) {
    // get pid  (ex: DVFGSD5645DGG65)
    const pid = req.params.pid;
    console.log(`[product ID]`, pid);
    
    // get firebase data using pid
    const doc = await db.doc(`product-list/${pid}`).get();
    //.then()
    //.catch()
    const product = doc.data();
    console.log(`[product]`, product);
    product.id = doc.id;
    // pass product to template
    res.locals.product = product;
    // 渲染 product/edit.ejs
    res.render('product/edit');
});

module.exports = router;
