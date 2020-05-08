/*
 * TODO: 串接ipinfo.io服務取得使用者的IP資訊，並顯示結果於網頁上
 * https://ipinfo.io/
 * 一個可回傳用戶端IP資訊的公開API服務
 */

const instance = axios.create({
    baseURL: '',
    timeout: 1000,
    headers: {'X-Custom-Header': 'foobar'}
  });

const getIPBtn = document.getElementById('getIPBtn'),
    reportDiv = document.getElementById('reportDiv'),
    token = `83249b6ae81ae3`;



getIPBtn.addEventListener('click', function () {
    console.log('[按鈕被點擊了]');
    // disabled button to be clicked
    getIPBtn.setAttribute('disabled','true')
    getIPBtn.innerHTML = `waiting`
    // use axios get IP data from ipinfo
    axios
    .get(`https://ipinfo.io?token=${token}`, 
    {
    baseURL: '',
    timeout: 15000,
    headers: {'X-Custom-Header': 'foobar'
    }
  })
    // request succefully and get response
    .then(function(response){
        getIPBtn.innerHTML = `get IP info`
        console.log('success')
        console.log(response);
        const data = response.data;
        // visualize request
        reportDiv.innerHTML += 
        `<div class = "alert alert-primary">
            IP = ${data.ip} <br>
            CITY = ${data.city} <br>
            REGION = ${data.region}
        </div>`
        // make button be able to be clicked
        getIPBtn.removeAttribute('disabled');

    })
    // if exception error 
    .catch(function(err){
        getIPBtn.innerHTML = `get IP info`
        console.log('something wrong');
        console.log(err);
        reportDiv.innerHTML += 
        `<div class = "alert alert-primary">
            Network error, cannot get response
        </div>`
        getIPBtn.removeAttribute('disabled');
    }
    );
});