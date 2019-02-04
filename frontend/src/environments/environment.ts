export const environment = {
  production: false
};
const PROTOCOL = 'http';
const HOST = 'localhost';
const PORT = '8080';
export const GET_NEWS = PROTOCOL + '://' + HOST + ':' + PORT + '/facade/news/REPLACE_COUNTRY/REPLACE_CATEGORY';
