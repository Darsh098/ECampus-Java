import React from "react";

class ProductList extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <h1
          style={{
            fontFamily: "Poor Richard",
            backgroundColor: "lightblue",
            textAlign: "center",
            margin: 0 + "px",
            borderStyle: "solid",
            borderColor: "blue",
            borderWidth: 3 + "px",
            borderLeftWidth: 0 + "px",
            borderRightWidth: 0 + "px",
          }}
        >
          Products List
        </h1>

        <h3>
          <ul
            style={{
              color: "blue",
              backgroundColor: "beige",
              borderColor: "darkgray",
              borderWidth: 1 + "px",
              borderStyle: "solid",
            }}
          >
            {this.props.items.map((element) => (
              <li>{element}</li>
            ))}
          </ul>
        </h3>
      </div>
    );
  }
}

export default ProductList;
