// 初始化firebase
// FIREBASE NODE.JS初始化文件
// https://firebase.google.com/docs/admin/setup

var admin = require("firebase-admin");

var serviceAccount = require("./key.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://shoppingcart-ac0a2.firebaseio.com"
});

// output admin for other files to use
module.exports = admin;