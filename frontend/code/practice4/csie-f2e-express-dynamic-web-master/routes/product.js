const express = require('express');
const router = express.Router();

// 產品詳情路由
router.get('/show/:pid', function (req, res, next) {
    // 渲染 product/show.ejs
    res.render('product/show');
});

// 建立產品路由
router.get('/create', function (req, res, next) {
    // 渲染 product/create.ejs
    res.render('product/create');
});

// 編輯產品路由
router.get('/edit/:pid', function (req, res, next) {
    // 渲染 product/edit.ejs
    res.render('product/edit');
});

module.exports = router;
