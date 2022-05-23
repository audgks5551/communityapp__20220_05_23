import Keycloak from "keycloak-js";

/**
 * keycloak 생성자 생성 (여러가지 함수들 소환)
 */
const _kc = new Keycloak("/keycloak.json");

const initKeycloak = (onAuthenticatedCallback) => {
    console.log(_kc);
    console.log("keycloak-start")
    _kc.init({
        onLoad: 'login-required',
        silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html',
        pkceMethod: 'S256',
    })
        .then((authenticated) => {
            onAuthenticatedCallback();
        })
        .catch(console.error);
    console.log("keycloak-end")
};

const doLogin = _kc.login;

const doLogout = _kc.logout;

const getToken = () => _kc.token;

const isLoggedIn = () => !!_kc.token;

const updateToken = (successCallback) =>
    _kc.updateToken(5)
        .then(successCallback)
        .catch(doLogin);

const UserService = {
    initKeycloak,
    isLoggedIn,
    getToken,
    doLogin,
    doLogout,
    updateToken
};

export default UserService;