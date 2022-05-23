import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import UserService from "./service/UserService";

const root = ReactDOM.createRoot(document.getElementById('root'));
const render = () => root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

UserService.initKeycloak(render);



