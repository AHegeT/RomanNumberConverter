import axios from 'axios';

const ADDRESS = "http://localhost:8080/";

export function makeConversionRequest(format: string, value: string) {
  const requestURI = `${ADDRESS}convert/${format}?value=${value}`;
  return axios.get(requestURI);
}
