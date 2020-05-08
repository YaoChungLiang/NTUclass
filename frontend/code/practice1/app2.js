// select form
const form = document.getElementById('introForm')
// input windws
const nameInput = document.getElementById('name')
const cityInput = document.getElementById('city')
const colorInput = document.getElementById('color')
// report
const report = document.getElementById('report')
// caught event before submit
form.addEventListener('submit',function(e){
    e.preventDefault(); //prevent default actions -> is there some problem?
    console.log('form submitted');
    // get input form data
    const name = nameInput.value;
    const city = cityInput.value;
    const intro = `I"m ${name} from ${city}`;
    report.innerText = intro;
    report.style.backgroundColor = colorInput.value
    
});
//after submitting, html will let your page refresh

