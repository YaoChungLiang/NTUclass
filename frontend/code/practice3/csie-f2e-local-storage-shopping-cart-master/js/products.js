const products = [
    {
        id: '1',
        title: '產品一',
        price: 10,
        img: 'https://picsum.photos/id/999/1200/600',
        tags: ['生活用品', '工具'],
        isAvailable: true
    },
    {
        id: '2',
        title: '產品二',
        price: 60,
        img: 'https://picsum.photos/id/1070/1200/600',
        tags: ['藥妝'],
        isAvailable: true
    },
    {
        id: '3',
        title: '產品三',
        price: 180,
        img: 'https://picsum.photos/id/1071/1200/600',
        tags: ['食品'],
        isAvailable: true
    },
    {
        id: '4',
        title: '產品四',
        price: 220,
        img: 'https://picsum.photos/id/1072/1200/600',
        tags: ['生活用品'],
        isAvailable: true
    },
    {
        id: '5',
        title: '產品五',
        price: 360,
        img: 'https://picsum.photos/id/1073/1200/600',
        tags: ['工具'],
        isAvailable: true
    },
    {
        id: '6',
        title: '產品六',
        price: 360,
        img: 'https://picsum.photos/id/1074/1200/600',
        tags: ['食品'],
        isAvailable: true
    },
    {
        id: '7',
        title: '產品七',
        price: 400,
        img: 'https://picsum.photos/id/1075/1200/600',
        tags: ['生活用品', '工具'],
        isAvailable: true
    },
    {
        id: '8',
        title: '產品八',
        price: 450,
        img: 'https://picsum.photos/id/1076/1200/600',
        tags: ['生活用品', '工具'],
        isAvailable: true
    },
    {
        id: '9',
        title: '產品九',
        price: 520,
        img: 'https://picsum.photos/id/1077/1200/600',
        tags: ['藥妝'],
        isAvailable: true
    }
];

// 設計渲染商品的函數
function renderProducts() {
    console.log('[start to render products]')
    products.forEach(function(product){
        //const a = document.getElementById('cartTablebody');
        const card = createProductCardElement(product);
        console.log('[HTML card]', card);
        // document.getElementById('productRow').innerHTML+= card;
        // try to use jquery
        // $() === jquery()
        // $('CSS selector');
        $('#productRow').append(card);
    })
}

// 設計建立單一商品卡片HTML標籤的函數
function createProductCardElement(product) {
    // 產生一個Bootstrap Card的元件
    // get all tags of product
    let badges = '';
    product.tags.forEach(function(tag){
        const badge = `<span class="badge badge-warning">${tag}</span>`;
        badges += badge;
    });
    // https://getbootstrap.com/docs/4.4/components/card/
    const cardElement = `
        <div class="col-md-4">
            <div class="card mb-3">
                <img src="${product.img}" class="card-img-top">
                <form data-product-id="${product.id}" class="card-body">
                    <h5 class="card-title">商品標題:${product.title}</h5>
                    ${badges}
                    <p class="card-text">商品價格: ${product.price}</p>
                    <div class="form-group">
                        <label>購買數量</label>
                        <input id="amountInput${product.id}" class="form-control" type="number" min="1" max="20">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">加入購物車</button>
                    </div>
                </form>
            </div>
        </div>
    `;
    return cardElement;
}

// 渲染商品
renderProducts();