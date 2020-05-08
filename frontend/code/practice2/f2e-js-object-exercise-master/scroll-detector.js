// 所有導覽列中的連結nav-link                      
const navLinkList = document.querySelectorAll('.navbar a.nav-link'),
    // 導覽列
    navbar = document.getElementById('navbar'),
    // 滑動資訊報告元件
    scrollReport = document.getElementById('scrollReport');

// TODO: 建立章節資訊查詢表
/* 
 * {
 *    section1: {section: sectionDOM, navLink: navLinkDOM},
 *    section2: {...}, ...
 * }
 */

const sectionList = {};

// get all guide button
navLinkList.forEach(function(link){
    //console.dir(link);
    // get tag value of data-target
    const sectionID = link.dataset.target;
    const section = document.getElementById(sectionID);
    sectionList[sectionID] = {
        link : link,
        section : section
    }
    
});

console.log(`[section map]`,sectionList)

// 綁定視窗(window)的滾動事件(scroll)
// https://developer.mozilla.org/en-US/docs/Web/API/Document/scroll_event
// window is a special object including all info in a web
window.addEventListener('scroll', function () {
    // TODO: 取得視窗的直向滑動偵測點(scrollY)
    // https://developer.mozilla.org/en-US/docs/Web/API/Window/scrollY
    const scroll = window.scrollY + navbar.offsetHeight;
    //console.log(`let's start to scroll`,scroll)
    scrollReport.innerText = `current position = `+ scroll+ ` px`;
    // TODO: 取得每個章節的所在位置頂邊座標(offsetTop)、底邊座標(offsetTop + offsetHeight)
    // https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/offsetTop
    // https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/offsetHeight
    for (let sectionID in sectionList){
        //console.log(`section ID = `, sectionID)
        //console.log(sectionList[sectionID])
        // link
        const link = sectionList[sectionID].link;
        // check if in this section
        const section = sectionList[sectionID].section
        //console.log(`[link] `, link)
        //console.log(`[section] `,section)
        // if this section fall into area of current top and bottom
        const sectionTop =  section.offsetTop;
        const sectionBottom = section.offsetTop+section.offsetHeight;
        if (scroll >= sectionTop && scroll< sectionBottom){
            console.log(`current I'm in `,sectionID)
            link.classList.add('text-warning');
            section.classList.add('active')
        }
        else{
            link.classList.remove('text-warning');
            section.classList.remove('active')
        }
    }
})

// Q : scroll unit? and where is the orientation
//     js file import order ? are they all independent?
//     