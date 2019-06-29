import React from 'react';
import axios from 'axios';
import './App.css';

interface Props { }

interface State {
  format: string;
  value: number;
}

export class NumberConverter extends React.Component<Props, State> {
  constructor(props: any) {
    super(props);
    this.state = {
      format: "d",
      value: 0
    }
  }

  private convertValue() {
    const { format, value } = this.state;
    axios.get(`http://localhost:8080/convert/${format}?vaule=${value}`).then(respone => {
      console.log(respone);
    });
  }

  render() {
    return (
    <div className="App">
      <div className="number-converter">
        <div className="tab-container">
          <button className="tab">Decimal</button>
          <button className="tab">Binary</button>
        </div>
        <div className="content">s
          <label>Number: </label>
          <input type="number" name="numberValue" value={this.state.value}/>
          <label>Result: </label>
          <input type="number" disabled name="resultValue"/>
        </div>
        <button className="convert" onClick={() => this.convertValue()}>Convert</button>
      </div>
    </div>
  )}
}
