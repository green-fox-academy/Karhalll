let accoutBalance = Number(prompt('Account Balance', 300));
let itemsOwned = 0;

const ITEM_PRICE = Number(prompt('Account Balance', 20));
const TAX_RATE = Number(prompt('Account Balance', 0.15));

function calculateTax(price) {
  return price * TAX_RATE;
}

function getPriceWithTax(price, tax) {
  return price + tax;
}


const priceWithTax = getPriceWithTax(ITEM_PRICE, calculateTax(ITEM_PRICE, TAX_RATE));
while (accoutBalance >= priceWithTax) {
  accoutBalance -= priceWithTax;
  itemsOwned++;
}
console.log("Final state: " + accoutBalance);
console.log("Items: " + itemsOwned);