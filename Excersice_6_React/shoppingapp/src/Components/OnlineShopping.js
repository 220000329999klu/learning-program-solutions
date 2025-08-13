import React from "react";
import Cart from "./cart";

class OnlineShopping extends React.Component {
  render() {
    const items = [
      { itemname: "Laptop", price: 60000 },
      { itemname: "Smartphone", price: 25000 },
      { itemname: "Headphones", price: 1500 },
      { itemname: "Keyboard", price: 1200 },
      { itemname: "Mouse", price: 700 }
    ];

    return (
      <div>
        <h2>Welcome to Online Shopping Portal</h2>
        {items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
