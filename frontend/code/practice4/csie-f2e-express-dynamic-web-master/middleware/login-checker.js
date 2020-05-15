const admin = require('../firebase');
const db = require('../db');

// 登入驗證關口
function loginChecker(router) {
    router.use(function (req, res, next) {
        console.log('[進入登入檢查站]');
        // TODO: 設計登入驗證關卡...

    });
}

module.exports = loginChecker;