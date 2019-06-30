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
    const requestURI = `http://localhost:8080/convert/${format}?value=${value}`;
    console.log(`Making request to: ${requestURI}`);

    axios.get(requestURI).then(response => {
      if (response.data) {
        this.setState({result: response.data})
      }
      console.log(`Obtained response: ${JSON.stringify(response)}`);
    });
  }

  render() {
    return (
    <div className="App">
      <div className="number-converter">
        <div className="tab-container row">
          <label className="left">Convert to roman numeral from</label>
          <div className="right">
            <button
                className={`tab ${this.state.format === Format.decimal ? 'active' : ''}`}
                onClick={() => this.setState({format: Format.decimal})}
            >
              Decimal
            </button>
            <button
                className={`tab ${this.state.format === Format.binary ? 'active' : ''}`}
                onClick={() => this.setState({format: Format.binary})}
            >
              Binary
            </button>
          </div>
        </div>
        <div className="row">
          <label className="left">Number</label>
          <div className="right">
            <input
              type="text"
              name="numberValue"
              value={this.state.value}
              onChange={e => this.setState({
                value: e.currentTarget.value
              })}
            />
          </div>
        </div>
        <div className="row">
          <label className="left">Result</label>
          <div className="right">
            <input type="text" disabled name="resultValue" value={this.state.result}/>
          </div>
        </div>
        <div className="row">
          <div className="left"></div>
          <button className="convert right" onClick={() => this.convertValue()}>Convert</button>
        </div>
      </div>
    </div>
  )}
}
