const express = require('express');
const moment = require('moment');
const axios = require('axios');
const router = express.Router();
// add db
const db = require('../db');

const admin = require('../firebase');

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
router.post('/login', async function (req, res, next) {
    // get idToken
    const idToken = req.body.idToken;
    // get cookieName
    const cookieName = req.app.locals.cookieName;
    console.log('[idToken]', idToken);
    console.log('[cookieName]', cookieName);
    //setup expiration date
    const expiresIn = 60*60*24*5*1000;

    // get sessionCookie
    const sessionCookie = await admin.auth().createSessionCookie(idToken, {expiresIn});
    //console.log('[sessionCookier]', sessionCookie);

    console.log('[sessionCookie]', sessionCookie);
    //cookie config
    const option = {
        maxAge : expiresIn,
        httpOnly : true,
       // secure : true // cannot be testing on local machine
    }
    // wrote a cookie to the browser
    res.cookie(cookieName, sessionCookie, option);
    // inform the frontend that all successful
    res.status(200).json({msg: 'Login successfully!!!'});
});

// 登出
router.post('/logout', function (req, res, next) {
    // get cookieName and sessionCookie
    const cookieName = req.app.locals.cookieName, 
        sessionCookie = req.cookies[cookieName] || '';
    // clear cookie from browser
    res.clearCookie(cookieName);
    // by sessionCookie get user
    admin
        .auth()
        .verifySessionCookie(sessionCookie)
        .then(async user =>{
            const uid = user.uid;
            // let firebase auth delete the user's sessionCookie
            await admin.auth().revokeRefreshTokens(uid)
            res.status(200).json({msg : 'OK'})
        })
        .catch(err =>{
            
            res.status(200).json({msg : 'OK'})
        })
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
    // add frontend data to remote backend database
    // only send object {} to firebase 
    db
        .collection('product-list')
        .add(product)
        .then( () => {
            res.status(200).json({msg:'Done'});
        })
        .catch(err =>{
            res.status(500).json(err);
        });
    res.status(200).json({msg: 'OK'});
    
});

// 更新商品
router.put('/product/:pid', function (req, res, next) {
    const pid = req.params.pid;
    // use req.body can get the object from the frontend
    const product = req.body; 
    /*
        get : doc() / collection().get while retrieve from the backend
        add : collection().add()
        update : doc().update()
        remove : doc().delete()
    */
    db
        .doc(`product-list/${pid}`)
        .update(product)
        .then( () =>{
            res.status(200).json({msg: 'update success'});
        })
        .catch(err =>{
            res.status(500).json(err);
        })
});

// 刪除商品
router.delete('/product/:pid', function (req, res, next) {
    const pid = req.params.pid;
    // use req.body can get the object from the frontend
    db
        .doc(`product-list/${pid}`)
        .delete()
        .then(() =>{
            res.status(200).json({msg:'update success'})
        })
        .catch(err =>{
            res.status(500).json(err);
        })

});

module.exports = router;
