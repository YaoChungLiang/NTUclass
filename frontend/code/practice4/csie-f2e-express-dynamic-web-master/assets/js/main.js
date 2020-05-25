

function finalizeFrontEndLogin(res) {
    // TODO: 處理登入成功後的流程
    // 取得idToken
    // https://firebase.google.com/docs/reference/js/firebase.User#getidtoken
    // get idToken
    res.user
        .getIdToken()
        .then(idToken => {
            console.log('[id Token]', idToken);
            // pass id token to the backend
            axios
                .post('/api/login',{
                    idToken
                })
                .then(res => {
                    //several ways to do like redirect to a new page or sth
                    // refresh the webpage
                    window.location.reload();
                })
                .catch(err =>{
                    console.log('[err]', err);
                    alert('Something wrong, try again plz.')
                })

        })    
}

// 登入表單送出時
$('#loginForm').submit(function (event) {
    event.preventDefault();
    const email = $('#loginEmail').val(),
        password = $('#loginPassword').val();
    console.log('[開始登入]', { email: email, password: password });
    // TODO: 處理登入流程
    // https://firebase.google.com/docs/auth/web/start#sign_in_existing_users
    firebase
    .auth().signInWithEmailAndPassword(email , password)
    .then(res =>{
        console.log('[ sign in successfully ]', res);
        // handle sign in process
        finalizeFrontEndLogin(res);
    })
    .catch(err =>{
        console.log('[ sign in fail ]', err);
        alert(err.message);
    });

});

// 註冊表單送出時
$('#signUpForm').submit(function (event) {
    event.preventDefault();
    const email = $('#signUpEmail').val(),
        password = $('#signUpPassword').val();
    console.log('[開始註冊]', { email: email, password: password });
    // TODO: 處理註冊流程
    // https://firebase.google.com/docs/auth/web/start#sign_up_new_users
    firebase
        .auth()
        .createUserWithEmailAndPassword(email, password)
        .then(res =>{
            finalizeFrontEndLogin(res);
        })
        .catch(err =>{
            console.log('[err]',err);
            alert(err);
        });

});

// 登出按鈕點擊時
$('#logoutBtn').click(function () {
    console.log('[開始登出]');
    // TODO: 處理登出流程
    // https://firebase.google.com/docs/reference/js/firebase.auth.Auth#signout
    axios
        .post('/api/logout', {})
        .then(res =>{
            // redirect to homepage
            window.location = '/'; // easier for front end
        })
        .catch(err =>{
            alert(err);
        })

});