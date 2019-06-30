import {shallow} from 'enzyme';
import React from 'react';
import ReactDOM from 'react-dom';
import { NumberConverter, Format } from './NumberConverter';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<NumberConverter />, div);
  ReactDOM.unmountComponentAtNode(div);
});

it('updates conversion format on click', () => {
  const wrapper = shallow(<NumberConverter />);
  const firstButton = wrapper.find('button').at(0);
  const secondButton = wrapper.find('button').at(1);

  firstButton.simulate('click');
  expect(wrapper.state('format')).toBe(Format.decimal);

  secondButton.simulate('click');
  expect(wrapper.state('format')).toBe(Format.binary);
});
