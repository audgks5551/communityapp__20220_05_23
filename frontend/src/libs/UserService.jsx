import Keycloak from "keycloak-js";

/**
 * keycloak 생성자 생성 (여러가지 함수들 소환)
 */
const _kc = new Keycloak("/keycloak.json");

const initKeycloak = (onAuthenticatedCallback) => {
    _kc.init({
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri: window.location.origin + '/index.html',
        pkceMethod: 'S256',
        checkLoginIframe: false
    })
        .then((authenticated) => {
            if (!authenticated) {
                console.log("user is not authenticated..!");
            }
            onAuthenticatedCallback();
        })
        .catch(console.error);
    console.log(_kc)
};

const doLogin = _kc.login;

const doLogout = _kc.logout;

const doSignup = _kc.register;

const getToken = () => _kc.token;

const isLoggedIn = () => !!_kc.token;

const updateToken = (successCallback) =>
    _kc.updateToken(5)
        .then(successCallback)
        .catch(doLogin);

const getNickName = () => _kc.tokenParsed.family_name + _kc.tokenParsed.given_name;

const UserService = {
    initKeycloak,
    isLoggedIn,
    getToken,
    doLogin,
    doLogout,
    updateToken,
    getNickName,
    doSignup
};

export default UserService;