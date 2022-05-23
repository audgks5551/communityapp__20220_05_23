import Keycloak from "keycloak-js";

/**
 * keycloak 생성자 생성 (여러가지 함수들 소환)
 */
const _kc = new Keycloak("/keycloak.json");

const initKeycloak = (onAuthenticatedCallback) => {
    console.log(_kc);
    console.log("keycloak-start")
    _kc.init({
        onLoad: 'check-sso'
    })
        .then((authenticated) => {
            if (!authenticated) {
                console.log("user is not authenticated..!");
            }
            onAuthenticatedCallback();
        })
        .catch((error) => {
            console.log("에러")
            console.log(error)
        });
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