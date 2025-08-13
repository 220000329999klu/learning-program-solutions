import React from "react";

class Cart extends React.Component {
  render() {
    return (
      <div style={{ border: "1px solid black", margin: "10px", padding: "10px" }}>
        <h3>Item: {this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

// Default Props
Cart.defaultProps = {
  itemname: "Default Item",
  price: 0,
};

export default Cart;
