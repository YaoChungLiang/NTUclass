const admin = require('../firebase');
const db = require('../db');

// 登入驗證關口
function loginChecker(router) {
    router.use(async function (req, res, next) {
        console.log('[進入登入檢查站]');
        // TODO: 設計登入驗證關卡...
        const auth = {
            isLogin : false,
            isAdmin : false,
            user : {}
        };
        // get session cookie
        const cookieName = req.app.locals.cookieName;
        const sessionCookie = req.cookies[cookieName] || '';
        admin
            .auth()
            .verifySessionCookie(sessionCookie, true)
            .then(async user=>{
                // sessionCoookie is valid, logon successfully
                auth.isLogin = true;
                auth.user = user;
                const email = user.email;
                // retrieve admin 
                const doc = await db.doc(`admin-list/${email}`).get();
                // if doc exist
                if (doc.exists){
                    auth.isAdmin = true;
                }
                // save auth
                res.locals.auth = auth;
                //pass
                next();
            })
            .catch(err =>{
                // not yet login
                res.locals.auth = auth;
                next();
            })
    });
}

module.exports = loginChecker;