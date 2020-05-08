$(function(){  // cannot be access
    const productList = JSON.parse(JSON.stringify(products))
    // for generating storage cart 
    function Cart() {
        // localStorage key
        this.key = 'example-cart';
        // 購物車的資料
        this.data = [];
        // 初始化購物車
        this.initCart = function () {
            if (localStorage.getItem(this.key)){
                // data in user's localStorage
                this.data = JSON.parse(localStorage.getItem(this.key)); 
            }
            this.render();
        }
        // 傳入商品id與數量並新增商品至購物車
        this.addItem = function (pid, amount) {
            console.log('[pid]', pid);
            const product = productsList.find(p => p.id === pid) // change thereference of it
            console.log('[product] ', product)
            const item = {
                title : product.title,
                price : product.price,
                amount : amount,
                createdAt : new Date().getTime()
            };
            console.log('[item in cart]',item)
            this.data.push(item);
            // need to render data
            this.render();
        }
        // 至購物車刪除於購物車內指定索引商品
        this.deleteItem = function (i) {
            this.data.splice(i,1)
            this.render();
        }
        // 清空購物車
        this.emptyCart = function () {
            this.data = [];
            this.render();
        }
        // 更新資料到localStorage
        this.updateDataToStorage = function () {
            const data = JSON.stringify(this.data);
            localStorage.setItem(this.key, data);
        }
        // 渲染購物車
        this.render = function () {
            this.updateDataToStorage();
            const $tbody = $('#cartTableBody'); // jquery selector
            const $tfoot = $('#cartTableFoot');
            const $link = $('#cartNavLink');
            //document.getElementById('cartTableBody').innerHTML = '';
            // if data already in this.data
            let badge = ``;
            if(this.data.length>0){
                badge = `<span class = "badge badge-danger">
                ${this.data.length}
                </span>`;
            }
            $link.html(`${badge} cart`)
            $tbody.empty();
            // visualize this.data
            let total = 0;
            this.data.forEach((item,idx) =>{
                const tr = `
                <tr>
                        <td>
                            <button data-item-index ="${idx}" class="remove-btn btn btn-danger">
                                &times;
                            </button>
                            ${item.title}
                        </td>
                        <td class="text-right">${item.price}</td>
                        <td class="text-right">${item.amount}</td>
                        <td class="text-right">${item.amount*item.price}</td>
                </tr>`;
                total += item.amount*item.price;
                $tbody.prepend(tr);
            });
            console.log('[total]', total);
            $tfoot.html(`<tr>
                    <th> total amount <th>
                    <td class = "text-right" colspan = "3"> ${total}</td>
                        </tr>`);
        }
    }

    const cart = new Cart();
    // initialize cart
    cart.initCart();
    // 
    $('#productRow').delegate('form','submit',function(e){
        e.preventDefault();
        console.log(`prepare to add items into cart`);
        console.log('[submitted form]',this);
        // retrieve product ID
        // JS
        //const productID = this.getAttribute('data-product-id');
        //console.log('[product ID]', productID);
        // Jquery
        const productID = $(this).attr('data-product-id');
        console.log('[product ID]', productID);
        const amount = parseInt($(`#amountInput${productID}`).val());
        console.log(`[product amount]`, amount)
        // 
        cart.addItem(productID, amount)
    });

    $('#clearCartBtn').click(function(){
        console.log('[clear cart]');
        cart.emptyCart();

    })

    // use delegate to dynamically bind elements
    $('#cartTableBody').delegate('.remove-btn','click',function(){
        console.log('time to remove an item');
        // get data index
        let idx = $(this).attr('data-item-index')
        idx = parseInt(idx);
        // pass idx
        console.log('the index of item be removed', idx);
        cart.deleteItem(idx)
    })

    // cannot bind
    // $('.remove-btn').click(function(){
    //     console.log('time to remove an item')
    // })


    //note :
    //     MDN array find
})