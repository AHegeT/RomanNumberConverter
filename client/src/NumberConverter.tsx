import React from 'react';
import axios from 'axios';
import './App.css';

interface Props { }

interface State {
  format: Format;
  value: string;
  result: string;
}

enum Format {
  decimal = "decimal",
  binary = "binary"
}

export class NumberConverter extends React.Component<Props, State> {
  constructor(props: any) {
    super(props);
    this.state = {
      format: Format.decimal,
      value: "",
      result: ""
    }
  }

  private convertValue() {
    const { format, value } = this.state;
    axios.get(`http://localhost:8080/convert/${format}?value=${value}`).then(response => {
      if (response.data) {
        this.setState({result: response.data})
      }
      console.log(response);
    });
  }

  render() {
    return (
    <div className="App">
      <div className="number-converter">
        <div className="tab-container">
          <button
              className="tab"
              onClick={() => this.setState({format: Format.decimal})}
          >
            Decimal
          </button>
          <button
              className="tab"
              onClick={() => this.setState({format: Format.binary})}
          >
            Binary
          </button>
        </div>
        <div className="content">
          <label>Number: </label>
          <input
              type="text"
              name="numberValue"
              value={this.state.value}
              onChange={e => this.setState({
                value: e.currentTarget.value
              })}
          />
          <label>Result: </label>
          <input type="text" disabled name="resultValue" value={this.state.result}/>
        </div>
        <button className="convert" onClick={() => this.convertValue()}>Convert</button>
      </div>
    </div>
  )}
}
