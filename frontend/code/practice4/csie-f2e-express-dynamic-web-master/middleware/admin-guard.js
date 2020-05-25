// 設置管理者路由守衛
function adminGuard(router) {
    router.use(function (req, res, next) {
        // TODO: 管理員驗證路由守衛
        // if this is an administrator
        if(res.locals.auth.isAdmin){
            next()
        } else {
            res.redirect('/');
        }
    });
}

module.exports = adminGuard;