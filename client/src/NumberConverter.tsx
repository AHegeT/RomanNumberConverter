import React from 'react';
import './App.css';

interface Props { }

interface State {
  value: number;
}

export class NumberConverter extends React.Component<Props, State> {
  constructor(props: any) {
    super(props);
    this.state = {
      value: 0
    }
  }

  render() {
    return (
    <div className="App">
      <div className="number-converter">
        <div className="tab-container">
          <button className="tab">Decimal</button>
          <button className="tab">Binary</button>
        </div>
        <div className="content">
          <label>Number: </label>
          <input type="number" name="numberValue" value={this.state.value}/>
          <label>Result: </label>
          <input type="number" disabled name="resultValue"/>
        </div>
        <button className="convert">Convert</button>
      </div>
    </div>
  )}
}
