/* global core */


/**
 * header
 * @type {Array}
 */
const headerList = [];
for (const brHeader of window.document.querySelectorAll('.br-header')) {
    try {
        headerList.push(new core.BRHeader('br-header', brHeader));
    } catch (e) {

    }

}

const menuList = [];
for (const brMenu of window.document.querySelectorAll('.br-menu')) {
    menuList.push(new core.BRMenu('br-menu', brMenu));
    console.log(menuList)
}


const inputList = [];
for (const brInput of window.document.querySelectorAll('.br-input')) {
    inputList.push(new core.BRInput('br-input', brInput));
}



const tableList = [];
for (const [index, brTable] of window.document
        .querySelectorAll('.br-table')
        .entries()) {
    tableList.push(new core.BRTable('br-table', brTable, index));
}

const itemList = [];
for (const brItem of window.document.querySelectorAll('.br-item')) {
    itemList.push(new core.BRItem('br-item', brItem));
}



const selectList = [];
const notFoundElement = `
 <div class="br-item not-found">
  <div class="container">
   <div class="row">
    <div class="col">
     <p><strong>Ops!</strong> Não encontramos o que você está procurando!</p>
    </div>
   </div>
  </div>
 </div>
`;


for (const brSelect of window.document.querySelectorAll('.br-select')) {
    const brselect = new core.BRSelect('br-select', brSelect, notFoundElement);
    //Exemplo de uso de listener do select
    brSelect.addEventListener('onChange', function (e) { });
    selectList.push(brselect);
}


for (const brScrim of window.document.querySelectorAll('.br-scrim')) {
    const scrim = new BRScrim('br-scrim', brScrim);
    for (const button of window.document.querySelectorAll(
            '.br-scrim + button'
            )) {
        button.addEventListener('click', () => {
            scrim.showScrim();
        });
    }
}



function showModal(modalId)
{
    var brScrim = document.getElementById(modalId);
    const scrim = new BRScrim('br-scrim', brScrim);
    scrim.showScrim();
}






