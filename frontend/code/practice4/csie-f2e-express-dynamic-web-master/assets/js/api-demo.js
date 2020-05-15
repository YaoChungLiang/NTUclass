function renderRes(form, res, hasSuccess) {
    // 取得此表單內部的pre標籤
    const pre = $(form).children('pre');
    // 清空pre
    pre.text('');
    // 移除pre所有的class
    pre.removeClass()
    // 將收到的JSON資料格式化
    let stringifyRes = JSON.stringify(res, null, 2);
    // 為pre新增樣式
    pre.addClass('alert');
    // 如果伺服器回傳的結果是成功取得
    if (hasSuccess) {
        pre.addClass('alert-success')
    } else {
        // 如果伺服器回傳的結果是請求失敗
        pre.addClass('alert-danger')
        // 檢查回傳值中是否有response
        // 其中有些錯誤訊息是不會有回應的（比如網路斷線）
        if (res.response) {
            // 如果有失敗回應設定要顯示的資料為失敗回應
            stringifyRes = JSON.stringify(res.response, null, 2)
        }
    }
    // 將回傳狀態顯示於畫面上
    pre.text(stringifyRes);
}

// 取得伺服器正確與錯誤訊息範例
$('#getSuccessOrErrorForm').submit(function (event) {
    event.preventDefault();
    // 取得送出的表單
    const form = this;
    // 取得輸入值
    const isSuccess = $('#isSuccess').val();
    // 準備要遞送給後端的資料
    const obj = {
        isSuccess: isSuccess
    }
    // 使用POST方法 遞送資料obj至後端API /api/success-or-error
    axios.post('/api/success-or-error', obj)
        .then(function (res) {
            console.log(res);
            renderRes(form, res, true)
        })
        .catch(function (err) {
            // 如果發生錯誤
            renderRes(form, err, false)
        });
});

// 取得伺服器時間戳記
$('#getTimestampForm').submit(function (event) {
    event.preventDefault();
    // 取得送出的表單
    const form = this;
    // 使用GET方法 請求後端API /api/time/current 的資料
    axios.get('/api/time/current')
        .then(function (res) {
            // 如果請求成功
            console.log(res);
            renderRes(form, res, true)
        })
        .catch(function (err) {
            // 如果發生錯誤
            console.log(err)
            renderRes(form, err, false)
        })
});

// 取得伺服器指定格式時間
$('#getFormatTimeForm').submit(function (event) {
    event.preventDefault();
    // 取得送出的表單
    const form = this;
    // 取得輸入填入的值
    const format = $('#format').val();
    // 準備傳送給後端的物件
    const obj = {
        format: format
    }
    console.log('obj', obj);
    // 使用POST方法 遞送資料obj至後端API /api/time/format
    axios.post('/api/time/format', obj)
        .then(function (res) {
            // 如果請求成功
            console.log(res);
            renderRes(form, res, true)
        })
        .catch(function (err) {
            // 如果發生錯誤
            console.log(err);
            renderRes(form, err, false)
        });
});

// TODO: 使伺服器回傳前端寫入的字串
$('#repeatMyStringForm').submit(function (event) {
    event.preventDefault();
    // 取得送出的表單
    const form = this;
    // 取得輸入的值
    const myString = $('#myString').val();
    console.log('[myString]', myString);

});