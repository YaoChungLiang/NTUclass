// 成績計算表單
const scoreForm = document.getElementById('scoreForm');
// 各科目分數輸入框
const zhInput = document.getElementById('chineseScoreInput');
const enInput = document.getElementById('englishScoreInput');
const mathInput = document.getElementById('mathScoreInput');
// select all input label in score form
// while using querySelectorAll <= need using CSS seletor rule
const inputList = document.querySelectorAll('#scoreForm input') 
// 報告顯示區塊
const reportDiv = document.getElementById('result');

function scoreToStr(scr){
    if (scr >= 90){ return 'A+';}
    else if (scr >= 80){return 'A';}
    else if (scr >= 70){return 'B';}
    else if (scr >= 60){return 'C';}
    else if (scr < 60 && scr>= 0){return 'F';}
    else{
        return 'invalid input';
    }
}

function handleSubmit (e) {
    // 防止表單重整畫面
    e.preventDefault();
    // TODO: 取得各科目成績
    const zh = parseFloat(zhInput.value);
    const en = parseFloat(enInput.value);
    const math = parseFloat(mathInput.value);
    // TODO: 計算總分
    const total = zh + en + math;
    console.log('total score = '+ total);
    // TODO: 計算平均分數
    let avg = total / 3;
    console.log('average score = '+ avg);   // if I convert it to string, does this improve efficiency a lot?
                                           // How come this support mandarin in the back of comment //
    avg = Math.round(avg*100)/100;
    console.log('average number round up to second digit = '+ Math.round(avg*100)/100);
    // TODO: 計算等級
    // 平均分數 >= 90 為A+
    // 平均分數 >= 80 為A
    // 平均分數 >= 70 為B
    // 平均分數 >= 60 為C
    // 平均分數 < 60 為F。
    const mathRank = scoreToStr(math);
    const zhRank = scoreToStr(zh);
    const enRank = scoreToStr(en);
    const avgRank = scoreToStr(avg);
    let alertType;
    if(avgRank=='A+'){alertType = 'primary';}
    else if(avgRank=='A'){alertType = 'secondary';}
    else if(avgRank=='B'){alertType = 'success';}
    else if(avgRank=='C'){alertType = 'danger';}
    else if(avgRank=='F'){alertType = 'warning';}
    // TODO: 顯示報告
    const report = `
    <div class = "alert alert-${alertType}">
        Mandarin: ${zh}, Rank = ${zhRank} <br> 
        English: ${en}, Rank = ${enRank}<br>
        Math:${math},  Rank = ${mathRank} <br>
        total Score:${total}, <br>
        Average Score:${avg}, <br>
        Average Rank:${avgRank} 
    </div>                
        `;
    // set the inner HTML instead of inner Text
    // drawback of inner HTML is that requires <br> to break the line
    reportDiv.innerHTML = report+reportDiv.innerHTML;
    inputList.forEach( function(eachElement){ 
        console.log(eachElement.value);
        eachElement.value = ''
     });
}

scoreForm.addEventListener('submit', handleSubmit,);