import axios from "axios";
import UserService from "./UserService";

const HttpMethods = {
  GET: 'GET',
  POST: 'POST',
  DELETE: 'DELETE',
};

const _axios = axios.create();

const configure = () => {
  console.log("configure start");
  _axios.interceptors.request.use((config) => {
    console.log("config");
    if (UserService.isLoggedIn()) {
      console.log("로그인됨");
      const cb = () => {
        config.headers.Authorization = `Bearer ${UserService.getToken()}`;
        return Promise.resolve(config);
      };
      return UserService.updateToken(cb);
    }
  });
  console.log("configure end");
};

const getAxiosClient = () => _axios;

const HttpService = {
  HttpMethods,
  configure,
  getAxiosClient,
};

export default HttpService;