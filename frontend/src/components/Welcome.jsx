import UserService from "../services/UserService";
import RenderOnAnonymous from "./RenderOnAnonymous";
import RenderOnAuthenticated from "./RenderOnAuthenticated";
const Welcome = () => {

    return (
        <div>
            <RenderOnAnonymous>
                <h1>Hello Anonymous!</h1>
                <button onClick={() => UserService.doLogin()}>Login</button>
            </RenderOnAnonymous>
            <RenderOnAuthenticated>
                <h1>Hello User!</h1>
                <button onClick={() => UserService.doLogout()}>logout</button>
            </RenderOnAuthenticated>
        </div>
    );
}

export default Welcome