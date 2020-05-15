const express = require('express');
const moment = require('moment');
const axios = require('axios');
const router = express.Router();

// TODO: 開出一個API回應前端傳來的內容

// 取得伺服器正確與錯誤訊息範例
router.post('/success-or-error', function (req, res, next) {
    // 取得傳遞進來的物件.isSuccess
    const isSuccess = req.body.isSuccess;
    console.log('[isSuccess]', isSuccess);
    if (isSuccess === '1') {
        // 回傳成功狀態200與資料給前端
        res.status(200).json({
            msg: '成功'
        })
    } else {
        // 回傳錯誤狀態400與資料給前端
        res.status(400).send({
            msg: '請求失敗'
        })
    }
});

// 取得當下時間
router.get('/time/current', function (req, res, next) {
    // 取得當下時間戳記
    const timestamp = new Date().getTime();
    console.log('[timestamp]', timestamp);
    // 回傳成功狀態200與資料給前端
    res.status(200).json({
        timestamp: timestamp
    })
});

// 取得特定時間格式
router.post('/time/format', function (req, res, next) {
    // 取得:formatString的值
    console.log('[req.body]', req.body);
    const formatString = req.body.format;
    // 取得當下時間戳記
    const timestamp = new Date().getTime();
    console.log('[formatString]', formatString);
    console.log('[timestamp]', timestamp);
    // 將時間格式處理為前端指定格式
    const date = moment(timestamp).format(formatString)
    // 回傳成功狀態200與資料給前端
    res.status(200).json({
        timestamp: timestamp,
        formatString: formatString,
        date: date
    })
});

// 登入
router.post('/login', function (req, res, next) {

});

// 登出
router.post('/logout', function (req, res, next) {

});

// 取得商品列表
router.get('/product/list', function (req, res, next) {

});

// 新增商品 
router.post('/product/create', function (req, res, next) {
    // get the info from the frontend
    const product = req.body;
    console.log('[new product]', product);
    // response to frontend that successfully
    res.status(200).json({msg: 'OK'});
    
});

// 更新商品
router.put('/product/:pid', function (req, res, next) {

});

// 刪除商品
router.delete('/product/:pid', function (req, res, next) {

});

module.exports = router;
